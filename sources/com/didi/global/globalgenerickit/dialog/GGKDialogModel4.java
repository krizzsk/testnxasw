package com.didi.global.globalgenerickit.dialog;

import android.widget.CompoundButton;
import com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback;
import com.didi.global.globalgenerickit.dialog.GGKRealUsedModel;

public class GGKDialogModel4 extends GGKBaseDialogModel {

    /* renamed from: a */
    private String f23989a;

    /* renamed from: b */
    private String f23990b;

    /* renamed from: c */
    private String f23991c;

    /* renamed from: d */
    private CompoundButton.OnCheckedChangeListener f23992d;

    public GGKDialogModel4(String str, String str2, String str3, GGKBtnTextAndCallback gGKBtnTextAndCallback, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        super(gGKBtnTextAndCallback);
        this.f23990b = str2;
        this.f23989a = str;
        this.f23991c = str3;
        this.f23992d = onCheckedChangeListener;
    }

    public String getTitle() {
        return this.f23989a;
    }

    public String getContent() {
        return this.f23990b;
    }

    public String getCheckBoxText() {
        return this.f23991c;
    }

    public CompoundButton.OnCheckedChangeListener getCheckboxListener() {
        return this.f23992d;
    }

    /* access modifiers changed from: protected */
    public void convertOthers(GGKRealUsedModel gGKRealUsedModel) {
        gGKRealUsedModel.f24003a = new GGKRealUsedModel.TextWidgetModel();
        gGKRealUsedModel.f24004b = new GGKRealUsedModel.TextWidgetModel();
        gGKRealUsedModel.f24004b.text = getContent();
        gGKRealUsedModel.f24003a.text = getTitle();
        gGKRealUsedModel.f24005c = new GGKRealUsedModel.TextWidgetModel();
        gGKRealUsedModel.f24005c.text = getCheckBoxText();
        gGKRealUsedModel.f24008f = getCheckboxListener();
    }
}
