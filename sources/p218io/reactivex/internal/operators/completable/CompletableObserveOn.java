package p218io.reactivex.internal.operators.completable;

import java.util.concurrent.atomic.AtomicReference;
import p218io.reactivex.Completable;
import p218io.reactivex.CompletableObserver;
import p218io.reactivex.CompletableSource;
import p218io.reactivex.Scheduler;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.internal.disposables.DisposableHelper;

/* renamed from: io.reactivex.internal.operators.completable.CompletableObserveOn */
public final class CompletableObserveOn extends Completable {

    /* renamed from: a */
    final CompletableSource f60902a;

    /* renamed from: b */
    final Scheduler f60903b;

    public CompletableObserveOn(CompletableSource completableSource, Scheduler scheduler) {
        this.f60902a = completableSource;
        this.f60903b = scheduler;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(CompletableObserver completableObserver) {
        this.f60902a.subscribe(new ObserveOnCompletableObserver(completableObserver, this.f60903b));
    }

    /* renamed from: io.reactivex.internal.operators.completable.CompletableObserveOn$ObserveOnCompletableObserver */
    static final class ObserveOnCompletableObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable, Runnable {
        private static final long serialVersionUID = 8571289934935992137L;
        final CompletableObserver downstream;
        Throwable error;
        final Scheduler scheduler;

        ObserveOnCompletableObserver(CompletableObserver completableObserver, Scheduler scheduler2) {
            this.downstream = completableObserver;
            this.scheduler = scheduler2;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                this.downstream.onSubscribe(this);
            }
        }

        public void onError(Throwable th) {
            this.error = th;
            DisposableHelper.replace(this, this.scheduler.scheduleDirect(this));
        }

        public void onComplete() {
            DisposableHelper.replace(this, this.scheduler.scheduleDirect(this));
        }

        public void run() {
            Throwable th = this.error;
            if (th != null) {
                this.error = null;
                this.downstream.onError(th);
                return;
            }
            this.downstream.onComplete();
        }
    }
}
