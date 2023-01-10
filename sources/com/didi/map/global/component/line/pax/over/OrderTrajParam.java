package com.didi.map.global.component.line.pax.over;

import com.didi.map.global.component.line.component.OnLineDrawStatusListener;
import com.didi.map.global.component.line.data.param.OrderTrajLineRequest;

public class OrderTrajParam {

    /* renamed from: a */
    private OrderTrajLineRequest f28158a;

    /* renamed from: b */
    private int f28159b;

    /* renamed from: c */
    private int f28160c;

    /* renamed from: d */
    private OnLineDrawStatusListener f28161d;

    public OrderTrajParam(OrderTrajLineRequest orderTrajLineRequest, int i, int i2, OnLineDrawStatusListener onLineDrawStatusListener) {
        this.f28158a = orderTrajLineRequest;
        this.f28159b = i;
        this.f28160c = i2;
        this.f28161d = onLineDrawStatusListener;
    }

    public OrderTrajLineRequest getRequest() {
        return this.f28158a;
    }

    public int getLineColor() {
        return this.f28159b;
    }

    public int getLineWidth() {
        return this.f28160c;
    }

    public OnLineDrawStatusListener getLineDrawStatusListener() {
        return this.f28161d;
    }
}
