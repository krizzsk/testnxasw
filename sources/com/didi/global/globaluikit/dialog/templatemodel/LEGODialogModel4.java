package com.didi.global.globaluikit.dialog.templatemodel;

import android.widget.CompoundButton;
import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.dialog.LEGOBaseDialogModel;
import com.didi.global.globaluikit.dialog.LEGORealUsedModel;

public class LEGODialogModel4 extends LEGOBaseDialogModel {

    /* renamed from: a */
    private String f24443a;

    /* renamed from: b */
    private String f24444b;

    /* renamed from: c */
    private String f24445c;

    /* renamed from: d */
    private CompoundButton.OnCheckedChangeListener f24446d;

    public LEGODialogModel4(String str, String str2, String str3, LEGOBtnTextAndCallback lEGOBtnTextAndCallback, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        super(lEGOBtnTextAndCallback);
        this.f24444b = str2;
        this.f24443a = str;
        this.f24445c = str3;
        this.f24446d = onCheckedChangeListener;
    }

    public String getTitle() {
        return this.f24443a;
    }

    public String getContent() {
        return this.f24444b;
    }

    public String getCheckBoxText() {
        return this.f24445c;
    }

    public CompoundButton.OnCheckedChangeListener getCheckboxListener() {
        return this.f24446d;
    }

    /* access modifiers changed from: protected */
    public void convertOthers(LEGORealUsedModel lEGORealUsedModel) {
        lEGORealUsedModel.mTitle = new LEGORealUsedModel.TextWidgetModel();
        lEGORealUsedModel.mContent = new LEGORealUsedModel.TextWidgetModel();
        lEGORealUsedModel.mContent.text = getContent();
        lEGORealUsedModel.mTitle.text = getTitle();
        lEGORealUsedModel.mCheckContent = new LEGORealUsedModel.TextWidgetModel();
        lEGORealUsedModel.mCheckContent.text = getCheckBoxText();
        lEGORealUsedModel.mLEGOCheckboxListener = getCheckboxListener();
    }
}
