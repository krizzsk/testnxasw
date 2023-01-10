package p218io.reactivex.processors;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p218io.reactivex.annotations.BackpressureKind;
import p218io.reactivex.annotations.BackpressureSupport;
import p218io.reactivex.annotations.CheckReturnValue;
import p218io.reactivex.annotations.SchedulerSupport;
import p218io.reactivex.exceptions.Exceptions;
import p218io.reactivex.exceptions.MissingBackpressureException;
import p218io.reactivex.internal.functions.ObjectHelper;
import p218io.reactivex.internal.fuseable.QueueSubscription;
import p218io.reactivex.internal.fuseable.SimpleQueue;
import p218io.reactivex.internal.queue.SpscArrayQueue;
import p218io.reactivex.internal.queue.SpscLinkedArrayQueue;
import p218io.reactivex.internal.subscriptions.EmptySubscription;
import p218io.reactivex.internal.subscriptions.SubscriptionHelper;
import p218io.reactivex.plugins.RxJavaPlugins;

@BackpressureSupport(BackpressureKind.FULL)
@SchedulerSupport("none")
/* renamed from: io.reactivex.processors.MulticastProcessor */
public final class MulticastProcessor<T> extends FlowableProcessor<T> {

    /* renamed from: m */
    static final MulticastSubscription[] f62135m = new MulticastSubscription[0];

    /* renamed from: n */
    static final MulticastSubscription[] f62136n = new MulticastSubscription[0];

    /* renamed from: a */
    final AtomicInteger f62137a = new AtomicInteger();

    /* renamed from: b */
    final AtomicReference<Subscription> f62138b = new AtomicReference<>();

    /* renamed from: c */
    final AtomicReference<MulticastSubscription<T>[]> f62139c = new AtomicReference<>(f62135m);

    /* renamed from: d */
    final AtomicBoolean f62140d;

    /* renamed from: e */
    final int f62141e;

    /* renamed from: f */
    final int f62142f;

    /* renamed from: g */
    final boolean f62143g;

    /* renamed from: h */
    volatile SimpleQueue<T> f62144h;

    /* renamed from: i */
    volatile boolean f62145i;

    /* renamed from: j */
    volatile Throwable f62146j;

    /* renamed from: k */
    int f62147k;

    /* renamed from: l */
    int f62148l;

    @CheckReturnValue
    public static <T> MulticastProcessor<T> create() {
        return new MulticastProcessor<>(bufferSize(), false);
    }

    @CheckReturnValue
    public static <T> MulticastProcessor<T> create(boolean z) {
        return new MulticastProcessor<>(bufferSize(), z);
    }

    @CheckReturnValue
    public static <T> MulticastProcessor<T> create(int i) {
        return new MulticastProcessor<>(i, false);
    }

    @CheckReturnValue
    public static <T> MulticastProcessor<T> create(int i, boolean z) {
        return new MulticastProcessor<>(i, z);
    }

    MulticastProcessor(int i, boolean z) {
        ObjectHelper.verifyPositive(i, "bufferSize");
        this.f62141e = i;
        this.f62142f = i - (i >> 2);
        this.f62143g = z;
        this.f62140d = new AtomicBoolean();
    }

    public void start() {
        if (SubscriptionHelper.setOnce(this.f62138b, EmptySubscription.INSTANCE)) {
            this.f62144h = new SpscArrayQueue(this.f62141e);
        }
    }

    public void startUnbounded() {
        if (SubscriptionHelper.setOnce(this.f62138b, EmptySubscription.INSTANCE)) {
            this.f62144h = new SpscLinkedArrayQueue(this.f62141e);
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.setOnce(this.f62138b, subscription)) {
            if (subscription instanceof QueueSubscription) {
                QueueSubscription queueSubscription = (QueueSubscription) subscription;
                int requestFusion = queueSubscription.requestFusion(3);
                if (requestFusion == 1) {
                    this.f62148l = requestFusion;
                    this.f62144h = queueSubscription;
                    this.f62145i = true;
                    mo185247a();
                    return;
                } else if (requestFusion == 2) {
                    this.f62148l = requestFusion;
                    this.f62144h = queueSubscription;
                    subscription.request((long) this.f62141e);
                    return;
                }
            }
            this.f62144h = new SpscArrayQueue(this.f62141e);
            subscription.request((long) this.f62141e);
        }
    }

