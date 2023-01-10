package com.didi.payment.base.utils;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J$\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00122\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0014H\u0007R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R#\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\n8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\b\u001a\u0004\b\f\u0010\r¨\u0006\u001b"}, mo148868d2 = {"Lcom/didi/payment/base/utils/WalletExecutors;", "", "()V", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "handler$delegate", "Lkotlin/Lazy;", "singleScheduleExecutor", "Ljava/util/concurrent/ScheduledExecutorService;", "kotlin.jvm.PlatformType", "getSingleScheduleExecutor", "()Ljava/util/concurrent/ScheduledExecutorService;", "singleScheduleExecutor$delegate", "postToMain", "", "delayMillis", "", "runnable", "Ljava/lang/Runnable;", "runOnMain", "scheduleOnce", "delay", "unit", "Ljava/util/concurrent/TimeUnit;", "command", "base_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: WalletExecutors.kt */
public final class WalletExecutors {
    public static final WalletExecutors INSTANCE = new WalletExecutors();

    /* renamed from: a */
    private static final Lazy f32486a = LazyKt.lazy(WalletExecutors$handler$2.INSTANCE);

    /* renamed from: b */
    private static final Lazy f32487b = LazyKt.lazy(WalletExecutors$singleScheduleExecutor$2.INSTANCE);

    private WalletExecutors() {
    }

    /* renamed from: a */
    private final Handler m24629a() {
        return (Handler) f32486a.getValue();
    }

    /* renamed from: b */
    private final ScheduledExecutorService m24630b() {
        return (ScheduledExecutorService) f32487b.getValue();
    }

    @JvmStatic
    public static final void runOnMain(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        if (Intrinsics.areEqual((Object) Thread.currentThread(), (Object) Looper.getMainLooper().getThread())) {
            runnable.run();
        } else {
            INSTANCE.m24629a().post(runnable);
        }
    }

    public static /* synthetic */ void postToMain$default(long j, Runnable runnable, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 0;
        }
        postToMain(j, runnable);
    }

    @JvmStatic
    public static final void postToMain(long j, Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        INSTANCE.m24629a().postDelayed(runnable, j);
    }

    public static /* synthetic */ void scheduleOnce$default(long j, TimeUnit timeUnit, Runnable runnable, int i, Object obj) {
        if ((i & 2) != 0) {
            timeUnit = TimeUnit.MILLISECONDS;
        }
        scheduleOnce(j, timeUnit, runnable);
    }

    @JvmStatic
    public static final void scheduleOnce(long j, TimeUnit timeUnit, Runnable runnable) {
        Intrinsics.checkNotNullParameter(timeUnit, "unit");
        if (runnable != null) {
            INSTANCE.m24630b().schedule(runnable, j, timeUnit);
        }
    }
}
