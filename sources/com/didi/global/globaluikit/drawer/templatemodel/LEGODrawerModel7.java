package com.didi.global.globaluikit.drawer.templatemodel;

import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.drawer.LEGOBtnModelAndCallback;
import com.didi.global.globaluikit.drawer.LEGODrawerModel;

public class LEGODrawerModel7 extends LEGOBaseDrawerModel {

    /* renamed from: a */
    private String f24505a;

    /* renamed from: b */
    private LEGOBtnTextAndCallback f24506b;

    public LEGODrawerModel7(String str, String str2, LEGOBtnTextAndCallback lEGOBtnTextAndCallback, LEGOBtnTextAndCallback lEGOBtnTextAndCallback2) {
        super(str, lEGOBtnTextAndCallback2);
        this.f24505a = str2;
        this.f24506b = lEGOBtnTextAndCallback;
    }

    /* renamed from: a */
    private String m19662a() {
        return this.f24505a;
    }

    /* renamed from: b */
    private LEGOBtnTextAndCallback m19663b() {
        return this.f24506b;
    }

    /* access modifiers changed from: protected */
    public LEGODrawerModel convertOthers(LEGODrawerModel lEGODrawerModel) {
        LEGODrawerModel.WidgetModel widgetModel = new LEGODrawerModel.WidgetModel();
        widgetModel.text = m19662a();
        lEGODrawerModel.leftText = widgetModel;
        LEGODrawerModel.WidgetModel widgetModel2 = new LEGODrawerModel.WidgetModel();
        widgetModel2.text = m19663b().getText();
        LEGOBtnModelAndCallback lEGOBtnModelAndCallback = new LEGOBtnModelAndCallback();
        lEGOBtnModelAndCallback.btnModel = widgetModel2;
        lEGOBtnModelAndCallback.listener = m19663b().getListener();
        lEGODrawerModel.rightBtn = lEGOBtnModelAndCallback;
        return lEGODrawerModel;
    }
}
