package p218io.reactivex.internal.operators.parallel;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import p218io.reactivex.functions.Function;
import p218io.reactivex.internal.operators.flowable.FlowableFlatMap;
import p218io.reactivex.parallel.ParallelFlowable;

/* renamed from: io.reactivex.internal.operators.parallel.ParallelFlatMap */
public final class ParallelFlatMap<T, R> extends ParallelFlowable<R> {

    /* renamed from: a */
    final ParallelFlowable<T> f61811a;

    /* renamed from: b */
    final Function<? super T, ? extends Publisher<? extends R>> f61812b;

    /* renamed from: c */
    final boolean f61813c;

    /* renamed from: d */
    final int f61814d;

    /* renamed from: e */
    final int f61815e;

    public ParallelFlatMap(ParallelFlowable<T> parallelFlowable, Function<? super T, ? extends Publisher<? extends R>> function, boolean z, int i, int i2) {
        this.f61811a = parallelFlowable;
        this.f61812b = function;
        this.f61813c = z;
        this.f61814d = i;
        this.f61815e = i2;
    }

    public int parallelism() {
        return this.f61811a.parallelism();
    }

    public void subscribe(Subscriber<? super R>[] subscriberArr) {
        if (validate(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber[] subscriberArr2 = new Subscriber[length];
            for (int i = 0; i < length; i++) {
                subscriberArr2[i] = FlowableFlatMap.subscribe(subscriberArr[i], this.f61812b, this.f61813c, this.f61814d, this.f61815e);
            }
            this.f61811a.subscribe(subscriberArr2);
        }
    }
}
