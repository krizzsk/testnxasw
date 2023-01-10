package com.didi.global.globaluikit.drawer.templatemodel;

import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;
import com.didi.global.globaluikit.drawer.LEGODrawerModel;
import com.didi.global.globaluikit.drawer.LEGOLinkModelAndCallback;

public class LEGODrawerModel3 extends LEGOBaseDrawerModel {

    /* renamed from: a */
    private String f24495a;

    /* renamed from: b */
    private LEGOOnAntiShakeClickListener f24496b;

    public LEGODrawerModel3(String str, String str2, LEGOOnAntiShakeClickListener lEGOOnAntiShakeClickListener, LEGOBtnTextAndCallback lEGOBtnTextAndCallback) {
        super(str, lEGOBtnTextAndCallback);
        this.f24495a = str2;
        this.f24496b = lEGOOnAntiShakeClickListener;
    }

    /* renamed from: a */
    private String m19650a() {
        return this.f24495a;
    }

    /* renamed from: b */
    private LEGOOnAntiShakeClickListener m19651b() {
        return this.f24496b;
    }

    /* access modifiers changed from: protected */
    public LEGODrawerModel convertOthers(LEGODrawerModel lEGODrawerModel) {
        LEGODrawerModel.WidgetModel widgetModel = new LEGODrawerModel.WidgetModel();
        widgetModel.text = m19650a();
        LEGOLinkModelAndCallback lEGOLinkModelAndCallback = new LEGOLinkModelAndCallback();
        lEGOLinkModelAndCallback.linkModel = widgetModel;
        lEGOLinkModelAndCallback.listener = m19651b();
        lEGODrawerModel.link = lEGOLinkModelAndCallback;
        return lEGODrawerModel;
    }
}
