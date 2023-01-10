package p218io.reactivex.internal.operators.single;

import p218io.reactivex.Single;
import p218io.reactivex.SingleObserver;
import p218io.reactivex.disposables.Disposables;

/* renamed from: io.reactivex.internal.operators.single.SingleJust */
public final class SingleJust<T> extends Single<T> {

    /* renamed from: a */
    final T f61918a;

    public SingleJust(T t) {
        this.f61918a = t;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        singleObserver.onSubscribe(Disposables.disposed());
        singleObserver.onSuccess(this.f61918a);
    }
}
