package com.didi.map.global.flow.scene.order.serving.scene.sctx;

import com.didi.map.global.model.omega.GlobalOmegaTracker;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002JD\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013¨\u0006\u0014"}, mo148868d2 = {"Lcom/didi/map/global/flow/scene/order/serving/scene/sctx/SctxOmegaHelper;", "", "()V", "trackSerialOrderError", "", "errorEnum", "Lcom/didi/map/global/flow/scene/order/serving/scene/sctx/SerialOrderErrorEnum;", "orderId", "", "lastOrderId", "trackSerialOrderOraRelatedError", "routeRes", "Lcom/didi/map/sdk/proto/driver_gl/MapPassengeOrderRouteRes;", "routePoints", "", "Lcom/didi/common/map/model/LatLng;", "markManager", "Lcom/didi/map/global/flow/scene/order/serving/components/MarkerManager;", "needAddSerialOrderPassPointMarker", "", "sdk-mapflow_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: SctxOmegaHelper.kt */
public final class SctxOmegaHelper {
    public static final SctxOmegaHelper INSTANCE = new SctxOmegaHelper();

    private SctxOmegaHelper() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v0, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: java.lang.Float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v12, resolved type: java.lang.Float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v20, resolved type: java.lang.Float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v11, resolved type: java.lang.Float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v26, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v27, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v1, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v2, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v2, resolved type: com.didi.map.sdk.proto.driver_gl.OdPoint} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v21, resolved type: java.lang.Float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v28, resolved type: java.lang.Float} */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x026a, code lost:
        if (((r3 == null || (r4 = r3.distance) == null) ? 0 : r4.intValue()) == 0) goto L_0x026c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x02aa, code lost:
        if (com.didi.common.map.util.LatLngUtils.locateCorrect(r6, r3 == 0 ? 0.0d : (double) r3.floatValue()) == false) goto L_0x02ac;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void trackSerialOrderOraRelatedError(java.lang.String r25, java.lang.String r26, com.didi.map.sdk.proto.driver_gl.MapPassengeOrderRouteRes r27, java.util.List<com.didi.common.map.model.LatLng> r28, com.didi.map.global.flow.scene.order.serving.components.MarkerManager r29, boolean r30) {
        /*
            r24 = this;
            r0 = r24
            r1 = r25
            r2 = r26
            r3 = r27
            r4 = r28
            r5 = r29
            java.lang.String r6 = "markManager"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r6)
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.List r6 = (java.util.List) r6
            if (r3 != 0) goto L_0x001c
            r8 = 0
            goto L_0x001e
        L_0x001c:
            java.lang.Integer r8 = r3.curDstRouteGeoIndex
        L_0x001e:
            r12 = 1
            if (r3 != 0) goto L_0x0022
            goto L_0x0026
        L_0x0022:
            java.util.List<com.didi.map.sdk.proto.driver_gl.OdPoint> r13 = r3.odPoints
            if (r13 != 0) goto L_0x0031
        L_0x0026:
            r19 = r8
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            goto L_0x010e
        L_0x0031:
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            java.util.Iterator r13 = r13.iterator()
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
        L_0x003f:
            boolean r19 = r13.hasNext()
            if (r19 == 0) goto L_0x010c
            java.lang.Object r19 = r13.next()
            int r20 = r14 + 1
            if (r14 >= 0) goto L_0x0050
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x0050:
            r14 = r19
            com.didi.map.sdk.proto.driver_gl.OdPoint r14 = (com.didi.map.sdk.proto.driver_gl.OdPoint) r14
            if (r14 != 0) goto L_0x0058
            r9 = 0
            goto L_0x005a
        L_0x0058:
            java.lang.Integer r9 = r14.pointType
        L_0x005a:
            r10 = 2
            if (r9 != 0) goto L_0x005e
            goto L_0x0064
        L_0x005e:
            int r9 = r9.intValue()
            if (r9 == r10) goto L_0x0066
        L_0x0064:
            r16 = 1
        L_0x0066:
            if (r14 != 0) goto L_0x006a
            r9 = 0
            goto L_0x006c
        L_0x006a:
            com.didi.map.sdk.proto.driver_gl.DoublePoint r9 = r14.point
        L_0x006c:
            if (r9 != 0) goto L_0x0073
        L_0x006e:
            r19 = r8
            r7 = 0
            goto L_0x0080
        L_0x0073:
            java.lang.Double r9 = r9.dlat
            if (r9 != 0) goto L_0x0078
            goto L_0x006e
        L_0x0078:
            double r21 = r9.doubleValue()
            r19 = r8
            r7 = r21
        L_0x0080:
            if (r14 != 0) goto L_0x0084
            r9 = 0
            goto L_0x0086
        L_0x0084:
            com.didi.map.sdk.proto.driver_gl.DoublePoint r9 = r14.point
        L_0x0086:
            if (r9 != 0) goto L_0x008b
        L_0x0088:
            r10 = 0
            goto L_0x0096
        L_0x008b:
            java.lang.Double r9 = r9.dlng
            if (r9 != 0) goto L_0x0090
            goto L_0x0088
        L_0x0090:
            double r22 = r9.doubleValue()
            r10 = r22
        L_0x0096:
            boolean r7 = com.didi.common.map.util.LatLngUtils.locateCorrect(r7, r10)
            if (r7 != 0) goto L_0x009e
            r17 = 1
        L_0x009e:
            if (r14 != 0) goto L_0x00a2
            r7 = 0
            goto L_0x00a4
        L_0x00a2:
            java.lang.Integer r7 = r14.odType
        L_0x00a4:
            if (r7 != 0) goto L_0x00a7
            goto L_0x00ad
        L_0x00a7:
            int r7 = r7.intValue()
            if (r7 == r12) goto L_0x00bf
        L_0x00ad:
            if (r14 != 0) goto L_0x00b1
            r7 = 0
            goto L_0x00b3
        L_0x00b1:
            java.lang.Integer r7 = r14.odType
        L_0x00b3:
            if (r7 != 0) goto L_0x00b6
            goto L_0x00bd
        L_0x00b6:
            int r7 = r7.intValue()
            r8 = 2
            if (r7 == r8) goto L_0x00bf
        L_0x00bd:
            r18 = 1
        L_0x00bf:
            if (r14 != 0) goto L_0x00c3
            r7 = 0
            goto L_0x00c5
        L_0x00c3:
            java.lang.Integer r7 = r14.pointType
        L_0x00c5:
            if (r7 != 0) goto L_0x00c8
            goto L_0x00df
        L_0x00c8:
            int r7 = r7.intValue()
            r8 = 2
            if (r7 != r8) goto L_0x00df
            if (r14 != 0) goto L_0x00d3
            r7 = 0
            goto L_0x00d5
        L_0x00d3:
            java.lang.Integer r7 = r14.odType
        L_0x00d5:
            if (r7 != 0) goto L_0x00d8
            goto L_0x00df
        L_0x00d8:
            int r7 = r7.intValue()
            if (r7 != r12) goto L_0x00df
            r15 = r14
        L_0x00df:
            if (r14 != 0) goto L_0x00e3
            r7 = 0
            goto L_0x00e5
        L_0x00e3:
            java.lang.Integer r7 = r14.pointType
        L_0x00e5:
            if (r7 != 0) goto L_0x00e8
            goto L_0x0106
        L_0x00e8:
            int r7 = r7.intValue()
            r8 = 2
            if (r7 != r8) goto L_0x0106
            if (r14 != 0) goto L_0x00f3
            r7 = 0
            goto L_0x00f5
        L_0x00f3:
            java.lang.Integer r7 = r14.odType
        L_0x00f5:
            if (r7 != 0) goto L_0x00f8
            goto L_0x0106
        L_0x00f8:
            int r7 = r7.intValue()
            if (r7 != r8) goto L_0x0106
            java.lang.String r7 = "odPoint"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r7)
            r6.add(r14)
        L_0x0106:
            r8 = r19
            r14 = r20
            goto L_0x003f
        L_0x010c:
            r19 = r8
        L_0x010e:
            if (r3 != 0) goto L_0x0112
        L_0x0110:
            r7 = 0
            goto L_0x0122
        L_0x0112:
            java.util.List<com.didi.map.sdk.proto.driver_gl.OdPoint> r7 = r3.odPoints
            if (r7 != 0) goto L_0x0117
            goto L_0x0110
        L_0x0117:
            java.util.Collection r7 = (java.util.Collection) r7
            boolean r7 = r7.isEmpty()
            r7 = r7 ^ r12
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
        L_0x0122:
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r12)
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)
            if (r7 == 0) goto L_0x013d
            if (r15 != 0) goto L_0x013d
            r7 = r6
            java.util.Collection r7 = (java.util.Collection) r7
            boolean r7 = r7.isEmpty()
            r7 = r7 ^ r12
            if (r7 == 0) goto L_0x013d
            com.didi.map.global.flow.scene.order.serving.scene.sctx.SerialOrderErrorEnum r7 = com.didi.map.global.flow.scene.order.serving.scene.sctx.SerialOrderErrorEnum.ORA_LAST_ORDER_HAS_OD_NO_DEST
            r0.m22809a(r7, r1, r2)
        L_0x013d:
            if (r16 == 0) goto L_0x0144
            com.didi.map.global.flow.scene.order.serving.scene.sctx.SerialOrderErrorEnum r7 = com.didi.map.global.flow.scene.order.serving.scene.sctx.SerialOrderErrorEnum.ORA_LAST_ORDER_POINT_TYPE_ERROR
            r0.m22809a(r7, r1, r2)
        L_0x0144:
            if (r17 == 0) goto L_0x014b
            com.didi.map.global.flow.scene.order.serving.scene.sctx.SerialOrderErrorEnum r7 = com.didi.map.global.flow.scene.order.serving.scene.sctx.SerialOrderErrorEnum.ORA_LAST_ORDER_COORDINATE_ERROR
            r0.m22809a(r7, r1, r2)
        L_0x014b:
            if (r18 == 0) goto L_0x0152
            com.didi.map.global.flow.scene.order.serving.scene.sctx.SerialOrderErrorEnum r7 = com.didi.map.global.flow.scene.order.serving.scene.sctx.SerialOrderErrorEnum.ORA_LAST_ORDER_OD_TYPE_ERROR
            r0.m22809a(r7, r1, r2)
        L_0x0152:
            if (r19 == 0) goto L_0x0167
            if (r4 == 0) goto L_0x018a
            r7 = r4
            java.util.Collection r7 = (java.util.Collection) r7
            kotlin.ranges.IntRange r7 = kotlin.collections.CollectionsKt.getIndices(r7)
            int r8 = r19.intValue()
            boolean r7 = r7.contains((int) r8)
            if (r7 != 0) goto L_0x018a
        L_0x0167:
            if (r3 != 0) goto L_0x016b
        L_0x0169:
            r7 = 0
            goto L_0x017b
        L_0x016b:
            java.util.List<com.didi.map.sdk.proto.driver_gl.OdPoint> r7 = r3.odPoints
            if (r7 != 0) goto L_0x0170
            goto L_0x0169
        L_0x0170:
            java.util.Collection r7 = (java.util.Collection) r7
            boolean r7 = r7.isEmpty()
            r7 = r7 ^ r12
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
        L_0x017b:
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r12)
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)
            if (r7 == 0) goto L_0x018a
            com.didi.map.global.flow.scene.order.serving.scene.sctx.SerialOrderErrorEnum r7 = com.didi.map.global.flow.scene.order.serving.scene.sctx.SerialOrderErrorEnum.ORA_LAST_ORDER_CURDST_NULL_ODPOINTS_NONNULL
            r0.m22809a(r7, r1, r2)
        L_0x018a:
            if (r19 == 0) goto L_0x01c2
            if (r4 == 0) goto L_0x01c2
            r7 = r4
            java.util.Collection r7 = (java.util.Collection) r7
            kotlin.ranges.IntRange r7 = kotlin.collections.CollectionsKt.getIndices(r7)
            int r8 = r19.intValue()
            boolean r7 = r7.contains((int) r8)
            if (r7 == 0) goto L_0x01c2
            if (r3 != 0) goto L_0x01a3
        L_0x01a1:
            r7 = 0
            goto L_0x01b3
        L_0x01a3:
            java.util.List<com.didi.map.sdk.proto.driver_gl.OdPoint> r7 = r3.odPoints
            if (r7 != 0) goto L_0x01a8
            goto L_0x01a1
        L_0x01a8:
            java.util.Collection r7 = (java.util.Collection) r7
            boolean r7 = r7.isEmpty()
            r7 = r7 ^ r12
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
        L_0x01b3:
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r12)
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)
            if (r7 != 0) goto L_0x01c2
            com.didi.map.global.flow.scene.order.serving.scene.sctx.SerialOrderErrorEnum r7 = com.didi.map.global.flow.scene.order.serving.scene.sctx.SerialOrderErrorEnum.ORA_LAST_ORDER_CURDST_NONNULL_ODPOINTS_NULL
            r0.m22809a(r7, r1, r2)
        L_0x01c2:
            if (r19 == 0) goto L_0x01d2
            if (r4 != 0) goto L_0x01c7
            goto L_0x01d2
        L_0x01c7:
            int r7 = r19.intValue()
            java.lang.Object r7 = kotlin.collections.CollectionsKt.getOrNull(r4, r7)
            com.didi.common.map.model.LatLng r7 = (com.didi.common.map.model.LatLng) r7
            goto L_0x01d3
        L_0x01d2:
            r7 = 0
        L_0x01d3:
            boolean r8 = r6.isEmpty()
            if (r8 == 0) goto L_0x01e0
            r21 = 0
            r6 = r21
            com.didi.common.map.model.LatLng r6 = (com.didi.common.map.model.LatLng) r6
            goto L_0x0212
        L_0x01e0:
            r21 = 0
            com.didi.common.map.model.LatLng r8 = new com.didi.common.map.model.LatLng
            java.lang.Object r10 = kotlin.collections.CollectionsKt.first(r6)
            com.didi.map.sdk.proto.driver_gl.OdPoint r10 = (com.didi.map.sdk.proto.driver_gl.OdPoint) r10
            com.didi.map.sdk.proto.driver_gl.DoublePoint r10 = r10.point
            java.lang.Double r10 = r10.dlat
            java.lang.String r11 = "wayPoints.first().point.dlat"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r11)
            java.lang.Number r10 = (java.lang.Number) r10
            double r10 = r10.doubleValue()
            java.lang.Object r6 = kotlin.collections.CollectionsKt.first(r6)
            com.didi.map.sdk.proto.driver_gl.OdPoint r6 = (com.didi.map.sdk.proto.driver_gl.OdPoint) r6
            com.didi.map.sdk.proto.driver_gl.DoublePoint r6 = r6.point
            java.lang.Double r6 = r6.dlng
            java.lang.String r13 = "wayPoints.first().point.dlng"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r13)
            java.lang.Number r6 = (java.lang.Number) r6
            double r13 = r6.doubleValue()
            r8.<init>((double) r10, (double) r13)
            r6 = r8
        L_0x0212:
            if (r19 == 0) goto L_0x022f
            boolean r8 = com.didi.common.map.util.LatLngUtils.locateCorrect(r7)
            if (r8 == 0) goto L_0x022f
            boolean r8 = com.didi.common.map.util.LatLngUtils.locateCorrect(r6)
            if (r8 == 0) goto L_0x022f
            double r6 = com.didi.common.map.util.DDSphericalUtil.computeDistanceBetween(r7, r6)
            r10 = 4617315517961601024(0x4014000000000000, double:5.0)
            int r8 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r8 <= 0) goto L_0x022f
            com.didi.map.global.flow.scene.order.serving.scene.sctx.SerialOrderErrorEnum r6 = com.didi.map.global.flow.scene.order.serving.scene.sctx.SerialOrderErrorEnum.ORA_LAST_ORDER_CURDST_POINT_TOO_FAR_FROM_FIRST_ODPOINT
            r0.m22809a(r6, r1, r2)
        L_0x022f:
            if (r4 != 0) goto L_0x0234
            r4 = r21
            goto L_0x023f
        L_0x0234:
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r4 = r4.isEmpty()
            r4 = r4 ^ r12
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
        L_0x023f:
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r12)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r6)
            if (r4 != 0) goto L_0x024e
            com.didi.map.global.flow.scene.order.serving.scene.sctx.SerialOrderErrorEnum r4 = com.didi.map.global.flow.scene.order.serving.scene.sctx.SerialOrderErrorEnum.ORA_ROUTE_POINTS_NULL
            r0.m22809a(r4, r1, r2)
        L_0x024e:
            if (r3 != 0) goto L_0x0252
        L_0x0250:
            r4 = 0
            goto L_0x025b
        L_0x0252:
            java.lang.Integer r4 = r3.eta
            if (r4 != 0) goto L_0x0257
            goto L_0x0250
        L_0x0257:
            int r4 = r4.intValue()
        L_0x025b:
            if (r4 == 0) goto L_0x026c
            if (r3 != 0) goto L_0x0261
        L_0x025f:
            r4 = 0
            goto L_0x026a
        L_0x0261:
            java.lang.Integer r4 = r3.distance
            if (r4 != 0) goto L_0x0266
            goto L_0x025f
        L_0x0266:
            int r4 = r4.intValue()
        L_0x026a:
            if (r4 != 0) goto L_0x0271
        L_0x026c:
            com.didi.map.global.flow.scene.order.serving.scene.sctx.SerialOrderErrorEnum r4 = com.didi.map.global.flow.scene.order.serving.scene.sctx.SerialOrderErrorEnum.ORA_ETA_OR_EDA_NULL
            r0.m22809a(r4, r1, r2)
        L_0x0271:
            if (r3 != 0) goto L_0x0276
            r4 = r21
            goto L_0x0278
        L_0x0276:
            com.didi.map.sdk.proto.driver_gl.DoublePoint r4 = r3.driverPoint
        L_0x0278:
            if (r4 == 0) goto L_0x02ac
            if (r3 != 0) goto L_0x027f
        L_0x027c:
            r4 = r21
            goto L_0x0286
        L_0x027f:
            com.didi.map.sdk.proto.driver_gl.DoublePoint r4 = r3.driverPoint
            if (r4 != 0) goto L_0x0284
            goto L_0x027c
        L_0x0284:
            java.lang.Float r4 = r4.lat
        L_0x0286:
            if (r4 != 0) goto L_0x028b
            r6 = 0
            goto L_0x0290
        L_0x028b:
            float r4 = r4.floatValue()
            double r6 = (double) r4
        L_0x0290:
            if (r3 != 0) goto L_0x0295
        L_0x0292:
            r3 = r21
            goto L_0x029c
        L_0x0295:
            com.didi.map.sdk.proto.driver_gl.DoublePoint r3 = r3.driverPoint
            if (r3 != 0) goto L_0x029a
            goto L_0x0292
        L_0x029a:
            java.lang.Float r3 = r3.lng
        L_0x029c:
            if (r3 != 0) goto L_0x02a1
            r3 = 0
            goto L_0x02a6
        L_0x02a1:
            float r3 = r3.floatValue()
            double r3 = (double) r3
        L_0x02a6:
            boolean r3 = com.didi.common.map.util.LatLngUtils.locateCorrect(r6, r3)
            if (r3 != 0) goto L_0x02b1
        L_0x02ac:
            com.didi.map.global.flow.scene.order.serving.scene.sctx.SerialOrderErrorEnum r3 = com.didi.map.global.flow.scene.order.serving.scene.sctx.SerialOrderErrorEnum.ORA_DRIVER_LOC_NULL
            r0.m22809a(r3, r1, r2)
        L_0x02b1:
            com.didi.map.global.flow.scene.param.MapElementId r3 = com.didi.map.global.flow.scene.param.MapElementId.ID_MARKER_WAYPOINT
            int r3 = r5.getMarkerIconResId(r3)
            com.didi.map.global.flow.scene.param.MapElementId r4 = com.didi.map.global.flow.scene.param.MapElementId.ID_MARKER_ODPOINT
            int r4 = r5.getMarkerIconResId(r4)
            if (r30 == 0) goto L_0x02c1
            if (r3 <= 0) goto L_0x02c3
        L_0x02c1:
            if (r4 > 0) goto L_0x02c8
        L_0x02c3:
            com.didi.map.global.flow.scene.order.serving.scene.sctx.SerialOrderErrorEnum r3 = com.didi.map.global.flow.scene.order.serving.scene.sctx.SerialOrderErrorEnum.UI_NO_ICON
            r0.m22809a(r3, r1, r2)
        L_0x02c8:
            if (r30 == 0) goto L_0x02f3
            com.didi.map.global.flow.scene.param.MapElementId r3 = com.didi.map.global.flow.scene.param.MapElementId.ID_MARKER_WAYPOINT
            java.lang.String r3 = r5.getMarkerAddressName(r3)
            if (r3 != 0) goto L_0x02d5
            r7 = r21
            goto L_0x02e4
        L_0x02d5:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            int r3 = r3.length()
            if (r3 <= 0) goto L_0x02df
            r11 = 1
            goto L_0x02e0
        L_0x02df:
            r11 = 0
        L_0x02e0:
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r11)
        L_0x02e4:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r12)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r3)
            if (r3 != 0) goto L_0x02f3
            com.didi.map.global.flow.scene.order.serving.scene.sctx.SerialOrderErrorEnum r3 = com.didi.map.global.flow.scene.order.serving.scene.sctx.SerialOrderErrorEnum.UI_NO_LAST_DST_TEXT
            r0.m22809a(r3, r1, r2)
        L_0x02f3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.flow.scene.order.serving.scene.sctx.SctxOmegaHelper.trackSerialOrderOraRelatedError(java.lang.String, java.lang.String, com.didi.map.sdk.proto.driver_gl.MapPassengeOrderRouteRes, java.util.List, com.didi.map.global.flow.scene.order.serving.components.MarkerManager, boolean):void");
    }

    /* renamed from: a */
    private final void m22809a(SerialOrderErrorEnum serialOrderErrorEnum, String str, String str2) {
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("error_code", Integer.valueOf(serialOrderErrorEnum.getValue()));
        if (str2 == null) {
            str2 = "";
        }
        linkedHashMap.put("last_order_id", str2);
        if (str == null) {
            str = "";
        }
        linkedHashMap.put("order_id", str);
        GlobalOmegaTracker.trackEvent("tech_map_serial_order_error", linkedHashMap);
    }
}
