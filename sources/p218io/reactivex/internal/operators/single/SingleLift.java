package p218io.reactivex.internal.operators.single;

import p218io.reactivex.Single;
import p218io.reactivex.SingleObserver;
import p218io.reactivex.SingleOperator;
import p218io.reactivex.SingleSource;
import p218io.reactivex.exceptions.Exceptions;
import p218io.reactivex.internal.disposables.EmptyDisposable;
import p218io.reactivex.internal.functions.ObjectHelper;

/* renamed from: io.reactivex.internal.operators.single.SingleLift */
public final class SingleLift<T, R> extends Single<R> {

    /* renamed from: a */
    final SingleSource<T> f61919a;

    /* renamed from: b */
    final SingleOperator<? extends R, ? super T> f61920b;

    public SingleLift(SingleSource<T> singleSource, SingleOperator<? extends R, ? super T> singleOperator) {
        this.f61919a = singleSource;
        this.f61920b = singleOperator;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super R> singleObserver) {
        try {
            this.f61919a.subscribe((SingleObserver) ObjectHelper.requireNonNull(this.f61920b.apply(singleObserver), "The onLift returned a null SingleObserver"));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, (SingleObserver<?>) singleObserver);
        }
    }
}
