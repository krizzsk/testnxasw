package p218io.reactivex.internal.operators.completable;

import java.util.concurrent.Callable;
import p218io.reactivex.CompletableObserver;
import p218io.reactivex.CompletableSource;
import p218io.reactivex.Single;
import p218io.reactivex.SingleObserver;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.exceptions.Exceptions;

/* renamed from: io.reactivex.internal.operators.completable.CompletableToSingle */
public final class CompletableToSingle<T> extends Single<T> {

    /* renamed from: a */
    final CompletableSource f60929a;

    /* renamed from: b */
    final Callable<? extends T> f60930b;

    /* renamed from: c */
    final T f60931c;

    public CompletableToSingle(CompletableSource completableSource, Callable<? extends T> callable, T t) {
        this.f60929a = completableSource;
        this.f60931c = t;
        this.f60930b = callable;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f60929a.subscribe(new ToSingle(singleObserver));
    }

    /* renamed from: io.reactivex.internal.operators.completable.CompletableToSingle$ToSingle */
    final class ToSingle implements CompletableObserver {
        private final SingleObserver<? super T> observer;

        ToSingle(SingleObserver<? super T> singleObserver) {
            this.observer = singleObserver;
        }

        public void onComplete() {
            T t;
            if (CompletableToSingle.this.f60930b != null) {
                try {
                    t = CompletableToSingle.this.f60930b.call();
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.observer.onError(th);
                    return;
                }
            } else {
                t = CompletableToSingle.this.f60931c;
            }
            if (t == null) {
                this.observer.onError(new NullPointerException("The value supplied is null"));
            } else {
                this.observer.onSuccess(t);
            }
        }

        public void onError(Throwable th) {
            this.observer.onError(th);
        }

        public void onSubscribe(Disposable disposable) {
            this.observer.onSubscribe(disposable);
        }
    }
}
