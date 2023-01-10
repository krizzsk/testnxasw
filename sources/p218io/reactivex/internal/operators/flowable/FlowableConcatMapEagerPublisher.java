package p218io.reactivex.internal.operators.flowable;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import p218io.reactivex.Flowable;
import p218io.reactivex.functions.Function;
import p218io.reactivex.internal.operators.flowable.FlowableConcatMapEager;
import p218io.reactivex.internal.util.ErrorMode;

/* renamed from: io.reactivex.internal.operators.flowable.FlowableConcatMapEagerPublisher */
public final class FlowableConcatMapEagerPublisher<T, R> extends Flowable<R> {

    /* renamed from: a */
    final Publisher<T> f61005a;

    /* renamed from: b */
    final Function<? super T, ? extends Publisher<? extends R>> f61006b;

    /* renamed from: c */
    final int f61007c;

    /* renamed from: d */
    final int f61008d;

    /* renamed from: e */
    final ErrorMode f61009e;

    public FlowableConcatMapEagerPublisher(Publisher<T> publisher, Function<? super T, ? extends Publisher<? extends R>> function, int i, int i2, ErrorMode errorMode) {
        this.f61005a = publisher;
        this.f61006b = function;
        this.f61007c = i;
        this.f61008d = i2;
        this.f61009e = errorMode;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.f61005a.subscribe(new FlowableConcatMapEager.ConcatMapEagerDelayErrorSubscriber(subscriber, this.f61006b, this.f61007c, this.f61008d, this.f61009e));
    }
}
