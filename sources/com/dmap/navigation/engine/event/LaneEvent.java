package com.dmap.navigation.engine.event;

import android.graphics.Bitmap;
import com.didi.map.outer.model.LatLng;
import com.dmap.navigation.jni.swig.NaviLatLng;
import com.dmap.navigation.simple.SimpleLatlng;
import java.math.BigInteger;

public class LaneEvent extends NaviEvent {

    /* renamed from: a */
    private final int f54452a;

    /* renamed from: b */
    private final String f54453b;

    /* renamed from: c */
    private final String f54454c;

    /* renamed from: d */
    private final String f54455d;

    /* renamed from: e */
    private final int f54456e;

    /* renamed from: f */
    private final int f54457f;

    /* renamed from: g */
    private final BigInteger f54458g;

    /* renamed from: h */
    private final LatLng f54459h;

    /* renamed from: i */
    private final int f54460i;

    /* renamed from: j */
    private Bitmap f54461j;

    public LaneEvent(int i, String str, String str2, String str3, int i2, int i3, BigInteger bigInteger, NaviLatLng naviLatLng, int i4) {
        this.f54452a = i;
        this.f54453b = str;
        this.f54454c = str2;
        this.f54455d = str3;
        this.f54456e = i2;
        this.f54457f = i3;
        this.f54458g = bigInteger;
        this.f54459h = new SimpleLatlng(naviLatLng.getLat(), naviLatLng.getLng());
        this.f54460i = i4;
    }

    public String toString() {
        return "LaneEvent{updateType=" + this.f54452a + ", lane='" + this.f54453b + '\'' + ", flag='" + this.f54454c + '\'' + ", property='" + this.f54455d + '\'' + ", emptyCout=" + this.f54457f + ", linkId=" + this.f54458g + ", position=" + this.f54459h + ", index=" + this.f54460i + '}';
    }

    public int getUpdateType() {
        return this.f54452a;
    }

    public String getLane() {
        return this.f54453b;
    }

    public String getProperty() {
        return this.f54455d;
    }

    public String getFlag() {
        return this.f54454c;
    }

    public int getEmptyCount() {
        return this.f54457f;
    }

    public BigInteger getLinkId() {
        return this.f54458g;
    }

    public LatLng getPosition() {
        return this.f54459h;
    }

    public int getIndex() {
        return this.f54460i;
    }

    public int getTotalCount() {
        return this.f54456e;
    }

    public Bitmap getBitmap() {
        return this.f54461j;
    }

    public void setBitmap(Bitmap bitmap) {
        this.f54461j = bitmap;
    }
}
