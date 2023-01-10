package p218io.reactivex.internal.schedulers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: io.reactivex.internal.schedulers.SchedulerPoolFactory */
public final class SchedulerPoolFactory {
    public static final boolean PURGE_ENABLED;
    public static final int PURGE_PERIOD_SECONDS;

    /* renamed from: a */
    static final String f62000a = "rx2.purge-enabled";

    /* renamed from: b */
    static final String f62001b = "rx2.purge-period-seconds";

    /* renamed from: c */
    static final AtomicReference<ScheduledExecutorService> f62002c = new AtomicReference<>();

    /* renamed from: d */
    static final Map<ScheduledThreadPoolExecutor, Object> f62003d = new ConcurrentHashMap();

    private SchedulerPoolFactory() {
        throw new IllegalStateException("No instances!");
    }

    static {
        Properties properties = System.getProperties();
        PurgeProperties purgeProperties = new PurgeProperties();
        purgeProperties.load(properties);
        PURGE_ENABLED = purgeProperties.purgeEnable;
        PURGE_PERIOD_SECONDS = purgeProperties.purgePeriod;
        start();
    }

    public static void start() {
        m45979a(PURGE_ENABLED);
    }

    /* renamed from: a */
    static void m45979a(boolean z) {
        if (z) {
            while (true) {
                ScheduledExecutorService scheduledExecutorService = f62002c.get();
                if (scheduledExecutorService == null) {
                    ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, new RxThreadFactory("RxSchedulerPurge"));
                    if (f62002c.compareAndSet(scheduledExecutorService, newScheduledThreadPool)) {
                        ScheduledTask scheduledTask = new ScheduledTask();
                        int i = PURGE_PERIOD_SECONDS;
                        newScheduledThreadPool.scheduleAtFixedRate(scheduledTask, (long) i, (long) i, TimeUnit.SECONDS);
                        return;
                    }
                    newScheduledThreadPool.shutdownNow();
                } else {
                    return;
                }
            }
        }
    }

    public static void shutdown() {
        ScheduledExecutorService andSet = f62002c.getAndSet((Object) null);
        if (andSet != null) {
            andSet.shutdownNow();
        }
        f62003d.clear();
    }

    /* renamed from: io.reactivex.internal.schedulers.SchedulerPoolFactory$PurgeProperties */
    static final class PurgeProperties {
        boolean purgeEnable;
        int purgePeriod;

        PurgeProperties() {
        }

        /* access modifiers changed from: package-private */
        public void load(Properties properties) {
            if (properties.containsKey(SchedulerPoolFactory.f62000a)) {
                this.purgeEnable = Boolean.parseBoolean(properties.getProperty(SchedulerPoolFactory.f62000a));
            } else {
                this.purgeEnable = true;
            }
            if (!this.purgeEnable || !properties.containsKey(SchedulerPoolFactory.f62001b)) {
                this.purgePeriod = 1;
                return;
            }
            try {
                this.purgePeriod = Integer.parseInt(properties.getProperty(SchedulerPoolFactory.f62001b));
            } catch (NumberFormatException unused) {
                this.purgePeriod = 1;
            }
        }
    }

    public static ScheduledExecutorService create(ThreadFactory threadFactory) {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        m45980a(PURGE_ENABLED, newScheduledThreadPool);
        return newScheduledThreadPool;
    }

    /* renamed from: a */
    static void m45980a(boolean z, ScheduledExecutorService scheduledExecutorService) {
        if (z && (scheduledExecutorService instanceof ScheduledThreadPoolExecutor)) {
            f62003d.put((ScheduledThreadPoolExecutor) scheduledExecutorService, scheduledExecutorService);
        }
    }

    /* renamed from: io.reactivex.internal.schedulers.SchedulerPoolFactory$ScheduledTask */
    static final class ScheduledTask implements Runnable {
        ScheduledTask() {
        }

        public void run() {
            Iterator it = new ArrayList(SchedulerPoolFactory.f62003d.keySet()).iterator();
            while (it.hasNext()) {
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) it.next();
                if (scheduledThreadPoolExecutor.isShutdown()) {
                    SchedulerPoolFactory.f62003d.remove(scheduledThreadPoolExecutor);
                } else {
                    scheduledThreadPoolExecutor.purge();
                }
            }
        }
    }
}
