package p218io.reactivex.internal.operators.single;

import java.util.concurrent.atomic.AtomicReference;
import p218io.reactivex.Single;
import p218io.reactivex.SingleObserver;
import p218io.reactivex.SingleSource;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.exceptions.Exceptions;
import p218io.reactivex.functions.Action;
import p218io.reactivex.internal.disposables.DisposableHelper;
import p218io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.single.SingleDoOnDispose */
public final class SingleDoOnDispose<T> extends Single<T> {

    /* renamed from: a */
    final SingleSource<T> f61887a;

    /* renamed from: b */
    final Action f61888b;

    public SingleDoOnDispose(SingleSource<T> singleSource, Action action) {
        this.f61887a = singleSource;
        this.f61888b = action;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f61887a.subscribe(new DoOnDisposeObserver(singleObserver, this.f61888b));
    }

    /* renamed from: io.reactivex.internal.operators.single.SingleDoOnDispose$DoOnDisposeObserver */
    static final class DoOnDisposeObserver<T> extends AtomicReference<Action> implements SingleObserver<T>, Disposable {
        private static final long serialVersionUID = -8583764624474935784L;
        final SingleObserver<? super T> downstream;
        Disposable upstream;

        DoOnDisposeObserver(SingleObserver<? super T> singleObserver, Action action) {
            this.downstream = singleObserver;
            lazySet(action);
        }

        public void dispose() {
            Action action = (Action) getAndSet((Object) null);
            if (action != null) {
                try {
                    action.run();
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    RxJavaPlugins.onError(th);
                }
                this.upstream.dispose();
            }
        }

        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        public void onSuccess(T t) {
            this.downstream.onSuccess(t);
        }

        public void onError(Throwable th) {
            this.downstream.onError(th);
        }
    }
}
