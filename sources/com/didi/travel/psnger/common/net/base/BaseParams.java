package com.didi.travel.psnger.common.net.base;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseParams {

    /* renamed from: a */
    private int f46706a;

    /* renamed from: b */
    private Map<String, Object> f46707b = new HashMap();

    /* access modifiers changed from: protected */
    public abstract Map<String, Object> convertBean2Map();

    public void addParam(String str, Object obj) {
        this.f46707b.put(str, obj);
    }

    public final Map<String, Object> getParams() {
        this.f46707b.put("business_id", Integer.valueOf(this.f46706a));
        this.f46707b.putAll(convertBean2Map());
        return this.f46707b;
    }

    /* access modifiers changed from: protected */
    public void put(Map<String, Object> map, String str, Object obj) {
        String valueOf = String.valueOf(obj);
        if (TextUtils.isEmpty(valueOf)) {
            map.put(str, "");
        } else {
            map.put(str, valueOf.trim());
        }
    }

    public void setBusinessId(int i) {
        this.f46706a = i;
    }

    public int getBusinessId() {
        return this.f46706a;
    }
}
