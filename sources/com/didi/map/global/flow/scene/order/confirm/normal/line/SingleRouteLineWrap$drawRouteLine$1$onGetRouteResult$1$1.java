package com.didi.map.global.flow.scene.order.confirm.normal.line;

import com.didi.common.map.util.DLog;
import com.didi.map.global.component.line.component.ICompLineContract;
import com.didi.map.global.component.line.component.OnLineDrawStatusListener;
import com.didi.map.global.flow.scene.order.confirm.component.OnElementShowCallback;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo148868d2 = {"com/didi/map/global/flow/scene/order/confirm/normal/line/SingleRouteLineWrap$drawRouteLine$1$onGetRouteResult$1$1", "Lcom/didi/map/global/component/line/component/OnLineDrawStatusListener;", "onLineDrawFinished", "", "sdk-mapflow_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: SingleRouteLineWrap.kt */
public final class SingleRouteLineWrap$drawRouteLine$1$onGetRouteResult$1$1 implements OnLineDrawStatusListener {
    final /* synthetic */ SingleRouteLineWrap this$0;

    public /* synthetic */ void onLineDrawStart() {
        OnLineDrawStatusListener.CC.$default$onLineDrawStart(this);
    }

    SingleRouteLineWrap$drawRouteLine$1$onGetRouteResult$1$1(SingleRouteLineWrap singleRouteLineWrap) {
        this.this$0 = singleRouteLineWrap;
    }

    public void onLineDrawFinished() {
        DLog.m10773d("SingleRouteLineWrap", "绘制 routeLineComponent完成", new Object[0]);
        ICompLineContract access$getMRouteLine$p = this.this$0.f29236e;
        if (access$getMRouteLine$p != null) {
            access$getMRouteLine$p.setLineVisible(this.this$0.f29237f);
        }
        OnElementShowCallback access$getElementShowCallback$p = this.this$0.f29238g;
        if (access$getElementShowCallback$p != null) {
            access$getElementShowCallback$p.onLineShowSuccess();
        }
    }
}
