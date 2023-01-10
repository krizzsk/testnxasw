package p218io.reactivex.internal.operators.completable;

import p218io.reactivex.Completable;
import p218io.reactivex.CompletableObserver;
import p218io.reactivex.CompletableSource;

/* renamed from: io.reactivex.internal.operators.completable.CompletableFromUnsafeSource */
public final class CompletableFromUnsafeSource extends Completable {

    /* renamed from: a */
    final CompletableSource f60890a;

    public CompletableFromUnsafeSource(CompletableSource completableSource) {
        this.f60890a = completableSource;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(CompletableObserver completableObserver) {
        this.f60890a.subscribe(completableObserver);
    }
}
