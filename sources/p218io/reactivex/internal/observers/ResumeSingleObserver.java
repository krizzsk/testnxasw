package p218io.reactivex.internal.observers;

import java.util.concurrent.atomic.AtomicReference;
import p218io.reactivex.SingleObserver;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.internal.disposables.DisposableHelper;

/* renamed from: io.reactivex.internal.observers.ResumeSingleObserver */
public final class ResumeSingleObserver<T> implements SingleObserver<T> {

    /* renamed from: a */
    final AtomicReference<Disposable> f60839a;

    /* renamed from: b */
    final SingleObserver<? super T> f60840b;

    public ResumeSingleObserver(AtomicReference<Disposable> atomicReference, SingleObserver<? super T> singleObserver) {
        this.f60839a = atomicReference;
        this.f60840b = singleObserver;
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.replace(this.f60839a, disposable);
    }

    public void onSuccess(T t) {
        this.f60840b.onSuccess(t);
    }

    public void onError(Throwable th) {
        this.f60840b.onError(th);
    }
}
