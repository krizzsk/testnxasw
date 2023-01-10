package com.didi.global.globaluikit.dialog.templatemodel;

import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;
import com.didi.global.globaluikit.dialog.LEGOBaseDialogModel;
import com.didi.global.globaluikit.dialog.LEGORealUsedModel;

public class LEGODialogModel6 extends LEGOBaseDialogModel {

    /* renamed from: a */
    private String f24449a;

    /* renamed from: b */
    private String f24450b;

    /* renamed from: c */
    private String f24451c;

    /* renamed from: d */
    private LEGOOnAntiShakeClickListener f24452d;

    public LEGODialogModel6(String str, String str2, String str3, LEGOOnAntiShakeClickListener lEGOOnAntiShakeClickListener, LEGOBtnTextAndCallback lEGOBtnTextAndCallback) {
        super(lEGOBtnTextAndCallback);
        this.f24449a = str;
        this.f24450b = str2;
        this.f24451c = str3;
        this.f24452d = lEGOOnAntiShakeClickListener;
    }

    public LEGOOnAntiShakeClickListener getLinkClickedListener() {
        return this.f24452d;
    }

    public String getTitle() {
        return this.f24449a;
    }

    public String getContent() {
        return this.f24450b;
    }

    public String getDiscriptionText() {
        return this.f24451c;
    }

    /* access modifiers changed from: protected */
    public void convertOthers(LEGORealUsedModel lEGORealUsedModel) {
        lEGORealUsedModel.mTitle = new LEGORealUsedModel.TextWidgetModel();
        lEGORealUsedModel.mTitle.text = getTitle();
        lEGORealUsedModel.mContent = new LEGORealUsedModel.TextWidgetModel();
        lEGORealUsedModel.mContent.text = getContent();
        lEGORealUsedModel.mDescription = new LEGORealUsedModel.TextWidgetModel();
        lEGORealUsedModel.mDescription.text = getDiscriptionText();
        lEGORealUsedModel.mLinkClickedListener = getLinkClickedListener();
    }
}
