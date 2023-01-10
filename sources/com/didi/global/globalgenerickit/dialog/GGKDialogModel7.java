package com.didi.global.globalgenerickit.dialog;

import com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback;
import com.didi.global.globalgenerickit.dialog.GGKRealUsedModel;
import com.didi.global.globalgenerickit.utils.GGKOnAntiShakeClickListener;

public class GGKDialogModel7 extends GGKBaseDialogModel {

    /* renamed from: a */
    private String f23999a;

    /* renamed from: b */
    private String f24000b;

    /* renamed from: c */
    private String f24001c;

    /* renamed from: d */
    private GGKOnAntiShakeClickListener f24002d;

    public GGKDialogModel7(String str, String str2, String str3, GGKOnAntiShakeClickListener gGKOnAntiShakeClickListener, GGKBtnTextAndCallback gGKBtnTextAndCallback) {
        super(gGKBtnTextAndCallback);
        this.f23999a = str;
        this.f24000b = str2;
        this.f24001c = str3;
        this.f24002d = gGKOnAntiShakeClickListener;
    }

    public GGKOnAntiShakeClickListener getLinkClickedListener() {
        return this.f24002d;
    }

    public String getTitle() {
        return this.f23999a;
    }

    public String getContent() {
        return this.f24000b;
    }

    public String getDiscriptionText() {
        return this.f24001c;
    }

    /* access modifiers changed from: protected */
    public void convertOthers(GGKRealUsedModel gGKRealUsedModel) {
        gGKRealUsedModel.f24003a = new GGKRealUsedModel.TextWidgetModel();
        gGKRealUsedModel.f24003a.text = getTitle();
        gGKRealUsedModel.f24004b = new GGKRealUsedModel.TextWidgetModel();
        gGKRealUsedModel.f24004b.text = getContent();
        gGKRealUsedModel.f24010h = new GGKRealUsedModel.TextWidgetModel();
        gGKRealUsedModel.f24010h.text = getDiscriptionText();
        gGKRealUsedModel.f24011i = getLinkClickedListener();
    }
}
