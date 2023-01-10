package com.didi.raven.manger;

import com.didi.raven.RavenDataManger;
import com.didi.raven.RavenSdk;
import com.didi.raven.utils.RavenLogUtils;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class RavenPoolManger {

    /* renamed from: a */
    private static final String f35864a = "RavenPoolManger";

    /* renamed from: b */
    private final AtomicBoolean f35865b = new AtomicBoolean(false);

    /* renamed from: c */
    private final Runnable f35866c = new Runnable() {
        public final void run() {
            RavenPoolManger.this.m27039c();
        }
    };

    private static class SingleTon {
        /* access modifiers changed from: private */
        public static final RavenPoolManger INSTANCE = new RavenPoolManger();

        private SingleTon() {
        }
    }

    public static RavenPoolManger getInstance() {
        return SingleTon.INSTANCE;
    }

    /* renamed from: a */
    private ScheduledExecutorService m27037a() {
        return RavenThreadExecutorManger.getInstance().getService();
    }

    public void start() {
        if (!this.f35865b.get()) {
            RavenLogUtils.m27059i(f35864a, "start: service");
            m27037a().scheduleAtFixedRate(this.f35866c, 0, RavenDataManger.getInstance().getPoolConfig().getDelay(), TimeUnit.MILLISECONDS);
            this.f35865b.set(true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m27039c() {
        RavenSdk.getInstance().clearPool();
    }

    public void stop() {
        m27037a().shutdown();
    }
}
