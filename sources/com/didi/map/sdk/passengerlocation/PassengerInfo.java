package com.didi.map.sdk.passengerlocation;

import android.graphics.Bitmap;
import com.didi.common.map.model.GpsLocation;

public class PassengerInfo {

    /* renamed from: a */
    private String f31032a = "";

    /* renamed from: b */
    private long f31033b;

    /* renamed from: c */
    private GpsLocation f31034c = null;

    /* renamed from: d */
    private String f31035d = null;

    /* renamed from: e */
    private Bitmap f31036e = null;

    /* renamed from: f */
    private int f31037f;

    /* renamed from: g */
    private GpsLocation f31038g = null;

    /* renamed from: h */
    private String f31039h = "";

    public PassengerInfo() {
    }

    public PassengerInfo(String str, GpsLocation gpsLocation, Bitmap bitmap) {
        this.f31032a = str;
        this.f31034c = gpsLocation;
        this.f31036e = bitmap;
    }

    public PassengerInfo(String str, String str2, int i) {
        this.f31032a = str;
        this.f31037f = i;
        this.f31039h = str2;
    }

    public PassengerInfo(PassengerInfo passengerInfo) {
        if (passengerInfo != null) {
            this.f31032a = passengerInfo.getId();
            this.f31033b = passengerInfo.getPassengerId();
            this.f31034c = passengerInfo.getGpsLocation();
            this.f31035d = passengerInfo.getHeadUrl();
            this.f31036e = passengerInfo.getHeadIcon();
            this.f31037f = passengerInfo.getColorIndex();
            this.f31038g = passengerInfo.getFinalPos();
            this.f31039h = passengerInfo.getOrderId();
        }
    }

    public String getId() {
        return this.f31032a;
    }

    public void setId(String str) {
        this.f31032a = str;
    }

    public long getPassengerId() {
        return this.f31033b;
    }

    public void setPassengerId(long j) {
        this.f31033b = j;
    }

    public GpsLocation getGpsLocation() {
        return this.f31034c;
    }

    public void setGpsLocation(GpsLocation gpsLocation) {
        this.f31034c = gpsLocation;
    }

    public String getHeadUrl() {
        return this.f31035d;
    }

    public void setHeadUrl(String str) {
        this.f31035d = str;
    }

    public Bitmap getHeadIcon() {
        return this.f31036e;
    }

    public void setHeadIcon(Bitmap bitmap) {
        this.f31036e = bitmap;
    }

    public int getColorIndex() {
        return this.f31037f;
    }

    public void setColorIndex(int i) {
        this.f31037f = i;
    }

    public GpsLocation getFinalPos() {
        return this.f31038g;
    }

    public void setFinalPos(GpsLocation gpsLocation) {
        this.f31038g = gpsLocation;
    }

    public String getOrderId() {
        return this.f31039h;
    }

    public void setOrderId(String str) {
        this.f31039h = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id:" + this.f31032a);
        sb.append("|colorIndex:" + this.f31037f);
        sb.append("|oid:" + this.f31039h);
        if (this.f31034c != null) {
            sb.append("|origin.lat:" + this.f31034c.latitude);
            sb.append("|origin:lon" + this.f31034c.longitude);
        } else {
            sb.append("|origin:null");
        }
        if (this.f31038g != null) {
            sb.append("|final.lat:" + this.f31038g.latitude);
            sb.append("|final:lon" + this.f31038g.longitude);
        } else {
            sb.append("|final:null");
        }
        sb.append("|headUrl:" + this.f31035d);
        return sb.toString();
    }
}
