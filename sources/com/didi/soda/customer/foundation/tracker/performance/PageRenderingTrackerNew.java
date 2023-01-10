package com.didi.soda.customer.foundation.tracker.performance;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0002J\u0006\u0010\u000e\u001a\u00020\rJ\u0010\u0010\n\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0006\u0010\u000f\u001a\u00020\u0000J\u0006\u0010\u0010\u001a\u00020\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo148868d2 = {"Lcom/didi/soda/customer/foundation/tracker/performance/PageRenderingTrackerNew;", "", "pageName", "", "(Ljava/lang/String;)V", "endTime", "", "getPageName", "()Ljava/lang/String;", "startTime", "switch", "", "checkParams", "", "report", "trackEnd", "trackStart", "Companion", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: PageRenderingTrackerNew.kt */
public final class PageRenderingTrackerNew {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long DEFAULT_TIMESTAMP = -1;
    public static final String TAG = "PageRenderingTrackerNew";

    /* renamed from: a */
    private final String f43716a;

    /* renamed from: b */
    private long f43717b = -1;

    /* renamed from: c */
    private long f43718c = -1;

    /* renamed from: d */
    private boolean f43719d = true;

    public PageRenderingTrackerNew(String str) {
        Intrinsics.checkNotNullParameter(str, "pageName");
        this.f43716a = str;
    }

    public final String getPageName() {
        return this.f43716a;
    }

    public final PageRenderingTrackerNew trackStart() {
        this.f43717b = System.currentTimeMillis();
        m32673a(true);
        return this;
    }

    public final PageRenderingTrackerNew trackEnd() {
        this.f43718c = System.currentTimeMillis();
        return this;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m32673a(boolean z) {
        this.f43719d = z;
    }

    public final void report() {
        try {
            if (this.f43719d) {
                m32672a();
                if (this.f43718c < this.f43717b) {
                    LogUtil.m32586e("PageRenderingTrackerNew", Intrinsics.stringPlus(this.f43716a, " endTime < startTime error."));
                    return;
                }
                long j = this.f43718c - this.f43717b;
                LogUtil.m32588i("PageRenderingTrackerNew", this.f43716a + " renderTime " + j);
                OmegaTracker.Builder.create(EventConst.Performance.TECH_PAGE_PERFORMANCE).addEventParam("pn", this.f43716a).addEventParam("duration", Long.valueOf(j)).build().track();
                m32673a(false);
            }
        } catch (Exception e) {
            LogUtil.m32588i("PageRenderingTrackerNew", this.f43716a + ' ' + e);
        }
    }

    /* renamed from: a */
    private final void m32672a() {
        if (this.f43716a.length() == 0) {
            throw new IllegalArgumentException("PageName is empty!");
        } else if (this.f43717b == -1) {
            throw new IllegalArgumentException("Do you forget to invoke trackStart() method ?");
        } else if (this.f43718c == -1) {
            throw new IllegalArgumentException("Do you forget to invoke trackEnd() method ?");
        }
    }

    @Metadata(mo148867d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u000b\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0010\u0010\f\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\r"}, mo148868d2 = {"Lcom/didi/soda/customer/foundation/tracker/performance/PageRenderingTrackerNew$Companion;", "", "()V", "DEFAULT_TIMESTAMP", "", "TAG", "", "trackEndAndReportUtil", "", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "trackExceptionUtil", "trackStartUtil", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: PageRenderingTrackerNew.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void trackStartUtil(ScopeContext scopeContext) {
            if (scopeContext != null && scopeContext.getObject("PageRenderingTrackerNew") != null) {
                Object object = scopeContext.getObject("PageRenderingTrackerNew");
                if (object != null) {
                    ((PageRenderingTrackerNew) object).trackStart();
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.didi.soda.customer.foundation.tracker.performance.PageRenderingTrackerNew");
            }
        }

        public final void trackEndAndReportUtil(ScopeContext scopeContext) {
            if (scopeContext != null && scopeContext.getObject("PageRenderingTrackerNew") != null) {
                Object object = scopeContext.getObject("PageRenderingTrackerNew");
                if (object != null) {
                    ((PageRenderingTrackerNew) object).trackEnd().report();
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.didi.soda.customer.foundation.tracker.performance.PageRenderingTrackerNew");
            }
        }

        public final void trackExceptionUtil(ScopeContext scopeContext) {
            if (scopeContext != null && scopeContext.getObject("PageRenderingTrackerNew") != null) {
                Object object = scopeContext.getObject("PageRenderingTrackerNew");
                if (object != null) {
                    ((PageRenderingTrackerNew) object).m32673a(false);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.didi.soda.customer.foundation.tracker.performance.PageRenderingTrackerNew");
            }
        }
    }
}
