package p218io.reactivex.internal.observers;

/* renamed from: io.reactivex.internal.observers.BlockingFirstObserver */
public final class BlockingFirstObserver<T> extends BlockingBaseObserver<T> {
    public void onNext(T t) {
        if (this.f60821a == null) {
            this.f60821a = t;
            this.f60823c.dispose();
            countDown();
        }
    }

    public void onError(Throwable th) {
        if (this.f60821a == null) {
            this.f60822b = th;
        }
        countDown();
    }
}
