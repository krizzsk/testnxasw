package p218io.reactivex.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import p218io.reactivex.Scheduler;

/* renamed from: io.reactivex.internal.schedulers.NewThreadScheduler */
public final class NewThreadScheduler extends Scheduler {

    /* renamed from: c */
    private static final String f61996c = "RxNewThreadScheduler";

    /* renamed from: d */
    private static final RxThreadFactory f61997d = new RxThreadFactory(f61996c, Math.max(1, Math.min(10, Integer.getInteger(f61998e, 5).intValue())));

    /* renamed from: e */
    private static final String f61998e = "rx2.newthread-priority";

    /* renamed from: b */
    final ThreadFactory f61999b;

    public NewThreadScheduler() {
        this(f61997d);
    }

    public NewThreadScheduler(ThreadFactory threadFactory) {
        this.f61999b = threadFactory;
    }

    public Scheduler.Worker createWorker() {
        return new NewThreadWorker(this.f61999b);
    }
}
