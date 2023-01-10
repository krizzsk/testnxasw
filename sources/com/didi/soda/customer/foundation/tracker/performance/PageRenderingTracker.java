package com.didi.soda.customer.foundation.tracker.performance;

import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0003H\u0002J\u0006\u0010\u000e\u001a\u00020\u000bJ\u0006\u0010\u000f\u001a\u00020\u000bJ\u0006\u0010\u0010\u001a\u00020\u0000J\u0006\u0010\u0011\u001a\u00020\u000bR\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo148868d2 = {"Lcom/didi/soda/customer/foundation/tracker/performance/PageRenderingTracker;", "", "pageName", "", "(Ljava/lang/String;)V", "endTime", "", "getPageName", "()Ljava/lang/String;", "startTime", "checkParams", "", "log", "message", "report", "reset", "trackEnd", "trackStart", "Companion", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: PageRenderingTracker.kt */
public final class PageRenderingTracker {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long DEFAULT_TIMESTAMP = -1;
    public static final String TAG = "PageRenderingTracker";

    /* renamed from: a */
    private final String f43713a;

    /* renamed from: b */
    private long f43714b = -1;

    /* renamed from: c */
    private long f43715c = -1;

    public PageRenderingTracker(String str) {
        Intrinsics.checkNotNullParameter(str, "pageName");
        this.f43713a = str;
    }

    public final String getPageName() {
        return this.f43713a;
    }

    public final void trackStart() {
        this.f43714b = System.currentTimeMillis();
        m32671a("On page[" + this.f43713a + "] trackStart, startTime: " + this.f43714b);
    }

    public final PageRenderingTracker trackEnd() {
        this.f43715c = System.currentTimeMillis();
        m32671a("On page[" + this.f43713a + "] trackEnd, endTime: " + this.f43715c);
        return this;
    }

    public final void reset() {
        this.f43714b = -1;
        this.f43715c = -1;
    }

    public final void report() {
        try {
            m32670a();
            if (this.f43715c < this.f43714b) {
                LogUtil.m32586e(TAG, "On page[" + this.f43713a + "] report error, startTime: " + this.f43714b + ", endTime: " + this.f43715c);
                return;
            }
            long j = this.f43715c - this.f43714b;
            m32671a("On page[" + this.f43713a + "] report " + j);
            OmegaTracker.Builder.create(EventConst.Performance.PAGE_RENDERING_TIME).addEventParam(ParamConst.PARAM_PERFORMANCE_PAGE_NAME, this.f43713a).addEventParam("time", Long.valueOf(j)).build().track();
            OmegaTracker.Builder.create(EventConst.Technology.PAGE_LAUNCH_TIME).addEventParam("pn", this.f43713a).addEventParam(ParamConst.PARAM_OMEGA_PAGE_RENDERING_TIME, Long.valueOf(j)).addEventParam(ParamConst.PARAM_OMEGA_PAGE_NAME, this.f43713a).build().track();
        } catch (Exception e) {
            m32671a(Intrinsics.stringPlus("report error : ", e));
        }
    }

    /* renamed from: a */
    private final void m32670a() {
        if (this.f43713a.length() == 0) {
            throw new IllegalArgumentException("PageName is empty!");
        } else if (this.f43714b == -1) {
            throw new IllegalArgumentException("Do you forget to invoke trackStart() method ?");
        } else if (this.f43715c == -1) {
            throw new IllegalArgumentException("Do you forget to invoke trackEnd() method ?");
        }
    }

    /* renamed from: a */
    private final void m32671a(String str) {
        LogUtil.m32588i(TAG, str);
    }

    @Metadata(mo148867d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo148868d2 = {"Lcom/didi/soda/customer/foundation/tracker/performance/PageRenderingTracker$Companion;", "", "()V", "DEFAULT_TIMESTAMP", "", "TAG", "", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: PageRenderingTracker.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
