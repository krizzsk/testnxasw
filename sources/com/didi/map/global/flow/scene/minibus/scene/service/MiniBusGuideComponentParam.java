package com.didi.map.global.flow.scene.minibus.scene.service;

import com.didi.map.global.flow.scene.order.serving.param.OrderParams;

public class MiniBusGuideComponentParam {

    /* renamed from: a */
    private OrderParams f28922a;

    /* renamed from: b */
    private MiniBusStreetParam f28923b;

    public OrderParams getOrderParams() {
        return this.f28922a;
    }

    public void setOrderParams(OrderParams orderParams) {
        this.f28922a = orderParams;
    }

    public void setStreetParam(MiniBusStreetParam miniBusStreetParam) {
        this.f28923b = miniBusStreetParam;
    }

    public MiniBusStreetParam getStreetParam() {
        return this.f28923b;
    }
}
