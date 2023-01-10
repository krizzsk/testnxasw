package p218io.reactivex.internal.operators.flowable;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import p218io.reactivex.Flowable;
import p218io.reactivex.functions.Function;

/* renamed from: io.reactivex.internal.operators.flowable.FlowableFlatMapPublisher */
public final class FlowableFlatMapPublisher<T, U> extends Flowable<U> {

    /* renamed from: a */
    final Publisher<T> f61075a;

    /* renamed from: b */
    final Function<? super T, ? extends Publisher<? extends U>> f61076b;

    /* renamed from: c */
    final boolean f61077c;

    /* renamed from: d */
    final int f61078d;

    /* renamed from: e */
    final int f61079e;

    public FlowableFlatMapPublisher(Publisher<T> publisher, Function<? super T, ? extends Publisher<? extends U>> function, boolean z, int i, int i2) {
        this.f61075a = publisher;
        this.f61076b = function;
        this.f61077c = z;
        this.f61078d = i;
        this.f61079e = i2;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super U> subscriber) {
        if (!FlowableScalarXMap.tryScalarXMapSubscribe(this.f61075a, subscriber, this.f61076b)) {
            this.f61075a.subscribe(FlowableFlatMap.subscribe(subscriber, this.f61076b, this.f61077c, this.f61078d, this.f61079e));
        }
    }
}
