package com.didi.global.globaluikit.drawer.templatemodel;

import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;
import com.didi.global.globaluikit.drawer.LEGODrawerModel;
import com.didi.global.globaluikit.drawer.LEGOLinkModelAndCallback;

public class LEGODrawerModel4 extends LEGOBaseDrawerModel {

    /* renamed from: a */
    private String f24497a;

    /* renamed from: b */
    private LEGOOnAntiShakeClickListener f24498b;

    public LEGODrawerModel4(String str, String str2, LEGOOnAntiShakeClickListener lEGOOnAntiShakeClickListener, LEGOBtnTextAndCallback lEGOBtnTextAndCallback, LEGOBtnTextAndCallback lEGOBtnTextAndCallback2) {
        super(str, lEGOBtnTextAndCallback);
        this.f24497a = str2;
        this.f24498b = lEGOOnAntiShakeClickListener;
        addMinorBtn(lEGOBtnTextAndCallback2);
    }

    /* renamed from: a */
    private String m19652a() {
        return this.f24497a;
    }

    /* renamed from: b */
    private LEGOOnAntiShakeClickListener m19653b() {
        return this.f24498b;
    }

    /* access modifiers changed from: protected */
    public LEGODrawerModel convertOthers(LEGODrawerModel lEGODrawerModel) {
        LEGODrawerModel.WidgetModel widgetModel = new LEGODrawerModel.WidgetModel();
        widgetModel.text = m19652a();
        LEGOLinkModelAndCallback lEGOLinkModelAndCallback = new LEGOLinkModelAndCallback();
        lEGOLinkModelAndCallback.linkModel = widgetModel;
        lEGOLinkModelAndCallback.listener = m19653b();
        lEGODrawerModel.link = lEGOLinkModelAndCallback;
        lEGODrawerModel.isTwoBtnHorizontal = true;
        return lEGODrawerModel;
    }
}
