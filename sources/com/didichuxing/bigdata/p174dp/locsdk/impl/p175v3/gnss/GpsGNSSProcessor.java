package com.didichuxing.bigdata.p174dp.locsdk.impl.p175v3.gnss;

import android.location.GnssStatus;
import android.location.LocationManager;
import com.didichuxing.bigdata.p174dp.locsdk.DLog;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.gnss.GpsGNSSProcessor */
public class GpsGNSSProcessor {

    /* renamed from: b */
    private static final String f48641b = "GpsGNSSProcessor";

    /* renamed from: a */
    LocationManager f48642a;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public OnGNSSDataListener f48643c;

    /* renamed from: d */
    private GnssStatus.Callback f48644d = new GnssStatus.Callback() {
        public void onStarted() {
            DLog.m36225d("gnss gps event started");
        }

        public void onStopped() {
            DLog.m36225d("gnss gps event stopped");
        }

        public void onFirstFix(int i) {
            DLog.m36225d("gnss gps event onFirstFix" + i);
        }

        public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            if (gnssStatus != null) {
                try {
                    GNSSData gNSSData = new GNSSData();
                    int satelliteCount = gnssStatus.getSatelliteCount();
                    gNSSData.fixedSatelliteNum = 0;
                    gNSSData.signalLevel = 0.0f;
                    for (int i = 0; i < satelliteCount; i++) {
                        if (gnssStatus.usedInFix(i)) {
                            gNSSData.fixedSatelliteNum++;
                        }
                        gNSSData.signalLevel += gnssStatus.getCn0DbHz(i);
                    }
                    DLog.m36225d("GpsGNSSProcessor GnssStatus data: " + gNSSData.toString());
                    if (GpsGNSSProcessor.this.f48643c != null) {
                        GpsGNSSProcessor.this.f48643c.onDataCallback(gNSSData);
                    }
                } catch (Exception e) {
                    DLog.m36225d("GpsGNSSProcessor onSatelliteStatusChanged exce:" + e.getMessage());
                }
            }
        }
    };

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.gnss.GpsGNSSProcessor$OnGNSSDataListener */
    public interface OnGNSSDataListener {
        void onDataCallback(GNSSData gNSSData);
    }

    public GpsGNSSProcessor(LocationManager locationManager) {
        this.f48642a = locationManager;
    }

    public void setOnGNSSDataListener(OnGNSSDataListener onGNSSDataListener) {
        this.f48643c = onGNSSDataListener;
    }

    public void start() {
        LocationManager locationManager = this.f48642a;
        if (locationManager != null) {
            try {
                locationManager.registerGnssStatusCallback(this.f48644d);
            } catch (Exception e) {
                DLog.m36225d("GpsGNSSProcessor start:" + e.getMessage());
            }
        }
    }

    public void stop() {
        LocationManager locationManager = this.f48642a;
        if (locationManager != null) {
            try {
                locationManager.unregisterGnssStatusCallback(this.f48644d);
            } catch (Exception e) {
                DLog.m36225d("GpsGNSSProcessor stop:" + e.getMessage());
            }
        }
    }
}
