package com.didi.map.global.sctx.event_reveal;

import com.didi.map.sdk.proto.driver_gl.event.ShowEvent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J'\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, mo148868d2 = {"Lcom/didi/map/global/sctx/event_reveal/TrafficEventsRepository;", "", "datasource", "Lcom/didi/map/global/sctx/event_reveal/ITrafficEventsDataSource;", "(Lcom/didi/map/global/sctx/event_reveal/ITrafficEventsDataSource;)V", "curTrafficEvents", "", "Lcom/didi/map/sdk/proto/driver_gl/event/ShowEvent;", "fetchTrafficEventData", "Lcom/didi/map/global/sctx/event_reveal/Result;", "Lcom/didi/map/sdk/proto/driver_gl/event/EventShowRes;", "url", "", "param", "Lcom/didi/map/sdk/proto/driver_gl/event/EventShowReq;", "(Ljava/lang/String;Lcom/didi/map/sdk/proto/driver_gl/event/EventShowReq;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTrafficEvents", "", "base-sync-trip_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: TrafficEventsRepository.kt */
public final class TrafficEventsRepository {

    /* renamed from: a */
    private final ITrafficEventsDataSource f30073a;

    /* renamed from: b */
    private final List<ShowEvent> f30074b = new ArrayList();

    public TrafficEventsRepository(ITrafficEventsDataSource iTrafficEventsDataSource) {
        Intrinsics.checkNotNullParameter(iTrafficEventsDataSource, "datasource");
        this.f30073a = iTrafficEventsDataSource;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object fetchTrafficEventData(java.lang.String r5, com.didi.map.sdk.proto.driver_gl.event.EventShowReq r6, kotlin.coroutines.Continuation<? super com.didi.map.global.sctx.event_reveal.Result<com.didi.map.sdk.proto.driver_gl.event.EventShowRes>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.didi.map.global.sctx.event_reveal.TrafficEventsRepository$fetchTrafficEventData$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.didi.map.global.sctx.event_reveal.TrafficEventsRepository$fetchTrafficEventData$1 r0 = (com.didi.map.global.sctx.event_reveal.TrafficEventsRepository$fetchTrafficEventData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.didi.map.global.sctx.event_reveal.TrafficEventsRepository$fetchTrafficEventData$1 r0 = new com.didi.map.global.sctx.event_reveal.TrafficEventsRepository$fetchTrafficEventData$1
            r0.<init>(r4, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r5 = r0.L$0
            com.didi.map.global.sctx.event_reveal.TrafficEventsRepository r5 = (com.didi.map.global.sctx.event_reveal.TrafficEventsRepository) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0047
        L_0x002e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r7)
            com.didi.map.global.sctx.event_reveal.ITrafficEventsDataSource r7 = r4.f30073a
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r7 = r7.getData(r5, r6, r0)
            if (r7 != r1) goto L_0x0046
            return r1
        L_0x0046:
            r5 = r4
        L_0x0047:
            com.didi.map.global.sctx.event_reveal.Result r7 = (com.didi.map.global.sctx.event_reveal.Result) r7
            boolean r6 = r7 instanceof com.didi.map.global.sctx.event_reveal.Result.Success
            if (r6 == 0) goto L_0x008a
            java.util.List<com.didi.map.sdk.proto.driver_gl.event.ShowEvent> r6 = r5.f30074b
            r6.clear()
            r6 = r7
            com.didi.map.global.sctx.event_reveal.Result$Success r6 = (com.didi.map.global.sctx.event_reveal.Result.Success) r6
            java.lang.Object r0 = r6.getData()
            com.didi.map.sdk.proto.driver_gl.event.EventShowRes r0 = (com.didi.map.sdk.proto.driver_gl.event.EventShowRes) r0
            java.util.List<com.didi.map.sdk.proto.driver_gl.event.ShowEvent> r0 = r0.events
            if (r0 != 0) goto L_0x0061
            r0 = 0
            goto L_0x006c
        L_0x0061:
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r3
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)
        L_0x006c:
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 == 0) goto L_0x008a
            java.util.List<com.didi.map.sdk.proto.driver_gl.event.ShowEvent> r5 = r5.f30074b
            java.lang.Object r6 = r6.getData()
            com.didi.map.sdk.proto.driver_gl.event.EventShowRes r6 = (com.didi.map.sdk.proto.driver_gl.event.EventShowRes) r6
            java.util.List<com.didi.map.sdk.proto.driver_gl.event.ShowEvent> r6 = r6.events
            java.lang.String r0 = "result.data.events"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)
            java.util.Collection r6 = (java.util.Collection) r6
            r5.addAll(r6)
        L_0x008a:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.sctx.event_reveal.TrafficEventsRepository.fetchTrafficEventData(java.lang.String, com.didi.map.sdk.proto.driver_gl.event.EventShowReq, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final List<ShowEvent> getTrafficEvents() {
        return CollectionsKt.toList(this.f30074b);
    }
}
