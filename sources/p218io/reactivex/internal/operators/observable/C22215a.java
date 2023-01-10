package p218io.reactivex.internal.operators.observable;

import p218io.reactivex.Observable;
import p218io.reactivex.ObservableSource;
import p218io.reactivex.internal.fuseable.HasUpstreamObservableSource;

/* renamed from: io.reactivex.internal.operators.observable.a */
/* compiled from: AbstractObservableWithUpstream */
abstract class C22215a<T, U> extends Observable<U> implements HasUpstreamObservableSource<T> {
    protected final ObservableSource<T> source;

    C22215a(ObservableSource<T> observableSource) {
        this.source = observableSource;
    }

    public final ObservableSource<T> source() {
        return this.source;
    }
}
