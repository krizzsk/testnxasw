package com.didichuxing.gbankcard.ocr.network;

import android.content.Context;
import android.os.Build;
import com.didi.sdk.util.SystemUtil;
import com.didichuxing.dfbasesdk.data.BaseInnerResult;
import com.didichuxing.dfbasesdk.http.AbsOkHttpCallback;
import com.didichuxing.dfbasesdk.utils.AppUtils;
import com.didichuxing.dfbasesdk.utils.CheckUtils;
import com.didichuxing.dfbasesdk.utils.DFApi;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import com.didichuxing.gbankcard.ocr.BuildConfig;
import com.didichuxing.gbankcard.ocr.network.data.GuideResp;
import java.util.Map;
import org.json.JSONObject;

public class GBankcardApi {
    public static final String KEY_CLIENT_DEVICE_INFO = "clientDeviceInfo";

    /* renamed from: c */
    private static final String f50275c = "extra";

    /* renamed from: d */
    private static final String f50276d = "https://api-sec.didiglobal.com/sec/risk-gateway/common/";

    /* renamed from: e */
    private static GBankcardApi f50277e = new GBankcardApi();

    /* renamed from: a */
    private JSONObject f50278a = new JSONObject();

    /* renamed from: b */
    private String f50279b;

    private GBankcardApi() {
    }

    public static GBankcardApi getInstance() {
        return f50277e;
    }

    public void buildClientDeviceInfo(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pac", context.getPackageName());
            jSONObject.put("appVer", AppUtils.getVersionName(context));
            jSONObject.put("sdkVer", BuildConfig.VERSION_NAME);
            jSONObject.put("clientOS", "Android " + Build.VERSION.RELEASE);
            jSONObject.put("brand", Build.BRAND);
            jSONObject.put("model", SystemUtil.getModel());
        } catch (Exception e) {
            LogUtils.logStackTrace(e);
        }
        this.f50279b = jSONObject.toString();
    }

    public void addExtraInfo(String str, Object obj) {
        try {
            this.f50278a.put(str, obj);
        } catch (Exception e) {
            LogUtils.logStackTrace(e);
        }
    }

    public String getClientDeviceInfo() {
        return this.f50279b;
    }

    public void requestGuideInfo(String str, Map<String, Object> map, AbsOkHttpCallback<GuideResp> absOkHttpCallback) {
        CheckUtils.checkAssert(!map.containsKey("extra"), "biz params should not contain 'extra' key!!!");
        map.put(KEY_CLIENT_DEVICE_INFO, this.f50279b);
        map.put("extra", this.f50278a.toString());
        DFApi.postReq(m37608a(str), map, absOkHttpCallback);
    }

    /* renamed from: a */
    private String m37608a(String str) {
        return f50276d + str;
    }

    public void reportSdkData(String str, String str2, AbsOkHttpCallback<BaseInnerResult> absOkHttpCallback) {
        DFApi.postNew(m37608a(str), str2, absOkHttpCallback);
    }
}
