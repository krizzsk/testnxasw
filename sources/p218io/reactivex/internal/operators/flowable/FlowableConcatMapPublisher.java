package p218io.reactivex.internal.operators.flowable;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import p218io.reactivex.Flowable;
import p218io.reactivex.functions.Function;
import p218io.reactivex.internal.util.ErrorMode;

/* renamed from: io.reactivex.internal.operators.flowable.FlowableConcatMapPublisher */
public final class FlowableConcatMapPublisher<T, R> extends Flowable<R> {

    /* renamed from: a */
    final Publisher<T> f61010a;

    /* renamed from: b */
    final Function<? super T, ? extends Publisher<? extends R>> f61011b;

    /* renamed from: c */
    final int f61012c;

    /* renamed from: d */
    final ErrorMode f61013d;

    public FlowableConcatMapPublisher(Publisher<T> publisher, Function<? super T, ? extends Publisher<? extends R>> function, int i, ErrorMode errorMode) {
        this.f61010a = publisher;
        this.f61011b = function;
        this.f61012c = i;
        this.f61013d = errorMode;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super R> subscriber) {
        if (!FlowableScalarXMap.tryScalarXMapSubscribe(this.f61010a, subscriber, this.f61011b)) {
            this.f61010a.subscribe(FlowableConcatMap.subscribe(subscriber, this.f61011b, this.f61012c, this.f61013d));
        }
    }
}
