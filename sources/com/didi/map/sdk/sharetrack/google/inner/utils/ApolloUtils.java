package com.didi.map.sdk.sharetrack.google.inner.utils;

import com.didi.map.sdk.nav.inertia.ApolloParamsSctxPrediction;
import com.didi.map.sdk.sharetrack.logger.DLog;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;
import com.example.compapollovisitor.ApolloVisitHelper;

public class ApolloUtils {

    /* renamed from: a */
    private static final String f31345a = "ShareTrack || ApolloUtils";

    /* renamed from: b */
    private static IToggle f31346b = Apollo.getToggle("global_drvier_map_enable_match_mock");

    /* renamed from: c */
    private static int f31347c = 0;

    /* renamed from: d */
    private static float f31348d = 0.8f;

    /* renamed from: e */
    private static int f31349e = 10;

    /* renamed from: f */
    private static int f31350f = 0;

    /* renamed from: g */
    private static int f31351g = 300;

    /* renamed from: h */
    private static boolean f31352h = false;

    /* renamed from: i */
    private static int f31353i = 30;

    /* renamed from: j */
    private static int f31354j = 70;

    /* renamed from: k */
    private static boolean f31355k = false;

    /* renamed from: l */
    private static int f31356l = 30;

    public static int getEtaInterval(int i) {
        return 60000;
    }

    static {
        ApolloVisitHelper.getInstance().addApolloKey("global_drvier_map_enable_match_mock");
        if (f31346b.allow()) {
            IExperiment experiment = f31346b.getExperiment();
            boolean z = false;
            f31347c = ((Integer) experiment.getParam("enableMock", 0)).intValue();
            try {
                f31348d = Float.valueOf((String) experiment.getParam("coefficient", "0.8")).floatValue();
            } catch (Exception unused) {
            }
            f31349e = ((Integer) experiment.getParam("distDisableMock", 10)).intValue();
            f31350f = ((Integer) experiment.getParam("enableOmg", 0)).intValue();
            f31351g = ((Integer) experiment.getParam("startOmgDist", 300)).intValue();
            IToggle toggle = Apollo.getToggle("map_driver_route_end_unreachable");
            if (toggle != null && toggle.allow()) {
                IExperiment experiment2 = toggle.getExperiment();
                f31352h = ((Integer) experiment2.getParam("tts", 0)).intValue() == 1;
                f31353i = ((Integer) experiment2.getParam("tts_distance", 30)).intValue();
                f31354j = ((Integer) experiment2.getParam("tts_eda", 70)).intValue();
                if (((Integer) experiment2.getParam("guide_line", 0)).intValue() == 1) {
                    z = true;
                }
                f31355k = z;
                f31356l = ((Integer) experiment2.getParam("guide_line_distance", 30)).intValue();
            }
        }
    }

    public static boolean IsPickUpUploadeEnable() {
        IToggle toggle = Apollo.getToggle("global_driver_pickup_point_upload_switch");
        if (toggle == null || !toggle.allow()) {
            DLog.m23962d(f31345a, "IsPickUpUploadeEnable:false", new Object[0]);
            return false;
        }
        DLog.m23962d(f31345a, "IsPickUpUploadeEnable:true", new Object[0]);
        return true;
    }

    public static ApolloParamsSctxPrediction getSctxPredictionApolloParams() {
        ApolloParamsSctxPrediction apolloParamsSctxPrediction = new ApolloParamsSctxPrediction();
        apolloParamsSctxPrediction.enableMock = f31347c;
        apolloParamsSctxPrediction.coefficient = f31348d;
        apolloParamsSctxPrediction.distDisableMock = f31349e;
        apolloParamsSctxPrediction.enableOmg = f31350f;
        apolloParamsSctxPrediction.startOmgDist = f31351g;
        return apolloParamsSctxPrediction;
    }

    public static boolean isRetryRoute() {
        return Apollo.getToggle("map_global_driver_ora_retry").allow();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000f, code lost:
        r0 = r0.getExperiment();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isServerRejectYaw() {
        /*
            java.lang.String r0 = "global_map_match_yaw_config_toggle_new"
            com.didichuxing.apollo.sdk.IToggle r0 = com.didichuxing.apollo.sdk.Apollo.getToggle(r0)
            r1 = 0
            if (r0 == 0) goto L_0x0026
            boolean r2 = r0.allow()
            if (r2 == 0) goto L_0x0026
            com.didichuxing.apollo.sdk.IExperiment r0 = r0.getExperiment()
            if (r0 == 0) goto L_0x0026
            java.lang.Integer r2 = java.lang.Integer.valueOf(r1)
            java.lang.String r3 = "is_server_reject_yaw"
            java.lang.Object r0 = r0.getParam(r3, r2)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            goto L_0x0027
        L_0x0026:
            r0 = 0
        L_0x0027:
            if (r0 != 0) goto L_0x002a
            return r1
        L_0x002a:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.sdk.sharetrack.google.inner.utils.ApolloUtils.isServerRejectYaw():boolean");
    }

    public static int getYawModelType() {
        IExperiment experiment;
        IToggle toggle = Apollo.getToggle("global_map_match_yaw_config_toggle_new");
        if (toggle == null || !toggle.allow() || (experiment = toggle.getExperiment()) == null) {
            return 0;
        }
        return ((Integer) experiment.getParam("yaw_model_type", 0)).intValue();
    }

    public static boolean getBERTtsEnable() {
        return f31352h;
    }

    public static int getBERTtsDistance() {
        return f31353i;
    }

    public static int getBERTtsEda() {
        return f31354j;
    }

    public static boolean getBERGuideLineEnable() {
        return f31355k;
    }

    public static int getBERGuideLineDistance() {
        return f31356l;
    }
}
