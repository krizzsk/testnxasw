package p218io.reactivex.internal.operators.observable;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p218io.reactivex.Observable;
import p218io.reactivex.Observer;
import p218io.reactivex.Scheduler;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.functions.Consumer;
import p218io.reactivex.internal.disposables.DisposableHelper;
import p218io.reactivex.internal.disposables.ResettableConnectable;
import p218io.reactivex.observables.ConnectableObservable;
import p218io.reactivex.plugins.RxJavaPlugins;
import p218io.reactivex.schedulers.Schedulers;

/* renamed from: io.reactivex.internal.operators.observable.ObservableRefCount */
public final class ObservableRefCount<T> extends Observable<T> {

    /* renamed from: a */
    final ConnectableObservable<T> f61665a;

    /* renamed from: b */
    final int f61666b;

    /* renamed from: c */
    final long f61667c;

    /* renamed from: d */
    final TimeUnit f61668d;

    /* renamed from: e */
    final Scheduler f61669e;

    /* renamed from: f */
    RefConnection f61670f;

    public ObservableRefCount(ConnectableObservable<T> connectableObservable) {
        this(connectableObservable, 1, 0, TimeUnit.NANOSECONDS, Schedulers.trampoline());
    }

    public ObservableRefCount(ConnectableObservable<T> connectableObservable, int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.f61665a = connectableObservable;
        this.f61666b = i;
        this.f61667c = j;
        this.f61668d = timeUnit;
        this.f61669e = scheduler;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super T> observer) {
        RefConnection refConnection;
        boolean z;
        synchronized (this) {
            refConnection = this.f61670f;
            if (refConnection == null) {
                refConnection = new RefConnection(this);
                this.f61670f = refConnection;
            }
            long j = refConnection.subscriberCount;
            if (j == 0 && refConnection.timer != null) {
                refConnection.timer.dispose();
            }
            long j2 = j + 1;
            refConnection.subscriberCount = j2;
            z = true;
            if (refConnection.connected || j2 != ((long) this.f61666b)) {
                z = false;
            } else {
                refConnection.connected = true;
            }
        }
        this.f61665a.subscribe(new RefCountObserver(observer, this, refConnection));
        if (z) {
            this.f61665a.connect(refConnection);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0040, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo184712a(p218io.reactivex.internal.operators.observable.ObservableRefCount.RefConnection r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            io.reactivex.internal.operators.observable.ObservableRefCount$RefConnection r0 = r5.f61670f     // Catch:{ all -> 0x0041 }
            if (r0 == 0) goto L_0x003f
            io.reactivex.internal.operators.observable.ObservableRefCount$RefConnection r0 = r5.f61670f     // Catch:{ all -> 0x0041 }
            if (r0 == r6) goto L_0x000a
            goto L_0x003f
        L_0x000a:
            long r0 = r6.subscriberCount     // Catch:{ all -> 0x0041 }
            r2 = 1
            long r0 = r0 - r2
            r6.subscriberCount = r0     // Catch:{ all -> 0x0041 }
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x003d
            boolean r0 = r6.connected     // Catch:{ all -> 0x0041 }
            if (r0 != 0) goto L_0x001c
            goto L_0x003d
        L_0x001c:
            long r0 = r5.f61667c     // Catch:{ all -> 0x0041 }
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x0027
            r5.mo184714c(r6)     // Catch:{ all -> 0x0041 }
            monitor-exit(r5)     // Catch:{ all -> 0x0041 }
            return
        L_0x0027:
            io.reactivex.internal.disposables.SequentialDisposable r0 = new io.reactivex.internal.disposables.SequentialDisposable     // Catch:{ all -> 0x0041 }
            r0.<init>()     // Catch:{ all -> 0x0041 }
            r6.timer = r0     // Catch:{ all -> 0x0041 }
            monitor-exit(r5)     // Catch:{ all -> 0x0041 }
            io.reactivex.Scheduler r1 = r5.f61669e
            long r2 = r5.f61667c
            java.util.concurrent.TimeUnit r4 = r5.f61668d
            io.reactivex.disposables.Disposable r6 = r1.scheduleDirect(r6, r2, r4)
            r0.replace(r6)
            return
        L_0x003d:
            monitor-exit(r5)     // Catch:{ all -> 0x0041 }
            return
        L_0x003f:
            monitor-exit(r5)     // Catch:{ all -> 0x0041 }
            return
        L_0x0041:
            r6 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0041 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: p218io.reactivex.internal.operators.observable.ObservableRefCount.mo184712a(io.reactivex.internal.operators.observable.ObservableRefCount$RefConnection):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo184713b(RefConnection refConnection) {
        synchronized (this) {
            if (this.f61670f != null && this.f61670f == refConnection) {
                this.f61670f = null;
                if (refConnection.timer != null) {
                    refConnection.timer.dispose();
                }
            }
            long j = refConnection.subscriberCount - 1;
            refConnection.subscriberCount = j;
            if (j == 0) {
                if (this.f61665a instanceof Disposable) {
                    ((Disposable) this.f61665a).dispose();
                } else if (this.f61665a instanceof ResettableConnectable) {
                    ((ResettableConnectable) this.f61665a).resetIf((Disposable) refConnection.get());
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo184714c(RefConnection refConnection) {
        synchronized (this) {
            if (refConnection.subscriberCount == 0 && refConnection == this.f61670f) {
                this.f61670f = null;
                Disposable disposable = (Disposable) refConnection.get();
                DisposableHelper.dispose(refConnection);
                if (this.f61665a instanceof Disposable) {
                    ((Disposable) this.f61665a).dispose();
                } else if (this.f61665a instanceof ResettableConnectable) {
                    if (disposable == null) {
                        refConnection.disconnectedEarly = true;
                    } else {
                        ((ResettableConnectable) this.f61665a).resetIf(disposable);
                    }
                }
            }
        }
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableRefCount$RefConnection */
    static final class RefConnection extends AtomicReference<Disposable> implements Consumer<Disposable>, Runnable {
        private static final long serialVersionUID = -4552101107598366241L;
        boolean connected;
        boolean disconnectedEarly;
        final ObservableRefCount<?> parent;
        long subscriberCount;
        Disposable timer;

        RefConnection(ObservableRefCount<?> observableRefCount) {
            this.parent = observableRefCount;
        }

        public void run() {
            this.parent.mo184714c(this);
        }

        public void accept(Disposable disposable) throws Exception {
            DisposableHelper.replace(this, disposable);
            synchronized (this.parent) {
                if (this.disconnectedEarly) {
                    ((ResettableConnectable) this.parent.f61665a).resetIf(disposable);
                }
            }
        }
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableRefCount$RefCountObserver */
    static final class RefCountObserver<T> extends AtomicBoolean implements Observer<T>, Disposable {
        private static final long serialVersionUID = -7419642935409022375L;
        final RefConnection connection;
        final Observer<? super T> downstream;
        final ObservableRefCount<T> parent;
        Disposable upstream;

        RefCountObserver(Observer<? super T> observer, ObservableRefCount<T> observableRefCount, RefConnection refConnection) {
            this.downstream = observer;
            this.parent = observableRefCount;
            this.connection = refConnection;
        }

        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        public void onError(Throwable th) {
            if (compareAndSet(false, true)) {
                this.parent.mo184713b(this.connection);
                this.downstream.onError(th);
                return;
            }
            RxJavaPlugins.onError(th);
        }

        public void onComplete() {
            if (compareAndSet(false, true)) {
                this.parent.mo184713b(this.connection);
                this.downstream.onComplete();
            }
        }

        public void dispose() {
            this.upstream.dispose();
            if (compareAndSet(false, true)) {
                this.parent.mo184712a(this.connection);
            }
        }

        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }
    }
}
