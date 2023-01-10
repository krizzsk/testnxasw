package p218io.reactivex.internal.operators.flowable;

import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;
import p218io.reactivex.Single;
import p218io.reactivex.SingleObserver;
import p218io.reactivex.exceptions.Exceptions;
import p218io.reactivex.functions.BiFunction;
import p218io.reactivex.internal.disposables.EmptyDisposable;
import p218io.reactivex.internal.functions.ObjectHelper;
import p218io.reactivex.internal.operators.flowable.FlowableReduceSeedSingle;

/* renamed from: io.reactivex.internal.operators.flowable.FlowableReduceWithSingle */
public final class FlowableReduceWithSingle<T, R> extends Single<R> {

    /* renamed from: a */
    final Publisher<T> f61169a;

    /* renamed from: b */
    final Callable<R> f61170b;

    /* renamed from: c */
    final BiFunction<R, ? super T, R> f61171c;

    public FlowableReduceWithSingle(Publisher<T> publisher, Callable<R> callable, BiFunction<R, ? super T, R> biFunction) {
        this.f61169a = publisher;
        this.f61170b = callable;
        this.f61171c = biFunction;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super R> singleObserver) {
        try {
            this.f61169a.subscribe(new FlowableReduceSeedSingle.ReduceSeedObserver(singleObserver, this.f61171c, ObjectHelper.requireNonNull(this.f61170b.call(), "The seedSupplier returned a null value")));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, (SingleObserver<?>) singleObserver);
        }
    }
}
