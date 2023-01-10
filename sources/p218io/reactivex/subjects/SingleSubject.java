package p218io.reactivex.subjects;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p218io.reactivex.Single;
import p218io.reactivex.SingleObserver;
import p218io.reactivex.annotations.CheckReturnValue;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.internal.functions.ObjectHelper;
import p218io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.subjects.SingleSubject */
public final class SingleSubject<T> extends Single<T> implements SingleObserver<T> {

    /* renamed from: b */
    static final SingleDisposable[] f62221b = new SingleDisposable[0];

    /* renamed from: c */
    static final SingleDisposable[] f62222c = new SingleDisposable[0];

    /* renamed from: a */
    final AtomicReference<SingleDisposable<T>[]> f62223a = new AtomicReference<>(f62221b);

    /* renamed from: d */
    final AtomicBoolean f62224d = new AtomicBoolean();

    /* renamed from: e */
    T f62225e;

    /* renamed from: f */
    Throwable f62226f;

    @CheckReturnValue
    public static <T> SingleSubject<T> create() {
        return new SingleSubject<>();
    }

    SingleSubject() {
    }

    public void onSubscribe(Disposable disposable) {
        if (this.f62223a.get() == f62222c) {
            disposable.dispose();
        }
    }

    public void onSuccess(T t) {
        ObjectHelper.requireNonNull(t, "onSuccess called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f62224d.compareAndSet(false, true)) {
            this.f62225e = t;
            for (SingleDisposable singleDisposable : (SingleDisposable[]) this.f62223a.getAndSet(f62222c)) {
                singleDisposable.downstream.onSuccess(t);
            }
        }
    }

    public void onError(Throwable th) {
        ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f62224d.compareAndSet(false, true)) {
            this.f62226f = th;
            for (SingleDisposable singleDisposable : (SingleDisposable[]) this.f62223a.getAndSet(f62222c)) {
                singleDisposable.downstream.onError(th);
            }
            return;
        }
        RxJavaPlugins.onError(th);
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        SingleDisposable singleDisposable = new SingleDisposable(singleObserver, this);
        singleObserver.onSubscribe(singleDisposable);
        if (!mo185382a(singleDisposable)) {
            Throwable th = this.f62226f;
            if (th != null) {
                singleObserver.onError(th);
            } else {
                singleObserver.onSuccess(this.f62225e);
            }
        } else if (singleDisposable.isDisposed()) {
            mo185383b(singleDisposable);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo185382a(SingleDisposable<T> singleDisposable) {
        SingleDisposable[] singleDisposableArr;
        SingleDisposable[] singleDisposableArr2;
        do {
            singleDisposableArr = (SingleDisposable[]) this.f62223a.get();
            if (singleDisposableArr == f62222c) {
                return false;
            }
            int length = singleDisposableArr.length;
            singleDisposableArr2 = new SingleDisposable[(length + 1)];
            System.arraycopy(singleDisposableArr, 0, singleDisposableArr2, 0, length);
            singleDisposableArr2[length] = singleDisposable;
        } while (!this.f62223a.compareAndSet(singleDisposableArr, singleDisposableArr2));
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo185383b(SingleDisposable<T> singleDisposable) {
        SingleDisposable<T>[] singleDisposableArr;
        SingleDisposable[] singleDisposableArr2;
        do {
            singleDisposableArr = (SingleDisposable[]) this.f62223a.get();
            int length = singleDisposableArr.length;
            if (length != 0) {
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (singleDisposableArr[i2] == singleDisposable) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        singleDisposableArr2 = f62221b;
                    } else {
                        SingleDisposable[] singleDisposableArr3 = new SingleDisposable[(length - 1)];
                        System.arraycopy(singleDisposableArr, 0, singleDisposableArr3, 0, i);
                        System.arraycopy(singleDisposableArr, i + 1, singleDisposableArr3, i, (length - i) - 1);
                        singleDisposableArr2 = singleDisposableArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.f62223a.compareAndSet(singleDisposableArr, singleDisposableArr2));
    }

    public T getValue() {
        if (this.f62223a.get() == f62222c) {
            return this.f62225e;
        }
        return null;
    }

    public boolean hasValue() {
        return this.f62223a.get() == f62222c && this.f62225e != null;
    }

    public Throwable getThrowable() {
        if (this.f62223a.get() == f62222c) {
            return this.f62226f;
        }
        return null;
    }

    public boolean hasThrowable() {
        return this.f62223a.get() == f62222c && this.f62226f != null;
    }

    public boolean hasObservers() {
        return ((SingleDisposable[]) this.f62223a.get()).length != 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo185381a() {
        return ((SingleDisposable[]) this.f62223a.get()).length;
    }

    /* renamed from: io.reactivex.subjects.SingleSubject$SingleDisposable */
    static final class SingleDisposable<T> extends AtomicReference<SingleSubject<T>> implements Disposable {
        private static final long serialVersionUID = -7650903191002190468L;
        final SingleObserver<? super T> downstream;

        SingleDisposable(SingleObserver<? super T> singleObserver, SingleSubject<T> singleSubject) {
            this.downstream = singleObserver;
            lazySet(singleSubject);
        }

        public void dispose() {
            SingleSubject singleSubject = (SingleSubject) getAndSet((Object) null);
            if (singleSubject != null) {
                singleSubject.mo185383b(this);
            }
        }

        public boolean isDisposed() {
            return get() == null;
        }
    }
}
