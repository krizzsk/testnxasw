package p218io.reactivex.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p218io.reactivex.Scheduler;
import p218io.reactivex.disposables.CompositeDisposable;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.internal.disposables.EmptyDisposable;
import p218io.reactivex.internal.disposables.ListCompositeDisposable;
import p218io.reactivex.internal.functions.ObjectHelper;
import p218io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport;

/* renamed from: io.reactivex.internal.schedulers.ComputationScheduler */
public final class ComputationScheduler extends Scheduler implements SchedulerMultiWorkerSupport {

    /* renamed from: b */
    static final FixedSchedulerPool f61969b;

    /* renamed from: c */
    static final RxThreadFactory f61970c;

    /* renamed from: d */
    static final String f61971d = "rx2.computation-threads";

    /* renamed from: e */
    static final int f61972e = m45978a(Runtime.getRuntime().availableProcessors(), Integer.getInteger(f61971d, 0).intValue());

    /* renamed from: f */
    static final PoolWorker f61973f;

    /* renamed from: i */
    private static final String f61974i = "RxComputationThreadPool";

    /* renamed from: j */
    private static final String f61975j = "rx2.computation-priority";

    /* renamed from: g */
    final ThreadFactory f61976g;

    /* renamed from: h */
    final AtomicReference<FixedSchedulerPool> f61977h;

    /* renamed from: a */
    static int m45978a(int i, int i2) {
        return (i2 <= 0 || i2 > i) ? i : i2;
    }

    static {
        PoolWorker poolWorker = new PoolWorker(new RxThreadFactory("RxComputationShutdown"));
        f61973f = poolWorker;
        poolWorker.dispose();
        RxThreadFactory rxThreadFactory = new RxThreadFactory(f61974i, Math.max(1, Math.min(10, Integer.getInteger(f61975j, 5).intValue())), true);
        f61970c = rxThreadFactory;
        FixedSchedulerPool fixedSchedulerPool = new FixedSchedulerPool(0, rxThreadFactory);
        f61969b = fixedSchedulerPool;
        fixedSchedulerPool.shutdown();
    }

    /* renamed from: io.reactivex.internal.schedulers.ComputationScheduler$FixedSchedulerPool */
    static final class FixedSchedulerPool implements SchedulerMultiWorkerSupport {
        final int cores;
        final PoolWorker[] eventLoops;

        /* renamed from: n */
        long f61978n;

        FixedSchedulerPool(int i, ThreadFactory threadFactory) {
            this.cores = i;
            this.eventLoops = new PoolWorker[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.eventLoops[i2] = new PoolWorker(threadFactory);
            }
        }

        public PoolWorker getEventLoop() {
            int i = this.cores;
            if (i == 0) {
                return ComputationScheduler.f61973f;
            }
            PoolWorker[] poolWorkerArr = this.eventLoops;
            long j = this.f61978n;
            this.f61978n = 1 + j;
            return poolWorkerArr[(int) (j % ((long) i))];
        }

        public void shutdown() {
            for (PoolWorker dispose : this.eventLoops) {
                dispose.dispose();
            }
        }

        public void createWorkers(int i, SchedulerMultiWorkerSupport.WorkerCallback workerCallback) {
            int i2 = this.cores;
            if (i2 == 0) {
                for (int i3 = 0; i3 < i; i3++) {
                    workerCallback.onWorker(i3, ComputationScheduler.f61973f);
                }
                return;
            }
            int i4 = ((int) this.f61978n) % i2;
            for (int i5 = 0; i5 < i; i5++) {
                workerCallback.onWorker(i5, new EventLoopWorker(this.eventLoops[i4]));
                i4++;
                if (i4 == i2) {
                    i4 = 0;
                }
            }
            this.f61978n = (long) i4;
        }
    }

    public ComputationScheduler() {
        this(f61970c);
    }

    public ComputationScheduler(ThreadFactory threadFactory) {
        this.f61976g = threadFactory;
        this.f61977h = new AtomicReference<>(f61969b);
        start();
    }

    public Scheduler.Worker createWorker() {
        return new EventLoopWorker(this.f61977h.get().getEventLoop());
    }

    public void createWorkers(int i, SchedulerMultiWorkerSupport.WorkerCallback workerCallback) {
        ObjectHelper.verifyPositive(i, "number > 0 required");
        this.f61977h.get().createWorkers(i, workerCallback);
    }

    public Disposable scheduleDirect(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.f61977h.get().getEventLoop().scheduleDirect(runnable, j, timeUnit);
    }

    public Disposable schedulePeriodicallyDirect(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.f61977h.get().getEventLoop().schedulePeriodicallyDirect(runnable, j, j2, timeUnit);
    }

    public void start() {
        FixedSchedulerPool fixedSchedulerPool = new FixedSchedulerPool(f61972e, this.f61976g);
        if (!this.f61977h.compareAndSet(f61969b, fixedSchedulerPool)) {
            fixedSchedulerPool.shutdown();
        }
    }

    public void shutdown() {
        FixedSchedulerPool fixedSchedulerPool;
        FixedSchedulerPool fixedSchedulerPool2;
        do {
            fixedSchedulerPool = this.f61977h.get();
            fixedSchedulerPool2 = f61969b;
            if (fixedSchedulerPool == fixedSchedulerPool2) {
                return;
            }
        } while (!this.f61977h.compareAndSet(fixedSchedulerPool, fixedSchedulerPool2));
        fixedSchedulerPool.shutdown();
    }

    /* renamed from: io.reactivex.internal.schedulers.ComputationScheduler$EventLoopWorker */
    static final class EventLoopWorker extends Scheduler.Worker {
        private final ListCompositeDisposable both;
        volatile boolean disposed;
        private final PoolWorker poolWorker;
        private final ListCompositeDisposable serial = new ListCompositeDisposable();
        private final CompositeDisposable timed = new CompositeDisposable();

        EventLoopWorker(PoolWorker poolWorker2) {
            this.poolWorker = poolWorker2;
            ListCompositeDisposable listCompositeDisposable = new ListCompositeDisposable();
            this.both = listCompositeDisposable;
            listCompositeDisposable.add(this.serial);
            this.both.add(this.timed);
        }

        public void dispose() {
            if (!this.disposed) {
                this.disposed = true;
                this.both.dispose();
            }
        }

        public boolean isDisposed() {
            return this.disposed;
        }

        public Disposable schedule(Runnable runnable) {
            if (this.disposed) {
                return EmptyDisposable.INSTANCE;
            }
            return this.poolWorker.scheduleActual(runnable, 0, TimeUnit.MILLISECONDS, this.serial);
        }

        public Disposable schedule(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.disposed) {
                return EmptyDisposable.INSTANCE;
            }
            return this.poolWorker.scheduleActual(runnable, j, timeUnit, this.timed);
        }
    }

    /* renamed from: io.reactivex.internal.schedulers.ComputationScheduler$PoolWorker */
    static final class PoolWorker extends NewThreadWorker {
        PoolWorker(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }
}
