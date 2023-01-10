package p218io.reactivex.internal.subscribers;

import p218io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.subscribers.BlockingFirstSubscriber */
public final class BlockingFirstSubscriber<T> extends BlockingBaseSubscriber<T> {
    public void onNext(T t) {
        if (this.f62025a == null) {
            this.f62025a = t;
            this.f62027c.cancel();
            countDown();
        }
    }

    public void onError(Throwable th) {
        if (this.f62025a == null) {
            this.f62026b = th;
        } else {
            RxJavaPlugins.onError(th);
        }
        countDown();
    }
}
