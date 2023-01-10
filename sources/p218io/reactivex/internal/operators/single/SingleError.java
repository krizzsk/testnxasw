package p218io.reactivex.internal.operators.single;

import java.util.concurrent.Callable;
import p218io.reactivex.Single;
import p218io.reactivex.SingleObserver;
import p218io.reactivex.exceptions.Exceptions;
import p218io.reactivex.internal.disposables.EmptyDisposable;
import p218io.reactivex.internal.functions.ObjectHelper;

/* renamed from: io.reactivex.internal.operators.single.SingleError */
public final class SingleError<T> extends Single<T> {

    /* renamed from: a */
    final Callable<? extends Throwable> f61899a;

    public SingleError(Callable<? extends Throwable> callable) {
        this.f61899a = callable;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        try {
            th = (Throwable) ObjectHelper.requireNonNull(this.f61899a.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th) {
            th = th;
            Exceptions.throwIfFatal(th);
        }
        EmptyDisposable.error(th, (SingleObserver<?>) singleObserver);
    }
}
