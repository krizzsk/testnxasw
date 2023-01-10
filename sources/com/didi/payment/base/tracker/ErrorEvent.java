package com.didi.payment.base.tracker;

import android.util.Log;
import com.didi.payment.base.utils.PayLogUtils;
import com.didichuxing.omega.sdk.common.OmegaConfig;
import java.util.HashMap;
import java.util.Map;

public class ErrorEvent {

    /* renamed from: a */
    private String f32423a;

    /* renamed from: b */
    private String f32424b;

    /* renamed from: c */
    private String f32425c;

    /* renamed from: d */
    private Map<String, Object> f32426d = new HashMap();

    protected ErrorEvent(String str, String str2, String str3) {
        this.f32423a = str;
        this.f32424b = str2;
        this.f32425c = str3;
    }

    public ErrorEvent module(String str) {
        return attr("pmn", (Object) str);
    }

    public ErrorEvent attr(String str, Object obj) {
        if (!(str == null || obj == null)) {
            this.f32426d.put(str, obj);
        }
        return this;
    }

    public ErrorEvent attr(String str, boolean z) {
        this.f32426d.put(str, Integer.valueOf(z ? 1 : 0));
        return this;
    }

    public ErrorEvent attrs(Map<String, Object> map) {
        if (map != null) {
            this.f32426d.putAll(map);
        }
        return this;
    }

    public ErrorEvent exception(Exception exc) {
        this.f32425c = Log.getStackTraceString(exc);
        return this;
    }

    public void track() {
        if (!OmegaConfig.IS_INIT) {
            PayLogUtils.m24625w("PayBase", "PayTracker", "Omega not init.");
        }
        FinOmegaSDK.trackError("Pay", this.f32423a, this.f32424b, this.f32425c, this.f32426d);
    }
}
