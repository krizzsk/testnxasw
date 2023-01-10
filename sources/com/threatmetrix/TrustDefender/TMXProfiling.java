package com.threatmetrix.TrustDefender;

import android.content.Context;
import com.threatmetrix.TrustDefender.TMXStrongAuth;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class TMXProfiling extends jjkjkj {
    private static final String b00640064d0064dd = yyyyqy.b0074t007400740074t(TMXProfiling.class);
    @Nullable
    private static volatile TMXProfiling bdd00640064dd = null;
    private int b0064006400640064dd;
    /* access modifiers changed from: private */
    public volatile boolean b0064d00640064dd = true;
    private Timer bd006400640064dd;

    private TMXProfiling() {
        super(new qqqyyq(), new kjjkjj(), new qqtqtt());
    }

    @Nonnull
    private static synchronized TMXProfiling bs00730073ss0073s() {
        synchronized (TMXProfiling.class) {
            TMXProfiling tMXProfiling = bdd00640064dd;
            if (tMXProfiling != null) {
                return tMXProfiling;
            }
            TMXProfiling tMXProfiling2 = new TMXProfiling();
            bdd00640064dd = tMXProfiling2;
            b00730073ss0073s = new yyqyqy();
            return tMXProfiling2;
        }
    }

    @Nonnull
    public static TMXProfiling getInstance() {
        TMXProfiling tMXProfiling = bdd00640064dd;
        return tMXProfiling != null ? tMXProfiling : bs00730073ss0073s();
    }

    public void b007300730073ss0073s() {
        this.b0064d00640064dd = false;
        String str = b00640064d0064dd;
        yyyyqy.bt0074007400740074t(str, "Screen is off, any future profiling will be blocked after " + this.b0064006400640064dd + " milliseconds.");
        Timer timer = this.bd006400640064dd;
        if (timer != null) {
            timer.cancel();
        }
        this.bd006400640064dd = new Timer();
        this.bd006400640064dd.schedule(new TimerTask() {
            public void run() {
                synchronized (this) {
                    if (!TMXProfiling.this.b0064d00640064dd) {
                        TMXProfiling.this.b007300730073ss0073 = false;
                    }
                }
            }
        }, (long) this.b0064006400640064dd);
    }

    public void b0073s0073ss0073s(@Nonnull TMXConfig tMXConfig) {
        this.b0064d00640064dd = true;
        this.b0064006400640064dd = bsss0073s00730073(tMXConfig.b0073ssss0073s(), TMXConfig.bo006F006F006Fo006F, "screenOffTimeout");
        Timer timer = this.bd006400640064dd;
        if (timer != null) {
            timer.cancel();
        }
        b0073ss0073s00730073(tMXConfig.b00730073s00730073ss(), 0, "LowPowerUpdateTime");
        b0073ss0073s00730073(tMXConfig.bsss00730073ss(), 0, "HighPowerUpdateTime");
        bsss0073s00730073(tMXConfig.bs0073s00730073ss(), 2, "location accuracy");
        b00730073ss0073s.b0067g0067ggg(tMXConfig.b00730073ss0073ss().bll006C006C006C006C);
    }

    public void b0073ss0073s0073s() {
        this.b00730073sss0073.bx007800780078x0078(this.bs00730073ss0073);
        b0073ss00730073s0073();
        this.b00730073sss0073.bxxx0078x0078();
        bdd00640064dd = null;
    }

    public void bss0073ss0073s(tqtqqt tqtqqt) {
        if (this.b0064006400640064dd > 0) {
            qyqqqq.b00680068h0068hh(this, tqtqqt);
        }
    }

    public void bsss0073s0073s() {
        synchronized (this) {
            this.b0064d00640064dd = true;
            this.b007300730073ss0073 = true;
            if (this.bd006400640064dd != null) {
                this.bd006400640064dd.cancel();
            }
            yyyyqy.bt0074007400740074t(b00640064d0064dd, "Screen is on profiling is unblocked.");
        }
    }

    public /* bridge */ /* synthetic */ void deregisterUser(@Nonnull String str, @Nullable TMXEndNotifier tMXEndNotifier) {
        super.deregisterUser(str, tMXEndNotifier);
    }

    public void init(Context context, String str) {
        init(new TMXConfig().setContext(context).setOrgId(str));
    }

    public /* bridge */ /* synthetic */ void init(@Nonnull TMXConfig tMXConfig) throws IllegalArgumentException, IllegalStateException {
        super.init(tMXConfig);
    }

    public /* bridge */ /* synthetic */ void pauseLocationServices(boolean z) {
        super.pauseLocationServices(z);
    }

    @Nullable
    public /* bridge */ /* synthetic */ String processStrongAuthMessage(@Nonnull TMXStrongAuth.StrongAuthConfiguration strongAuthConfiguration, @Nonnull TMXStrongAuth.StrongAuthCallback strongAuthCallback, @Nullable TMXEndNotifier tMXEndNotifier) {
        return super.processStrongAuthMessage(strongAuthConfiguration, strongAuthCallback, tMXEndNotifier);
    }

    @Nullable
    public /* bridge */ /* synthetic */ String processStrongAuthMessage(@Nonnull Object obj, @Nonnull TMXStrongAuth.StrongAuthCallback strongAuthCallback, @Nullable TMXEndNotifier tMXEndNotifier) {
        return super.processStrongAuthMessage(obj, strongAuthCallback, tMXEndNotifier);
    }

    public /* bridge */ /* synthetic */ TMXProfilingHandle profile(@Nonnull TMXEndNotifier tMXEndNotifier) {
        return super.profile(tMXEndNotifier);
    }

    public /* bridge */ /* synthetic */ TMXProfilingHandle profile(@Nonnull TMXProfilingOptions tMXProfilingOptions, @Nonnull TMXEndNotifier tMXEndNotifier) {
        return super.profile(tMXProfilingOptions, tMXEndNotifier);
    }

    public /* bridge */ /* synthetic */ TMXProfilingHandle profile(@Nonnull String str, @Nonnull TMXEndNotifier tMXEndNotifier) {
        return super.profile(str, tMXEndNotifier);
    }

    @Nullable
    public /* bridge */ /* synthetic */ String registerUser(@Nonnull String str, @Nullable String str2, @Nonnull String str3, @Nonnull TMXStrongAuth.StrongAuthCallback strongAuthCallback, @Nullable TMXEndNotifier tMXEndNotifier) {
        return super.registerUser(str, str2, str3, strongAuthCallback, tMXEndNotifier);
    }

    public /* bridge */ /* synthetic */ boolean scanPackages() {
        return super.scanPackages();
    }

    public /* bridge */ /* synthetic */ boolean scanPackages(int i, @Nonnull TimeUnit timeUnit, @Nullable TMXScanEndNotifier tMXScanEndNotifier) {
        return super.scanPackages(i, timeUnit, tMXScanEndNotifier);
    }

    public /* bridge */ /* synthetic */ boolean scanPackages(TMXScanEndNotifier tMXScanEndNotifier) {
        return super.scanPackages(tMXScanEndNotifier);
    }
}
