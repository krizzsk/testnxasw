package com.didichuxing.mas.sdk.quality.init;

import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HttpTransactionEventReductionUtil {

    /* renamed from: a */
    private static final String f50815a = "HttpEventReduction";

    /* renamed from: b */
    private static final Map<String, Integer> f50816b = new ConcurrentHashMap();

    /* renamed from: a */
    static void m37851a(String str) {
        IExperiment experiment;
        IToggle toggle = Apollo.getToggle(str, false);
        if (toggle != null && toggle.allow() && (experiment = toggle.getExperiment()) != null) {
            m37853b((String) experiment.getParam("black_list", ""));
        }
    }

    /* renamed from: b */
    static void m37853b(String str) {
        f50816b.clear();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray optJSONArray = new JSONObject(str).optJSONArray("l");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        f50816b.put(optJSONArray.optString(i, ""), 0);
                    }
                }
            } catch (JSONException e) {
                SystemUtils.log(6, f50815a, "", e, "com.didichuxing.mas.sdk.quality.init.HttpTransactionEventReductionUtil", 58);
            }
        }
    }

    /* renamed from: a */
    static boolean m37852a(String str, int i) {
        if (f50816b.isEmpty()) {
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        if (!f50816b.containsKey(m37854c(str)) || i != 0) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    private static String m37854c(String str) {
        try {
            URL url = new URL(str);
            String host = url.getHost();
            String path = url.getPath();
            return host + path;
        } catch (MalformedURLException e) {
            SystemUtils.log(6, f50815a, "", e, "com.didichuxing.mas.sdk.quality.init.HttpTransactionEventReductionUtil", 89);
            return str;
        }
    }
}
