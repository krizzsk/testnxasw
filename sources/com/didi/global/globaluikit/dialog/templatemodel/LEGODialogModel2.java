package com.didi.global.globaluikit.dialog.templatemodel;

import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.dialog.LEGOBaseDialogModel;
import com.didi.global.globaluikit.dialog.LEGORealUsedModel;

public class LEGODialogModel2 extends LEGOBaseDialogModel {

    /* renamed from: a */
    private String f24440a;

    public LEGODialogModel2(String str, LEGOBtnTextAndCallback lEGOBtnTextAndCallback) {
        super(lEGOBtnTextAndCallback);
        this.f24440a = str;
    }

    public String getContentText() {
        return this.f24440a;
    }

    /* access modifiers changed from: protected */
    public void convertOthers(LEGORealUsedModel lEGORealUsedModel) {
        lEGORealUsedModel.mContent = new LEGORealUsedModel.TextWidgetModel();
        lEGORealUsedModel.mContent.text = getContentText();
    }
}
