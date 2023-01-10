package com.didi.global.globalgenerickit.dialog;

import com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback;
import com.didi.global.globalgenerickit.dialog.GGKRealUsedModel;

public class GGKDialogModel1 extends GGKBaseDialogModel {

    /* renamed from: a */
    private String f23985a;

    public GGKDialogModel1(String str, GGKBtnTextAndCallback gGKBtnTextAndCallback) {
        super(gGKBtnTextAndCallback);
        this.f23985a = str;
    }

    public String getTitle() {
        return this.f23985a;
    }

    /* access modifiers changed from: protected */
    public void convertOthers(GGKRealUsedModel gGKRealUsedModel) {
        gGKRealUsedModel.f24003a = new GGKRealUsedModel.TextWidgetModel();
        gGKRealUsedModel.f24003a.text = getTitle();
    }
}
