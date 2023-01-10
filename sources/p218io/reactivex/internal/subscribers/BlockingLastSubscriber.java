package p218io.reactivex.internal.subscribers;

/* renamed from: io.reactivex.internal.subscribers.BlockingLastSubscriber */
public final class BlockingLastSubscriber<T> extends BlockingBaseSubscriber<T> {
    public void onNext(T t) {
        this.f62025a = t;
    }

    public void onError(Throwable th) {
        this.f62025a = null;
        this.f62026b = th;
        countDown();
    }
}
