package com.iproov.sdk.core;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import org.json.JSONObject;

/* renamed from: com.iproov.sdk.core.for */
/* compiled from: CaptureResult */
public final class C20871for {

    /* renamed from: a */
    private String f57099a = "";

    /* renamed from: b */
    private String f57100b;

    /* renamed from: c */
    private String f57101c;

    /* renamed from: d */
    private String f57102d = "";

    public C20871for(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f57099a = jSONObject.optString("result", "");
            this.f57100b = jSONObject.optString("reason", (String) null);
            this.f57101c = jSONObject.optString("feedback_code", (String) null);
            this.f57102d = jSONObject.optString("token", "");
        }
    }

    /* renamed from: do */
    public String mo171487do() {
        return this.f57101c;
    }

    /* renamed from: for  reason: not valid java name */
    public boolean m48120for() {
        String str = this.f57101c;
        return str != null && (str.equalsIgnoreCase("network_problem") || this.f57101c.equalsIgnoreCase("user_timeout"));
    }

    /* renamed from: if */
    public String mo171490if() {
        return this.f57102d;
    }

    /* renamed from: new  reason: not valid java name */
    public boolean m48121new() {
        return this.f57099a.equals("Passed");
    }

    /* renamed from: do */
    public String mo171488do(Context context) {
        if (this.f57101c == null) {
            return this.f57100b;
        }
        String str = m43288do(context, "iproov__failure_" + this.f57101c);
        return str == null ? this.f57100b : str;
    }

    /* renamed from: do */
    public static String m43288do(Context context, String str) {
        int identifier = context.getResources().getIdentifier(str, TypedValues.Custom.S_STRING, context.getApplicationContext().getPackageName());
        if (identifier == 0) {
            return null;
        }
        return context.getString(identifier);
    }
}
