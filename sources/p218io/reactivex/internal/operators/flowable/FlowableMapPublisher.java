package p218io.reactivex.internal.operators.flowable;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import p218io.reactivex.Flowable;
import p218io.reactivex.functions.Function;
import p218io.reactivex.internal.operators.flowable.FlowableMap;

/* renamed from: io.reactivex.internal.operators.flowable.FlowableMapPublisher */
public final class FlowableMapPublisher<T, U> extends Flowable<U> {

    /* renamed from: a */
    final Publisher<T> f61132a;

    /* renamed from: b */
    final Function<? super T, ? extends U> f61133b;

    public FlowableMapPublisher(Publisher<T> publisher, Function<? super T, ? extends U> function) {
        this.f61132a = publisher;
        this.f61133b = function;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super U> subscriber) {
        this.f61132a.subscribe(new FlowableMap.MapSubscriber(subscriber, this.f61133b));
    }
}
