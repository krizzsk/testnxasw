package p218io.reactivex.internal.operators.single;

import p218io.reactivex.Single;
import p218io.reactivex.SingleObserver;
import p218io.reactivex.SingleSource;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.internal.disposables.DisposableHelper;

/* renamed from: io.reactivex.internal.operators.single.SingleHide */
public final class SingleHide<T> extends Single<T> {

    /* renamed from: a */
    final SingleSource<? extends T> f61917a;

    public SingleHide(SingleSource<? extends T> singleSource) {
        this.f61917a = singleSource;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f61917a.subscribe(new HideSingleObserver(singleObserver));
    }

    /* renamed from: io.reactivex.internal.operators.single.SingleHide$HideSingleObserver */
    static final class HideSingleObserver<T> implements SingleObserver<T>, Disposable {
        final SingleObserver<? super T> downstream;
        Disposable upstream;

        HideSingleObserver(SingleObserver<? super T> singleObserver) {
            this.downstream = singleObserver;
        }

        public void dispose() {
            this.upstream.dispose();
        }

        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        public void onSuccess(T t) {
            this.downstream.onSuccess(t);
        }

        public void onError(Throwable th) {
            this.downstream.onError(th);
        }
    }
}
