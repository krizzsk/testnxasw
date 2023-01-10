package p218io.reactivex.internal.operators.single;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p218io.reactivex.Single;
import p218io.reactivex.SingleObserver;
import p218io.reactivex.SingleSource;
import p218io.reactivex.disposables.Disposable;

/* renamed from: io.reactivex.internal.operators.single.SingleCache */
public final class SingleCache<T> extends Single<T> implements SingleObserver<T> {

    /* renamed from: a */
    static final CacheDisposable[] f61851a = new CacheDisposable[0];

    /* renamed from: b */
    static final CacheDisposable[] f61852b = new CacheDisposable[0];

    /* renamed from: c */
    final SingleSource<? extends T> f61853c;

    /* renamed from: d */
    final AtomicInteger f61854d = new AtomicInteger();

    /* renamed from: e */
    final AtomicReference<CacheDisposable<T>[]> f61855e = new AtomicReference<>(f61851a);

    /* renamed from: f */
    T f61856f;

    /* renamed from: g */
    Throwable f61857g;

    public void onSubscribe(Disposable disposable) {
    }

    public SingleCache(SingleSource<? extends T> singleSource) {
        this.f61853c = singleSource;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        CacheDisposable cacheDisposable = new CacheDisposable(singleObserver, this);
        singleObserver.onSubscribe(cacheDisposable);
        if (mo184883a(cacheDisposable)) {
            if (cacheDisposable.isDisposed()) {
                mo184884b(cacheDisposable);
            }
            if (this.f61854d.getAndIncrement() == 0) {
                this.f61853c.subscribe(this);
                return;
            }
            return;
        }
        Throwable th = this.f61857g;
        if (th != null) {
            singleObserver.onError(th);
        } else {
            singleObserver.onSuccess(this.f61856f);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo184883a(CacheDisposable<T> cacheDisposable) {
        CacheDisposable[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = (CacheDisposable[]) this.f61855e.get();
            if (cacheDisposableArr == f61852b) {
                return false;
            }
            int length = cacheDisposableArr.length;
            cacheDisposableArr2 = new CacheDisposable[(length + 1)];
            System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr2, 0, length);
            cacheDisposableArr2[length] = cacheDisposable;
        } while (!this.f61855e.compareAndSet(cacheDisposableArr, cacheDisposableArr2));
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo184884b(CacheDisposable<T> cacheDisposable) {
        CacheDisposable<T>[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = (CacheDisposable[]) this.f61855e.get();
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
                        cacheDisposableArr2 = f61851a;
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
        } while (!this.f61855e.compareAndSet(cacheDisposableArr, cacheDisposableArr2));
    }

    public void onSuccess(T t) {
        this.f61856f = t;
        for (CacheDisposable cacheDisposable : (CacheDisposable[]) this.f61855e.getAndSet(f61852b)) {
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.downstream.onSuccess(t);
            }
        }
    }

    public void onError(Throwable th) {
        this.f61857g = th;
        for (CacheDisposable cacheDisposable : (CacheDisposable[]) this.f61855e.getAndSet(f61852b)) {
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.downstream.onError(th);
            }
        }
    }

    /* renamed from: io.reactivex.internal.operators.single.SingleCache$CacheDisposable */
    static final class CacheDisposable<T> extends AtomicBoolean implements Disposable {
        private static final long serialVersionUID = 7514387411091976596L;
        final SingleObserver<? super T> downstream;
        final SingleCache<T> parent;

        CacheDisposable(SingleObserver<? super T> singleObserver, SingleCache<T> singleCache) {
            this.downstream = singleObserver;
            this.parent = singleCache;
        }

        public boolean isDisposed() {
            return get();
        }

        public void dispose() {
            if (compareAndSet(false, true)) {
                this.parent.mo184884b(this);
            }
        }
    }
}
