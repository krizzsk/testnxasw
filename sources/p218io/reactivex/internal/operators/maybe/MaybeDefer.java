package p218io.reactivex.internal.operators.maybe;

import java.util.concurrent.Callable;
import p218io.reactivex.Maybe;
import p218io.reactivex.MaybeObserver;
import p218io.reactivex.MaybeSource;
import p218io.reactivex.exceptions.Exceptions;
import p218io.reactivex.internal.disposables.EmptyDisposable;
import p218io.reactivex.internal.functions.ObjectHelper;

/* renamed from: io.reactivex.internal.operators.maybe.MaybeDefer */
public final class MaybeDefer<T> extends Maybe<T> {

    /* renamed from: a */
    final Callable<? extends MaybeSource<? extends T>> f61326a;

    public MaybeDefer(Callable<? extends MaybeSource<? extends T>> callable) {
        this.f61326a = callable;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        try {
            ((MaybeSource) ObjectHelper.requireNonNull(this.f61326a.call(), "The maybeSupplier returned a null MaybeSource")).subscribe(maybeObserver);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, (MaybeObserver<?>) maybeObserver);
        }
    }
}
