package p218io.reactivex.internal.operators.flowable;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p218io.reactivex.Flowable;
import p218io.reactivex.FlowableSubscriber;
import p218io.reactivex.exceptions.Exceptions;
import p218io.reactivex.functions.BiFunction;
import p218io.reactivex.internal.functions.ObjectHelper;
import p218io.reactivex.internal.subscriptions.SubscriptionHelper;
import p218io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.flowable.FlowableScan */
public final class FlowableScan<T> extends C22212a<T, T> {

    /* renamed from: a */
    final BiFunction<T, T, T> f61202a;

    public FlowableScan(Flowable<T> flowable, BiFunction<T, T, T> biFunction) {
        super(flowable);
        this.f61202a = biFunction;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new ScanSubscriber(subscriber, this.f61202a));
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableScan$ScanSubscriber */
    static final class ScanSubscriber<T> implements FlowableSubscriber<T>, Subscription {
        final BiFunction<T, T, T> accumulator;
        boolean done;
        final Subscriber<? super T> downstream;
        Subscription upstream;
        T value;

        ScanSubscriber(Subscriber<? super T> subscriber, BiFunction<T, T, T> biFunction) {
            this.downstream = subscriber;
            this.accumulator = biFunction;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            if (!this.done) {
                Subscriber<? super T> subscriber = this.downstream;
                T t2 = this.value;
                if (t2 == null) {
                    this.value = t;
                    subscriber.onNext(t);
                    return;
                }
                try {
                    T requireNonNull = ObjectHelper.requireNonNull(this.accumulator.apply(t2, t), "The value returned by the accumulator is null");
                    this.value = requireNonNull;
                    subscriber.onNext(requireNonNull);
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
