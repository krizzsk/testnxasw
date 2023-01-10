package p218io.reactivex.internal.operators.completable;

import p218io.reactivex.Completable;
import p218io.reactivex.CompletableObserver;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.disposables.Disposables;
import p218io.reactivex.exceptions.Exceptions;
import p218io.reactivex.functions.Action;

/* renamed from: io.reactivex.internal.operators.completable.CompletableFromAction */
public final class CompletableFromAction extends Completable {

    /* renamed from: a */
    final Action f60882a;

    public CompletableFromAction(Action action) {
        this.f60882a = action;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(CompletableObserver completableObserver) {
        Disposable empty = Disposables.empty();
        completableObserver.onSubscribe(empty);
        try {
            this.f60882a.run();
            if (!empty.isDisposed()) {
                completableObserver.onComplete();
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            if (!empty.isDisposed()) {
                completableObserver.onError(th);
            }
        }
    }
}
