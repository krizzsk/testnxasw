package p218io.reactivex.internal.operators.flowable;

import org.reactivestreams.Subscriber;
import p218io.reactivex.Flowable;
import p218io.reactivex.internal.fuseable.ScalarCallable;
import p218io.reactivex.internal.subscriptions.ScalarSubscription;

/* renamed from: io.reactivex.internal.operators.flowable.FlowableJust */
public final class FlowableJust<T> extends Flowable<T> implements ScalarCallable<T> {

    /* renamed from: a */
    private final T f61122a;

    public FlowableJust(T t) {
        this.f61122a = t;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super T> subscriber) {
        subscriber.onSubscribe(new ScalarSubscription(subscriber, this.f61122a));
    }

    public T call() {
        return this.f61122a;
    }
}
