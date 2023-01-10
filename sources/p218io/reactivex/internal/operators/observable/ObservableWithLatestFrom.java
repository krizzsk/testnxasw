package p218io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicReference;
import p218io.reactivex.ObservableSource;
import p218io.reactivex.Observer;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.exceptions.Exceptions;
import p218io.reactivex.functions.BiFunction;
import p218io.reactivex.internal.disposables.DisposableHelper;
import p218io.reactivex.internal.functions.ObjectHelper;
import p218io.reactivex.observers.SerializedObserver;

/* renamed from: io.reactivex.internal.operators.observable.ObservableWithLatestFrom */
public final class ObservableWithLatestFrom<T, U, R> extends C22215a<T, R> {

    /* renamed from: a */
    final BiFunction<? super T, ? super U, ? extends R> f61783a;

    /* renamed from: b */
    final ObservableSource<? extends U> f61784b;

    public ObservableWithLatestFrom(ObservableSource<T> observableSource, BiFunction<? super T, ? super U, ? extends R> biFunction, ObservableSource<? extends U> observableSource2) {
        super(observableSource);
        this.f61783a = biFunction;
        this.f61784b = observableSource2;
    }

    public void subscribeActual(Observer<? super R> observer) {
        SerializedObserver serializedObserver = new SerializedObserver(observer);
        WithLatestFromObserver withLatestFromObserver = new WithLatestFromObserver(serializedObserver, this.f61783a);
        serializedObserver.onSubscribe(withLatestFromObserver);
        this.f61784b.subscribe(new WithLatestFromOtherObserver(withLatestFromObserver));
        this.source.subscribe(withLatestFromObserver);
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableWithLatestFrom$WithLatestFromObserver */
    static final class WithLatestFromObserver<T, U, R> extends AtomicReference<U> implements Observer<T>, Disposable {
        private static final long serialVersionUID = -312246233408980075L;
        final BiFunction<? super T, ? super U, ? extends R> combiner;
        final Observer<? super R> downstream;
        final AtomicReference<Disposable> other = new AtomicReference<>();
        final AtomicReference<Disposable> upstream = new AtomicReference<>();

        WithLatestFromObserver(Observer<? super R> observer, BiFunction<? super T, ? super U, ? extends R> biFunction) {
            this.downstream = observer;
            this.combiner = biFunction;
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.upstream, disposable);
        }

        public void onNext(T t) {
            Object obj = get();
            if (obj != null) {
                try {
                    this.downstream.onNext(ObjectHelper.requireNonNull(this.combiner.apply(t, obj), "The combiner returned a null value"));
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    dispose();
                    this.downstream.onError(th);
                }
            }
        }

        public void onError(Throwable th) {
            DisposableHelper.dispose(this.other);
            this.downstream.onError(th);
        }

        public void onComplete() {
            DisposableHelper.dispose(this.other);
            this.downstream.onComplete();
        }

        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            DisposableHelper.dispose(this.other);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.upstream.get());
        }

        public boolean setOther(Disposable disposable) {
            return DisposableHelper.setOnce(this.other, disposable);
        }

        public void otherError(Throwable th) {
            DisposableHelper.dispose(this.upstream);
            this.downstream.onError(th);
        }
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableWithLatestFrom$WithLatestFromOtherObserver */
    final class WithLatestFromOtherObserver implements Observer<U> {
        private final WithLatestFromObserver<T, U, R> parent;

        public void onComplete() {
        }

        WithLatestFromOtherObserver(WithLatestFromObserver<T, U, R> withLatestFromObserver) {
            this.parent = withLatestFromObserver;
        }

        public void onSubscribe(Disposable disposable) {
            this.parent.setOther(disposable);
        }

        public void onNext(U u) {
            this.parent.lazySet(u);
        }

        public void onError(Throwable th) {
            this.parent.otherError(th);
        }
    }
}
