package p218io.reactivex.internal.operators.maybe;

import java.util.concurrent.atomic.AtomicReference;
import p218io.reactivex.Maybe;
import p218io.reactivex.MaybeObserver;
import p218io.reactivex.MaybeSource;
import p218io.reactivex.disposables.Disposable;

/* renamed from: io.reactivex.internal.operators.maybe.MaybeCache */
public final class MaybeCache<T> extends Maybe<T> implements MaybeObserver<T> {

    /* renamed from: a */
    static final CacheDisposable[] f61313a = new CacheDisposable[0];

    /* renamed from: b */
    static final CacheDisposable[] f61314b = new CacheDisposable[0];

    /* renamed from: c */
    final AtomicReference<MaybeSource<T>> f61315c;

    /* renamed from: d */
    final AtomicReference<CacheDisposable<T>[]> f61316d = new AtomicReference<>(f61313a);

    /* renamed from: e */
    T f61317e;

    /* renamed from: f */
    Throwable f61318f;

    public void onSubscribe(Disposable disposable) {
    }

    public MaybeCache(MaybeSource<T> maybeSource) {
        this.f61315c = new AtomicReference<>(maybeSource);
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        CacheDisposable cacheDisposable = new CacheDisposable(maybeObserver, this);
        maybeObserver.onSubscribe(cacheDisposable);
        if (mo184442a(cacheDisposable)) {
            if (cacheDisposable.isDisposed()) {
                mo184443b(cacheDisposable);
                return;
            }
            MaybeSource andSet = this.f61315c.getAndSet((Object) null);
            if (andSet != null) {
                andSet.subscribe(this);
            }
        } else if (!cacheDisposable.isDisposed()) {
            Throwable th = this.f61318f;
            if (th != null) {
                maybeObserver.onError(th);
                return;
            }
            T t = this.f61317e;
            if (t != null) {
                maybeObserver.onSuccess(t);
            } else {
                maybeObserver.onComplete();
            }
        }
    }

    public void onSuccess(T t) {
        this.f61317e = t;
        for (CacheDisposable cacheDisposable : (CacheDisposable[]) this.f61316d.getAndSet(f61314b)) {
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.downstream.onSuccess(t);
            }
        }
    }

    public void onError(Throwable th) {
        this.f61318f = th;
        for (CacheDisposable cacheDisposable : (CacheDisposable[]) this.f61316d.getAndSet(f61314b)) {
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.downstream.onError(th);
            }
        }
    }

    public void onComplete() {
        for (CacheDisposable cacheDisposable : (CacheDisposable[]) this.f61316d.getAndSet(f61314b)) {
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.downstream.onComplete();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo184442a(CacheDisposable<T> cacheDisposable) {
        CacheDisposable[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = (CacheDisposable[]) this.f61316d.get();
            if (cacheDisposableArr == f61314b) {
                return false;
            }
            int length = cacheDisposableArr.length;
            cacheDisposableArr2 = new CacheDisposable[(length + 1)];
            System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr2, 0, length);
            cacheDisposableArr2[length] = cacheDisposable;
        } while (!this.f61316d.compareAndSet(cacheDisposableArr, cacheDisposableArr2));
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo184443b(CacheDisposable<T> cacheDisposable) {
        CacheDisposable<T>[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = (CacheDisposable[]) this.f61316d.get();
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
                        cacheDisposableArr2 = f61313a;
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
        } while (!this.f61316d.compareAndSet(cacheDisposableArr, cacheDisposableArr2));
    }

    /* renamed from: io.reactivex.internal.operators.maybe.MaybeCache$CacheDisposable */
    static final class CacheDisposable<T> extends AtomicReference<MaybeCache<T>> implements Disposable {
        private static final long serialVersionUID = -5791853038359966195L;
        final MaybeObserver<? super T> downstream;

        CacheDisposable(MaybeObserver<? super T> maybeObserver, MaybeCache<T> maybeCache) {
            super(maybeCache);
            this.downstream = maybeObserver;
        }

        public void dispose() {
            MaybeCache maybeCache = (MaybeCache) getAndSet((Object) null);
            if (maybeCache != null) {
                maybeCache.mo184443b(this);
            }
        }

        public boolean isDisposed() {
            return get() == null;
        }
    }
}
