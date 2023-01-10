package com.didi.map.global.component.slideCars.api;

import com.didi.common.map.model.LatLng;
import java.util.List;

public class CarNavigatorRequest {

    /* renamed from: a */
    private String f28415a;

    /* renamed from: b */
    private String f28416b;

    /* renamed from: c */
    private LatLng f28417c;

    /* renamed from: d */
    private LatLng f28418d;

    /* renamed from: e */
    private int f28419e;

    /* renamed from: f */
    private int f28420f;

    /* renamed from: g */
    private ClientConfigParam f28421g;

    /* renamed from: h */
    private String f28422h;

    /* renamed from: i */
    private String f28423i;

    /* renamed from: j */
    private String f28424j;

    /* renamed from: k */
    private int f28425k;

    /* renamed from: l */
    private String f28426l;

    /* renamed from: m */
    private int f28427m;

    /* renamed from: n */
    private String f28428n;

    /* renamed from: o */
    private int f28429o = -1;

    /* renamed from: p */
    private List<AnyCarInfo> f28430p;

    /* renamed from: q */
    private int f28431q = -1;

    public CarNavigatorRequest(String str, String str2, ClientConfigParam clientConfigParam, LatLng latLng, int i, int i2) {
        this.f28415a = str;
        this.f28416b = str2;
        this.f28421g = clientConfigParam;
        this.f28417c = latLng;
        this.f28419e = i;
        this.f28420f = i2;
    }

    public String getProductId() {
        return this.f28415a;
    }

    public String getSdkMapType() {
        return this.f28416b;
    }

    public ClientConfigParam getClientConfigParam() {
        return this.f28421g;
    }

    public LatLng getStartPosition() {
        return this.f28417c;
    }

    public LatLng getEndPosition() {
        return this.f28418d;
    }

    public int getType() {
        return this.f28419e;
    }

    public int getOrderState() {
        return this.f28420f;
    }

    public String getXtags() {
        return this.f28422h;
    }

    public String getExtra() {
        return this.f28423i;
    }

    public String getPid() {
        return this.f28424j;
    }

    public int getCarLevel() {
        return this.f28425k;
    }

    public String getBubbleId() {
        return this.f28426l;
    }

    public String getDriverId() {
        return this.f28428n;
    }

    public void setProductId(String str) {
        this.f28415a = str;
    }

    public void setSdkMapType(String str) {
        this.f28416b = str;
    }

    public void setClientConfigParam(ClientConfigParam clientConfigParam) {
        this.f28421g = clientConfigParam;
    }

    public void setStartPosition(LatLng latLng) {
        this.f28417c = latLng;
    }

    public void setEndPosition(LatLng latLng) {
        this.f28418d = latLng;
    }

    public void setType(int i) {
        this.f28419e = i;
    }

    public void setOrderState(int i) {
        this.f28420f = i;
    }

    public void setXtags(String str) {
        this.f28422h = str;
    }

    public void setExtra(String str) {
        this.f28423i = str;
    }

    public void setPid(String str) {
        this.f28424j = str;
    }

    public void setCarLevel(int i) {
        this.f28425k = i;
    }

    public void setBubbleId(String str) {
        this.f28426l = str;
    }

    public void setDriverId(String str) {
        this.f28428n = str;
    }

    public int getOrderTab() {
        return this.f28427m;
    }

    public void setOrderTab(int i) {
        this.f28427m = i;
    }

    public List<AnyCarInfo> getAnyCarInfo() {
        return this.f28430p;
    }

    public int getAnyCarPriority() {
        return this.f28431q;
    }

    public int getIsAnyCarIntl() {
        return this.f28429o;
    }

    public void setAnyCarInfo(List<AnyCarInfo> list) {
        this.f28430p = list;
    }

    public void setAnyCarPriority(int i) {
        this.f28431q = i;
    }

    public void setIsAnyCarIntl(int i) {
        this.f28429o = i;
    }
}
