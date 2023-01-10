package p218io.reactivex.processors;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p218io.reactivex.annotations.CheckReturnValue;
import p218io.reactivex.internal.functions.ObjectHelper;
import p218io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import p218io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.processors.AsyncProcessor */
public final class AsyncProcessor<T> extends FlowableProcessor<T> {

    /* renamed from: a */
    static final AsyncSubscription[] f62120a = new AsyncSubscription[0];

    /* renamed from: b */
    static final AsyncSubscription[] f62121b = new AsyncSubscription[0];

    /* renamed from: c */
    final AtomicReference<AsyncSubscription<T>[]> f62122c = new AtomicReference<>(f62120a);

    /* renamed from: d */
    Throwable f62123d;

    /* renamed from: e */
    T f62124e;

    @CheckReturnValue
    public static <T> AsyncProcessor<T> create() {
        return new AsyncProcessor<>();
    }

    AsyncProcessor() {
    }

    public void onSubscribe(Subscription subscription) {
        if (this.f62122c.get() == f62121b) {
            subscription.cancel();
        } else {
            subscription.request(Long.MAX_VALUE);
        }
    }

    public void onNext(T t) {
        ObjectHelper.requireNonNull(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f62122c.get() != f62121b) {
            this.f62124e = t;
        }
    }

    public void onError(Throwable th) {
        ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        AsyncSubscription<T>[] asyncSubscriptionArr = this.f62122c.get();
        AsyncSubscription<T>[] asyncSubscriptionArr2 = f62121b;
        if (asyncSubscriptionArr == asyncSubscriptionArr2) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.f62124e = null;
        this.f62123d = th;
        for (AsyncSubscription onError : (AsyncSubscription[]) this.f62122c.getAndSet(asyncSubscriptionArr2)) {
            onError.onError(th);
        }
    }

    public void onComplete() {
        AsyncSubscription<T>[] asyncSubscriptionArr = this.f62122c.get();
        AsyncSubscription<T>[] asyncSubscriptionArr2 = f62121b;
        if (asyncSubscriptionArr != asyncSubscriptionArr2) {
            T t = this.f62124e;
            AsyncSubscription[] asyncSubscriptionArr3 = (AsyncSubscription[]) this.f62122c.getAndSet(asyncSubscriptionArr2);
            int i = 0;
            if (t == null) {
                int length = asyncSubscriptionArr3.length;
                while (i < length) {
                    asyncSubscriptionArr3[i].onComplete();
                    i++;
                }
                return;
            }
            int length2 = asyncSubscriptionArr3.length;
            while (i < length2) {
                asyncSubscriptionArr3[i].complete(t);
                i++;
            }
        }
    }

    public boolean hasSubscribers() {
        return ((AsyncSubscription[]) this.f62122c.get()).length != 0;
    }

    public boolean hasThrowable() {
        return this.f62122c.get() == f62121b && this.f62123d != null;
    }

    public boolean hasComplete() {
        return this.f62122c.get() == f62121b && this.f62123d == null;
    }

    public Throwable getThrowable() {
        if (this.f62122c.get() == f62121b) {
            return this.f62123d;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super T> subscriber) {
        AsyncSubscription asyncSubscription = new AsyncSubscription(subscriber, this);
        subscriber.onSubscribe(asyncSubscription);
        if (!mo185220a(asyncSubscription)) {
            Throwable th = this.f62123d;
            if (th != null) {
                subscriber.onError(th);
                return;
            }
            T t = this.f62124e;
            if (t != null) {
                asyncSubscription.complete(t);
            } else {
                asyncSubscription.onComplete();
            }
        } else if (asyncSubscription.isCancelled()) {
            mo185221b(asyncSubscription);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo185220a(AsyncSubscription<T> asyncSubscription) {
        AsyncSubscription[] asyncSubscriptionArr;
        AsyncSubscription[] asyncSubscriptionArr2;
        do {
            asyncSubscriptionArr = (AsyncSubscription[]) this.f62122c.get();
            if (asyncSubscriptionArr == f62121b) {
                return false;
            }
            int length = asyncSubscriptionArr.length;
            asyncSubscriptionArr2 = new AsyncSubscription[(length + 1)];
            System.arraycopy(asyncSubscriptionArr, 0, asyncSubscriptionArr2, 0, length);
            asyncSubscriptionArr2[length] = asyncSubscription;
        } while (!this.f62122c.compareAndSet(asyncSubscriptionArr, asyncSubscriptionArr2));
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo185221b(AsyncSubscription<T> asyncSubscription) {
        AsyncSubscription<T>[] asyncSubscriptionArr;
        AsyncSubscription[] asyncSubscriptionArr2;
        do {
            asyncSubscriptionArr = (AsyncSubscription[]) this.f62122c.get();
            int length = asyncSubscriptionArr.length;
            if (length != 0) {
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (asyncSubscriptionArr[i2] == asyncSubscription) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        asyncSubscriptionArr2 = f62120a;
                    } else {
                        AsyncSubscription[] asyncSubscriptionArr3 = new AsyncSubscription[(length - 1)];
                        System.arraycopy(asyncSubscriptionArr, 0, asyncSubscriptionArr3, 0, i);
                        System.arraycopy(asyncSubscriptionArr, i + 1, asyncSubscriptionArr3, i, (length - i) - 1);
                        asyncSubscriptionArr2 = asyncSubscriptionArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.f62122c.compareAndSet(asyncSubscriptionArr, asyncSubscriptionArr2));
    }

    public boolean hasValue() {
        return this.f62122c.get() == f62121b && this.f62124e != null;
    }

    public T getValue() {
        if (this.f62122c.get() == f62121b) {
            return this.f62124e;
        }
        return null;
    }

    @Deprecated
    public Object[] getValues() {
        Object value = getValue();
        if (value == null) {
            return new Object[0];
        }
        return new Object[]{value};
    }

    @Deprecated
    public T[] getValues(T[] tArr) {
        T value = getValue();
        if (value == null) {
            if (tArr.length != 0) {
                tArr[0] = null;
            }
            return tArr;
        }
        if (tArr.length == 0) {
            tArr = Arrays.copyOf(tArr, 1);
        }
        tArr[0] = value;
        if (tArr.length != 1) {
            tArr[1] = null;
        }
        return tArr;
    }

    /* renamed from: io.reactivex.processors.AsyncProcessor$AsyncSubscription */
    static final class AsyncSubscription<T> extends DeferredScalarSubscription<T> {
        private static final long serialVersionUID = 5629876084736248016L;
        final AsyncProcessor<T> parent;

        AsyncSubscription(Subscriber<? super T> subscriber, AsyncProcessor<T> asyncProcessor) {
            super(subscriber);
            this.parent = asyncProcessor;
        }

        public void cancel() {
            if (super.tryCancel()) {
                this.parent.mo185221b(this);
            }
        }

        /* access modifiers changed from: package-private */
        public void onComplete() {
            if (!isCancelled()) {
                this.downstream.onComplete();
            }
        }

        /* access modifiers changed from: package-private */
        public void onError(Throwable th) {
            if (isCancelled()) {
                RxJavaPlugins.onError(th);
            } else {
                this.downstream.onError(th);
            }
        }
    }
}
