package p218io.reactivex.internal.operators.observable;

import java.util.concurrent.Callable;
import p218io.reactivex.Observable;
import p218io.reactivex.Observer;
import p218io.reactivex.exceptions.Exceptions;
import p218io.reactivex.internal.disposables.EmptyDisposable;
import p218io.reactivex.internal.functions.ObjectHelper;

/* renamed from: io.reactivex.internal.operators.observable.ObservableError */
public final class ObservableError<T> extends Observable<T> {

    /* renamed from: a */
    final Callable<? extends Throwable> f61578a;

    public ObservableError(Callable<? extends Throwable> callable) {
        this.f61578a = callable;
    }

    public void subscribeActual(Observer<? super T> observer) {
        try {
            th = (Throwable) ObjectHelper.requireNonNull(this.f61578a.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th) {
            th = th;
            Exceptions.throwIfFatal(th);
        }
        EmptyDisposable.error(th, (Observer<?>) observer);
    }
}
