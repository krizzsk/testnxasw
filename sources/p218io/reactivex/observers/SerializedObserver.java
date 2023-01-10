package p218io.reactivex.observers;

import p218io.reactivex.Observer;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.internal.disposables.DisposableHelper;
import p218io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import p218io.reactivex.internal.util.NotificationLite;

/* renamed from: io.reactivex.observers.SerializedObserver */
public final class SerializedObserver<T> implements Observer<T>, Disposable {

    /* renamed from: c */
    static final int f62084c = 4;

    /* renamed from: a */
    final Observer<? super T> f62085a;

    /* renamed from: b */
    final boolean f62086b;

    /* renamed from: d */
    Disposable f62087d;

    /* renamed from: e */
    boolean f62088e;

    /* renamed from: f */
    AppendOnlyLinkedArrayList<Object> f62089f;

    /* renamed from: g */
    volatile boolean f62090g;

    public SerializedObserver(Observer<? super T> observer) {
        this(observer, false);
    }

    public SerializedObserver(Observer<? super T> observer, boolean z) {
        this.f62085a = observer;
        this.f62086b = z;
    }

    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f62087d, disposable)) {
            this.f62087d = disposable;
            this.f62085a.onSubscribe(this);
        }
    }

    public void dispose() {
        this.f62087d.dispose();
    }

    public boolean isDisposed() {
        return this.f62087d.isDisposed();
    }

    public void onNext(T t) {
        if (!this.f62090g) {
            if (t == null) {
                this.f62087d.dispose();
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                return;
            }
            synchronized (this) {
                if (!this.f62090g) {
                    if (this.f62088e) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f62089f;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.f62089f = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.add(NotificationLite.next(t));
                        return;
                    }
                    this.f62088e = true;
                    this.f62085a.onNext(t);
                    mo185167a();
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
        r2.f62085a.onError(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0043, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onError(java.lang.Throwable r3) {
        /*
            r2 = this;
            boolean r0 = r2.f62090g
            if (r0 == 0) goto L_0x0008
            p218io.reactivex.plugins.RxJavaPlugins.onError(r3)
            return
        L_0x0008:
            monitor-enter(r2)
            boolean r0 = r2.f62090g     // Catch:{ all -> 0x0044 }
            r1 = 1
            if (r0 == 0) goto L_0x000f
            goto L_0x0037
        L_0x000f:
            boolean r0 = r2.f62088e     // Catch:{ all -> 0x0044 }
            if (r0 == 0) goto L_0x0032
            r2.f62090g = r1     // Catch:{ all -> 0x0044 }
            io.reactivex.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> r0 = r2.f62089f     // Catch:{ all -> 0x0044 }
            if (r0 != 0) goto L_0x0021
            io.reactivex.internal.util.AppendOnlyLinkedArrayList r0 = new io.reactivex.internal.util.AppendOnlyLinkedArrayList     // Catch:{ all -> 0x0044 }
            r1 = 4
            r0.<init>(r1)     // Catch:{ all -> 0x0044 }
            r2.f62089f = r0     // Catch:{ all -> 0x0044 }
        L_0x0021:
            java.lang.Object r3 = p218io.reactivex.internal.util.NotificationLite.error(r3)     // Catch:{ all -> 0x0044 }
            boolean r1 = r2.f62086b     // Catch:{ all -> 0x0044 }
            if (r1 == 0) goto L_0x002d
            r0.add(r3)     // Catch:{ all -> 0x0044 }
            goto L_0x0030
        L_0x002d:
            r0.setFirst(r3)     // Catch:{ all -> 0x0044 }
        L_0x0030:
            monitor-exit(r2)     // Catch:{ all -> 0x0044 }
            return
        L_0x0032:
            r2.f62090g = r1     // Catch:{ all -> 0x0044 }
            r2.f62088e = r1     // Catch:{ all -> 0x0044 }
            r1 = 0
        L_0x0037:
            monitor-exit(r2)     // Catch:{ all -> 0x0044 }
            if (r1 == 0) goto L_0x003e
            p218io.reactivex.plugins.RxJavaPlugins.onError(r3)
            return
        L_0x003e:
            io.reactivex.Observer<? super T> r0 = r2.f62085a
            r0.onError(r3)
            return
        L_0x0044:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0044 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p218io.reactivex.observers.SerializedObserver.onError(java.lang.Throwable):void");
    }

    public void onComplete() {
        if (!this.f62090g) {
            synchronized (this) {
                if (!this.f62090g) {
                    if (this.f62088e) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f62089f;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.f62089f = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.add(NotificationLite.complete());
                        return;
                    }
                    this.f62090g = true;
                    this.f62088e = true;
                    this.f62085a.onComplete();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo185167a() {
        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList;
        do {
            synchronized (this) {
                appendOnlyLinkedArrayList = this.f62089f;
                if (appendOnlyLinkedArrayList == null) {
                    this.f62088e = false;
                    return;
                }
                this.f62089f = null;
            }
        } while (!appendOnlyLinkedArrayList.accept((Observer<? super U>) this.f62085a));
    }
}
