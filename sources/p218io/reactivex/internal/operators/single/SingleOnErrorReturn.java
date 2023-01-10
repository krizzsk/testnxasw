package p218io.reactivex.internal.operators.single;

import p218io.reactivex.Single;
import p218io.reactivex.SingleObserver;
import p218io.reactivex.SingleSource;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.exceptions.CompositeException;
import p218io.reactivex.exceptions.Exceptions;
import p218io.reactivex.functions.Function;

/* renamed from: io.reactivex.internal.operators.single.SingleOnErrorReturn */
public final class SingleOnErrorReturn<T> extends Single<T> {

    /* renamed from: a */
    final SingleSource<? extends T> f61927a;

    /* renamed from: b */
    final Function<? super Throwable, ? extends T> f61928b;

    /* renamed from: c */
    final T f61929c;

    public SingleOnErrorReturn(SingleSource<? extends T> singleSource, Function<? super Throwable, ? extends T> function, T t) {
        this.f61927a = singleSource;
        this.f61928b = function;
        this.f61929c = t;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f61927a.subscribe(new OnErrorReturn(singleObserver));
    }

    /* renamed from: io.reactivex.internal.operators.single.SingleOnErrorReturn$OnErrorReturn */
    final class OnErrorReturn implements SingleObserver<T> {
        private final SingleObserver<? super T> observer;

        OnErrorReturn(SingleObserver<? super T> singleObserver) {
            this.observer = singleObserver;
        }

        public void onError(Throwable th) {
            T t;
            if (SingleOnErrorReturn.this.f61928b != null) {
                try {
                    t = SingleOnErrorReturn.this.f61928b.apply(th);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.observer.onError(new CompositeException(th, th2));
                    return;
                }
            } else {
                t = SingleOnErrorReturn.this.f61929c;
            }
            if (t == null) {
                NullPointerException nullPointerException = new NullPointerException("Value supplied was null");
                nullPointerException.initCause(th);
                this.observer.onError(nullPointerException);
                return;
            }
            this.observer.onSuccess(t);
        }

        public void onSubscribe(Disposable disposable) {
            this.observer.onSubscribe(disposable);
        }

        public void onSuccess(T t) {
            this.observer.onSuccess(t);
        }
    }
}
