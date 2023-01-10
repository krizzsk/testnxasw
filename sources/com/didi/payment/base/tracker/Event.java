package com.didi.payment.base.tracker;

import android.text.TextUtils;
import com.didichuxing.omega.sdk.common.OmegaConfig;
import java.util.HashMap;
import java.util.Map;

public class Event {

    /* renamed from: a */
    private String f32427a;

    /* renamed from: b */
    private Map<String, Object> f32428b;

    protected Event(String str) {
        this.f32427a = str;
    }

    /* renamed from: a */
    private void m24604a() {
        if (this.f32428b == null) {
            this.f32428b = new HashMap();
        }
    }

    public Event module(String str) {
        return attr("pmn", (Object) str);
    }

    public Event subEvent(String str) {
        return attr("se", (Object) str);
    }

    public Event attr(String str, Object obj) {
        m24604a();
        if (!(str == null || obj == null)) {
            this.f32428b.put(str, obj);
        }
        return this;
    }

    public Event attr(String str, boolean z) {
        m24604a();
        this.f32428b.put(str, Integer.valueOf(z ? 1 : 0));
        return this;
    }

    public Event attrs(Map<String, Object> map) {
        m24604a();
        if (map != null) {
            this.f32428b.putAll(map);
        }
        return this;
    }

    public void track() {
        if (!TextUtils.isEmpty(this.f32427a)) {
            boolean z = OmegaConfig.IS_INIT;
            FinOmegaSDK.trackEvent(this.f32427a, this.f32428b);
        }
    }
}
