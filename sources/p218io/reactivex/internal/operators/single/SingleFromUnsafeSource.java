package p218io.reactivex.internal.operators.single;

import p218io.reactivex.Single;
import p218io.reactivex.SingleObserver;
import p218io.reactivex.SingleSource;

/* renamed from: io.reactivex.internal.operators.single.SingleFromUnsafeSource */
public final class SingleFromUnsafeSource<T> extends Single<T> {

    /* renamed from: a */
    final SingleSource<T> f61916a;

    public SingleFromUnsafeSource(SingleSource<T> singleSource) {
        this.f61916a = singleSource;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f61916a.subscribe(singleObserver);
    }
}
