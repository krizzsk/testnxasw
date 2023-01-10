package com.didi.map.global.flow.toolkit.walkdrop;

import android.content.Context;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.global.model.location.LocationHelper2;
import com.didi.map.global.model.location.LocationRegisterParam;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;

public class WalkComponentApolloUtils {

    /* renamed from: a */
    private static boolean f29764a = false;

    /* renamed from: b */
    private static int f29765b;

    /* renamed from: c */
    private static int f29766c;

    /* renamed from: d */
    private static int f29767d;

    static {
        m23077a();
    }

    /* renamed from: a */
    private static void m23077a() {
        IExperiment experiment;
        try {
            IToggle toggle = Apollo.getToggle("global_map_sctx_walkline_toggle");
            if (toggle != null && toggle.allow() && (experiment = toggle.getExperiment()) != null) {
                int intValue = ((Integer) experiment.getParam("newLineEnable", 0)).intValue();
                f29765b = ((Integer) experiment.getParam("max_distance", 0)).intValue();
                f29766c = ((Integer) experiment.getParam("min_distance", 0)).intValue();
                f29767d = ((Integer) experiment.getParam("push_interval", 0)).intValue();
                boolean z = true;
                if (intValue != 1) {
                    z = false;
                }
                f29764a = z;
                DLog.m10773d("global_map_sctx_walkline_toggle", "isEnable" + f29764a + "maxDistance" + f29765b + "minDistance" + f29766c, new Object[0]);
            }
        } catch (Exception e) {
            DLog.m10773d("global_map_sctx_walkline_toggle", e.toString(), new Object[0]);
            e.printStackTrace();
        }
    }

    public static boolean isUseNewComponent(Context context, LatLng latLng) {
        DIDILocation lastKnownLocation = LocationHelper2.getLastKnownLocation(context, LocationRegisterParam.LocType.FLP);
        LatLng latLng2 = lastKnownLocation != null ? new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude()) : null;
        if (!LatLngUtils.locateCorrect(latLng2) || !LatLngUtils.locateCorrect(latLng)) {
            return false;
        }
        double computeDistanceBetween = DDSphericalUtil.computeDistanceBetween(latLng2, latLng);
        DLog.m10773d("NewWalkLine", "distance-->" + computeDistanceBetween, new Object[0]);
        if (!f29764a || computeDistanceBetween >= ((double) f29765b) || computeDistanceBetween <= ((double) f29766c)) {
            return false;
        }
        return true;
    }

    public static int getOraPushInterval() {
        return f29767d;
    }
}
