package p218io.reactivex.internal.operators.flowable;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p218io.reactivex.Flowable;
import p218io.reactivex.FlowableSubscriber;
import p218io.reactivex.internal.subscriptions.SubscriptionHelper;
import p218io.reactivex.internal.util.BackpressureHelper;
import p218io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.flowable.FlowableCache */
public final class FlowableCache<T> extends C22212a<T, T> implements FlowableSubscriber<T> {

    /* renamed from: d */
    static final CacheSubscription[] f60973d = new CacheSubscription[0];

    /* renamed from: e */
    static final CacheSubscription[] f60974e = new CacheSubscription[0];

    /* renamed from: a */
    final AtomicBoolean f60975a = new AtomicBoolean();

    /* renamed from: b */
    final int f60976b;

    /* renamed from: c */
    final AtomicReference<CacheSubscription<T>[]> f60977c;

    /* renamed from: f */
    volatile long f60978f;

    /* renamed from: g */
    final Node<T> f60979g;

    /* renamed from: h */
    Node<T> f60980h;

    /* renamed from: i */
    int f60981i;

    /* renamed from: j */
    Throwable f60982j;

    /* renamed from: k */
    volatile boolean f60983k;

    public FlowableCache(Flowable<T> flowable, int i) {
        super(flowable);
        this.f60976b = i;
        Node<T> node = new Node<>(i);
        this.f60979g = node;
        this.f60980h = node;
        this.f60977c = new AtomicReference<>(f60973d);
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super T> subscriber) {
        CacheSubscription cacheSubscription = new CacheSubscription(subscriber, this);
        subscriber.onSubscribe(cacheSubscription);
        mo184140a(cacheSubscription);
        if (this.f60975a.get() || !this.f60975a.compareAndSet(false, true)) {
            mo184145c(cacheSubscription);
        } else {
            this.source.subscribe(this);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo184141a() {
        return this.f60975a.get();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo184143b() {
        return ((CacheSubscription[]) this.f60977c.get()).length != 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public long mo184144c() {
        return this.f60978f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo184140a(CacheSubscription<T> cacheSubscription) {
        CacheSubscription[] cacheSubscriptionArr;
        CacheSubscription[] cacheSubscriptionArr2;
        do {
            cacheSubscriptionArr = (CacheSubscription[]) this.f60977c.get();
            if (cacheSubscriptionArr != f60974e) {
                int length = cacheSubscriptionArr.length;
                cacheSubscriptionArr2 = new CacheSubscription[(length + 1)];
                System.arraycopy(cacheSubscriptionArr, 0, cacheSubscriptionArr2, 0, length);
                cacheSubscriptionArr2[length] = cacheSubscription;
            } else {
                return;
            }
        } while (!this.f60977c.compareAndSet(cacheSubscriptionArr, cacheSubscriptionArr2));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo184142b(CacheSubscription<T> cacheSubscription) {
        CacheSubscription<T>[] cacheSubscriptionArr;
        CacheSubscription[] cacheSubscriptionArr2;
        do {
            cacheSubscriptionArr = (CacheSubscription[]) this.f60977c.get();
            int length = cacheSubscriptionArr.length;
            if (length != 0) {
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (cacheSubscriptionArr[i2] == cacheSubscription) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        cacheSubscriptionArr2 = f60973d;
                    } else {
                        CacheSubscription[] cacheSubscriptionArr3 = new CacheSubscription[(length - 1)];
                        System.arraycopy(cacheSubscriptionArr, 0, cacheSubscriptionArr3, 0, i);
                        System.arraycopy(cacheSubscriptionArr, i + 1, cacheSubscriptionArr3, i, (length - i) - 1);
                        cacheSubscriptionArr2 = cacheSubscriptionArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.f60977c.compareAndSet(cacheSubscriptionArr, cacheSubscriptionArr2));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo184145c(CacheSubscription<T> cacheSubscription) {
        CacheSubscription<T> cacheSubscription2 = cacheSubscription;
        if (cacheSubscription.getAndIncrement() == 0) {
            long j = cacheSubscription2.index;
            int i = cacheSubscription2.offset;
            Node<T> node = cacheSubscription2.node;
            AtomicLong atomicLong = cacheSubscription2.requested;
            Subscriber<? super T> subscriber = cacheSubscription2.downstream;
            int i2 = this.f60976b;
            int i3 = 1;
            while (true) {
                boolean z = this.f60983k;
                boolean z2 = this.f60978f == j;
                if (!z || !z2) {
                    if (!z2) {
                        long j2 = atomicLong.get();
                        if (j2 == Long.MIN_VALUE) {
                            cacheSubscription2.node = null;
                            return;
                        } else if (j2 != j) {
                            if (i == i2) {
                                node = node.next;
                                i = 0;
                            }
                            subscriber.onNext(node.values[i]);
                            i++;
                            j++;
                        }
                    }
                    cacheSubscription2.index = j;
                    cacheSubscription2.offset = i;
                    cacheSubscription2.node = node;
                    i3 = cacheSubscription2.addAndGet(-i3);
                    if (i3 == 0) {
                        return;
                    }
                } else {
                    cacheSubscription2.node = null;
                    Throwable th = this.f60982j;
                    if (th != null) {
                        subscriber.onError(th);
                        return;
                    } else {
                        subscriber.onComplete();
                        return;
                    }
                }
            }
        }
    }

    public void onSubscribe(Subscription subscription) {
        subscription.request(Long.MAX_VALUE);
    }

    public void onNext(T t) {
        int i = this.f60981i;
        if (i == this.f60976b) {
            Node<T> node = new Node<>(i);
            node.values[0] = t;
            this.f60981i = 1;
            this.f60980h.next = node;
            this.f60980h = node;
        } else {
            this.f60980h.values[i] = t;
            this.f60981i = i + 1;
        }
        this.f60978f++;
        for (CacheSubscription c : (CacheSubscription[]) this.f60977c.get()) {
            mo184145c(c);
        }
    }

    public void onError(Throwable th) {
        if (this.f60983k) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.f60982j = th;
        this.f60983k = true;
        for (CacheSubscription c : (CacheSubscription[]) this.f60977c.getAndSet(f60974e)) {
            mo184145c(c);
        }
    }

    public void onComplete() {
        this.f60983k = true;
        for (CacheSubscription c : (CacheSubscription[]) this.f60977c.getAndSet(f60974e)) {
            mo184145c(c);
        }
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableCache$CacheSubscription */
    static final class CacheSubscription<T> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = 6770240836423125754L;
        final Subscriber<? super T> downstream;
        long index;
        Node<T> node;
        int offset;
        final FlowableCache<T> parent;
        final AtomicLong requested = new AtomicLong();

        CacheSubscription(Subscriber<? super T> subscriber, FlowableCache<T> flowableCache) {
            this.downstream = subscriber;
            this.parent = flowableCache;
            this.node = flowableCache.f60979g;
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.addCancel(this.requested, j);
                this.parent.mo184145c(this);
            }
        }

        public void cancel() {
            if (this.requested.getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.mo184142b(this);
            }
        }
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableCache$Node */
    static final class Node<T> {
        volatile Node<T> next;
        final T[] values;

        Node(int i) {
            this.values = (Object[]) new Object[i];
        }
    }
}
