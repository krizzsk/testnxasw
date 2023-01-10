package com.didi.dimina.webview.jsbridge;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class InvokeMessage {
    public static final String INVOKE_FROM_ANCIENT = "ancient";
    public static final String INVOKE_FROM_FUSION = "fusion";
    public static final String INVOKE_FROM_PREVIOUS = "previous";
    public static final String KEY_ARGS = "arguments";
    public static final String KEY_FUNCTION_NAME = "method";
    public static final String KEY_NAMESPACE = "module";

    /* renamed from: a */
    private String f20148a;

    /* renamed from: b */
    private String f20149b;

    /* renamed from: c */
    private String f20150c;

    /* renamed from: d */
    private String f20151d;

    /* renamed from: e */
    private String f20152e;

    /* renamed from: f */
    private String f20153f;

    /* renamed from: g */
    private String f20154g;

    public void setTraceId(String str) {
        this.f20148a = str;
    }

    public String getTraceId() {
        return this.f20148a;
    }

    public void setModuleName(String str) {
        this.f20149b = str;
    }

    public String getModuleName() {
        return this.f20149b;
    }

    public void setFunctionName(String str) {
        this.f20150c = str;
    }

    public String getFunctionName() {
        return this.f20150c;
    }

    public void setArgs(String str) {
        this.f20151d = str;
    }

    public void setOrgProtocol(String str) {
        this.f20154g = str;
    }

    public String getOrgProtocol() {
        return this.f20154g;
    }

    public Object[] getArgsForNative() {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(this.f20151d);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                Object obj = jSONArray.get(i);
                if (obj == JSONObject.NULL) {
                    arrayList.add((Object) null);
                } else {
                    arrayList.add(obj);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrayList.toArray();
    }

    public String getArgs() {
        return this.f20151d;
    }

    public void setInvokeFrom(String str) {
        this.f20152e = str;
    }

    public String getInvokeFrom() {
        return this.f20152e;
    }

    public void setPreviousCallId(String str) {
        this.f20153f = str;
    }

    public String getPreviousCallId() {
        return this.f20153f;
    }

    public String toString() {
        return "module:" + this.f20149b + "\nfunctionName:" + this.f20150c + "\nargs:" + this.f20151d + "\ninvokeFrom:" + this.f20152e + "\norgProtocol:" + this.f20154g;
    }
}
