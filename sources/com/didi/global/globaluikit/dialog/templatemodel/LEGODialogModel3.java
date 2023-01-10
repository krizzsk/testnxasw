package com.didi.global.globaluikit.dialog.templatemodel;

import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.dialog.LEGOBaseDialogModel;
import com.didi.global.globaluikit.dialog.LEGORealUsedModel;

public class LEGODialogModel3 extends LEGOBaseDialogModel {

    /* renamed from: a */
    private String f24441a;

    /* renamed from: b */
    private String f24442b;

    public LEGODialogModel3(String str, String str2, LEGOBtnTextAndCallback... lEGOBtnTextAndCallbackArr) {
        super(lEGOBtnTextAndCallbackArr);
        this.f24442b = str2;
        this.f24441a = str;
    }

    public LEGODialogModel3(String str, String str2) {
        super(new LEGOBtnTextAndCallback[0]);
        this.f24442b = str2;
        this.f24441a = str;
    }

    public String getTitle() {
        return this.f24441a;
    }

    public String getContent() {
        return this.f24442b;
    }

    /* access modifiers changed from: protected */
    public void convertOthers(LEGORealUsedModel lEGORealUsedModel) {
        lEGORealUsedModel.mTitle = new LEGORealUsedModel.TextWidgetModel();
        lEGORealUsedModel.mContent = new LEGORealUsedModel.TextWidgetModel();
        lEGORealUsedModel.mTitle.text = getTitle();
        lEGORealUsedModel.mContent.text = getContent();
    }
}
