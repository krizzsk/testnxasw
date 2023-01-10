package p218io.reactivex.internal.operators.observable;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p218io.reactivex.Observable;
import p218io.reactivex.Observer;
import p218io.reactivex.Scheduler;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.internal.disposables.DisposableHelper;
import p218io.reactivex.internal.schedulers.TrampolineScheduler;

/* renamed from: io.reactivex.internal.operators.observable.ObservableIntervalRange */
public final class ObservableIntervalRange extends Observable<Long> {

    /* renamed from: a */
    final Scheduler f61621a;

    /* renamed from: b */
    final long f61622b;

    /* renamed from: c */
    final long f61623c;

    /* renamed from: d */
    final long f61624d;

    /* renamed from: e */
    final long f61625e;

    /* renamed from: f */
    final TimeUnit f61626f;

    public ObservableIntervalRange(long j, long j2, long j3, long j4, TimeUnit timeUnit, Scheduler scheduler) {
        this.f61624d = j3;
        this.f61625e = j4;
        this.f61626f = timeUnit;
        this.f61621a = scheduler;
        this.f61622b = j;
        this.f61623c = j2;
    }

    public void subscribeActual(Observer<? super Long> observer) {
        IntervalRangeObserver intervalRangeObserver = new IntervalRangeObserver(observer, this.f61622b, this.f61623c);
        observer.onSubscribe(intervalRangeObserver);
        Scheduler scheduler = this.f61621a;
        if (scheduler instanceof TrampolineScheduler) {
            Scheduler.Worker createWorker = scheduler.createWorker();
            intervalRangeObserver.setResource(createWorker);
            createWorker.schedulePeriodically(intervalRangeObserver, this.f61624d, this.f61625e, this.f61626f);
            return;
        }
        intervalRangeObserver.setResource(scheduler.schedulePeriodicallyDirect(intervalRangeObserver, this.f61624d, this.f61625e, this.f61626f));
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableIntervalRange$IntervalRangeObserver */
    static final class IntervalRangeObserver extends AtomicReference<Disposable> implements Disposable, Runnable {
        private static final long serialVersionUID = 1891866368734007884L;
        long count;
        final Observer<? super Long> downstream;
        final long end;

        IntervalRangeObserver(Observer<? super Long> observer, long j, long j2) {
            this.downstream = observer;
            this.count = j;
            this.end = j2;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return get() == DisposableHelper.DISPOSED;
        }

        public void run() {
            if (!isDisposed()) {
                long j = this.count;
                this.downstream.onNext(Long.valueOf(j));
                if (j == this.end) {
                    DisposableHelper.dispose(this);
                    this.downstream.onComplete();
                    return;
                }
                this.count = j + 1;
            }
        }

        public void setResource(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }
}
