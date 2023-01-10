package com.dmap.navigation.engine.simple;

import com.didi.map.outer.model.LatLng;
import com.dmap.navigation.base.location.INaviLocation;
import com.dmap.navigation.jni.swig.NaviLocation;
import com.dmap.navigation.simple.SimpleLatlng;
import java.math.BigInteger;

public class SimpleLocation implements INaviLocation {

    /* renamed from: a */
    private final LatLng f54540a;

    /* renamed from: b */
    private final float f54541b;

    /* renamed from: c */
    private final float f54542c;

    /* renamed from: d */
    private final float f54543d;

    /* renamed from: e */
    private final float f54544e;

    /* renamed from: f */
    private final float f54545f;

    /* renamed from: g */
    private final int f54546g;

    /* renamed from: h */
    private final INaviLocation.NaviSource f54547h;

    /* renamed from: i */
    private final int f54548i;

    /* renamed from: j */
    private final int f54549j;

    /* renamed from: k */
    private final String f54550k;

    /* renamed from: l */
    private final int f54551l;

    /* renamed from: m */
    private final BigInteger f54552m;

    /* renamed from: n */
    private final BigInteger f54553n;

    /* renamed from: o */
    private final String f54554o;

    /* renamed from: p */
    private final String f54555p;

    public void setNaviSource(INaviLocation.NaviSource naviSource) {
    }

    public SimpleLocation(NaviLocation naviLocation) {
        this.f54540a = new SimpleLatlng(naviLocation.getLatLng().getLat(), naviLocation.getLatLng().getLng());
        this.f54541b = naviLocation.getAngle();
        this.f54542c = naviLocation.getAccuracy();
        this.f54543d = naviLocation.getVelocity();
        this.f54544e = naviLocation.getFlpBearing();
        this.f54545f = naviLocation.getFlpConfidence();
        this.f54546g = naviLocation.getFlpStatus();
        int naviSource = naviLocation.getNaviSource();
        if (INaviLocation.NaviSource.ORIGINAL.getValue() == naviSource) {
            this.f54547h = INaviLocation.NaviSource.ORIGINAL;
        } else if (INaviLocation.NaviSource.VIRTUAL.getValue() == naviSource) {
            this.f54547h = INaviLocation.NaviSource.VIRTUAL;
        } else if (INaviLocation.NaviSource.VIRTUAL_WEAK.getValue() == naviSource) {
            this.f54547h = INaviLocation.NaviSource.VIRTUAL_WEAK;
        } else {
            this.f54547h = INaviLocation.NaviSource.UNKNOWN;
        }
        this.f54548i = naviLocation.getGpsProvider();
        this.f54549j = naviLocation.getVdrConf();
        this.f54550k = naviLocation.getFlpExt();
        this.f54551l = naviLocation.getSatellitesNum();
        this.f54552m = naviLocation.getGpsTime();
        this.f54553n = naviLocation.getPhoneTime();
        this.f54554o = naviLocation.getGpsSource();
        this.f54555p = "gps";
    }

    public SimpleLocation(LatLng latLng) {
        this.f54540a = latLng;
        this.f54541b = 0.0f;
        this.f54542c = 0.0f;
        this.f54543d = 0.0f;
        this.f54544e = 0.0f;
        this.f54545f = 0.0f;
        this.f54546g = 0;
        this.f54547h = INaviLocation.NaviSource.VIRTUAL;
        this.f54548i = -1;
        this.f54549j = 0;
        this.f54550k = "";
        this.f54551l = 0;
        this.f54552m = BigInteger.valueOf(System.currentTimeMillis());
        this.f54553n = BigInteger.valueOf(System.currentTimeMillis());
        this.f54554o = "gps";
        this.f54555p = "gps";
    }

    public String toString() {
        return "SimpleLocation{latLng=" + this.f54540a + ", angle=" + this.f54541b + ", accuracy=" + this.f54542c + ", velocity=" + this.f54543d + ", flpBearing=" + this.f54544e + ", flpConfidence=" + this.f54545f + ", flpStatus=" + this.f54546g + ", naviSource=" + this.f54547h + ", gpsProvider=" + this.f54548i + ", vdrConf=" + this.f54549j + ", flpExt='" + this.f54550k + '\'' + ", satellitesNum=" + this.f54551l + ", gpsTime=" + this.f54552m + ", phoneTime=" + this.f54553n + ", gpsSource='" + this.f54554o + '\'' + '}';
    }

    public LatLng getLatLng() {
        return this.f54540a;
    }

    public float getAngle() {
        return this.f54541b;
    }

    public float getAccuracy() {
        return this.f54542c;
    }

    public float getVelocity() {
        return this.f54543d;
    }

    public float getFlpBearing() {
        return this.f54544e;
    }

    public float getFlpConfidence() {
        return this.f54545f;
    }

    public int getFlpStatus() {
        return this.f54546g;
    }

    public INaviLocation.NaviSource getNaviSource() {
        return this.f54547h;
    }

    public int getGpsProvider() {
        return this.f54548i;
    }

    public int getVdrConf() {
        return this.f54549j;
    }

    public String getFlpExt() {
        return this.f54550k;
    }

    public int getSatellitesNum() {
        return this.f54551l;
    }

    public long getGpsTime() {
        return this.f54552m.longValue();
    }

    public long getPhoneTime() {
        return this.f54553n.longValue();
    }

    public String getGpsSource() {
        return this.f54554o;
    }

    public String getProvider() {
        return this.f54555p;
    }
}
