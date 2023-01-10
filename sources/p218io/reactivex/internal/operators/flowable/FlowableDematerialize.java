package p218io.reactivex.internal.operators.flowable;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p218io.reactivex.Flowable;
import p218io.reactivex.FlowableSubscriber;
import p218io.reactivex.Notification;
import p218io.reactivex.exceptions.Exceptions;
import p218io.reactivex.functions.Function;
import p218io.reactivex.internal.functions.ObjectHelper;
import p218io.reactivex.internal.subscriptions.SubscriptionHelper;
import p218io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.flowable.FlowableDematerialize */
public final class FlowableDematerialize<T, R> extends C22212a<T, R> {

    /* renamed from: a */
    final Function<? super T, ? extends Notification<R>> f61034a;

    public FlowableDematerialize(Flowable<T> flowable, Function<? super T, ? extends Notification<R>> function) {
        super(flowable);
        this.f61034a = function;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.source.subscribe(new DematerializeSubscriber(subscriber, this.f61034a));
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableDematerialize$DematerializeSubscriber */
    static final class DematerializeSubscriber<T, R> implements FlowableSubscriber<T>, Subscription {
        boolean done;
        final Subscriber<? super R> downstream;
        final Function<? super T, ? extends Notification<R>> selector;
        Subscription upstream;

        DematerializeSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends Notification<R>> function) {
            this.downstream = subscriber;
            this.selector = function;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            if (!this.done) {
                try {
                    Notification notification = (Notification) ObjectHelper.requireNonNull(this.selector.apply(t), "The selector returned a null Notification");
                    if (notification.isOnError()) {
                        this.upstream.cancel();
                        onError(notification.getError());
                    } else if (notification.isOnComplete()) {
                        this.upstream.cancel();
                        onComplete();
                    } else {
                        this.downstream.onNext(notification.getValue());
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.upstream.cancel();
                    onError(th);
                }
            } else if (t instanceof Notification) {
                Notification notification2 = (Notification) t;
                if (notification2.isOnError()) {
                    RxJavaPlugins.onError(notification2.getError());
                }
            }
        }

        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.downstream.onError(th);
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.downstream.onComplete();
            }
        }

        public void request(long j) {
            this.upstream.request(j);
        }

        public void cancel() {
            this.upstream.cancel();
        }
    }
}
