package com.didi.safetoolkit.business.share.model;

import com.didi.safetoolkit.model.ISfBaseObject;

public class SfContactsParam implements ISfBaseObject {

    /* renamed from: a */
    private String f37204a;

    /* renamed from: b */
    private int f37205b;

    /* renamed from: c */
    private int f37206c = Integer.MAX_VALUE;

    public SfContactsParam setOrderId(String str) {
        this.f37204a = str;
        return this;
    }

    public SfContactsParam setTarget(int i) {
        this.f37205b = i;
        return this;
    }

    public SfContactsParam setThreshold(int i) {
        this.f37206c = i;
        return this;
    }

    public String getOrderId() {
        return this.f37204a;
    }

    public int getTarget() {
        return this.f37205b;
    }

    public int getThreshold() {
        return this.f37206c;
    }
}
