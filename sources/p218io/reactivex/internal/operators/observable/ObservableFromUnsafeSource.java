package p218io.reactivex.internal.operators.observable;

import p218io.reactivex.Observable;
import p218io.reactivex.ObservableSource;
import p218io.reactivex.Observer;

/* renamed from: io.reactivex.internal.operators.observable.ObservableFromUnsafeSource */
public final class ObservableFromUnsafeSource<T> extends Observable<T> {

    /* renamed from: a */
    final ObservableSource<T> f61603a;

    public ObservableFromUnsafeSource(ObservableSource<T> observableSource) {
        this.f61603a = observableSource;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super T> observer) {
        this.f61603a.subscribe(observer);
    }
}
