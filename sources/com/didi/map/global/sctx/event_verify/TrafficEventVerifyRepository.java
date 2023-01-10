package com.didi.map.global.sctx.event_verify;

import com.didi.map.global.sctx.event_reveal.Result;
import com.didi.map.sdk.proto.driver_gl.event.EventFeedbackReq;
import com.didi.map.sdk.proto.driver_gl.event.EventFeedbackRes;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J'\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, mo148868d2 = {"Lcom/didi/map/global/sctx/event_verify/TrafficEventVerifyRepository;", "", "dataSource", "Lcom/didi/map/global/sctx/event_verify/TrafficEventVerifyDataSource;", "(Lcom/didi/map/global/sctx/event_verify/TrafficEventVerifyDataSource;)V", "postVerifyData", "Lcom/didi/map/global/sctx/event_reveal/Result;", "Lcom/didi/map/sdk/proto/driver_gl/event/EventFeedbackRes;", "url", "", "req", "Lcom/didi/map/sdk/proto/driver_gl/event/EventFeedbackReq;", "(Ljava/lang/String;Lcom/didi/map/sdk/proto/driver_gl/event/EventFeedbackReq;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "base-sync-trip_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: TrafficEventVerifyRepository.kt */
public final class TrafficEventVerifyRepository {

    /* renamed from: a */
    private final TrafficEventVerifyDataSource f30082a;

    public TrafficEventVerifyRepository(TrafficEventVerifyDataSource trafficEventVerifyDataSource) {
        Intrinsics.checkNotNullParameter(trafficEventVerifyDataSource, "dataSource");
        this.f30082a = trafficEventVerifyDataSource;
    }

    public final Object postVerifyData(String str, EventFeedbackReq eventFeedbackReq, Continuation<? super Result<EventFeedbackRes>> continuation) {
        return this.f30082a.postVerifyData(str, eventFeedbackReq, continuation);
    }
}
