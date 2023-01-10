package p218io.reactivex.subjects;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p218io.reactivex.Observer;
import p218io.reactivex.annotations.CheckReturnValue;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.internal.disposables.EmptyDisposable;
import p218io.reactivex.internal.functions.ObjectHelper;
import p218io.reactivex.internal.fuseable.SimpleQueue;
import p218io.reactivex.internal.observers.BasicIntQueueDisposable;
import p218io.reactivex.internal.queue.SpscLinkedArrayQueue;
import p218io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.subjects.UnicastSubject */
public final class UnicastSubject<T> extends Subject<T> {

    /* renamed from: a */
    final SpscLinkedArrayQueue<T> f62227a;

    /* renamed from: b */
    final AtomicReference<Observer<? super T>> f62228b;

    /* renamed from: c */
    final AtomicReference<Runnable> f62229c;

    /* renamed from: d */
    final boolean f62230d;

    /* renamed from: e */
    volatile boolean f62231e;

    /* renamed from: f */
    volatile boolean f62232f;

    /* renamed from: g */
    Throwable f62233g;

    /* renamed from: h */
    final AtomicBoolean f62234h;

    /* renamed from: i */
    final BasicIntQueueDisposable<T> f62235i;

    /* renamed from: j */
    boolean f62236j;

    @CheckReturnValue
    public static <T> UnicastSubject<T> create() {
        return new UnicastSubject<>(bufferSize(), true);
    }

    @CheckReturnValue
    public static <T> UnicastSubject<T> create(int i) {
        return new UnicastSubject<>(i, true);
    }

    @CheckReturnValue
    public static <T> UnicastSubject<T> create(int i, Runnable runnable) {
        return new UnicastSubject<>(i, runnable, true);
    }

    @CheckReturnValue
    public static <T> UnicastSubject<T> create(int i, Runnable runnable, boolean z) {
        return new UnicastSubject<>(i, runnable, z);
    }

    @CheckReturnValue
    public static <T> UnicastSubject<T> create(boolean z) {
        return new UnicastSubject<>(bufferSize(), z);
    }

    UnicastSubject(int i, boolean z) {
        this.f62227a = new SpscLinkedArrayQueue<>(ObjectHelper.verifyPositive(i, "capacityHint"));
        this.f62229c = new AtomicReference<>();
        this.f62230d = z;
        this.f62228b = new AtomicReference<>();
        this.f62234h = new AtomicBoolean();
        this.f62235i = new UnicastQueueDisposable();
    }

    UnicastSubject(int i, Runnable runnable) {
        this(i, runnable, true);
    }

