package p218io.reactivex.observers;

import java.util.concurrent.atomic.AtomicReference;
import p218io.reactivex.SingleObserver;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.internal.disposables.DisposableHelper;
import p218io.reactivex.internal.util.EndConsumerHelper;

/* renamed from: io.reactivex.observers.DisposableSingleObserver */
public abstract class DisposableSingleObserver<T> implements SingleObserver<T>, Disposable {

    /* renamed from: a */
    final AtomicReference<Disposable> f62072a = new AtomicReference<>();

    /* access modifiers changed from: protected */
    public void onStart() {
    }

    public final void onSubscribe(Disposable disposable) {
        if (EndConsumerHelper.setOnce(this.f62072a, disposable, getClass())) {
            onStart();
        }
    }

    public final boolean isDisposed() {
        return this.f62072a.get() == DisposableHelper.DISPOSED;
    }

    public final void dispose() {
        DisposableHelper.dispose(this.f62072a);
    }
}
