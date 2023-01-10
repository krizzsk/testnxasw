package p218io.reactivex.internal.operators.observable;

import p218io.reactivex.Completable;
import p218io.reactivex.CompletableObserver;
import p218io.reactivex.Observable;
import p218io.reactivex.ObservableSource;
import p218io.reactivex.Observer;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.internal.fuseable.FuseToObservable;
import p218io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.observable.ObservableIgnoreElementsCompletable */
public final class ObservableIgnoreElementsCompletable<T> extends Completable implements FuseToObservable<T> {

    /* renamed from: a */
    final ObservableSource<T> f61615a;

    public ObservableIgnoreElementsCompletable(ObservableSource<T> observableSource) {
        this.f61615a = observableSource;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        this.f61615a.subscribe(new IgnoreObservable(completableObserver));
    }

    public Observable<T> fuseToObservable() {
        return RxJavaPlugins.onAssembly(new ObservableIgnoreElements(this.f61615a));
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableIgnoreElementsCompletable$IgnoreObservable */
    static final class IgnoreObservable<T> implements Observer<T>, Disposable {
        final CompletableObserver downstream;
        Disposable upstream;

        public void onNext(T t) {
        }

        IgnoreObservable(CompletableObserver completableObserver) {
            this.downstream = completableObserver;
        }

        public void onSubscribe(Disposable disposable) {
            this.upstream = disposable;
            this.downstream.onSubscribe(this);
        }

        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        public void onComplete() {
            this.downstream.onComplete();
        }

        public void dispose() {
            this.upstream.dispose();
        }

        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }
    }
}
