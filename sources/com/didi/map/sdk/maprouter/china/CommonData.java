package com.didi.map.sdk.maprouter.china;

public class CommonData {

    /* renamed from: u */
    private static CommonData f30743u;

    /* renamed from: a */
    private String f30744a;

    /* renamed from: b */
    private int f30745b;

    /* renamed from: c */
    private double f30746c;

    /* renamed from: d */
    private double f30747d;

    /* renamed from: e */
    private double f30748e;

    /* renamed from: f */
    private double f30749f;

    /* renamed from: g */
    private double f30750g;

    /* renamed from: h */
    private double f30751h;

    /* renamed from: i */
    private int f30752i;

    /* renamed from: j */
    private String f30753j;

    /* renamed from: k */
    private String f30754k;

    /* renamed from: l */
    private String f30755l;

    /* renamed from: m */
    private String f30756m;

    /* renamed from: n */
    private String f30757n;

    /* renamed from: o */
    private String f30758o;

    /* renamed from: p */
    private String f30759p;

    /* renamed from: q */
    private String f30760q;

    /* renamed from: r */
    private int f30761r;

    /* renamed from: s */
    private int f30762s;

    /* renamed from: t */
    private int f30763t;

    public static CommonData getInstance() {
        synchronized (CommonData.class) {
            if (f30743u == null) {
                f30743u = new CommonData();
            }
        }
        return f30743u;
    }

    public String getOrderId() {
        return this.f30744a;
    }

    public void setOrderId(String str) {
        this.f30744a = str;
    }

    public int getOrderStage() {
        return this.f30745b;
    }

    public void setOrderStage(int i) {
        this.f30745b = i;
    }

    public double getStartLat() {
        return this.f30746c;
    }

    public void setStartLat(double d) {
        this.f30746c = d;
    }

    public double getStartLon() {
        return this.f30747d;
    }

    public void setStartLon(double d) {
        this.f30747d = d;
    }

    public double getDestLat() {
        return this.f30748e;
    }

    public void setDestLat(double d) {
        this.f30748e = d;
    }

    public double getDestLon() {
        return this.f30749f;
    }

    public void setDestLon(double d) {
        this.f30749f = d;
    }

    public double getGetOnLat() {
        return this.f30750g;
    }

    public void setGetOnLat(double d) {
        this.f30750g = d;
    }

    public double getGetOnLon() {
        return this.f30751h;
    }

    public void setGetOnLon(double d) {
        this.f30751h = d;
    }

    public int getBizType() {
        return this.f30752i;
    }

    public void setBizType(int i) {
        this.f30752i = i;
    }

    public String getTicket() {
        return this.f30753j;
    }

    public void setTicket(String str) {
        this.f30753j = str;
    }

    public String getDriverId() {
        return this.f30754k;
    }

    public void setDriverId(String str) {
        this.f30754k = str;
    }

    public String getTravelId() {
        return this.f30755l;
    }

    public void setTravelId(String str) {
        this.f30755l = str;
    }

    public String getLastOrderId() {
        return this.f30756m;
    }

    public void setLastOrderId(String str) {
        this.f30756m = str;
    }

    public String getCountryId() {
        return this.f30757n;
    }

    public void setCountryId(String str) {
        this.f30757n = str;
    }

    public String getClientVersion() {
        return this.f30758o;
    }

    public void setClientVersion(String str) {
        this.f30758o = str;
    }

    public String getPhoneNumber() {
        return this.f30759p;
    }

    public void setPhoneNumber(String str) {
        this.f30759p = str;
    }

    public String getRouteId() {
        return this.f30760q;
    }

    public void setRouteId(String str) {
        this.f30760q = str;
    }

    public int getTripStep() {
        return this.f30761r;
    }

    public void setTripStep(int i) {
        this.f30761r = i;
    }

    public int getMapType() {
        return this.f30762s;
    }

    public void setMapType(int i) {
        this.f30762s = i;
    }

    public int getTerminal() {
        return this.f30763t;
    }

    public void setTerminal(int i) {
        this.f30763t = i;
    }
}
