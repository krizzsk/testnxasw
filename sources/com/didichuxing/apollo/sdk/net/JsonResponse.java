package com.didichuxing.apollo.sdk.net;

import android.text.TextUtils;
import com.didichuxing.apollo.sdk.log.LogUtils;
import com.turbomanage.httpclient.HttpResponse;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonResponse {

    /* renamed from: a */
    private JSONObject f48295a;

    /* renamed from: b */
    private int f48296b;

    /* renamed from: c */
    private String f48297c;

    /* renamed from: d */
    private Map<String, List<String>> f48298d;

    public JSONObject getResponse() {
        return this.f48295a;
    }

    public int getStatus() {
        return this.f48296b;
    }

    public String getUrl() {
        return this.f48297c;
    }

    public Map<String, List<String>> getHeaders() {
        return this.f48298d;
    }

    public static JsonResponse convertFrom(HttpResponse httpResponse) {
        JsonResponse jsonResponse = new JsonResponse();
        jsonResponse.f48296b = httpResponse.getStatus();
        jsonResponse.f48297c = httpResponse.getUrl();
        jsonResponse.f48298d = httpResponse.getHeaders();
        String bodyAsString = httpResponse.getBodyAsString();
        if (!TextUtils.isEmpty(bodyAsString)) {
            try {
                jsonResponse.f48295a = new JSONObject(bodyAsString);
            } catch (JSONException e) {
                e.printStackTrace();
                LogUtils.m36180e("JSONException while JsonResponse#convertFrom: " + e.getMessage());
            }
        }
        return jsonResponse;
    }
}
