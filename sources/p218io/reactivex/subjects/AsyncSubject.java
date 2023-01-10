package p218io.reactivex.subjects;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import p218io.reactivex.Observer;
import p218io.reactivex.annotations.CheckReturnValue;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.internal.functions.ObjectHelper;
import p218io.reactivex.internal.observers.DeferredScalarDisposable;
import p218io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.subjects.AsyncSubject */
public final class AsyncSubject<T> extends Subject<T> {

    /* renamed from: a */
    static final AsyncDisposable[] f62185a = new AsyncDisposable[0];

    /* renamed from: b */
    static final AsyncDisposable[] f62186b = new AsyncDisposable[0];

    /* renamed from: c */
    final AtomicReference<AsyncDisposable<T>[]> f62187c = new AtomicReference<>(f62185a);

    /* renamed from: d */
    Throwable f62188d;

    /* renamed from: e */
    T f62189e;

    @CheckReturnValue
    public static <T> AsyncSubject<T> create() {
        return new AsyncSubject<>();
    }

    AsyncSubject() {
    }

    public void onSubscribe(Disposable disposable) {
        if (this.f62187c.get() == f62186b) {
            disposable.dispose();
        }
    }

    public void onNext(T t) {
        ObjectHelper.requireNonNull(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f62187c.get() != f62186b) {
            this.f62189e = t;
        }
    }

    public void onError(Throwable th) {
        ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        AsyncDisposable<T>[] asyncDisposableArr = this.f62187c.get();
        AsyncDisposable<T>[] asyncDisposableArr2 = f62186b;
        if (asyncDisposableArr == asyncDisposableArr2) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.f62189e = null;
        this.f62188d = th;
        for (AsyncDisposable onError : (AsyncDisposable[]) this.f62187c.getAndSet(asyncDisposableArr2)) {
            onError.onError(th);
        }
    }

    public void onComplete() {
        AsyncDisposable<T>[] asyncDisposableArr = this.f62187c.get();
        AsyncDisposable<T>[] asyncDisposableArr2 = f62186b;
        if (asyncDisposableArr != asyncDisposableArr2) {
            T t = this.f62189e;
            AsyncDisposable[] asyncDisposableArr3 = (AsyncDisposable[]) this.f62187c.getAndSet(asyncDisposableArr2);
            int i = 0;
            if (t == null) {
                int length = asyncDisposableArr3.length;
                while (i < length) {
                    asyncDisposableArr3[i].onComplete();
                    i++;
                }
                return;
            }
            int length2 = asyncDisposableArr3.length;
            while (i < length2) {
                asyncDisposableArr3[i].complete(t);
                i++;
            }
        }
    }

    public boolean hasObservers() {
        return ((AsyncDisposable[]) this.f62187c.get()).length != 0;
    }

    public boolean hasThrowable() {
        return this.f62187c.get() == f62186b && this.f62188d != null;
    }

    public boolean hasComplete() {
        return this.f62187c.get() == f62186b && this.f62188d == null;
    }

    public Throwable getThrowable() {
        if (this.f62187c.get() == f62186b) {
            return this.f62188d;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super T> observer) {
        AsyncDisposable asyncDisposable = new AsyncDisposable(observer, this);
        observer.onSubscribe(asyncDisposable);
        if (!mo185312a(asyncDisposable)) {
            Throwable th = this.f62188d;
            if (th != null) {
                observer.onError(th);
                return;
            }
            T t = this.f62189e;
            if (t != null) {
                asyncDisposable.complete(t);
            } else {
                asyncDisposable.onComplete();
            }
        } else if (asyncDisposable.isDisposed()) {
            mo185313b(asyncDisposable);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo185312a(AsyncDisposable<T> asyncDisposable) {
        AsyncDisposable[] asyncDisposableArr;
        AsyncDisposable[] asyncDisposableArr2;
        do {
            asyncDisposableArr = (AsyncDisposable[]) this.f62187c.get();
            if (asyncDisposableArr == f62186b) {
                return false;
            }
            int length = asyncDisposableArr.length;
            asyncDisposableArr2 = new AsyncDisposable[(length + 1)];
            System.arraycopy(asyncDisposableArr, 0, asyncDisposableArr2, 0, length);
            asyncDisposableArr2[length] = asyncDisposable;
        } while (!this.f62187c.compareAndSet(asyncDisposableArr, asyncDisposableArr2));
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo185313b(AsyncDisposable<T> asyncDisposable) {
        AsyncDisposable<T>[] asyncDisposableArr;
        AsyncDisposable[] asyncDisposableArr2;
        do {
            asyncDisposableArr = (AsyncDisposable[]) this.f62187c.get();
            int length = asyncDisposableArr.length;
            if (length != 0) {
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (asyncDisposableArr[i2] == asyncDisposable) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        asyncDisposableArr2 = f62185a;
                    } else {
                        AsyncDisposable[] asyncDisposableArr3 = new AsyncDisposable[(length - 1)];
                        System.arraycopy(asyncDisposableArr, 0, asyncDisposableArr3, 0, i);
                        System.arraycopy(asyncDisposableArr, i + 1, asyncDisposableArr3, i, (length - i) - 1);
                        asyncDisposableArr2 = asyncDisposableArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.f62187c.compareAndSet(asyncDisposableArr, asyncDisposableArr2));
    }

    public boolean hasValue() {
        return this.f62187c.get() == f62186b && this.f62189e != null;
    }

    public T getValue() {
        if (this.f62187c.get() == f62186b) {
            return this.f62189e;
        }
        return null;
    }

    @Deprecated
    public Object[] getValues() {
        Object value = getValue();
        if (value == null) {
            return new Object[0];
        }
        return new Object[]{value};
    }

    @Deprecated
    public T[] getValues(T[] tArr) {
        T value = getValue();
        if (value == null) {
            if (tArr.length != 0) {
                tArr[0] = null;
            }
            return tArr;
        }
        if (tArr.length == 0) {
            tArr = Arrays.copyOf(tArr, 1);
        }
        tArr[0] = value;
        if (tArr.length != 1) {
            tArr[1] = null;
        }
        return tArr;
    }

    /* renamed from: io.reactivex.subjects.AsyncSubject$AsyncDisposable */
    static final class AsyncDisposable<T> extends DeferredScalarDisposable<T> {
        private static final long serialVersionUID = 5629876084736248016L;
        final AsyncSubject<T> parent;

        AsyncDisposable(Observer<? super T> observer, AsyncSubject<T> asyncSubject) {
            super(observer);
            this.parent = asyncSubject;
        }

        public void dispose() {
            if (super.tryDispose()) {
                this.parent.mo185313b(this);
            }
        }

        /* access modifiers changed from: package-private */
        public void onComplete() {
            if (!isDisposed()) {
                this.downstream.onComplete();
            }
        }

        /* access modifiers changed from: package-private */
        public void onError(Throwable th) {
            if (isDisposed()) {
                RxJavaPlugins.onError(th);
            } else {
                this.downstream.onError(th);
            }
        }
    }
}
