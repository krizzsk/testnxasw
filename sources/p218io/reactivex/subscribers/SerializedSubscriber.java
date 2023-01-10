package p218io.reactivex.subscribers;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p218io.reactivex.FlowableSubscriber;
import p218io.reactivex.internal.subscriptions.SubscriptionHelper;
import p218io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import p218io.reactivex.internal.util.NotificationLite;

/* renamed from: io.reactivex.subscribers.SerializedSubscriber */
public final class SerializedSubscriber<T> implements FlowableSubscriber<T>, Subscription {

    /* renamed from: c */
    static final int f62247c = 4;

    /* renamed from: a */
    final Subscriber<? super T> f62248a;

    /* renamed from: b */
    final boolean f62249b;

    /* renamed from: d */
    Subscription f62250d;

    /* renamed from: e */
    boolean f62251e;

    /* renamed from: f */
    AppendOnlyLinkedArrayList<Object> f62252f;

    /* renamed from: g */
    volatile boolean f62253g;

    public SerializedSubscriber(Subscriber<? super T> subscriber) {
        this(subscriber, false);
    }

    public SerializedSubscriber(Subscriber<? super T> subscriber, boolean z) {
        this.f62248a = subscriber;
        this.f62249b = z;
    }

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f62250d, subscription)) {
            this.f62250d = subscription;
            this.f62248a.onSubscribe(this);
        }
    }

    public void onNext(T t) {
        if (!this.f62253g) {
            if (t == null) {
                this.f62250d.cancel();
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                return;
            }
            synchronized (this) {
                if (!this.f62253g) {
                    if (this.f62251e) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f62252f;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.f62252f = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.add(NotificationLite.next(t));
                        return;
                    }
                    this.f62251e = true;
                    this.f62248a.onNext(t);
                    mo185408a();
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0031, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0038, code lost:
        if (r1 == false) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003a, code lost:
        p218io.reactivex.plugins.RxJavaPlugins.onError(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003d, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003e, code lost:
        r2.f62248a.onError(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0043, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onError(java.lang.Throwable r3) {
        /*
            r2 = this;
            boolean r0 = r2.f62253g
            if (r0 == 0) goto L_0x0008
            p218io.reactivex.plugins.RxJavaPlugins.onError(r3)
            return
        L_0x0008:
            monitor-enter(r2)
            boolean r0 = r2.f62253g     // Catch:{ all -> 0x0044 }
            r1 = 1
            if (r0 == 0) goto L_0x000f
            goto L_0x0037
        L_0x000f:
            boolean r0 = r2.f62251e     // Catch:{ all -> 0x0044 }
            if (r0 == 0) goto L_0x0032
            r2.f62253g = r1     // Catch:{ all -> 0x0044 }
            io.reactivex.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> r0 = r2.f62252f     // Catch:{ all -> 0x0044 }
            if (r0 != 0) goto L_0x0021
            io.reactivex.internal.util.AppendOnlyLinkedArrayList r0 = new io.reactivex.internal.util.AppendOnlyLinkedArrayList     // Catch:{ all -> 0x0044 }
            r1 = 4
            r0.<init>(r1)     // Catch:{ all -> 0x0044 }
            r2.f62252f = r0     // Catch:{ all -> 0x0044 }
        L_0x0021:
            java.lang.Object r3 = p218io.reactivex.internal.util.NotificationLite.error(r3)     // Catch:{ all -> 0x0044 }
            boolean r1 = r2.f62249b     // Catch:{ all -> 0x0044 }
            if (r1 == 0) goto L_0x002d
            r0.add(r3)     // Catch:{ all -> 0x0044 }
            goto L_0x0030
        L_0x002d:
            r0.setFirst(r3)     // Catch:{ all -> 0x0044 }
        L_0x0030:
            monitor-exit(r2)     // Catch:{ all -> 0x0044 }
            return
        L_0x0032:
            r2.f62253g = r1     // Catch:{ all -> 0x0044 }
            r2.f62251e = r1     // Catch:{ all -> 0x0044 }
            r1 = 0
        L_0x0037:
            monitor-exit(r2)     // Catch:{ all -> 0x0044 }
            if (r1 == 0) goto L_0x003e
            p218io.reactivex.plugins.RxJavaPlugins.onError(r3)
            return
        L_0x003e:
            org.reactivestreams.Subscriber<? super T> r0 = r2.f62248a
            r0.onError(r3)
            return
        L_0x0044:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0044 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p218io.reactivex.subscribers.SerializedSubscriber.onError(java.lang.Throwable):void");
    }

    public void onComplete() {
        if (!this.f62253g) {
            synchronized (this) {
                if (!this.f62253g) {
                    if (this.f62251e) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f62252f;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.f62252f = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.add(NotificationLite.complete());
                        return;
                    }
                    this.f62253g = true;
                    this.f62251e = true;
                    this.f62248a.onComplete();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo185408a() {
        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList;
        do {
            synchronized (this) {
                appendOnlyLinkedArrayList = this.f62252f;
                if (appendOnlyLinkedArrayList == null) {
                    this.f62251e = false;
                    return;
                }
                this.f62252f = null;
            }
        } while (!appendOnlyLinkedArrayList.accept((Subscriber<? super U>) this.f62248a));
    }

    public void request(long j) {
        this.f62250d.request(j);
    }

    public void cancel() {
        this.f62250d.cancel();
    }
}
