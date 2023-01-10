package p218io.reactivex.internal.operators.mixed;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p218io.reactivex.CompletableObserver;
import p218io.reactivex.CompletableSource;
import p218io.reactivex.Flowable;
import p218io.reactivex.FlowableSubscriber;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.internal.disposables.DisposableHelper;
import p218io.reactivex.internal.subscriptions.SubscriptionHelper;

/* renamed from: io.reactivex.internal.operators.mixed.CompletableAndThenPublisher */
public final class CompletableAndThenPublisher<R> extends Flowable<R> {

    /* renamed from: a */
    final CompletableSource f61418a;

    /* renamed from: b */
    final Publisher<? extends R> f61419b;

    public CompletableAndThenPublisher(CompletableSource completableSource, Publisher<? extends R> publisher) {
        this.f61418a = completableSource;
        this.f61419b = publisher;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.f61418a.subscribe(new AndThenPublisherSubscriber(subscriber, this.f61419b));
    }

    /* renamed from: io.reactivex.internal.operators.mixed.CompletableAndThenPublisher$AndThenPublisherSubscriber */
    static final class AndThenPublisherSubscriber<R> extends AtomicReference<Subscription> implements CompletableObserver, FlowableSubscriber<R>, Subscription {
        private static final long serialVersionUID = -8948264376121066672L;
        final Subscriber<? super R> downstream;
        Publisher<? extends R> other;
        final AtomicLong requested = new AtomicLong();
        Disposable upstream;

        AndThenPublisherSubscriber(Subscriber<? super R> subscriber, Publisher<? extends R> publisher) {
            this.downstream = subscriber;
            this.other = publisher;
        }

        public void onNext(R r) {
            this.downstream.onNext(r);
        }

        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        public void onComplete() {
            Publisher<? extends R> publisher = this.other;
            if (publisher == null) {
                this.downstream.onComplete();
                return;
            }
            this.other = null;
            publisher.subscribe(this);
        }

        public void request(long j) {
            SubscriptionHelper.deferredRequest(this, this.requested, j);
        }

        public void cancel() {
            this.upstream.dispose();
            SubscriptionHelper.cancel(this);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this, this.requested, subscription);
        }
    }
}
