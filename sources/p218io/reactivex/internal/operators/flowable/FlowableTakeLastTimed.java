package p218io.reactivex.internal.operators.flowable;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p218io.reactivex.Flowable;
import p218io.reactivex.FlowableSubscriber;
import p218io.reactivex.Scheduler;
import p218io.reactivex.internal.queue.SpscLinkedArrayQueue;
import p218io.reactivex.internal.subscriptions.SubscriptionHelper;
import p218io.reactivex.internal.util.BackpressureHelper;

/* renamed from: io.reactivex.internal.operators.flowable.FlowableTakeLastTimed */
public final class FlowableTakeLastTimed<T> extends C22212a<T, T> {

    /* renamed from: a */
    final long f61240a;

    /* renamed from: b */
    final long f61241b;

    /* renamed from: c */
    final TimeUnit f61242c;

    /* renamed from: d */
    final Scheduler f61243d;

    /* renamed from: e */
    final int f61244e;

    /* renamed from: f */
    final boolean f61245f;

    public FlowableTakeLastTimed(Flowable<T> flowable, long j, long j2, TimeUnit timeUnit, Scheduler scheduler, int i, boolean z) {
        super(flowable);
        this.f61240a = j;
        this.f61241b = j2;
        this.f61242c = timeUnit;
        this.f61243d = scheduler;
        this.f61244e = i;
        this.f61245f = z;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new TakeLastTimedSubscriber(subscriber, this.f61240a, this.f61241b, this.f61242c, this.f61243d, this.f61244e, this.f61245f));
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableTakeLastTimed$TakeLastTimedSubscriber */
    static final class TakeLastTimedSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -5677354903406201275L;
        volatile boolean cancelled;
        final long count;
        final boolean delayError;
        volatile boolean done;
        final Subscriber<? super T> downstream;
        Throwable error;
        final SpscLinkedArrayQueue<Object> queue;
        final AtomicLong requested = new AtomicLong();
        final Scheduler scheduler;
        final long time;
        final TimeUnit unit;
        Subscription upstream;

        TakeLastTimedSubscriber(Subscriber<? super T> subscriber, long j, long j2, TimeUnit timeUnit, Scheduler scheduler2, int i, boolean z) {
            this.downstream = subscriber;
            this.count = j;
            this.time = j2;
            this.unit = timeUnit;
            this.scheduler = scheduler2;
            this.queue = new SpscLinkedArrayQueue<>(i);
            this.delayError = z;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void onNext(T t) {
            SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.queue;
            long now = this.scheduler.now(this.unit);
            spscLinkedArrayQueue.offer(Long.valueOf(now), t);
            trim(now, spscLinkedArrayQueue);
        }

        public void onError(Throwable th) {
            if (this.delayError) {
                trim(this.scheduler.now(this.unit), this.queue);
            }
            this.error = th;
            this.done = true;
            drain();
        }

        public void onComplete() {
            trim(this.scheduler.now(this.unit), this.queue);
            this.done = true;
            drain();
        }

        /* access modifiers changed from: package-private */
        public void trim(long j, SpscLinkedArrayQueue<Object> spscLinkedArrayQueue) {
            long j2 = this.time;
            long j3 = this.count;
            boolean z = j3 == Long.MAX_VALUE;
            while (!spscLinkedArrayQueue.isEmpty()) {
                if (((Long) spscLinkedArrayQueue.peek()).longValue() < j - j2 || (!z && ((long) (spscLinkedArrayQueue.size() >> 1)) > j3)) {
                    spscLinkedArrayQueue.poll();
                    spscLinkedArrayQueue.poll();
                } else {
                    return;
                }
            }
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
                drain();
            }
        }

        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.upstream.cancel();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void drain() {
            if (getAndIncrement() == 0) {
                Subscriber<? super T> subscriber = this.downstream;
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.queue;
                boolean z = this.delayError;
                int i = 1;
                do {
                    if (this.done) {
                        if (!checkTerminated(spscLinkedArrayQueue.isEmpty(), subscriber, z)) {
                            long j = this.requested.get();
                            long j2 = 0;
                            while (true) {
                                if (!checkTerminated(spscLinkedArrayQueue.peek() == null, subscriber, z)) {
                                    if (j != j2) {
                                        spscLinkedArrayQueue.poll();
                                        subscriber.onNext(spscLinkedArrayQueue.poll());
                                        j2++;
                                    } else if (j2 != 0) {
                                        BackpressureHelper.produced(this.requested, j2);
                                    }
                                } else {
                                    return;
                                }
                            }
                        } else {
                            return;
                        }
                    }
                    i = addAndGet(-i);
                } while (i != 0);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean checkTerminated(boolean z, Subscriber<? super T> subscriber, boolean z2) {
            if (this.cancelled) {
                this.queue.clear();
                return true;
            } else if (!z2) {
                Throwable th = this.error;
                if (th != null) {
                    this.queue.clear();
                    subscriber.onError(th);
                    return true;
                } else if (!z) {
                    return false;
                } else {
                    subscriber.onComplete();
                    return true;
                }
            } else if (!z) {
                return false;
            } else {
                Throwable th2 = this.error;
                if (th2 != null) {
                    subscriber.onError(th2);
                } else {
                    subscriber.onComplete();
                }
                return true;
            }
        }
    }
}
