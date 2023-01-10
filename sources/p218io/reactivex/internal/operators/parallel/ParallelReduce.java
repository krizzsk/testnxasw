package p218io.reactivex.internal.operators.parallel;

import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p218io.reactivex.exceptions.Exceptions;
import p218io.reactivex.functions.BiFunction;
import p218io.reactivex.internal.functions.ObjectHelper;
import p218io.reactivex.internal.subscribers.DeferredScalarSubscriber;
import p218io.reactivex.internal.subscriptions.EmptySubscription;
import p218io.reactivex.internal.subscriptions.SubscriptionHelper;
import p218io.reactivex.parallel.ParallelFlowable;
import p218io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.parallel.ParallelReduce */
public final class ParallelReduce<T, R> extends ParallelFlowable<R> {

    /* renamed from: a */
    final ParallelFlowable<? extends T> f61839a;

    /* renamed from: b */
    final Callable<R> f61840b;

    /* renamed from: c */
    final BiFunction<R, ? super T, R> f61841c;

    public ParallelReduce(ParallelFlowable<? extends T> parallelFlowable, Callable<R> callable, BiFunction<R, ? super T, R> biFunction) {
        this.f61839a = parallelFlowable;
        this.f61840b = callable;
        this.f61841c = biFunction;
    }

    public void subscribe(Subscriber<? super R>[] subscriberArr) {
        if (validate(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber[] subscriberArr2 = new Subscriber[length];
            int i = 0;
            while (i < length) {
                try {
                    subscriberArr2[i] = new ParallelReduceSubscriber(subscriberArr[i], ObjectHelper.requireNonNull(this.f61840b.call(), "The initialSupplier returned a null value"), this.f61841c);
                    i++;
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    mo184865a(subscriberArr, th);
                    return;
                }
            }
            this.f61839a.subscribe(subscriberArr2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo184865a(Subscriber<?>[] subscriberArr, Throwable th) {
        for (Subscriber<?> error : subscriberArr) {
            EmptySubscription.error(th, error);
        }
    }

    public int parallelism() {
        return this.f61839a.parallelism();
    }

    /* renamed from: io.reactivex.internal.operators.parallel.ParallelReduce$ParallelReduceSubscriber */
    static final class ParallelReduceSubscriber<T, R> extends DeferredScalarSubscriber<T, R> {
        private static final long serialVersionUID = 8200530050639449080L;
        R accumulator;
        boolean done;
        final BiFunction<R, ? super T, R> reducer;

        ParallelReduceSubscriber(Subscriber<? super R> subscriber, R r, BiFunction<R, ? super T, R> biFunction) {
            super(subscriber);
            this.accumulator = r;
            this.reducer = biFunction;
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
                    this.accumulator = ObjectHelper.requireNonNull(this.reducer.apply(this.accumulator, t), "The reducer returned a null value");
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
            this.accumulator = null;
            this.downstream.onError(th);
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                R r = this.accumulator;
                this.accumulator = null;
                complete(r);
            }
        }

        public void cancel() {
            super.cancel();
            this.upstream.cancel();
        }
    }
}
