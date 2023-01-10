package p218io.reactivex.internal.operators.observable;

import java.util.concurrent.Callable;
import p218io.reactivex.ObservableSource;
import p218io.reactivex.Single;
import p218io.reactivex.SingleObserver;
import p218io.reactivex.exceptions.Exceptions;
import p218io.reactivex.functions.BiFunction;
import p218io.reactivex.internal.disposables.EmptyDisposable;
import p218io.reactivex.internal.functions.ObjectHelper;
import p218io.reactivex.internal.operators.observable.ObservableReduceSeedSingle;

/* renamed from: io.reactivex.internal.operators.observable.ObservableReduceWithSingle */
public final class ObservableReduceWithSingle<T, R> extends Single<R> {

    /* renamed from: a */
    final ObservableSource<T> f61662a;

    /* renamed from: b */
    final Callable<R> f61663b;

    /* renamed from: c */
    final BiFunction<R, ? super T, R> f61664c;

    public ObservableReduceWithSingle(ObservableSource<T> observableSource, Callable<R> callable, BiFunction<R, ? super T, R> biFunction) {
        this.f61662a = observableSource;
        this.f61663b = callable;
        this.f61664c = biFunction;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super R> singleObserver) {
        try {
            this.f61662a.subscribe(new ObservableReduceSeedSingle.ReduceSeedObserver(singleObserver, this.f61664c, ObjectHelper.requireNonNull(this.f61663b.call(), "The seedSupplier returned a null value")));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, (SingleObserver<?>) singleObserver);
        }
    }
}
