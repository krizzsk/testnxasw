package p218io.reactivex.internal.operators.single;

import java.util.concurrent.Callable;
import p218io.reactivex.Single;
import p218io.reactivex.SingleObserver;
import p218io.reactivex.SingleSource;
import p218io.reactivex.exceptions.Exceptions;
import p218io.reactivex.internal.disposables.EmptyDisposable;
import p218io.reactivex.internal.functions.ObjectHelper;

/* renamed from: io.reactivex.internal.operators.single.SingleDefer */
public final class SingleDefer<T> extends Single<T> {

    /* renamed from: a */
    final Callable<? extends SingleSource<? extends T>> f61862a;

    public SingleDefer(Callable<? extends SingleSource<? extends T>> callable) {
        this.f61862a = callable;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        try {
            ((SingleSource) ObjectHelper.requireNonNull(this.f61862a.call(), "The singleSupplier returned a null SingleSource")).subscribe(singleObserver);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, (SingleObserver<?>) singleObserver);
        }
    }
}
