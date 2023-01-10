package com.didichuxing.mas.sdk.quality.collect.lag;

import android.content.ComponentName;
import android.content.Context;
import android.os.Looper;
import android.util.Printer;
import com.didi.sdk.apm.SystemUtils;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class BlockCanary {

    /* renamed from: a */
    private static BlockCanary f50665a;

    /* renamed from: d */
    private static final Executor f50666d = m37748a("File-IO");

    /* renamed from: b */
    private BlockCanaryInternals f50667b;

    /* renamed from: c */
    private boolean f50668c = false;

    private BlockCanary() {
        BlockCanaryInternals.setContext(BlockCanaryContext.get());
        BlockCanaryInternals a = BlockCanaryInternals.m37753a();
        this.f50667b = a;
        a.mo124911a((C16599b) BlockCanaryContext.get());
        if (!BlockCanaryContext.get().displayNotification()) {
        }
    }

    public static BlockCanary install(Context context, BlockCanaryContext blockCanaryContext) {
        BlockCanaryContext.init(context, blockCanaryContext);
        return get();
    }

    public static BlockCanary get() {
        if (f50665a == null) {
            synchronized (BlockCanary.class) {
                if (f50665a == null) {
                    f50665a = new BlockCanary();
                }
            }
        }
        return f50665a;
    }

    public void start() {
        if (!this.f50668c) {
            this.f50668c = true;
            Looper.getMainLooper().setMessageLogging(this.f50667b.f50671a);
        }
    }

    public void stop() {
        if (this.f50668c) {
            this.f50668c = false;
            Looper.getMainLooper().setMessageLogging((Printer) null);
            this.f50667b.f50672b.mo124922b();
            this.f50667b.f50673c.mo124922b();
        }
    }

    public void recordStartTime() {
        SystemUtils.getDefaultSharedPreferences(BlockCanaryContext.get().provideContext()).edit().putLong("BlockCanary_StartTime", System.currentTimeMillis()).commit();
    }

    public boolean isMonitorDurationEnd() {
        long j = SystemUtils.getDefaultSharedPreferences(BlockCanaryContext.get().provideContext()).getLong("BlockCanary_StartTime", 0);
        return j != 0 && System.currentTimeMillis() - j > ((long) ((BlockCanaryContext.get().provideMonitorDuration() * 3600) * 1000));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m37751b(Context context, Class<?> cls, boolean z) {
        context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, cls), z ? 1 : 2, 1);
    }

    /* renamed from: a */
    private static void m37750a(Runnable runnable) {
        f50666d.execute(runnable);
    }

    /* renamed from: a */
    private static Executor m37748a(String str) {
        return Executors.newSingleThreadExecutor(new C16601d(str));
    }

    /* renamed from: c */
    private static void m37752c(Context context, final Class<?> cls, final boolean z) {
        final Context applicationContext = context.getApplicationContext();
        m37750a((Runnable) new Runnable() {
            public void run() {
                BlockCanary.m37751b(applicationContext, cls, z);
            }
        });
    }
}
