package com.didi.map.global.flow.scene;

import com.didi.common.map.model.LatLng;
import com.didi.map.global.component.slideCars.api.AnyCarInfo;
import com.didi.map.global.component.slideCars.model.ICarBitmapDescriptor;
import java.util.List;

public class CarSlidingParam {

    /* renamed from: a */
    private ICarBitmapDescriptor f28797a;

    /* renamed from: b */
    private String f28798b;

    /* renamed from: c */
    private String f28799c;

    /* renamed from: d */
    private int f28800d;

    /* renamed from: e */
    private int f28801e;

    /* renamed from: f */
    private int f28802f;

    /* renamed from: g */
    private String f28803g;

    /* renamed from: h */
    private String f28804h;

    /* renamed from: i */
    private int f28805i;

    /* renamed from: j */
    private String f28806j;

    /* renamed from: k */
    private String f28807k;

    /* renamed from: l */
    private int f28808l;

    /* renamed from: m */
    private String f28809m;

    /* renamed from: n */
    private int f28810n = -1;

    /* renamed from: o */
    private List<AnyCarInfo> f28811o;

    /* renamed from: p */
    private int f28812p = -1;

    /* renamed from: q */
    private LatLng f28813q;

    /* renamed from: r */
    private String f28814r;

    /* renamed from: s */
    private String f28815s;

    /* renamed from: t */
    private String f28816t;

    /* renamed from: u */
    private String f28817u;

    /* renamed from: v */
    private Long f28818v;

    public CarSlidingParam(ICarBitmapDescriptor iCarBitmapDescriptor, String str, String str2, int i, int i2, String str3, String str4, String str5, String str6, int i3, String str7) {
        this.f28797a = iCarBitmapDescriptor;
        this.f28798b = str;
        this.f28799c = str2;
        this.f28800d = i;
        this.f28801e = i2;
        this.f28803g = str3;
        this.f28804h = str4;
        this.f28806j = str5;
        this.f28807k = str6;
        this.f28808l = i3;
        this.f28809m = str7;
    }

    public CarSlidingParam(ICarBitmapDescriptor iCarBitmapDescriptor, int i, int i2, String str, String str2, int i3, String str3) {
        this.f28797a = iCarBitmapDescriptor;
        this.f28800d = i;
        this.f28801e = i2;
        this.f28806j = str;
        this.f28807k = str2;
        this.f28808l = i3;
        this.f28809m = str3;
    }

    public ICarBitmapDescriptor getBitmap() {
        return this.f28797a;
    }

    public String getProductId() {
        return this.f28798b;
    }

    public String getSdkMapType() {
        return this.f28799c;
    }

    public int getType() {
        return this.f28800d;
    }

    public void setBitmap(ICarBitmapDescriptor iCarBitmapDescriptor) {
        this.f28797a = iCarBitmapDescriptor;
    }

    public void setProductId(String str) {
        this.f28798b = str;
    }

    public void setSdkMapType(String str) {
        this.f28799c = str;
    }

    public void setType(int i) {
        this.f28800d = i;
    }

    public void setOrderState(int i) {
        this.f28801e = i;
    }

    public void setLocale(String str) {
        this.f28803g = str;
    }

    public void setMapType(String str) {
        this.f28804h = str;
    }

    public void setIdfa(String str) {
        this.f28806j = str;
    }

    public void setOriginId(String str) {
        this.f28807k = str;
    }

    public void setMixFlag(int i) {
        this.f28808l = i;
    }

    public void setA3Token(String str) {
        this.f28809m = str;
    }

    public int getOrderState() {
        return this.f28801e;
    }

    public int getCarLevel() {
        return this.f28802f;
    }

    public void setCarLevel(int i) {
        this.f28802f = i;
    }

    public String getLocale() {
        return this.f28803g;
    }

    public String getMapType() {
        return this.f28804h;
    }

    public String getIdfa() {
        return this.f28806j;
    }

    public String getOriginId() {
        return this.f28807k;
    }

    public int getMixFlag() {
        return this.f28808l;
    }

    public String getA3Token() {
        return this.f28809m;
    }

    public LatLng getEndLatLng() {
        return this.f28813q;
    }

    public void setEndLatLng(LatLng latLng) {
        this.f28813q = latLng;
    }

    public String getXtags() {
        return this.f28814r;
    }

    public void setXtags(String str) {
        this.f28814r = str;
    }

    public String getExtra() {
        return this.f28815s;
    }

    public void setExtra(String str) {
        this.f28815s = str;
    }

    public String getPid() {
        return this.f28816t;
    }

    public void setPid(String str) {
        this.f28816t = str;
    }

    public String getBubbleId() {
        return this.f28817u;
    }

    public void setBubbleId(String str) {
        this.f28817u = str;
    }

    public Long getDriverId() {
        return this.f28818v;
    }

    public void setDriverId(Long l) {
        this.f28818v = l;
    }

    public int getOrderTab() {
        return this.f28805i;
    }

    public void setOrderTab(int i) {
        this.f28805i = i;
    }

    public List<AnyCarInfo> getAnyCarInfo() {
        return this.f28811o;
    }

    public int getIsAnyCarIntl() {
        return this.f28810n;
    }

    public int getAnyCarPriority() {
        return this.f28812p;
    }

    public void setIsAnyCarIntl(int i) {
        this.f28810n = i;
    }

    public void setAnyCarPriority(int i) {
        this.f28812p = i;
    }

    public void setAnyCarInfo(List<AnyCarInfo> list) {
        this.f28811o = list;
    }

    public String toString() {
        return "CarSlidingParam{bitmap=" + this.f28797a + ", productId='" + this.f28798b + '\'' + ", sdkMapType='" + this.f28799c + '\'' + ", type=" + this.f28800d + ", orderState=" + this.f28801e + ", carLevel=" + this.f28802f + ", locale='" + this.f28803g + '\'' + ", mapType='" + this.f28804h + '\'' + ", orderTab=" + this.f28805i + ", idfa='" + this.f28806j + '\'' + ", originId='" + this.f28807k + '\'' + ", mixFlag=" + this.f28808l + ", a3Token='" + this.f28809m + '\'' + ", isAnyCarIntl=" + this.f28810n + ", anyCarInfo=" + this.f28811o + ", anyCarPriority=" + this.f28812p + ", endLatLng=" + this.f28813q + ", xtags='" + this.f28814r + '\'' + ", extra='" + this.f28815s + '\'' + ", pid='" + this.f28816t + '\'' + ", bubbleId='" + this.f28817u + '\'' + ", driverId=" + this.f28818v + '}';
    }
}
