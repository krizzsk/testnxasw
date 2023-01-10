package com.didiglobal.pay.paysecure.tmx;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didiglobal.pay.paysecure.net.PaySecureRequest;
import com.didiglobal.pay.paysecure.util.PaySecureApollo;
import com.didiglobal.pay.paysecure.util.PaySecureLog;
import com.threatmetrix.TrustDefender.TMXConfig;
import com.threatmetrix.TrustDefender.TMXEndNotifier;
import com.threatmetrix.TrustDefender.TMXProfiling;
import com.threatmetrix.TrustDefender.TMXProfilingConnections.C21569TMXProfilingConnections;
import com.threatmetrix.TrustDefender.TMXProfilingHandle;
import com.threatmetrix.TrustDefender.TMXProfilingOptions;
import com.threatmetrix.TrustDefender.TMXStatusCode;
import java.sql.Timestamp;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001)B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0004H\u0002J\u0016\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u0004J\u0018\u0010\"\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u0004H\u0002J\u0010\u0010#\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020&H\u0002J\u000e\u0010'\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020&J\u0006\u0010(\u001a\u00020\u001bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R#\u0010\u0013\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00148BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, mo148868d2 = {"Lcom/didiglobal/pay/paysecure/tmx/TMXProfilingMgr;", "", "()V", "FP_SERVER", "", "FROM_HOME", "FROM_LOGIN", "FROM_STARTUP", "MILLIS_PER_DAY", "", "ORG_ID", "TAG", "apiSessionId", "getApiSessionId", "()Ljava/lang/String;", "setApiSessionId", "(Ljava/lang/String;)V", "lastProfilingCompleted", "Ljava/sql/Timestamp;", "singleScheduleExecutor", "Ljava/util/concurrent/ScheduledExecutorService;", "kotlin.jvm.PlatformType", "getSingleScheduleExecutor", "()Ljava/util/concurrent/ScheduledExecutorService;", "singleScheduleExecutor$delegate", "Lkotlin/Lazy;", "tmxInitialized", "", "doProfile", "", "srcFrom", "doWork", "applicationContext", "Landroid/content/Context;", "doWorkImpl", "initTMX", "profileWhenLogin", "context", "Landroid/app/Application;", "register", "wasProfilingSuccessful", "CompletionNotifier", "paysecure_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: TMXProfilingMgr.kt */
public final class TMXProfilingMgr {
    public static final TMXProfilingMgr INSTANCE = new TMXProfilingMgr();

    /* renamed from: a */
    private static final String f52926a = "TMXProfilingMgr";

    /* renamed from: b */
    private static final String f52927b = "859g1sil";

    /* renamed from: c */
    private static final String f52928c = "cnt.didiglobal.com";

    /* renamed from: d */
    private static final long f52929d = 86400000;

    /* renamed from: e */
    private static String f52930e = null;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static Timestamp f52931f = null;

    /* renamed from: g */
    private static boolean f52932g = false;

    /* renamed from: h */
    private static final String f52933h = "FROM_STARTUP";

    /* renamed from: i */
    private static final String f52934i = "FROM_LOGIN";

    /* renamed from: j */
    private static final String f52935j = "FROM_HOME";

    /* renamed from: k */
    private static final Lazy f52936k = LazyKt.lazy(TMXProfilingMgr$singleScheduleExecutor$2.INSTANCE);

    /* renamed from: a */
    private final ScheduledExecutorService m39667a() {
        return (ScheduledExecutorService) f52936k.getValue();
    }

    private TMXProfilingMgr() {
    }

    public final String getApiSessionId() {
        return f52930e;
    }

    public final void setApiSessionId(String str) {
        f52930e = str;
    }

