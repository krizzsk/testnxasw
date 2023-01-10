package com.didi.map.global.flow.toolkit.walkdrop;

import com.didi.common.map.model.LatLng;
import com.didichuxing.routesearchsdk.CallFrom;

public class WalkParam {

    /* renamed from: a */
    private LatLng f29768a;

    /* renamed from: b */
    private long f29769b;

    /* renamed from: c */
    private String f29770c;

    /* renamed from: d */
    private String f29771d;

    /* renamed from: e */
    private CallFrom f29772e;

    /* renamed from: f */
    private boolean f29773f;

    /* renamed from: g */
    private String f29774g;

    /* renamed from: h */
    private long f29775h;

    public LatLng getEndPoint() {
        return this.f29768a;
    }

    public long getDriverId() {
        return this.f29769b;
    }

    public String getOrderId() {
        return this.f29770c;
    }

    public String getProductId() {
        return this.f29771d;
    }

    public void setEndPoint(LatLng latLng) {
        this.f29768a = latLng;
    }

    public void setDriverId(long j) {
        this.f29769b = j;
    }

    public void setOrderId(String str) {
        this.f29770c = str;
    }

    public void setProductId(String str) {
        this.f29771d = str;
    }

    public CallFrom getCallFromm() {
        return this.f29772e;
    }

    public void setCallFromm(CallFrom callFrom) {
        this.f29772e = callFrom;
    }

    public boolean isAnimate() {
        return this.f29773f;
    }

    public void setAnimate(boolean z) {
        this.f29773f = z;
    }

    public String getSrcTag() {
        return this.f29774g;
    }

    public void setSrcTag(String str) {
        this.f29774g = str;
    }

    public long getPushInterval() {
        return this.f29775h;
    }

    public void setPushInterval(long j) {
        this.f29775h = j;
    }
}
