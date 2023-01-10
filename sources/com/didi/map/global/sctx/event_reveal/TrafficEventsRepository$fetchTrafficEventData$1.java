package com.didi.map.global.sctx.event_reveal;

import com.didi.map.sdk.proto.driver_gl.event.EventShowReq;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
@DebugMetadata(mo23688c = "com.didi.map.global.sctx.event_reveal.TrafficEventsRepository", mo23689f = "TrafficEventsRepository.kt", mo23690i = {0}, mo23691l = {16}, mo23692m = "fetchTrafficEventData", mo23693n = {"this"}, mo23694s = {"L$0"})
/* compiled from: TrafficEventsRepository.kt */
final class TrafficEventsRepository$fetchTrafficEventData$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TrafficEventsRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TrafficEventsRepository$fetchTrafficEventData$1(TrafficEventsRepository trafficEventsRepository, Continuation<? super TrafficEventsRepository$fetchTrafficEventData$1> continuation) {
        super(continuation);
        this.this$0 = trafficEventsRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.fetchTrafficEventData((String) null, (EventShowReq) null, this);
    }
}
