package com.didi.travel.psnger.core.model.request;

import com.didi.travel.psnger.common.net.base.BaseParams;
import java.util.HashMap;
import java.util.Map;

public class BaseOrderDetailParams extends BaseParams {

    /* renamed from: a */
    private String f46737a;

    public String getOid() {
        return this.f46737a;
    }

    public void setOid(String str) {
        this.f46737a = str;
    }

    /* access modifiers changed from: protected */
    public Map<String, Object> convertBean2Map() {
        HashMap hashMap = new HashMap();
        hashMap.put("order_id", this.f46737a);
        return hashMap;
    }
}
