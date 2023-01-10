package p218io.reactivex.disposables;

import java.util.concurrent.atomic.AtomicReference;
import p218io.reactivex.internal.disposables.DisposableHelper;

/* renamed from: io.reactivex.disposables.SerialDisposable */
public final class SerialDisposable implements Disposable {

    /* renamed from: a */
    final AtomicReference<Disposable> f60802a;

    public SerialDisposable() {
        this.f60802a = new AtomicReference<>();
    }

    public SerialDisposable(Disposable disposable) {
        this.f60802a = new AtomicReference<>(disposable);
    }

    public boolean set(Disposable disposable) {
        return DisposableHelper.set(this.f60802a, disposable);
    }

    public boolean replace(Disposable disposable) {
        return DisposableHelper.replace(this.f60802a, disposable);
    }

    public Disposable get() {
        Disposable disposable = this.f60802a.get();
        return disposable == DisposableHelper.DISPOSED ? Disposables.disposed() : disposable;
    }

    public void dispose() {
        DisposableHelper.dispose(this.f60802a);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed(this.f60802a.get());
    }
}
