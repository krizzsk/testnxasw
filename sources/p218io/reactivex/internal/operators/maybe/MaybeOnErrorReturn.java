package p218io.reactivex.internal.operators.maybe;

import p218io.reactivex.MaybeObserver;
import p218io.reactivex.MaybeSource;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.exceptions.CompositeException;
import p218io.reactivex.exceptions.Exceptions;
import p218io.reactivex.functions.Function;
import p218io.reactivex.internal.disposables.DisposableHelper;
import p218io.reactivex.internal.functions.ObjectHelper;

/* renamed from: io.reactivex.internal.operators.maybe.MaybeOnErrorReturn */
public final class MaybeOnErrorReturn<T> extends C22213a<T, T> {

    /* renamed from: a */
    final Function<? super Throwable, ? extends T> f61382a;

    public MaybeOnErrorReturn(MaybeSource<T> maybeSource, Function<? super Throwable, ? extends T> function) {
        super(maybeSource);
        this.f61382a = function;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe(new OnErrorReturnMaybeObserver(maybeObserver, this.f61382a));
    }

    /* renamed from: io.reactivex.internal.operators.maybe.MaybeOnErrorReturn$OnErrorReturnMaybeObserver */
    static final class OnErrorReturnMaybeObserver<T> implements MaybeObserver<T>, Disposable {
        final MaybeObserver<? super T> downstream;
        Disposable upstream;
        final Function<? super Throwable, ? extends T> valueSupplier;

        OnErrorReturnMaybeObserver(MaybeObserver<? super T> maybeObserver, Function<? super Throwable, ? extends T> function) {
            this.downstream = maybeObserver;
            this.valueSupplier = function;
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
            this.downstream.onSuccess(t);
        }

        public void onError(Throwable th) {
            try {
                this.downstream.onSuccess(ObjectHelper.requireNonNull(this.valueSupplier.apply(th), "The valueSupplier returned a null value"));
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.downstream.onError(new CompositeException(th, th2));
            }
        }

        public void onComplete() {
            this.downstream.onComplete();
        }
    }
}
