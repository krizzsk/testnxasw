package p218io.reactivex.internal.operators.flowable;

import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import p218io.reactivex.Flowable;
import p218io.reactivex.exceptions.Exceptions;
import p218io.reactivex.internal.functions.ObjectHelper;
import p218io.reactivex.internal.subscriptions.EmptySubscription;

/* renamed from: io.reactivex.internal.operators.flowable.FlowableDefer */
public final class FlowableDefer<T> extends Flowable<T> {

    /* renamed from: a */
    final Callable<? extends Publisher<? extends T>> f61024a;

    public FlowableDefer(Callable<? extends Publisher<? extends T>> callable) {
        this.f61024a = callable;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        try {
            ((Publisher) ObjectHelper.requireNonNull(this.f61024a.call(), "The publisher supplied is null")).subscribe(subscriber);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }
}
