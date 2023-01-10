package p218io.reactivex.internal.operators.observable;

import p218io.reactivex.Observable;
import p218io.reactivex.Observer;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.functions.Action;
import p218io.reactivex.functions.Consumer;
import p218io.reactivex.internal.observers.DisposableLambdaObserver;

/* renamed from: io.reactivex.internal.operators.observable.ObservableDoOnLifecycle */
public final class ObservableDoOnLifecycle<T> extends C22215a<T, T> {

    /* renamed from: a */
    private final Consumer<? super Disposable> f61568a;

    /* renamed from: b */
    private final Action f61569b;

    public ObservableDoOnLifecycle(Observable<T> observable, Consumer<? super Disposable> consumer, Action action) {
        super(observable);
        this.f61568a = consumer;
        this.f61569b = action;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new DisposableLambdaObserver(observer, this.f61568a, this.f61569b));
    }
}
