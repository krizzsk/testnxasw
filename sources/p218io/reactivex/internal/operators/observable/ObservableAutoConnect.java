package p218io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicInteger;
import p218io.reactivex.Observable;
import p218io.reactivex.Observer;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.functions.Consumer;
import p218io.reactivex.observables.ConnectableObservable;

/* renamed from: io.reactivex.internal.operators.observable.ObservableAutoConnect */
public final class ObservableAutoConnect<T> extends Observable<T> {

    /* renamed from: a */
    final ConnectableObservable<? extends T> f61484a;

    /* renamed from: b */
    final int f61485b;

    /* renamed from: c */
    final Consumer<? super Disposable> f61486c;

    /* renamed from: d */
    final AtomicInteger f61487d = new AtomicInteger();

    public ObservableAutoConnect(ConnectableObservable<? extends T> connectableObservable, int i, Consumer<? super Disposable> consumer) {
        this.f61484a = connectableObservable;
        this.f61485b = i;
        this.f61486c = consumer;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f61484a.subscribe(observer);
        if (this.f61487d.incrementAndGet() == this.f61485b) {
            this.f61484a.connect(this.f61486c);
        }
    }
}