    public final void register(Application application) {
        Intrinsics.checkParameterIsNotNull(application, "context");
        application.registerActivityLifecycleCallbacks(new TMXProfilingMgr$register$1());
        new TMXProfilingMgr$register$timer$1(application, 10000, 1000).start();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m39668a(Application application) {
        doWork(application, f52933h);
        OneLoginFacade.getFunction().addLoginListener(new TMXProfilingMgr$profileWhenLogin$1(application));
    }

    public final void doWork(Context context, String str) {
        Intrinsics.checkParameterIsNotNull(context, "applicationContext");
        Intrinsics.checkParameterIsNotNull(str, "srcFrom");
        if (Build.VERSION.SDK_INT >= 23) {
            if (!PaySecureApollo.INSTANCE.isOpenTMX()) {
                PaySecureLog.INSTANCE.mo129705i(f52926a, "doWork isOpenTMX = false");
            } else {
                m39667a().execute(new TMXProfilingMgr$doWork$1(context, str));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m39670a(Context context, String str) {
        if (!f52932g) {
            m39669a(context);
        }
        PaySecureLog paySecureLog = PaySecureLog.INSTANCE;
        StringBuilder sb = new StringBuilder();
        sb.append("Started doProfile srcFrom = ");
        sb.append(str);
        sb.append(" threadName = ");
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
        sb.append(currentThread.getName());
        paySecureLog.mo129705i(f52926a, sb.toString());
        m39671a(str);
    }

    public final boolean wasProfilingSuccessful() {
        long currentTimeMillis = System.currentTimeMillis() - 86400000;
        CharSequence charSequence = f52930e;
        if (charSequence == null || charSequence.length() == 0) {
            PaySecureLog.INSTANCE.mo129705i(f52926a, "session_id is null");
            return false;
        }
        Timestamp timestamp = f52931f;
        if (timestamp == null) {
            PaySecureLog.INSTANCE.mo129705i(f52926a, "session_id is not null but lastProfilingCompleted is not null");
            return false;
        }
        if (timestamp == null) {
            Intrinsics.throwNpe();
        }
        if (timestamp.getTime() < currentTimeMillis) {
            PaySecureLog.INSTANCE.mo129705i(f52926a, "No successful profiling done within last 24h.");
            return false;
        }
        PaySecureLog paySecureLog = PaySecureLog.INSTANCE;
        paySecureLog.mo129705i(f52926a, "Profiling was completed. session_id: " + f52930e);
        return true;
    }

    /* renamed from: a */
    private final void m39669a(Context context) {
        String tMXHost = PaySecureApollo.INSTANCE.getTMXHost();
        CharSequence charSequence = tMXHost;
        if (charSequence == null || charSequence.length() == 0) {
            tMXHost = f52928c;
        }
        C21569TMXProfilingConnections retryTimes = new C21569TMXProfilingConnections().setConnectionTimeout(10, TimeUnit.SECONDS).setRetryTimes(3);
        Intrinsics.checkExpressionValueIsNotNull(retryTimes, "TMXProfilingConnections(…        .setRetryTimes(3)");
        TMXConfig disableOption = new TMXConfig().setOrgId(f52927b).setFPServer(tMXHost).setContext(context).setProfilingConnections(retryTimes).setRegisterForLocationServices(true).setProfileTimeout(20, TimeUnit.SECONDS).setScreenOffTimeout(180, TimeUnit.SECONDS).disableOption(32768);
        Intrinsics.checkExpressionValueIsNotNull(disableOption, "TMXConfig() // For more …   .disableOption(0x8000)");
        TMXProfiling.getInstance().init(disableOption);
        f52932g = true;
        PaySecureLog.INSTANCE.mo129705i(f52926a, " TMX SDK Initialized");
    }

    /* renamed from: a */
    private final void m39671a(String str) {
        if (f52932g) {
            TMXProfilingHandle profile = TMXProfiling.getInstance().profile(new TMXProfilingOptions(), (TMXEndNotifier) new CompletionNotifier(str));
            String str2 = f52930e;
            if (str2 != null) {
                if (str2 == null) {
                    Intrinsics.throwNpe();
                }
                if (!(str2.length() == 0)) {
                    return;
                }
            }
            Intrinsics.checkExpressionValueIsNotNull(profile, "profilingHandle");
            f52930e = profile.getSessionID();
            return;
        }
        PaySecureLog.INSTANCE.mo129705i(f52926a, " TMX SDK not initialized yet. Please call initTMX method first");
    }

    @Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, mo148868d2 = {"Lcom/didiglobal/pay/paysecure/tmx/TMXProfilingMgr$CompletionNotifier;", "Lcom/threatmetrix/TrustDefender/TMXEndNotifier;", "srcFrom", "", "(Ljava/lang/String;)V", "getSrcFrom", "()Ljava/lang/String;", "complete", "", "result", "Lcom/threatmetrix/TrustDefender/TMXProfilingHandle$Result;", "paysecure_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
    /* compiled from: TMXProfilingMgr.kt */
    private static final class CompletionNotifier implements TMXEndNotifier {
        private final String srcFrom;

        public CompletionNotifier(String str) {
            Intrinsics.checkParameterIsNotNull(str, "srcFrom");
            this.srcFrom = str;
        }

        public final String getSrcFrom() {
            return this.srcFrom;
        }

        public void complete(TMXProfilingHandle.Result result) {
            Intrinsics.checkParameterIsNotNull(result, "result");
            PaySecureLog paySecureLog = PaySecureLog.INSTANCE;
            StringBuilder sb = new StringBuilder();
            sb.append(" Profile completed with: ");
            sb.append(result.getStatus().toString());
            sb.append(" - ");
            TMXStatusCode status = result.getStatus();
            Intrinsics.checkExpressionValueIsNotNull(status, "result.status");
            sb.append(status.getDesc());
            sb.append(" session_id: ");
            sb.append(result.getSessionID());
            paySecureLog.mo129705i(TMXProfilingMgr.f52926a, sb.toString());
            if (result.getStatus() == TMXStatusCode.TMX_OK) {
                TMXProfilingMgr.INSTANCE.setApiSessionId(result.getSessionID());
                TMXProfilingMgr.f52931f = new Timestamp(System.currentTimeMillis());
                if (!Intrinsics.areEqual((Object) TMXProfilingMgr.f52933h, (Object) this.srcFrom)) {
                    PaySecureRequest.INSTANCE.preloadVendor(TMXProfilingMgr.INSTANCE.getApiSessionId(), "success");
                } else {
                    PaySecureLog.INSTANCE.mo129705i(TMXProfilingMgr.f52926a, "ignore preload because FROM_STARTUP");
                }
            } else {
                PaySecureRequest paySecureRequest = PaySecureRequest.INSTANCE;
                TMXStatusCode status2 = result.getStatus();
                Intrinsics.checkExpressionValueIsNotNull(status2, "result.status");
                String desc = status2.getDesc();
                Intrinsics.checkExpressionValueIsNotNull(desc, "result.status.desc");
                paySecureRequest.preloadVendor("", desc);
            }
        }
    }
}
