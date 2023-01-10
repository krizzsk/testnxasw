package p218io.reactivex.internal.operators.single;

import p218io.reactivex.Single;
import p218io.reactivex.SingleObserver;
import p218io.reactivex.internal.disposables.EmptyDisposable;

/* renamed from: io.reactivex.internal.operators.single.SingleNever */
public final class SingleNever extends Single<Object> {
    public static final Single<Object> INSTANCE = new SingleNever();

    private SingleNever() {
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super Object> singleObserver) {
        singleObserver.onSubscribe(EmptyDisposable.NEVER);
    }
}
