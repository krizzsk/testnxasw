package com.didi.travel.psnger.core.model.request;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class CancelOrderParams extends BaseCancelOrderParams {

    /* renamed from: a */
    private String f46738a;

    /* renamed from: b */
    private String f46739b;

    /* renamed from: c */
    private String f46740c;

    /* renamed from: d */
    private String f46741d;

    /* access modifiers changed from: protected */
    public Map<String, Object> convertBean2Map() {
        HashMap hashMap = new HashMap();
        put(hashMap, "token", this.f46739b);
        if (!TextUtils.isEmpty(this.f46741d)) {
            put(hashMap, "lat", this.f46741d);
        }
        if (!TextUtils.isEmpty(this.f46740c)) {
            put(hashMap, "lng", this.f46740c);
        }
        put(hashMap, "oid", this.f46738a);
        return hashMap;
    }

    public void setOrderId(String str) {
        this.f46738a = str;
    }

    public String getOrderId() {
        return this.f46738a;
    }

    public void setToken(String str) {
        this.f46739b = str;
    }

    public String getToken() {
        return this.f46739b;
    }

    public void setLng(String str) {
        this.f46740c = str;
    }

    public String getLng() {
        return this.f46740c;
    }

    public void setLat(String str) {
        this.f46741d = str;
    }

    public String getLat() {
        return this.f46741d;
    }
}
