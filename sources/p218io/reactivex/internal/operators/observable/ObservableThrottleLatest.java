package p218io.reactivex.internal.operators.observable;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p218io.reactivex.Observable;
import p218io.reactivex.Observer;
import p218io.reactivex.Scheduler;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.internal.disposables.DisposableHelper;

/* renamed from: io.reactivex.internal.operators.observable.ObservableThrottleLatest */
public final class ObservableThrottleLatest<T> extends C22215a<T, T> {

    /* renamed from: a */
    final long f61737a;

    /* renamed from: b */
    final TimeUnit f61738b;

    /* renamed from: c */
    final Scheduler f61739c;

    /* renamed from: d */
    final boolean f61740d;

    public ObservableThrottleLatest(Observable<T> observable, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        super(observable);
        this.f61737a = j;
        this.f61738b = timeUnit;
        this.f61739c = scheduler;
        this.f61740d = z;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new ThrottleLatestObserver(observer, this.f61737a, this.f61738b, this.f61739c.createWorker(), this.f61740d));
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableThrottleLatest$ThrottleLatestObserver */
    static final class ThrottleLatestObserver<T> extends AtomicInteger implements Observer<T>, Disposable, Runnable {
        private static final long serialVersionUID = -8296689127439125014L;
        volatile boolean cancelled;
        volatile boolean done;
        final Observer<? super T> downstream;
        final boolean emitLast;
        Throwable error;
        final AtomicReference<T> latest = new AtomicReference<>();
        final long timeout;
        volatile boolean timerFired;
        boolean timerRunning;
        final TimeUnit unit;
        Disposable upstream;
        final Scheduler.Worker worker;

        ThrottleLatestObserver(Observer<? super T> observer, long j, TimeUnit timeUnit, Scheduler.Worker worker2, boolean z) {
            this.downstream = observer;
            this.timeout = j;
            this.unit = timeUnit;
            this.worker = worker2;
            this.emitLast = z;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            this.latest.set(t);
            drain();
        }

        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        public void onComplete() {
            this.done = true;
            drain();
        }

        public void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            this.worker.dispose();
            if (getAndIncrement() == 0) {
                this.latest.lazySet((Object) null);
            }
        }

        public boolean isDisposed() {
            return this.cancelled;
        }

        public void run() {
            this.timerFired = true;
            drain();
        }

        /* access modifiers changed from: package-private */
        public void drain() {
            if (getAndIncrement() == 0) {
                AtomicReference<T> atomicReference = this.latest;
                Observer<? super T> observer = this.downstream;
                int i = 1;
                while (!this.cancelled) {
                    boolean z = this.done;
                    if (!z || this.error == null) {
                        boolean z2 = atomicReference.get() == null;
                        if (z) {
                            T andSet = atomicReference.getAndSet((Object) null);
                            if (!z2 && this.emitLast) {
                                observer.onNext(andSet);
                            }
                            observer.onComplete();
                            this.worker.dispose();
                            return;
                        }
                        if (z2) {
                            if (this.timerFired) {
                                this.timerRunning = false;
                                this.timerFired = false;
                            }
                        } else if (!this.timerRunning || this.timerFired) {
                            observer.onNext(atomicReference.getAndSet((Object) null));
                            this.timerFired = false;
                            this.timerRunning = true;
                            this.worker.schedule(this, this.timeout, this.unit);
                        }
                        i = addAndGet(-i);
                        if (i == 0) {
                            return;
                        }
                    } else {
                        atomicReference.lazySet((Object) null);
                        observer.onError(this.error);
                        this.worker.dispose();
                        return;
                    }
                }
                atomicReference.lazySet((Object) null);
            }
        }
    }
}
