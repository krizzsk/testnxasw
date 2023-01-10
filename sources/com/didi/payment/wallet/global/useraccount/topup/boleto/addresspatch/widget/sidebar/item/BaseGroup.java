package com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.widget.sidebar.item;

@Deprecated
public abstract class BaseGroup {

    /* renamed from: a */
    private String f34468a;

    /* access modifiers changed from: protected */
    public abstract void generateGroup();

    public String getGroup() {
        if (this.f34468a == null) {
            generateGroup();
        }
        return this.f34468a;
    }

    public void setGroup(String str) {
        this.f34468a = str;
    }
}
