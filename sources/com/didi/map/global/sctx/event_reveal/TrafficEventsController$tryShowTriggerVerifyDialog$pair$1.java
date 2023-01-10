package com.didi.map.global.sctx.event_reveal;

import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.LatLng;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n"}, mo148868d2 = {"<anonymous>", "", "driPoint", "Lcom/didi/common/map/model/LatLng;", "mapElement", "Lcom/didi/common/map/internal/IMapElement;"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: TrafficEventsController.kt */
final class TrafficEventsController$tryShowTriggerVerifyDialog$pair$1 extends Lambda implements Function2<LatLng, IMapElement, Boolean> {
    final /* synthetic */ TrafficEventsController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TrafficEventsController$tryShowTriggerVerifyDialog$pair$1(TrafficEventsController trafficEventsController) {
        super(2);
        this.this$0 = trafficEventsController;
    }

    public /* synthetic */ Object invoke(Object obj, Object obj2) {
        return Boolean.valueOf(invoke((LatLng) obj, (IMapElement) obj2));
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x006f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean invoke(com.didi.common.map.model.LatLng r7, com.didi.common.map.internal.IMapElement r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.didi.common.map.model.Marker
            r1 = 0
            if (r0 == 0) goto L_0x0008
            com.didi.common.map.model.Marker r8 = (com.didi.common.map.model.Marker) r8
            goto L_0x0009
        L_0x0008:
            r8 = r1
        L_0x0009:
            if (r8 != 0) goto L_0x000d
            r8 = r1
            goto L_0x0011
        L_0x000d:
            java.lang.Object r8 = r8.getData()
        L_0x0011:
            boolean r0 = r8 instanceof com.didi.map.sdk.proto.driver_gl.event.ShowEvent
            if (r0 == 0) goto L_0x0018
            com.didi.map.sdk.proto.driver_gl.event.ShowEvent r8 = (com.didi.map.sdk.proto.driver_gl.event.ShowEvent) r8
            goto L_0x0019
        L_0x0018:
            r8 = r1
        L_0x0019:
            if (r8 != 0) goto L_0x001d
        L_0x001b:
            r0 = r1
            goto L_0x0024
        L_0x001d:
            com.didi.map.sdk.proto.driver_gl.DoublePoint r0 = r8.eventPoint
            if (r0 != 0) goto L_0x0022
            goto L_0x001b
        L_0x0022:
            java.lang.Double r0 = r0.dlat
        L_0x0024:
            if (r0 == 0) goto L_0x0057
            if (r8 != 0) goto L_0x002a
        L_0x0028:
            r0 = r1
            goto L_0x0031
        L_0x002a:
            com.didi.map.sdk.proto.driver_gl.DoublePoint r0 = r8.eventPoint
            if (r0 != 0) goto L_0x002f
            goto L_0x0028
        L_0x002f:
            java.lang.Double r0 = r0.dlng
        L_0x0031:
            if (r0 == 0) goto L_0x0057
            com.didi.common.map.model.LatLng r0 = new com.didi.common.map.model.LatLng
            com.didi.map.sdk.proto.driver_gl.DoublePoint r2 = r8.eventPoint
            java.lang.Double r2 = r2.dlat
            java.lang.String r3 = "model.eventPoint.dlat"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            java.lang.Number r2 = (java.lang.Number) r2
            double r2 = r2.doubleValue()
            com.didi.map.sdk.proto.driver_gl.DoublePoint r4 = r8.eventPoint
            java.lang.Double r4 = r4.dlng
            java.lang.String r5 = "model.eventPoint.dlng"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            java.lang.Number r4 = (java.lang.Number) r4
            double r4 = r4.doubleValue()
            r0.<init>((double) r2, (double) r4)
            goto L_0x005a
        L_0x0057:
            r0 = r1
            com.didi.common.map.model.LatLng r0 = (com.didi.common.map.model.LatLng) r0
        L_0x005a:
            boolean r7 = com.didi.common.map.util.LatLngUtils.locateCorrect(r7)
            r2 = 1
            if (r7 == 0) goto L_0x0090
            boolean r7 = com.didi.common.map.util.LatLngUtils.locateCorrect(r0)
            if (r7 == 0) goto L_0x0090
            if (r8 != 0) goto L_0x006b
            r7 = r1
            goto L_0x006d
        L_0x006b:
            java.lang.Long r7 = r8.eventId
        L_0x006d:
            if (r7 == 0) goto L_0x0090
            com.didi.map.global.sctx.event_reveal.TrafficEventsController r7 = r6.this$0
            java.util.List r7 = r7.f30062q
            if (r8 != 0) goto L_0x0079
            r0 = r1
            goto L_0x007b
        L_0x0079:
            java.lang.Long r0 = r8.eventId
        L_0x007b:
            boolean r7 = r7.contains(r0)
            if (r7 != 0) goto L_0x0090
            if (r8 != 0) goto L_0x0084
            goto L_0x0086
        L_0x0084:
            java.lang.Integer r1 = r8.eventOper
        L_0x0086:
            if (r1 != 0) goto L_0x0089
            goto L_0x0090
        L_0x0089:
            int r7 = r1.intValue()
            if (r7 != r2) goto L_0x0090
            goto L_0x0091
        L_0x0090:
            r2 = 0
        L_0x0091:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.sctx.event_reveal.TrafficEventsController$tryShowTriggerVerifyDialog$pair$1.invoke(com.didi.common.map.model.LatLng, com.didi.common.map.internal.IMapElement):boolean");
    }
}
