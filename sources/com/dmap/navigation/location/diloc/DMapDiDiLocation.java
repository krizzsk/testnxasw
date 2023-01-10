package com.dmap.navigation.location.diloc;

import android.os.Bundle;
import com.didi.map.outer.model.LatLng;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.dmap.navigation.base.location.INaviLocation;
import com.dmap.navigation.simple.SimpleLatlng;

public class DMapDiDiLocation implements INaviLocation {

    /* renamed from: a */
    private DIDILocation f54578a;

    /* renamed from: b */
    private INaviLocation.NaviSource f54579b = INaviLocation.NaviSource.UNKNOWN;

    /* renamed from: c */
    private final SimpleLatlng f54580c;

    public DMapDiDiLocation(DIDILocation dIDILocation) {
        this.f54578a = dIDILocation;
        this.f54580c = new SimpleLatlng(dIDILocation.getLatitude(), dIDILocation.getLongitude());
    }

    public LatLng getLatLng() {
        return this.f54580c;
    }

    public float getAngle() {
        return this.f54578a.getBearing();
    }

    public float getAccuracy() {
        return this.f54578a.getAccuracy();
    }

    public float getVelocity() {
        return this.f54578a.getSpeed();
    }

    public INaviLocation.NaviSource getNaviSource() {
        return this.f54579b;
    }

    public void setNaviSource(INaviLocation.NaviSource naviSource) {
        this.f54579b = naviSource;
    }

    public long getGpsTime() {
        return (long) ((int) (this.f54578a.getTime() / 1000));
    }

    public long getPhoneTime() {
        return this.f54578a.getLocalTime();
    }

    public int getGpsProvider() {
        if (this.f54578a.getSource().equals("flp-vdr")) {
            return 1;
        }
        return this.f54578a.getSource().equals(DIDILocation.SOURCE_FLP_INERTIAL) ? 2 : -1;
    }

    public String getGpsSource() {
        return this.f54578a.getSource();
    }

    public String getProvider() {
        return this.f54578a.getProvider();
    }

    public float getFlpBearing() {
        Bundle extra = this.f54578a.getExtra();
        if (extra != null) {
            return extra.getFloat(DIDILocation.EXTRA_KEY_FLP_VDR_BEARING, -1.0f);
        }
        return -1.0f;
    }

    public float getFlpConfidence() {
        Bundle extra = this.f54578a.getExtra();
        if (extra != null) {
            return extra.getFloat(DIDILocation.EXTRA_KEY_FLP_VDR_BEARING_CONFIDENCE, -1.0f);
        }
        return -1.0f;
    }

    public int getFlpStatus() {
        Bundle extra = this.f54578a.getExtra();
        if (extra != null) {
            return extra.getInt(DIDILocation.EXTRA_KEY_FLP_STATIC_STATUS, -1);
        }
        return -1;
    }

    public int getVdrConf() {
        Bundle extra = this.f54578a.getExtra();
        if (extra != null) {
            return extra.getInt(DIDILocation.EXTRA_KEY_FLP_VDR_CONFIDENCE_4USE, -1);
        }
        return -1;
    }

    public String getFlpExt() {
        Bundle extra = this.f54578a.getExtra();
        if (extra != null) {
            return extra.getString(DIDILocation.EXTRA_KEY_FLP_STRATEGY, "");
        }
        return "";
    }

    public int getSatellitesNum() {
        Bundle extra = this.f54578a.getExtra();
        if (extra != null) {
            return extra.getInt(DIDILocation.EXTRA_KEY_FIX_LOC_SATELLITE_NUM, -1);
        }
        return -1;
    }

    public String toString() {
        return "DMapDiDiLocation{location=" + this.f54578a + ", source=" + this.f54579b + '}';
    }
}
