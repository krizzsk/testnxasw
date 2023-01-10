package com.didi.travel.psnger.core.model.request;

import com.didi.travel.psnger.common.net.base.BaseParams;
import java.util.Map;

public class OrderStatusParams extends BaseParams {

    /* renamed from: a */
    private String f46832a;

    /* renamed from: b */
    private int f46833b;

    /* renamed from: c */
    private int f46834c;

    /* renamed from: d */
    private int f46835d;

    /* access modifiers changed from: protected */
    public Map<String, Object> convertBean2Map() {
        return null;
    }

    public String getOid() {
        return this.f46832a;
    }

    public void setOid(String str) {
        this.f46832a = str;
    }

    public int getType() {
        return this.f46833b;
    }

    public void setType(int i) {
        this.f46833b = i;
    }

    public int getCurrentStatus() {
        return this.f46834c;
    }

    public void setCurrentStatus(int i) {
        this.f46834c = i;
    }

    public int getCurrentSubStatus() {
        return this.f46835d;
    }

    public void setCurrentSubStatus(int i) {
        this.f46835d = i;
    }
}
