package p218io.reactivex.internal.operators.mixed;

import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;
import p218io.reactivex.Completable;
import p218io.reactivex.CompletableObserver;
import p218io.reactivex.CompletableSource;
import p218io.reactivex.Flowable;
import p218io.reactivex.FlowableSubscriber;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.exceptions.Exceptions;
import p218io.reactivex.functions.Function;
import p218io.reactivex.internal.disposables.DisposableHelper;
import p218io.reactivex.internal.functions.ObjectHelper;
import p218io.reactivex.internal.subscriptions.SubscriptionHelper;
import p218io.reactivex.internal.util.AtomicThrowable;
import p218io.reactivex.internal.util.ExceptionHelper;
import p218io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.mixed.FlowableSwitchMapCompletable */
public final class FlowableSwitchMapCompletable<T> extends Completable {

    /* renamed from: a */
    final Flowable<T> f61432a;

    /* renamed from: b */
    final Function<? super T, ? extends CompletableSource> f61433b;

    /* renamed from: c */
    final boolean f61434c;

    public FlowableSwitchMapCompletable(Flowable<T> flowable, Function<? super T, ? extends CompletableSource> function, boolean z) {
        this.f61432a = flowable;
        this.f61433b = function;
        this.f61434c = z;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(CompletableObserver completableObserver) {
        this.f61432a.subscribe(new SwitchMapCompletableObserver(completableObserver, this.f61433b, this.f61434c));
    }

    /* renamed from: io.reactivex.internal.operators.mixed.FlowableSwitchMapCompletable$SwitchMapCompletableObserver */
    static final class SwitchMapCompletableObserver<T> implements FlowableSubscriber<T>, Disposable {
        static final SwitchMapInnerObserver INNER_DISPOSED = new SwitchMapInnerObserver((SwitchMapCompletableObserver<?>) null);
        final boolean delayErrors;
        volatile boolean done;
        final CompletableObserver downstream;
        final AtomicThrowable errors = new AtomicThrowable();
        final AtomicReference<SwitchMapInnerObserver> inner = new AtomicReference<>();
        final Function<? super T, ? extends CompletableSource> mapper;
        Subscription upstream;

        SwitchMapCompletableObserver(CompletableObserver completableObserver, Function<? super T, ? extends CompletableSource> function, boolean z) {
            this.downstream = completableObserver;
            this.mapper = function;
            this.delayErrors = z;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void onNext(T t) {
            SwitchMapInnerObserver switchMapInnerObserver;
            try {
                CompletableSource completableSource = (CompletableSource) ObjectHelper.requireNonNull(this.mapper.apply(t), "The mapper returned a null CompletableSource");
                SwitchMapInnerObserver switchMapInnerObserver2 = new SwitchMapInnerObserver(this);
                do {
                    switchMapInnerObserver = this.inner.get();
                    if (switchMapInnerObserver == INNER_DISPOSED) {
                        return;
                    }
                } while (!this.inner.compareAndSet(switchMapInnerObserver, switchMapInnerObserver2));
                if (switchMapInnerObserver != null) {
                    switchMapInnerObserver.dispose();
                }
                completableSource.subscribe(switchMapInnerObserver2);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.upstream.cancel();
                onError(th);
            }
        }

        public void onError(Throwable th) {
            if (!this.errors.addThrowable(th)) {
                RxJavaPlugins.onError(th);
            } else if (this.delayErrors) {
                onComplete();
            } else {
                disposeInner();
                Throwable terminate = this.errors.terminate();
                if (terminate != ExceptionHelper.TERMINATED) {
                    this.downstream.onError(terminate);
                }
            }
        }

        public void onComplete() {
            this.done = true;
            if (this.inner.get() == null) {
                Throwable terminate = this.errors.terminate();
                if (terminate == null) {
                    this.downstream.onComplete();
                } else {
                    this.downstream.onError(terminate);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void disposeInner() {
            SwitchMapInnerObserver andSet = this.inner.getAndSet(INNER_DISPOSED);
            if (andSet != null && andSet != INNER_DISPOSED) {
                andSet.dispose();
            }
        }

        public void dispose() {
            this.upstream.cancel();
            disposeInner();
        }

        public boolean isDisposed() {
            return this.inner.get() == INNER_DISPOSED;
        }

        /* access modifiers changed from: package-private */
        public void innerError(SwitchMapInnerObserver switchMapInnerObserver, Throwable th) {
            if (!this.inner.compareAndSet(switchMapInnerObserver, (Object) null) || !this.errors.addThrowable(th)) {
                RxJavaPlugins.onError(th);
            } else if (!this.delayErrors) {
                dispose();
                Throwable terminate = this.errors.terminate();
                if (terminate != ExceptionHelper.TERMINATED) {
                    this.downstream.onError(terminate);
                }
            } else if (this.done) {
                this.downstream.onError(this.errors.terminate());
            }
        }

        /* access modifiers changed from: package-private */
        public void innerComplete(SwitchMapInnerObserver switchMapInnerObserver) {
            if (this.inner.compareAndSet(switchMapInnerObserver, (Object) null) && this.done) {
                Throwable terminate = this.errors.terminate();
                if (terminate == null) {
                    this.downstream.onComplete();
                } else {
                    this.downstream.onError(terminate);
                }
            }
        }

        /* renamed from: io.reactivex.internal.operators.mixed.FlowableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver */
        static final class SwitchMapInnerObserver extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long serialVersionUID = -8003404460084760287L;
            final SwitchMapCompletableObserver<?> parent;

            SwitchMapInnerObserver(SwitchMapCompletableObserver<?> switchMapCompletableObserver) {
                this.parent = switchMapCompletableObserver;
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            public void onError(Throwable th) {
                this.parent.innerError(this, th);
            }

            public void onComplete() {
                this.parent.innerComplete(this);
            }

            /* access modifiers changed from: package-private */
            public void dispose() {
                DisposableHelper.dispose(this);
            }
        }
    }
}
