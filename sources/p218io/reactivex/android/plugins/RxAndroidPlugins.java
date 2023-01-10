package p218io.reactivex.android.plugins;

import java.util.concurrent.Callable;
import p218io.reactivex.Scheduler;
import p218io.reactivex.exceptions.Exceptions;
import p218io.reactivex.functions.Function;

/* renamed from: io.reactivex.android.plugins.RxAndroidPlugins */
public final class RxAndroidPlugins {

    /* renamed from: a */
    private static volatile Function<Callable<Scheduler>, Scheduler> f60794a;

    /* renamed from: b */
    private static volatile Function<Scheduler, Scheduler> f60795b;

    public static void setInitMainThreadSchedulerHandler(Function<Callable<Scheduler>, Scheduler> function) {
        f60794a = function;
    }

    public static Scheduler initMainThreadScheduler(Callable<Scheduler> callable) {
        if (callable != null) {
            Function<Callable<Scheduler>, Scheduler> function = f60794a;
            if (function == null) {
                return m45919a(callable);
            }
            return m45918a(function, callable);
        }
        throw new NullPointerException("scheduler == null");
    }

    public static void setMainThreadSchedulerHandler(Function<Scheduler, Scheduler> function) {
        f60795b = function;
    }

    public static Scheduler onMainThreadScheduler(Scheduler scheduler) {
        if (scheduler != null) {
            Function function = f60795b;
            if (function == null) {
                return scheduler;
            }
            return (Scheduler) m45920a(function, scheduler);
        }
        throw new NullPointerException("scheduler == null");
    }

    public static Function<Callable<Scheduler>, Scheduler> getInitMainThreadSchedulerHandler() {
        return f60794a;
    }

    public static Function<Scheduler, Scheduler> getOnMainThreadSchedulerHandler() {
        return f60795b;
    }

    public static void reset() {
        setInitMainThreadSchedulerHandler((Function<Callable<Scheduler>, Scheduler>) null);
        setMainThreadSchedulerHandler((Function<Scheduler, Scheduler>) null);
    }

    /* renamed from: a */
    static Scheduler m45919a(Callable<Scheduler> callable) {
        try {
            Scheduler call = callable.call();
            if (call != null) {
                return call;
            }
            throw new NullPointerException("Scheduler Callable returned null");
        } catch (Throwable th) {
            throw Exceptions.propagate(th);
        }
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [io.reactivex.functions.Function, io.reactivex.functions.Function<java.util.concurrent.Callable<io.reactivex.Scheduler>, io.reactivex.Scheduler>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static p218io.reactivex.Scheduler m45918a(p218io.reactivex.functions.Function<java.util.concurrent.Callable<p218io.reactivex.Scheduler>, p218io.reactivex.Scheduler> r0, java.util.concurrent.Callable<p218io.reactivex.Scheduler> r1) {
        /*
            java.lang.Object r0 = m45920a(r0, r1)
            io.reactivex.Scheduler r0 = (p218io.reactivex.Scheduler) r0
            if (r0 == 0) goto L_0x0009
            return r0
        L_0x0009:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Scheduler Callable returned null"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p218io.reactivex.android.plugins.RxAndroidPlugins.m45918a(io.reactivex.functions.Function, java.util.concurrent.Callable):io.reactivex.Scheduler");
    }

    /* renamed from: a */
    static <T, R> R m45920a(Function<T, R> function, T t) {
        try {
            return function.apply(t);
        } catch (Throwable th) {
            throw Exceptions.propagate(th);
        }
    }

    private RxAndroidPlugins() {
        throw new AssertionError("No instances.");
    }
}
