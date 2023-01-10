package p218io.reactivex.internal.operators.flowable;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p218io.reactivex.Flowable;
import p218io.reactivex.FlowableSubscriber;
import p218io.reactivex.exceptions.CompositeException;
import p218io.reactivex.exceptions.Exceptions;
import p218io.reactivex.functions.Consumer;
import p218io.reactivex.functions.Function;
import p218io.reactivex.internal.functions.ObjectHelper;
import p218io.reactivex.internal.subscriptions.EmptySubscription;
import p218io.reactivex.internal.subscriptions.SubscriptionHelper;
import p218io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.flowable.FlowableUsing */
public final class FlowableUsing<T, D> extends Flowable<T> {

    /* renamed from: a */
    final Callable<? extends D> f61274a;

    /* renamed from: b */
    final Function<? super D, ? extends Publisher<? extends T>> f61275b;

    /* renamed from: c */
    final Consumer<? super D> f61276c;

    /* renamed from: d */
    final boolean f61277d;

    public FlowableUsing(Callable<? extends D> callable, Function<? super D, ? extends Publisher<? extends T>> function, Consumer<? super D> consumer, boolean z) {
        this.f61274a = callable;
        this.f61275b = function;
        this.f61276c = consumer;
        this.f61277d = z;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        try {
            Object call = this.f61274a.call();
            try {
                ((Publisher) ObjectHelper.requireNonNull(this.f61275b.apply(call), "The sourceSupplier returned a null Publisher")).subscribe(new UsingSubscriber(subscriber, call, this.f61276c, this.f61277d));
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptySubscription.error(new CompositeException(th, th), subscriber);
            }
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptySubscription.error(th2, subscriber);
        }
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableUsing$UsingSubscriber */
    static final class UsingSubscriber<T, D> extends AtomicBoolean implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 5904473792286235046L;
        final Consumer<? super D> disposer;
        final Subscriber<? super T> downstream;
        final boolean eager;
        final D resource;
        Subscription upstream;

        UsingSubscriber(Subscriber<? super T> subscriber, D d, Consumer<? super D> consumer, boolean z) {
            this.downstream = subscriber;
            this.resource = d;
            this.disposer = consumer;
            this.eager = z;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        public void onError(Throwable th) {
            if (this.eager) {
                Throwable th2 = null;
                if (compareAndSet(false, true)) {
                    try {
                        this.disposer.accept(this.resource);
                    } catch (Throwable th3) {
                        th2 = th3;
                        Exceptions.throwIfFatal(th2);
                    }
                }
                this.upstream.cancel();
                if (th2 != null) {
                    this.downstream.onError(new CompositeException(th, th2));
                    return;
                }
                this.downstream.onError(th);
                return;
            }
            this.downstream.onError(th);
            this.upstream.cancel();
            disposeAfter();
        }

        public void onComplete() {
            if (this.eager) {
                if (compareAndSet(false, true)) {
                    try {
                        this.disposer.accept(this.resource);
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        this.downstream.onError(th);
                        return;
                    }
                }
                this.upstream.cancel();
                this.downstream.onComplete();
                return;
            }
            this.downstream.onComplete();
            this.upstream.cancel();
            disposeAfter();
        }

        public void request(long j) {
            this.upstream.request(j);
        }

        public void cancel() {
            disposeAfter();
            this.upstream.cancel();
        }

        /* access modifiers changed from: package-private */
        public void disposeAfter() {
            if (compareAndSet(false, true)) {
                try {
                    this.disposer.accept(this.resource);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    RxJavaPlugins.onError(th);
                }
            }
        }
    }
}
