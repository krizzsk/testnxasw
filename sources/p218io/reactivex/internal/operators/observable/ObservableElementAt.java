package p218io.reactivex.internal.operators.observable;

import java.util.NoSuchElementException;
import p218io.reactivex.ObservableSource;
import p218io.reactivex.Observer;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.internal.disposables.DisposableHelper;
import p218io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.observable.ObservableElementAt */
public final class ObservableElementAt<T> extends C22215a<T, T> {

    /* renamed from: a */
    final long f61570a;

    /* renamed from: b */
    final T f61571b;

    /* renamed from: c */
    final boolean f61572c;

    public ObservableElementAt(ObservableSource<T> observableSource, long j, T t, boolean z) {
        super(observableSource);
        this.f61570a = j;
        this.f61571b = t;
        this.f61572c = z;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new ElementAtObserver(observer, this.f61570a, this.f61571b, this.f61572c));
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableElementAt$ElementAtObserver */
    static final class ElementAtObserver<T> implements Observer<T>, Disposable {
        long count;
        final T defaultValue;
        boolean done;
        final Observer<? super T> downstream;
        final boolean errorOnFewer;
        final long index;
        Disposable upstream;

        ElementAtObserver(Observer<? super T> observer, long j, T t, boolean z) {
            this.downstream = observer;
            this.index = j;
            this.defaultValue = t;
            this.errorOnFewer = z;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        public void dispose() {
            this.upstream.dispose();
        }

        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        public void onNext(T t) {
            if (!this.done) {
                long j = this.count;
                if (j == this.index) {
                    this.done = true;
                    this.upstream.dispose();
                    this.downstream.onNext(t);
                    this.downstream.onComplete();
                    return;
                }
                this.count = j + 1;
            }
        }

        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.downstream.onError(th);
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                T t = this.defaultValue;
                if (t != null || !this.errorOnFewer) {
                    if (t != null) {
                        this.downstream.onNext(t);
                    }
                    this.downstream.onComplete();
                    return;
                }
                this.downstream.onError(new NoSuchElementException());
            }
        }
    }
}
