package com.didi.map.global.sctx.event_reveal;

import com.didi.map.sdk.proto.driver_gl.event.EventShowReq;
import com.didi.map.sdk.proto.driver_gl.event.EventShowRes;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(mo148867d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J'\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, mo148868d2 = {"Lcom/didi/map/global/sctx/event_reveal/ITrafficEventsDataSource;", "", "getData", "Lcom/didi/map/global/sctx/event_reveal/Result;", "Lcom/didi/map/sdk/proto/driver_gl/event/EventShowRes;", "url", "", "param", "Lcom/didi/map/sdk/proto/driver_gl/event/EventShowReq;", "(Ljava/lang/String;Lcom/didi/map/sdk/proto/driver_gl/event/EventShowReq;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "base-sync-trip_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: ITrafficEventsDataSource.kt */
public interface ITrafficEventsDataSource {
    Object getData(String str, EventShowReq eventShowReq, Continuation<? super Result<EventShowRes>> continuation);
}
