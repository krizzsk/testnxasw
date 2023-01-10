package com.didi.travel.psnger.core.model.request;

import com.didi.travel.psnger.common.net.base.ParamKeys;
import java.util.HashMap;
import java.util.Map;

public class CancelTripParams extends BaseCancelTripParams {

    /* renamed from: a */
    private String f46742a;

    /* renamed from: b */
    private String f46743b;

    /* renamed from: c */
    private String f46744c;

    /* renamed from: d */
    private String f46745d;

    /* renamed from: e */
    private int f46746e;

    /* renamed from: f */
    private String f46747f;

    /* renamed from: g */
    private int f46748g = 0;

    /* renamed from: h */
    private int f46749h;

    /* access modifiers changed from: protected */
    public Map<String, Object> convertBean2Map() {
        HashMap hashMap = new HashMap();
        put(hashMap, "token", this.f46743b);
        put(hashMap, "lng", this.f46744c);
        put(hashMap, "lat", this.f46745d);
        put(hashMap, "oid", this.f46742a);
        put(hashMap, "type", Integer.valueOf(this.f46746e));
        put(hashMap, "content", this.f46747f);
        put(hashMap, ParamKeys.PARAM_CONTROL, 1);
        put(hashMap, ParamKeys.PARAM_NATIVE_CANCEL, Integer.valueOf(this.f46748g));
        put(hashMap, ParamKeys.PARAM_SUB_STATUS, Integer.valueOf(this.f46749h));
        return hashMap;
    }

    public void setOrderId(String str) {
        this.f46742a = str;
    }

    public String getOrderId() {
        return this.f46742a;
    }

    public void setToken(String str) {
        this.f46743b = str;
    }

    public String getToken() {
        return this.f46743b;
    }

    public void setLng(String str) {
        this.f46744c = str;
    }

    public String getLng() {
        return this.f46744c;
    }

    public void setLat(String str) {
        this.f46745d = str;
    }

    public String getLat() {
        return this.f46745d;
    }

    public void setType(int i) {
        this.f46746e = i;
    }

    public int getType() {
        return this.f46746e;
    }

    public void setContent(String str) {
        this.f46747f = str;
    }

    public String getContent() {
        return this.f46747f;
    }

    public int getNativeCancel() {
        return this.f46748g;
    }

    public void setNativeCancel(int i) {
        this.f46748g = i;
    }

    public int getSubStatus() {
        return this.f46749h;
    }

    public void setSubStatus(int i) {
        this.f46749h = i;
    }
}
