package p218io.reactivex.internal.operators.maybe;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p218io.reactivex.Maybe;
import p218io.reactivex.MaybeObserver;
import p218io.reactivex.Scheduler;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.internal.disposables.DisposableHelper;

/* renamed from: io.reactivex.internal.operators.maybe.MaybeTimer */
public final class MaybeTimer extends Maybe<Long> {

    /* renamed from: a */
    final long f61399a;

    /* renamed from: b */
    final TimeUnit f61400b;

    /* renamed from: c */
    final Scheduler f61401c;

    public MaybeTimer(long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.f61399a = j;
        this.f61400b = timeUnit;
        this.f61401c = scheduler;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(MaybeObserver<? super Long> maybeObserver) {
        TimerDisposable timerDisposable = new TimerDisposable(maybeObserver);
        maybeObserver.onSubscribe(timerDisposable);
        timerDisposable.setFuture(this.f61401c.scheduleDirect(timerDisposable, this.f61399a, this.f61400b));
    }

    /* renamed from: io.reactivex.internal.operators.maybe.MaybeTimer$TimerDisposable */
    static final class TimerDisposable extends AtomicReference<Disposable> implements Disposable, Runnable {
        private static final long serialVersionUID = 2875964065294031672L;
        final MaybeObserver<? super Long> downstream;

        TimerDisposable(MaybeObserver<? super Long> maybeObserver) {
            this.downstream = maybeObserver;
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
