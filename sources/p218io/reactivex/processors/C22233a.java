package p218io.reactivex.processors;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p218io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import p218io.reactivex.internal.util.NotificationLite;

/* renamed from: io.reactivex.processors.a */
/* compiled from: SerializedProcessor */
final class C22233a<T> extends FlowableProcessor<T> {

    /* renamed from: a */
    final FlowableProcessor<T> f62170a;

    /* renamed from: b */
    boolean f62171b;

    /* renamed from: c */
    AppendOnlyLinkedArrayList<Object> f62172c;

    /* renamed from: d */
    volatile boolean f62173d;

    C22233a(FlowableProcessor<T> flowableProcessor) {
        this.f62170a = flowableProcessor;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f62170a.subscribe(subscriber);
    }

    public void onSubscribe(Subscription subscription) {
        boolean z = true;
        if (!this.f62173d) {
            synchronized (this) {
                if (!this.f62173d) {
                    if (this.f62171b) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f62172c;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.f62172c = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.add(NotificationLite.subscription(subscription));
                        return;
                    }
                    this.f62171b = true;
                    z = false;
                }
            }
        }
        if (z) {
            subscription.cancel();
            return;
        }
        this.f62170a.onSubscribe(subscription);
        mo185293a();
    }

    public void onNext(T t) {
        if (!this.f62173d) {
            synchronized (this) {
                if (!this.f62173d) {
                    if (this.f62171b) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f62172c;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.f62172c = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.add(NotificationLite.next(t));
                        return;
                    }
                    this.f62171b = true;
                    this.f62170a.onNext(t);
                    mo185293a();
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002f, code lost:
        if (r1 == false) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0031, code lost:
        p218io.reactivex.plugins.RxJavaPlugins.onError(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0034, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0035, code lost:
        r2.f62170a.onError(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onError(java.lang.Throwable r3) {
        /*
            r2 = this;
            boolean r0 = r2.f62173d
            if (r0 == 0) goto L_0x0008
            p218io.reactivex.plugins.RxJavaPlugins.onError(r3)
            return
        L_0x0008:
            monitor-enter(r2)
            boolean r0 = r2.f62173d     // Catch:{ all -> 0x003b }
            r1 = 1
            if (r0 == 0) goto L_0x000f
            goto L_0x002e
        L_0x000f:
            r2.f62173d = r1     // Catch:{ all -> 0x003b }
            boolean r0 = r2.f62171b     // Catch:{ all -> 0x003b }
            if (r0 == 0) goto L_0x002a
            io.reactivex.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> r0 = r2.f62172c     // Catch:{ all -> 0x003b }
            if (r0 != 0) goto L_0x0021
            io.reactivex.internal.util.AppendOnlyLinkedArrayList r0 = new io.reactivex.internal.util.AppendOnlyLinkedArrayList     // Catch:{ all -> 0x003b }
            r1 = 4
            r0.<init>(r1)     // Catch:{ all -> 0x003b }
            r2.f62172c = r0     // Catch:{ all -> 0x003b }
        L_0x0021:
            java.lang.Object r3 = p218io.reactivex.internal.util.NotificationLite.error(r3)     // Catch:{ all -> 0x003b }
            r0.setFirst(r3)     // Catch:{ all -> 0x003b }
            monitor-exit(r2)     // Catch:{ all -> 0x003b }
            return
        L_0x002a:
            r0 = 0
            r2.f62171b = r1     // Catch:{ all -> 0x003b }
            r1 = 0
        L_0x002e:
            monitor-exit(r2)     // Catch:{ all -> 0x003b }
            if (r1 == 0) goto L_0x0035
            p218io.reactivex.plugins.RxJavaPlugins.onError(r3)
            return
        L_0x0035:
            io.reactivex.processors.FlowableProcessor<T> r0 = r2.f62170a
            r0.onError(r3)
            return
        L_0x003b:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x003b }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p218io.reactivex.processors.C22233a.onError(java.lang.Throwable):void");
    }

    public void onComplete() {
        if (!this.f62173d) {
            synchronized (this) {
                if (!this.f62173d) {
                    this.f62173d = true;
                    if (this.f62171b) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f62172c;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.f62172c = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.add(NotificationLite.complete());
                        return;
                    }
                    this.f62171b = true;
                    this.f62170a.onComplete();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo185293a() {
        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList;
        while (true) {
            synchronized (this) {
                appendOnlyLinkedArrayList = this.f62172c;
                if (appendOnlyLinkedArrayList == null) {
                    this.f62171b = false;
                    return;
                }
                this.f62172c = null;
            }
            appendOnlyLinkedArrayList.accept((Subscriber<? super U>) this.f62170a);
        }
        while (true) {
        }
    }

    public boolean hasSubscribers() {
        return this.f62170a.hasSubscribers();
    }

    public boolean hasThrowable() {
        return this.f62170a.hasThrowable();
    }

    public Throwable getThrowable() {
        return this.f62170a.getThrowable();
    }

    public boolean hasComplete() {
        return this.f62170a.hasComplete();
    }
}
