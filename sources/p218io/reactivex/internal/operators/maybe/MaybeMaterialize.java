package p218io.reactivex.internal.operators.maybe;

import p218io.reactivex.Maybe;
import p218io.reactivex.Notification;
import p218io.reactivex.Single;
import p218io.reactivex.SingleObserver;
import p218io.reactivex.internal.operators.mixed.MaterializeSingleObserver;

/* renamed from: io.reactivex.internal.operators.maybe.MaybeMaterialize */
public final class MaybeMaterialize<T> extends Single<Notification<T>> {

    /* renamed from: a */
    final Maybe<T> f61376a;

    public MaybeMaterialize(Maybe<T> maybe) {
        this.f61376a = maybe;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super Notification<T>> singleObserver) {
        this.f61376a.subscribe(new MaterializeSingleObserver(singleObserver));
    }
}