    UnicastSubject(int i, Runnable runnable, boolean z) {
        this.f62227a = new SpscLinkedArrayQueue<>(ObjectHelper.verifyPositive(i, "capacityHint"));
        this.f62229c = new AtomicReference<>(ObjectHelper.requireNonNull(runnable, "onTerminate"));
        this.f62230d = z;
        this.f62228b = new AtomicReference<>();
        this.f62234h = new AtomicBoolean();
        this.f62235i = new UnicastQueueDisposable();
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super T> observer) {
        if (this.f62234h.get() || !this.f62234h.compareAndSet(false, true)) {
            EmptyDisposable.error((Throwable) new IllegalStateException("Only a single observer allowed."), (Observer<?>) observer);
            return;
        }
        observer.onSubscribe(this.f62235i);
        this.f62228b.lazySet(observer);
        if (this.f62231e) {
            this.f62228b.lazySet((Object) null);
        } else {
            mo185393b();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo185390a() {
        Runnable runnable = this.f62229c.get();
        if (runnable != null && this.f62229c.compareAndSet(runnable, (Object) null)) {
            runnable.run();
        }
    }

    public void onSubscribe(Disposable disposable) {
        if (this.f62232f || this.f62231e) {
            disposable.dispose();
        }
    }

    public void onNext(T t) {
        ObjectHelper.requireNonNull(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.f62232f && !this.f62231e) {
            this.f62227a.offer(t);
            mo185393b();
        }
    }

    public void onError(Throwable th) {
        ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f62232f || this.f62231e) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.f62233g = th;
        this.f62232f = true;
        mo185390a();
        mo185393b();
    }

    public void onComplete() {
        if (!this.f62232f && !this.f62231e) {
            this.f62232f = true;
            mo185390a();
            mo185393b();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo185391a(Observer<? super T> observer) {
        SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.f62227a;
        boolean z = !this.f62230d;
        boolean z2 = true;
        int i = 1;
        while (!this.f62231e) {
            boolean z3 = this.f62232f;
            T poll = this.f62227a.poll();
            boolean z4 = poll == null;
            if (z3) {
                if (z && z2) {
                    if (!mo185392a(spscLinkedArrayQueue, observer)) {
                        z2 = false;
                    } else {
                        return;
                    }
                }
                if (z4) {
                    mo185395c(observer);
                    return;
                }
            }
            if (z4) {
                i = this.f62235i.addAndGet(-i);
                if (i == 0) {
                    return;
                }
            } else {
                observer.onNext(poll);
            }
        }
        this.f62228b.lazySet((Object) null);
        spscLinkedArrayQueue.clear();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo185394b(Observer<? super T> observer) {
        SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.f62227a;
        int i = 1;
        boolean z = !this.f62230d;
        while (!this.f62231e) {
            boolean z2 = this.f62232f;
            if (!z || !z2 || !mo185392a(spscLinkedArrayQueue, observer)) {
                observer.onNext(null);
                if (z2) {
                    mo185395c(observer);
                    return;
                }
                i = this.f62235i.addAndGet(-i);
                if (i == 0) {
                    return;
                }
            } else {
                return;
            }
        }
        this.f62228b.lazySet((Object) null);
        spscLinkedArrayQueue.clear();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo185395c(Observer<? super T> observer) {
        this.f62228b.lazySet((Object) null);
        Throwable th = this.f62233g;
        if (th != null) {
            observer.onError(th);
        } else {
            observer.onComplete();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo185392a(SimpleQueue<T> simpleQueue, Observer<? super T> observer) {
        Throwable th = this.f62233g;
        if (th == null) {
            return false;
        }
        this.f62228b.lazySet((Object) null);
        simpleQueue.clear();
        observer.onError(th);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo185393b() {
        if (this.f62235i.getAndIncrement() == 0) {
            Observer observer = this.f62228b.get();
            int i = 1;
            while (observer == null) {
                i = this.f62235i.addAndGet(-i);
                if (i != 0) {
                    observer = this.f62228b.get();
                } else {
                    return;
                }
            }
            if (this.f62236j) {
                mo185394b(observer);
            } else {
                mo185391a(observer);
            }
        }
    }

    public boolean hasObservers() {
        return this.f62228b.get() != null;
    }

    public Throwable getThrowable() {
        if (this.f62232f) {
            return this.f62233g;
        }
        return null;
    }

    public boolean hasThrowable() {
        return this.f62232f && this.f62233g != null;
    }

    public boolean hasComplete() {
        return this.f62232f && this.f62233g == null;
    }

    /* renamed from: io.reactivex.subjects.UnicastSubject$UnicastQueueDisposable */
    final class UnicastQueueDisposable extends BasicIntQueueDisposable<T> {
        private static final long serialVersionUID = 7926949470189395511L;

        UnicastQueueDisposable() {
        }

        public int requestFusion(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            UnicastSubject.this.f62236j = true;
            return 2;
        }

        public T poll() throws Exception {
            return UnicastSubject.this.f62227a.poll();
        }

        public boolean isEmpty() {
            return UnicastSubject.this.f62227a.isEmpty();
        }

        public void clear() {
            UnicastSubject.this.f62227a.clear();
        }

        public void dispose() {
            if (!UnicastSubject.this.f62231e) {
                UnicastSubject.this.f62231e = true;
                UnicastSubject.this.mo185390a();
                UnicastSubject.this.f62228b.lazySet((Object) null);
                if (UnicastSubject.this.f62235i.getAndIncrement() == 0) {
                    UnicastSubject.this.f62228b.lazySet((Object) null);
                    UnicastSubject.this.f62227a.clear();
                }
            }
        }

        public boolean isDisposed() {
            return UnicastSubject.this.f62231e;
        }
    }
}
