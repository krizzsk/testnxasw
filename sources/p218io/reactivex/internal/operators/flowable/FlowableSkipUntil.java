package p218io.reactivex.internal.operators.flowable;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p218io.reactivex.Flowable;
import p218io.reactivex.FlowableSubscriber;
import p218io.reactivex.internal.fuseable.ConditionalSubscriber;
import p218io.reactivex.internal.subscriptions.SubscriptionHelper;
import p218io.reactivex.internal.util.AtomicThrowable;
import p218io.reactivex.internal.util.HalfSerializer;

/* renamed from: io.reactivex.internal.operators.flowable.FlowableSkipUntil */
public final class FlowableSkipUntil<T, U> extends C22212a<T, T> {

    /* renamed from: a */
    final Publisher<U> f61229a;

    public FlowableSkipUntil(Flowable<T> flowable, Publisher<U> publisher) {
        super(flowable);
        this.f61229a = publisher;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super T> subscriber) {
        SkipUntilMainSubscriber skipUntilMainSubscriber = new SkipUntilMainSubscriber(subscriber);
        subscriber.onSubscribe(skipUntilMainSubscriber);
        this.f61229a.subscribe(skipUntilMainSubscriber.other);
        this.source.subscribe(skipUntilMainSubscriber);
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableSkipUntil$SkipUntilMainSubscriber */
    static final class SkipUntilMainSubscriber<T> extends AtomicInteger implements ConditionalSubscriber<T>, Subscription {
        private static final long serialVersionUID = -6270983465606289181L;
        final Subscriber<? super T> downstream;
        final AtomicThrowable error = new AtomicThrowable();
        volatile boolean gate;
        final SkipUntilMainSubscriber<T>.OtherSubscriber other = new OtherSubscriber();
        final AtomicLong requested = new AtomicLong();
        final AtomicReference<Subscription> upstream = new AtomicReference<>();

        SkipUntilMainSubscriber(Subscriber<? super T> subscriber) {
            this.downstream = subscriber;
        }

        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, subscription);
        }

        public void onNext(T t) {
            if (!tryOnNext(t)) {
                this.upstream.get().request(1);
            }
        }

        public boolean tryOnNext(T t) {
            if (!this.gate) {
                return false;
            }
            HalfSerializer.onNext(this.downstream, t, (AtomicInteger) this, this.error);
            return true;
        }

        public void onError(Throwable th) {
            SubscriptionHelper.cancel(this.other);
            HalfSerializer.onError((Subscriber<?>) this.downstream, th, (AtomicInteger) this, this.error);
        }

        public void onComplete() {
            SubscriptionHelper.cancel(this.other);
            HalfSerializer.onComplete((Subscriber<?>) this.downstream, (AtomicInteger) this, this.error);
        }

        public void request(long j) {
            SubscriptionHelper.deferredRequest(this.upstream, this.requested, j);
        }

        public void cancel() {
            SubscriptionHelper.cancel(this.upstream);
            SubscriptionHelper.cancel(this.other);
        }

        /* renamed from: io.reactivex.internal.operators.flowable.FlowableSkipUntil$SkipUntilMainSubscriber$OtherSubscriber */
        final class OtherSubscriber extends AtomicReference<Subscription> implements FlowableSubscriber<Object> {
            private static final long serialVersionUID = -5592042965931999169L;

            OtherSubscriber() {
            }

            public void onSubscribe(Subscription subscription) {
                SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
            }

            public void onNext(Object obj) {
                SkipUntilMainSubscriber.this.gate = true;
                ((Subscription) get()).cancel();
            }

            public void onError(Throwable th) {
                SubscriptionHelper.cancel(SkipUntilMainSubscriber.this.upstream);
                Subscriber<? super T> subscriber = SkipUntilMainSubscriber.this.downstream;
                SkipUntilMainSubscriber skipUntilMainSubscriber = SkipUntilMainSubscriber.this;
                HalfSerializer.onError((Subscriber<?>) subscriber, th, (AtomicInteger) skipUntilMainSubscriber, skipUntilMainSubscriber.error);
            }

            public void onComplete() {
                SkipUntilMainSubscriber.this.gate = true;
            }
        }
    }
}
