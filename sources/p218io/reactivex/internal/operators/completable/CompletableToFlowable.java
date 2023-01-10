package p218io.reactivex.internal.operators.completable;

import org.reactivestreams.Subscriber;
import p218io.reactivex.CompletableSource;
import p218io.reactivex.Flowable;
import p218io.reactivex.internal.observers.SubscriberCompletableObserver;

/* renamed from: io.reactivex.internal.operators.completable.CompletableToFlowable */
public final class CompletableToFlowable<T> extends Flowable<T> {

    /* renamed from: a */
    final CompletableSource f60927a;

    public CompletableToFlowable(CompletableSource completableSource) {
        this.f60927a = completableSource;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f60927a.subscribe(new SubscriberCompletableObserver(subscriber));
    }
}
