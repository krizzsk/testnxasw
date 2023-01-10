package com.didi.onehybrid.jsbridge;

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
    private String f32073a;

    /* renamed from: b */
    private String f32074b;

    /* renamed from: c */
    private String f32075c;

    /* renamed from: d */
    private String f32076d;

    /* renamed from: e */
    private String f32077e;

    /* renamed from: f */
    private String f32078f;

    /* renamed from: g */
    private String f32079g;

    public void setTraceId(String str) {
        this.f32073a = str;
    }

    public String getTraceId() {
        return this.f32073a;
    }

    public void setModuleName(String str) {
        this.f32074b = str;
    }

    public String getModuleName() {
        return this.f32074b;
    }

    public void setFunctionName(String str) {
        this.f32075c = str;
    }

    public String getFunctionName() {
        return this.f32075c;
    }

    public void setArgs(String str) {
        this.f32076d = str;
    }

    public void setOrgProtocol(String str) {
        this.f32079g = str;
    }

    public String getOrgProtocol() {
        return this.f32079g;
    }

    public Object[] getArgsForNative() {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(this.f32076d);
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
        return this.f32076d;
    }

    public void setInvokeFrom(String str) {
        this.f32077e = str;
    }

    public String getInvokeFrom() {
        return this.f32077e;
    }

    public void setPreviousCallId(String str) {
        this.f32078f = str;
    }

    public String getPreviousCallId() {
        return this.f32078f;
    }

    public String toString() {
        return "module:" + this.f32074b + "\n" + "functionName:" + this.f32075c + "\n" + "args:" + this.f32076d + "\n" + "invokeFrom:" + this.f32077e + "\n" + "orgProtocol:" + this.f32079g;
    }
}
