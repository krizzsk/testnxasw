package p218io.reactivex.internal.operators.completable;

import p218io.reactivex.CompletableObserver;
import p218io.reactivex.CompletableSource;
import p218io.reactivex.Observable;
import p218io.reactivex.Observer;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.internal.disposables.DisposableHelper;
import p218io.reactivex.internal.observers.BasicQueueDisposable;

/* renamed from: io.reactivex.internal.operators.completable.CompletableToObservable */
public final class CompletableToObservable<T> extends Observable<T> {

    /* renamed from: a */
    final CompletableSource f60928a;

    public CompletableToObservable(CompletableSource completableSource) {
        this.f60928a = completableSource;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super T> observer) {
        this.f60928a.subscribe(new ObserverCompletableObserver(observer));
    }

    /* renamed from: io.reactivex.internal.operators.completable.CompletableToObservable$ObserverCompletableObserver */
    static final class ObserverCompletableObserver extends BasicQueueDisposable<Void> implements CompletableObserver {
        final Observer<?> observer;
        Disposable upstream;

        public void clear() {
        }

        public boolean isEmpty() {
            return true;
        }

        public Void poll() throws Exception {
            return null;
        }

        public int requestFusion(int i) {
            return i & 2;
        }

        ObserverCompletableObserver(Observer<?> observer2) {
            this.observer = observer2;
        }

        public void onComplete() {
            this.observer.onComplete();
        }

        public void onError(Throwable th) {
            this.observer.onError(th);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.observer.onSubscribe(this);
            }
        }

        public void dispose() {
            this.upstream.dispose();
        }

        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }
    }
}
