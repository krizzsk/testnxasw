package p218io.reactivex.observers;

import com.didi.travel.p172v2.store.IStoreCallback;
import java.util.concurrent.atomic.AtomicReference;
import p218io.reactivex.CompletableObserver;
import p218io.reactivex.MaybeObserver;
import p218io.reactivex.Observer;
import p218io.reactivex.SingleObserver;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.functions.Consumer;
import p218io.reactivex.internal.disposables.DisposableHelper;
import p218io.reactivex.internal.fuseable.QueueDisposable;
import p218io.reactivex.internal.util.ExceptionHelper;

/* renamed from: io.reactivex.observers.TestObserver */
public class TestObserver<T> extends BaseTestConsumer<T, TestObserver<T>> implements CompletableObserver, MaybeObserver<T>, Observer<T>, SingleObserver<T>, Disposable {

    /* renamed from: a */
    private final Observer<? super T> f62091a;

    /* renamed from: b */
    private final AtomicReference<Disposable> f62092b;

    /* renamed from: c */
    private QueueDisposable<T> f62093c;

    /* renamed from: io.reactivex.observers.TestObserver$EmptyObserver */
    enum EmptyObserver implements Observer<Object> {
        INSTANCE;

        public void onComplete() {
        }

        public void onError(Throwable th) {
        }

        public void onNext(Object obj) {
        }

        public void onSubscribe(Disposable disposable) {
        }
    }

    public static <T> TestObserver<T> create() {
        return new TestObserver<>();
    }

    public static <T> TestObserver<T> create(Observer<? super T> observer) {
        return new TestObserver<>(observer);
    }

    public TestObserver() {
        this(EmptyObserver.INSTANCE);
    }

    public TestObserver(Observer<? super T> observer) {
        this.f62092b = new AtomicReference<>();
        this.f62091a = observer;
    }

    public void onSubscribe(Disposable disposable) {
        this.lastThread = Thread.currentThread();
        if (disposable == null) {
            this.errors.add(new NullPointerException("onSubscribe received a null Subscription"));
        } else if (!this.f62092b.compareAndSet((Object) null, disposable)) {
            disposable.dispose();
            if (this.f62092b.get() != DisposableHelper.DISPOSED) {
                this.errors.add(new IllegalStateException("onSubscribe received multiple subscriptions: " + disposable));
            }
        } else {
            if (this.initialFusionMode != 0 && (disposable instanceof QueueDisposable)) {
                QueueDisposable<T> queueDisposable = (QueueDisposable) disposable;
                this.f62093c = queueDisposable;
                int requestFusion = queueDisposable.requestFusion(this.initialFusionMode);
                this.establishedFusionMode = requestFusion;
                if (requestFusion == 1) {
                    this.checkSubscriptionOnce = true;
                    this.lastThread = Thread.currentThread();
                    while (true) {
                        try {
                            T poll = this.f62093c.poll();
                            if (poll != null) {
                                this.values.add(poll);
                            } else {
                                this.completions++;
                                this.f62092b.lazySet(DisposableHelper.DISPOSED);
                                return;
                            }
                        } catch (Throwable th) {
                            this.errors.add(th);
                            return;
                        }
                    }
                }
            }
            this.f62091a.onSubscribe(disposable);
        }
    }

    public void onNext(T t) {
        if (!this.checkSubscriptionOnce) {
            this.checkSubscriptionOnce = true;
            if (this.f62092b.get() == null) {
                this.errors.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        this.lastThread = Thread.currentThread();
        if (this.establishedFusionMode == 2) {
            while (true) {
                try {
                    T poll = this.f62093c.poll();
                    if (poll != null) {
                        this.values.add(poll);
                    } else {
                        return;
                    }
                } catch (Throwable th) {
                    this.errors.add(th);
                    this.f62093c.dispose();
                    return;
                }
            }
        } else {
            this.values.add(t);
            if (t == null) {
                this.errors.add(new NullPointerException("onNext received a null value"));
            }
            this.f62091a.onNext(t);
        }
    }

    public void onError(Throwable th) {
        if (!this.checkSubscriptionOnce) {
            this.checkSubscriptionOnce = true;
            if (this.f62092b.get() == null) {
                this.errors.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.lastThread = Thread.currentThread();
            if (th == null) {
                this.errors.add(new NullPointerException("onError received a null Throwable"));
            } else {
                this.errors.add(th);
            }
            this.f62091a.onError(th);
        } finally {
            this.done.countDown();
        }
    }

    public void onComplete() {
        if (!this.checkSubscriptionOnce) {
            this.checkSubscriptionOnce = true;
            if (this.f62092b.get() == null) {
                this.errors.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.lastThread = Thread.currentThread();
            this.completions++;
            this.f62091a.onComplete();
        } finally {
            this.done.countDown();
        }
    }

    public final boolean isCancelled() {
        return isDisposed();
    }

    public final void cancel() {
        dispose();
    }

    public final void dispose() {
        DisposableHelper.dispose(this.f62092b);
    }

    public final boolean isDisposed() {
        return DisposableHelper.isDisposed(this.f62092b.get());
    }

    public final boolean hasSubscription() {
        return this.f62092b.get() != null;
    }

    public final TestObserver<T> assertSubscribed() {
        if (this.f62092b.get() != null) {
            return this;
        }
        throw fail("Not subscribed!");
    }

    public final TestObserver<T> assertNotSubscribed() {
        if (this.f62092b.get() != null) {
            throw fail("Subscribed!");
        } else if (this.errors.isEmpty()) {
            return this;
        } else {
            throw fail("Not subscribed but errors found");
        }
    }

    public final TestObserver<T> assertOf(Consumer<? super TestObserver<T>> consumer) {
        try {
            consumer.accept(this);
            return this;
        } catch (Throwable th) {
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final TestObserver<T> mo185169a(int i) {
        this.initialFusionMode = i;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final TestObserver<T> mo185172b(int i) {
        int i2 = this.establishedFusionMode;
        if (i2 == i) {
            return this;
        }
        if (this.f62093c != null) {
            throw new AssertionError("Fusion mode different. Expected: " + m45993c(i) + ", actual: " + m45993c(i2));
        }
        throw fail("Upstream is not fuseable");
    }

    /* renamed from: c */
    static String m45993c(int i) {
        if (i == 0) {
            return IStoreCallback.DEFAULT_API_DETAIL_KEY;
        }
        if (i == 1) {
            return "SYNC";
        }
        if (i == 2) {
            return "ASYNC";
        }
        return "Unknown(" + i + ")";
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final TestObserver<T> mo185168a() {
        if (this.f62093c != null) {
            return this;
        }
        throw new AssertionError("Upstream is not fuseable.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final TestObserver<T> mo185171b() {
        if (this.f62093c == null) {
            return this;
        }
        throw new AssertionError("Upstream is fuseable.");
    }

    public void onSuccess(T t) {
        onNext(t);
        onComplete();
    }
}
