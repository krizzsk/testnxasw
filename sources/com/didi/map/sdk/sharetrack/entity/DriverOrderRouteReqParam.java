package com.didi.map.sdk.sharetrack.entity;

public class DriverOrderRouteReqParam {
    public static final int STAGE_ON_TRIP = 4;
    public static final int STAGE_PICKUP = 1;

    /* renamed from: a */
    private String f31090a = "";

    /* renamed from: b */
    private int f31091b = 1;

    /* renamed from: c */
    private int f31092c = 260;

    /* renamed from: d */
    private int f31093d = 0;

    /* renamed from: e */
    private long f31094e = 0;

    /* renamed from: f */
    private long f31095f;

    /* renamed from: g */
    private String f31096g;

    public DriverOrderRouteReqParam() {
    }

    public DriverOrderRouteReqParam(String str, int i, int i2, int i3, long j, long j2) {
        this.f31090a = str;
        this.f31091b = i;
        this.f31092c = i2;
        this.f31093d = i3;
        this.f31094e = j;
        this.f31095f = j2;
    }

    public String getOrderId() {
        return this.f31090a;
    }

    public int getOrderStage() {
        return this.f31091b;
    }

    public int getBizType() {
        return this.f31092c;
    }

    public int getEventType() {
        return this.f31093d;
    }

    public long getTimestamp() {
        return this.f31094e;
    }

    public long getDriverId() {
        return this.f31095f;
    }

    public void setOrderId(String str) {
        this.f31090a = str;
    }

    public void setOrderStage(int i) {
        this.f31091b = i;
    }

    public void setBizType(int i) {
        this.f31092c = i;
    }

    public void setEventType(int i) {
        this.f31093d = i;
    }

    public void setTimestamp(long j) {
        this.f31094e = j;
    }

    public void setDriverId(long j) {
        this.f31095f = j;
    }

    public String getCountryId() {
        return this.f31096g;
    }

    public void setCountryId(String str) {
        this.f31096g = str;
    }
}
