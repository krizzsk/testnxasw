package com.didi.global.globalgenerickit.dialog;

import com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback;
import com.didi.global.globalgenerickit.dialog.GGKRealUsedModel;

public class GGKDialogModel3 extends GGKBaseDialogModel {

    /* renamed from: a */
    private String f23987a;

    /* renamed from: b */
    private String f23988b;

    public GGKDialogModel3(String str, String str2, GGKBtnTextAndCallback... gGKBtnTextAndCallbackArr) {
        super(gGKBtnTextAndCallbackArr);
        this.f23988b = str2;
        this.f23987a = str;
    }

    public GGKDialogModel3(String str, String str2) {
        super(new GGKBtnTextAndCallback[0]);
        this.f23988b = str2;
        this.f23987a = str;
    }

    public String getTitle() {
        return this.f23987a;
    }

    public String getContent() {
        return this.f23988b;
    }

    /* access modifiers changed from: protected */
    public void convertOthers(GGKRealUsedModel gGKRealUsedModel) {
        gGKRealUsedModel.f24003a = new GGKRealUsedModel.TextWidgetModel();
        gGKRealUsedModel.f24004b = new GGKRealUsedModel.TextWidgetModel();
        gGKRealUsedModel.f24003a.text = getTitle();
        gGKRealUsedModel.f24004b.text = getContent();
    }
}
