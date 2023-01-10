package p218io.reactivex.internal.subscribers;

import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;
import p218io.reactivex.FlowableSubscriber;
import p218io.reactivex.internal.subscriptions.SubscriptionHelper;
import p218io.reactivex.internal.util.BlockingHelper;
import p218io.reactivex.internal.util.ExceptionHelper;
import p218io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.subscribers.FutureSubscriber */
public final class FutureSubscriber<T> extends CountDownLatch implements FlowableSubscriber<T>, Future<T>, Subscription {

    /* renamed from: a */
    T f62029a;

    /* renamed from: b */
    Throwable f62030b;

    /* renamed from: c */
    final AtomicReference<Subscription> f62031c = new AtomicReference<>();

    public void cancel() {
    }

    public void request(long j) {
    }

    public FutureSubscriber() {
        super(1);
    }

    public boolean cancel(boolean z) {
        Subscription subscription;
        do {
            subscription = this.f62031c.get();
            if (subscription == this || subscription == SubscriptionHelper.CANCELLED) {
                return false;
            }
        } while (!this.f62031c.compareAndSet(subscription, SubscriptionHelper.CANCELLED));
        if (subscription != null) {
            subscription.cancel();
        }
        countDown();
        return true;
    }

    public boolean isCancelled() {
        return this.f62031c.get() == SubscriptionHelper.CANCELLED;
    }

    public boolean isDone() {
        return getCount() == 0;
    }

    public T get() throws InterruptedException, ExecutionException {
        if (getCount() != 0) {
            BlockingHelper.verifyNonBlocking();
            await();
        }
        if (!isCancelled()) {
            Throwable th = this.f62030b;
            if (th == null) {
                return this.f62029a;
            }
            throw new ExecutionException(th);
        }
        throw new CancellationException();
    }

    public T get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        if (getCount() != 0) {
            BlockingHelper.verifyNonBlocking();
            if (!await(j, timeUnit)) {
                throw new TimeoutException(ExceptionHelper.timeoutMessage(j, timeUnit));
            }
        }
        if (!isCancelled()) {
            Throwable th = this.f62030b;
            if (th == null) {
                return this.f62029a;
            }
            throw new ExecutionException(th);
        }
        throw new CancellationException();
    }

    public void onSubscribe(Subscription subscription) {
        SubscriptionHelper.setOnce(this.f62031c, subscription, Long.MAX_VALUE);
    }

    public void onNext(T t) {
        if (this.f62029a != null) {
            this.f62031c.get().cancel();
            onError(new IndexOutOfBoundsException("More than one element received"));
            return;
        }
        this.f62029a = t;
    }

    public void onError(Throwable th) {
        Subscription subscription;
        do {
            subscription = this.f62031c.get();
            if (subscription == this || subscription == SubscriptionHelper.CANCELLED) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.f62030b = th;
        } while (!this.f62031c.compareAndSet(subscription, this));
        countDown();
    }

    public void onComplete() {
        Subscription subscription;
        if (this.f62029a == null) {
            onError(new NoSuchElementException("The source is empty"));
            return;
        }
        do {
            subscription = this.f62031c.get();
            if (subscription == this || subscription == SubscriptionHelper.CANCELLED) {
                return;
            }
        } while (!this.f62031c.compareAndSet(subscription, this));
        countDown();
    }
}