    public void onNext(T t) {
        if (!this.f62140d.get()) {
            if (this.f62148l == 0) {
                ObjectHelper.requireNonNull(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
                if (!this.f62144h.offer(t)) {
                    SubscriptionHelper.cancel(this.f62138b);
                    onError(new MissingBackpressureException());
                    return;
                }
            }
            mo185247a();
        }
    }

    public boolean offer(T t) {
        if (this.f62140d.get()) {
            return false;
        }
        ObjectHelper.requireNonNull(t, "offer called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f62148l != 0 || !this.f62144h.offer(t)) {
            return false;
        }
        mo185247a();
        return true;
    }

    public void onError(Throwable th) {
        ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f62140d.compareAndSet(false, true)) {
            this.f62146j = th;
            this.f62145i = true;
            mo185247a();
            return;
        }
        RxJavaPlugins.onError(th);
    }

    public void onComplete() {
        if (this.f62140d.compareAndSet(false, true)) {
            this.f62145i = true;
            mo185247a();
        }
    }

    public boolean hasSubscribers() {
        return ((MulticastSubscription[]) this.f62139c.get()).length != 0;
    }

    public boolean hasThrowable() {
        return this.f62140d.get() && this.f62146j != null;
    }

    public boolean hasComplete() {
        return this.f62140d.get() && this.f62146j == null;
    }

