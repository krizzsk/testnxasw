package com.didi.safetoolkit.business.emergency;

import android.text.TextUtils;
import com.didi.safetoolkit.api.ISfInfoService;
import com.didi.safetoolkit.business.sdk.SafeToolKit;
import com.didi.safetoolkit.util.SfContextHelper;
import com.didi.safetoolkit.util.SfLog;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.foundation.spi.ServiceLoader;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;

public class SfEmergencyNumHelper {
    public static String getEmergencyCallNum() {
        String a = m28022a();
        if (TextUtils.isEmpty(a)) {
            return "911";
        }
        String str = a.toLowerCase() + "_police_num";
        JSONObject policePhoneFromPGetConfig = SafeToolKit.getIns().getPolicePhoneFromPGetConfig();
        if (policePhoneFromPGetConfig != null) {
            String optString = policePhoneFromPGetConfig.optString(str);
            if (!TextUtils.isEmpty(optString)) {
                return optString;
            }
        }
        String str2 = (String) m28021a("global_safetytoolkit_police_number", str, "0");
        if (!"0".equals(str2)) {
            return str2;
        }
        SfLog.m28131d("getEmergencyCallNum", "get police number from apollo failed");
        String a2 = m28023a("safetoolkit/police_number.json");
        if (!TextUtils.isEmpty(a2)) {
            try {
                return new JSONObject(a2).getString(str);
            } catch (JSONException e) {
                SfLog.m28131d("getEmergencyCallNum", "get police number from json failed");
                e.printStackTrace();
            }
        }
        return "911";
    }

    /* renamed from: a */
    private static <T> T m28021a(String str, String str2, T t) {
        try {
            return Apollo.getToggle(str).getExperiment().getParam(str2, t);
        } catch (Exception e) {
            SfLog.m28132e(e.getMessage());
            return t;
        }
    }

    /* renamed from: a */
    private static String m28023a(String str) {
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
    private static String m28022a() {
        ISfInfoService iSfInfoService = (ISfInfoService) ServiceLoader.load(ISfInfoService.class, SafeToolKit.getIns().getBusinessType()).get();
        if (iSfInfoService != null) {
            return iSfInfoService.getCountryIsoCode();
        }
        return null;
    }
}
