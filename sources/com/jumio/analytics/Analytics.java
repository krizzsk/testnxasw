package com.jumio.analytics;

import com.jumio.commons.log.Log;
import com.jumio.commons.log.LogUtils;
import com.jumio.core.api.BackendManager;
import com.jumio.core.api.calls.AnalyticsCall;
import com.jumio.core.models.ApiCallDataModel;
import com.jumio.core.network.ApiBinding;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 !2\u00020\u0001:\u0001!B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\bJ\u0010\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\fJ\u001e\u0010\u0013\u001a\u00020\b2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u001e\u0010\u0016\u001a\u00020\b2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016R(\u0010\u001c\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00190\u00180\u00178V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\""}, mo148868d2 = {"Lcom/jumio/analytics/Analytics;", "Lcom/jumio/core/network/ApiBinding;", "Ljava/util/Date;", "serverTime", "", "time", "", "quota", "", "start", "stop", "shutdown", "", "canceled", "reporting", "Lcom/jumio/core/models/ApiCallDataModel;", "apiCallDataModel", "", "result", "onResult", "", "error", "onError", "", "Ljava/lang/Class;", "Lcom/jumio/core/network/ApiCall;", "getBindingClasses", "()[Ljava/lang/Class;", "bindingClasses", "Lcom/jumio/core/api/BackendManager;", "backendManager", "<init>", "(Lcom/jumio/core/api/BackendManager;)V", "Companion", "jumio-core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1})
/* compiled from: Analytics.kt */
public final class Analytics implements ApiBinding {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String LOGTAG = "Analytics";

    /* renamed from: e */
    public static Analytics f57356e;

    /* renamed from: f */
    public static final Object f57357f = new Object();

    /* renamed from: g */
    public static final ArrayList<AnalyticsEvent> f57358g = new ArrayList<>();

    /* renamed from: h */
    public static final ArrayList<AnalyticsEvent> f57359h = new ArrayList<>();

    /* renamed from: i */
    public static UUID f57360i = UUID.randomUUID();

    /* renamed from: j */
    public static int f57361j = 10;

    /* renamed from: k */
    public static boolean f57362k;

    /* renamed from: l */
    public static boolean f57363l = true;

    /* renamed from: a */
    public BackendManager f57364a;

    /* renamed from: b */
    public final ScheduledExecutorService f57365b = Executors.newScheduledThreadPool(1);

    /* renamed from: c */
    public ScheduledFuture<?> f57366c;

    /* renamed from: d */
    public long f57367d;

    @Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b$\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0006\u0010\t\u001a\u00020\u0002R\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u00020\u00018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u0015R\u001e\u0010!\u001a\n  *\u0004\u0018\u00010\u001f0\u001f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010#\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010\f¨\u0006%"}, mo148868d2 = {"Lcom/jumio/analytics/Analytics$Companion;", "", "", "configure$jumio_core_release", "()V", "configure", "Lcom/jumio/analytics/AnalyticsEvent;", "event", "add", "flush", "", "isEnabled", "Z", "()Z", "setEnabled", "(Z)V", "", "LOGTAG", "Ljava/lang/String;", "Ljava/util/ArrayList;", "events", "Ljava/util/ArrayList;", "Lcom/jumio/analytics/Analytics;", "instance", "Lcom/jumio/analytics/Analytics;", "lock", "Ljava/lang/Object;", "", "quota", "I", "reporting", "Ljava/util/UUID;", "kotlin.jvm.PlatformType", "sessionId", "Ljava/util/UUID;", "started", "<init>", "jumio-core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1})
    /* compiled from: Analytics.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void add(AnalyticsEvent analyticsEvent) {
            Analytics access$getInstance$cp;
            Intrinsics.checkNotNullParameter(analyticsEvent, "event");
            analyticsEvent.setSessionId(Analytics.f57360i);
            int eventType = analyticsEvent.getEventType();
            if (eventType == 306 || eventType == 307 || eventType == 311 || eventType == 313 || eventType == 316) {
                Analytics.f57359h.add(analyticsEvent);
            } else if (isEnabled()) {
                LogUtils.logAnalytics(analyticsEvent);
                synchronized (Analytics.f57357f) {
                    Analytics.f57358g.add(analyticsEvent);
                }
                if (!(Analytics.f57361j == 0 || Analytics.f57358g.size() < Analytics.f57361j || (access$getInstance$cp = Analytics.f57356e) == null)) {
                    Analytics.m43610a(access$getInstance$cp, false, 1, (Object) null);
                }
                if (analyticsEvent.getEventType() == 302 && !Intrinsics.areEqual((Object) analyticsEvent.getPayload().mo171748b(), (Object) C20921a.f57375c.toString())) {
                    Log.m43660v(Analytics.LOGTAG, "-- event was SDKLIFECYCLE -> flush() events");
                    Analytics access$getInstance$cp2 = Analytics.f57356e;
                    if (access$getInstance$cp2 != null) {
                        Analytics.m43610a(access$getInstance$cp2, false, 1, (Object) null);
                    }
                }
            }
        }

        public final void configure$jumio_core_release() {
            Analytics.f57362k = false;
            setEnabled(true);
            Analytics.f57360i = UUID.randomUUID();
            Analytics.f57358g.clear();
            Analytics.f57359h.clear();
        }

        public final void flush() {
            Analytics access$getInstance$cp = Analytics.f57356e;
            if (access$getInstance$cp != null) {
                Analytics.m43610a(access$getInstance$cp, false, 1, (Object) null);
            }
        }

        public final boolean isEnabled() {
            return Analytics.f57363l;
        }

        public final void setEnabled(boolean z) {
            Analytics.f57363l = z;
        }
    }

    public Analytics(BackendManager backendManager) {
        Intrinsics.checkNotNullParameter(backendManager, "backendManager");
        this.f57364a = backendManager;
        backendManager.addBinding(this);
    }

    /* renamed from: a */
    public static final void m43609a(Analytics analytics) {
        Intrinsics.checkNotNullParameter(analytics, "this$0");
        m43610a(analytics, false, 1, (Object) null);
    }

    @JvmStatic
    public static final void add(AnalyticsEvent analyticsEvent) {
        Companion.add(analyticsEvent);
    }

    public static /* synthetic */ void reporting$default(Analytics analytics, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        analytics.reporting(z);
    }

    public static /* synthetic */ void start$default(Analytics analytics, Date date, long j, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j = 0;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        analytics.start(date, j, i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.lang.Class<? extends com.jumio.core.network.ApiCall<?>>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Class<? extends com.jumio.core.network.ApiCall<?>>[] getBindingClasses() {
        /*
            r3 = this;
            r0 = 1
            java.lang.Class[] r0 = new java.lang.Class[r0]
            r1 = 0
            java.lang.Class<com.jumio.core.api.calls.AnalyticsCall> r2 = com.jumio.core.api.calls.AnalyticsCall.class
            r0[r1] = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.analytics.Analytics.getBindingClasses():java.lang.Class[]");
    }

    public void onError(ApiCallDataModel<?> apiCallDataModel, Throwable th) {
        Intrinsics.checkNotNullParameter(apiCallDataModel, "apiCallDataModel");
        if (Intrinsics.areEqual((Object) apiCallDataModel.getCall(), (Object) AnalyticsCall.class)) {
            synchronized (f57357f) {
                ArrayList arrayList = (ArrayList) apiCallDataModel.getData().get("DATA_EVENTS");
                if (arrayList != null) {
                    f57358g.addAll(0, arrayList);
                }
            }
        }
    }

    public void onResult(ApiCallDataModel<?> apiCallDataModel, Object obj) {
        Intrinsics.checkNotNullParameter(apiCallDataModel, "apiCallDataModel");
        Intrinsics.areEqual((Object) apiCallDataModel.getCall(), (Object) AnalyticsCall.class);
    }

    public final void reporting(boolean z) {
        this.f57364a.reporting(f57359h, this.f57367d, z);
    }

    public final void shutdown() {
        stop();
        mo171711a(true);
        this.f57364a.removeBinding(this);
    }

    public final void start(Date date, long j, int i) {
        Intrinsics.checkNotNullParameter(date, "serverTime");
        if (!f57362k && f57363l) {
            this.f57367d = new Date().getTime() - date.getTime();
            f57361j = i;
            f57362k = true;
            Log.m43645d(LOGTAG, Intrinsics.stringPlus("create new session Id: ", f57360i));
            Log.m43660v(LOGTAG, "start with fixed rate at P=" + j + " ms");
            ScheduledFuture<?> scheduledFuture = this.f57366c;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
            if (j != 0) {
                this.f57366c = this.f57365b.scheduleWithFixedDelay(new Runnable() {
                    public final void run() {
                        Analytics.m43609a(Analytics.this);
                    }
                }, j, j, TimeUnit.MILLISECONDS);
            }
            f57356e = this;
        }
    }

    public final void stop() {
        ScheduledFuture<?> scheduledFuture;
        ScheduledFuture<?> scheduledFuture2 = this.f57366c;
        if ((scheduledFuture2 != null && !scheduledFuture2.isCancelled()) && (scheduledFuture = this.f57366c) != null) {
            scheduledFuture.cancel(true);
        }
        f57362k = false;
        f57356e = null;
    }

    /* renamed from: a */
    public static /* synthetic */ void m43610a(Analytics analytics, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        analytics.mo171711a(z);
    }

    /* renamed from: a */
    public final void mo171711a(boolean z) {
        ArrayList arrayList = new ArrayList();
        synchronized (f57357f) {
            ArrayList<AnalyticsEvent> arrayList2 = f57358g;
            arrayList.addAll(arrayList2);
            arrayList2.clear();
            Unit unit = Unit.INSTANCE;
        }
        if (!arrayList.isEmpty()) {
            try {
                Log.m43660v(LOGTAG, "EventDispatcher.dispatchEvents()");
                this.f57364a.analytics(arrayList, this.f57367d, z);
            } catch (Exception e) {
                Log.m43666w(LOGTAG, "Exception while event dispatch", (Throwable) e);
                synchronized (f57357f) {
                    f57358g.addAll(0, arrayList);
                }
            }
        }
    }
}
