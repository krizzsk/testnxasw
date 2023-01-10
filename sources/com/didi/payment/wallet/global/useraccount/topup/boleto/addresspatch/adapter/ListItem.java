package com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.adapter;

import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.widget.sidebar.item.BaseGroup;
import rui.config.RConfigConstants;

public class ListItem extends BaseGroup {

    /* renamed from: a */
    private String f34390a;

    /* renamed from: b */
    private String f34391b;

    /* renamed from: c */
    private String f34392c;

    public String getDisplayContent() {
        return this.f34391b;
    }

    public String getStateOrCity() {
        return this.f34390a;
    }

    public String getStateCode() {
        return this.f34392c;
    }

    public ListItem(String str, String str2, String str3) {
        this.f34390a = str;
        this.f34391b = str2;
        this.f34392c = str3;
    }

    /* access modifiers changed from: protected */
    public void generateGroup() {
        char c = this.f34391b.toCharArray()[0];
        if (String.valueOf(c).matches("[A-Za-z]")) {
            setGroup(String.valueOf(c).toUpperCase());
        } else {
            setGroup(RConfigConstants.KEYWORD_COLOR_SIGN);
        }
    }
}
