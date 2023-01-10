package p218io.reactivex.internal.schedulers;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p218io.reactivex.Scheduler;
import p218io.reactivex.disposables.CompositeDisposable;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.internal.disposables.EmptyDisposable;

/* renamed from: io.reactivex.internal.schedulers.IoScheduler */
public final class IoScheduler extends Scheduler {
    public static final long KEEP_ALIVE_TIME_DEFAULT = 60;

    /* renamed from: b */
    static final RxThreadFactory f61984b;

    /* renamed from: c */
    static final RxThreadFactory f61985c;

    /* renamed from: d */
    static final ThreadWorker f61986d;

    /* renamed from: g */
    static final CachedWorkerPool f61987g;

    /* renamed from: h */
    private static final String f61988h = "RxCachedThreadScheduler";

    /* renamed from: i */
    private static final String f61989i = "RxCachedWorkerPoolEvictor";

    /* renamed from: j */
    private static final String f61990j = "rx2.io-keep-alive-time";

    /* renamed from: k */
    private static final long f61991k = Long.getLong(f61990j, 60).longValue();

    /* renamed from: l */
    private static final TimeUnit f61992l = TimeUnit.SECONDS;

    /* renamed from: m */
    private static final String f61993m = "rx2.io-priority";

    /* renamed from: e */
    final ThreadFactory f61994e;

    /* renamed from: f */
    final AtomicReference<CachedWorkerPool> f61995f;

    static {
        ThreadWorker threadWorker = new ThreadWorker(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
        f61986d = threadWorker;
        threadWorker.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger(f61993m, 5).intValue()));
        f61984b = new RxThreadFactory(f61988h, max);
        f61985c = new RxThreadFactory(f61989i, max);
        CachedWorkerPool cachedWorkerPool = new CachedWorkerPool(0, (TimeUnit) null, f61984b);
        f61987g = cachedWorkerPool;
        cachedWorkerPool.shutdown();
    }

    /* renamed from: io.reactivex.internal.schedulers.IoScheduler$CachedWorkerPool */
    static final class CachedWorkerPool implements Runnable {
        final CompositeDisposable allWorkers;
        private final ScheduledExecutorService evictorService;
        private final Future<?> evictorTask;
        private final ConcurrentLinkedQueue<ThreadWorker> expiringWorkerQueue;
        private final long keepAliveTime;
        private final ThreadFactory threadFactory;

        CachedWorkerPool(long j, TimeUnit timeUnit, ThreadFactory threadFactory2) {
            ScheduledFuture<?> scheduledFuture;
            this.keepAliveTime = timeUnit != null ? timeUnit.toNanos(j) : 0;
            this.expiringWorkerQueue = new ConcurrentLinkedQueue<>();
            this.allWorkers = new CompositeDisposable();
            this.threadFactory = threadFactory2;
            ScheduledExecutorService scheduledExecutorService = null;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, IoScheduler.f61985c);
                long j2 = this.keepAliveTime;
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(this, j2, j2, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.evictorService = scheduledExecutorService;
            this.evictorTask = scheduledFuture;
        }

        public void run() {
            evictExpiredWorkers();
        }

        /* access modifiers changed from: package-private */
        public ThreadWorker get() {
            if (this.allWorkers.isDisposed()) {
                return IoScheduler.f61986d;
            }
            while (!this.expiringWorkerQueue.isEmpty()) {
                ThreadWorker poll = this.expiringWorkerQueue.poll();
                if (poll != null) {
                    return poll;
                }
            }
            ThreadWorker threadWorker = new ThreadWorker(this.threadFactory);
            this.allWorkers.add(threadWorker);
            return threadWorker;
        }

        /* access modifiers changed from: package-private */
        public void release(ThreadWorker threadWorker) {
            threadWorker.setExpirationTime(now() + this.keepAliveTime);
            this.expiringWorkerQueue.offer(threadWorker);
        }

        /* access modifiers changed from: package-private */
        public void evictExpiredWorkers() {
            if (!this.expiringWorkerQueue.isEmpty()) {
                long now = now();
                Iterator<ThreadWorker> it = this.expiringWorkerQueue.iterator();
                while (it.hasNext()) {
                    ThreadWorker next = it.next();
                    if (next.getExpirationTime() > now) {
                        return;
                    }
                    if (this.expiringWorkerQueue.remove(next)) {
                        this.allWorkers.remove(next);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public long now() {
            return System.nanoTime();
        }

        /* access modifiers changed from: package-private */
        public void shutdown() {
            this.allWorkers.dispose();
            Future<?> future = this.evictorTask;
            if (future != null) {
                future.cancel(true);
            }
            ScheduledExecutorService scheduledExecutorService = this.evictorService;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
        }
    }

    public IoScheduler() {
        this(f61984b);
    }

    public IoScheduler(ThreadFactory threadFactory) {
        this.f61994e = threadFactory;
        this.f61995f = new AtomicReference<>(f61987g);
        start();
    }

    public void start() {
        CachedWorkerPool cachedWorkerPool = new CachedWorkerPool(f61991k, f61992l, this.f61994e);
        if (!this.f61995f.compareAndSet(f61987g, cachedWorkerPool)) {
            cachedWorkerPool.shutdown();
        }
    }

    public void shutdown() {
        CachedWorkerPool cachedWorkerPool;
        CachedWorkerPool cachedWorkerPool2;
        do {
            cachedWorkerPool = this.f61995f.get();
            cachedWorkerPool2 = f61987g;
            if (cachedWorkerPool == cachedWorkerPool2) {
                return;
            }
        } while (!this.f61995f.compareAndSet(cachedWorkerPool, cachedWorkerPool2));
        cachedWorkerPool.shutdown();
    }

    public Scheduler.Worker createWorker() {
        return new EventLoopWorker(this.f61995f.get());
    }

    public int size() {
        return this.f61995f.get().allWorkers.size();
    }

    /* renamed from: io.reactivex.internal.schedulers.IoScheduler$EventLoopWorker */
    static final class EventLoopWorker extends Scheduler.Worker {
        final AtomicBoolean once = new AtomicBoolean();
        private final CachedWorkerPool pool;
        private final CompositeDisposable tasks;
        private final ThreadWorker threadWorker;

        EventLoopWorker(CachedWorkerPool cachedWorkerPool) {
            this.pool = cachedWorkerPool;
            this.tasks = new CompositeDisposable();
            this.threadWorker = cachedWorkerPool.get();
        }

        public void dispose() {
            if (this.once.compareAndSet(false, true)) {
                this.tasks.dispose();
                this.pool.release(this.threadWorker);
            }
        }

        public boolean isDisposed() {
            return this.once.get();
        }

        public Disposable schedule(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.tasks.isDisposed()) {
                return EmptyDisposable.INSTANCE;
            }
            return this.threadWorker.scheduleActual(runnable, j, timeUnit, this.tasks);
        }
    }

    /* renamed from: io.reactivex.internal.schedulers.IoScheduler$ThreadWorker */
    static final class ThreadWorker extends NewThreadWorker {
        private long expirationTime = 0;

        ThreadWorker(ThreadFactory threadFactory) {
            super(threadFactory);
        }

        public long getExpirationTime() {
            return this.expirationTime;
        }

        public void setExpirationTime(long j) {
            this.expirationTime = j;
        }
    }
}
