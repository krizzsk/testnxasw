package com.didi.map.global.flow.scene.order.confirm;

import com.didi.map.global.flow.scene.order.confirm.normal.LineMode;
import com.didi.map.global.flow.scene.param.CommonLineParam;
import com.didi.map.sdk.proto.driver_gl.EpfOrderType;

public class RoutePlanParam {

    /* renamed from: a */
    private LineMode f29093a;

    /* renamed from: b */
    private EpfOrderType f29094b;

    /* renamed from: c */
    private String f29095c;

    /* renamed from: d */
    private CommonLineParam f29096d;

    public LineMode getLineMode() {
        return this.f29093a;
    }

    public void setLineMode(LineMode lineMode) {
        this.f29093a = lineMode;
    }

    public EpfOrderType getOrderType() {
        return this.f29094b;
    }

    public void setOrderType(EpfOrderType epfOrderType) {
        this.f29094b = epfOrderType;
    }

    public String getBubbleId() {
        return this.f29095c;
    }

    public void setBubbleId(String str) {
        this.f29095c = str;
    }

    public CommonLineParam getLineParam() {
        return this.f29096d;
    }

    public void setLineParam(CommonLineParam commonLineParam) {
        this.f29096d = commonLineParam;
    }

    public String toString() {
        return "RoutePlanParam{lineMode=" + this.f29093a + ", orderType=" + this.f29094b + ", bubbleId='" + this.f29095c + '\'' + ", lineParam=" + this.f29096d + '}';
    }
}
