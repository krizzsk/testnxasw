package p218io.reactivex.internal.operators.single;

import java.util.concurrent.atomic.AtomicReference;
import p218io.reactivex.Scheduler;
import p218io.reactivex.Single;
import p218io.reactivex.SingleObserver;
import p218io.reactivex.SingleSource;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.internal.disposables.DisposableHelper;

/* renamed from: io.reactivex.internal.operators.single.SingleUnsubscribeOn */
public final class SingleUnsubscribeOn<T> extends Single<T> {

    /* renamed from: a */
    final SingleSource<T> f61946a;

    /* renamed from: b */
    final Scheduler f61947b;

    public SingleUnsubscribeOn(SingleSource<T> singleSource, Scheduler scheduler) {
        this.f61946a = singleSource;
        this.f61947b = scheduler;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f61946a.subscribe(new UnsubscribeOnSingleObserver(singleObserver, this.f61947b));
    }

    /* renamed from: io.reactivex.internal.operators.single.SingleUnsubscribeOn$UnsubscribeOnSingleObserver */
    static final class UnsubscribeOnSingleObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable, Runnable {
        private static final long serialVersionUID = 3256698449646456986L;
        final SingleObserver<? super T> downstream;

        /* renamed from: ds */
        Disposable f61948ds;
        final Scheduler scheduler;

        UnsubscribeOnSingleObserver(SingleObserver<? super T> singleObserver, Scheduler scheduler2) {
            this.downstream = singleObserver;
            this.scheduler = scheduler2;
        }

        public void dispose() {
            Disposable disposable = (Disposable) getAndSet(DisposableHelper.DISPOSED);
            if (disposable != DisposableHelper.DISPOSED) {
                this.f61948ds = disposable;
                this.scheduler.scheduleDirect(this);
            }
        }

        public void run() {
            this.f61948ds.dispose();
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                this.downstream.onSubscribe(this);
            }
        }

        public void onSuccess(T t) {
            this.downstream.onSuccess(t);
        }

        public void onError(Throwable th) {
            this.downstream.onError(th);
        }
    }
}
