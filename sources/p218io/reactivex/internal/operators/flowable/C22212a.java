package p218io.reactivex.internal.operators.flowable;

import org.reactivestreams.Publisher;
import p218io.reactivex.Flowable;
import p218io.reactivex.internal.functions.ObjectHelper;
import p218io.reactivex.internal.fuseable.HasUpstreamPublisher;

/* renamed from: io.reactivex.internal.operators.flowable.a */
/* compiled from: AbstractFlowableWithUpstream */
abstract class C22212a<T, R> extends Flowable<R> implements HasUpstreamPublisher<T> {
    protected final Flowable<T> source;

    C22212a(Flowable<T> flowable) {
        this.source = (Flowable) ObjectHelper.requireNonNull(flowable, "source is null");
    }

    public final Publisher<T> source() {
        return this.source;
    }
}
