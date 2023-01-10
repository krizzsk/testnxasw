package p218io.reactivex.internal.schedulers;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p218io.reactivex.Scheduler;
import p218io.reactivex.disposables.CompositeDisposable;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.internal.disposables.EmptyDisposable;
import p218io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.schedulers.SingleScheduler */
public final class SingleScheduler extends Scheduler {

    /* renamed from: d */
    static final RxThreadFactory f62009d = new RxThreadFactory(f62012g, Math.max(1, Math.min(10, Integer.getInteger(f62011f, 5).intValue())), true);

    /* renamed from: e */
    static final ScheduledExecutorService f62010e;

    /* renamed from: f */
    private static final String f62011f = "rx2.single-priority";

    /* renamed from: g */
    private static final String f62012g = "RxSingleScheduler";

    /* renamed from: b */
    final ThreadFactory f62013b;

    /* renamed from: c */
    final AtomicReference<ScheduledExecutorService> f62014c;

    static {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(0);
        f62010e = newScheduledThreadPool;
        newScheduledThreadPool.shutdown();
    }

    public SingleScheduler() {
        this(f62009d);
    }

    public SingleScheduler(ThreadFactory threadFactory) {
        AtomicReference<ScheduledExecutorService> atomicReference = new AtomicReference<>();
        this.f62014c = atomicReference;
        this.f62013b = threadFactory;
        atomicReference.lazySet(m45981a(threadFactory));
    }

    /* renamed from: a */
    static ScheduledExecutorService m45981a(ThreadFactory threadFactory) {
        return SchedulerPoolFactory.create(threadFactory);
    }

    public void start() {
        ScheduledExecutorService scheduledExecutorService;
        ScheduledExecutorService scheduledExecutorService2 = null;
        do {
            scheduledExecutorService = this.f62014c.get();
            if (scheduledExecutorService != f62010e) {
                if (scheduledExecutorService2 != null) {
                    scheduledExecutorService2.shutdown();
                    return;
                }
                return;
            } else if (scheduledExecutorService2 == null) {
                scheduledExecutorService2 = m45981a(this.f62013b);
            }
        } while (!this.f62014c.compareAndSet(scheduledExecutorService, scheduledExecutorService2));
    }

    public void shutdown() {
        ScheduledExecutorService andSet;
        ScheduledExecutorService scheduledExecutorService = this.f62014c.get();
        ScheduledExecutorService scheduledExecutorService2 = f62010e;
        if (scheduledExecutorService != scheduledExecutorService2 && (andSet = this.f62014c.getAndSet(scheduledExecutorService2)) != f62010e) {
            andSet.shutdownNow();
        }
    }

    public Scheduler.Worker createWorker() {
        return new ScheduledWorker(this.f62014c.get());
    }

    public Disposable scheduleDirect(Runnable runnable, long j, TimeUnit timeUnit) {
        Future future;
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(RxJavaPlugins.onSchedule(runnable));
        if (j <= 0) {
            try {
                future = this.f62014c.get().submit(scheduledDirectTask);
            } catch (RejectedExecutionException e) {
                RxJavaPlugins.onError(e);
                return EmptyDisposable.INSTANCE;
            }
        } else {
            future = this.f62014c.get().schedule(scheduledDirectTask, j, timeUnit);
        }
        scheduledDirectTask.setFuture(future);
        return scheduledDirectTask;
    }

    public Disposable schedulePeriodicallyDirect(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        Future future;
        Runnable onSchedule = RxJavaPlugins.onSchedule(runnable);
        if (j2 <= 0) {
            ScheduledExecutorService scheduledExecutorService = this.f62014c.get();
            C22220b bVar = new C22220b(onSchedule, scheduledExecutorService);
            if (j <= 0) {
                try {
                    future = scheduledExecutorService.submit(bVar);
                } catch (RejectedExecutionException e) {
                    RxJavaPlugins.onError(e);
                    return EmptyDisposable.INSTANCE;
                }
            } else {
                future = scheduledExecutorService.schedule(bVar, j, timeUnit);
            }
            bVar.mo184975a(future);
            return bVar;
        }
        ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(onSchedule);
        try {
            scheduledDirectPeriodicTask.setFuture(this.f62014c.get().scheduleAtFixedRate(scheduledDirectPeriodicTask, j, j2, timeUnit));
            return scheduledDirectPeriodicTask;
        } catch (RejectedExecutionException e2) {
            RxJavaPlugins.onError(e2);
            return EmptyDisposable.INSTANCE;
        }
    }

    /* renamed from: io.reactivex.internal.schedulers.SingleScheduler$ScheduledWorker */
    static final class ScheduledWorker extends Scheduler.Worker {
        volatile boolean disposed;
        final ScheduledExecutorService executor;
        final CompositeDisposable tasks = new CompositeDisposable();

        ScheduledWorker(ScheduledExecutorService scheduledExecutorService) {
            this.executor = scheduledExecutorService;
        }

        public Disposable schedule(Runnable runnable, long j, TimeUnit timeUnit) {
            Future future;
            if (this.disposed) {
                return EmptyDisposable.INSTANCE;
            }
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(RxJavaPlugins.onSchedule(runnable), this.tasks);
            this.tasks.add(scheduledRunnable);
            if (j <= 0) {
                try {
                    future = this.executor.submit(scheduledRunnable);
                } catch (RejectedExecutionException e) {
                    dispose();
                    RxJavaPlugins.onError(e);
                    return EmptyDisposable.INSTANCE;
                }
            } else {
                future = this.executor.schedule(scheduledRunnable, j, timeUnit);
            }
            scheduledRunnable.setFuture(future);
            return scheduledRunnable;
        }

        public void dispose() {
            if (!this.disposed) {
                this.disposed = true;
                this.tasks.dispose();
            }
        }

        public boolean isDisposed() {
            return this.disposed;
        }
    }
}
