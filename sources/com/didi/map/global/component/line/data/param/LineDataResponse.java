package com.didi.map.global.component.line.data.param;

import com.didi.map.sdk.proto.driver_gl.BubblePageRes;
import com.didi.map.sdk.proto.driver_gl.MultiRoutePlanRes;
import com.didi.map.sdk.proto.driver_gl.OrderTrajResponse;
import com.didi.map.sdk.proto.driver_gl.RoutePlanRes;

public class LineDataResponse {

    /* renamed from: a */
    private RoutePlanRes f28079a;

    /* renamed from: b */
    private MultiRoutePlanRes f28080b;

    /* renamed from: c */
    private OrderTrajResponse f28081c;

    /* renamed from: d */
    private BubblePageRes f28082d;

    public BubblePageRes getBubblePageRes() {
        return this.f28082d;
    }

    public void setBubblePageRes(BubblePageRes bubblePageRes) {
        this.f28082d = bubblePageRes;
    }

    public RoutePlanRes getRoutePlanRes() {
        return this.f28079a;
    }

    public void setRoutePlanRes(RoutePlanRes routePlanRes) {
        this.f28079a = routePlanRes;
    }

    public MultiRoutePlanRes getMultiRoutePlanRes() {
        return this.f28080b;
    }

    public void setMultiRoutePlanRes(MultiRoutePlanRes multiRoutePlanRes) {
        this.f28080b = multiRoutePlanRes;
    }

    public OrderTrajResponse getOrderTrajResponse() {
        return this.f28081c;
    }

    public void setOrderTrajResponse(OrderTrajResponse orderTrajResponse) {
        this.f28081c = orderTrajResponse;
    }
}
