package p218io.reactivex.internal.operators.completable;

import p218io.reactivex.Completable;
import p218io.reactivex.CompletableObserver;
import p218io.reactivex.CompletableSource;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.internal.disposables.DisposableHelper;

/* renamed from: io.reactivex.internal.operators.completable.CompletableDetach */
public final class CompletableDetach extends Completable {

    /* renamed from: a */
    final CompletableSource f60873a;

    public CompletableDetach(CompletableSource completableSource) {
        this.f60873a = completableSource;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(CompletableObserver completableObserver) {
        this.f60873a.subscribe(new DetachCompletableObserver(completableObserver));
    }

    /* renamed from: io.reactivex.internal.operators.completable.CompletableDetach$DetachCompletableObserver */
    static final class DetachCompletableObserver implements CompletableObserver, Disposable {
        CompletableObserver downstream;
        Disposable upstream;

        DetachCompletableObserver(CompletableObserver completableObserver) {
            this.downstream = completableObserver;
        }

        public void dispose() {
            this.downstream = null;
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

        public void onError(Throwable th) {
            this.upstream = DisposableHelper.DISPOSED;
            CompletableObserver completableObserver = this.downstream;
            if (completableObserver != null) {
                this.downstream = null;
                completableObserver.onError(th);
            }
        }

        public void onComplete() {
            this.upstream = DisposableHelper.DISPOSED;
            CompletableObserver completableObserver = this.downstream;
            if (completableObserver != null) {
                this.downstream = null;
                completableObserver.onComplete();
            }
        }
    }
}
