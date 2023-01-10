package com.didi.map.global.component.line.data.param;

import com.didichuxing.routesearchsdk.CallFrom;
import com.didichuxing.routesearchsdk.multi.SingleRouteReqParam;
import java.util.List;

public class MultiRouteLineRequest extends BaseLineRequest {

    /* renamed from: a */
    private List<SingleRouteReqParam> f28083a;

    /* renamed from: b */
    private int f28084b;

    /* renamed from: c */
    private String f28085c;

    /* renamed from: d */
    private String f28086d;

    public MultiRouteLineRequest(CallFrom callFrom, String str) {
        super(callFrom, str);
    }

    public String getOrderId() {
        return this.f28086d;
    }

    public void setOrderId(String str) {
        this.f28086d = str;
    }

    public int getOrderStage() {
        return this.f28084b;
    }

    public void setOrderStage(int i) {
        this.f28084b = i;
    }

    public String getDidiVersion() {
        return this.f28085c;
    }

    public void setDidiVersion(String str) {
        this.f28085c = str;
    }

    public List<SingleRouteReqParam> getLineParams() {
        return this.f28083a;
    }

    public void setLineParams(List<SingleRouteReqParam> list) {
        this.f28083a = list;
    }
}
