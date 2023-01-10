package com.didi.dimina.webview.jsbridge;

import org.json.JSONArray;

public class CallbackMessage {

    /* renamed from: a */
    private String f20140a;

    /* renamed from: b */
    private Object[] f20141b;

    public void setCallbackId(String str) {
        this.f20140a = str;
    }

    public void setCallbackArguments(Object[] objArr) {
        this.f20141b = objArr;
    }

    public String getCallbackId() {
        return this.f20140a;
    }

    public JSONArray getArgumentsAsJSONArray() {
        JSONArray jSONArray = new JSONArray();
        Object[] objArr = this.f20141b;
        if (objArr != null) {
            for (Object put : objArr) {
                jSONArray.put(put);
            }
        }
        return jSONArray;
    }

    public String toString() {
        return "CallbackId:" + this.f20140a + "; Data:" + getArgumentsAsJSONArray().toString();
    }
}
