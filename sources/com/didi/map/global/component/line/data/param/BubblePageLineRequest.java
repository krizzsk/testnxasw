package com.didi.map.global.component.line.data.param;

import com.didi.common.map.model.LatLng;
import com.didi.map.sdk.proto.driver_gl.EpfOrderType;
import com.didichuxing.routesearchsdk.CallFrom;
import java.util.List;

public class BubblePageLineRequest extends BaseLineRequest {

    /* renamed from: a */
    private LatLng f28071a;

    /* renamed from: b */
    private int f28072b;

    /* renamed from: c */
    private LatLng f28073c;

    /* renamed from: d */
    private int f28074d;

    /* renamed from: e */
    private List<LatLng> f28075e;

    /* renamed from: f */
    private EpfOrderType f28076f;

    /* renamed from: g */
    private String f28077g;

    /* renamed from: h */
    private int f28078h;

    public BubblePageLineRequest(CallFrom callFrom, String str) {
        super(callFrom, str);
    }

    public BubblePageLineRequest(CallFrom callFrom, String str, LatLng latLng, LatLng latLng2) {
        super(callFrom, str);
        this.f28071a = latLng;
        this.f28073c = latLng2;
    }

    public LatLng getStart() {
        return this.f28071a;
    }

    public void setStart(LatLng latLng) {
        this.f28071a = latLng;
    }

    public int getStartCityId() {
        return this.f28072b;
    }

    public void setStartCityId(int i) {
        this.f28072b = i;
    }

    public LatLng getEnd() {
        return this.f28073c;
    }

    public void setEnd(LatLng latLng) {
        this.f28073c = latLng;
    }

    public int getEndCityId() {
        return this.f28074d;
    }

    public void setEndCityId(int i) {
        this.f28074d = i;
    }

    public List<LatLng> getWayPoint() {
        return this.f28075e;
    }

    public void setWayPoint(List<LatLng> list) {
        this.f28075e = list;
    }

    public EpfOrderType getEpfOrderType() {
        return this.f28076f;
    }

    public void setEpfOrderType(EpfOrderType epfOrderType) {
        this.f28076f = epfOrderType;
    }

    public String getCurrentLang() {
        return this.f28077g;
    }

    public void setCurrentLang(String str) {
        this.f28077g = str;
    }

    public void setBizGroup(int i) {
        this.f28078h = i;
    }

    public int getBizGroup() {
        return this.f28078h;
    }
}
