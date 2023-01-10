package com.didi.map.global.component.trafficreport.util;

import android.content.Context;
import com.didi.common.map.model.LatLng;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationManager;

public class LocUtils {
    public static LatLng getCurrentLocation(Context context) {
        DIDILocation lastKnownLocation;
        if (context == null || (lastKnownLocation = DIDILocationManager.getInstance(context).getLastKnownLocation()) == null) {
            return null;
        }
        return new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude());
    }
}
