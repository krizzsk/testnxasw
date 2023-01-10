package com.didi.global.globalgenerickit.dialog;

import com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback;
import com.didi.global.globalgenerickit.dialog.GGKRealUsedModel;

public class GGKDialogModel2 extends GGKBaseDialogModel {

    /* renamed from: a */
    private String f23986a;

    public GGKDialogModel2(String str, GGKBtnTextAndCallback gGKBtnTextAndCallback) {
        super(gGKBtnTextAndCallback);
        this.f23986a = str;
    }

    public String getContentText() {
        return this.f23986a;
    }

    /* access modifiers changed from: protected */
    public void convertOthers(GGKRealUsedModel gGKRealUsedModel) {
        gGKRealUsedModel.f24004b = new GGKRealUsedModel.TextWidgetModel();
        gGKRealUsedModel.f24004b.text = getContentText();
    }
}
