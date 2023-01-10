package p218io.reactivex.internal.operators.single;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;
import p218io.reactivex.FlowableSubscriber;
import p218io.reactivex.Single;
import p218io.reactivex.SingleObserver;
import p218io.reactivex.SingleSource;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.internal.disposables.DisposableHelper;
import p218io.reactivex.internal.subscriptions.SubscriptionHelper;
import p218io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.single.SingleTakeUntil */
public final class SingleTakeUntil<T, U> extends Single<T> {

    /* renamed from: a */
    final SingleSource<T> f61934a;

    /* renamed from: b */
    final Publisher<U> f61935b;

    public SingleTakeUntil(SingleSource<T> singleSource, Publisher<U> publisher) {
        this.f61934a = singleSource;
        this.f61935b = publisher;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        TakeUntilMainObserver takeUntilMainObserver = new TakeUntilMainObserver(singleObserver);
        singleObserver.onSubscribe(takeUntilMainObserver);
        this.f61935b.subscribe(takeUntilMainObserver.other);
        this.f61934a.subscribe(takeUntilMainObserver);
    }

    /* renamed from: io.reactivex.internal.operators.single.SingleTakeUntil$TakeUntilMainObserver */
    static final class TakeUntilMainObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable {
        private static final long serialVersionUID = -622603812305745221L;
        final SingleObserver<? super T> downstream;
        final TakeUntilOtherSubscriber other = new TakeUntilOtherSubscriber(this);

        TakeUntilMainObserver(SingleObserver<? super T> singleObserver) {
            this.downstream = singleObserver;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
            this.other.dispose();
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        public void onSuccess(T t) {
            this.other.dispose();
            if (((Disposable) getAndSet(DisposableHelper.DISPOSED)) != DisposableHelper.DISPOSED) {
                this.downstream.onSuccess(t);
            }
        }

        public void onError(Throwable th) {
            this.other.dispose();
            if (((Disposable) get()) == DisposableHelper.DISPOSED || ((Disposable) getAndSet(DisposableHelper.DISPOSED)) == DisposableHelper.DISPOSED) {
                RxJavaPlugins.onError(th);
            } else {
                this.downstream.onError(th);
            }
        }

        /* access modifiers changed from: package-private */
        public void otherError(Throwable th) {
            Disposable disposable;
            if (((Disposable) get()) == DisposableHelper.DISPOSED || (disposable = (Disposable) getAndSet(DisposableHelper.DISPOSED)) == DisposableHelper.DISPOSED) {
                RxJavaPlugins.onError(th);
                return;
            }
            if (disposable != null) {
                disposable.dispose();
            }
            this.downstream.onError(th);
        }
    }

    /* renamed from: io.reactivex.internal.operators.single.SingleTakeUntil$TakeUntilOtherSubscriber */
    static final class TakeUntilOtherSubscriber extends AtomicReference<Subscription> implements FlowableSubscriber<Object> {
        private static final long serialVersionUID = 5170026210238877381L;
        final TakeUntilMainObserver<?> parent;

        TakeUntilOtherSubscriber(TakeUntilMainObserver<?> takeUntilMainObserver) {
            this.parent = takeUntilMainObserver;
        }

        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
        }

        public void onNext(Object obj) {
            if (SubscriptionHelper.cancel(this)) {
                this.parent.otherError(new CancellationException());
            }
        }

        public void onError(Throwable th) {
            this.parent.otherError(th);
        }

        public void onComplete() {
            if (get() != SubscriptionHelper.CANCELLED) {
                lazySet(SubscriptionHelper.CANCELLED);
                this.parent.otherError(new CancellationException());
            }
        }

        public void dispose() {
            SubscriptionHelper.cancel(this);
        }
    }
}
