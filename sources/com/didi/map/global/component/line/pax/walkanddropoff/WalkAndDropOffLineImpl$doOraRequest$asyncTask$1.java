package com.didi.map.global.component.line.pax.walkanddropoff;

import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.line.utils.LineDataConverter;
import com.didi.map.sdk.proto.driver_gl.MultiRoutePlanRes;
import com.didi.map.sdk.proto.driver_gl.SingleRouteRes;
import com.didi.map.sdk.proto.driver_gl.TravelMode;
import com.didichuxing.routesearchsdk.multi.IMultiRouteSearchCallback;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J$\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, mo148868d2 = {"com/didi/map/global/component/line/pax/walkanddropoff/WalkAndDropOffLineImpl$doOraRequest$asyncTask$1", "Lcom/didichuxing/routesearchsdk/multi/IMultiRouteSearchCallback;", "onBeginToSearch", "", "onFinishToSearch", "res", "Lcom/didi/map/sdk/proto/driver_gl/MultiRoutePlanRes;", "errno", "", "taskId", "", "compLine_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: WalkAndDropOffLineImpl.kt */
public final class WalkAndDropOffLineImpl$doOraRequest$asyncTask$1 implements IMultiRouteSearchCallback {
    final /* synthetic */ WalkAndDropOffLineImpl this$0;

    public void onFinishToSearch(MultiRoutePlanRes multiRoutePlanRes, String str) {
        Intrinsics.checkNotNullParameter(str, "errno");
    }

    WalkAndDropOffLineImpl$doOraRequest$asyncTask$1(WalkAndDropOffLineImpl walkAndDropOffLineImpl) {
        this.this$0 = walkAndDropOffLineImpl;
    }

    public void onBeginToSearch() {
        DLog.m10773d(this.this$0.f28167a, Intrinsics.stringPlus("onFinishToSearch  mId=", Integer.valueOf(this.this$0.f28174h)), new Object[0]);
    }

    public void onFinishToSearch(MultiRoutePlanRes multiRoutePlanRes, String str, int i) {
        List<SingleRouteRes> list;
        List<SingleRouteRes> list2;
        DLog.m10773d(this.this$0.f28167a, "onFinishToSearch  mId=" + this.this$0.f28174h + ", taskId= " + i, new Object[0]);
        if (i == this.this$0.f28174h) {
            if (multiRoutePlanRes == null) {
                list = null;
            } else {
                list = multiRoutePlanRes.routeRes;
            }
            if (list != null) {
                DLog.m10773d(this.this$0.f28167a, Intrinsics.stringPlus("onFinishToSearch  res=", multiRoutePlanRes), new Object[0]);
                if (multiRoutePlanRes == null) {
                    list2 = null;
                } else {
                    list2 = multiRoutePlanRes.routeRes;
                }
                if (!CollectionUtil.isEmpty((Collection<?>) list2)) {
                    for (SingleRouteRes next : list2) {
                        List<LatLng> latLngListFromDiffGeoPoints = LineDataConverter.getLatLngListFromDiffGeoPoints(next.routeGeos);
                        if (next.travelMode == TravelMode.WALKING) {
                            WalkAndDropOffLineImpl walkAndDropOffLineImpl = this.this$0;
                            Integer num = next.style;
                            Intrinsics.checkNotNullExpressionValue(num, "route.style");
                            walkAndDropOffLineImpl.m22104a(latLngListFromDiffGeoPoints, num.intValue());
                        } else if (next.travelMode == TravelMode.DRIVING) {
                            this.this$0.m22103a(latLngListFromDiffGeoPoints);
                        }
                    }
                    return;
                }
            }
            this.this$0.f28171e = null;
            this.this$0.f28172f = null;
            DLog.m10773d(this.this$0.f28167a, "onFinishToSearch  data error", new Object[0]);
            return;
        }
        DLog.m10773d(this.this$0.f28167a, "onFinishToSearch  丢弃", new Object[0]);
    }
}
