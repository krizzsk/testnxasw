package com.didi.dimina.container.secondparty.jsmodule.jsbridge.location;

import android.content.Context;
import android.location.Criteria;
import com.didi.dimina.container.mina.IDMCommonAction;
import com.didi.dimina.container.util.LogUtil;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationListener;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationManager;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationUpdateOption;
import com.didichuxing.bigdata.p174dp.locsdk.ErrInfo;

public class LocationHelper {
    public static final String LOCATION_TYPE_BD09 = "bd09";
    public static final String LOCATION_TYPE_GCJ02 = "gcj02";
    public static final String LOCATION_TYPE_WGS84 = "wgs84";

    /* renamed from: a */
    private final DIDILocationManager f19081a;

    /* renamed from: b */
    private DIDILocationListener f19082b;

    public LocationHelper(Context context) {
        this.f19081a = DIDILocationManager.getInstance(context.getApplicationContext());
    }

    public boolean startLocationUpdate(String str, boolean z, long j, float f, final IDMCommonAction<DIDILocation> iDMCommonAction) {
        if (this.f19081a == null) {
            return false;
        }
        if (this.f19082b == null) {
            this.f19082b = new DIDILocationListener() {
                public void onStatusUpdate(String str, int i, String str2) {
                }

                public void onLocationChanged(DIDILocation dIDILocation) {
                    LogUtil.m16841i("onLocationChanged, new location=" + dIDILocation);
                    iDMCommonAction.callback(dIDILocation);
                }

                public void onLocationError(int i, ErrInfo errInfo) {
                    iDMCommonAction.callback(null);
                }
            };
        }
        Criteria criteria = new Criteria();
        criteria.setAltitudeRequired(false);
        criteria.setAccuracy(z ? 1 : 2);
        criteria.setPowerRequirement(3);
        try {
            DIDILocationUpdateOption dIDILocationUpdateOption = new DIDILocationUpdateOption();
            dIDILocationUpdateOption.setInterval(DIDILocationUpdateOption.IntervalMode.MORE_BATTERY_SAVE);
            this.f19081a.requestLocationUpdates(this.f19082b, dIDILocationUpdateOption);
            LogUtil.m16841i("requestLocationUpdates, minTime:" + j);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void stopLocationUpdate() {
        DIDILocationListener dIDILocationListener;
        LogUtil.m16841i("removeLocationUpdates");
        DIDILocationManager dIDILocationManager = this.f19081a;
        if (!(dIDILocationManager == null || (dIDILocationListener = this.f19082b) == null)) {
            dIDILocationManager.removeLocationUpdates(dIDILocationListener);
        }
        this.f19082b = null;
    }

    public void getOnceLocation(String str, long j, final IDMCommonAction<DIDILocation> iDMCommonAction) {
        if (this.f19081a == null) {
            iDMCommonAction.callback(null);
        }
        this.f19081a.requestLocationUpdateOnce(new DIDILocationListener() {
            public void onStatusUpdate(String str, int i, String str2) {
            }

            public void onLocationChanged(DIDILocation dIDILocation) {
                iDMCommonAction.callback(dIDILocation);
            }

            public void onLocationError(int i, ErrInfo errInfo) {
                iDMCommonAction.callback(null);
            }
        }, "dimina_location");
    }

    public DIDILocation getLastLocation(String str) {
        return this.f19081a.getLastKnownLocation();
    }
}
