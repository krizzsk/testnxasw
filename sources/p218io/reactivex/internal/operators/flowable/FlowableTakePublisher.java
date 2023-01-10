package p218io.reactivex.internal.operators.flowable;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import p218io.reactivex.Flowable;
import p218io.reactivex.internal.operators.flowable.FlowableTake;

/* renamed from: io.reactivex.internal.operators.flowable.FlowableTakePublisher */
public final class FlowableTakePublisher<T> extends Flowable<T> {

    /* renamed from: a */
    final Publisher<T> f61246a;

    /* renamed from: b */
    final long f61247b;

    public FlowableTakePublisher(Publisher<T> publisher, long j) {
        this.f61246a = publisher;
        this.f61247b = j;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f61246a.subscribe(new FlowableTake.TakeSubscriber(subscriber, this.f61247b));
    }
}
