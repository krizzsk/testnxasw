package com.didi.map.global.sctx.event_reveal;

import com.didi.dcrypto.util.DCryptoUtils;
import com.didi.map.sdk.proto.driver_gl.DoublePoint;
import com.didi.map.sdk.proto.driver_gl.event.ButtonInfo;
import com.didi.map.sdk.proto.driver_gl.event.ButtonModeInfo;
import com.didi.map.sdk.proto.driver_gl.event.EventShowReq;
import com.didi.map.sdk.proto.driver_gl.event.EventShowRes;
import com.didi.map.sdk.proto.driver_gl.event.FeedCard;
import com.didi.map.sdk.proto.driver_gl.event.ShowEvent;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(mo148867d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J'\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J*\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0014H\u0002R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, mo148868d2 = {"Lcom/didi/map/global/sctx/event_reveal/MockTrafficEventsDataSource;", "Lcom/didi/map/global/sctx/event_reveal/ITrafficEventsDataSource;", "timeout", "", "routesGetter", "Lcom/didi/map/global/sctx/event_reveal/IMockTrafficEventGetter;", "(JLcom/didi/map/global/sctx/event_reveal/IMockTrafficEventGetter;)V", "getRoutesGetter", "()Lcom/didi/map/global/sctx/event_reveal/IMockTrafficEventGetter;", "getTimeout", "()J", "getData", "Lcom/didi/map/global/sctx/event_reveal/Result;", "Lcom/didi/map/sdk/proto/driver_gl/event/EventShowRes;", "url", "", "param", "Lcom/didi/map/sdk/proto/driver_gl/event/EventShowReq;", "(Ljava/lang/String;Lcom/didi/map/sdk/proto/driver_gl/event/EventShowReq;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mockRandomEventPoint", "Lcom/didi/map/sdk/proto/driver_gl/DoublePoint;", "prot", "", "mockShowEvent", "Lcom/didi/map/sdk/proto/driver_gl/event/ShowEvent;", "eventId", "eventTitle", "subTitle", "eventPoint", "base-sync-trip_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: MockTrafficEventsDataSource.kt */
public final class MockTrafficEventsDataSource implements ITrafficEventsDataSource {

    /* renamed from: a */
    private final long f30037a;

    /* renamed from: b */
    private final IMockTrafficEventGetter f30038b;

    public MockTrafficEventsDataSource(long j, IMockTrafficEventGetter iMockTrafficEventGetter) {
        this.f30037a = j;
        this.f30038b = iMockTrafficEventGetter;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MockTrafficEventsDataSource(long j, IMockTrafficEventGetter iMockTrafficEventGetter, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? null : iMockTrafficEventGetter);
    }

    public final IMockTrafficEventGetter getRoutesGetter() {
        return this.f30038b;
    }

    public final long getTimeout() {
        return this.f30037a;
    }

    public Object getData(String str, EventShowReq eventShowReq, Continuation<? super Result<EventShowRes>> continuation) {
        Dispatchers dispatchers = Dispatchers.INSTANCE;
        return BuildersKt.withContext(Dispatchers.getIO(), new MockTrafficEventsDataSource$getData$2(this, (Continuation<? super MockTrafficEventsDataSource$getData$2>) null), continuation);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0006, code lost:
        r2 = r9.getRoutePoints();
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.didi.map.sdk.proto.driver_gl.DoublePoint m23408a(com.didi.map.global.sctx.event_reveal.IMockTrafficEventGetter r9, float r10) {
        /*
            r8 = this;
            r0 = 1
            r1 = 0
            if (r9 != 0) goto L_0x0006
        L_0x0004:
            r2 = r1
            goto L_0x0018
        L_0x0006:
            java.util.List r2 = r9.getRoutePoints()
            if (r2 != 0) goto L_0x000d
            goto L_0x0004
        L_0x000d:
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            r2 = r2 ^ r0
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
        L_0x0018:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r0)
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            if (r2 == 0) goto L_0x00a7
            java.util.List r9 = r9.getRoutePoints()
            long r2 = java.lang.System.currentTimeMillis()
            kotlin.random.Random r2 = kotlin.random.RandomKt.Random((long) r2)
            if (r9 != 0) goto L_0x0032
            r3 = 1
            goto L_0x0036
        L_0x0032:
            int r3 = r9.size()
        L_0x0036:
            int r3 = r3 / 3
            float r3 = (float) r3
            float r3 = r3 * r10
            int r10 = (int) r3
            int r10 = r2.nextInt(r0, r10)
            if (r9 != 0) goto L_0x0044
            r9 = r1
            goto L_0x004a
        L_0x0044:
            java.lang.Object r9 = kotlin.collections.CollectionsKt.getOrNull(r9, r10)
            com.didi.common.map.model.LatLng r9 = (com.didi.common.map.model.LatLng) r9
        L_0x004a:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "mock index "
            r0.append(r2)
            r0.append(r10)
            java.lang.String r10 = " randomPoint "
            r0.append(r10)
            r0.append(r9)
            java.lang.String r4 = r0.toString()
            r2 = 3
            r5 = 0
            r7 = 66
            java.lang.String r3 = "TrafficReveal"
            java.lang.String r6 = "com.didi.map.global.sctx.event_reveal.MockTrafficEventsDataSource"
            com.didi.sdk.apm.SystemUtils.log(r2, r3, r4, r5, r6, r7)
            if (r9 != 0) goto L_0x0073
            com.didi.map.sdk.proto.driver_gl.DoublePoint r1 = (com.didi.map.sdk.proto.driver_gl.DoublePoint) r1
            goto L_0x00a9
        L_0x0073:
            com.didi.map.sdk.proto.driver_gl.DoublePoint$Builder r10 = new com.didi.map.sdk.proto.driver_gl.DoublePoint$Builder
            r10.<init>()
            double r0 = r9.latitude
            float r0 = (float) r0
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
            com.didi.map.sdk.proto.driver_gl.DoublePoint$Builder r10 = r10.lat(r0)
            double r0 = r9.longitude
            float r0 = (float) r0
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
            com.didi.map.sdk.proto.driver_gl.DoublePoint$Builder r10 = r10.lng(r0)
            double r0 = r9.latitude
            java.lang.Double r0 = java.lang.Double.valueOf(r0)
            com.didi.map.sdk.proto.driver_gl.DoublePoint$Builder r10 = r10.dlat(r0)
            double r0 = r9.longitude
            java.lang.Double r9 = java.lang.Double.valueOf(r0)
            com.didi.map.sdk.proto.driver_gl.DoublePoint$Builder r9 = r10.dlng(r9)
            com.didi.map.sdk.proto.driver_gl.DoublePoint r1 = r9.build()
            goto L_0x00a9
        L_0x00a7:
            com.didi.map.sdk.proto.driver_gl.DoublePoint r1 = (com.didi.map.sdk.proto.driver_gl.DoublePoint) r1
        L_0x00a9:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.sctx.event_reveal.MockTrafficEventsDataSource.m23408a(com.didi.map.global.sctx.event_reveal.IMockTrafficEventGetter, float):com.didi.map.sdk.proto.driver_gl.DoublePoint");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final ShowEvent m23409a(long j, String str, String str2, DoublePoint doublePoint) {
        String str3 = str;
        ButtonInfo build = new ButtonInfo.Builder().buttonTitle(DCryptoUtils.KEY_IP_BLOCKING_STATUS_UNBLOCK).buttonValue(1).buttonIndex(0).build();
        ButtonInfo build2 = new ButtonInfo.Builder().buttonTitle(DCryptoUtils.KEY_IP_BLOCKING_STATUS_BLOCK).buttonValue(2).buttonIndex(1).build();
        FeedCard.Builder builder = new FeedCard.Builder();
        FeedCard build3 = builder.title(str3 + "{closes in " + "{{close_time}}" + "s}").subTitle((String) null).secondary((String) null).cardType(1).btn(CollectionsKt.listOf(build, build2)).build();
        ButtonInfo build4 = new ButtonInfo.Builder().buttonTitle(DCryptoUtils.KEY_IP_BLOCKING_STATUS_UNBLOCK).buttonValue(1).buttonIndex(0).build();
        ButtonInfo build5 = new ButtonInfo.Builder().buttonTitle(DCryptoUtils.KEY_IP_BLOCKING_STATUS_BLOCK).buttonValue(2).buttonIndex(1).build();
        FeedCard build6 = new FeedCard.Builder().title(str3).subTitle(str2).secondary("test secondary").cardType(2).btn(CollectionsKt.listOf(build4, build5)).build();
        ShowEvent build7 = new ShowEvent.Builder().eventId(Long.valueOf(j)).modeInfo(CollectionsKt.listOf(new ButtonModeInfo.Builder().buttonMode(1).buttonPicUrl("https://img0.didiglobal.com/static/map_global/user_event/5077d18ae439571d1bda54a1b860350b").build())).eventTitle(str3).eventType(1).eventPoint(doublePoint).linkId(6L).card(CollectionsKt.listOf(build3, build6)).eventOper(1).reportTime(Long.valueOf(System.currentTimeMillis() / ((long) 1000))).build();
        Intrinsics.checkNotNullExpressionValue(build7, "showEvent");
        return build7;
    }
}
