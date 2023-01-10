package p218io.reactivex.internal.operators.observable;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import p218io.reactivex.Observable;
import p218io.reactivex.Observer;
import p218io.reactivex.exceptions.Exceptions;
import p218io.reactivex.internal.functions.ObjectHelper;
import p218io.reactivex.internal.observers.DeferredScalarDisposable;

/* renamed from: io.reactivex.internal.operators.observable.ObservableFromFuture */
public final class ObservableFromFuture<T> extends Observable<T> {

    /* renamed from: a */
    final Future<? extends T> f61597a;

    /* renamed from: b */
    final long f61598b;

    /* renamed from: c */
    final TimeUnit f61599c;

    public ObservableFromFuture(Future<? extends T> future, long j, TimeUnit timeUnit) {
        this.f61597a = future;
        this.f61598b = j;
        this.f61599c = timeUnit;
    }

    public void subscribeActual(Observer<? super T> observer) {
        DeferredScalarDisposable deferredScalarDisposable = new DeferredScalarDisposable(observer);
        observer.onSubscribe(deferredScalarDisposable);
        if (!deferredScalarDisposable.isDisposed()) {
            try {
                deferredScalarDisposable.complete(ObjectHelper.requireNonNull(this.f61599c != null ? this.f61597a.get(this.f61598b, this.f61599c) : this.f61597a.get(), "Future returned null"));
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                if (!deferredScalarDisposable.isDisposed()) {
                    observer.onError(th);
                }
            }
        }
    }
}
