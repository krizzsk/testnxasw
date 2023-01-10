package p218io.reactivex.internal.operators.flowable;

import org.reactivestreams.Subscriber;
import p218io.reactivex.Flowable;
import p218io.reactivex.functions.Consumer;
import p218io.reactivex.internal.fuseable.ConditionalSubscriber;
import p218io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber;
import p218io.reactivex.internal.subscribers.BasicFuseableSubscriber;

/* renamed from: io.reactivex.internal.operators.flowable.FlowableDoAfterNext */
public final class FlowableDoAfterNext<T> extends C22212a<T, T> {

    /* renamed from: a */
    final Consumer<? super T> f61039a;

    public FlowableDoAfterNext(Flowable<T> flowable, Consumer<? super T> consumer) {
        super(flowable);
        this.f61039a = consumer;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super T> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            this.source.subscribe(new DoAfterConditionalSubscriber((ConditionalSubscriber) subscriber, this.f61039a));
        } else {
            this.source.subscribe(new DoAfterSubscriber(subscriber, this.f61039a));
        }
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableDoAfterNext$DoAfterSubscriber */
    static final class DoAfterSubscriber<T> extends BasicFuseableSubscriber<T, T> {
        final Consumer<? super T> onAfterNext;

        DoAfterSubscriber(Subscriber<? super T> subscriber, Consumer<? super T> consumer) {
            super(subscriber);
            this.onAfterNext = consumer;
        }

        public void onNext(T t) {
            if (!this.done) {
                this.downstream.onNext(t);
                if (this.sourceMode == 0) {
                    try {
                        this.onAfterNext.accept(t);
                    } catch (Throwable th) {
                        fail(th);
                    }
                }
            }
        }

        public int requestFusion(int i) {
            return transitiveBoundaryFusion(i);
        }

        public T poll() throws Exception {
            T poll = this.f62024qs.poll();
            if (poll != null) {
                this.onAfterNext.accept(poll);
            }
            return poll;
        }
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableDoAfterNext$DoAfterConditionalSubscriber */
    static final class DoAfterConditionalSubscriber<T> extends BasicFuseableConditionalSubscriber<T, T> {
        final Consumer<? super T> onAfterNext;

        DoAfterConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Consumer<? super T> consumer) {
            super(conditionalSubscriber);
            this.onAfterNext = consumer;
        }

        public void onNext(T t) {
            this.downstream.onNext(t);
            if (this.sourceMode == 0) {
                try {
                    this.onAfterNext.accept(t);
                } catch (Throwable th) {
                    fail(th);
                }
            }
        }

        public boolean tryOnNext(T t) {
            boolean tryOnNext = this.downstream.tryOnNext(t);
            try {
                this.onAfterNext.accept(t);
            } catch (Throwable th) {
                fail(th);
            }
            return tryOnNext;
        }

        public int requestFusion(int i) {
            return transitiveBoundaryFusion(i);
        }

        public T poll() throws Exception {
            T poll = this.f62023qs.poll();
            if (poll != null) {
                this.onAfterNext.accept(poll);
            }
            return poll;
        }
    }
}
