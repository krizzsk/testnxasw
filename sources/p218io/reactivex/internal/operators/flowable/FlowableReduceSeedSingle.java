package p218io.reactivex.internal.operators.flowable;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;
import p218io.reactivex.FlowableSubscriber;
import p218io.reactivex.Single;
import p218io.reactivex.SingleObserver;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.exceptions.Exceptions;
import p218io.reactivex.functions.BiFunction;
import p218io.reactivex.internal.functions.ObjectHelper;
import p218io.reactivex.internal.subscriptions.SubscriptionHelper;
import p218io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.flowable.FlowableReduceSeedSingle */
public final class FlowableReduceSeedSingle<T, R> extends Single<R> {

    /* renamed from: a */
    final Publisher<T> f61166a;

    /* renamed from: b */
    final R f61167b;

    /* renamed from: c */
    final BiFunction<R, ? super T, R> f61168c;

    public FlowableReduceSeedSingle(Publisher<T> publisher, R r, BiFunction<R, ? super T, R> biFunction) {
        this.f61166a = publisher;
        this.f61167b = r;
        this.f61168c = biFunction;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super R> singleObserver) {
        this.f61166a.subscribe(new ReduceSeedObserver(singleObserver, this.f61168c, this.f61167b));
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableReduceSeedSingle$ReduceSeedObserver */
    static final class ReduceSeedObserver<T, R> implements FlowableSubscriber<T>, Disposable {
        final SingleObserver<? super R> downstream;
        final BiFunction<R, ? super T, R> reducer;
        Subscription upstream;
        R value;

        ReduceSeedObserver(SingleObserver<? super R> singleObserver, BiFunction<R, ? super T, R> biFunction, R r) {
            this.downstream = singleObserver;
            this.value = r;
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
            R r = this.value;
            if (r != null) {
                try {
                    this.value = ObjectHelper.requireNonNull(this.reducer.apply(r, t), "The reducer returned a null value");
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.upstream.cancel();
                    onError(th);
                }
            }
        }

        public void onError(Throwable th) {
            if (this.value != null) {
                this.value = null;
                this.upstream = SubscriptionHelper.CANCELLED;
                this.downstream.onError(th);
                return;
            }
            RxJavaPlugins.onError(th);
        }

        public void onComplete() {
            R r = this.value;
            if (r != null) {
                this.value = null;
                this.upstream = SubscriptionHelper.CANCELLED;
                this.downstream.onSuccess(r);
            }
        }

        public void dispose() {
            this.upstream.cancel();
            this.upstream = SubscriptionHelper.CANCELLED;
        }

        public boolean isDisposed() {
            return this.upstream == SubscriptionHelper.CANCELLED;
        }
    }
}
