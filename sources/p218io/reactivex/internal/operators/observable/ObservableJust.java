package p218io.reactivex.internal.operators.observable;

import p218io.reactivex.Observable;
import p218io.reactivex.Observer;
import p218io.reactivex.internal.fuseable.ScalarCallable;
import p218io.reactivex.internal.operators.observable.ObservableScalarXMap;

/* renamed from: io.reactivex.internal.operators.observable.ObservableJust */
public final class ObservableJust<T> extends Observable<T> implements ScalarCallable<T> {

    /* renamed from: a */
    private final T f61631a;

    public ObservableJust(T t) {
        this.f61631a = t;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super T> observer) {
        ObservableScalarXMap.ScalarDisposable scalarDisposable = new ObservableScalarXMap.ScalarDisposable(observer, this.f61631a);
        observer.onSubscribe(scalarDisposable);
        scalarDisposable.run();
    }

    public T call() {
        return this.f61631a;
    }
}
