package p218io.reactivex.subjects;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p218io.reactivex.Completable;
import p218io.reactivex.CompletableObserver;
import p218io.reactivex.annotations.CheckReturnValue;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.internal.functions.ObjectHelper;
import p218io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.subjects.CompletableSubject */
public final class CompletableSubject extends Completable implements CompletableObserver {

    /* renamed from: b */
    static final CompletableDisposable[] f62200b = new CompletableDisposable[0];

    /* renamed from: c */
    static final CompletableDisposable[] f62201c = new CompletableDisposable[0];

    /* renamed from: a */
    final AtomicReference<CompletableDisposable[]> f62202a = new AtomicReference<>(f62200b);

    /* renamed from: d */
    final AtomicBoolean f62203d = new AtomicBoolean();

    /* renamed from: e */
    Throwable f62204e;

    @CheckReturnValue
    public static CompletableSubject create() {
        return new CompletableSubject();
    }

    CompletableSubject() {
    }

    public void onSubscribe(Disposable disposable) {
        if (this.f62202a.get() == f62201c) {
            disposable.dispose();
        }
    }

    public void onError(Throwable th) {
        ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f62203d.compareAndSet(false, true)) {
            this.f62204e = th;
            for (CompletableDisposable completableDisposable : this.f62202a.getAndSet(f62201c)) {
                completableDisposable.downstream.onError(th);
            }
            return;
        }
        RxJavaPlugins.onError(th);
    }

    public void onComplete() {
        if (this.f62203d.compareAndSet(false, true)) {
            for (CompletableDisposable completableDisposable : this.f62202a.getAndSet(f62201c)) {
                completableDisposable.downstream.onComplete();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(CompletableObserver completableObserver) {
        CompletableDisposable completableDisposable = new CompletableDisposable(completableObserver, this);
        completableObserver.onSubscribe(completableDisposable);
        if (!mo185337a(completableDisposable)) {
            Throwable th = this.f62204e;
            if (th != null) {
                completableObserver.onError(th);
            } else {
                completableObserver.onComplete();
            }
        } else if (completableDisposable.isDisposed()) {
            mo185338b(completableDisposable);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo185337a(CompletableDisposable completableDisposable) {
        CompletableDisposable[] completableDisposableArr;
        CompletableDisposable[] completableDisposableArr2;
        do {
            completableDisposableArr = this.f62202a.get();
            if (completableDisposableArr == f62201c) {
                return false;
            }
            int length = completableDisposableArr.length;
            completableDisposableArr2 = new CompletableDisposable[(length + 1)];
            System.arraycopy(completableDisposableArr, 0, completableDisposableArr2, 0, length);
            completableDisposableArr2[length] = completableDisposable;
        } while (!this.f62202a.compareAndSet(completableDisposableArr, completableDisposableArr2));
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo185338b(CompletableDisposable completableDisposable) {
        CompletableDisposable[] completableDisposableArr;
        CompletableDisposable[] completableDisposableArr2;
        do {
            completableDisposableArr = this.f62202a.get();
            int length = completableDisposableArr.length;
            if (length != 0) {
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (completableDisposableArr[i2] == completableDisposable) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        completableDisposableArr2 = f62200b;
                    } else {
                        CompletableDisposable[] completableDisposableArr3 = new CompletableDisposable[(length - 1)];
                        System.arraycopy(completableDisposableArr, 0, completableDisposableArr3, 0, i);
                        System.arraycopy(completableDisposableArr, i + 1, completableDisposableArr3, i, (length - i) - 1);
                        completableDisposableArr2 = completableDisposableArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.f62202a.compareAndSet(completableDisposableArr, completableDisposableArr2));
    }

    public Throwable getThrowable() {
        if (this.f62202a.get() == f62201c) {
            return this.f62204e;
        }
        return null;
    }

    public boolean hasThrowable() {
        return this.f62202a.get() == f62201c && this.f62204e != null;
    }

    public boolean hasComplete() {
        return this.f62202a.get() == f62201c && this.f62204e == null;
    }

    public boolean hasObservers() {
        return this.f62202a.get().length != 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo185336a() {
        return this.f62202a.get().length;
    }

    /* renamed from: io.reactivex.subjects.CompletableSubject$CompletableDisposable */
    static final class CompletableDisposable extends AtomicReference<CompletableSubject> implements Disposable {
        private static final long serialVersionUID = -7650903191002190468L;
        final CompletableObserver downstream;

        CompletableDisposable(CompletableObserver completableObserver, CompletableSubject completableSubject) {
            this.downstream = completableObserver;
            lazySet(completableSubject);
        }

        public void dispose() {
            CompletableSubject completableSubject = (CompletableSubject) getAndSet((Object) null);
            if (completableSubject != null) {
                completableSubject.mo185338b(this);
            }
        }

        public boolean isDisposed() {
            return get() == null;
        }
    }
}
