package p218io.reactivex.internal.operators.single;

import java.util.concurrent.atomic.AtomicReference;
import p218io.reactivex.Single;
import p218io.reactivex.SingleObserver;
import p218io.reactivex.SingleSource;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.internal.disposables.DisposableHelper;
import p218io.reactivex.internal.observers.ResumeSingleObserver;

/* renamed from: io.reactivex.internal.operators.single.SingleDelayWithSingle */
public final class SingleDelayWithSingle<T, U> extends Single<T> {

    /* renamed from: a */
    final SingleSource<T> f61876a;

    /* renamed from: b */
    final SingleSource<U> f61877b;

    public SingleDelayWithSingle(SingleSource<T> singleSource, SingleSource<U> singleSource2) {
        this.f61876a = singleSource;
        this.f61877b = singleSource2;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f61877b.subscribe(new OtherObserver(singleObserver, this.f61876a));
    }

    /* renamed from: io.reactivex.internal.operators.single.SingleDelayWithSingle$OtherObserver */
    static final class OtherObserver<T, U> extends AtomicReference<Disposable> implements SingleObserver<U>, Disposable {
        private static final long serialVersionUID = -8565274649390031272L;
        final SingleObserver<? super T> downstream;
        final SingleSource<T> source;

        OtherObserver(SingleObserver<? super T> singleObserver, SingleSource<T> singleSource) {
            this.downstream = singleObserver;
            this.source = singleSource;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                this.downstream.onSubscribe(this);
            }
        }

        public void onSuccess(U u) {
            this.source.subscribe(new ResumeSingleObserver(this, this.downstream));
        }

        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }
    }
}
