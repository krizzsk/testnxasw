package p218io.reactivex.internal.operators.completable;

import p218io.reactivex.Completable;
import p218io.reactivex.CompletableObserver;
import p218io.reactivex.internal.disposables.EmptyDisposable;

/* renamed from: io.reactivex.internal.operators.completable.CompletableEmpty */
public final class CompletableEmpty extends Completable {
    public static final Completable INSTANCE = new CompletableEmpty();

    private CompletableEmpty() {
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        EmptyDisposable.complete(completableObserver);
    }
}
