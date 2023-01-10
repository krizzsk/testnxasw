package p218io.reactivex.internal.operators.parallel;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import p218io.reactivex.functions.Function;
import p218io.reactivex.internal.functions.ObjectHelper;
import p218io.reactivex.internal.operators.flowable.FlowableConcatMap;
import p218io.reactivex.internal.util.ErrorMode;
import p218io.reactivex.parallel.ParallelFlowable;

/* renamed from: io.reactivex.internal.operators.parallel.ParallelConcatMap */
public final class ParallelConcatMap<T, R> extends ParallelFlowable<R> {

    /* renamed from: a */
    final ParallelFlowable<T> f61799a;

    /* renamed from: b */
    final Function<? super T, ? extends Publisher<? extends R>> f61800b;

    /* renamed from: c */
    final int f61801c;

    /* renamed from: d */
    final ErrorMode f61802d;

    public ParallelConcatMap(ParallelFlowable<T> parallelFlowable, Function<? super T, ? extends Publisher<? extends R>> function, int i, ErrorMode errorMode) {
        this.f61799a = parallelFlowable;
        this.f61800b = (Function) ObjectHelper.requireNonNull(function, "mapper");
        this.f61801c = i;
        this.f61802d = (ErrorMode) ObjectHelper.requireNonNull(errorMode, "errorMode");
    }

    public int parallelism() {
        return this.f61799a.parallelism();
    }

    public void subscribe(Subscriber<? super R>[] subscriberArr) {
        if (validate(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber[] subscriberArr2 = new Subscriber[length];
            for (int i = 0; i < length; i++) {
                subscriberArr2[i] = FlowableConcatMap.subscribe(subscriberArr[i], this.f61800b, this.f61801c, this.f61802d);
            }
            this.f61799a.subscribe(subscriberArr2);
        }
    }
}
