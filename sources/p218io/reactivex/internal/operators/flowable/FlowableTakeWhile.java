package p218io.reactivex.internal.operators.flowable;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p218io.reactivex.Flowable;
import p218io.reactivex.FlowableSubscriber;
import p218io.reactivex.exceptions.Exceptions;
import p218io.reactivex.functions.Predicate;
import p218io.reactivex.internal.subscriptions.SubscriptionHelper;
import p218io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.flowable.FlowableTakeWhile */
public final class FlowableTakeWhile<T> extends C22212a<T, T> {

    /* renamed from: a */
    final Predicate<? super T> f61250a;

    public FlowableTakeWhile(Flowable<T> flowable, Predicate<? super T> predicate) {
        super(flowable);
        this.f61250a = predicate;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new TakeWhileSubscriber(subscriber, this.f61250a));
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableTakeWhile$TakeWhileSubscriber */
    static final class TakeWhileSubscriber<T> implements FlowableSubscriber<T>, Subscription {
        boolean done;
        final Subscriber<? super T> downstream;
        final Predicate<? super T> predicate;
        Subscription upstream;

        TakeWhileSubscriber(Subscriber<? super T> subscriber, Predicate<? super T> predicate2) {
            this.downstream = subscriber;
            this.predicate = predicate2;
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
                    if (!this.predicate.test(t)) {
                        this.done = true;
                        this.upstream.cancel();
                        this.downstream.onComplete();
                        return;
                    }
                    this.downstream.onNext(t);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.upstream.cancel();
                    onError(th);
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
