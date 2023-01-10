package p218io.reactivex.internal.operators.observable;

import java.util.concurrent.Callable;
import p218io.reactivex.Observable;
import p218io.reactivex.ObservableSource;
import p218io.reactivex.Observer;
import p218io.reactivex.exceptions.Exceptions;
import p218io.reactivex.internal.disposables.EmptyDisposable;
import p218io.reactivex.internal.functions.ObjectHelper;

/* renamed from: io.reactivex.internal.operators.observable.ObservableDefer */
public final class ObservableDefer<T> extends Observable<T> {

    /* renamed from: a */
    final Callable<? extends ObservableSource<? extends T>> f61547a;

    public ObservableDefer(Callable<? extends ObservableSource<? extends T>> callable) {
        this.f61547a = callable;
    }

    public void subscribeActual(Observer<? super T> observer) {
        try {
            ((ObservableSource) ObjectHelper.requireNonNull(this.f61547a.call(), "null ObservableSource supplied")).subscribe(observer);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, (Observer<?>) observer);
        }
    }
}
