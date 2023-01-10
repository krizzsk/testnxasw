package p218io.reactivex.internal.operators.single;

import p218io.reactivex.Notification;
import p218io.reactivex.Single;
import p218io.reactivex.SingleObserver;
import p218io.reactivex.internal.operators.mixed.MaterializeSingleObserver;

/* renamed from: io.reactivex.internal.operators.single.SingleMaterialize */
public final class SingleMaterialize<T> extends Single<Notification<T>> {

    /* renamed from: a */
    final Single<T> f61924a;

    public SingleMaterialize(Single<T> single) {
        this.f61924a = single;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super Notification<T>> singleObserver) {
        this.f61924a.subscribe(new MaterializeSingleObserver(singleObserver));
    }
}