    public Throwable getThrowable() {
        if (this.f62140d.get()) {
            return this.f62146j;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super T> subscriber) {
        Throwable th;
        MulticastSubscription multicastSubscription = new MulticastSubscription(subscriber, this);
        subscriber.onSubscribe(multicastSubscription);
        if (mo185248a(multicastSubscription)) {
            if (multicastSubscription.get() == Long.MIN_VALUE) {
                mo185249b(multicastSubscription);
            } else {
                mo185247a();
            }
        } else if ((this.f62140d.get() || !this.f62143g) && (th = this.f62146j) != null) {
            subscriber.onError(th);
        } else {
            subscriber.onComplete();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo185248a(MulticastSubscription<T> multicastSubscription) {
        MulticastSubscription[] multicastSubscriptionArr;
        MulticastSubscription[] multicastSubscriptionArr2;
        do {
            multicastSubscriptionArr = (MulticastSubscription[]) this.f62139c.get();
            if (multicastSubscriptionArr == f62136n) {
                return false;
            }
            int length = multicastSubscriptionArr.length;
            multicastSubscriptionArr2 = new MulticastSubscription[(length + 1)];
            System.arraycopy(multicastSubscriptionArr, 0, multicastSubscriptionArr2, 0, length);
            multicastSubscriptionArr2[length] = multicastSubscription;
        } while (!this.f62139c.compareAndSet(multicastSubscriptionArr, multicastSubscriptionArr2));
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo185249b(MulticastSubscription<T> multicastSubscription) {
        while (true) {
            MulticastSubscription<T>[] multicastSubscriptionArr = (MulticastSubscription[]) this.f62139c.get();
            int length = multicastSubscriptionArr.length;
            if (length != 0) {
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (multicastSubscriptionArr[i2] == multicastSubscription) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i >= 0) {
                    if (length != 1) {
                        MulticastSubscription[] multicastSubscriptionArr2 = new MulticastSubscription[(length - 1)];
                        System.arraycopy(multicastSubscriptionArr, 0, multicastSubscriptionArr2, 0, i);
                        System.arraycopy(multicastSubscriptionArr, i + 1, multicastSubscriptionArr2, i, (length - i) - 1);
                        if (this.f62139c.compareAndSet(multicastSubscriptionArr, multicastSubscriptionArr2)) {
                            return;
                        }
                    } else if (this.f62143g) {
                        if (this.f62139c.compareAndSet(multicastSubscriptionArr, f62136n)) {
                            SubscriptionHelper.cancel(this.f62138b);
                            this.f62140d.set(true);
                            return;
                        }
                    } else if (this.f62139c.compareAndSet(multicastSubscriptionArr, f62135m)) {
                        return;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo185247a() {
        int i;
        T t;
        if (this.f62137a.getAndIncrement() == 0) {
            AtomicReference<MulticastSubscription<T>[]> atomicReference = this.f62139c;
            int i2 = this.f62147k;
            int i3 = this.f62142f;
            int i4 = this.f62148l;
            int i5 = 1;
            while (true) {
                SimpleQueue<T> simpleQueue = this.f62144h;
                if (simpleQueue != null) {
                    MulticastSubscription[] multicastSubscriptionArr = (MulticastSubscription[]) atomicReference.get();
                    if (multicastSubscriptionArr.length != 0) {
                        int length = multicastSubscriptionArr.length;
                        long j = -1;
                        long j2 = -1;
                        int i6 = 0;
                        while (i6 < length) {
                            MulticastSubscription multicastSubscription = multicastSubscriptionArr[i6];
                            long j3 = multicastSubscription.get();
                            if (j3 >= 0) {
                                if (j2 == j) {
                                    j2 = j3 - multicastSubscription.emitted;
                                } else {
                                    j2 = Math.min(j2, j3 - multicastSubscription.emitted);
                                }
                            }
                            i6++;
                            j = -1;
                        }
                        int i7 = i2;
                        while (true) {
                            i = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
                            if (i <= 0) {
                                break;
                            }
                            MulticastSubscription[] multicastSubscriptionArr2 = (MulticastSubscription[]) atomicReference.get();
                            if (multicastSubscriptionArr2 == f62136n) {
                                simpleQueue.clear();
                                return;
                            } else if (multicastSubscriptionArr != multicastSubscriptionArr2) {
                                break;
                            } else {
                                boolean z = this.f62145i;
                                try {
                                    t = simpleQueue.poll();
                                } catch (Throwable th) {
                                    Throwable th2 = th;
                                    Exceptions.throwIfFatal(th2);
                                    SubscriptionHelper.cancel(this.f62138b);
                                    this.f62146j = th2;
                                    this.f62145i = true;
                                    t = null;
                                    z = true;
                                }
                                boolean z2 = t == null;
                                if (z && z2) {
                                    Throwable th3 = this.f62146j;
                                    if (th3 != null) {
                                        for (MulticastSubscription onError : (MulticastSubscription[]) atomicReference.getAndSet(f62136n)) {
                                            onError.onError(th3);
                                        }
                                        return;
                                    }
                                    for (MulticastSubscription onComplete : (MulticastSubscription[]) atomicReference.getAndSet(f62136n)) {
                                        onComplete.onComplete();
                                    }
                                    return;
                                } else if (z2) {
                                    break;
                                } else {
                                    for (MulticastSubscription onNext : multicastSubscriptionArr) {
                                        onNext.onNext(t);
                                    }
                                    j2--;
                                    if (i4 != 1 && (i7 = i7 + 1) == i3) {
                                        this.f62138b.get().request((long) i3);
                                        i7 = 0;
                                    }
                                }
                            }
                        }
                        if (i == 0) {
                            MulticastSubscription[] multicastSubscriptionArr3 = (MulticastSubscription[]) atomicReference.get();
                            if (multicastSubscriptionArr3 == f62136n) {
                                simpleQueue.clear();
                                return;
                            }
                            if (multicastSubscriptionArr == multicastSubscriptionArr3) {
                                if (this.f62145i && simpleQueue.isEmpty()) {
                                    Throwable th4 = this.f62146j;
                                    if (th4 != null) {
                                        for (MulticastSubscription onError2 : (MulticastSubscription[]) atomicReference.getAndSet(f62136n)) {
                                            onError2.onError(th4);
                                        }
                                        return;
                                    }
                                    for (MulticastSubscription onComplete2 : (MulticastSubscription[]) atomicReference.getAndSet(f62136n)) {
                                        onComplete2.onComplete();
                                    }
                                    return;
                                }
                            }
                            i2 = i7;
                        }
                        i2 = i7;
                    }
                }
                i5 = this.f62137a.addAndGet(-i5);
                if (i5 == 0) {
                    return;
                }
            }
        }
    }

    /* renamed from: io.reactivex.processors.MulticastProcessor$MulticastSubscription */
    static final class MulticastSubscription<T> extends AtomicLong implements Subscription {
        private static final long serialVersionUID = -363282618957264509L;
        final Subscriber<? super T> downstream;
        long emitted;
        final MulticastProcessor<T> parent;

        MulticastSubscription(Subscriber<? super T> subscriber, MulticastProcessor<T> multicastProcessor) {
            this.downstream = subscriber;
            this.parent = multicastProcessor;
        }

        public void request(long j) {
            long j2;
            long j3;
            if (SubscriptionHelper.validate(j)) {
                do {
                    j2 = get();
                    if (j2 != Long.MIN_VALUE) {
                        j3 = Long.MAX_VALUE;
                        if (j2 != Long.MAX_VALUE) {
                            long j4 = j2 + j;
                            if (j4 >= 0) {
                                j3 = j4;
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } while (!compareAndSet(j2, j3));
                this.parent.mo185247a();
            }
        }

        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.mo185249b(this);
            }
        }

        /* access modifiers changed from: package-private */
        public void onNext(T t) {
            if (get() != Long.MIN_VALUE) {
                this.emitted++;
                this.downstream.onNext(t);
            }
        }

        /* access modifiers changed from: package-private */
        public void onError(Throwable th) {
            if (get() != Long.MIN_VALUE) {
                this.downstream.onError(th);
            }
        }

        /* access modifiers changed from: package-private */
        public void onComplete() {
            if (get() != Long.MIN_VALUE) {
                this.downstream.onComplete();
            }
        }
    }
}
