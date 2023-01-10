package com.didi.universal.pay.sdk.net;

import android.content.Context;
import android.text.TextUtils;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.foundation.net.http.HttpHeader;
import com.didichuxing.foundation.net.http.SimpleHttpHeader;
import com.didichuxing.foundation.net.rpc.http.HttpRpcClient;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import com.google.common.net.HttpHeaders;
import com.koushikdutta.async.http.AsyncHttpRequest;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class HttpHelper {
    public static final String CONTENT_TYPE_FORM = "application/x-www-form-urlencoded";
    public static final String CONTENT_TYPE_JSON = "application/json";
    public static final String UNIPAY_SDK_VERSION = "5.2.9";

    /* renamed from: a */
    private String m35883a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str;
        }
    }

    public Iterable<HttpHeader> getHeaders() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new SimpleHttpHeader(HttpHeaders.CACHE_CONTROL, "no-cache"));
        arrayList.add(new SimpleHttpHeader("Content-Type", "application/json"));
        arrayList.add(new SimpleHttpHeader(HttpHeaders.ACCEPT, AsyncHttpRequest.HEADER_ACCEPT_ALL));
        arrayList.add(new SimpleHttpHeader("DidiCashier-Version", UNIPAY_SDK_VERSION));
        return arrayList;
    }

    public HttpRpcClient getHttpClient(Context context) {
        return ((HttpRpcClient) new RpcServiceFactory(context).getRpcClient("https")).newBuilder().setHostnameVerifier(m35885a()).build();
    }

    /* renamed from: a */
    private HostnameVerifier m35885a() {
        return new HostnameVerifier() {
            public boolean verify(String str, SSLSession sSLSession) {
                if ("".equals(str) || "https://cashier.didiglobal.com".equals(str)) {
                    return true;
                }
                return HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession);
            }
        };
    }

    public String createBody(Map<String, String> map, Object obj, Context context) throws IllegalAccessException {
        HashMap hashMap = new HashMap();
        hashMap.putAll(map);
        m35886a(obj, hashMap);
        return m35884a((Map<String, String>) hashMap);
    }

    /* renamed from: a */
    private String m35884a(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return "";
        }
        Set<String> keySet = map.keySet();
        StringBuilder sb = new StringBuilder();
        for (String next : keySet) {
            sb.append(next);
            sb.append("=");
            sb.append(m35883a(map.get(next)));
            sb.append(ParamKeys.SIGN_AND);
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    /* renamed from: a */
    private void m35886a(Object obj, Map<String, String> map) throws IllegalAccessException {
        Field[] declaredFields;
        Object obj2;
        if (obj != null && (declaredFields = obj.getClass().getDeclaredFields()) != null && declaredFields.length > 0) {
            for (Field field : declaredFields) {
                field.setAccessible(true);
                int modifiers = field.getModifiers();
                if (!((modifiers | 16 | 8) == modifiers || (obj2 = field.get(obj)) == null || TextUtils.isEmpty(obj2.toString()))) {
                    map.put(field.getName(), obj2 + "");
                }
            }
        }
    }
}
