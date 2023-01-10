package p218io.reactivex.processors;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p218io.reactivex.annotations.CheckReturnValue;
import p218io.reactivex.internal.functions.ObjectHelper;
import p218io.reactivex.internal.queue.SpscLinkedArrayQueue;
import p218io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import p218io.reactivex.internal.subscriptions.EmptySubscription;
import p218io.reactivex.internal.subscriptions.SubscriptionHelper;
import p218io.reactivex.internal.util.BackpressureHelper;
import p218io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.processors.UnicastProcessor */
public final class UnicastProcessor<T> extends FlowableProcessor<T> {

    /* renamed from: a */
    final SpscLinkedArrayQueue<T> f62159a;

    /* renamed from: b */
    final AtomicReference<Runnable> f62160b;

    /* renamed from: c */
    final boolean f62161c;

    /* renamed from: d */
    volatile boolean f62162d;

    /* renamed from: e */
    Throwable f62163e;

    /* renamed from: f */
    final AtomicReference<Subscriber<? super T>> f62164f;

    /* renamed from: g */
    volatile boolean f62165g;

    /* renamed from: h */
    final AtomicBoolean f62166h;

    /* renamed from: i */
    final BasicIntQueueSubscription<T> f62167i;

    /* renamed from: j */
    final AtomicLong f62168j;

    /* renamed from: k */
    boolean f62169k;

    @CheckReturnValue
    public static <T> UnicastProcessor<T> create() {
        return new UnicastProcessor<>(bufferSize());
    }

    @CheckReturnValue
    public static <T> UnicastProcessor<T> create(int i) {
        return new UnicastProcessor<>(i);
    }

    @CheckReturnValue
    public static <T> UnicastProcessor<T> create(boolean z) {
        return new UnicastProcessor<>(bufferSize(), (Runnable) null, z);
    }

    @CheckReturnValue
    public static <T> UnicastProcessor<T> create(int i, Runnable runnable) {
        ObjectHelper.requireNonNull(runnable, "onTerminate");
        return new UnicastProcessor<>(i, runnable);
    }

    @CheckReturnValue
    public static <T> UnicastProcessor<T> create(int i, Runnable runnable, boolean z) {
        ObjectHelper.requireNonNull(runnable, "onTerminate");
        return new UnicastProcessor<>(i, runnable, z);
    }

    UnicastProcessor(int i) {
        this(i, (Runnable) null, true);
    }

    UnicastProcessor(int i, Runnable runnable) {
        this(i, runnable, true);
    }

