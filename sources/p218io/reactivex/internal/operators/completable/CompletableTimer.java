package p218io.reactivex.internal.operators.completable;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p218io.reactivex.Completable;
import p218io.reactivex.CompletableObserver;
import p218io.reactivex.Scheduler;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.internal.disposables.DisposableHelper;

/* renamed from: io.reactivex.internal.operators.completable.CompletableTimer */
public final class CompletableTimer extends Completable {

    /* renamed from: a */
    final long f60924a;

    /* renamed from: b */
    final TimeUnit f60925b;

    /* renamed from: c */
    final Scheduler f60926c;

    public CompletableTimer(long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.f60924a = j;
        this.f60925b = timeUnit;
        this.f60926c = scheduler;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(CompletableObserver completableObserver) {
        TimerDisposable timerDisposable = new TimerDisposable(completableObserver);
        completableObserver.onSubscribe(timerDisposable);
        timerDisposable.setFuture(this.f60926c.scheduleDirect(timerDisposable, this.f60924a, this.f60925b));
    }

    /* renamed from: io.reactivex.internal.operators.completable.CompletableTimer$TimerDisposable */
    static final class TimerDisposable extends AtomicReference<Disposable> implements Disposable, Runnable {
        private static final long serialVersionUID = 3167244060586201109L;
        final CompletableObserver downstream;

        TimerDisposable(CompletableObserver completableObserver) {
            this.downstream = completableObserver;
        }

        public void run() {
            this.downstream.onComplete();
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        /* access modifiers changed from: package-private */
        public void setFuture(Disposable disposable) {
            DisposableHelper.replace(this, disposable);
        }
    }
}
