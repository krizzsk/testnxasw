package com.didiglobal.p205sa.biz.tracker;

import com.didi.sdk.monitor.QualityCheckTrackImpl;
import java.util.Map;

/* renamed from: com.didiglobal.sa.biz.tracker.AddressMonitorTrack */
public class AddressMonitorTrack {

    /* renamed from: a */
    private static String f53800a = "address";
    public static int mSceneCreateOrder = 12;
    public static int mSceneEstimateSugCallback = 13;
    public static int mSceneRideBackEstimate = 11;
    public static int mSceneRideDestination = 6;
    public static int mSceneRideEstimate = 10;
    public static int mSceneRideReverseGeo = 5;
    public static int mSceneRideSugcallback = 8;
    public static int mSceneRideWhereToGo = 7;
    public static int mSceneSaDestination = 2;
    public static int mSceneSaEstimate = 9;
    public static int mSceneSaReverseGeo = 1;
    public static int mSceneSaSugcallback = 4;
    public static int mSceneSaWhereToGo = 3;

    public static void adddressMonitorTrack(int i, Map<String, Object> map) {
        QualityCheckTrackImpl.trackError(f53800a, i, map);
    }
}