    UnicastProcessor(int i, Runnable runnable, boolean z) {
        this.f62159a = new SpscLinkedArrayQueue<>(ObjectHelper.verifyPositive(i, "capacityHint"));
        this.f62160b = new AtomicReference<>(runnable);
        this.f62161c = z;
        this.f62164f = new AtomicReference<>();
        this.f62166h = new AtomicBoolean();
        this.f62167i = new UnicastQueueSubscription();
        this.f62168j = new AtomicLong();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo185288a() {
        Runnable andSet = this.f62160b.getAndSet((Object) null);
        if (andSet != null) {
            andSet.run();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo185289a(Subscriber<? super T> subscriber) {
        int i;
        long j;
        SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.f62159a;
        boolean z = !this.f62161c;
        int i2 = 1;
        while (true) {
            long j2 = this.f62168j.get();
            long j3 = 0;
            while (true) {
                i = (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
                if (i == 0) {
                    j = j3;
                    break;
                }
                boolean z2 = this.f62162d;
                T poll = spscLinkedArrayQueue.poll();
                boolean z3 = poll == null;
                T t = poll;
                j = j3;
                if (!mo185290a(z, z2, z3, subscriber, spscLinkedArrayQueue)) {
                    if (z3) {
                        break;
                    }
                    subscriber.onNext(t);
                    j3 = 1 + j;
                } else {
                    return;
                }
            }
            Subscriber<? super T> subscriber2 = subscriber;
            if (i == 0) {
                if (mo185290a(z, this.f62162d, spscLinkedArrayQueue.isEmpty(), subscriber, spscLinkedArrayQueue)) {
                    return;
                }
            }
            if (!(j == 0 || j2 == Long.MAX_VALUE)) {
                this.f62168j.addAndGet(-j);
            }
            i2 = this.f62167i.addAndGet(-i2);
            if (i2 == 0) {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo185292b(Subscriber<? super T> subscriber) {
        SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.f62159a;
        int i = 1;
        boolean z = !this.f62161c;
        while (!this.f62165g) {
            boolean z2 = this.f62162d;
            if (!z || !z2 || this.f62163e == null) {
                subscriber.onNext(null);
                if (z2) {
                    this.f62164f.lazySet((Object) null);
                    Throwable th = this.f62163e;
                    if (th != null) {
                        subscriber.onError(th);
                        return;
                    } else {
                        subscriber.onComplete();
                        return;
                    }
                } else {
                    i = this.f62167i.addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            } else {
                spscLinkedArrayQueue.clear();
                this.f62164f.lazySet((Object) null);
                subscriber.onError(this.f62163e);
                return;
            }
        }
        spscLinkedArrayQueue.clear();
        this.f62164f.lazySet((Object) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo185291b() {
        if (this.f62167i.getAndIncrement() == 0) {
            int i = 1;
            Subscriber subscriber = this.f62164f.get();
            while (subscriber == null) {
                i = this.f62167i.addAndGet(-i);
                if (i != 0) {
                    subscriber = this.f62164f.get();
                } else {
                    return;
                }
            }
            if (this.f62169k) {
                mo185292b(subscriber);
            } else {
                mo185289a(subscriber);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo185290a(boolean z, boolean z2, boolean z3, Subscriber<? super T> subscriber, SpscLinkedArrayQueue<T> spscLinkedArrayQueue) {
        if (this.f62165g) {
            spscLinkedArrayQueue.clear();
            this.f62164f.lazySet((Object) null);
            return true;
        } else if (!z2) {
            return false;
        } else {
            if (z && this.f62163e != null) {
                spscLinkedArrayQueue.clear();
                this.f62164f.lazySet((Object) null);
                subscriber.onError(this.f62163e);
                return true;
            } else if (!z3) {
                return false;
            } else {
                Throwable th = this.f62163e;
                this.f62164f.lazySet((Object) null);
                if (th != null) {
                    subscriber.onError(th);
                } else {
                    subscriber.onComplete();
                }
                return true;
            }
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (this.f62162d || this.f62165g) {
            subscription.cancel();
        } else {
            subscription.request(Long.MAX_VALUE);
        }
    }

    public void onNext(T t) {
        ObjectHelper.requireNonNull(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.f62162d && !this.f62165g) {
            this.f62159a.offer(t);
            mo185291b();
        }
    }

    public void onError(Throwable th) {
        ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f62162d || this.f62165g) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.f62163e = th;
        this.f62162d = true;
        mo185288a();
        mo185291b();
    }

    public void onComplete() {
        if (!this.f62162d && !this.f62165g) {
            this.f62162d = true;
            mo185288a();
            mo185291b();
        }
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super T> subscriber) {
        if (this.f62166h.get() || !this.f62166h.compareAndSet(false, true)) {
            EmptySubscription.error(new IllegalStateException("This processor allows only a single Subscriber"), subscriber);
            return;
        }
        subscriber.onSubscribe(this.f62167i);
        this.f62164f.set(subscriber);
        if (this.f62165g) {
            this.f62164f.lazySet((Object) null);
        } else {
            mo185291b();
        }
    }

    /* renamed from: io.reactivex.processors.UnicastProcessor$UnicastQueueSubscription */
    final class UnicastQueueSubscription extends BasicIntQueueSubscription<T> {
        private static final long serialVersionUID = -4896760517184205454L;

        UnicastQueueSubscription() {
        }

        public T poll() {
            return UnicastProcessor.this.f62159a.poll();
        }

        public boolean isEmpty() {
            return UnicastProcessor.this.f62159a.isEmpty();
        }

        public void clear() {
            UnicastProcessor.this.f62159a.clear();
        }

        public int requestFusion(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            UnicastProcessor.this.f62169k = true;
            return 2;
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(UnicastProcessor.this.f62168j, j);
                UnicastProcessor.this.mo185291b();
            }
        }

        public void cancel() {
            if (!UnicastProcessor.this.f62165g) {
                UnicastProcessor.this.f62165g = true;
                UnicastProcessor.this.mo185288a();
                if (!UnicastProcessor.this.f62169k && UnicastProcessor.this.f62167i.getAndIncrement() == 0) {
                    UnicastProcessor.this.f62159a.clear();
                    UnicastProcessor.this.f62164f.lazySet((Object) null);
                }
            }
        }
    }

    public boolean hasSubscribers() {
        return this.f62164f.get() != null;
    }

    public Throwable getThrowable() {
        if (this.f62162d) {
            return this.f62163e;
        }
        return null;
    }

    public boolean hasComplete() {
        return this.f62162d && this.f62163e == null;
    }

    public boolean hasThrowable() {
        return this.f62162d && this.f62163e != null;
    }
}
