package p218io.reactivex.internal.operators.completable;

import p218io.reactivex.Completable;
import p218io.reactivex.CompletableObserver;
import p218io.reactivex.SingleObserver;
import p218io.reactivex.SingleSource;
import p218io.reactivex.disposables.Disposable;

/* renamed from: io.reactivex.internal.operators.completable.CompletableFromSingle */
public final class CompletableFromSingle<T> extends Completable {

    /* renamed from: a */
    final SingleSource<T> f60888a;

    public CompletableFromSingle(SingleSource<T> singleSource) {
        this.f60888a = singleSource;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(CompletableObserver completableObserver) {
        this.f60888a.subscribe(new CompletableFromSingleObserver(completableObserver));
    }

    /* renamed from: io.reactivex.internal.operators.completable.CompletableFromSingle$CompletableFromSingleObserver */
    static final class CompletableFromSingleObserver<T> implements SingleObserver<T> {

        /* renamed from: co */
        final CompletableObserver f60889co;

        CompletableFromSingleObserver(CompletableObserver completableObserver) {
            this.f60889co = completableObserver;
        }

        public void onError(Throwable th) {
            this.f60889co.onError(th);
        }

        public void onSubscribe(Disposable disposable) {
            this.f60889co.onSubscribe(disposable);
        }

        public void onSuccess(T t) {
            this.f60889co.onComplete();
        }
    }
}
