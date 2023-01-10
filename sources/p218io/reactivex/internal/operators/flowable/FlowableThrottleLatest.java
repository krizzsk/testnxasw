package p218io.reactivex.internal.operators.flowable;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p218io.reactivex.Flowable;
import p218io.reactivex.FlowableSubscriber;
import p218io.reactivex.Scheduler;
import p218io.reactivex.exceptions.MissingBackpressureException;
import p218io.reactivex.internal.subscriptions.SubscriptionHelper;
import p218io.reactivex.internal.util.BackpressureHelper;

/* renamed from: io.reactivex.internal.operators.flowable.FlowableThrottleLatest */
public final class FlowableThrottleLatest<T> extends C22212a<T, T> {

    /* renamed from: a */
    final long f61254a;

    /* renamed from: b */
    final TimeUnit f61255b;

    /* renamed from: c */
    final Scheduler f61256c;

    /* renamed from: d */
    final boolean f61257d;

    public FlowableThrottleLatest(Flowable<T> flowable, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        super(flowable);
        this.f61254a = j;
        this.f61255b = timeUnit;
        this.f61256c = scheduler;
        this.f61257d = z;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new ThrottleLatestSubscriber(subscriber, this.f61254a, this.f61255b, this.f61256c.createWorker(), this.f61257d));
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableThrottleLatest$ThrottleLatestSubscriber */
    static final class ThrottleLatestSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Runnable, Subscription {
        private static final long serialVersionUID = -8296689127439125014L;
        volatile boolean cancelled;
        volatile boolean done;
        final Subscriber<? super T> downstream;
        final boolean emitLast;
        long emitted;
        Throwable error;
        final AtomicReference<T> latest = new AtomicReference<>();
        final AtomicLong requested = new AtomicLong();
        final long timeout;
        volatile boolean timerFired;
        boolean timerRunning;
        final TimeUnit unit;
        Subscription upstream;
        final Scheduler.Worker worker;

        ThrottleLatestSubscriber(Subscriber<? super T> subscriber, long j, TimeUnit timeUnit, Scheduler.Worker worker2, boolean z) {
            this.downstream = subscriber;
            this.timeout = j;
            this.unit = timeUnit;
            this.worker = worker2;
            this.emitLast = z;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
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

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
            }
        }

        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
            this.worker.dispose();
            if (getAndIncrement() == 0) {
                this.latest.lazySet((Object) null);
            }
        }

        public void run() {
            this.timerFired = true;
            drain();
        }

        /* access modifiers changed from: package-private */
        public void drain() {
            if (getAndIncrement() == 0) {
                AtomicReference<T> atomicReference = this.latest;
                AtomicLong atomicLong = this.requested;
                Subscriber<? super T> subscriber = this.downstream;
                int i = 1;
                while (!this.cancelled) {
                    boolean z = this.done;
                    if (!z || this.error == null) {
                        boolean z2 = atomicReference.get() == null;
                        if (z) {
                            if (z2 || !this.emitLast) {
                                atomicReference.lazySet((Object) null);
                                subscriber.onComplete();
                            } else {
                                T andSet = atomicReference.getAndSet((Object) null);
                                long j = this.emitted;
                                if (j != atomicLong.get()) {
                                    this.emitted = j + 1;
                                    subscriber.onNext(andSet);
                                    subscriber.onComplete();
                                } else {
                                    subscriber.onError(new MissingBackpressureException("Could not emit final value due to lack of requests"));
                                }
                            }
                            this.worker.dispose();
                            return;
                        }
                        if (z2) {
                            if (this.timerFired) {
                                this.timerRunning = false;
                                this.timerFired = false;
                            }
                        } else if (!this.timerRunning || this.timerFired) {
                            T andSet2 = atomicReference.getAndSet((Object) null);
                            long j2 = this.emitted;
                            if (j2 != atomicLong.get()) {
                                subscriber.onNext(andSet2);
                                this.emitted = j2 + 1;
                                this.timerFired = false;
                                this.timerRunning = true;
                                this.worker.schedule(this, this.timeout, this.unit);
                            } else {
                                this.upstream.cancel();
                                subscriber.onError(new MissingBackpressureException("Could not emit value due to lack of requests"));
                                this.worker.dispose();
                                return;
                            }
                        }
                        i = addAndGet(-i);
                        if (i == 0) {
                            return;
                        }
                    } else {
                        atomicReference.lazySet((Object) null);
                        subscriber.onError(this.error);
                        this.worker.dispose();
                        return;
                    }
                }
                atomicReference.lazySet((Object) null);
            }
        }
    }
}
