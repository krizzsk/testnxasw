package com.didi.sdk.developermode;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.developermode.DevModeUtil;
import com.didi.sdk.envsetbase.EnvPreferenceUtil;

public class DevModePreference {

    /* renamed from: a */
    private static final String f38575a = "app_configuration";

    /* renamed from: b */
    private static final String f38576b = "dev_environment_flag";

    /* renamed from: c */
    private static final String f38577c = "tab_mis_config_flag";

    /* renamed from: d */
    private static final String f38578d = "tab_mis_config_test_flag";

    /* renamed from: e */
    private static final String f38579e = "public_service_environment_flag";

    /* renamed from: f */
    private static final String f38580f = "side_bar_version";

    /* renamed from: g */
    private static final String f38581g = "pre_release_enable";

    /* renamed from: h */
    private static final String f38582h = "web_view_debug_enable";

    /* renamed from: i */
    private static final String f38583i = "pacific_location_flag";

    /* renamed from: j */
    private static final String f38584j = "omega_debug_flag";

    /* renamed from: k */
    private static final String f38585k = "key_default_push_ip_test";

    /* renamed from: l */
    private static final String f38586l = "key_default_push_port_test";

    /* renamed from: m */
    private static final String f38587m = "key_default_push_file_ip_test";

    /* renamed from: n */
    private static final String f38588n = "key_default_push_file_port_test";

    /* renamed from: o */
    private static final String f38589o = "key_test_common_url";

    /* renamed from: p */
    private static final String f38590p = "key_guide_help_service";

    /* renamed from: q */
    private static final String f38591q = "key_http_dns_enable_flag";

    /* renamed from: r */
    private static final String f38592r = "key_is_upload_oom_flag";

    public static String getPushIp(Context context) {
        if (m29096d(context, "key_default_push_ip_test").contains(":")) {
            return EnvPreferenceUtil.getUrl(context, "key_default_push_ip_test").getHost();
        }
        return m29096d(context, "key_default_push_ip_test");
    }

    public static void setPushIp(Context context, String str) {
        m29087a(context, "key_default_push_ip_test", str);
    }

    public static String getPushPort(Context context) {
        if (m29096d(context, "key_default_push_ip_test").contains(":")) {
            return String.valueOf(EnvPreferenceUtil.getUrl(context, "key_default_push_ip_test").getPort());
        }
        return m29096d(context, "key_default_push_port_test");
    }

    public static void setPushPort(Context context, String str) {
        m29087a(context, "key_default_push_port_test", str);
    }

    public static String getPushFileIp(Context context) {
        return m29096d(context, "key_default_push_file_ip_test");
    }

    public static void setPushFileIp(Context context, String str) {
        m29087a(context, "key_default_push_file_ip_test", str);
    }

    public static String getPushFilePort(Context context) {
        return m29096d(context, "key_default_push_file_port_test");
    }

    public static void setPushFilePort(Context context, String str) {
        m29087a(context, "key_default_push_file_port_test", str);
    }

    public static String getCommonApiUrl(Context context) {
        return m29096d(context, f38589o);
    }

    public static void setCommonApiUrl(Context context, String str) {
        m29087a(context, f38589o, str);
    }

    public static String getHelpServiceHelp(Context context) {
        return m29096d(context, f38590p);
    }

    public static void setHelpServiceUrl(Context context, String str) {
        m29087a(context, f38590p, str);
    }

    public static int getDevEnvironmentFlag(Context context) {
        return m29090b(context, "dev_environment_flag", DevModeUtil.DevEnvironment.RELEASE.ordinal());
    }

    public static void setDevEnvironmentFlag(Context context, int i) {
        m29085a(context, "dev_environment_flag", i);
    }

    public static boolean getMisConfigFlag(Context context) {
        return m29094b(context, f38577c, true);
    }

    public static void setMisConfigFlag(Context context, boolean z) {
        m29088a(context, f38577c, z);
    }

    public static boolean getMisConfigTestFlag(Context context) {
        return m29094b(context, f38578d, false);
    }

    public static void setMisConfigTestFlag(Context context, boolean z) {
        m29088a(context, f38578d, z);
    }

