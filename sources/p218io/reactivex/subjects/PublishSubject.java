package p218io.reactivex.subjects;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p218io.reactivex.Observer;
import p218io.reactivex.annotations.CheckReturnValue;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.internal.functions.ObjectHelper;
import p218io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.subjects.PublishSubject */
public final class PublishSubject<T> extends Subject<T> {

    /* renamed from: a */
    static final PublishDisposable[] f62211a = new PublishDisposable[0];

    /* renamed from: b */
    static final PublishDisposable[] f62212b = new PublishDisposable[0];

    /* renamed from: c */
    final AtomicReference<PublishDisposable<T>[]> f62213c = new AtomicReference<>(f62212b);

    /* renamed from: d */
    Throwable f62214d;

    @CheckReturnValue
    public static <T> PublishSubject<T> create() {
        return new PublishSubject<>();
    }

    PublishSubject() {
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super T> observer) {
        PublishDisposable publishDisposable = new PublishDisposable(observer, this);
        observer.onSubscribe(publishDisposable);
        if (!mo185352a(publishDisposable)) {
            Throwable th = this.f62214d;
            if (th != null) {
                observer.onError(th);
            } else {
                observer.onComplete();
            }
        } else if (publishDisposable.isDisposed()) {
            mo185353b(publishDisposable);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo185352a(PublishDisposable<T> publishDisposable) {
        PublishDisposable[] publishDisposableArr;
        PublishDisposable[] publishDisposableArr2;
        do {
            publishDisposableArr = (PublishDisposable[]) this.f62213c.get();
            if (publishDisposableArr == f62211a) {
                return false;
            }
            int length = publishDisposableArr.length;
            publishDisposableArr2 = new PublishDisposable[(length + 1)];
            System.arraycopy(publishDisposableArr, 0, publishDisposableArr2, 0, length);
            publishDisposableArr2[length] = publishDisposable;
        } while (!this.f62213c.compareAndSet(publishDisposableArr, publishDisposableArr2));
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo185353b(PublishDisposable<T> publishDisposable) {
        PublishDisposable<T>[] publishDisposableArr;
        PublishDisposable[] publishDisposableArr2;
        do {
            publishDisposableArr = (PublishDisposable[]) this.f62213c.get();
            if (publishDisposableArr != f62211a && publishDisposableArr != f62212b) {
                int length = publishDisposableArr.length;
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (publishDisposableArr[i2] == publishDisposable) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        publishDisposableArr2 = f62212b;
                    } else {
                        PublishDisposable[] publishDisposableArr3 = new PublishDisposable[(length - 1)];
                        System.arraycopy(publishDisposableArr, 0, publishDisposableArr3, 0, i);
                        System.arraycopy(publishDisposableArr, i + 1, publishDisposableArr3, i, (length - i) - 1);
                        publishDisposableArr2 = publishDisposableArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.f62213c.compareAndSet(publishDisposableArr, publishDisposableArr2));
    }

    public void onSubscribe(Disposable disposable) {
        if (this.f62213c.get() == f62211a) {
            disposable.dispose();
        }
    }

    public void onNext(T t) {
        ObjectHelper.requireNonNull(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        for (PublishDisposable onNext : (PublishDisposable[]) this.f62213c.get()) {
            onNext.onNext(t);
        }
    }

    public void onError(Throwable th) {
        ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        PublishDisposable<T>[] publishDisposableArr = this.f62213c.get();
        PublishDisposable<T>[] publishDisposableArr2 = f62211a;
        if (publishDisposableArr == publishDisposableArr2) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.f62214d = th;
        for (PublishDisposable onError : (PublishDisposable[]) this.f62213c.getAndSet(publishDisposableArr2)) {
            onError.onError(th);
        }
    }

    public void onComplete() {
        PublishDisposable<T>[] publishDisposableArr = this.f62213c.get();
        PublishDisposable<T>[] publishDisposableArr2 = f62211a;
        if (publishDisposableArr != publishDisposableArr2) {
            for (PublishDisposable onComplete : (PublishDisposable[]) this.f62213c.getAndSet(publishDisposableArr2)) {
                onComplete.onComplete();
            }
        }
    }

    public boolean hasObservers() {
        return ((PublishDisposable[]) this.f62213c.get()).length != 0;
    }

    public Throwable getThrowable() {
        if (this.f62213c.get() == f62211a) {
            return this.f62214d;
        }
        return null;
    }

    public boolean hasThrowable() {
        return this.f62213c.get() == f62211a && this.f62214d != null;
    }

    public boolean hasComplete() {
        return this.f62213c.get() == f62211a && this.f62214d == null;
    }

    /* renamed from: io.reactivex.subjects.PublishSubject$PublishDisposable */
    static final class PublishDisposable<T> extends AtomicBoolean implements Disposable {
        private static final long serialVersionUID = 3562861878281475070L;
        final Observer<? super T> downstream;
        final PublishSubject<T> parent;

        PublishDisposable(Observer<? super T> observer, PublishSubject<T> publishSubject) {
            this.downstream = observer;
            this.parent = publishSubject;
        }

        public void onNext(T t) {
            if (!get()) {
                this.downstream.onNext(t);
            }
        }

        public void onError(Throwable th) {
            if (get()) {
                RxJavaPlugins.onError(th);
            } else {
                this.downstream.onError(th);
            }
        }

        public void onComplete() {
            if (!get()) {
                this.downstream.onComplete();
            }
        }

        public void dispose() {
            if (compareAndSet(false, true)) {
                this.parent.mo185353b(this);
            }
        }

        public boolean isDisposed() {
            return get();
        }
    }
}
