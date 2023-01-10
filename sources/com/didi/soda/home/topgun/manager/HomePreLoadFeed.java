package com.didi.soda.home.topgun.manager;

import com.didi.nova.assembly.serial.SerialTaskQueue;
import com.didi.soda.customer.foundation.rpc.entity.topgun.HomeEntity;
import com.didi.soda.customer.foundation.rpc.net.CRpcCallBackWithTraceId;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import com.didi.soda.customer.foundation.tracker.LaunchAppTracker;
import com.didi.soda.customer.foundation.util.startup.FallbackController;
import com.didi.soda.customer.foundation.util.startup.StartLocHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000f\u001a\u00020\u00102\u0010\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\nJ\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, mo148868d2 = {"Lcom/didi/soda/home/topgun/manager/HomePreLoadFeed;", "", "()V", "preFeedEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/topgun/HomeEntity;", "preFeedTime", "", "preSFRpcException", "Lcom/didi/soda/customer/foundation/rpc/net/SFRpcException;", "resultCallback", "Lcom/didi/soda/customer/foundation/rpc/net/CRpcCallBackWithTraceId;", "status", "Lcom/didi/soda/home/topgun/manager/PreLoadStatus;", "traceId", "", "addCallback", "", "callback", "isBeginPreLoad", "", "preLoadFeedFeed", "queue", "Lcom/didi/nova/assembly/serial/SerialTaskQueue;", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: HomeFeedPreLoad.kt */
public final class HomePreLoadFeed {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public HomeEntity f45504a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public long f45505b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public String f45506c = "";
    /* access modifiers changed from: private */

    /* renamed from: d */
    public SFRpcException f45507d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public PreLoadStatus f45508e = PreLoadStatus.IDLE;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public CRpcCallBackWithTraceId<HomeEntity> f45509f;

    public final boolean isBeginPreLoad() {
        return this.f45508e != PreLoadStatus.IDLE;
    }

    public final void preLoadFeedFeed(SerialTaskQueue serialTaskQueue) {
        Intrinsics.checkNotNullParameter(serialTaskQueue, "queue");
        if (FallbackController.isOpenPreFeed()) {
            StartLocHelper.preloadLaunch();
            this.f45508e = PreLoadStatus.RUNNING;
            HomePreLoadFeed$preLoadFeedFeed$callback$1 homePreLoadFeed$preLoadFeedFeed$callback$1 = new HomePreLoadFeed$preLoadFeedFeed$callback$1(this);
            HomeFeedParam homeFeedParam = new HomeFeedParam();
            homeFeedParam.reset();
            homeFeedParam.setScene(1);
            LaunchAppTracker.Companion.beginTrace("FeedAddQueue");
            serialTaskQueue.append(new HomeFeedTask(homePreLoadFeed$preLoadFeedFeed$callback$1, homeFeedParam), SerialTaskQueue.AppendMode.ReplaceStrict);
            return;
        }
        this.f45508e = PreLoadStatus.IDLE;
    }

    public final void addCallback(CRpcCallBackWithTraceId<HomeEntity> cRpcCallBackWithTraceId) {
        if (this.f45508e == PreLoadStatus.RUNNING) {
            this.f45509f = cRpcCallBackWithTraceId;
        } else if (this.f45508e == PreLoadStatus.SUCCESS) {
            if (cRpcCallBackWithTraceId != null) {
                cRpcCallBackWithTraceId.onRpcSuccess(this.f45504a, this.f45505b, this.f45506c);
            }
        } else if (this.f45508e == PreLoadStatus.FAIL && cRpcCallBackWithTraceId != null) {
            cRpcCallBackWithTraceId.onRpcFailure(this.f45507d);
        }
    }
}
