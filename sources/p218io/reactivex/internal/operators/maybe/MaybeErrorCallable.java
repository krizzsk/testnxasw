package p218io.reactivex.internal.operators.maybe;

import java.util.concurrent.Callable;
import p218io.reactivex.Maybe;
import p218io.reactivex.MaybeObserver;
import p218io.reactivex.disposables.Disposables;
import p218io.reactivex.exceptions.Exceptions;
import p218io.reactivex.internal.functions.ObjectHelper;

/* renamed from: io.reactivex.internal.operators.maybe.MaybeErrorCallable */
public final class MaybeErrorCallable<T> extends Maybe<T> {

    /* renamed from: a */
    final Callable<? extends Throwable> f61341a;

    public MaybeErrorCallable(Callable<? extends Throwable> callable) {
        this.f61341a = callable;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        maybeObserver.onSubscribe(Disposables.disposed());
        try {
            th = (Throwable) ObjectHelper.requireNonNull(this.f61341a.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th) {
            th = th;
            Exceptions.throwIfFatal(th);
        }
        maybeObserver.onError(th);
    }
}
