package p218io.reactivex.internal.operators.completable;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import p218io.reactivex.Completable;
import p218io.reactivex.CompletableObserver;
import p218io.reactivex.CompletableSource;
import p218io.reactivex.Scheduler;
import p218io.reactivex.disposables.CompositeDisposable;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.internal.util.ExceptionHelper;
import p218io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.completable.CompletableTimeout */
public final class CompletableTimeout extends Completable {

    /* renamed from: a */
    final CompletableSource f60919a;

    /* renamed from: b */
    final long f60920b;

    /* renamed from: c */
    final TimeUnit f60921c;

    /* renamed from: d */
    final Scheduler f60922d;

    /* renamed from: e */
    final CompletableSource f60923e;

    public CompletableTimeout(CompletableSource completableSource, long j, TimeUnit timeUnit, Scheduler scheduler, CompletableSource completableSource2) {
        this.f60919a = completableSource;
        this.f60920b = j;
        this.f60921c = timeUnit;
        this.f60922d = scheduler;
        this.f60923e = completableSource2;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        completableObserver.onSubscribe(compositeDisposable);
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        compositeDisposable.add(this.f60922d.scheduleDirect(new DisposeTask(atomicBoolean, compositeDisposable, completableObserver), this.f60920b, this.f60921c));
        this.f60919a.subscribe(new TimeOutObserver(compositeDisposable, atomicBoolean, completableObserver));
    }

    /* renamed from: io.reactivex.internal.operators.completable.CompletableTimeout$TimeOutObserver */
    static final class TimeOutObserver implements CompletableObserver {
        private final CompletableObserver downstream;
        private final AtomicBoolean once;
        private final CompositeDisposable set;

        TimeOutObserver(CompositeDisposable compositeDisposable, AtomicBoolean atomicBoolean, CompletableObserver completableObserver) {
            this.set = compositeDisposable;
            this.once = atomicBoolean;
            this.downstream = completableObserver;
        }

        public void onSubscribe(Disposable disposable) {
            this.set.add(disposable);
        }

        public void onError(Throwable th) {
            if (this.once.compareAndSet(false, true)) {
                this.set.dispose();
                this.downstream.onError(th);
                return;
            }
            RxJavaPlugins.onError(th);
        }

        public void onComplete() {
            if (this.once.compareAndSet(false, true)) {
                this.set.dispose();
                this.downstream.onComplete();
            }
        }
    }

    /* renamed from: io.reactivex.internal.operators.completable.CompletableTimeout$DisposeTask */
    final class DisposeTask implements Runnable {
        final CompletableObserver downstream;
        private final AtomicBoolean once;
        final CompositeDisposable set;

        DisposeTask(AtomicBoolean atomicBoolean, CompositeDisposable compositeDisposable, CompletableObserver completableObserver) {
            this.once = atomicBoolean;
            this.set = compositeDisposable;
            this.downstream = completableObserver;
        }

        public void run() {
            if (this.once.compareAndSet(false, true)) {
                this.set.clear();
                if (CompletableTimeout.this.f60923e == null) {
                    this.downstream.onError(new TimeoutException(ExceptionHelper.timeoutMessage(CompletableTimeout.this.f60920b, CompletableTimeout.this.f60921c)));
                } else {
                    CompletableTimeout.this.f60923e.subscribe(new DisposeObserver());
                }
            }
        }

        /* renamed from: io.reactivex.internal.operators.completable.CompletableTimeout$DisposeTask$DisposeObserver */
        final class DisposeObserver implements CompletableObserver {
            DisposeObserver() {
            }

            public void onSubscribe(Disposable disposable) {
                DisposeTask.this.set.add(disposable);
            }

            public void onError(Throwable th) {
                DisposeTask.this.set.dispose();
                DisposeTask.this.downstream.onError(th);
            }

            public void onComplete() {
                DisposeTask.this.set.dispose();
                DisposeTask.this.downstream.onComplete();
            }
        }
    }
}
