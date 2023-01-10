package p218io.reactivex;

import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.functions.Cancellable;

/* renamed from: io.reactivex.ObservableEmitter */
public interface ObservableEmitter<T> extends Emitter<T> {
    boolean isDisposed();

    ObservableEmitter<T> serialize();

    void setCancellable(Cancellable cancellable);

    void setDisposable(Disposable disposable);

    boolean tryOnError(Throwable th);
}
