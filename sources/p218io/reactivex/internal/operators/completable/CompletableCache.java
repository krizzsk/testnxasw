package p218io.reactivex.internal.operators.completable;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p218io.reactivex.Completable;
import p218io.reactivex.CompletableObserver;
import p218io.reactivex.CompletableSource;
import p218io.reactivex.disposables.Disposable;

/* renamed from: io.reactivex.internal.operators.completable.CompletableCache */
public final class CompletableCache extends Completable implements CompletableObserver {

    /* renamed from: a */
    static final InnerCompletableCache[] f60854a = new InnerCompletableCache[0];

    /* renamed from: b */
    static final InnerCompletableCache[] f60855b = new InnerCompletableCache[0];

    /* renamed from: c */
    final CompletableSource f60856c;

    /* renamed from: d */
    final AtomicReference<InnerCompletableCache[]> f60857d = new AtomicReference<>(f60854a);

    /* renamed from: e */
    final AtomicBoolean f60858e = new AtomicBoolean();

    /* renamed from: f */
    Throwable f60859f;

    public void onSubscribe(Disposable disposable) {
    }

    public CompletableCache(CompletableSource completableSource) {
        this.f60856c = completableSource;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(CompletableObserver completableObserver) {
        InnerCompletableCache innerCompletableCache = new InnerCompletableCache(completableObserver);
        completableObserver.onSubscribe(innerCompletableCache);
        if (mo184070a(innerCompletableCache)) {
            if (innerCompletableCache.isDisposed()) {
                mo184071b(innerCompletableCache);
            }
            if (this.f60858e.compareAndSet(false, true)) {
                this.f60856c.subscribe(this);
                return;
            }
            return;
        }
        Throwable th = this.f60859f;
        if (th != null) {
            completableObserver.onError(th);
        } else {
            completableObserver.onComplete();
        }
    }

    public void onError(Throwable th) {
        this.f60859f = th;
        for (InnerCompletableCache innerCompletableCache : this.f60857d.getAndSet(f60855b)) {
            if (!innerCompletableCache.get()) {
                innerCompletableCache.downstream.onError(th);
            }
        }
    }

    public void onComplete() {
        for (InnerCompletableCache innerCompletableCache : this.f60857d.getAndSet(f60855b)) {
            if (!innerCompletableCache.get()) {
                innerCompletableCache.downstream.onComplete();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo184070a(InnerCompletableCache innerCompletableCache) {
        InnerCompletableCache[] innerCompletableCacheArr;
        InnerCompletableCache[] innerCompletableCacheArr2;
        do {
            innerCompletableCacheArr = this.f60857d.get();
            if (innerCompletableCacheArr == f60855b) {
                return false;
            }
            int length = innerCompletableCacheArr.length;
            innerCompletableCacheArr2 = new InnerCompletableCache[(length + 1)];
            System.arraycopy(innerCompletableCacheArr, 0, innerCompletableCacheArr2, 0, length);
            innerCompletableCacheArr2[length] = innerCompletableCache;
        } while (!this.f60857d.compareAndSet(innerCompletableCacheArr, innerCompletableCacheArr2));
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo184071b(InnerCompletableCache innerCompletableCache) {
        InnerCompletableCache[] innerCompletableCacheArr;
        InnerCompletableCache[] innerCompletableCacheArr2;
        do {
            innerCompletableCacheArr = this.f60857d.get();
            int length = innerCompletableCacheArr.length;
            if (length != 0) {
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (innerCompletableCacheArr[i2] == innerCompletableCache) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        innerCompletableCacheArr2 = f60854a;
                    } else {
                        InnerCompletableCache[] innerCompletableCacheArr3 = new InnerCompletableCache[(length - 1)];
                        System.arraycopy(innerCompletableCacheArr, 0, innerCompletableCacheArr3, 0, i);
                        System.arraycopy(innerCompletableCacheArr, i + 1, innerCompletableCacheArr3, i, (length - i) - 1);
                        innerCompletableCacheArr2 = innerCompletableCacheArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.f60857d.compareAndSet(innerCompletableCacheArr, innerCompletableCacheArr2));
    }

    /* renamed from: io.reactivex.internal.operators.completable.CompletableCache$InnerCompletableCache */
    final class InnerCompletableCache extends AtomicBoolean implements Disposable {
        private static final long serialVersionUID = 8943152917179642732L;
        final CompletableObserver downstream;

        InnerCompletableCache(CompletableObserver completableObserver) {
            this.downstream = completableObserver;
        }

        public boolean isDisposed() {
            return get();
        }

        public void dispose() {
            if (compareAndSet(false, true)) {
                CompletableCache.this.mo184071b(this);
            }
        }
    }
}
