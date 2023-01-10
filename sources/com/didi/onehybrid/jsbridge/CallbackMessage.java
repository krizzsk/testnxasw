package com.didi.onehybrid.jsbridge;

import org.json.JSONArray;

public class CallbackMessage {

    /* renamed from: a */
    private String f32063a;

    /* renamed from: b */
    private Object[] f32064b;

    public void setCallbackId(String str) {
        this.f32063a = str;
    }

    public void setCallbackArguments(Object[] objArr) {
        this.f32064b = objArr;
    }

    public String getCallbackId() {
        return this.f32063a;
    }

    public JSONArray getArgumentsAsJSONArray() {
        JSONArray jSONArray = new JSONArray();
        Object[] objArr = this.f32064b;
        if (objArr != null) {
            for (Object put : objArr) {
                jSONArray.put(put);
            }
        }
        return jSONArray;
    }

    public String toString() {
        return "CallbackId:" + this.f32063a + "; Data:" + getArgumentsAsJSONArray().toString();
    }
}
