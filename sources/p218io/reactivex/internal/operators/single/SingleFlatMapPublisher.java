package p218io.reactivex.internal.operators.single;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p218io.reactivex.Flowable;
import p218io.reactivex.FlowableSubscriber;
import p218io.reactivex.SingleObserver;
import p218io.reactivex.SingleSource;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.exceptions.Exceptions;
import p218io.reactivex.functions.Function;
import p218io.reactivex.internal.functions.ObjectHelper;
import p218io.reactivex.internal.subscriptions.SubscriptionHelper;

/* renamed from: io.reactivex.internal.operators.single.SingleFlatMapPublisher */
public final class SingleFlatMapPublisher<T, R> extends Flowable<R> {

    /* renamed from: a */
    final SingleSource<T> f61912a;

    /* renamed from: b */
    final Function<? super T, ? extends Publisher<? extends R>> f61913b;

    public SingleFlatMapPublisher(SingleSource<T> singleSource, Function<? super T, ? extends Publisher<? extends R>> function) {
        this.f61912a = singleSource;
        this.f61913b = function;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.f61912a.subscribe(new SingleFlatMapPublisherObserver(subscriber, this.f61913b));
    }

    /* renamed from: io.reactivex.internal.operators.single.SingleFlatMapPublisher$SingleFlatMapPublisherObserver */
    static final class SingleFlatMapPublisherObserver<S, T> extends AtomicLong implements FlowableSubscriber<T>, SingleObserver<S>, Subscription {
        private static final long serialVersionUID = 7759721921468635667L;
        Disposable disposable;
        final Subscriber<? super T> downstream;
        final Function<? super S, ? extends Publisher<? extends T>> mapper;
        final AtomicReference<Subscription> parent = new AtomicReference<>();

        SingleFlatMapPublisherObserver(Subscriber<? super T> subscriber, Function<? super S, ? extends Publisher<? extends T>> function) {
            this.downstream = subscriber;
            this.mapper = function;
        }

        public void onSubscribe(Disposable disposable2) {
            this.disposable = disposable2;
            this.downstream.onSubscribe(this);
        }

        public void onSuccess(S s) {
            try {
                ((Publisher) ObjectHelper.requireNonNull(this.mapper.apply(s), "the mapper returned a null Publisher")).subscribe(this);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.downstream.onError(th);
            }
        }

        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this.parent, this, subscription);
        }

        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        public void onComplete() {
            this.downstream.onComplete();
        }

        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        public void request(long j) {
            SubscriptionHelper.deferredRequest(this.parent, this, j);
        }

        public void cancel() {
            this.disposable.dispose();
            SubscriptionHelper.cancel(this.parent);
        }
    }
}
