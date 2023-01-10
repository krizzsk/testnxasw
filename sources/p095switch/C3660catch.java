package p095switch;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: switch.catch */
/* compiled from: ThreadUtils */
public class C3660catch {

    /* renamed from: switch.catch$do */
    /* compiled from: ThreadUtils */
    static /* synthetic */ class C3661do {

        /* renamed from: do */
        static final /* synthetic */ int[] f8771do;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                switch.catch$new[] r0 = p095switch.C3660catch.C3664new.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8771do = r0
                switch.catch$new r1 = p095switch.C3660catch.C3664new.RUN_TASK_ONLY_IF_IDLE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8771do     // Catch:{ NoSuchFieldError -> 0x001d }
                switch.catch$new r1 = p095switch.C3660catch.C3664new.QUEUE_MAX_ONE_TASK_REPLACING_IF_BUSY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f8771do     // Catch:{ NoSuchFieldError -> 0x0028 }
                switch.catch$new r1 = p095switch.C3660catch.C3664new.QUEUE_TASKS_FIFO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p095switch.C3660catch.C3661do.<clinit>():void");
        }
    }

    /* renamed from: switch.catch$for */
    /* compiled from: ThreadUtils */
    public enum C3662for {
        LOW(1),
        MEDIUM(5),
        HIGH(10);
        

        /* renamed from: do */
        private int f8773do;

        private C3662for(int i) {
            this.f8773do = i;
        }

        /* renamed from: do */
        public int mo43493do() {
            return this.f8773do;
        }
    }

    /* renamed from: switch.catch$if */
    /* compiled from: ThreadUtils */
    private static final class C3663if implements ThreadFactory {

        /* renamed from: do */
        private String f8774do;

        /* renamed from: if */
        private int f8775if;

        C3663if(String str, int i) {
            this.f8774do = str;
            this.f8775if = i;
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.f8774do);
            thread.setPriority(this.f8775if);
            return thread;
        }
    }

    /* renamed from: switch.catch$new */
    /* compiled from: ThreadUtils */
    public enum C3664new {
        RUN_TASK_ONLY_IF_IDLE,
        QUEUE_MAX_ONE_TASK_REPLACING_IF_BUSY,
        QUEUE_TASKS_FIFO
    }

    /* renamed from: do */
    public static ExecutorService m7405do(String str, C3662for forR, C3664new newR) {
        int i = C3661do.f8771do[newR.ordinal()];
        if (i == 1) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new SynchronousQueue(), new ThreadPoolExecutor.DiscardPolicy());
            threadPoolExecutor.setThreadFactory(new C3663if(str, forR.mo43493do()));
            return threadPoolExecutor;
        } else if (i != 2) {
            return Executors.newSingleThreadExecutor(new C3663if(str, forR.mo43493do()));
        } else {
            ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(1), new ThreadPoolExecutor.DiscardOldestPolicy());
            threadPoolExecutor2.setThreadFactory(new C3663if(str, forR.mo43493do()));
            return threadPoolExecutor2;
        }
    }

    /* renamed from: do */
    public static Thread m7404do(String str, C3662for forR, Runnable runnable) {
        return new C3663if(str, forR.mo43493do()).newThread(runnable);
    }
}
