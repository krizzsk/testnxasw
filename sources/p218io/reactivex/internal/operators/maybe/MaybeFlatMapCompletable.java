package p218io.reactivex.internal.operators.maybe;

import java.util.concurrent.atomic.AtomicReference;
import p218io.reactivex.Completable;
import p218io.reactivex.CompletableObserver;
import p218io.reactivex.CompletableSource;
import p218io.reactivex.MaybeObserver;
import p218io.reactivex.MaybeSource;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.exceptions.Exceptions;
import p218io.reactivex.functions.Function;
import p218io.reactivex.internal.disposables.DisposableHelper;
import p218io.reactivex.internal.functions.ObjectHelper;

/* renamed from: io.reactivex.internal.operators.maybe.MaybeFlatMapCompletable */
public final class MaybeFlatMapCompletable<T> extends Completable {

    /* renamed from: a */
    final MaybeSource<T> f61347a;

    /* renamed from: b */
    final Function<? super T, ? extends CompletableSource> f61348b;

    public MaybeFlatMapCompletable(MaybeSource<T> maybeSource, Function<? super T, ? extends CompletableSource> function) {
        this.f61347a = maybeSource;
        this.f61348b = function;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(CompletableObserver completableObserver) {
        FlatMapCompletableObserver flatMapCompletableObserver = new FlatMapCompletableObserver(completableObserver, this.f61348b);
        completableObserver.onSubscribe(flatMapCompletableObserver);
        this.f61347a.subscribe(flatMapCompletableObserver);
    }

    /* renamed from: io.reactivex.internal.operators.maybe.MaybeFlatMapCompletable$FlatMapCompletableObserver */
    static final class FlatMapCompletableObserver<T> extends AtomicReference<Disposable> implements CompletableObserver, MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = -2177128922851101253L;
        final CompletableObserver downstream;
        final Function<? super T, ? extends CompletableSource> mapper;

        FlatMapCompletableObserver(CompletableObserver completableObserver, Function<? super T, ? extends CompletableSource> function) {
            this.downstream = completableObserver;
            this.mapper = function;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.replace(this, disposable);
        }

        public void onSuccess(T t) {
            try {
                CompletableSource completableSource = (CompletableSource) ObjectHelper.requireNonNull(this.mapper.apply(t), "The mapper returned a null CompletableSource");
                if (!isDisposed()) {
                    completableSource.subscribe(this);
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                onError(th);
            }
        }

        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        public void onComplete() {
            this.downstream.onComplete();
        }
    }
}
