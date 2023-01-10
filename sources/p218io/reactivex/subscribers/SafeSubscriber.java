package p218io.reactivex.subscribers;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p218io.reactivex.FlowableSubscriber;
import p218io.reactivex.exceptions.CompositeException;
import p218io.reactivex.exceptions.Exceptions;
import p218io.reactivex.internal.subscriptions.EmptySubscription;
import p218io.reactivex.internal.subscriptions.SubscriptionHelper;
import p218io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.subscribers.SafeSubscriber */
public final class SafeSubscriber<T> implements FlowableSubscriber<T>, Subscription {

    /* renamed from: a */
    final Subscriber<? super T> f62244a;

    /* renamed from: b */
    Subscription f62245b;

    /* renamed from: c */
    boolean f62246c;

    public SafeSubscriber(Subscriber<? super T> subscriber) {
        this.f62244a = subscriber;
    }

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f62245b, subscription)) {
            this.f62245b = subscription;
            try {
                this.f62244a.onSubscribe(this);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(new CompositeException(th, th));
            }
        }
    }

    public void onNext(T t) {
        if (!this.f62246c) {
            if (this.f62245b == null) {
                mo185406a();
            } else if (t == null) {
                NullPointerException nullPointerException = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
                try {
                    this.f62245b.cancel();
                    onError(nullPointerException);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    onError(new CompositeException(nullPointerException, th));
                }
            } else {
                try {
                    this.f62244a.onNext(t);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    onError(new CompositeException(th, th2));
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo185406a() {
        this.f62246c = true;
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.f62244a.onSubscribe(EmptySubscription.INSTANCE);
            try {
                this.f62244a.onError(nullPointerException);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(new CompositeException(nullPointerException, th));
            }
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            RxJavaPlugins.onError(new CompositeException(nullPointerException, th2));
        }
    }

    public void onError(Throwable th) {
        if (this.f62246c) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.f62246c = true;
        if (this.f62245b == null) {
            NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
            try {
                this.f62244a.onSubscribe(EmptySubscription.INSTANCE);
                try {
                    this.f62244a.onError(new CompositeException(th, nullPointerException));
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    RxJavaPlugins.onError(new CompositeException(th, nullPointerException, th2));
                }
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                RxJavaPlugins.onError(new CompositeException(th, nullPointerException, th3));
            }
        } else {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            try {
                this.f62244a.onError(th);
            } catch (Throwable th4) {
                Exceptions.throwIfFatal(th4);
                RxJavaPlugins.onError(new CompositeException(th, th4));
            }
        }
    }

    public void onComplete() {
        if (!this.f62246c) {
            this.f62246c = true;
            if (this.f62245b == null) {
                mo185407b();
                return;
            }
            try {
                this.f62244a.onComplete();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo185407b() {
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.f62244a.onSubscribe(EmptySubscription.INSTANCE);
            try {
                this.f62244a.onError(nullPointerException);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(new CompositeException(nullPointerException, th));
            }
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            RxJavaPlugins.onError(new CompositeException(nullPointerException, th2));
        }
    }

    public void request(long j) {
        try {
            this.f62245b.request(j);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(new CompositeException(th, th));
        }
    }

    public void cancel() {
        try {
            this.f62245b.cancel();
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
        }
    }
}
