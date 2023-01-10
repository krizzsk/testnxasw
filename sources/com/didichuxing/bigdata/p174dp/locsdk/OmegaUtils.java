package com.didichuxing.bigdata.p174dp.locsdk;

import com.android.didi.bfflib.business.BffNetConstant;
import com.didichuxing.omega.sdk.common.record.Event;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.OmegaUtils */
public class OmegaUtils {

    /* renamed from: a */
    private static final Random f48372a = new Random();

    /* renamed from: b */
    private static final int f48373b = ApolloProxy.getInstance().getNTPStatBasePercent();

    /* renamed from: c */
    private static final int f48374c = ApolloProxy.getInstance().getNTPStatLocPercent();

    /* renamed from: d */
    private static final int f48375d = ApolloProxy.getInstance().getLocTimeMonotonicStatPercent();

    /* renamed from: e */
    private static final int f48376e = ApolloProxy.getInstance().getLocDispatchStatPercent();

    /* renamed from: a */
    private static void m36232a(String str, long j) {
    }

    public static void trackNTPCache(boolean z, Long l) {
    }

    public static void trackNTPSync(String str, boolean z, Long l, Long l2, long j, long j2, String str2, String str3, int i, boolean z2) {
    }

    static {
        DLog.m36225d("NTP_STAT_BASE_PERCENT=" + f48373b);
        DLog.m36225d("NTP_LOC_STAT_PERCENT=" + f48374c);
        DLog.m36225d("LOCTIME_MONOTONIC_STAT_PERCENT=" + f48375d);
        DLog.m36225d("LOC_DISPATCH_STAT_PERCENT=" + f48376e);
    }

    public static void trackNTPAndMobileTimeDiff(long j) {
        if (isSampledByPercent(f48373b)) {
            m36232a("mobile", j);
        }
    }

    public static boolean isSampledByPercent(int i) {
        if (i >= 100) {
            return true;
        }
        return i > 0 && f48372a.nextInt(100) < i;
    }

    /* renamed from: a */
    private static boolean m36233a(int i) {
        if (i >= 1000) {
            return true;
        }
        return i > 0 && f48372a.nextInt(1000) < i;
    }

    public static void trackReflectError(Throwable th, String str) {
        HashMap hashMap = new HashMap();
        if (th != null) {
            hashMap.put("cls", th.getClass().getName());
            hashMap.put("msg", th.getMessage());
            if (th.getCause() != null) {
                hashMap.put("cause_cls", th.getCause().getClass().getName());
                hashMap.put("cause_msg", th.getCause().getMessage());
            }
        }
        if (str != null) {
            hashMap.put("info", str);
        }
        OmegaSDKAdapter.trackEvent("locsdk_reflect_error", (Map<String, Object>) hashMap);
    }

    public static void trackNLPOnceRespTime(long j, int i, String str, String str2, String str3) {
        Event event = new Event("tech_map_log_nlp_loc_resp_time");
        event.putAttr("last_time", Long.valueOf(j));
        event.putAttr("page", str2);
        event.putAttr("entrance", str3);
        event.putAttr(BffNetConstant.ERR_CODE, Integer.valueOf(i));
        event.putAttr("errmsg", str);
        OmegaSDKAdapter.trackEvent(event);
    }
}
