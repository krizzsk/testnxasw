package p218io.reactivex.internal.operators.single;

import p218io.reactivex.Maybe;
import p218io.reactivex.MaybeObserver;
import p218io.reactivex.Notification;
import p218io.reactivex.Single;
import p218io.reactivex.SingleObserver;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.exceptions.Exceptions;
import p218io.reactivex.functions.Function;
import p218io.reactivex.internal.disposables.DisposableHelper;
import p218io.reactivex.internal.functions.ObjectHelper;

/* renamed from: io.reactivex.internal.operators.single.SingleDematerialize */
public final class SingleDematerialize<T, R> extends Maybe<R> {

    /* renamed from: a */
    final Single<T> f61878a;

    /* renamed from: b */
    final Function<? super T, Notification<R>> f61879b;

    public SingleDematerialize(Single<T> single, Function<? super T, Notification<R>> function) {
        this.f61878a = single;
        this.f61879b = function;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(MaybeObserver<? super R> maybeObserver) {
        this.f61878a.subscribe(new DematerializeObserver(maybeObserver, this.f61879b));
    }

    /* renamed from: io.reactivex.internal.operators.single.SingleDematerialize$DematerializeObserver */
    static final class DematerializeObserver<T, R> implements SingleObserver<T>, Disposable {
        final MaybeObserver<? super R> downstream;
        final Function<? super T, Notification<R>> selector;
        Disposable upstream;

        DematerializeObserver(MaybeObserver<? super R> maybeObserver, Function<? super T, Notification<R>> function) {
            this.downstream = maybeObserver;
            this.selector = function;
        }

        public void dispose() {
            this.upstream.dispose();
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
            try {
                Notification notification = (Notification) ObjectHelper.requireNonNull(this.selector.apply(t), "The selector returned a null Notification");
                if (notification.isOnNext()) {
                    this.downstream.onSuccess(notification.getValue());
                } else if (notification.isOnComplete()) {
                    this.downstream.onComplete();
                } else {
                    this.downstream.onError(notification.getError());
                }
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
