package com.didichuxing.bigdata.p174dp.locsdk;

import android.location.Location;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.OSLocationWrapper */
public class OSLocationWrapper {
    public static final int GPS_SOURCE_TYPE_CALLBACK = 0;
    public static final int GPS_SOURCE_TYPE_LAST_LOCATION = 1;

    /* renamed from: a */
    private Location f48369a;

    /* renamed from: b */
    private long f48370b;

    /* renamed from: c */
    private int f48371c = -1;

    public int getGpsSourceType() {
        return this.f48371c;
    }

    public void setGpsSourceType(int i) {
        this.f48371c = i;
    }

    public OSLocationWrapper(Location location, long j) {
        this.f48369a = location;
        this.f48370b = j;
    }

    public Location getLocation() {
        return this.f48369a;
    }

    public void setLocation(Location location) {
        this.f48369a = location;
    }

    public long getLocalTime() {
        return this.f48370b;
    }

    public void setLocalTime(long j) {
        this.f48370b = j;
    }

    public String info() {
        if (this.f48369a == null) {
            return "";
        }
        return Const.joLeft + Const.formatDouble(this.f48369a.getLongitude(), 6) + "," + Const.formatDouble(this.f48369a.getLatitude(), 6) + "," + this.f48369a.getAccuracy() + "," + this.f48369a.getBearing() + "," + this.f48369a.getTime() + "," + this.f48369a.getSpeed() + "," + "nlp" + "," + "}";
    }
}
