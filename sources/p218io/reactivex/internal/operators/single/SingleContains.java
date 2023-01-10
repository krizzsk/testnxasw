package p218io.reactivex.internal.operators.single;

import p218io.reactivex.Single;
import p218io.reactivex.SingleObserver;
import p218io.reactivex.SingleSource;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.exceptions.Exceptions;
import p218io.reactivex.functions.BiPredicate;

/* renamed from: io.reactivex.internal.operators.single.SingleContains */
public final class SingleContains<T> extends Single<Boolean> {

    /* renamed from: a */
    final SingleSource<T> f61858a;

    /* renamed from: b */
    final Object f61859b;

    /* renamed from: c */
    final BiPredicate<Object, Object> f61860c;

    public SingleContains(SingleSource<T> singleSource, Object obj, BiPredicate<Object, Object> biPredicate) {
        this.f61858a = singleSource;
        this.f61859b = obj;
        this.f61860c = biPredicate;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        this.f61858a.subscribe(new ContainsSingleObserver(singleObserver));
    }

    /* renamed from: io.reactivex.internal.operators.single.SingleContains$ContainsSingleObserver */
    final class ContainsSingleObserver implements SingleObserver<T> {
        private final SingleObserver<? super Boolean> downstream;

        ContainsSingleObserver(SingleObserver<? super Boolean> singleObserver) {
            this.downstream = singleObserver;
        }

        public void onSubscribe(Disposable disposable) {
            this.downstream.onSubscribe(disposable);
        }

        public void onSuccess(T t) {
            try {
                this.downstream.onSuccess(Boolean.valueOf(SingleContains.this.f61860c.test(t, SingleContains.this.f61859b)));
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.downstream.onError(th);
            }
        }

        public void onError(Throwable th) {
            this.downstream.onError(th);
        }
    }
}
