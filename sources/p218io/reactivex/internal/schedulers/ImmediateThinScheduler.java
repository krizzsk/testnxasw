package p218io.reactivex.internal.schedulers;

import java.util.concurrent.TimeUnit;
import p218io.reactivex.Scheduler;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.disposables.Disposables;

/* renamed from: io.reactivex.internal.schedulers.ImmediateThinScheduler */
public final class ImmediateThinScheduler extends Scheduler {
    public static final Scheduler INSTANCE = new ImmediateThinScheduler();

    /* renamed from: b */
    static final Scheduler.Worker f61982b = new ImmediateThinWorker();

    /* renamed from: c */
    static final Disposable f61983c;

    static {
        Disposable empty = Disposables.empty();
        f61983c = empty;
        empty.dispose();
    }

    private ImmediateThinScheduler() {
    }

    public Disposable scheduleDirect(Runnable runnable) {
        runnable.run();
        return f61983c;
    }

    public Disposable scheduleDirect(Runnable runnable, long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("This scheduler doesn't support delayed execution");
    }

    public Disposable schedulePeriodicallyDirect(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("This scheduler doesn't support periodic execution");
    }

    public Scheduler.Worker createWorker() {
        return f61982b;
    }

    /* renamed from: io.reactivex.internal.schedulers.ImmediateThinScheduler$ImmediateThinWorker */
    static final class ImmediateThinWorker extends Scheduler.Worker {
        public void dispose() {
        }

        public boolean isDisposed() {
            return false;
        }

        ImmediateThinWorker() {
        }

        public Disposable schedule(Runnable runnable) {
            runnable.run();
            return ImmediateThinScheduler.f61983c;
        }

        public Disposable schedule(Runnable runnable, long j, TimeUnit timeUnit) {
            throw new UnsupportedOperationException("This scheduler doesn't support delayed execution");
        }

        public Disposable schedulePeriodically(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            throw new UnsupportedOperationException("This scheduler doesn't support periodic execution");
        }
    }
}
