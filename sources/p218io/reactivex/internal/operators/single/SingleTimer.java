package p218io.reactivex.internal.operators.single;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p218io.reactivex.Scheduler;
import p218io.reactivex.Single;
import p218io.reactivex.SingleObserver;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.internal.disposables.DisposableHelper;

/* renamed from: io.reactivex.internal.operators.single.SingleTimer */
public final class SingleTimer extends Single<Long> {

    /* renamed from: a */
    final long f61941a;

    /* renamed from: b */
    final TimeUnit f61942b;

    /* renamed from: c */
    final Scheduler f61943c;

    public SingleTimer(long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.f61941a = j;
        this.f61942b = timeUnit;
        this.f61943c = scheduler;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super Long> singleObserver) {
        TimerDisposable timerDisposable = new TimerDisposable(singleObserver);
        singleObserver.onSubscribe(timerDisposable);
        timerDisposable.setFuture(this.f61943c.scheduleDirect(timerDisposable, this.f61941a, this.f61942b));
    }

    /* renamed from: io.reactivex.internal.operators.single.SingleTimer$TimerDisposable */
    static final class TimerDisposable extends AtomicReference<Disposable> implements Disposable, Runnable {
        private static final long serialVersionUID = 8465401857522493082L;
        final SingleObserver<? super Long> downstream;

        TimerDisposable(SingleObserver<? super Long> singleObserver) {
            this.downstream = singleObserver;
        }

        public void run() {
            this.downstream.onSuccess(0L);
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
