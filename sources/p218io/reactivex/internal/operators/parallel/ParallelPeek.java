package p218io.reactivex.internal.operators.parallel;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p218io.reactivex.FlowableSubscriber;
import p218io.reactivex.exceptions.CompositeException;
import p218io.reactivex.exceptions.Exceptions;
import p218io.reactivex.functions.Action;
import p218io.reactivex.functions.Consumer;
import p218io.reactivex.functions.LongConsumer;
import p218io.reactivex.internal.functions.ObjectHelper;
import p218io.reactivex.internal.subscriptions.EmptySubscription;
import p218io.reactivex.internal.subscriptions.SubscriptionHelper;
import p218io.reactivex.parallel.ParallelFlowable;
import p218io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.parallel.ParallelPeek */
public final class ParallelPeek<T> extends ParallelFlowable<T> {

    /* renamed from: a */
    final ParallelFlowable<T> f61830a;

    /* renamed from: b */
    final Consumer<? super T> f61831b;

    /* renamed from: c */
    final Consumer<? super T> f61832c;

    /* renamed from: d */
    final Consumer<? super Throwable> f61833d;

    /* renamed from: e */
    final Action f61834e;

    /* renamed from: f */
    final Action f61835f;

    /* renamed from: g */
    final Consumer<? super Subscription> f61836g;

    /* renamed from: h */
    final LongConsumer f61837h;

    /* renamed from: i */
    final Action f61838i;

    public ParallelPeek(ParallelFlowable<T> parallelFlowable, Consumer<? super T> consumer, Consumer<? super T> consumer2, Consumer<? super Throwable> consumer3, Action action, Action action2, Consumer<? super Subscription> consumer4, LongConsumer longConsumer, Action action3) {
        this.f61830a = parallelFlowable;
        this.f61831b = (Consumer) ObjectHelper.requireNonNull(consumer, "onNext is null");
        this.f61832c = (Consumer) ObjectHelper.requireNonNull(consumer2, "onAfterNext is null");
        this.f61833d = (Consumer) ObjectHelper.requireNonNull(consumer3, "onError is null");
        this.f61834e = (Action) ObjectHelper.requireNonNull(action, "onComplete is null");
        this.f61835f = (Action) ObjectHelper.requireNonNull(action2, "onAfterTerminated is null");
        this.f61836g = (Consumer) ObjectHelper.requireNonNull(consumer4, "onSubscribe is null");
        this.f61837h = (LongConsumer) ObjectHelper.requireNonNull(longConsumer, "onRequest is null");
        this.f61838i = (Action) ObjectHelper.requireNonNull(action3, "onCancel is null");
    }

    public void subscribe(Subscriber<? super T>[] subscriberArr) {
        if (validate(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber[] subscriberArr2 = new Subscriber[length];
            for (int i = 0; i < length; i++) {
                subscriberArr2[i] = new ParallelPeekSubscriber(subscriberArr[i], this);
            }
            this.f61830a.subscribe(subscriberArr2);
        }
    }

    public int parallelism() {
        return this.f61830a.parallelism();
    }

    /* renamed from: io.reactivex.internal.operators.parallel.ParallelPeek$ParallelPeekSubscriber */
    static final class ParallelPeekSubscriber<T> implements FlowableSubscriber<T>, Subscription {
        boolean done;
        final Subscriber<? super T> downstream;
        final ParallelPeek<T> parent;
        Subscription upstream;

        ParallelPeekSubscriber(Subscriber<? super T> subscriber, ParallelPeek<T> parallelPeek) {
            this.downstream = subscriber;
            this.parent = parallelPeek;
        }

        public void request(long j) {
            try {
                this.parent.f61837h.accept(j);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
            this.upstream.request(j);
        }

        public void cancel() {
            try {
                this.parent.f61838i.run();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
            this.upstream.cancel();
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                try {
                    this.parent.f61836g.accept(subscription);
                    this.downstream.onSubscribe(this);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    subscription.cancel();
                    this.downstream.onSubscribe(EmptySubscription.INSTANCE);
                    onError(th);
                }
            }
        }

        public void onNext(T t) {
            if (!this.done) {
                try {
                    this.parent.f61831b.accept(t);
                    this.downstream.onNext(t);
                    try {
                        this.parent.f61832c.accept(t);
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        onError(th);
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    onError(th2);
                }
            }
        }

        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            try {
                this.parent.f61833d.accept(th);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                th = new CompositeException(th, th2);
            }
            this.downstream.onError(th);
            try {
                this.parent.f61835f.run();
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                RxJavaPlugins.onError(th3);
            }
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                try {
                    this.parent.f61834e.run();
                    this.downstream.onComplete();
                    try {
                        this.parent.f61835f.run();
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        RxJavaPlugins.onError(th);
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.downstream.onError(th2);
                }
            }
        }
    }
}
