package p218io.reactivex.internal.operators.maybe;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import p218io.reactivex.Maybe;
import p218io.reactivex.MaybeObserver;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.disposables.Disposables;
import p218io.reactivex.exceptions.Exceptions;

/* renamed from: io.reactivex.internal.operators.maybe.MaybeFromFuture */
public final class MaybeFromFuture<T> extends Maybe<T> {

    /* renamed from: a */
    final Future<? extends T> f61366a;

    /* renamed from: b */
    final long f61367b;

    /* renamed from: c */
    final TimeUnit f61368c;

    public MaybeFromFuture(Future<? extends T> future, long j, TimeUnit timeUnit) {
        this.f61366a = future;
        this.f61367b = j;
        this.f61368c = timeUnit;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        Object obj;
        Disposable empty = Disposables.empty();
        maybeObserver.onSubscribe(empty);
        if (!empty.isDisposed()) {
            try {
                if (this.f61367b <= 0) {
                    obj = this.f61366a.get();
                } else {
                    obj = this.f61366a.get(this.f61367b, this.f61368c);
                }
                if (empty.isDisposed()) {
                    return;
                }
                if (obj == null) {
                    maybeObserver.onComplete();
                } else {
                    maybeObserver.onSuccess(obj);
                }
            } catch (Throwable th) {
                th = th;
                if (th instanceof ExecutionException) {
                    th = th.getCause();
                }
                Exceptions.throwIfFatal(th);
                if (!empty.isDisposed()) {
                    maybeObserver.onError(th);
                }
            }
        }
    }
}
