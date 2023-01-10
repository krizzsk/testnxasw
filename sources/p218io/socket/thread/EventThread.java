package p218io.socket.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.logging.Logger;

/* renamed from: io.socket.thread.EventThread */
public class EventThread extends Thread {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final Logger f55287a = Logger.getLogger(EventThread.class.getName());

    /* renamed from: b */
    private static final ThreadFactory f55288b = new ThreadFactory() {
        public Thread newThread(Runnable runnable) {
            EventThread unused = EventThread.f55289c = new EventThread(runnable);
            EventThread.f55289c.setName("EventThread");
            EventThread.f55289c.setDaemon(Thread.currentThread().isDaemon());
            return EventThread.f55289c;
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static EventThread f55289c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static ExecutorService f55290d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static int f55291e = 0;

    /* renamed from: c */
    static /* synthetic */ int m41095c() {
        int i = f55291e;
        f55291e = i - 1;
        return i;
    }

    private EventThread(Runnable runnable) {
        super(runnable);
    }

    public static boolean isCurrent() {
        return currentThread() == f55289c;
    }

    public static void exec(Runnable runnable) {
        if (isCurrent()) {
            runnable.run();
        } else {
            nextTick(runnable);
        }
    }

    public static void nextTick(final Runnable runnable) {
        ExecutorService executorService;
        synchronized (EventThread.class) {
            f55291e++;
            if (f55290d == null) {
                f55290d = Executors.newSingleThreadExecutor(f55288b);
            }
            executorService = f55290d;
        }
        executorService.execute(new Runnable() {
            public void run() {
                try {
                    runnable.run();
                    synchronized (EventThread.class) {
                        EventThread.m41095c();
                        if (EventThread.f55291e == 0) {
                            EventThread.f55290d.shutdown();
                            ExecutorService unused = EventThread.f55290d = null;
                            EventThread unused2 = EventThread.f55289c = null;
                        }
                    }
                } catch (Throwable th) {
                    synchronized (EventThread.class) {
                        EventThread.m41095c();
                        if (EventThread.f55291e == 0) {
                            EventThread.f55290d.shutdown();
                            ExecutorService unused3 = EventThread.f55290d = null;
                            EventThread unused4 = EventThread.f55289c = null;
                        }
                        throw th;
                    }
                }
            }
        });
    }
}
