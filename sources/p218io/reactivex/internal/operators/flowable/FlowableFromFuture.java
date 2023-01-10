package p218io.reactivex.internal.operators.flowable;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import p218io.reactivex.Flowable;
import p218io.reactivex.exceptions.Exceptions;
import p218io.reactivex.internal.subscriptions.DeferredScalarSubscription;

/* renamed from: io.reactivex.internal.operators.flowable.FlowableFromFuture */
public final class FlowableFromFuture<T> extends Flowable<T> {

    /* renamed from: a */
    final Future<? extends T> f61087a;

    /* renamed from: b */
    final long f61088b;

    /* renamed from: c */
    final TimeUnit f61089c;

    public FlowableFromFuture(Future<? extends T> future, long j, TimeUnit timeUnit) {
        this.f61087a = future;
        this.f61088b = j;
        this.f61089c = timeUnit;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        DeferredScalarSubscription deferredScalarSubscription = new DeferredScalarSubscription(subscriber);
        subscriber.onSubscribe(deferredScalarSubscription);
        try {
            Object obj = this.f61089c != null ? this.f61087a.get(this.f61088b, this.f61089c) : this.f61087a.get();
            if (obj == null) {
                subscriber.onError(new NullPointerException("The future returned null"));
            } else {
                deferredScalarSubscription.complete(obj);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            if (!deferredScalarSubscription.isCancelled()) {
                subscriber.onError(th);
            }
        }
    }
}
