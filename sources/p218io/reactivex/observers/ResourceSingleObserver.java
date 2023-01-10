package p218io.reactivex.observers;

import java.util.concurrent.atomic.AtomicReference;
import p218io.reactivex.SingleObserver;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.internal.disposables.DisposableHelper;
import p218io.reactivex.internal.disposables.ListCompositeDisposable;
import p218io.reactivex.internal.functions.ObjectHelper;
import p218io.reactivex.internal.util.EndConsumerHelper;

/* renamed from: io.reactivex.observers.ResourceSingleObserver */
public abstract class ResourceSingleObserver<T> implements SingleObserver<T>, Disposable {

    /* renamed from: a */
    private final AtomicReference<Disposable> f62079a = new AtomicReference<>();

    /* renamed from: b */
    private final ListCompositeDisposable f62080b = new ListCompositeDisposable();

    /* access modifiers changed from: protected */
    public void onStart() {
    }

    public final void add(Disposable disposable) {
        ObjectHelper.requireNonNull(disposable, "resource is null");
        this.f62080b.add(disposable);
    }

    public final void onSubscribe(Disposable disposable) {
        if (EndConsumerHelper.setOnce(this.f62079a, disposable, getClass())) {
            onStart();
        }
    }

    public final void dispose() {
        if (DisposableHelper.dispose(this.f62079a)) {
            this.f62080b.dispose();
        }
    }

    public final boolean isDisposed() {
        return DisposableHelper.isDisposed(this.f62079a.get());
    }
}
