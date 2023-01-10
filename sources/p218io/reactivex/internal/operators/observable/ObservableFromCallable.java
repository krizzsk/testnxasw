package p218io.reactivex.internal.operators.observable;

import java.util.concurrent.Callable;
import p218io.reactivex.Observable;
import p218io.reactivex.Observer;
import p218io.reactivex.exceptions.Exceptions;
import p218io.reactivex.internal.functions.ObjectHelper;
import p218io.reactivex.internal.observers.DeferredScalarDisposable;
import p218io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.observable.ObservableFromCallable */
public final class ObservableFromCallable<T> extends Observable<T> implements Callable<T> {

    /* renamed from: a */
    final Callable<? extends T> f61596a;

    public ObservableFromCallable(Callable<? extends T> callable) {
        this.f61596a = callable;
    }

    public void subscribeActual(Observer<? super T> observer) {
        DeferredScalarDisposable deferredScalarDisposable = new DeferredScalarDisposable(observer);
        observer.onSubscribe(deferredScalarDisposable);
        if (!deferredScalarDisposable.isDisposed()) {
            try {
                deferredScalarDisposable.complete(ObjectHelper.requireNonNull(this.f61596a.call(), "Callable returned null"));
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                if (!deferredScalarDisposable.isDisposed()) {
                    observer.onError(th);
                } else {
                    RxJavaPlugins.onError(th);
                }
            }
        }
    }

    public T call() throws Exception {
        return ObjectHelper.requireNonNull(this.f61596a.call(), "The callable returned a null value");
    }
}
