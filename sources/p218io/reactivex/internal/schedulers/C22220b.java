package p218io.reactivex.internal.schedulers;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.internal.functions.Functions;
import p218io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.schedulers.b */
/* compiled from: InstantPeriodicTask */
final class C22220b implements Disposable, Callable<Void> {

    /* renamed from: f */
    static final FutureTask<Void> f62017f = new FutureTask<>(Functions.EMPTY_RUNNABLE, (Object) null);

    /* renamed from: a */
    final Runnable f62018a;

    /* renamed from: b */
    final AtomicReference<Future<?>> f62019b = new AtomicReference<>();

    /* renamed from: c */
    final AtomicReference<Future<?>> f62020c = new AtomicReference<>();

    /* renamed from: d */
    final ExecutorService f62021d;

    /* renamed from: e */
    Thread f62022e;

    C22220b(Runnable runnable, ExecutorService executorService) {
        this.f62018a = runnable;
        this.f62021d = executorService;
    }

    /* renamed from: a */
    public Void call() throws Exception {
        this.f62022e = Thread.currentThread();
        try {
            this.f62018a.run();
            mo184976b(this.f62021d.submit(this));
            this.f62022e = null;
        } catch (Throwable th) {
            this.f62022e = null;
            RxJavaPlugins.onError(th);
        }
        return null;
    }

    public void dispose() {
        Future andSet = this.f62020c.getAndSet(f62017f);
        boolean z = true;
        if (!(andSet == null || andSet == f62017f)) {
            andSet.cancel(this.f62022e != Thread.currentThread());
        }
        Future andSet2 = this.f62019b.getAndSet(f62017f);
        if (andSet2 != null && andSet2 != f62017f) {
            if (this.f62022e == Thread.currentThread()) {
                z = false;
            }
            andSet2.cancel(z);
        }
    }

    public boolean isDisposed() {
        return this.f62020c.get() == f62017f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo184975a(Future<?> future) {
        Future future2;
        do {
            future2 = this.f62020c.get();
            if (future2 == f62017f) {
                future.cancel(this.f62022e != Thread.currentThread());
                return;
            }
        } while (!this.f62020c.compareAndSet(future2, future));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo184976b(Future<?> future) {
        Future future2;
        do {
            future2 = this.f62019b.get();
            if (future2 == f62017f) {
                future.cancel(this.f62022e != Thread.currentThread());
                return;
            }
        } while (!this.f62019b.compareAndSet(future2, future));
    }
}
