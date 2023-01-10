package p218io.reactivex.internal.operators.flowable;

import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscriber;
import p218io.reactivex.Flowable;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.flowables.ConnectableFlowable;
import p218io.reactivex.functions.Consumer;

/* renamed from: io.reactivex.internal.operators.flowable.FlowableAutoConnect */
public final class FlowableAutoConnect<T> extends Flowable<T> {

    /* renamed from: a */
    final ConnectableFlowable<? extends T> f60950a;

    /* renamed from: b */
    final int f60951b;

    /* renamed from: c */
    final Consumer<? super Disposable> f60952c;

    /* renamed from: d */
    final AtomicInteger f60953d = new AtomicInteger();

    public FlowableAutoConnect(ConnectableFlowable<? extends T> connectableFlowable, int i, Consumer<? super Disposable> consumer) {
        this.f60950a = connectableFlowable;
        this.f60951b = i;
        this.f60952c = consumer;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f60950a.subscribe(subscriber);
        if (this.f60953d.incrementAndGet() == this.f60951b) {
            this.f60950a.connect(this.f60952c);
        }
    }
}
