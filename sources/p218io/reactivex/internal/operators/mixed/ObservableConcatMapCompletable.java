package p218io.reactivex.internal.operators.mixed;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p218io.reactivex.Completable;
import p218io.reactivex.CompletableObserver;
import p218io.reactivex.CompletableSource;
import p218io.reactivex.Observable;
import p218io.reactivex.Observer;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.exceptions.Exceptions;
import p218io.reactivex.functions.Function;
import p218io.reactivex.internal.disposables.DisposableHelper;
import p218io.reactivex.internal.functions.ObjectHelper;
import p218io.reactivex.internal.fuseable.QueueDisposable;
import p218io.reactivex.internal.fuseable.SimpleQueue;
import p218io.reactivex.internal.queue.SpscLinkedArrayQueue;
import p218io.reactivex.internal.util.AtomicThrowable;
import p218io.reactivex.internal.util.ErrorMode;
import p218io.reactivex.internal.util.ExceptionHelper;
import p218io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.mixed.ObservableConcatMapCompletable */
public final class ObservableConcatMapCompletable<T> extends Completable {

    /* renamed from: a */
    final Observable<T> f61447a;

    /* renamed from: b */
    final Function<? super T, ? extends CompletableSource> f61448b;

    /* renamed from: c */
    final ErrorMode f61449c;

    /* renamed from: d */
    final int f61450d;

    public ObservableConcatMapCompletable(Observable<T> observable, Function<? super T, ? extends CompletableSource> function, ErrorMode errorMode, int i) {
        this.f61447a = observable;
        this.f61448b = function;
        this.f61449c = errorMode;
        this.f61450d = i;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(CompletableObserver completableObserver) {
        if (!C22214a.m45938a((Object) this.f61447a, this.f61448b, completableObserver)) {
            this.f61447a.subscribe(new ConcatMapCompletableObserver(completableObserver, this.f61448b, this.f61449c, this.f61450d));
        }
    }

    /* renamed from: io.reactivex.internal.operators.mixed.ObservableConcatMapCompletable$ConcatMapCompletableObserver */
    static final class ConcatMapCompletableObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = 3610901111000061034L;
        volatile boolean active;
        volatile boolean disposed;
        volatile boolean done;
        final CompletableObserver downstream;
        final ErrorMode errorMode;
        final AtomicThrowable errors = new AtomicThrowable();
        final ConcatMapInnerObserver inner = new ConcatMapInnerObserver(this);
        final Function<? super T, ? extends CompletableSource> mapper;
        final int prefetch;
        SimpleQueue<T> queue;
        Disposable upstream;

        ConcatMapCompletableObserver(CompletableObserver completableObserver, Function<? super T, ? extends CompletableSource> function, ErrorMode errorMode2, int i) {
            this.downstream = completableObserver;
            this.mapper = function;
            this.errorMode = errorMode2;
            this.prefetch = i;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int requestFusion = queueDisposable.requestFusion(3);
                    if (requestFusion == 1) {
                        this.queue = queueDisposable;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        drain();
                        return;
                    } else if (requestFusion == 2) {
                        this.queue = queueDisposable;
                        this.downstream.onSubscribe(this);
                        return;
                    }
                }
                this.queue = new SpscLinkedArrayQueue(this.prefetch);
                this.downstream.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            if (t != null) {
                this.queue.offer(t);
            }
            drain();
        }

        public void onError(Throwable th) {
            if (!this.errors.addThrowable(th)) {
                RxJavaPlugins.onError(th);
            } else if (this.errorMode == ErrorMode.IMMEDIATE) {
                this.disposed = true;
                this.inner.dispose();
                Throwable terminate = this.errors.terminate();
                if (terminate != ExceptionHelper.TERMINATED) {
                    this.downstream.onError(terminate);
                }
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            } else {
                this.done = true;
                drain();
            }
        }

        public void onComplete() {
            this.done = true;
            drain();
        }

        public void dispose() {
            this.disposed = true;
            this.upstream.dispose();
            this.inner.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        public boolean isDisposed() {
            return this.disposed;
        }

        /* access modifiers changed from: package-private */
        public void innerError(Throwable th) {
            if (!this.errors.addThrowable(th)) {
                RxJavaPlugins.onError(th);
            } else if (this.errorMode == ErrorMode.IMMEDIATE) {
                this.disposed = true;
                this.upstream.dispose();
                Throwable terminate = this.errors.terminate();
                if (terminate != ExceptionHelper.TERMINATED) {
                    this.downstream.onError(terminate);
                }
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            } else {
                this.active = false;
                drain();
            }
        }

        /* access modifiers changed from: package-private */
        public void innerComplete() {
            this.active = false;
            drain();
        }

        /* access modifiers changed from: package-private */
        public void drain() {
            boolean z;
            if (getAndIncrement() == 0) {
                AtomicThrowable atomicThrowable = this.errors;
                ErrorMode errorMode2 = this.errorMode;
                while (!this.disposed) {
                    if (!this.active) {
                        if (errorMode2 != ErrorMode.BOUNDARY || atomicThrowable.get() == null) {
                            boolean z2 = this.done;
                            CompletableSource completableSource = null;
                            try {
                                T poll = this.queue.poll();
                                if (poll != null) {
                                    completableSource = (CompletableSource) ObjectHelper.requireNonNull(this.mapper.apply(poll), "The mapper returned a null CompletableSource");
                                    z = false;
                                } else {
                                    z = true;
                                }
                                if (z2 && z) {
                                    this.disposed = true;
                                    Throwable terminate = atomicThrowable.terminate();
                                    if (terminate != null) {
                                        this.downstream.onError(terminate);
                                        return;
                                    } else {
                                        this.downstream.onComplete();
                                        return;
                                    }
                                } else if (!z) {
                                    this.active = true;
                                    completableSource.subscribe(this.inner);
                                }
                            } catch (Throwable th) {
                                Exceptions.throwIfFatal(th);
                                this.disposed = true;
                                this.queue.clear();
                                this.upstream.dispose();
                                atomicThrowable.addThrowable(th);
                                this.downstream.onError(atomicThrowable.terminate());
                                return;
                            }
                        } else {
                            this.disposed = true;
                            this.queue.clear();
                            this.downstream.onError(atomicThrowable.terminate());
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
                this.queue.clear();
            }
        }

        /* renamed from: io.reactivex.internal.operators.mixed.ObservableConcatMapCompletable$ConcatMapCompletableObserver$ConcatMapInnerObserver */
        static final class ConcatMapInnerObserver extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long serialVersionUID = 5638352172918776687L;
            final ConcatMapCompletableObserver<?> parent;

            ConcatMapInnerObserver(ConcatMapCompletableObserver<?> concatMapCompletableObserver) {
                this.parent = concatMapCompletableObserver;
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.replace(this, disposable);
            }

            public void onError(Throwable th) {
                this.parent.innerError(th);
            }

            public void onComplete() {
                this.parent.innerComplete();
            }

            /* access modifiers changed from: package-private */
            public void dispose() {
                DisposableHelper.dispose(this);
            }
        }
    }
}
