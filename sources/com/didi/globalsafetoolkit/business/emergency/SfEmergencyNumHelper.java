package com.didi.globalsafetoolkit.business.emergency;

import android.text.TextUtils;
import com.didi.globalsafetoolkit.GlobalSfBusinessInterface;
import com.didi.globalsafetoolkit.SafeBusinessData;
import com.didi.globalsafetoolkit.business.sdk.GlobalSafeToolKit;
import com.didi.globalsafetoolkit.util.SfContextHelper;
import com.didi.globalsafetoolkit.util.SfLog;
import com.didichuxing.apollo.sdk.Apollo;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;

public class SfEmergencyNumHelper {
    public static String getEmergencyCallNum() {
        String a = m20037a();
        if (TextUtils.isEmpty(a)) {
            return "911";
        }
        String str = a.toLowerCase() + "_police_num";
        JSONObject policePhoneFromPGetConfig = GlobalSafeToolKit.getIns().getPolicePhoneFromPGetConfig();
        if (policePhoneFromPGetConfig != null) {
            String optString = policePhoneFromPGetConfig.optString(str);
            if (!TextUtils.isEmpty(optString)) {
                return optString;
            }
        }
        String str2 = (String) m20036a("global_safetytoolkit_police_number", str, "0");
        if (!"0".equals(str2)) {
            return str2;
        }
        SfLog.m20145d("getEmergencyCallNum", "get police number from apollo failed");
        String a2 = m20038a("safetoolkit/police_number.json");
        if (!TextUtils.isEmpty(a2)) {
            try {
                return new JSONObject(a2).getString(str);
            } catch (JSONException e) {
                SfLog.m20145d("getEmergencyCallNum", "get police number from json failed");
                e.printStackTrace();
            }
        }
        return "911";
    }

    /* renamed from: a */
    private static <T> T m20036a(String str, String str2, T t) {
        try {
            return Apollo.getToggle(str).getExperiment().getParam(str2, t);
        } catch (Exception e) {
            SfLog.m20146e(e.getMessage());
            return t;
        }
    }

    /* renamed from: a */
    private static String m20038a(String str) {
        try {
            InputStream open = SfContextHelper.getContext().getAssets().open(str);
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            return new String(bArr, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private static String m20037a() {
        SafeBusinessData businessInfo = GlobalSfBusinessInterface.getBusinessInfo();
        if (businessInfo != null) {
            return businessInfo.getCountryIsoCode();
        }
        return null;
    }
}
