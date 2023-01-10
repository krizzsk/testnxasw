package p218io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p218io.reactivex.Observable;
import p218io.reactivex.Observer;
import p218io.reactivex.disposables.Disposable;

/* renamed from: io.reactivex.internal.operators.observable.ObservableCache */
public final class ObservableCache<T> extends C22215a<T, T> implements Observer<T> {

    /* renamed from: d */
    static final CacheDisposable[] f61508d = new CacheDisposable[0];

    /* renamed from: e */
    static final CacheDisposable[] f61509e = new CacheDisposable[0];

    /* renamed from: a */
    final AtomicBoolean f61510a = new AtomicBoolean();

    /* renamed from: b */
    final int f61511b;

    /* renamed from: c */
    final AtomicReference<CacheDisposable<T>[]> f61512c;

    /* renamed from: f */
    volatile long f61513f;

    /* renamed from: g */
    final Node<T> f61514g;

    /* renamed from: h */
    Node<T> f61515h;

    /* renamed from: i */
    int f61516i;

    /* renamed from: j */
    Throwable f61517j;

    /* renamed from: k */
    volatile boolean f61518k;

    public void onSubscribe(Disposable disposable) {
    }

    public ObservableCache(Observable<T> observable, int i) {
        super(observable);
        this.f61511b = i;
        Node<T> node = new Node<>(i);
        this.f61514g = node;
        this.f61515h = node;
        this.f61512c = new AtomicReference<>(f61508d);
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super T> observer) {
        CacheDisposable cacheDisposable = new CacheDisposable(observer, this);
        observer.onSubscribe(cacheDisposable);
        mo184589a(cacheDisposable);
        if (this.f61510a.get() || !this.f61510a.compareAndSet(false, true)) {
            mo184594c(cacheDisposable);
        } else {
            this.source.subscribe(this);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo184590a() {
        return this.f61510a.get();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo184592b() {
        return ((CacheDisposable[]) this.f61512c.get()).length != 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public long mo184593c() {
        return this.f61513f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo184589a(CacheDisposable<T> cacheDisposable) {
        CacheDisposable[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = (CacheDisposable[]) this.f61512c.get();
            if (cacheDisposableArr != f61509e) {
                int length = cacheDisposableArr.length;
                cacheDisposableArr2 = new CacheDisposable[(length + 1)];
                System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr2, 0, length);
                cacheDisposableArr2[length] = cacheDisposable;
            } else {
                return;
            }
        } while (!this.f61512c.compareAndSet(cacheDisposableArr, cacheDisposableArr2));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo184591b(CacheDisposable<T> cacheDisposable) {
        CacheDisposable<T>[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = (CacheDisposable[]) this.f61512c.get();
            int length = cacheDisposableArr.length;
            if (length != 0) {
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (cacheDisposableArr[i2] == cacheDisposable) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        cacheDisposableArr2 = f61508d;
                    } else {
                        CacheDisposable[] cacheDisposableArr3 = new CacheDisposable[(length - 1)];
                        System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr3, 0, i);
                        System.arraycopy(cacheDisposableArr, i + 1, cacheDisposableArr3, i, (length - i) - 1);
                        cacheDisposableArr2 = cacheDisposableArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.f61512c.compareAndSet(cacheDisposableArr, cacheDisposableArr2));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo184594c(CacheDisposable<T> cacheDisposable) {
        if (cacheDisposable.getAndIncrement() == 0) {
            long j = cacheDisposable.index;
            int i = cacheDisposable.offset;
            Node<T> node = cacheDisposable.node;
            Observer<? super T> observer = cacheDisposable.downstream;
            int i2 = this.f61511b;
            int i3 = 1;
            while (!cacheDisposable.disposed) {
                boolean z = this.f61518k;
                boolean z2 = this.f61513f == j;
                if (z && z2) {
                    cacheDisposable.node = null;
                    Throwable th = this.f61517j;
                    if (th != null) {
                        observer.onError(th);
                        return;
                    } else {
                        observer.onComplete();
                        return;
                    }
                } else if (!z2) {
                    if (i == i2) {
                        node = node.next;
                        i = 0;
                    }
                    observer.onNext(node.values[i]);
                    i++;
                    j++;
                } else {
                    cacheDisposable.index = j;
                    cacheDisposable.offset = i;
                    cacheDisposable.node = node;
                    i3 = cacheDisposable.addAndGet(-i3);
                    if (i3 == 0) {
                        return;
                    }
                }
            }
            cacheDisposable.node = null;
        }
    }

    public void onNext(T t) {
        int i = this.f61516i;
        if (i == this.f61511b) {
            Node<T> node = new Node<>(i);
            node.values[0] = t;
            this.f61516i = 1;
            this.f61515h.next = node;
            this.f61515h = node;
        } else {
            this.f61515h.values[i] = t;
            this.f61516i = i + 1;
        }
        this.f61513f++;
        for (CacheDisposable c : (CacheDisposable[]) this.f61512c.get()) {
            mo184594c(c);
        }
    }

    public void onError(Throwable th) {
        this.f61517j = th;
        this.f61518k = true;
        for (CacheDisposable c : (CacheDisposable[]) this.f61512c.getAndSet(f61509e)) {
            mo184594c(c);
        }
    }

    public void onComplete() {
        this.f61518k = true;
        for (CacheDisposable c : (CacheDisposable[]) this.f61512c.getAndSet(f61509e)) {
            mo184594c(c);
        }
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableCache$CacheDisposable */
    static final class CacheDisposable<T> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = 6770240836423125754L;
        volatile boolean disposed;
        final Observer<? super T> downstream;
        long index;
        Node<T> node;
        int offset;
        final ObservableCache<T> parent;

        CacheDisposable(Observer<? super T> observer, ObservableCache<T> observableCache) {
            this.downstream = observer;
            this.parent = observableCache;
            this.node = observableCache.f61514g;
        }

        public void dispose() {
            if (!this.disposed) {
                this.disposed = true;
                this.parent.mo184591b(this);
            }
        }

        public boolean isDisposed() {
            return this.disposed;
        }
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableCache$Node */
    static final class Node<T> {
        volatile Node<T> next;
        final T[] values;

        Node(int i) {
            this.values = (Object[]) new Object[i];
        }
    }
}
