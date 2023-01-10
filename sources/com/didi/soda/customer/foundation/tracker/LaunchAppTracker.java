package com.didi.soda.customer.foundation.tracker;

import com.didi.foundation.sdk.utils.PerformanceTracker;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.tracker.performance.PerformanceOmegaHelper;
import com.didi.soda.customer.foundation.util.CustomerExtentionKt;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.customer.foundation.util.LocationUtil;
import com.didi.soda.customer.foundation.util.UiHandlerUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

@Metadata(mo148867d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 !2\u00020\u0001:\u0001!B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\fH\u0002J\b\u0010\u0010\u001a\u00020\fH\u0002J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u0013\u001a\u00020\fH\u0002J\u0018\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0004H\u0002J\u001a\u0010\u0016\u001a\u00020\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0018\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0004H\u0002J\u0010\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0004H\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u001e\u001a\u00020\fH\u0002J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010 \u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, mo148868d2 = {"Lcom/didi/soda/customer/foundation/tracker/LaunchAppTracker;", "", "()V", "appBeginTime", "", "hasLastLocation", "", "stage", "trackInfos", "", "Lcom/didi/soda/customer/foundation/tracker/TraceInfo;", "beginTrace", "", "tag", "", "checkHasLastLocation", "doTrack", "endTrace", "endTraceInThread", "getFoundationPerformance", "getMainDetail", "appBegin", "getPointInfo", "info", "beginTime", "getSubStage", "getTrackDetail", "isLaunchStage", "", "isMainStage", "print", "reverseFind", "track", "Companion", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: LaunchAppTracker.kt */
public final class LaunchAppTracker {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String LOG_TAG = "LaunchApp";
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static boolean f43670e = (!GlobalContext.isEmbed());
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static LaunchAppTracker f43671f = new LaunchAppTracker();
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final List<C14553a> f43672a = new ArrayList();

    /* renamed from: b */
    private int f43673b;

    /* renamed from: c */
    private final long f43674c = System.currentTimeMillis();

    /* renamed from: d */
    private int f43675d;

    public LaunchAppTracker() {
        m32636a(LOG_TAG);
    }

    /* renamed from: a */
    private final void m32634a() {
        try {
            if (LocationUtil.getCurrentLocation() != null) {
                this.f43675d = 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001b, code lost:
        if (r8.equals("RequestFeedIndex") == false) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0024, code lost:
        if (r8.equals("FeedAddQueue") == false) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0027, code lost:
        r7.f43673b = 3;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m32636a(java.lang.String r8) {
        /*
            r7 = this;
            int r0 = r8.hashCode()
            switch(r0) {
                case -1755289556: goto L_0x0038;
                case -1107357317: goto L_0x002b;
                case -571536178: goto L_0x001e;
                case 443222053: goto L_0x0015;
                case 1274592282: goto L_0x0008;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x0044
        L_0x0008:
            java.lang.String r0 = "LaunchSplash"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0011
            goto L_0x0044
        L_0x0011:
            r0 = 1
            r7.f43673b = r0
            goto L_0x0044
        L_0x0015:
            java.lang.String r0 = "RequestFeedIndex"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0027
            goto L_0x0044
        L_0x001e:
            java.lang.String r0 = "FeedAddQueue"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0027
            goto L_0x0044
        L_0x0027:
            r0 = 3
            r7.f43673b = r0
            goto L_0x0044
        L_0x002b:
            java.lang.String r0 = "RenderView"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0034
            goto L_0x0044
        L_0x0034:
            r0 = 4
            r7.f43673b = r0
            goto L_0x0044
        L_0x0038:
            java.lang.String r0 = "LaunchMain"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0041
            goto L_0x0044
        L_0x0041:
            r0 = 2
            r7.f43673b = r0
        L_0x0044:
            com.didi.soda.customer.foundation.tracker.a r0 = new com.didi.soda.customer.foundation.tracker.a
            long r3 = java.lang.System.currentTimeMillis()
            r5 = 0
            int r6 = r7.f43673b
            r1 = r0
            r2 = r8
            r1.<init>(r2, r3, r5, r6)
            java.lang.String r1 = "init-GetLoc"
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r1)
            if (r8 == 0) goto L_0x005d
            r7.m32634a()
        L_0x005d:
            java.util.List<com.didi.soda.customer.foundation.tracker.a> r8 = r7.f43672a
            r8.add(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.foundation.tracker.LaunchAppTracker.m32636a(java.lang.String):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final C14553a m32637b(String str) {
        Iterator it = RangesKt.downTo(this.f43672a.size() - 1, 0).iterator();
        while (it.hasNext()) {
            C14553a aVar = this.f43672a.get(((IntIterator) it).nextInt());
            if (Intrinsics.areEqual((Object) aVar.mo111325a(), (Object) str)) {
                return aVar;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final void m32641c(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        C14553a b = m32637b(str);
        if (b != null) {
            b.mo111326a((int) (currentTimeMillis - b.mo111328b()));
            b.mo111327a(currentTimeMillis);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public final void m32643d(String str) {
        UiHandlerUtil.post(new Runnable(str, System.currentTimeMillis()) {
            public final /* synthetic */ String f$1;
            public final /* synthetic */ long f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                LaunchAppTracker.m32635a(LaunchAppTracker.this, this.f$1, this.f$2);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m32635a(LaunchAppTracker launchAppTracker, String str, long j) {
        Intrinsics.checkNotNullParameter(launchAppTracker, "this$0");
        Intrinsics.checkNotNullParameter(str, "$tag");
        if (f43670e) {
            try {
                C14553a b = launchAppTracker.m32637b(str);
                if (b != null) {
                    b.mo111326a((int) (j - b.mo111328b()));
                    b.mo111327a(j);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    private final void m32639b() {
        if (LaunchAppTrackerKt.f43676a) {
            for (C14553a aVar : this.f43672a) {
                Companion.log(aVar.toString());
            }
        }
    }

    /* renamed from: c */
    private final void m32640c() {
        List<PerformanceTracker.TraceInfo> traceInfo = PerformanceTracker.getTraceInfo();
        if (traceInfo != null) {
            for (PerformanceTracker.TraceInfo traceInfo2 : traceInfo) {
                C14553a aVar = new C14553a(Intrinsics.stringPlus("Foundation", traceInfo2.tag), traceInfo2.begin, (int) (traceInfo2.end - traceInfo2.begin), 0);
                aVar.mo111327a(traceInfo2.end);
                this.f43672a.add(aVar);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public final void m32642d() {
        try {
            m32641c(LOG_TAG);
            m32640c();
            if (LaunchAppTrackerKt.f43676a) {
                m32639b();
            }
            long currentTimeMillis = System.currentTimeMillis();
            m32644e();
            LogUtil.m32584d("TAG", Intrinsics.stringPlus(" dur = ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: e */
    private final boolean m32645e(String str) {
        return Intrinsics.areEqual((Object) str, (Object) LOG_TAG) || Intrinsics.areEqual((Object) str, (Object) "Application") || Intrinsics.areEqual((Object) str, (Object) "Splash") || Intrinsics.areEqual((Object) str, (Object) "MainPage") || Intrinsics.areEqual((Object) str, (Object) "RequestFeedIndex");
    }

    /* renamed from: f */
    private final boolean m32646f(String str) {
        return Intrinsics.areEqual((Object) str, (Object) "LaunchMain") || Intrinsics.areEqual((Object) str, (Object) "LaunchSplash");
    }

    /* renamed from: a */
    private final String m32631a(int i, long j) {
        List arrayList = new ArrayList();
        for (C14553a aVar : this.f43672a) {
            if (!m32645e(aVar.mo111325a()) && !m32646f(aVar.mo111325a()) && aVar.mo111331d() == i) {
                long e = aVar.mo111332e() - j;
                if (e >= 0) {
                    arrayList.add(MapsKt.mapOf(TuplesKt.m41339to("tag", aVar.mo111325a()), TuplesKt.m41339to("begin", Long.valueOf(aVar.mo111328b() - j)), TuplesKt.m41339to("end", Long.valueOf(e)), TuplesKt.m41339to("duration", Integer.valueOf(aVar.mo111330c()))));
                }
            }
        }
        return CustomerExtentionKt.toJsonString(arrayList);
    }

    /* renamed from: b */
    private final String m32638b(int i, long j) {
        List arrayList = new ArrayList();
        int i2 = 0;
        int i3 = 0;
        for (C14553a aVar : this.f43672a) {
            if (!m32645e(aVar.mo111325a()) && !m32646f(aVar.mo111325a()) && aVar.mo111331d() == i) {
                if (StringsKt.contains$default((CharSequence) aVar.mo111325a(), (CharSequence) "Component", false, 2, (Object) null)) {
                    i2 += aVar.mo111330c();
                } else if (Intrinsics.areEqual((Object) aVar.mo111325a(), (Object) "MainOther") || Intrinsics.areEqual((Object) aVar.mo111325a(), (Object) "MainLocal")) {
                    i3 += aVar.mo111330c();
                } else {
                    arrayList.add(MapsKt.mapOf(TuplesKt.m41339to("tag", aVar.mo111325a()), TuplesKt.m41339to("duration", Integer.valueOf(aVar.mo111330c()))));
                }
            }
        }
        arrayList.add(MapsKt.mapOf(TuplesKt.m41339to("tag", "SetUpComponent"), TuplesKt.m41339to("duration", Integer.valueOf(i2))));
        arrayList.add(MapsKt.mapOf(TuplesKt.m41339to("tag", "Other"), TuplesKt.m41339to("duration", Integer.valueOf(i3))));
        return CustomerExtentionKt.toJsonString(arrayList);
    }

    /* renamed from: a */
    private final String m32632a(long j) {
        List arrayList = new ArrayList();
        for (C14553a aVar : this.f43672a) {
            arrayList.add(MapsKt.mapOf(TuplesKt.m41339to("tag", aVar.mo111325a()), TuplesKt.m41339to("begin", Long.valueOf(aVar.mo111328b() - j)), TuplesKt.m41339to("end", Long.valueOf(aVar.mo111332e() - j)), TuplesKt.m41339to("duration", Integer.valueOf(aVar.mo111330c()))));
        }
        return CustomerExtentionKt.toJsonString(arrayList);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m32644e() {
        /*
            r18 = this;
            r0 = r18
            r1 = 0
            r2 = r1
            com.didi.soda.customer.foundation.tracker.a r2 = (com.didi.soda.customer.foundation.tracker.C14553a) r2
            long r2 = r0.f43674c
            java.util.List<com.didi.soda.customer.foundation.tracker.a> r4 = r0.f43672a
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.Iterator r4 = r4.iterator()
            r5 = 0
            r7 = r1
            r8 = r7
            r9 = r8
            r10 = r9
            r11 = r5
            r13 = r11
            r5 = r10
            r6 = r5
        L_0x001a:
            boolean r15 = r4.hasNext()
            if (r15 == 0) goto L_0x00a5
            java.lang.Object r15 = r4.next()
            com.didi.soda.customer.foundation.tracker.a r15 = (com.didi.soda.customer.foundation.tracker.C14553a) r15
            r16 = r4
            java.lang.String r4 = r15.mo111325a()
            int r17 = r4.hashCode()
            switch(r17) {
                case -1811999097: goto L_0x0093;
                case -1107357317: goto L_0x0080;
                case -1072845520: goto L_0x0073;
                case -571536178: goto L_0x0066;
                case 56081416: goto L_0x0059;
                case 443222053: goto L_0x0046;
                case 2129477674: goto L_0x0037;
                default: goto L_0x0033;
            }
        L_0x0033:
            r17 = r10
            goto L_0x009f
        L_0x0037:
            r17 = r10
            java.lang.String r10 = "GetLoc"
            boolean r4 = r4.equals(r10)
            if (r4 != 0) goto L_0x0043
            goto L_0x009f
        L_0x0043:
            r7 = r15
            goto L_0x009f
        L_0x0046:
            r17 = r10
            java.lang.String r10 = "RequestFeedIndex"
            boolean r4 = r4.equals(r10)
            if (r4 != 0) goto L_0x0051
            goto L_0x009f
        L_0x0051:
            long r10 = r15.mo111332e()
            long r10 = r10 - r2
            r11 = r10
            r8 = r15
            goto L_0x009f
        L_0x0059:
            r17 = r10
            java.lang.String r10 = "MainPage"
            boolean r4 = r4.equals(r10)
            if (r4 != 0) goto L_0x0064
            goto L_0x009f
        L_0x0064:
            r6 = r15
            goto L_0x009f
        L_0x0066:
            r17 = r10
            java.lang.String r10 = "FeedAddQueue"
            boolean r4 = r4.equals(r10)
            if (r4 != 0) goto L_0x0071
            goto L_0x009f
        L_0x0071:
            r10 = r15
            goto L_0x00a1
        L_0x0073:
            r17 = r10
            java.lang.String r10 = "Application"
            boolean r4 = r4.equals(r10)
            if (r4 != 0) goto L_0x007e
            goto L_0x009f
        L_0x007e:
            r1 = r15
            goto L_0x009f
        L_0x0080:
            r17 = r10
            java.lang.String r10 = "RenderView"
            boolean r4 = r4.equals(r10)
            if (r4 != 0) goto L_0x008b
            goto L_0x009f
        L_0x008b:
            long r9 = r15.mo111332e()
            long r9 = r9 - r2
            r13 = r9
            r9 = r15
            goto L_0x009f
        L_0x0093:
            r17 = r10
            java.lang.String r10 = "Splash"
            boolean r4 = r4.equals(r10)
            if (r4 != 0) goto L_0x009e
            goto L_0x009f
        L_0x009e:
            r5 = r15
        L_0x009f:
            r10 = r17
        L_0x00a1:
            r4 = r16
            goto L_0x001a
        L_0x00a5:
            r17 = r10
            com.didi.soda.customer.foundation.util.startup.FallbackController$FallbackModel r4 = com.didi.soda.customer.foundation.util.startup.FallbackController.getFallbackInfo()
            java.lang.String r10 = "getFallbackInfo()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r10)
            java.lang.String r10 = "tech_sailing_c_x_launch_detail"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r10 = com.didi.soda.customer.foundation.tracker.OmegaTracker.Builder.create(r10)
            int r15 = r0.f43675d
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            r16 = r4
            java.lang.String r4 = "has_last_location"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r4 = r10.addEventParam(r4, r15)
            java.lang.Long r10 = java.lang.Long.valueOf(r11)
            java.lang.String r11 = "duration_feed"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r4 = r4.addEventParam(r11, r10)
            java.lang.Long r10 = java.lang.Long.valueOf(r13)
            java.lang.String r11 = "duration_render"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r4 = r4.addEventParam(r11, r10)
            java.lang.String r1 = r0.m32633a((com.didi.soda.customer.foundation.tracker.C14553a) r1, (long) r2)
            java.lang.String r10 = "init_app"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r1 = r4.addEventParam(r10, r1)
            r4 = 0
            java.lang.String r4 = r0.m32631a((int) r4, (long) r2)
            java.lang.String r10 = "init_app_detail"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r1 = r1.addEventParam(r10, r4)
            java.lang.String r4 = r0.m32633a((com.didi.soda.customer.foundation.tracker.C14553a) r5, (long) r2)
            java.lang.String r5 = "init_splash"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r1 = r1.addEventParam(r5, r4)
            r4 = 1
            java.lang.String r4 = r0.m32631a((int) r4, (long) r2)
            java.lang.String r5 = "init_splash_detail"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r1 = r1.addEventParam(r5, r4)
            java.lang.String r4 = r0.m32633a((com.didi.soda.customer.foundation.tracker.C14553a) r6, (long) r2)
            java.lang.String r5 = "init_main"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r1 = r1.addEventParam(r5, r4)
            r4 = 2
            java.lang.String r4 = r0.m32638b(r4, r2)
            java.lang.String r5 = "init_main_detail"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r1 = r1.addEventParam(r5, r4)
            java.lang.String r4 = r0.m32633a((com.didi.soda.customer.foundation.tracker.C14553a) r7, (long) r2)
            java.lang.String r5 = "wait_loc"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r1 = r1.addEventParam(r5, r4)
            java.lang.String r4 = r0.m32633a((com.didi.soda.customer.foundation.tracker.C14553a) r8, (long) r2)
            java.lang.String r5 = "refresh_home"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r1 = r1.addEventParam(r5, r4)
            r4 = 3
            java.lang.String r4 = r0.m32631a((int) r4, (long) r2)
            java.lang.String r5 = "refresh_home_detail"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r1 = r1.addEventParam(r5, r4)
            java.lang.String r4 = r0.m32633a((com.didi.soda.customer.foundation.tracker.C14553a) r9, (long) r2)
            java.lang.String r5 = "render_view"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r1 = r1.addEventParam(r5, r4)
            r10 = r17
            java.lang.String r4 = r0.m32633a((com.didi.soda.customer.foundation.tracker.C14553a) r10, (long) r2)
            java.lang.String r5 = "add_queue"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r1 = r1.addEventParam(r5, r4)
            java.lang.String r2 = r0.m32632a((long) r2)
            java.lang.String r3 = "detail"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r1 = r1.addEventParam(r3, r2)
            r2 = r16
            boolean r2 = r2.isOpen
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            java.lang.String r3 = "fallback_open"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r1 = r1.addEventParam(r3, r2)
            boolean r2 = com.didi.soda.customer.foundation.util.startup.StartLocHelper.isPreLoc()
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            java.lang.String r3 = "pre_loc"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r1 = r1.addEventParam(r3, r2)
            boolean r2 = com.didi.soda.customer.foundation.util.startup.StartLocHelper.isPreLoad()
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            java.lang.String r3 = "open_pre_feed"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r1 = r1.addEventParam(r3, r2)
            com.didi.soda.customer.foundation.tracker.OmegaTracker r1 = r1.build()
            r1.track()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.foundation.tracker.LaunchAppTracker.m32644e():void");
    }

    /* renamed from: a */
    private final String m32633a(C14553a aVar, long j) {
        long j2;
        Pair[] pairArr = new Pair[4];
        int i = 0;
        pairArr[0] = TuplesKt.m41339to("tag", aVar == null ? "" : aVar.mo111325a());
        long j3 = 0;
        if (aVar == null) {
            j2 = 0;
        } else {
            j2 = aVar.mo111328b() - j;
        }
        pairArr[1] = TuplesKt.m41339to("begin", Long.valueOf(j2));
        if (aVar != null) {
            j3 = aVar.mo111332e() - j;
        }
        pairArr[2] = TuplesKt.m41339to("end", Long.valueOf(j3));
        if (aVar != null) {
            i = aVar.mo111330c();
        }
        pairArr[3] = TuplesKt.m41339to("duration", Integer.valueOf(i));
        try {
            String json = GsonUtil.toJson(MapsKt.mapOf(pairArr));
            Intrinsics.checkNotNullExpressionValue(json, "{\n            GsonUtil.toJson(infoMap)\n        }");
            return json;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Metadata(mo148867d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\nJ\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004J\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\u000f\u001a\u00020\nJ\u000e\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0004J\u0006\u0010\u0012\u001a\u00020\nJ\u0016\u0010\u0013\u001a\u00020\n2\u000e\u0010\u0014\u001a\n\u0018\u00010\u0015j\u0004\u0018\u0001`\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, mo148868d2 = {"Lcom/didi/soda/customer/foundation/tracker/LaunchAppTracker$Companion;", "", "()V", "LOG_TAG", "", "enable", "", "instance", "Lcom/didi/soda/customer/foundation/tracker/LaunchAppTracker;", "beginTrace", "", "tag", "clear", "endTrace", "endTraceInThread", "fixFakeColdStart", "log", "msg", "track", "trackExtraError", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: LaunchAppTracker.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void log(String str) {
            Intrinsics.checkNotNullParameter(str, "msg");
        }

        private Companion() {
        }

        public final void beginTrace(String str) {
            LaunchAppTracker access$getInstance$cp;
            Intrinsics.checkNotNullParameter(str, "tag");
            if (LaunchAppTracker.f43670e && (access$getInstance$cp = LaunchAppTracker.f43671f) != null) {
                access$getInstance$cp.m32636a(str);
            }
        }

        public final void endTrace(String str) {
            LaunchAppTracker access$getInstance$cp;
            Intrinsics.checkNotNullParameter(str, "tag");
            if (LaunchAppTracker.f43670e && (access$getInstance$cp = LaunchAppTracker.f43671f) != null) {
                access$getInstance$cp.m32641c(str);
            }
        }

        public final void endTraceInThread(String str) {
            LaunchAppTracker access$getInstance$cp;
            Intrinsics.checkNotNullParameter(str, "tag");
            if (LaunchAppTracker.f43670e && (access$getInstance$cp = LaunchAppTracker.f43671f) != null) {
                access$getInstance$cp.m32643d(str);
            }
        }

        public final void fixFakeColdStart() {
            if (LaunchAppTracker.f43670e) {
                LaunchAppTracker access$getInstance$cp = LaunchAppTracker.f43671f;
                C14553a access$reverseFind = access$getInstance$cp == null ? null : access$getInstance$cp.m32637b("LaunchSplash");
                if (access$reverseFind != null && access$reverseFind.mo111330c() > 500) {
                    clear();
                    PerformanceOmegaHelper.getInstance().reset();
                    LogUtil.m32584d("TraceHelper", "fixFakeColdStart");
                }
            }
        }

        public final void track() {
            if (LaunchAppTracker.f43670e) {
                LaunchAppTracker access$getInstance$cp = LaunchAppTracker.f43671f;
                if (access$getInstance$cp != null) {
                    access$getInstance$cp.m32642d();
                }
                clear();
            }
        }

        public final void clear() {
            LaunchAppTracker.f43670e = false;
            if (LaunchAppTracker.f43671f != null) {
                LaunchAppTracker access$getInstance$cp = LaunchAppTracker.f43671f;
                if (access$getInstance$cp != null) {
                    access$getInstance$cp.f43672a.clear();
                }
                LaunchAppTracker.f43671f = null;
            }
        }

        public final void trackExtraError(Exception exc) {
            String str;
            if (exc == null) {
                str = null;
            } else {
                try {
                    str = ExceptionsKt.stackTraceToString(exc);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Technology.TECH_SAILING_C_GET_EXTRA_DATA_ERROR);
            if (str == null) {
                str = "";
            }
            create.addEventParam("stack_info", str).build().track();
        }
    }
}
