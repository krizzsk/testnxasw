package p218io.reactivex.internal.disposables;

import java.util.concurrent.atomic.AtomicReference;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.exceptions.Exceptions;
import p218io.reactivex.functions.Cancellable;
import p218io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.disposables.CancellableDisposable */
public final class CancellableDisposable extends AtomicReference<Cancellable> implements Disposable {
    private static final long serialVersionUID = 5718521705281392066L;

    public CancellableDisposable(Cancellable cancellable) {
        super(cancellable);
    }

    public boolean isDisposed() {
        return get() == null;
    }

    public void dispose() {
        Cancellable cancellable;
        if (get() != null && (cancellable = (Cancellable) getAndSet((Object) null)) != null) {
            try {
                cancellable.cancel();
            } catch (Exception e) {
                Exceptions.throwIfFatal(e);
                RxJavaPlugins.onError(e);
            }
        }
    }
}
