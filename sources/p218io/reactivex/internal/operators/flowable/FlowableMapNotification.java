package p218io.reactivex.internal.operators.flowable;

import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;
import p218io.reactivex.Flowable;
import p218io.reactivex.exceptions.CompositeException;
import p218io.reactivex.exceptions.Exceptions;
import p218io.reactivex.functions.Function;
import p218io.reactivex.internal.functions.ObjectHelper;
import p218io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;

/* renamed from: io.reactivex.internal.operators.flowable.FlowableMapNotification */
public final class FlowableMapNotification<T, R> extends C22212a<T, R> {

    /* renamed from: a */
    final Function<? super T, ? extends R> f61129a;

    /* renamed from: b */
    final Function<? super Throwable, ? extends R> f61130b;

    /* renamed from: c */
    final Callable<? extends R> f61131c;

    public FlowableMapNotification(Flowable<T> flowable, Function<? super T, ? extends R> function, Function<? super Throwable, ? extends R> function2, Callable<? extends R> callable) {
        super(flowable);
        this.f61129a = function;
        this.f61130b = function2;
        this.f61131c = callable;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.source.subscribe(new MapNotificationSubscriber(subscriber, this.f61129a, this.f61130b, this.f61131c));
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableMapNotification$MapNotificationSubscriber */
    static final class MapNotificationSubscriber<T, R> extends SinglePostCompleteSubscriber<T, R> {
        private static final long serialVersionUID = 2757120512858778108L;
        final Callable<? extends R> onCompleteSupplier;
        final Function<? super Throwable, ? extends R> onErrorMapper;
        final Function<? super T, ? extends R> onNextMapper;

        MapNotificationSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends R> function, Function<? super Throwable, ? extends R> function2, Callable<? extends R> callable) {
            super(subscriber);
            this.onNextMapper = function;
            this.onErrorMapper = function2;
            this.onCompleteSupplier = callable;
        }

        public void onNext(T t) {
            try {
                Object requireNonNull = ObjectHelper.requireNonNull(this.onNextMapper.apply(t), "The onNext publisher returned is null");
                this.produced++;
                this.downstream.onNext(requireNonNull);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.downstream.onError(th);
            }
        }

        public void onError(Throwable th) {
            try {
                complete(ObjectHelper.requireNonNull(this.onErrorMapper.apply(th), "The onError publisher returned is null"));
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.downstream.onError(new CompositeException(th, th2));
            }
        }

        public void onComplete() {
            try {
                complete(ObjectHelper.requireNonNull(this.onCompleteSupplier.call(), "The onComplete publisher returned is null"));
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.downstream.onError(th);
            }
        }
    }
}
