package p218io.reactivex.internal.operators.mixed;

import java.util.concurrent.atomic.AtomicReference;
import p218io.reactivex.CompletableObserver;
import p218io.reactivex.CompletableSource;
import p218io.reactivex.Observable;
import p218io.reactivex.ObservableSource;
import p218io.reactivex.Observer;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.internal.disposables.DisposableHelper;

/* renamed from: io.reactivex.internal.operators.mixed.CompletableAndThenObservable */
public final class CompletableAndThenObservable<R> extends Observable<R> {

    /* renamed from: a */
    final CompletableSource f61416a;

    /* renamed from: b */
    final ObservableSource<? extends R> f61417b;

    public CompletableAndThenObservable(CompletableSource completableSource, ObservableSource<? extends R> observableSource) {
        this.f61416a = completableSource;
        this.f61417b = observableSource;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super R> observer) {
        AndThenObservableObserver andThenObservableObserver = new AndThenObservableObserver(observer, this.f61417b);
        observer.onSubscribe(andThenObservableObserver);
        this.f61416a.subscribe(andThenObservableObserver);
    }

    /* renamed from: io.reactivex.internal.operators.mixed.CompletableAndThenObservable$AndThenObservableObserver */
    static final class AndThenObservableObserver<R> extends AtomicReference<Disposable> implements CompletableObserver, Observer<R>, Disposable {
        private static final long serialVersionUID = -8948264376121066672L;
        final Observer<? super R> downstream;
        ObservableSource<? extends R> other;

        AndThenObservableObserver(Observer<? super R> observer, ObservableSource<? extends R> observableSource) {
            this.other = observableSource;
            this.downstream = observer;
        }

        public void onNext(R r) {
            this.downstream.onNext(r);
        }

        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        public void onComplete() {
            ObservableSource<? extends R> observableSource = this.other;
            if (observableSource == null) {
                this.downstream.onComplete();
                return;
            }
            this.other = null;
            observableSource.subscribe(this);
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.replace(this, disposable);
        }
    }
}
