package p218io.reactivex.internal.operators.single;

import p218io.reactivex.Single;
import p218io.reactivex.SingleObserver;
import p218io.reactivex.SingleSource;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.exceptions.Exceptions;
import p218io.reactivex.functions.Action;
import p218io.reactivex.internal.disposables.DisposableHelper;
import p218io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.single.SingleDoAfterTerminate */
public final class SingleDoAfterTerminate<T> extends Single<T> {

    /* renamed from: a */
    final SingleSource<T> f61883a;

    /* renamed from: b */
    final Action f61884b;

    public SingleDoAfterTerminate(SingleSource<T> singleSource, Action action) {
        this.f61883a = singleSource;
        this.f61884b = action;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f61883a.subscribe(new DoAfterTerminateObserver(singleObserver, this.f61884b));
    }

    /* renamed from: io.reactivex.internal.operators.single.SingleDoAfterTerminate$DoAfterTerminateObserver */
    static final class DoAfterTerminateObserver<T> implements SingleObserver<T>, Disposable {
        final SingleObserver<? super T> downstream;
        final Action onAfterTerminate;
        Disposable upstream;

        DoAfterTerminateObserver(SingleObserver<? super T> singleObserver, Action action) {
            this.downstream = singleObserver;
            this.onAfterTerminate = action;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        public void onSuccess(T t) {
            this.downstream.onSuccess(t);
            onAfterTerminate();
        }

        public void onError(Throwable th) {
            this.downstream.onError(th);
            onAfterTerminate();
        }

        public void dispose() {
            this.upstream.dispose();
        }

        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        private void onAfterTerminate() {
            try {
                this.onAfterTerminate.run();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
        }
    }
}
