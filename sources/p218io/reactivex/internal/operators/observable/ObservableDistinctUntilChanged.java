package p218io.reactivex.internal.operators.observable;

import p218io.reactivex.ObservableSource;
import p218io.reactivex.Observer;
import p218io.reactivex.functions.BiPredicate;
import p218io.reactivex.functions.Function;
import p218io.reactivex.internal.observers.BasicFuseableObserver;

/* renamed from: io.reactivex.internal.operators.observable.ObservableDistinctUntilChanged */
public final class ObservableDistinctUntilChanged<T, K> extends C22215a<T, T> {

    /* renamed from: a */
    final Function<? super T, K> f61559a;

    /* renamed from: b */
    final BiPredicate<? super K, ? super K> f61560b;

    public ObservableDistinctUntilChanged(ObservableSource<T> observableSource, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
        super(observableSource);
        this.f61559a = function;
        this.f61560b = biPredicate;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new DistinctUntilChangedObserver(observer, this.f61559a, this.f61560b));
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableDistinctUntilChanged$DistinctUntilChangedObserver */
    static final class DistinctUntilChangedObserver<T, K> extends BasicFuseableObserver<T, T> {
        final BiPredicate<? super K, ? super K> comparer;
        boolean hasValue;
        final Function<? super T, K> keySelector;
        K last;

        DistinctUntilChangedObserver(Observer<? super T> observer, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
            super(observer);
            this.keySelector = function;
            this.comparer = biPredicate;
        }

        public void onNext(T t) {
            if (!this.done) {
                if (this.sourceMode != 0) {
                    this.downstream.onNext(t);
                    return;
                }
                try {
                    K apply = this.keySelector.apply(t);
                    if (this.hasValue) {
                        boolean test = this.comparer.test(this.last, apply);
                        this.last = apply;
                        if (test) {
                            return;
                        }
                    } else {
                        this.hasValue = true;
                        this.last = apply;
                    }
                    this.downstream.onNext(t);
                } catch (Throwable th) {
                    fail(th);
                }
            }
        }

        public int requestFusion(int i) {
            return transitiveBoundaryFusion(i);
        }

        public T poll() throws Exception {
            while (true) {
                T poll = this.f60820qd.poll();
                if (poll == null) {
                    return null;
                }
                K apply = this.keySelector.apply(poll);
                if (!this.hasValue) {
                    this.hasValue = true;
                    this.last = apply;
                    return poll;
                } else if (!this.comparer.test(this.last, apply)) {
                    this.last = apply;
                    return poll;
                } else {
                    this.last = apply;
                }
            }
        }
    }
}
