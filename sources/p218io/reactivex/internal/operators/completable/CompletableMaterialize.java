package p218io.reactivex.internal.operators.completable;

import p218io.reactivex.Completable;
import p218io.reactivex.CompletableObserver;
import p218io.reactivex.Notification;
import p218io.reactivex.Single;
import p218io.reactivex.SingleObserver;
import p218io.reactivex.internal.operators.mixed.MaterializeSingleObserver;

/* renamed from: io.reactivex.internal.operators.completable.CompletableMaterialize */
public final class CompletableMaterialize<T> extends Single<Notification<T>> {

    /* renamed from: a */
    final Completable f60894a;

    public CompletableMaterialize(Completable completable) {
        this.f60894a = completable;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super Notification<T>> singleObserver) {
        this.f60894a.subscribe((CompletableObserver) new MaterializeSingleObserver(singleObserver));
    }
}