    public static void setPublicServiceEnviornmentFlag(Context context, boolean z) {
        m29088a(context, f38579e, z);
    }

    public static void setSideBarSwitchFlag(Context context, boolean z) {
        m29088a(context, f38580f, z);
    }

    public static void setPreEnabble(Context context, boolean z) {
        m29088a(context, f38581g, z);
    }

    public static boolean getPreEnable(Context context) {
        return m29094b(context, f38581g, false);
    }

    public static void setWebViewDebugEnabble(Context context, boolean z) {
        m29088a(context, f38582h, z);
    }

    public static boolean getWebViewDebugEnable(Context context) {
        return m29094b(context, f38582h, false);
    }

    public static void setPacificSwitchFlag(Context context, boolean z) {
        m29088a(context, f38583i, z);
    }

    public static void setOmegaSDKDebugFlag(Context context, boolean z) {
        m29088a(context, f38584j, z);
    }

    public static boolean getOmegaSDKDebugFlag(Context context) {
        return m29094b(context, f38584j, false);
    }

    public static void setIsUploadoomFlag(Context context, boolean z) {
        m29088a(context, f38592r, z);
    }

    public static boolean getIsUploadoomFlag(Context context) {
        return m29094b(context, f38592r, true);
    }

    public static boolean getPublicServiceEnvironmentFlag(Context context) {
        return m29094b(context, f38579e, true);
    }

    public static boolean getPacificSwitchFlag(Context context) {
        return m29094b(context, f38583i, false);
    }

    public static boolean getCountrySwitchFlag(Context context) {
        return m29094b(context, f38580f, true);
    }

    public static boolean getHttpDnsEnable(Context context) {
        return m29094b(context, f38591q, true);
    }

    public static void setHttpDnsEnable(Context context, boolean z) {
        m29088a(context, f38591q, z);
    }

    /* renamed from: a */
    private static SharedPreferences m29083a(Context context) {
        return SystemUtils.getSharedPreferences(context, f38575a, 0);
    }

    public static void clear(Context context) {
        m29083a(context).edit().clear().apply();
    }

    /* renamed from: a */
    private static void m29085a(Context context, String str, int i) {
        m29083a(context).edit().putInt(str, i).apply();
    }

    /* renamed from: a */
    private static void m29086a(Context context, String str, long j) {
        m29083a(context).edit().putLong(str, j).apply();
    }

    /* renamed from: a */
    private static void m29084a(Context context, String str, float f) {
        m29083a(context).edit().putFloat(str, f).apply();
    }

    /* renamed from: a */
    private static void m29087a(Context context, String str, String str2) {
        m29083a(context).edit().putString(str, str2).apply();
    }

    /* renamed from: a */
    private static void m29088a(Context context, String str, boolean z) {
        m29083a(context).edit().putBoolean(str, z).apply();
    }

    /* renamed from: a */
    private static int m29082a(Context context, String str) {
        return m29083a(context).getInt(str, 0);
    }

    /* renamed from: b */
    private static long m29091b(Context context, String str) {
        return m29083a(context).getLong(str, 0);
    }

    /* renamed from: c */
    private static float m29095c(Context context, String str) {
        return m29083a(context).getFloat(str, 0.0f);
    }

    /* renamed from: d */
    private static String m29096d(Context context, String str) {
        return m29083a(context).getString(str, "");
    }

    /* renamed from: e */
    private static boolean m29097e(Context context, String str) {
        return m29083a(context).getBoolean(str, false);
    }

    /* renamed from: b */
    private static int m29090b(Context context, String str, int i) {
        return m29083a(context).getInt(str, i);
    }

    /* renamed from: b */
    private static long m29092b(Context context, String str, long j) {
        return m29083a(context).getLong(str, j);
    }

    /* renamed from: b */
    private static float m29089b(Context context, String str, float f) {
        return m29083a(context).getFloat(str, f);
    }

    /* renamed from: b */
    private static String m29093b(Context context, String str, String str2) {
        return m29083a(context).getString(str, str2);
    }

    /* renamed from: b */
    private static boolean m29094b(Context context, String str, boolean z) {
        return m29083a(context).getBoolean(str, z);
    }
}
