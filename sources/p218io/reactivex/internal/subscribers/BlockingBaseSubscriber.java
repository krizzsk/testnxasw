package p218io.reactivex.internal.subscribers;

import java.util.concurrent.CountDownLatch;
import org.reactivestreams.Subscription;
import p218io.reactivex.FlowableSubscriber;
import p218io.reactivex.internal.subscriptions.SubscriptionHelper;
import p218io.reactivex.internal.util.BlockingHelper;
import p218io.reactivex.internal.util.ExceptionHelper;

/* renamed from: io.reactivex.internal.subscribers.BlockingBaseSubscriber */
public abstract class BlockingBaseSubscriber<T> extends CountDownLatch implements FlowableSubscriber<T> {

    /* renamed from: a */
    T f62025a;

    /* renamed from: b */
    Throwable f62026b;

    /* renamed from: c */
    Subscription f62027c;

    /* renamed from: d */
    volatile boolean f62028d;

    public BlockingBaseSubscriber() {
        super(1);
    }

    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f62027c, subscription)) {
            this.f62027c = subscription;
            if (!this.f62028d) {
                subscription.request(Long.MAX_VALUE);
                if (this.f62028d) {
                    this.f62027c = SubscriptionHelper.CANCELLED;
                    subscription.cancel();
                }
            }
        }
    }

    public final void onComplete() {
        countDown();
    }

    public final T blockingGet() {
        if (getCount() != 0) {
            try {
                BlockingHelper.verifyNonBlocking();
                await();
            } catch (InterruptedException e) {
                Subscription subscription = this.f62027c;
                this.f62027c = SubscriptionHelper.CANCELLED;
                if (subscription != null) {
                    subscription.cancel();
                }
                throw ExceptionHelper.wrapOrThrow(e);
            }
        }
        Throwable th = this.f62026b;
        if (th == null) {
            return this.f62025a;
        }
        throw ExceptionHelper.wrapOrThrow(th);
    }
}
