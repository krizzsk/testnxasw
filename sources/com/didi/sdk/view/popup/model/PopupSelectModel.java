package com.didi.sdk.view.popup.model;

public class PopupSelectModel {

    /* renamed from: id */
    public String f40884id;
    public int invoiceType;
    public String invoiceUrl;
    public String name;

    public PopupSelectModel(String str, String str2) {
        this.f40884id = str;
        this.name = str2;
    }

    public PopupSelectModel(String str, String str2, String str3, int i) {
        this.f40884id = str;
        this.name = str2;
        this.invoiceType = i;
        this.invoiceUrl = str3;
    }

    public boolean isNeedGoToH5() {
        return 2 == this.invoiceType;
    }
}
