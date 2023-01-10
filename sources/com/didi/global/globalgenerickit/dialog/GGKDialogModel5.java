package com.didi.global.globalgenerickit.dialog;

import android.text.TextWatcher;
import com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback;
import com.didi.global.globalgenerickit.dialog.GGKRealUsedModel;

public class GGKDialogModel5 extends GGKBaseDialogModel {

    /* renamed from: a */
    private String f23993a;

    /* renamed from: b */
    private String f23994b;

    /* renamed from: c */
    private TextWatcher f23995c;

    /* renamed from: d */
    private String f23996d;

    public GGKDialogModel5(String str, String str2, String str3, GGKBtnTextAndCallback gGKBtnTextAndCallback, TextWatcher textWatcher) {
        super(gGKBtnTextAndCallback);
        this.f23993a = str;
        this.f23994b = str2;
        this.f23995c = textWatcher;
        this.f23996d = str3;
    }

    public String getTitle() {
        return this.f23993a;
    }

    public String getContent() {
        return this.f23994b;
    }

    public TextWatcher getEditListener() {
        return this.f23995c;
    }

    public String getHint() {
        return this.f23996d;
    }

    /* access modifiers changed from: protected */
    public void convertOthers(GGKRealUsedModel gGKRealUsedModel) {
        gGKRealUsedModel.f24003a = new GGKRealUsedModel.TextWidgetModel();
        gGKRealUsedModel.f24003a.text = getTitle();
        gGKRealUsedModel.f24004b = new GGKRealUsedModel.TextWidgetModel();
        gGKRealUsedModel.f24004b.text = getContent();
        gGKRealUsedModel.f24006d = getEditListener();
        gGKRealUsedModel.f24007e = getHint();
    }
}
