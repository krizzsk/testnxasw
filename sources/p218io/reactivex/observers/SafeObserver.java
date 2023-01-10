package p218io.reactivex.observers;

import p218io.reactivex.Observer;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.exceptions.CompositeException;
import p218io.reactivex.exceptions.Exceptions;
import p218io.reactivex.internal.disposables.DisposableHelper;
import p218io.reactivex.internal.disposables.EmptyDisposable;
import p218io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.observers.SafeObserver */
public final class SafeObserver<T> implements Observer<T>, Disposable {

    /* renamed from: a */
    final Observer<? super T> f62081a;

    /* renamed from: b */
    Disposable f62082b;

    /* renamed from: c */
    boolean f62083c;

    public SafeObserver(Observer<? super T> observer) {
        this.f62081a = observer;
    }

    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f62082b, disposable)) {
            this.f62082b = disposable;
            try {
                this.f62081a.onSubscribe(this);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(new CompositeException(th, th));
            }
        }
    }

    public void dispose() {
        this.f62082b.dispose();
    }

    public boolean isDisposed() {
        return this.f62082b.isDisposed();
    }

    public void onNext(T t) {
        if (!this.f62083c) {
            if (this.f62082b == null) {
                mo185165a();
            } else if (t == null) {
                NullPointerException nullPointerException = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
                try {
                    this.f62082b.dispose();
                    onError(nullPointerException);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    onError(new CompositeException(nullPointerException, th));
                }
            } else {
                try {
                    this.f62081a.onNext(t);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    onError(new CompositeException(th, th2));
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo185165a() {
        this.f62083c = true;
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.f62081a.onSubscribe(EmptyDisposable.INSTANCE);
            try {
                this.f62081a.onError(nullPointerException);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(new CompositeException(nullPointerException, th));
            }
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            RxJavaPlugins.onError(new CompositeException(nullPointerException, th2));
        }
    }

    public void onError(Throwable th) {
        if (this.f62083c) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.f62083c = true;
        if (this.f62082b == null) {
            NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
            try {
                this.f62081a.onSubscribe(EmptyDisposable.INSTANCE);
                try {
                    this.f62081a.onError(new CompositeException(th, nullPointerException));
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    RxJavaPlugins.onError(new CompositeException(th, nullPointerException, th2));
                }
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                RxJavaPlugins.onError(new CompositeException(th, nullPointerException, th3));
            }
        } else {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            try {
                this.f62081a.onError(th);
            } catch (Throwable th4) {
                Exceptions.throwIfFatal(th4);
                RxJavaPlugins.onError(new CompositeException(th, th4));
            }
        }
    }

    public void onComplete() {
        if (!this.f62083c) {
            this.f62083c = true;
            if (this.f62082b == null) {
                mo185166b();
                return;
            }
            try {
                this.f62081a.onComplete();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo185166b() {
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.f62081a.onSubscribe(EmptyDisposable.INSTANCE);
            try {
                this.f62081a.onError(nullPointerException);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(new CompositeException(nullPointerException, th));
            }
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            RxJavaPlugins.onError(new CompositeException(nullPointerException, th2));
        }
    }
}
