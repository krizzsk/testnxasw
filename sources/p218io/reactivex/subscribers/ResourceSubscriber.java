package p218io.reactivex.subscribers;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;
import p218io.reactivex.FlowableSubscriber;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.internal.disposables.ListCompositeDisposable;
import p218io.reactivex.internal.functions.ObjectHelper;
import p218io.reactivex.internal.subscriptions.SubscriptionHelper;
import p218io.reactivex.internal.util.EndConsumerHelper;

/* renamed from: io.reactivex.subscribers.ResourceSubscriber */
public abstract class ResourceSubscriber<T> implements FlowableSubscriber<T>, Disposable {

    /* renamed from: a */
    private final AtomicReference<Subscription> f62241a = new AtomicReference<>();

    /* renamed from: b */
    private final ListCompositeDisposable f62242b = new ListCompositeDisposable();

    /* renamed from: c */
    private final AtomicLong f62243c = new AtomicLong();

    public final void add(Disposable disposable) {
        ObjectHelper.requireNonNull(disposable, "resource is null");
        this.f62242b.add(disposable);
    }

    public final void onSubscribe(Subscription subscription) {
        if (EndConsumerHelper.setOnce(this.f62241a, subscription, getClass())) {
            long andSet = this.f62243c.getAndSet(0);
            if (andSet != 0) {
                subscription.request(andSet);
            }
            onStart();
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        request(Long.MAX_VALUE);
    }

    /* access modifiers changed from: protected */
    public final void request(long j) {
        SubscriptionHelper.deferredRequest(this.f62241a, this.f62243c, j);
    }

    public final void dispose() {
        if (SubscriptionHelper.cancel(this.f62241a)) {
            this.f62242b.dispose();
        }
    }

    public final boolean isDisposed() {
        return this.f62241a.get() == SubscriptionHelper.CANCELLED;
    }
}
