package com.didi.map.global.component.line.data.param;

import com.didi.common.map.model.LatLng;
import com.didi.map.sdk.proto.driver_gl.TravelMode;
import com.didichuxing.routesearchsdk.CallFrom;
import java.util.List;

public class RouteLineRequest extends BaseLineRequest {

    /* renamed from: a */
    private LatLng f28087a;

    /* renamed from: b */
    private LatLng f28088b;

    /* renamed from: c */
    private List<LatLng> f28089c;

    /* renamed from: d */
    private TravelMode f28090d;

    /* renamed from: e */
    private String f28091e;

    /* renamed from: f */
    private int f28092f;

    public RouteLineRequest(CallFrom callFrom, String str) {
        super(callFrom, str);
    }

    public RouteLineRequest(CallFrom callFrom, String str, LatLng latLng, LatLng latLng2, TravelMode travelMode) {
        super(callFrom, str);
        this.f28087a = latLng;
        this.f28088b = latLng2;
        this.f28090d = travelMode;
    }

    public LatLng getStart() {
        return this.f28087a;
    }

    public void setStart(LatLng latLng) {
        this.f28087a = latLng;
    }

    public LatLng getEnd() {
        return this.f28088b;
    }

    public void setEnd(LatLng latLng) {
        this.f28088b = latLng;
    }

    public List<LatLng> getWayPoint() {
        return this.f28089c;
    }

    public void setWayPoint(List<LatLng> list) {
        this.f28089c = list;
    }

    public TravelMode getTravelMode() {
        return this.f28090d;
    }

    public void setTravelMode(TravelMode travelMode) {
        this.f28090d = travelMode;
    }

    public String getOrderId() {
        return this.f28091e;
    }

    public void setOrderId(String str) {
        this.f28091e = str;
    }

    public void setBizGroup(int i) {
        this.f28092f = i;
    }

    public int getBizGroup() {
        return this.f28092f;
    }
}
