package p218io.reactivex.internal.observers;

import p218io.reactivex.Observer;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.exceptions.Exceptions;
import p218io.reactivex.functions.Action;
import p218io.reactivex.functions.Consumer;
import p218io.reactivex.internal.disposables.DisposableHelper;
import p218io.reactivex.internal.disposables.EmptyDisposable;
import p218io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.observers.DisposableLambdaObserver */
public final class DisposableLambdaObserver<T> implements Observer<T>, Disposable {

    /* renamed from: a */
    final Observer<? super T> f60829a;

    /* renamed from: b */
    final Consumer<? super Disposable> f60830b;

    /* renamed from: c */
    final Action f60831c;

    /* renamed from: d */
    Disposable f60832d;

    public DisposableLambdaObserver(Observer<? super T> observer, Consumer<? super Disposable> consumer, Action action) {
        this.f60829a = observer;
        this.f60830b = consumer;
        this.f60831c = action;
    }

    public void onSubscribe(Disposable disposable) {
        try {
            this.f60830b.accept(disposable);
            if (DisposableHelper.validate(this.f60832d, disposable)) {
                this.f60832d = disposable;
                this.f60829a.onSubscribe(this);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            disposable.dispose();
            this.f60832d = DisposableHelper.DISPOSED;
            EmptyDisposable.error(th, (Observer<?>) this.f60829a);
        }
    }

    public void onNext(T t) {
        this.f60829a.onNext(t);
    }

    public void onError(Throwable th) {
        if (this.f60832d != DisposableHelper.DISPOSED) {
            this.f60832d = DisposableHelper.DISPOSED;
            this.f60829a.onError(th);
            return;
        }
        RxJavaPlugins.onError(th);
    }

    public void onComplete() {
        if (this.f60832d != DisposableHelper.DISPOSED) {
            this.f60832d = DisposableHelper.DISPOSED;
            this.f60829a.onComplete();
        }
    }

    public void dispose() {
        Disposable disposable = this.f60832d;
        if (disposable != DisposableHelper.DISPOSED) {
            this.f60832d = DisposableHelper.DISPOSED;
            try {
                this.f60831c.run();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
            disposable.dispose();
        }
    }

    public boolean isDisposed() {
        return this.f60832d.isDisposed();
    }
}
