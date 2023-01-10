package com.didi.sdk.util;

import android.os.Build;
import com.didi.sdk.nation.NationTypeUtil;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GlobalOmegaUtils {

    /* renamed from: a */
    private static final String f40313a = "gd_profile_setting_discountandinformation_confirm_ck";

    /* renamed from: b */
    private static final String f40314b = "gd_profile_setting_discountandinformation_switch_ck";

    /* renamed from: c */
    private static final String f40315c = "gd_profile_setting_discountandinformation_disable_ck";

    /* renamed from: d */
    private static final String f40316d = "gd_profile_setting_discountandinformation_cancel_ck";

    /* renamed from: e */
    private static final String f40317e = "gd_profile_setting_locationsharing_turnoff";

    /* renamed from: f */
    private static final String f40318f = "gd_profile_setting_locationsharing_cancel";

    /* renamed from: g */
    private static final String f40319g = "gd_profile_setting_discountandinformation_sms_switch_ck";

    /* renamed from: h */
    private static final String f40320h = "gd_profile_setting_discountandinformation_push_switch_ck";

    /* renamed from: i */
    private static final String f40321i = "gd_profile_setting_discountandinformation_email_switch_ck";

    /* renamed from: j */
    private static final String f40322j = "gd_profile_setting_locationsharing_switch_ck";

    /* renamed from: k */
    private static final String f40323k = "gd_profile_setting_discountandinformation_entrance_ck";

    /* renamed from: l */
    private static final String f40324l = "map_clock_sctx_setting_switch_ck";

    /* renamed from: m */
    private static final String f40325m = "map_clock_sctx_setting_introduction_sw";

    /* renamed from: n */
    private static final String f40326n = "map_clock_sctx_setting_introduction_ck";

    /* renamed from: o */
    private static final String f40327o = "passenger_id";

    /* renamed from: p */
    private static final String f40328p = "timestamp";

    /* renamed from: q */
    private static final String f40329q = "system_type";

    /* renamed from: r */
    private static final String f40330r = "type";
    public static Set<String> set = new HashSet();

    public static void trackEvent(String str, Map<String, Object> map) {
        m30359a(str, (String) null, map);
    }

    /* renamed from: a */
    private static void m30359a(String str, String str2, Map<String, Object> map) {
        OmegaSDKAdapter.trackEvent(str, str2, map);
    }

    public static void sendClickDiscountEntrance() {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", NationTypeUtil.getNationComponentData().getLoginInfo().getUid());
        trackEvent(f40323k, hashMap);
    }

    public static void sendClickDiscountDialogOK() {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", NationTypeUtil.getNationComponentData().getLoginInfo().getUid());
        hashMap.put("type", 1);
        trackEvent(f40313a, hashMap);
    }

    public static void sendClickDiscountDialogCancel() {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", NationTypeUtil.getNationComponentData().getLoginInfo().getUid());
        hashMap.put("type", 2);
        trackEvent(f40313a, hashMap);
    }

    public static void sendClickDiscountSwitchSMS() {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", NationTypeUtil.getNationComponentData().getLoginInfo().getUid());
        hashMap.put("type", 2);
        trackEvent(f40314b, hashMap);
    }

    public static void sendClickDiscountSwitchPush() {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", NationTypeUtil.getNationComponentData().getLoginInfo().getUid());
        hashMap.put("type", 1);
        trackEvent(f40314b, hashMap);
    }

    public static void sendClickDiscountSwitchEmail() {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", NationTypeUtil.getNationComponentData().getLoginInfo().getUid());
        hashMap.put("type", 3);
        trackEvent(f40314b, hashMap);
    }

    public static void sendClickLocationSwitchShare() {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", NationTypeUtil.getNationComponentData().getLoginInfo().getUid());
        trackEvent(f40322j, hashMap);
    }

    public static void sendClickLocationDialogOK() {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", NationTypeUtil.getNationComponentData().getLoginInfo().getUid());
        trackEvent(f40317e, hashMap);
    }

    public static void sendClickLocationDialogCancel() {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", NationTypeUtil.getNationComponentData().getLoginInfo().getUid());
        trackEvent(f40318f, hashMap);
    }

    public static void sendSettingLockScreenSwitchCheck(boolean z, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", NationTypeUtil.getNationComponentData().getLoginInfo().getUid());
        hashMap.put("timestamp", Long.valueOf(System.currentTimeMillis() / 1000));
        hashMap.put("state", Integer.valueOf(z ? 1 : 0));
        hashMap.put("system_type", Integer.valueOf(Build.VERSION.SDK_INT >= 29 ? 1 : 0));
        hashMap.put("switch_type", Integer.valueOf(i));
        trackEvent(f40324l, hashMap);
    }

    public static void sendSettingLockScreenIntroduction() {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", NationTypeUtil.getNationComponentData().getLoginInfo().getUid());
        hashMap.put("timestamp", Long.valueOf(System.currentTimeMillis() / 1000));
        trackEvent(f40325m, hashMap);
    }

    public static void sendSettingLockScreenClickIntroduction(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", NationTypeUtil.getNationComponentData().getLoginInfo().getUid());
        hashMap.put("timestamp", Long.valueOf(System.currentTimeMillis() / 1000));
        hashMap.put("type", Integer.valueOf(z ? 1 : 0));
        trackEvent(f40326n, hashMap);
    }

    public static boolean isReportOmega(String str) {
        if (GlobalApolloUtils.rule4NotReport(str)) {
            return false;
        }
        if (GlobalApolloUtils.rule1Upload(str) || GlobalApolloUtils.rule2OrderOnce(str)) {
            return true;
        }
        if (!GlobalApolloUtils.rule3LifecycleOnce(str) || set.contains(str)) {
            return false;
        }
        set.add(str);
        return true;
    }
}
