package didihttpdns.toolbox;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.push.ServerParam;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import didinet.Logger;
import org.json.JSONException;
import org.json.JSONObject;

public class AppUtils {

    /* renamed from: a */
    private static String f59809a;

    /* renamed from: b */
    private static int f59810b;

    /* renamed from: c */
    private static String f59811c;

    private AppUtils() {
        throw new AssertionError();
    }

    public static int getVersionCode(Context context) {
        try {
            if (f59810b == 0) {
                f59810b = SystemUtils.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionCode;
            }
            return f59810b;
        } catch (Exception e) {
            Logger.m45047d("AppUtils", "getVersionCode: " + Log.getStackTraceString(e));
            return 0;
        }
    }

    public static String getVersionName(Context context) {
        try {
            if (TextUtils.isEmpty(f59811c)) {
                f59811c = SystemUtils.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionName;
            }
            return f59811c;
        } catch (Exception e) {
            Logger.m45047d("AppUtils", "getVersionName: " + Log.getStackTraceString(e));
            return "";
        }
    }

    public static String getDeviceId(Context context) {
        try {
            if (TextUtils.isEmpty(f59809a)) {
                f59809a = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
            }
            return f59809a;
        } catch (Exception e) {
            Logger.m45047d("AppUtils", "getDeviceId: " + Log.getStackTraceString(e));
            return "";
        }
    }

    public static String getJsonAppInfo(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("clientType", "1");
            jSONObject.put("os", "android");
            jSONObject.put("os_sdk", Build.VERSION.SDK_INT);
            jSONObject.put("device_id", getDeviceId(context));
            jSONObject.put("model", Build.MODEL);
            jSONObject.put("app_version_code", getVersionCode(context));
            jSONObject.put("app_version_name", getVersionName(context));
        } catch (JSONException e) {
            Logger.m45047d("AppUtils", "getJsonAppInfo: " + Log.getStackTraceString(e));
        }
        return jSONObject.toString();
    }

    public static String getAppInfo(Context context) {
        return "clientType" + "=" + "1" + ParamKeys.SIGN_AND + ServerParam.PARAM_DDRIVER_OSTYPE + "=" + "android" + ParamKeys.SIGN_AND + "osVersion" + "=" + Build.VERSION.SDK_INT + ParamKeys.SIGN_AND + "imei" + "=" + getDeviceId(context) + ParamKeys.SIGN_AND + "model" + "=" + Build.MANUFACTURER + "_" + Build.BRAND + "_" + Build.MODEL + ParamKeys.SIGN_AND + "appVersion" + "=" + getVersionName(context) + ParamKeys.SIGN_AND + "appVersionCode" + "=" + getVersionCode(context) + ParamKeys.SIGN_AND + "timeStamp" + "=" + System.currentTimeMillis() + ParamKeys.SIGN_AND + "packageName" + "=" + context.getPackageName();
    }
}
