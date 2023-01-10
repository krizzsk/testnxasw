package p218io.reactivex.internal.operators.observable;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p218io.reactivex.Observable;
import p218io.reactivex.Observer;
import p218io.reactivex.Scheduler;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.internal.disposables.DisposableHelper;
import p218io.reactivex.internal.disposables.EmptyDisposable;

/* renamed from: io.reactivex.internal.operators.observable.ObservableTimer */
public final class ObservableTimer extends Observable<Long> {

    /* renamed from: a */
    final Scheduler f61750a;

    /* renamed from: b */
    final long f61751b;

    /* renamed from: c */
    final TimeUnit f61752c;

    public ObservableTimer(long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.f61751b = j;
        this.f61752c = timeUnit;
        this.f61750a = scheduler;
    }

    public void subscribeActual(Observer<? super Long> observer) {
        TimerObserver timerObserver = new TimerObserver(observer);
        observer.onSubscribe(timerObserver);
        timerObserver.setResource(this.f61750a.scheduleDirect(timerObserver, this.f61751b, this.f61752c));
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableTimer$TimerObserver */
    static final class TimerObserver extends AtomicReference<Disposable> implements Disposable, Runnable {
        private static final long serialVersionUID = -2809475196591179431L;
        final Observer<? super Long> downstream;

        TimerObserver(Observer<? super Long> observer) {
            this.downstream = observer;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return get() == DisposableHelper.DISPOSED;
        }

        public void run() {
            if (!isDisposed()) {
                this.downstream.onNext(0L);
                lazySet(EmptyDisposable.INSTANCE);
                this.downstream.onComplete();
            }
        }

        public void setResource(Disposable disposable) {
            DisposableHelper.trySet(this, disposable);
        }
    }
}
