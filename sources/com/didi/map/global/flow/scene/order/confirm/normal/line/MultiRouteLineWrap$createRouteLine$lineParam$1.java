package com.didi.map.global.flow.scene.order.confirm.normal.line;

import com.didi.common.map.util.DLog;
import com.didi.map.global.flow.scene.order.confirm.normal.ILineSelectedListener;
import com.didi.map.global.flow.scene.param.CommonLineParam;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, mo148868d2 = {"com/didi/map/global/flow/scene/order/confirm/normal/line/MultiRouteLineWrap$createRouteLine$lineParam$1", "Lcom/didi/map/global/flow/scene/order/confirm/normal/ILineSelectedListener;", "routeSelected", "", "selectedRouteId", "", "defaultRouteId", "sdk-mapflow_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: MultiRouteLineWrap.kt */
public final class MultiRouteLineWrap$createRouteLine$lineParam$1 implements ILineSelectedListener {
    final /* synthetic */ MultiRouteLineWrap this$0;

    MultiRouteLineWrap$createRouteLine$lineParam$1(MultiRouteLineWrap multiRouteLineWrap) {
        this.this$0 = multiRouteLineWrap;
    }

    public void routeSelected(long j, long j2) {
        CommonLineParam commonLineParam;
        ILineSelectedListener access$getMListener$p;
        DLog.m10773d(MultiRouteLineWrap.TAG, "selected routeId:" + j + ", default routeId:" + j2, new Object[0]);
        if (!(this.this$0.f29213j == j || (access$getMListener$p = this.this$0.f29208e) == null)) {
            access$getMListener$p.routeSelected(j, j2);
        }
        this.this$0.f29213j = j;
        BubbleLineParam access$getParam$p = this.this$0.f29206c;
        if (access$getParam$p != null && (commonLineParam = access$getParam$p.getCommonLineParam()) != null) {
            BubblePageCache.getInstance().updateSelectedRouteId(commonLineParam.getStartPoint(), commonLineParam.getEndPoint(), commonLineParam.getWayPoints(), j);
        }
    }
}
