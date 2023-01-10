package p218io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicInteger;
import p218io.reactivex.Observable;
import p218io.reactivex.ObservableSource;
import p218io.reactivex.Observer;
import p218io.reactivex.Single;
import p218io.reactivex.SingleObserver;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.exceptions.Exceptions;
import p218io.reactivex.functions.BiPredicate;
import p218io.reactivex.internal.disposables.ArrayCompositeDisposable;
import p218io.reactivex.internal.fuseable.FuseToObservable;
import p218io.reactivex.internal.queue.SpscLinkedArrayQueue;
import p218io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.observable.ObservableSequenceEqualSingle */
public final class ObservableSequenceEqualSingle<T> extends Single<Boolean> implements FuseToObservable<Boolean> {

    /* renamed from: a */
    final ObservableSource<? extends T> f61700a;

    /* renamed from: b */
    final ObservableSource<? extends T> f61701b;

    /* renamed from: c */
    final BiPredicate<? super T, ? super T> f61702c;

    /* renamed from: d */
    final int f61703d;

    public ObservableSequenceEqualSingle(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, BiPredicate<? super T, ? super T> biPredicate, int i) {
        this.f61700a = observableSource;
        this.f61701b = observableSource2;
        this.f61702c = biPredicate;
        this.f61703d = i;
    }

    public void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        EqualCoordinator equalCoordinator = new EqualCoordinator(singleObserver, this.f61703d, this.f61700a, this.f61701b, this.f61702c);
        singleObserver.onSubscribe(equalCoordinator);
        equalCoordinator.subscribe();
    }

    public Observable<Boolean> fuseToObservable() {
        return RxJavaPlugins.onAssembly(new ObservableSequenceEqual(this.f61700a, this.f61701b, this.f61702c, this.f61703d));
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableSequenceEqualSingle$EqualCoordinator */
    static final class EqualCoordinator<T> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = -6178010334400373240L;
        volatile boolean cancelled;
        final BiPredicate<? super T, ? super T> comparer;
        final SingleObserver<? super Boolean> downstream;
        final ObservableSource<? extends T> first;
        final EqualObserver<T>[] observers;
        final ArrayCompositeDisposable resources = new ArrayCompositeDisposable(2);
        final ObservableSource<? extends T> second;

        /* renamed from: v1 */
        T f61704v1;

        /* renamed from: v2 */
        T f61705v2;

        EqualCoordinator(SingleObserver<? super Boolean> singleObserver, int i, ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, BiPredicate<? super T, ? super T> biPredicate) {
            this.downstream = singleObserver;
            this.first = observableSource;
            this.second = observableSource2;
            this.comparer = biPredicate;
            EqualObserver<T>[] equalObserverArr = new EqualObserver[2];
            this.observers = equalObserverArr;
            equalObserverArr[0] = new EqualObserver<>(this, 0, i);
            equalObserverArr[1] = new EqualObserver<>(this, 1, i);
        }

        /* access modifiers changed from: package-private */
        public boolean setDisposable(Disposable disposable, int i) {
            return this.resources.setResource(i, disposable);
        }

        /* access modifiers changed from: package-private */
        public void subscribe() {
            EqualObserver<T>[] equalObserverArr = this.observers;
            this.first.subscribe(equalObserverArr[0]);
            this.second.subscribe(equalObserverArr[1]);
        }

        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.resources.dispose();
                if (getAndIncrement() == 0) {
                    EqualObserver<T>[] equalObserverArr = this.observers;
                    equalObserverArr[0].queue.clear();
                    equalObserverArr[1].queue.clear();
                }
            }
        }

        public boolean isDisposed() {
            return this.cancelled;
        }

        /* access modifiers changed from: package-private */
        public void cancel(SpscLinkedArrayQueue<T> spscLinkedArrayQueue, SpscLinkedArrayQueue<T> spscLinkedArrayQueue2) {
            this.cancelled = true;
            spscLinkedArrayQueue.clear();
            spscLinkedArrayQueue2.clear();
        }

        /* access modifiers changed from: package-private */
        public void drain() {
            Throwable th;
            Throwable th2;
            if (getAndIncrement() == 0) {
                EqualObserver<T>[] equalObserverArr = this.observers;
                EqualObserver<T> equalObserver = equalObserverArr[0];
                SpscLinkedArrayQueue<T> spscLinkedArrayQueue = equalObserver.queue;
                EqualObserver<T> equalObserver2 = equalObserverArr[1];
                SpscLinkedArrayQueue<T> spscLinkedArrayQueue2 = equalObserver2.queue;
                int i = 1;
                while (!this.cancelled) {
                    boolean z = equalObserver.done;
                    if (!z || (th2 = equalObserver.error) == null) {
                        boolean z2 = equalObserver2.done;
                        if (!z2 || (th = equalObserver2.error) == null) {
                            if (this.f61704v1 == null) {
                                this.f61704v1 = spscLinkedArrayQueue.poll();
                            }
                            boolean z3 = this.f61704v1 == null;
                            if (this.f61705v2 == null) {
                                this.f61705v2 = spscLinkedArrayQueue2.poll();
                            }
                            boolean z4 = this.f61705v2 == null;
                            if (z && z2 && z3 && z4) {
                                this.downstream.onSuccess(true);
                                return;
                            } else if (!z || !z2 || z3 == z4) {
                                if (!z3 && !z4) {
                                    try {
                                        if (!this.comparer.test(this.f61704v1, this.f61705v2)) {
                                            cancel(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                                            this.downstream.onSuccess(false);
                                            return;
                                        }
                                        this.f61704v1 = null;
                                        this.f61705v2 = null;
                                    } catch (Throwable th3) {
                                        Exceptions.throwIfFatal(th3);
                                        cancel(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                                        this.downstream.onError(th3);
                                        return;
                                    }
                                }
                                if ((z3 || z4) && (i = addAndGet(-i)) == 0) {
                                    return;
                                }
                            } else {
                                cancel(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                                this.downstream.onSuccess(false);
                                return;
                            }
                        } else {
                            cancel(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                            this.downstream.onError(th);
                            return;
                        }
                    } else {
                        cancel(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                        this.downstream.onError(th2);
                        return;
                    }
                }
                spscLinkedArrayQueue.clear();
                spscLinkedArrayQueue2.clear();
            }
        }
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableSequenceEqualSingle$EqualObserver */
    static final class EqualObserver<T> implements Observer<T> {
        volatile boolean done;
        Throwable error;
        final int index;
        final EqualCoordinator<T> parent;
        final SpscLinkedArrayQueue<T> queue;

        EqualObserver(EqualCoordinator<T> equalCoordinator, int i, int i2) {
            this.parent = equalCoordinator;
            this.index = i;
            this.queue = new SpscLinkedArrayQueue<>(i2);
        }

        public void onSubscribe(Disposable disposable) {
            this.parent.setDisposable(disposable, this.index);
        }

        public void onNext(T t) {
            this.queue.offer(t);
            this.parent.drain();
        }

        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            this.parent.drain();
        }

        public void onComplete() {
            this.done = true;
            this.parent.drain();
        }
    }
}
