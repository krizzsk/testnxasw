package p218io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicReference;
import p218io.reactivex.ObservableSource;
import p218io.reactivex.Observer;
import p218io.reactivex.Scheduler;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.internal.disposables.DisposableHelper;

/* renamed from: io.reactivex.internal.operators.observable.ObservableSubscribeOn */
public final class ObservableSubscribeOn<T> extends C22215a<T, T> {

    /* renamed from: a */
    final Scheduler f61718a;

    public ObservableSubscribeOn(ObservableSource<T> observableSource, Scheduler scheduler) {
        super(observableSource);
        this.f61718a = scheduler;
    }

    public void subscribeActual(Observer<? super T> observer) {
        SubscribeOnObserver subscribeOnObserver = new SubscribeOnObserver(observer);
        observer.onSubscribe(subscribeOnObserver);
        subscribeOnObserver.setDisposable(this.f61718a.scheduleDirect(new SubscribeTask(subscribeOnObserver)));
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableSubscribeOn$SubscribeOnObserver */
    static final class SubscribeOnObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
        private static final long serialVersionUID = 8094547886072529208L;
        final Observer<? super T> downstream;
        final AtomicReference<Disposable> upstream = new AtomicReference<>();

        SubscribeOnObserver(Observer<? super T> observer) {
            this.downstream = observer;
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.upstream, disposable);
        }

        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        public void onComplete() {
            this.downstream.onComplete();
        }

        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        /* access modifiers changed from: package-private */
        public void setDisposable(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableSubscribeOn$SubscribeTask */
    final class SubscribeTask implements Runnable {
        private final SubscribeOnObserver<T> parent;

        SubscribeTask(SubscribeOnObserver<T> subscribeOnObserver) {
            this.parent = subscribeOnObserver;
        }

        public void run() {
            ObservableSubscribeOn.this.source.subscribe(this.parent);
        }
    }
}
