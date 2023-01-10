package com.didi.global.globalgenerickit.drawer.templatemodel;

import com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback;
import com.didi.global.globalgenerickit.drawer.GGKDrawerModel;
import com.didi.global.globalgenerickit.utils.GGKOnAntiShakeClickListener;

public class GGKDrawerModel8 extends GGKDrawerModel3 {

    /* renamed from: a */
    private String f24104a;

    /* renamed from: b */
    private GGKBtnTextAndCallback f24105b;

    public GGKDrawerModel8(String str, String str2, GGKOnAntiShakeClickListener gGKOnAntiShakeClickListener, String str3, GGKBtnTextAndCallback gGKBtnTextAndCallback, GGKBtnTextAndCallback gGKBtnTextAndCallback2, GGKBtnTextAndCallback gGKBtnTextAndCallback3) {
        super(str, str2, gGKOnAntiShakeClickListener, gGKBtnTextAndCallback2);
        this.f24104a = str3;
        this.f24105b = gGKBtnTextAndCallback;
        addMinorBtn(gGKBtnTextAndCallback3);
    }

    public String getSelectedText() {
        return this.f24104a;
    }

    public GGKBtnTextAndCallback getChangeBtn() {
        return this.f24105b;
    }

    /* access modifiers changed from: protected */
    public GGKDrawerModel convertOthers(GGKDrawerModel gGKDrawerModel) {
        super.convertOthers(gGKDrawerModel);
        GGKDrawerModel.WidgetModel widgetModel = new GGKDrawerModel.WidgetModel();
        widgetModel.text = getSelectedText();
        gGKDrawerModel.selectedText = widgetModel;
        gGKDrawerModel.changeBtn = getChangeBtn();
        gGKDrawerModel.isTwoBtnHorizontal = true;
        return gGKDrawerModel;
    }
}
