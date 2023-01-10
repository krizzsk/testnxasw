package p218io.reactivex.internal.observers;

import java.util.concurrent.CountDownLatch;
import p218io.reactivex.Observer;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.internal.util.BlockingHelper;
import p218io.reactivex.internal.util.ExceptionHelper;

/* renamed from: io.reactivex.internal.observers.BlockingBaseObserver */
public abstract class BlockingBaseObserver<T> extends CountDownLatch implements Observer<T>, Disposable {

    /* renamed from: a */
    T f60821a;

    /* renamed from: b */
    Throwable f60822b;

    /* renamed from: c */
    Disposable f60823c;

    /* renamed from: d */
    volatile boolean f60824d;

    public BlockingBaseObserver() {
        super(1);
    }

    public final void onSubscribe(Disposable disposable) {
        this.f60823c = disposable;
        if (this.f60824d) {
            disposable.dispose();
        }
    }

    public final void onComplete() {
        countDown();
    }

    public final void dispose() {
        this.f60824d = true;
        Disposable disposable = this.f60823c;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    public final boolean isDisposed() {
        return this.f60824d;
    }

    public final T blockingGet() {
        if (getCount() != 0) {
            try {
                BlockingHelper.verifyNonBlocking();
                await();
            } catch (InterruptedException e) {
                dispose();
                throw ExceptionHelper.wrapOrThrow(e);
            }
        }
        Throwable th = this.f60822b;
        if (th == null) {
            return this.f60821a;
        }
        throw ExceptionHelper.wrapOrThrow(th);
    }
}
