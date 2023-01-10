package com.didi.global.globaluikit.drawer.templatemodel;

import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.drawer.LEGOBtnModelAndCallback;
import com.didi.global.globaluikit.drawer.LEGODrawerModel;

public class LEGODrawerModel8 extends LEGOBaseDrawerModel {

    /* renamed from: a */
    private String f24507a;

    /* renamed from: b */
    private LEGOBtnTextAndCallback f24508b;

    public LEGODrawerModel8(String str, String str2, LEGOBtnTextAndCallback lEGOBtnTextAndCallback, LEGOBtnTextAndCallback lEGOBtnTextAndCallback2, LEGOBtnTextAndCallback lEGOBtnTextAndCallback3) {
        super(str, lEGOBtnTextAndCallback2);
        this.f24507a = str2;
        this.f24508b = lEGOBtnTextAndCallback;
        addMinorBtn(lEGOBtnTextAndCallback3);
    }

    /* renamed from: a */
    private String m19664a() {
        return this.f24507a;
    }

    /* renamed from: b */
    private LEGOBtnTextAndCallback m19665b() {
        return this.f24508b;
    }

    /* access modifiers changed from: protected */
    public LEGODrawerModel convertOthers(LEGODrawerModel lEGODrawerModel) {
        LEGODrawerModel.WidgetModel widgetModel = new LEGODrawerModel.WidgetModel();
        widgetModel.text = m19664a();
        LEGODrawerModel.WidgetModel widgetModel2 = new LEGODrawerModel.WidgetModel();
        widgetModel2.text = m19665b().getText();
        LEGOBtnModelAndCallback lEGOBtnModelAndCallback = new LEGOBtnModelAndCallback();
        lEGOBtnModelAndCallback.btnModel = widgetModel2;
        lEGOBtnModelAndCallback.listener = m19665b().getListener();
        lEGODrawerModel.leftText = widgetModel;
        lEGODrawerModel.rightBtn = lEGOBtnModelAndCallback;
        lEGODrawerModel.isTwoBtnHorizontal = true;
        return lEGODrawerModel;
    }
}
