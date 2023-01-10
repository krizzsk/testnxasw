package p218io.reactivex.internal.operators.observable;

import p218io.reactivex.ObservableOperator;
import p218io.reactivex.ObservableSource;
import p218io.reactivex.Observer;
import p218io.reactivex.exceptions.Exceptions;
import p218io.reactivex.internal.functions.ObjectHelper;
import p218io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.observable.ObservableLift */
public final class ObservableLift<R, T> extends C22215a<T, R> {

    /* renamed from: a */
    final ObservableOperator<? extends R, ? super T> f61635a;

    public ObservableLift(ObservableSource<T> observableSource, ObservableOperator<? extends R, ? super T> observableOperator) {
        super(observableSource);
        this.f61635a = observableOperator;
    }

    public void subscribeActual(Observer<? super R> observer) {
        try {
            Observer<? super Object> apply = this.f61635a.apply(observer);
            this.source.subscribe((Observer) ObjectHelper.requireNonNull(apply, "Operator " + this.f61635a + " returned a null Observer"));
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }
}
