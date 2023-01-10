package p218io.reactivex.internal.operators.single;

import org.reactivestreams.Subscriber;
import p218io.reactivex.Flowable;
import p218io.reactivex.SingleObserver;
import p218io.reactivex.SingleSource;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.internal.disposables.DisposableHelper;
import p218io.reactivex.internal.subscriptions.DeferredScalarSubscription;

/* renamed from: io.reactivex.internal.operators.single.SingleToFlowable */
public final class SingleToFlowable<T> extends Flowable<T> {

    /* renamed from: a */
    final SingleSource<? extends T> f61944a;

    public SingleToFlowable(SingleSource<? extends T> singleSource) {
        this.f61944a = singleSource;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f61944a.subscribe(new SingleToFlowableObserver(subscriber));
    }

    /* renamed from: io.reactivex.internal.operators.single.SingleToFlowable$SingleToFlowableObserver */
    static final class SingleToFlowableObserver<T> extends DeferredScalarSubscription<T> implements SingleObserver<T> {
        private static final long serialVersionUID = 187782011903685568L;
        Disposable upstream;

        SingleToFlowableObserver(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        public void onSuccess(T t) {
            complete(t);
        }

        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        public void cancel() {
            super.cancel();
            this.upstream.dispose();
        }
    }
}
