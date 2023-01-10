package com.didi.component.common.net;

import android.text.TextUtils;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.common.util.GLog;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.foundation.net.http.HttpEntity;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.p188io.Streams;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class RequestParamsChecker {

    /* renamed from: a */
    private static final String f13489a = "RequestParamsChecker";

    /* renamed from: b */
    private static HashMap<String, HashMap<String, CheckConfig>> f13490b = null;

    /* renamed from: c */
    private static HashMap<String, HashMap<String, CheckConfig>> f13491c = null;

    /* renamed from: d */
    private static final String f13492d = "global_passenger_request_params_check";

    /* renamed from: e */
    private static final String f13493e = "0";

    /* renamed from: f */
    private static final String f13494f = "null";

    /* renamed from: g */
    private static final String f13495g = "[]";

    /* renamed from: h */
    private static final String f13496h = "{}";

    class CheckConfig {
        @SerializedName("can_be_empty_list")
        boolean canBeEmptyList;
        @SerializedName("can_be_zero")
        boolean canBeZero;

        CheckConfig() {
        }
    }

    RequestParamsChecker() {
    }

    public void checkRequestParams(String str, HttpRpcRequest httpRpcRequest) throws IOException {
        if (m11269a() && f13490b != null && f13491c != null) {
            if (m11272c(str)) {
                m11273d(m11264a(httpRpcRequest));
                return;
            }
            String b = m11270b(str);
            if (b != null) {
                m11268a(b, m11264a(httpRpcRequest));
            }
        }
    }

    /* renamed from: a */
    private static boolean m11269a() {
        return GlobalApolloUtil.getStatus(f13492d);
    }

    /* renamed from: a */
    private static HashMap<String, HashMap<String, CheckConfig>> m11267a(String str) {
        HashMap<String, HashMap<String, CheckConfig>> hashMap = new HashMap<>();
        String str2 = (String) GlobalApolloUtil.getParam(f13492d, str, "");
        if (TextUtils.isEmpty(str2)) {
            return hashMap;
        }
        try {
            String[] split = str2.split(";");
            for (String str3 : split) {
                HashMap hashMap2 = (HashMap) new Gson().fromJson((String) GlobalApolloUtil.getParam(f13492d, str3, ""), new TypeToken<HashMap<String, CheckConfig>>() {
                }.getType());
                if (hashMap2 != null) {
                    GLog.m11354d(f13489a, "buildParamsCheckConfigMap path:  " + str3);
                    for (String str4 : hashMap2.keySet()) {
                        GLog.m11354d(f13489a, "buildParamsCheckConfigMap params:  " + str4);
                    }
                    hashMap.put(str3, hashMap2);
                }
            }
        } catch (Exception e) {
            GLog.m11357e(f13489a, "buildParamsCheckConfigMap error" + e.getMessage());
        }
        return hashMap;
    }

    /* renamed from: a */
    private String m11265a(String str, String str2, CheckConfig checkConfig) {
        if ((checkConfig.canBeZero && "0".equals(str2)) || (checkConfig.canBeEmptyList && f13495g.equals(str2))) {
            GLog.m11354d(f13489a, "continue data:" + str);
            return null;
        } else if (!TextUtils.isEmpty(str2) && !"0".equals(str2) && !f13495g.equals(str2) && !"null".equals(str2) && !f13496h.equals(str2)) {
            return null;
        } else {
            GLog.m11354d(f13489a, "errorParams data:" + str);
            return str;
        }
    }

    /* renamed from: a */
    private void m11268a(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            try {
                HashMap hashMap = f13490b.get(str);
                if (hashMap == null) {
                    return;
                }
                if (hashMap.size() != 0) {
                    StringBuilder sb = new StringBuilder();
                    for (String str3 : hashMap.keySet()) {
                        Pattern compile = Pattern.compile(ParamKeys.SIGN_AND + str3 + "=(.+?)&");
                        CheckConfig checkConfig = (CheckConfig) hashMap.get(str3);
                        Matcher matcher = compile.matcher(str2);
                        if (checkConfig != null && matcher.find() && matcher.groupCount() >= 1 && m11265a(str3, URLDecoder.decode(matcher.group(1), "UTF-8"), checkConfig) != null) {
                            sb.append(str3 + ";");
                        }
                    }
                    m11271b(str, sb.toString());
                }
            } catch (Exception e) {
                GLog.m11357e(f13489a, "error" + e.getMessage());
            }
        }
    }

    public static void initRequestCheckConfig() {
        if (m11269a()) {
            if (f13490b == null) {
                f13490b = m11267a("api_list");
            }
            if (f13491c == null) {
                f13491c = m11267a("bff_list");
            }
        }
    }

    /* renamed from: b */
    private String m11270b(String str) {
        int lastIndexOf;
        int i;
        if (!TextUtils.isEmpty(str) && (lastIndexOf = str.lastIndexOf("/")) >= 0 && (i = lastIndexOf + 1) < str.length()) {
            String substring = str.substring(i);
            if (f13490b.containsKey(substring)) {
                GLog.m11354d(f13489a, "hitApiRequestCheckPath:" + substring);
                return substring;
            }
        }
        return null;
    }

    /* renamed from: c */
    private boolean m11272c(String str) {
        return str.contains("/halo/") || str.contains("/ability/");
    }

    /* renamed from: d */
    private void m11273d(String str) {
        JSONObject optJSONObject;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("abilities") && (optJSONObject = jSONObject.optJSONObject("abilities")) != null) {
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        HashMap hashMap = f13491c.get(next);
                        if (hashMap != null && hashMap.size() > 0) {
                            GLog.m11354d(f13489a, "ability:" + next);
                            m11271b(next, m11266a(optJSONObject.optJSONObject(next), (HashMap<String, CheckConfig>) hashMap));
                        }
                    }
                }
            } catch (Exception e) {
                GLog.m11358e(f13489a, "error", e);
            }
        }
    }

    /* renamed from: a */
    private String m11266a(JSONObject jSONObject, HashMap<String, CheckConfig> hashMap) {
        StringBuilder sb = new StringBuilder();
        for (String next : hashMap.keySet()) {
            CheckConfig checkConfig = hashMap.get(next);
            if (!(jSONObject == null || !jSONObject.has(next) || m11265a(next, jSONObject.optString(next), checkConfig) == null)) {
                sb.append(next + ";");
            }
        }
        return sb.toString();
    }

    /* renamed from: b */
    private void m11271b(String str, String str2) {
        GLog.m11360i(f13489a, "trackErrorParams:" + str2);
        if (!TextUtils.isEmpty(str2)) {
            HashMap hashMap = new HashMap();
            hashMap.put("url_flag", str);
            hashMap.put("error_params", str2);
            hashMap.put(ParamConst.TRACE_ID, RidGetterInterceptor.threadLocal.get());
            OmegaSDKAdapter.trackEvent("tech_pax_request_params_error", (Map<String, Object>) hashMap);
        }
    }

    /* renamed from: a */
    private String m11264a(HttpRpcRequest httpRpcRequest) throws IOException {
        HttpEntity entity = httpRpcRequest.getEntity();
        if (entity != null && entity.getContentLength() != 0) {
            return Streams.readFully((Reader) new InputStreamReader(entity.getContent()));
        }
        int indexOf = httpRpcRequest.getUrl().indexOf("?");
        return indexOf >= 0 ? httpRpcRequest.getUrl().substring(indexOf) : "";
    }
}
