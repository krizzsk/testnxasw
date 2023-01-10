package com.didi.unifiedPay.component.widget.dialog;

public abstract class DialogInfo {

    /* renamed from: a */
    int f47134a;

    /* renamed from: b */
    boolean f47135b;

    protected DialogInfo(int i) {
        this.f47134a = i;
    }

    public int getDialogId() {
        return this.f47134a;
    }

    public void setDialogId(int i) {
        this.f47134a = i;
    }

    public DialogInfo setCancelable(boolean z) {
        this.f47135b = z;
        return this;
    }
}
