package com.didichuxing.apollo.sdk.log;

import com.didi.global.fintech.cashier.core.GlobalCashierCoreModule;
import com.didichuxing.apollo.sdk.dataprovider.DCache;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class LogCoolDownWrapper implements ILogDelegate {
    public static final String CACHE_KEY_LOG_COOL_DOWN = "cache_key_log_cool_down";
    public static int COOL_DOWN_INTERVAL = 3600000;
    public static int FLUSH_INTERVAL = 60000;

    /* renamed from: a */
    private ILogDelegate f48279a;

    /* renamed from: b */
    private final Random f48280b = new Random();

    /* renamed from: c */
    private ScheduledFuture<?> f48281c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public HashMap<String, String> f48282d;

    /* renamed from: e */
    private final ScheduledExecutorService f48283e = Executors.newScheduledThreadPool(1);

    /* renamed from: f */
    private volatile boolean f48284f = false;

    public LogCoolDownWrapper(ILogDelegate iLogDelegate) {
        LogUtils.m36179d(GlobalCashierCoreModule.APOLLO, "cool down logger init");
        this.f48279a = iLogDelegate;
    }

    public void saveLog(ApolloLog apolloLog) {
        LogUtils.m36179d(GlobalCashierCoreModule.APOLLO, "use cool down logger");
        HashMap<String, String> hashMap = this.f48282d;
        if (hashMap == null) {
            try {
                this.f48282d = (HashMap) DCache.getObject(CACHE_KEY_LOG_COOL_DOWN, hashMap.getClass());
            } catch (Exception unused) {
            }
            if (this.f48282d == null) {
                this.f48282d = new HashMap<>();
            }
        }
        if (!this.f48284f) {
            m36176a();
        }
        Long l = null;
        try {
            l = Long.valueOf(Long.parseLong(this.f48282d.get(apolloLog.getToggleName())));
        } catch (Exception unused2) {
        }
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        if (l == null || valueOf.longValue() - l.longValue() > ((long) COOL_DOWN_INTERVAL)) {
            this.f48282d.put(apolloLog.getToggleName(), valueOf.toString());
            this.f48279a.saveLog(apolloLog);
        }
    }

    public void saveErrorLog(ApolloErrorLog apolloErrorLog) {
        ILogDelegate iLogDelegate;
        if (this.f48280b.nextInt(100) == 0 && (iLogDelegate = this.f48279a) != null) {
            iLogDelegate.saveErrorLog(apolloErrorLog);
        }
    }

    public void reset() {
        this.f48282d = new HashMap<>();
    }

    /* renamed from: a */
    private void m36176a() {
        if (!this.f48284f) {
            this.f48284f = true;
            C158701 r2 = new Runnable() {
                public void run() {
                    DCache.putObject(LogCoolDownWrapper.CACHE_KEY_LOG_COOL_DOWN, LogCoolDownWrapper.this.f48282d);
                }
            };
            ScheduledExecutorService scheduledExecutorService = this.f48283e;
            int i = FLUSH_INTERVAL;
            this.f48281c = scheduledExecutorService.scheduleAtFixedRate(r2, (long) i, (long) i, TimeUnit.MILLISECONDS);
        }
    }

    /* renamed from: b */
    private void m36177b() {
        this.f48281c.cancel(true);
    }
}
