package p218io.reactivex.internal.operators.completable;

import p218io.reactivex.Completable;
import p218io.reactivex.CompletableObserver;
import p218io.reactivex.ObservableSource;
import p218io.reactivex.Observer;
import p218io.reactivex.disposables.Disposable;

/* renamed from: io.reactivex.internal.operators.completable.CompletableFromObservable */
public final class CompletableFromObservable<T> extends Completable {

    /* renamed from: a */
    final ObservableSource<T> f60884a;

    public CompletableFromObservable(ObservableSource<T> observableSource) {
        this.f60884a = observableSource;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(CompletableObserver completableObserver) {
        this.f60884a.subscribe(new CompletableFromObservableObserver(completableObserver));
    }

    /* renamed from: io.reactivex.internal.operators.completable.CompletableFromObservable$CompletableFromObservableObserver */
    static final class CompletableFromObservableObserver<T> implements Observer<T> {

        /* renamed from: co */
        final CompletableObserver f60885co;

        public void onNext(T t) {
        }

        CompletableFromObservableObserver(CompletableObserver completableObserver) {
            this.f60885co = completableObserver;
        }

        public void onSubscribe(Disposable disposable) {
            this.f60885co.onSubscribe(disposable);
        }

        public void onError(Throwable th) {
            this.f60885co.onError(th);
        }

        public void onComplete() {
            this.f60885co.onComplete();
        }
    }
}
