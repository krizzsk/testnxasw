package p218io.reactivex.internal.operators.completable;

import java.util.concurrent.Callable;
import p218io.reactivex.Completable;
import p218io.reactivex.CompletableObserver;
import p218io.reactivex.exceptions.Exceptions;
import p218io.reactivex.internal.disposables.EmptyDisposable;
import p218io.reactivex.internal.functions.ObjectHelper;

/* renamed from: io.reactivex.internal.operators.completable.CompletableErrorSupplier */
public final class CompletableErrorSupplier extends Completable {

    /* renamed from: a */
    final Callable<? extends Throwable> f60881a;

    public CompletableErrorSupplier(Callable<? extends Throwable> callable) {
        this.f60881a = callable;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(CompletableObserver completableObserver) {
        try {
            th = (Throwable) ObjectHelper.requireNonNull(this.f60881a.call(), "The error returned is null");
        } catch (Throwable th) {
            th = th;
            Exceptions.throwIfFatal(th);
        }
        EmptyDisposable.error(th, completableObserver);
    }
}
