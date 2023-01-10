package p218io.reactivex.internal.operators.maybe;

import java.util.concurrent.atomic.AtomicReference;
import p218io.reactivex.MaybeObserver;
import p218io.reactivex.MaybeSource;
import p218io.reactivex.Scheduler;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.internal.disposables.DisposableHelper;
import p218io.reactivex.internal.disposables.SequentialDisposable;

/* renamed from: io.reactivex.internal.operators.maybe.MaybeSubscribeOn */
public final class MaybeSubscribeOn<T> extends C22213a<T, T> {

    /* renamed from: a */
    final Scheduler f61389a;

    public MaybeSubscribeOn(MaybeSource<T> maybeSource, Scheduler scheduler) {
        super(maybeSource);
        this.f61389a = scheduler;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        SubscribeOnMaybeObserver subscribeOnMaybeObserver = new SubscribeOnMaybeObserver(maybeObserver);
        maybeObserver.onSubscribe(subscribeOnMaybeObserver);
        subscribeOnMaybeObserver.task.replace(this.f61389a.scheduleDirect(new SubscribeTask(subscribeOnMaybeObserver, this.source)));
    }

    /* renamed from: io.reactivex.internal.operators.maybe.MaybeSubscribeOn$SubscribeTask */
    static final class SubscribeTask<T> implements Runnable {
        final MaybeObserver<? super T> observer;
        final MaybeSource<T> source;

        SubscribeTask(MaybeObserver<? super T> maybeObserver, MaybeSource<T> maybeSource) {
            this.observer = maybeObserver;
            this.source = maybeSource;
        }

        public void run() {
            this.source.subscribe(this.observer);
        }
    }

    /* renamed from: io.reactivex.internal.operators.maybe.MaybeSubscribeOn$SubscribeOnMaybeObserver */
    static final class SubscribeOnMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = 8571289934935992137L;
        final MaybeObserver<? super T> downstream;
        final SequentialDisposable task = new SequentialDisposable();

        SubscribeOnMaybeObserver(MaybeObserver<? super T> maybeObserver) {
            this.downstream = maybeObserver;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
            this.task.dispose();
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        public void onSuccess(T t) {
            this.downstream.onSuccess(t);
        }

        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        public void onComplete() {
            this.downstream.onComplete();
        }
    }
}
