package com.didi.payment.base.utils;

import android.content.Context;
import android.text.TextUtils;
import com.didi.payment.base.exts.ApplicationContextProvider;
import com.didi.payment.base.proxy.CommonProxyHolder;
import com.didi.sdk.fastframe.util.CollectionUtil;
import com.didi.sdk.util.TextUtil;
import java.util.HashMap;
import java.util.Map;

public class WalletCommonParamsUtil {

    /* renamed from: a */
    private static final String f32477a = "com.taxis99";

    /* renamed from: b */
    private static final String f32478b = "com.xiaojukeji.didi.brazil.customer";

    /* renamed from: c */
    private static final String f32479c = "com.app99.driver";

    /* renamed from: d */
    private static final String f32480d = "com.pay99.wallet";

    /* renamed from: e */
    private static final String f32481e = "com.didiglobal.passenger";

    /* renamed from: f */
    private static final String f32482f = "com.xiaojukeji.didi.global.customer";

    /* renamed from: g */
    private static final String f32483g = "com.didiglobal.driver";

    /* renamed from: h */
    private static Map<String, Object> f32484h = null;

    /* renamed from: i */
    private static int f32485i = -1;

    public static String getCommonParamWithCache(Context context, String str, String str2) {
        Object commonParamWithCache = getCommonParamWithCache(context, str);
        return (commonParamWithCache == null || TextUtil.isEmpty(commonParamWithCache.toString())) ? str2 : commonParamWithCache.toString();
    }

    public static Object getCommonParamWithCache(Context context, String str) {
        if (context == null || TextUtil.isEmpty(str)) {
            return null;
        }
        Object a = m24626a(str);
        if (a != null) {
            return a;
        }
        Object commonParam = getCommonParam(context, str);
        if (commonParam == null) {
            return null;
        }
        m24627a(str, commonParam);
        return commonParam;
    }

    /* renamed from: a */
    private static Object m24626a(String str) {
        if (f32484h == null) {
            f32484h = new HashMap();
        }
        return f32484h.get(str);
    }

    /* renamed from: a */
    private static void m24627a(String str, Object obj) {
        if (f32484h == null) {
            f32484h = new HashMap();
        }
        f32484h.put(str, obj);
    }

    public static HashMap<String, Object> getAllParams(Context context) {
        if (context == null) {
            return new HashMap<>();
        }
        CommonProxyHolder.ICommonProxy proxy = CommonProxyHolder.getProxy();
        if (proxy == null) {
            return new HashMap<>();
        }
        return proxy.getBaseParams(context);
    }

    public static Object getCommonParam(Context context, String str) {
        CommonProxyHolder.ICommonProxy proxy;
        if (context == null || str == null || (proxy = CommonProxyHolder.getProxy()) == null) {
            return null;
        }
        if (str.equals("terminal_id")) {
            return proxy.getTerminalId(context);
        }
        HashMap<String, Object> baseParams = proxy.getBaseParams(context);
        if (CollectionUtil.isEmpty((Map) baseParams)) {
            return null;
        }
        return baseParams.get(str);
    }

    public static boolean isDriverClient() {
        String packageName = ApplicationContextProvider.Companion.getContext().getPackageName();
        return m24628a(packageName, f32483g) || m24628a(packageName, "com.app99.driver");
    }

    public static boolean isBrazilDriverClient() {
        return m24628a(ApplicationContextProvider.Companion.getContext().getPackageName(), "com.app99.driver");
    }

    public static boolean isGlobalDriverClient() {
        return m24628a(ApplicationContextProvider.Companion.getContext().getPackageName(), f32483g);
    }

    /* renamed from: a */
    private static boolean m24628a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (TextUtils.equals(str, str2) || str.startsWith(str2)) {
            return true;
        }
        return false;
    }

    public static boolean isPassengerClient() {
        String packageName = ApplicationContextProvider.Companion.getContext().getPackageName();
        return m24628a(packageName, f32481e) || m24628a(packageName, "com.taxis99");
    }

    public static boolean isPassengerBrazilClient() {
        return m24628a(ApplicationContextProvider.Companion.getContext().getPackageName(), "com.taxis99");
    }

    public static boolean isPassengerGlobalClient() {
        return m24628a(ApplicationContextProvider.Companion.getContext().getPackageName(), f32483g);
    }

    public static boolean is99PayClient() {
        return m24628a(ApplicationContextProvider.Companion.getContext().getPackageName(), f32480d);
    }

    public static boolean isSodaClient() {
        String packageName = ApplicationContextProvider.Companion.getContext().getPackageName();
        return m24628a(packageName, f32482f) || m24628a(packageName, f32478b);
    }

    public static boolean isSodaBrazilClient() {
        return m24628a(ApplicationContextProvider.Companion.getContext().getPackageName(), f32478b);
    }

    public static String getCountry(Context context) {
        Object commonParam = getCommonParam(context, "country");
        if (commonParam == null) {
            return "";
        }
        return commonParam.toString();
    }

    public static String getUID(Context context) {
        Object commonParam = getCommonParam(context, "uid");
        if (commonParam == null) {
            return "";
        }
        return commonParam.toString();
    }

    public static String getTerminalId(Context context) {
        Object commonParam = getCommonParam(context, "terminal_id");
        if (commonParam == null) {
            return "";
        }
        return commonParam.toString();
    }

    public static String getLang(Context context) {
        Object commonParam = getCommonParam(context, "lang");
        if (commonParam == null) {
            return "";
        }
        return commonParam.toString();
    }

    public static String getLat(Context context) {
        Object commonParam = getCommonParam(context, "lat");
        if (commonParam == null) {
            return "";
        }
        return commonParam.toString();
    }

    public static String getLng(Context context) {
        Object commonParam = getCommonParam(context, "lng");
        if (commonParam == null) {
            return "";
        }
        return commonParam.toString();
    }

    public static String getIP(Context context) {
        Object commonParam = getCommonParam(context, "ip");
        if (commonParam == null) {
            return "";
        }
        return commonParam.toString();
    }

    public static String getToken(Context context) {
        Object commonParam = getCommonParam(context, "token");
        if (commonParam == null) {
            return "";
        }
        return commonParam.toString();
    }

    public static String getPhone(Context context) {
        Object commonParam = getCommonParam(context, "phone");
        if (commonParam == null) {
            return "";
        }
        return commonParam.toString();
    }

    public static int getClientId() {
        int i = f32485i;
        if (i != -1) {
            return i;
        }
        String packageName = ApplicationContextProvider.Companion.getContext().getPackageName();
        if (m24628a(packageName, "com.taxis99")) {
            f32485i = 1;
        } else if (m24628a(packageName, f32481e)) {
            f32485i = 2;
        } else if (m24628a(packageName, "com.app99.driver")) {
            f32485i = 3;
        } else if (m24628a(packageName, f32483g)) {
            f32485i = 4;
        } else if (m24628a(packageName, f32480d)) {
            f32485i = 5;
        } else if (m24628a(packageName, f32478b)) {
            f32485i = 6;
        } else if (m24628a(packageName, f32482f)) {
            f32485i = 7;
        }
        return f32485i;
    }
}
