package com.didi.unifiedPay.util;

import android.content.Context;
import android.util.Pair;
import com.didi.sdk.pay.base.PayCommonParamsUtil;
import com.didi.unifiedPay.sdk.net.BaseParam;
import java.util.HashMap;
import java.util.Map;

public class UniPayParamUtil {

    /* renamed from: a */
    private static ParamProxy f47270a;

    /* renamed from: b */
    private static WebParamProxy f47271b;

    /* renamed from: c */
    private static ResourceConfigurationProxy f47272c;

    public interface ParamProxy {
        HashMap<String, Object> getCommonParam(Context context);
    }

    public interface ResourceConfigurationProxy {
        void updateConfiguration(Context context);
    }

    public interface WebParamProxy {
        HashMap<String, Object> getWebParam(Context context);
    }

    public static void init(ParamProxy paramProxy) {
        f47270a = paramProxy;
    }

    public static void initWebParam(WebParamProxy webParamProxy) {
        f47271b = webParamProxy;
    }

    public static void setResourceConfiguration(ResourceConfigurationProxy resourceConfigurationProxy) {
        f47272c = resourceConfigurationProxy;
    }

    public static HashMap<String, Object> getCommonParam(Context context) {
        ParamProxy paramProxy = f47270a;
        return paramProxy == null ? new HashMap<>() : paramProxy.getCommonParam(context);
    }

    public static boolean isTestNow() {
        return PayCommonParamsUtil.getInstance().isTestNow();
    }

    public static Map<String, Object> getWebParam(Context context) {
        WebParamProxy webParamProxy = f47271b;
        HashMap<String, Object> hashMap = webParamProxy == null ? new HashMap<>() : webParamProxy.getWebParam(context);
        return (hashMap == null || hashMap.isEmpty()) ? PayCommonParamsUtil.getInstance().getCommonParam(context) : hashMap;
    }

    public static String getLang() {
        return PayCommonParamsUtil.getInstance().getLang();
    }

    public static String getToken(Context context) {
        return PayCommonParamsUtil.getInstance().getToken(context);
    }

    public static int getStartCityId() {
        return PayCommonParamsUtil.getInstance().getStartCityId();
    }

    public static String getUid(Context context) {
        return context == null ? "" : PayCommonParamsUtil.getInstance().getUid(context);
    }

    public static int getTerminalId(Context context) {
        if (context == null) {
            return 0;
        }
        return m35187a(context, "terminal_id");
    }

    public static int getProductId(Context context) {
        if (context == null) {
            return 0;
        }
        return m35187a(context, "product_id");
    }

    public static boolean needPayWebContainer(Context context) {
        return m35187a(context, BaseParam.PARAM_USE_PAY_WEB_CONTAINER) == 1;
    }

    public static String getDeviceId(Context context) {
        return PayCommonParamsUtil.getInstance().getDeviceId(context);
    }

    public static String getUUID(Context context) {
        return PayCommonParamsUtil.getInstance().getUUID(context);
    }

    public static String getSUUID(Context context) {
        return PayCommonParamsUtil.getInstance().getSUUID(context);
    }

    public static double getLat(Context context) {
        Pair<Double, Double> lastKnownLocation = PayCommonParamsUtil.getInstance().getLastKnownLocation(context);
        if (lastKnownLocation == null) {
            return 0.0d;
        }
        return ((Double) lastKnownLocation.first).doubleValue();
    }

    public static double getLng(Context context) {
        Pair<Double, Double> lastKnownLocation = PayCommonParamsUtil.getInstance().getLastKnownLocation(context);
        if (lastKnownLocation == null) {
            return 0.0d;
        }
        return ((Double) lastKnownLocation.second).doubleValue();
    }

    public static ResourceConfigurationProxy getResourceConfigurationProxy() {
        return f47272c;
    }

    /* renamed from: a */
    private static int m35187a(Context context, String str) {
        HashMap<String, Object> commonParam = PayCommonParamsUtil.getInstance().getCommonParam(context);
        if (commonParam == null) {
            return 0;
        }
        try {
            return Integer.valueOf(String.valueOf(commonParam.get(str))).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }
}
