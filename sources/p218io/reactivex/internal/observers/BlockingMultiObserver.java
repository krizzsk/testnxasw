package p218io.reactivex.internal.observers;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import p218io.reactivex.CompletableObserver;
import p218io.reactivex.MaybeObserver;
import p218io.reactivex.SingleObserver;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.internal.util.BlockingHelper;
import p218io.reactivex.internal.util.ExceptionHelper;

/* renamed from: io.reactivex.internal.observers.BlockingMultiObserver */
public final class BlockingMultiObserver<T> extends CountDownLatch implements CompletableObserver, MaybeObserver<T>, SingleObserver<T> {

    /* renamed from: a */
    T f60825a;

    /* renamed from: b */
    Throwable f60826b;

    /* renamed from: c */
    Disposable f60827c;

    /* renamed from: d */
    volatile boolean f60828d;

    public BlockingMultiObserver() {
        super(1);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo184031a() {
        this.f60828d = true;
        Disposable disposable = this.f60827c;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    public void onSubscribe(Disposable disposable) {
        this.f60827c = disposable;
        if (this.f60828d) {
            disposable.dispose();
        }
    }

    public void onSuccess(T t) {
        this.f60825a = t;
        countDown();
    }

    public void onError(Throwable th) {
        this.f60826b = th;
        countDown();
    }

    public void onComplete() {
        countDown();
    }

    public T blockingGet() {
        if (getCount() != 0) {
            try {
                BlockingHelper.verifyNonBlocking();
                await();
            } catch (InterruptedException e) {
                mo184031a();
                throw ExceptionHelper.wrapOrThrow(e);
            }
        }
        Throwable th = this.f60826b;
        if (th == null) {
            return this.f60825a;
        }
        throw ExceptionHelper.wrapOrThrow(th);
    }

    public T blockingGet(T t) {
        if (getCount() != 0) {
            try {
                BlockingHelper.verifyNonBlocking();
                await();
            } catch (InterruptedException e) {
                mo184031a();
                throw ExceptionHelper.wrapOrThrow(e);
            }
        }
        Throwable th = this.f60826b;
        if (th == null) {
            T t2 = this.f60825a;
            return t2 != null ? t2 : t;
        }
        throw ExceptionHelper.wrapOrThrow(th);
    }

    public Throwable blockingGetError() {
        if (getCount() != 0) {
            try {
                BlockingHelper.verifyNonBlocking();
                await();
            } catch (InterruptedException e) {
                mo184031a();
                return e;
            }
        }
        return this.f60826b;
    }

    public Throwable blockingGetError(long j, TimeUnit timeUnit) {
        if (getCount() != 0) {
            try {
                BlockingHelper.verifyNonBlocking();
                if (!await(j, timeUnit)) {
                    mo184031a();
                    throw ExceptionHelper.wrapOrThrow(new TimeoutException(ExceptionHelper.timeoutMessage(j, timeUnit)));
                }
            } catch (InterruptedException e) {
                mo184031a();
                throw ExceptionHelper.wrapOrThrow(e);
            }
        }
        return this.f60826b;
    }

    public boolean blockingAwait(long j, TimeUnit timeUnit) {
        if (getCount() != 0) {
            try {
                BlockingHelper.verifyNonBlocking();
                if (!await(j, timeUnit)) {
                    mo184031a();
                    return false;
                }
            } catch (InterruptedException e) {
                mo184031a();
                throw ExceptionHelper.wrapOrThrow(e);
            }
        }
        Throwable th = this.f60826b;
        if (th == null) {
            return true;
        }
        throw ExceptionHelper.wrapOrThrow(th);
    }
}
