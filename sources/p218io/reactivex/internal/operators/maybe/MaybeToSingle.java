package p218io.reactivex.internal.operators.maybe;

import java.util.NoSuchElementException;
import p218io.reactivex.MaybeObserver;
import p218io.reactivex.MaybeSource;
import p218io.reactivex.Single;
import p218io.reactivex.SingleObserver;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.internal.disposables.DisposableHelper;
import p218io.reactivex.internal.fuseable.HasUpstreamMaybeSource;

/* renamed from: io.reactivex.internal.operators.maybe.MaybeToSingle */
public final class MaybeToSingle<T> extends Single<T> implements HasUpstreamMaybeSource<T> {

    /* renamed from: a */
    final MaybeSource<T> f61404a;

    /* renamed from: b */
    final T f61405b;

    public MaybeToSingle(MaybeSource<T> maybeSource, T t) {
        this.f61404a = maybeSource;
        this.f61405b = t;
    }

    public MaybeSource<T> source() {
        return this.f61404a;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f61404a.subscribe(new ToSingleMaybeSubscriber(singleObserver, this.f61405b));
    }

    /* renamed from: io.reactivex.internal.operators.maybe.MaybeToSingle$ToSingleMaybeSubscriber */
    static final class ToSingleMaybeSubscriber<T> implements MaybeObserver<T>, Disposable {
        final T defaultValue;
        final SingleObserver<? super T> downstream;
        Disposable upstream;

        ToSingleMaybeSubscriber(SingleObserver<? super T> singleObserver, T t) {
            this.downstream = singleObserver;
            this.defaultValue = t;
        }

        public void dispose() {
            this.upstream.dispose();
            this.upstream = DisposableHelper.DISPOSED;
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
            this.upstream = DisposableHelper.DISPOSED;
            this.downstream.onSuccess(t);
        }

        public void onError(Throwable th) {
            this.upstream = DisposableHelper.DISPOSED;
            this.downstream.onError(th);
        }

        public void onComplete() {
            this.upstream = DisposableHelper.DISPOSED;
            T t = this.defaultValue;
            if (t != null) {
                this.downstream.onSuccess(t);
            } else {
                this.downstream.onError(new NoSuchElementException("The MaybeSource is empty"));
            }
        }
    }
}
