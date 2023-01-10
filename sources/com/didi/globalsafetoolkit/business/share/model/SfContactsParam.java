package com.didi.globalsafetoolkit.business.share.model;

import com.didi.globalsafetoolkit.model.ISfBaseObject;

public class SfContactsParam implements ISfBaseObject {

    /* renamed from: a */
    private String f25103a;

    /* renamed from: b */
    private int f25104b;

    /* renamed from: c */
    private int f25105c = Integer.MAX_VALUE;

    public SfContactsParam setOrderId(String str) {
        this.f25103a = str;
        return this;
    }

    public SfContactsParam setTarget(int i) {
        this.f25104b = i;
        return this;
    }

    public SfContactsParam setThreshold(int i) {
        this.f25105c = i;
        return this;
    }

    public String getOrderId() {
        return this.f25103a;
    }

    public int getTarget() {
        return this.f25104b;
    }

    public int getThreshold() {
        return this.f25105c;
    }
}
