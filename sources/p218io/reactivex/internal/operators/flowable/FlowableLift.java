package p218io.reactivex.internal.operators.flowable;

import org.reactivestreams.Subscriber;
import p218io.reactivex.Flowable;
import p218io.reactivex.FlowableOperator;
import p218io.reactivex.exceptions.Exceptions;
import p218io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.flowable.FlowableLift */
public final class FlowableLift<R, T> extends C22212a<T, R> {

    /* renamed from: a */
    final FlowableOperator<? extends R, ? super T> f61126a;

    public FlowableLift(Flowable<T> flowable, FlowableOperator<? extends R, ? super T> flowableOperator) {
        super(flowable);
        this.f61126a = flowableOperator;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        try {
            Subscriber<? super Object> apply = this.f61126a.apply(subscriber);
            if (apply != null) {
                this.source.subscribe(apply);
                return;
            }
            throw new NullPointerException("Operator " + this.f61126a + " returned a null Subscriber");
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }
}
