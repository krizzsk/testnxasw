package p218io.reactivex.internal.operators.observable;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p218io.reactivex.ObservableSource;
import p218io.reactivex.Observer;
import p218io.reactivex.Scheduler;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.internal.disposables.DisposableHelper;
import p218io.reactivex.observers.SerializedObserver;

/* renamed from: io.reactivex.internal.operators.observable.ObservableSampleTimed */
public final class ObservableSampleTimed<T> extends C22215a<T, T> {

    /* renamed from: a */
    final long f61685a;

    /* renamed from: b */
    final TimeUnit f61686b;

    /* renamed from: c */
    final Scheduler f61687c;

    /* renamed from: d */
    final boolean f61688d;

    public ObservableSampleTimed(ObservableSource<T> observableSource, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        super(observableSource);
        this.f61685a = j;
        this.f61686b = timeUnit;
        this.f61687c = scheduler;
        this.f61688d = z;
    }

    public void subscribeActual(Observer<? super T> observer) {
        SerializedObserver serializedObserver = new SerializedObserver(observer);
        if (this.f61688d) {
            this.source.subscribe(new SampleTimedEmitLast(serializedObserver, this.f61685a, this.f61686b, this.f61687c));
        } else {
            this.source.subscribe(new SampleTimedNoLast(serializedObserver, this.f61685a, this.f61686b, this.f61687c));
        }
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableSampleTimed$SampleTimedObserver */
    static abstract class SampleTimedObserver<T> extends AtomicReference<T> implements Observer<T>, Disposable, Runnable {
        private static final long serialVersionUID = -3517602651313910099L;
        final Observer<? super T> downstream;
        final long period;
        final Scheduler scheduler;
        final AtomicReference<Disposable> timer = new AtomicReference<>();
        final TimeUnit unit;
        Disposable upstream;

        /* access modifiers changed from: package-private */
        public abstract void complete();

        SampleTimedObserver(Observer<? super T> observer, long j, TimeUnit timeUnit, Scheduler scheduler2) {
            this.downstream = observer;
            this.period = j;
            this.unit = timeUnit;
            this.scheduler = scheduler2;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
                Scheduler scheduler2 = this.scheduler;
                long j = this.period;
                DisposableHelper.replace(this.timer, scheduler2.schedulePeriodicallyDirect(this, j, j, this.unit));
            }
        }

        public void onNext(T t) {
            lazySet(t);
        }

        public void onError(Throwable th) {
            cancelTimer();
            this.downstream.onError(th);
        }

        public void onComplete() {
            cancelTimer();
            complete();
        }

        /* access modifiers changed from: package-private */
        public void cancelTimer() {
            DisposableHelper.dispose(this.timer);
        }

        public void dispose() {
            cancelTimer();
            this.upstream.dispose();
        }

        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        /* access modifiers changed from: package-private */
        public void emit() {
            Object andSet = getAndSet((Object) null);
            if (andSet != null) {
                this.downstream.onNext(andSet);
            }
        }
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableSampleTimed$SampleTimedNoLast */
    static final class SampleTimedNoLast<T> extends SampleTimedObserver<T> {
        private static final long serialVersionUID = -7139995637533111443L;

        SampleTimedNoLast(Observer<? super T> observer, long j, TimeUnit timeUnit, Scheduler scheduler) {
            super(observer, j, timeUnit, scheduler);
        }

        /* access modifiers changed from: package-private */
        public void complete() {
            this.downstream.onComplete();
        }

        public void run() {
            emit();
        }
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableSampleTimed$SampleTimedEmitLast */
    static final class SampleTimedEmitLast<T> extends SampleTimedObserver<T> {
        private static final long serialVersionUID = -7139995637533111443L;
        final AtomicInteger wip = new AtomicInteger(1);

        SampleTimedEmitLast(Observer<? super T> observer, long j, TimeUnit timeUnit, Scheduler scheduler) {
            super(observer, j, timeUnit, scheduler);
        }

        /* access modifiers changed from: package-private */
        public void complete() {
            emit();
            if (this.wip.decrementAndGet() == 0) {
                this.downstream.onComplete();
            }
        }

        public void run() {
            if (this.wip.incrementAndGet() == 2) {
                emit();
                if (this.wip.decrementAndGet() == 0) {
                    this.downstream.onComplete();
                }
            }
        }
    }
}
