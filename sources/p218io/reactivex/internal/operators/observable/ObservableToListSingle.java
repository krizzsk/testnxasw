package p218io.reactivex.internal.operators.observable;

import java.util.Collection;
import java.util.concurrent.Callable;
import p218io.reactivex.Observable;
import p218io.reactivex.ObservableSource;
import p218io.reactivex.Observer;
import p218io.reactivex.Single;
import p218io.reactivex.SingleObserver;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.exceptions.Exceptions;
import p218io.reactivex.internal.disposables.DisposableHelper;
import p218io.reactivex.internal.disposables.EmptyDisposable;
import p218io.reactivex.internal.functions.Functions;
import p218io.reactivex.internal.functions.ObjectHelper;
import p218io.reactivex.internal.fuseable.FuseToObservable;
import p218io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.observable.ObservableToListSingle */
public final class ObservableToListSingle<T, U extends Collection<? super T>> extends Single<U> implements FuseToObservable<U> {

    /* renamed from: a */
    final ObservableSource<T> f61754a;

    /* renamed from: b */
    final Callable<U> f61755b;

    public ObservableToListSingle(ObservableSource<T> observableSource, int i) {
        this.f61754a = observableSource;
        this.f61755b = Functions.createArrayList(i);
    }

    public ObservableToListSingle(ObservableSource<T> observableSource, Callable<U> callable) {
        this.f61754a = observableSource;
        this.f61755b = callable;
    }

    public void subscribeActual(SingleObserver<? super U> singleObserver) {
        try {
            this.f61754a.subscribe(new ToListObserver(singleObserver, (Collection) ObjectHelper.requireNonNull(this.f61755b.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, (SingleObserver<?>) singleObserver);
        }
    }

    public Observable<U> fuseToObservable() {
        return RxJavaPlugins.onAssembly(new ObservableToList(this.f61754a, this.f61755b));
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableToListSingle$ToListObserver */
    static final class ToListObserver<T, U extends Collection<? super T>> implements Observer<T>, Disposable {
        U collection;
        final SingleObserver<? super U> downstream;
        Disposable upstream;

        ToListObserver(SingleObserver<? super U> singleObserver, U u) {
            this.downstream = singleObserver;
            this.collection = u;
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
            this.collection.add(t);
        }

        public void onError(Throwable th) {
            this.collection = null;
            this.downstream.onError(th);
        }

        public void onComplete() {
            U u = this.collection;
            this.collection = null;
            this.downstream.onSuccess(u);
        }
    }
}
