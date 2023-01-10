package p218io.reactivex.internal.operators.completable;

import p218io.reactivex.Completable;
import p218io.reactivex.CompletableObserver;
import p218io.reactivex.CompletableOperator;
import p218io.reactivex.CompletableSource;
import p218io.reactivex.exceptions.Exceptions;
import p218io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.completable.CompletableLift */
public final class CompletableLift extends Completable {

    /* renamed from: a */
    final CompletableSource f60892a;

    /* renamed from: b */
    final CompletableOperator f60893b;

    public CompletableLift(CompletableSource completableSource, CompletableOperator completableOperator) {
        this.f60892a = completableSource;
        this.f60893b = completableOperator;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(CompletableObserver completableObserver) {
        try {
            this.f60892a.subscribe(this.f60893b.apply(completableObserver));
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
        }
    }
}
