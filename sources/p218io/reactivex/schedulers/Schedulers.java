package p218io.reactivex.schedulers;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import p218io.reactivex.Scheduler;
import p218io.reactivex.internal.schedulers.ComputationScheduler;
import p218io.reactivex.internal.schedulers.ExecutorScheduler;
import p218io.reactivex.internal.schedulers.IoScheduler;
import p218io.reactivex.internal.schedulers.NewThreadScheduler;
import p218io.reactivex.internal.schedulers.SchedulerPoolFactory;
import p218io.reactivex.internal.schedulers.SingleScheduler;
import p218io.reactivex.internal.schedulers.TrampolineScheduler;
import p218io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.schedulers.Schedulers */
public final class Schedulers {

    /* renamed from: a */
    static final Scheduler f62174a = RxJavaPlugins.initSingleScheduler(new SingleTask());

    /* renamed from: b */
    static final Scheduler f62175b = RxJavaPlugins.initComputationScheduler(new ComputationTask());

    /* renamed from: c */
    static final Scheduler f62176c = RxJavaPlugins.initIoScheduler(new IOTask());

    /* renamed from: d */
    static final Scheduler f62177d = TrampolineScheduler.instance();

    /* renamed from: e */
    static final Scheduler f62178e = RxJavaPlugins.initNewThreadScheduler(new NewThreadTask());

    /* renamed from: io.reactivex.schedulers.Schedulers$SingleHolder */
    static final class SingleHolder {
        static final Scheduler DEFAULT = new SingleScheduler();

        SingleHolder() {
        }
    }

    /* renamed from: io.reactivex.schedulers.Schedulers$ComputationHolder */
    static final class ComputationHolder {
        static final Scheduler DEFAULT = new ComputationScheduler();

        ComputationHolder() {
        }
    }

    /* renamed from: io.reactivex.schedulers.Schedulers$IoHolder */
    static final class IoHolder {
        static final Scheduler DEFAULT = new IoScheduler();

        IoHolder() {
        }
    }

    /* renamed from: io.reactivex.schedulers.Schedulers$NewThreadHolder */
    static final class NewThreadHolder {
        static final Scheduler DEFAULT = new NewThreadScheduler();

        NewThreadHolder() {
        }
    }

    private Schedulers() {
        throw new IllegalStateException("No instances!");
    }

    public static Scheduler computation() {
        return RxJavaPlugins.onComputationScheduler(f62175b);
    }

    /* renamed from: io */
    public static Scheduler m46030io() {
        return RxJavaPlugins.onIoScheduler(f62176c);
    }

    public static Scheduler trampoline() {
        return f62177d;
    }

    public static Scheduler newThread() {
        return RxJavaPlugins.onNewThreadScheduler(f62178e);
    }

    public static Scheduler single() {
        return RxJavaPlugins.onSingleScheduler(f62174a);
    }

    public static Scheduler from(Executor executor) {
        return new ExecutorScheduler(executor);
    }

    public static void shutdown() {
        computation().shutdown();
        m46030io().shutdown();
        newThread().shutdown();
        single().shutdown();
        trampoline().shutdown();
        SchedulerPoolFactory.shutdown();
    }

    public static void start() {
        computation().start();
        m46030io().start();
        newThread().start();
        single().start();
        trampoline().start();
        SchedulerPoolFactory.start();
    }

    /* renamed from: io.reactivex.schedulers.Schedulers$IOTask */
    static final class IOTask implements Callable<Scheduler> {
        IOTask() {
        }

        public Scheduler call() throws Exception {
            return IoHolder.DEFAULT;
        }
    }

    /* renamed from: io.reactivex.schedulers.Schedulers$NewThreadTask */
    static final class NewThreadTask implements Callable<Scheduler> {
        NewThreadTask() {
        }

        public Scheduler call() throws Exception {
            return NewThreadHolder.DEFAULT;
        }
    }

    /* renamed from: io.reactivex.schedulers.Schedulers$SingleTask */
    static final class SingleTask implements Callable<Scheduler> {
        SingleTask() {
        }

        public Scheduler call() throws Exception {
            return SingleHolder.DEFAULT;
        }
    }

    /* renamed from: io.reactivex.schedulers.Schedulers$ComputationTask */
    static final class ComputationTask implements Callable<Scheduler> {
        ComputationTask() {
        }

        public Scheduler call() throws Exception {
            return ComputationHolder.DEFAULT;
        }
    }
}
