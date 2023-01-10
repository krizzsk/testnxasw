package p218io.reactivex.internal.operators.observable;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import p218io.reactivex.Observable;
import p218io.reactivex.ObservableSource;
import p218io.reactivex.Observer;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.exceptions.CompositeException;
import p218io.reactivex.exceptions.Exceptions;
import p218io.reactivex.functions.Consumer;
import p218io.reactivex.functions.Function;
import p218io.reactivex.internal.disposables.DisposableHelper;
import p218io.reactivex.internal.disposables.EmptyDisposable;
import p218io.reactivex.internal.functions.ObjectHelper;
import p218io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.observable.ObservableUsing */
public final class ObservableUsing<T, D> extends Observable<T> {

    /* renamed from: a */
    final Callable<? extends D> f61757a;

    /* renamed from: b */
    final Function<? super D, ? extends ObservableSource<? extends T>> f61758b;

    /* renamed from: c */
    final Consumer<? super D> f61759c;

    /* renamed from: d */
    final boolean f61760d;

    public ObservableUsing(Callable<? extends D> callable, Function<? super D, ? extends ObservableSource<? extends T>> function, Consumer<? super D> consumer, boolean z) {
        this.f61757a = callable;
        this.f61758b = function;
        this.f61759c = consumer;
        this.f61760d = z;
    }

    public void subscribeActual(Observer<? super T> observer) {
        try {
            Object call = this.f61757a.call();
            try {
                ((ObservableSource) ObjectHelper.requireNonNull(this.f61758b.apply(call), "The sourceSupplier returned a null ObservableSource")).subscribe(new UsingObserver(observer, call, this.f61759c, this.f61760d));
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptyDisposable.error((Throwable) new CompositeException(th, th), (Observer<?>) observer);
            }
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptyDisposable.error(th2, (Observer<?>) observer);
        }
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableUsing$UsingObserver */
    static final class UsingObserver<T, D> extends AtomicBoolean implements Observer<T>, Disposable {
        private static final long serialVersionUID = 5904473792286235046L;
        final Consumer<? super D> disposer;
        final Observer<? super T> downstream;
        final boolean eager;
        final D resource;
        Disposable upstream;

        UsingObserver(Observer<? super T> observer, D d, Consumer<? super D> consumer, boolean z) {
            this.downstream = observer;
            this.resource = d;
            this.disposer = consumer;
            this.eager = z;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        public void onError(Throwable th) {
            if (this.eager) {
                if (compareAndSet(false, true)) {
                    try {
                        this.disposer.accept(this.resource);
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        th = new CompositeException(th, th2);
                    }
                }
                this.upstream.dispose();
                this.downstream.onError(th);
                return;
            }
            this.downstream.onError(th);
            this.upstream.dispose();
            disposeAfter();
        }

        public void onComplete() {
            if (this.eager) {
                if (compareAndSet(false, true)) {
                    try {
                        this.disposer.accept(this.resource);
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        this.downstream.onError(th);
                        return;
                    }
                }
                this.upstream.dispose();
                this.downstream.onComplete();
                return;
            }
            this.downstream.onComplete();
            this.upstream.dispose();
            disposeAfter();
        }

        public void dispose() {
            disposeAfter();
            this.upstream.dispose();
        }

        public boolean isDisposed() {
            return get();
        }

        /* access modifiers changed from: package-private */
        public void disposeAfter() {
            if (compareAndSet(false, true)) {
                try {
                    this.disposer.accept(this.resource);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    RxJavaPlugins.onError(th);
                }
            }
        }
    }
}
