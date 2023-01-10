package p218io.reactivex.internal.observers;

import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import p218io.reactivex.SingleObserver;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.internal.disposables.DisposableHelper;
import p218io.reactivex.internal.util.BlockingHelper;
import p218io.reactivex.internal.util.ExceptionHelper;
import p218io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.observers.FutureSingleObserver */
public final class FutureSingleObserver<T> extends CountDownLatch implements SingleObserver<T>, Disposable, Future<T> {

    /* renamed from: a */
    T f60836a;

    /* renamed from: b */
    Throwable f60837b;

    /* renamed from: c */
    final AtomicReference<Disposable> f60838c = new AtomicReference<>();

    public void dispose() {
    }

    public FutureSingleObserver() {
        super(1);
    }

    public boolean cancel(boolean z) {
        Disposable disposable;
        do {
            disposable = this.f60838c.get();
            if (disposable == this || disposable == DisposableHelper.DISPOSED) {
                return false;
            }
        } while (!this.f60838c.compareAndSet(disposable, DisposableHelper.DISPOSED));
        if (disposable != null) {
            disposable.dispose();
        }
        countDown();
        return true;
    }

    public boolean isCancelled() {
        return DisposableHelper.isDisposed(this.f60838c.get());
    }

    public boolean isDone() {
        return getCount() == 0;
    }

    public T get() throws InterruptedException, ExecutionException {
        if (getCount() != 0) {
            BlockingHelper.verifyNonBlocking();
            await();
        }
        if (!isCancelled()) {
            Throwable th = this.f60837b;
            if (th == null) {
                return this.f60836a;
            }
            throw new ExecutionException(th);
        }
        throw new CancellationException();
    }

    public T get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        if (getCount() != 0) {
            BlockingHelper.verifyNonBlocking();
            if (!await(j, timeUnit)) {
                throw new TimeoutException(ExceptionHelper.timeoutMessage(j, timeUnit));
            }
        }
        if (!isCancelled()) {
            Throwable th = this.f60837b;
            if (th == null) {
                return this.f60836a;
            }
            throw new ExecutionException(th);
        }
        throw new CancellationException();
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this.f60838c, disposable);
    }

    public void onSuccess(T t) {
        Disposable disposable = this.f60838c.get();
        if (disposable != DisposableHelper.DISPOSED) {
            this.f60836a = t;
            this.f60838c.compareAndSet(disposable, this);
            countDown();
        }
    }

    public void onError(Throwable th) {
        Disposable disposable;
        do {
            disposable = this.f60838c.get();
            if (disposable == DisposableHelper.DISPOSED) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.f60837b = th;
        } while (!this.f60838c.compareAndSet(disposable, this));
        countDown();
    }

    public boolean isDisposed() {
        return isDone();
    }
}
