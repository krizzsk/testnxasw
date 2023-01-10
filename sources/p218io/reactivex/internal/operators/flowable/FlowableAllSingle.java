package p218io.reactivex.internal.operators.flowable;

import org.reactivestreams.Subscription;
import p218io.reactivex.Flowable;
import p218io.reactivex.FlowableSubscriber;
import p218io.reactivex.Single;
import p218io.reactivex.SingleObserver;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.exceptions.Exceptions;
import p218io.reactivex.functions.Predicate;
import p218io.reactivex.internal.fuseable.FuseToFlowable;
import p218io.reactivex.internal.subscriptions.SubscriptionHelper;
import p218io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.flowable.FlowableAllSingle */
public final class FlowableAllSingle<T> extends Single<Boolean> implements FuseToFlowable<Boolean> {

    /* renamed from: a */
    final Flowable<T> f60943a;

    /* renamed from: b */
    final Predicate<? super T> f60944b;

    public FlowableAllSingle(Flowable<T> flowable, Predicate<? super T> predicate) {
        this.f60943a = flowable;
        this.f60944b = predicate;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        this.f60943a.subscribe(new AllSubscriber(singleObserver, this.f60944b));
    }

    public Flowable<Boolean> fuseToFlowable() {
        return RxJavaPlugins.onAssembly(new FlowableAll(this.f60943a, this.f60944b));
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableAllSingle$AllSubscriber */
    static final class AllSubscriber<T> implements FlowableSubscriber<T>, Disposable {
        boolean done;
        final SingleObserver<? super Boolean> downstream;
        final Predicate<? super T> predicate;
        Subscription upstream;

        AllSubscriber(SingleObserver<? super Boolean> singleObserver, Predicate<? super T> predicate2) {
            this.downstream = singleObserver;
            this.predicate = predicate2;
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
                    if (!this.predicate.test(t)) {
                        this.done = true;
                        this.upstream.cancel();
                        this.upstream = SubscriptionHelper.CANCELLED;
                        this.downstream.onSuccess(false);
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.upstream.cancel();
                    this.upstream = SubscriptionHelper.CANCELLED;
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
            this.upstream = SubscriptionHelper.CANCELLED;
            this.downstream.onError(th);
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.upstream = SubscriptionHelper.CANCELLED;
                this.downstream.onSuccess(true);
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
