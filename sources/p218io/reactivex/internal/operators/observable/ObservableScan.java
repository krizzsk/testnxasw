package p218io.reactivex.internal.operators.observable;

import p218io.reactivex.ObservableSource;
import p218io.reactivex.Observer;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.exceptions.Exceptions;
import p218io.reactivex.functions.BiFunction;
import p218io.reactivex.internal.disposables.DisposableHelper;
import p218io.reactivex.internal.functions.ObjectHelper;
import p218io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.observable.ObservableScan */
public final class ObservableScan<T> extends C22215a<T, T> {

    /* renamed from: a */
    final BiFunction<T, T, T> f61691a;

    public ObservableScan(ObservableSource<T> observableSource, BiFunction<T, T, T> biFunction) {
        super(observableSource);
        this.f61691a = biFunction;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new ScanObserver(observer, this.f61691a));
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableScan$ScanObserver */
    static final class ScanObserver<T> implements Observer<T>, Disposable {
        final BiFunction<T, T, T> accumulator;
        boolean done;
        final Observer<? super T> downstream;
        Disposable upstream;
        T value;

        ScanObserver(Observer<? super T> observer, BiFunction<T, T, T> biFunction) {
            this.downstream = observer;
            this.accumulator = biFunction;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        public void dispose() {
            this.upstream.dispose();
        }

        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        public void onNext(T t) {
            if (!this.done) {
                Observer<? super T> observer = this.downstream;
                T t2 = this.value;
                if (t2 == null) {
                    this.value = t;
                    observer.onNext(t);
                    return;
                }
                try {
                    T requireNonNull = ObjectHelper.requireNonNull(this.accumulator.apply(t2, t), "The value returned by the accumulator is null");
                    this.value = requireNonNull;
                    observer.onNext(requireNonNull);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.upstream.dispose();
                    onError(th);
                }
            }
        }

        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.downstream.onError(th);
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.downstream.onComplete();
            }
        }
    }
}
