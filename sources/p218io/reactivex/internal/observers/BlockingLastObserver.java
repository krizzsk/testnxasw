package p218io.reactivex.internal.observers;

/* renamed from: io.reactivex.internal.observers.BlockingLastObserver */
public final class BlockingLastObserver<T> extends BlockingBaseObserver<T> {
    public void onNext(T t) {
        this.f60821a = t;
    }

    public void onError(Throwable th) {
        this.f60821a = null;
        this.f60822b = th;
        countDown();
    }
}
