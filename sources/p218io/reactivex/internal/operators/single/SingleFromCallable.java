package p218io.reactivex.internal.operators.single;

import java.util.concurrent.Callable;
import p218io.reactivex.Single;
import p218io.reactivex.SingleObserver;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.disposables.Disposables;
import p218io.reactivex.exceptions.Exceptions;
import p218io.reactivex.internal.functions.ObjectHelper;
import p218io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.single.SingleFromCallable */
public final class SingleFromCallable<T> extends Single<T> {

    /* renamed from: a */
    final Callable<? extends T> f61914a;

    public SingleFromCallable(Callable<? extends T> callable) {
        this.f61914a = callable;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        Disposable empty = Disposables.empty();
        singleObserver.onSubscribe(empty);
        if (!empty.isDisposed()) {
            try {
                Object requireNonNull = ObjectHelper.requireNonNull(this.f61914a.call(), "The callable returned a null value");
                if (!empty.isDisposed()) {
                    singleObserver.onSuccess(requireNonNull);
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                if (!empty.isDisposed()) {
                    singleObserver.onError(th);
                } else {
                    RxJavaPlugins.onError(th);
                }
            }
        }
    }
}
