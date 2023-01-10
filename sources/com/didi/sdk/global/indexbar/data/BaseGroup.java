package com.didi.sdk.global.indexbar.data;

@Deprecated
public abstract class BaseGroup {

    /* renamed from: a */
    private String f38945a;

    /* access modifiers changed from: protected */
    public abstract void generateGroup();

    public String getGroup() {
        if (this.f38945a == null) {
            generateGroup();
        }
        return this.f38945a;
    }

    public void setGroup(String str) {
        this.f38945a = str;
    }
}
