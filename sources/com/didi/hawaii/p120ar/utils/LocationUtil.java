package com.didi.hawaii.p120ar.utils;

import android.content.Context;
import com.didi.hawaii.p120ar.jni.DARCGPSData;
import com.didi.hawaii.p120ar.jni.DARCGeoPoint;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationListener;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationManager;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationUpdateOption;
import com.didichuxing.bigdata.p174dp.locsdk.ErrInfo;

/* renamed from: com.didi.hawaii.ar.utils.LocationUtil */
public class LocationUtil {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static GpscurLocation f25576a = new GpscurLocation();

    /* renamed from: b */
    private static DIDILocationListener f25577b = new DIDILocationListener() {
        public void onLocationError(int i, ErrInfo errInfo) {
        }

        public void onStatusUpdate(String str, int i, String str2) {
        }

        public void onLocationChanged(DIDILocation dIDILocation) {
            LocationUtil.f25576a.longitude = dIDILocation.getLongitude();
            LocationUtil.f25576a.latitude = dIDILocation.getLatitude();
            LocationUtil.f25576a.time = dIDILocation.getTime();
            LocationUtil.f25576a.accuracy = dIDILocation.getAccuracy();
            LocationUtil.f25576a.altitude = dIDILocation.getAltitude();
            LocationUtil.f25576a.direction = dIDILocation.getBearing();
            LocationUtil.f25576a.provider = dIDILocation.getProvider();
            LocationUtil.f25576a.velocity = dIDILocation.getSpeed();
            LocationUtil.f25576a.localTime = dIDILocation.getLocalTime();
            if (LocationUtil.f25578c != null) {
                LocationUtil.f25578c.onLocationChanged(LocationUtil.f25576a);
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static NotifyLocationListener f25578c = null;

    /* renamed from: com.didi.hawaii.ar.utils.LocationUtil$GpscurLocation */
    public static class GpscurLocation {
        public float accuracy = 0.0f;
        public double altitude = 0.0d;
        public float direction = -1.0f;
        public double latitude = 0.0d;
        public long localTime = -1;
        public double longitude = 0.0d;
        public String provider = "";
        public long time = 0;
        public float velocity = 0.0f;
    }

    /* renamed from: com.didi.hawaii.ar.utils.LocationUtil$NotifyLocationListener */
    public interface NotifyLocationListener {
        void onLocationChanged(GpscurLocation gpscurLocation);
    }

    public static void startGetLocation(Context context) {
        DIDILocationUpdateOption defaultLocationUpdateOption = DIDILocationManager.getInstance(context).getDefaultLocationUpdateOption();
        defaultLocationUpdateOption.setModuleKey("ar");
        DIDILocationManager.getInstance(context).requestLocationUpdates(f25577b, defaultLocationUpdateOption);
    }

    public static void stopGetLocation(Context context) {
        DIDILocationManager.getInstance(context).removeLocationUpdates(f25577b);
    }

    public static void setNotifyLocationListener(NotifyLocationListener notifyLocationListener) {
        f25578c = notifyLocationListener;
    }

    public static DARCGPSData getCurLocation2DARCGPSData() {
        DARCGPSData dARCGPSData = new DARCGPSData();
        dARCGPSData.setVerticalAccuracy((double) f25576a.accuracy);
        dARCGPSData.setHorizontalAccuracy((double) f25576a.accuracy);
        dARCGPSData.setAltitude(f25576a.altitude);
        DARCGeoPoint dARCGeoPoint = new DARCGeoPoint();
        dARCGeoPoint.setLon(f25576a.longitude);
        dARCGeoPoint.setLat(f25576a.latitude);
        dARCGPSData.setLocation(dARCGeoPoint);
        return dARCGPSData;
    }

    public static GpscurLocation DARCGPSData2Location(DARCGPSData dARCGPSData) {
        GpscurLocation gpscurLocation = new GpscurLocation();
        gpscurLocation.longitude = dARCGPSData.getLocation().getLon();
        gpscurLocation.latitude = dARCGPSData.getLocation().getLat();
        gpscurLocation.localTime = (long) dARCGPSData.getTimestamp();
        gpscurLocation.accuracy = (float) dARCGPSData.getHorizontalAccuracy();
        gpscurLocation.velocity = (float) dARCGPSData.getSpeed();
        gpscurLocation.altitude = dARCGPSData.getAltitude();
        return gpscurLocation;
    }

    public static GpscurLocation getCurLocation() {
        return f25576a;
    }
}
