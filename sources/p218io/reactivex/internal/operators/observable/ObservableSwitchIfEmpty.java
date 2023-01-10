package p218io.reactivex.internal.operators.observable;

import p218io.reactivex.ObservableSource;
import p218io.reactivex.Observer;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.internal.disposables.SequentialDisposable;

/* renamed from: io.reactivex.internal.operators.observable.ObservableSwitchIfEmpty */
public final class ObservableSwitchIfEmpty<T> extends C22215a<T, T> {

    /* renamed from: a */
    final ObservableSource<? extends T> f61719a;

    public ObservableSwitchIfEmpty(ObservableSource<T> observableSource, ObservableSource<? extends T> observableSource2) {
        super(observableSource);
        this.f61719a = observableSource2;
    }

    public void subscribeActual(Observer<? super T> observer) {
        SwitchIfEmptyObserver switchIfEmptyObserver = new SwitchIfEmptyObserver(observer, this.f61719a);
        observer.onSubscribe(switchIfEmptyObserver.arbiter);
        this.source.subscribe(switchIfEmptyObserver);
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableSwitchIfEmpty$SwitchIfEmptyObserver */
    static final class SwitchIfEmptyObserver<T> implements Observer<T> {
        final SequentialDisposable arbiter = new SequentialDisposable();
        final Observer<? super T> downstream;
        boolean empty = true;
        final ObservableSource<? extends T> other;

        SwitchIfEmptyObserver(Observer<? super T> observer, ObservableSource<? extends T> observableSource) {
            this.downstream = observer;
            this.other = observableSource;
        }

        public void onSubscribe(Disposable disposable) {
            this.arbiter.update(disposable);
        }

        public void onNext(T t) {
            if (this.empty) {
                this.empty = false;
            }
            this.downstream.onNext(t);
        }

        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        public void onComplete() {
            if (this.empty) {
                this.empty = false;
                this.other.subscribe(this);
                return;
            }
            this.downstream.onComplete();
        }
    }
}
