package p218io.reactivex.internal.operators.maybe;

import p218io.reactivex.Maybe;
import p218io.reactivex.MaybeObserver;
import p218io.reactivex.disposables.Disposables;

/* renamed from: io.reactivex.internal.operators.maybe.MaybeError */
public final class MaybeError<T> extends Maybe<T> {

    /* renamed from: a */
    final Throwable f61340a;

    public MaybeError(Throwable th) {
        this.f61340a = th;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        maybeObserver.onSubscribe(Disposables.disposed());
        maybeObserver.onError(this.f61340a);
    }
}
