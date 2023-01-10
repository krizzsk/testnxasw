package p218io.reactivex.internal.operators.parallel;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import p218io.reactivex.parallel.ParallelFlowable;

/* renamed from: io.reactivex.internal.operators.parallel.ParallelFromArray */
public final class ParallelFromArray<T> extends ParallelFlowable<T> {

    /* renamed from: a */
    final Publisher<T>[] f61816a;

    public ParallelFromArray(Publisher<T>[] publisherArr) {
        this.f61816a = publisherArr;
    }

    public int parallelism() {
        return this.f61816a.length;
    }

    public void subscribe(Subscriber<? super T>[] subscriberArr) {
        if (validate(subscriberArr)) {
            int length = subscriberArr.length;
            for (int i = 0; i < length; i++) {
                this.f61816a[i].subscribe(subscriberArr[i]);
            }
        }
    }
}
