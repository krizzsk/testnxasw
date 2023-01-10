package p218io.reactivex.internal.operators.parallel;

import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p218io.reactivex.exceptions.Exceptions;
import p218io.reactivex.functions.BiConsumer;
import p218io.reactivex.internal.functions.ObjectHelper;
import p218io.reactivex.internal.subscribers.DeferredScalarSubscriber;
import p218io.reactivex.internal.subscriptions.EmptySubscription;
import p218io.reactivex.internal.subscriptions.SubscriptionHelper;
import p218io.reactivex.parallel.ParallelFlowable;
import p218io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.parallel.ParallelCollect */
public final class ParallelCollect<T, C> extends ParallelFlowable<C> {

    /* renamed from: a */
    final ParallelFlowable<? extends T> f61796a;

    /* renamed from: b */
    final Callable<? extends C> f61797b;

    /* renamed from: c */
    final BiConsumer<? super C, ? super T> f61798c;

    public ParallelCollect(ParallelFlowable<? extends T> parallelFlowable, Callable<? extends C> callable, BiConsumer<? super C, ? super T> biConsumer) {
        this.f61796a = parallelFlowable;
        this.f61797b = callable;
        this.f61798c = biConsumer;
    }

    public void subscribe(Subscriber<? super C>[] subscriberArr) {
        if (validate(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber[] subscriberArr2 = new Subscriber[length];
            int i = 0;
            while (i < length) {
                try {
                    subscriberArr2[i] = new ParallelCollectSubscriber(subscriberArr[i], ObjectHelper.requireNonNull(this.f61797b.call(), "The initialSupplier returned a null value"), this.f61798c);
                    i++;
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    mo184845a(subscriberArr, th);
                    return;
                }
            }
            this.f61796a.subscribe(subscriberArr2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo184845a(Subscriber<?>[] subscriberArr, Throwable th) {
        for (Subscriber<?> error : subscriberArr) {
            EmptySubscription.error(th, error);
        }
    }

    public int parallelism() {
        return this.f61796a.parallelism();
    }

    /* renamed from: io.reactivex.internal.operators.parallel.ParallelCollect$ParallelCollectSubscriber */
    static final class ParallelCollectSubscriber<T, C> extends DeferredScalarSubscriber<T, C> {
        private static final long serialVersionUID = -4767392946044436228L;
        C collection;
        final BiConsumer<? super C, ? super T> collector;
        boolean done;

        ParallelCollectSubscriber(Subscriber<? super C> subscriber, C c, BiConsumer<? super C, ? super T> biConsumer) {
            super(subscriber);
            this.collection = c;
            this.collector = biConsumer;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void onNext(T t) {
            if (!this.done) {
                try {
                    this.collector.accept(this.collection, t);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    cancel();
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
            this.collection = null;
            this.downstream.onError(th);
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                C c = this.collection;
                this.collection = null;
                complete(c);
            }
        }

        public void cancel() {
            super.cancel();
            this.upstream.cancel();
        }
    }
}
