package p218io.reactivex.internal.operators.flowable;

import org.reactivestreams.Subscriber;
import p218io.reactivex.Flowable;
import p218io.reactivex.functions.Predicate;
import p218io.reactivex.internal.fuseable.ConditionalSubscriber;
import p218io.reactivex.internal.fuseable.QueueSubscription;
import p218io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber;
import p218io.reactivex.internal.subscribers.BasicFuseableSubscriber;

/* renamed from: io.reactivex.internal.operators.flowable.FlowableFilter */
public final class FlowableFilter<T> extends C22212a<T, T> {

    /* renamed from: a */
    final Predicate<? super T> f61059a;

    public FlowableFilter(Flowable<T> flowable, Predicate<? super T> predicate) {
        super(flowable);
        this.f61059a = predicate;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super T> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            this.source.subscribe(new FilterConditionalSubscriber((ConditionalSubscriber) subscriber, this.f61059a));
        } else {
            this.source.subscribe(new FilterSubscriber(subscriber, this.f61059a));
        }
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableFilter$FilterSubscriber */
    static final class FilterSubscriber<T> extends BasicFuseableSubscriber<T, T> implements ConditionalSubscriber<T> {
        final Predicate<? super T> filter;

        FilterSubscriber(Subscriber<? super T> subscriber, Predicate<? super T> predicate) {
            super(subscriber);
            this.filter = predicate;
        }

        public void onNext(T t) {
            if (!tryOnNext(t)) {
                this.upstream.request(1);
            }
        }

        public boolean tryOnNext(T t) {
            if (this.done) {
                return false;
            }
            if (this.sourceMode != 0) {
                this.downstream.onNext(null);
                return true;
            }
            try {
                boolean test = this.filter.test(t);
                if (test) {
                    this.downstream.onNext(t);
                }
                return test;
            } catch (Throwable th) {
                fail(th);
                return true;
            }
        }

        public int requestFusion(int i) {
            return transitiveBoundaryFusion(i);
        }

        public T poll() throws Exception {
            QueueSubscription queueSubscription = this.f62024qs;
            Predicate<? super T> predicate = this.filter;
            while (true) {
                T poll = queueSubscription.poll();
                if (poll == null) {
                    return null;
                }
                if (predicate.test(poll)) {
                    return poll;
                }
                if (this.sourceMode == 2) {
                    queueSubscription.request(1);
                }
            }
        }
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableFilter$FilterConditionalSubscriber */
    static final class FilterConditionalSubscriber<T> extends BasicFuseableConditionalSubscriber<T, T> {
        final Predicate<? super T> filter;

        FilterConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Predicate<? super T> predicate) {
            super(conditionalSubscriber);
            this.filter = predicate;
        }

        public void onNext(T t) {
            if (!tryOnNext(t)) {
                this.upstream.request(1);
            }
        }

        public boolean tryOnNext(T t) {
            if (this.done) {
                return false;
            }
            if (this.sourceMode != 0) {
                return this.downstream.tryOnNext(null);
            }
            try {
                if (!this.filter.test(t) || !this.downstream.tryOnNext(t)) {
                    return false;
                }
                return true;
            } catch (Throwable th) {
                fail(th);
                return true;
            }
        }

        public int requestFusion(int i) {
            return transitiveBoundaryFusion(i);
        }

        public T poll() throws Exception {
            QueueSubscription queueSubscription = this.f62023qs;
            Predicate<? super T> predicate = this.filter;
            while (true) {
                T poll = queueSubscription.poll();
                if (poll == null) {
                    return null;
                }
                if (predicate.test(poll)) {
                    return poll;
                }
                if (this.sourceMode == 2) {
                    queueSubscription.request(1);
                }
            }
        }
    }
}
