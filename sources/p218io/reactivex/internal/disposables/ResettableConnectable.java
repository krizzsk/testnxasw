package p218io.reactivex.internal.disposables;

import p218io.reactivex.disposables.Disposable;

/* renamed from: io.reactivex.internal.disposables.ResettableConnectable */
public interface ResettableConnectable {
    void resetIf(Disposable disposable);
}
