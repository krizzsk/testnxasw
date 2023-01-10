package com.didi.map.global.component.trafficreport.util;

import android.text.TextUtils;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.global.model.omega.GlobalOmegaTracker;
import com.didi.sdk.apm.SystemUtils;
import java.util.HashMap;

public class ReportOmegaUtil {

    /* renamed from: a */
    private static final String f28617a = "ReportOmegaUtil";

    /* renamed from: b */
    private static final String f28618b = "order_id";

    /* renamed from: c */
    private static final String f28619c = "uid";

    /* renamed from: d */
    private static final String f28620d = "latitude";

    /* renamed from: e */
    private static final String f28621e = "longtitude";

    /* renamed from: f */
    private static final String f28622f = "timestamp";

    public static void trackPaxOpenOrCloseReport(String str, String str2, LatLng latLng, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && LatLngUtils.locateCorrect(latLng)) {
            HashMap hashMap = new HashMap();
            hashMap.put("order_id", str2);
            hashMap.put("uid", str);
            hashMap.put("latitude", Double.valueOf(latLng.latitude));
            hashMap.put(f28621e, Double.valueOf(latLng.longitude));
            hashMap.put("timestamp", Long.valueOf(System.currentTimeMillis()));
            hashMap.put("operation_type", str3);
            GlobalOmegaTracker.trackEvent("map_paxreport_button_ck", hashMap);
            SystemUtils.log(3, f28617a, "map_paxreport_button_ck: ", (Throwable) null, "com.didi.map.global.component.trafficreport.util.ReportOmegaUtil", 39);
        }
    }

    public static void trackPaxChooseType(String str, String str2, LatLng latLng, String str3, int i) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && LatLngUtils.locateCorrect(latLng)) {
            HashMap hashMap = new HashMap();
            hashMap.put("order_id", str2);
            hashMap.put("uid", str);
            hashMap.put("latitude", Double.valueOf(latLng.latitude));
            hashMap.put(f28621e, Double.valueOf(latLng.longitude));
            hashMap.put("timestamp", Long.valueOf(System.currentTimeMillis()));
            hashMap.put("type_list", str3);
            hashMap.put("type", Integer.valueOf(i));
            GlobalOmegaTracker.trackEvent("map_paxreport_choosetype_ck", hashMap);
            SystemUtils.log(3, f28617a, "map_paxreport_choosetype_ck: ", (Throwable) null, "com.didi.map.global.component.trafficreport.util.ReportOmegaUtil", 63);
        }
    }

    public static void trackPaxReportDetailShow(String str, String str2, LatLng latLng) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && LatLngUtils.locateCorrect(latLng)) {
            HashMap hashMap = new HashMap();
            hashMap.put("order_id", str2);
            hashMap.put("uid", str);
            hashMap.put("latitude", Double.valueOf(latLng.latitude));
            hashMap.put(f28621e, Double.valueOf(latLng.longitude));
            hashMap.put("timestamp", Long.valueOf(System.currentTimeMillis()));
            GlobalOmegaTracker.trackEvent("map_paxreport_reportdetail_sw", hashMap);
            SystemUtils.log(3, f28617a, "map_paxreport_reportdetail_sw: ", (Throwable) null, "com.didi.map.global.component.trafficreport.util.ReportOmegaUtil", 82);
        }
    }

    public static void trackPaxReportDetailCk(String str, String str2, LatLng latLng, int i, int i2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && LatLngUtils.locateCorrect(latLng)) {
            HashMap hashMap = new HashMap();
            hashMap.put("order_id", str2);
            hashMap.put("uid", str);
            hashMap.put("latitude", Double.valueOf(latLng.latitude));
            hashMap.put(f28621e, Double.valueOf(latLng.longitude));
            hashMap.put("timestamp", Long.valueOf(System.currentTimeMillis()));
            hashMap.put("text", Integer.valueOf(i));
            hashMap.put("detail", Integer.valueOf(i2));
            hashMap.put("operation_type", str3);
            GlobalOmegaTracker.trackEvent("map_paxreport_reportdetail_ck", hashMap);
            SystemUtils.log(3, f28617a, "map_paxreport_reportdetail_ck: ", (Throwable) null, "com.didi.map.global.component.trafficreport.util.ReportOmegaUtil", 108);
        }
    }

    public static void trackPaxContributionCk(String str, String str2, LatLng latLng) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && LatLngUtils.locateCorrect(latLng)) {
            HashMap hashMap = new HashMap();
            hashMap.put("order_id", str2);
            hashMap.put("uid", str);
            hashMap.put("latitude", Double.valueOf(latLng.latitude));
            hashMap.put(f28621e, Double.valueOf(latLng.longitude));
            hashMap.put("timestamp", Long.valueOf(System.currentTimeMillis()));
            GlobalOmegaTracker.trackEvent("map_paxreport_mycontribution_ck", hashMap);
            SystemUtils.log(3, f28617a, "map_paxreport_mycontribution_ck: ", (Throwable) null, "com.didi.map.global.component.trafficreport.util.ReportOmegaUtil", 127);
        }
    }
}
