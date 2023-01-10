package p218io.reactivex.internal.operators.mixed;

import p218io.reactivex.CompletableObserver;
import p218io.reactivex.MaybeObserver;
import p218io.reactivex.Notification;
import p218io.reactivex.SingleObserver;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.internal.disposables.DisposableHelper;

/* renamed from: io.reactivex.internal.operators.mixed.MaterializeSingleObserver */
public final class MaterializeSingleObserver<T> implements CompletableObserver, MaybeObserver<T>, SingleObserver<T>, Disposable {

    /* renamed from: a */
    final SingleObserver<? super Notification<T>> f61441a;

    /* renamed from: b */
    Disposable f61442b;

    public MaterializeSingleObserver(SingleObserver<? super Notification<T>> singleObserver) {
        this.f61441a = singleObserver;
    }

    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f61442b, disposable)) {
            this.f61442b = disposable;
            this.f61441a.onSubscribe(this);
        }
    }

    public void onComplete() {
        this.f61441a.onSuccess(Notification.createOnComplete());
    }

    public void onSuccess(T t) {
        this.f61441a.onSuccess(Notification.createOnNext(t));
    }

    public void onError(Throwable th) {
        this.f61441a.onSuccess(Notification.createOnError(th));
    }

    public boolean isDisposed() {
        return this.f61442b.isDisposed();
    }

    public void dispose() {
        this.f61442b.dispose();
    }
}
