package com.didi.global.globalgenerickit.drawer.templatemodel;

import com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback;
import com.didi.global.globalgenerickit.callback.GGKEditListener;
import com.didi.global.globalgenerickit.drawer.GGKDrawerModel;
import com.didi.global.globalgenerickit.drawer.GGKEditModelAndCallback;

public class GGKDrawerModel12 extends GGKBaseDrawerModel {

    /* renamed from: a */
    private String f24092a;

    /* renamed from: b */
    private GGKEditListener f24093b;

    public GGKDrawerModel12(String str, String str2, GGKEditListener gGKEditListener, GGKBtnTextAndCallback gGKBtnTextAndCallback, GGKBtnTextAndCallback gGKBtnTextAndCallback2) {
        super(str, gGKBtnTextAndCallback);
        this.f24092a = str2;
        this.f24093b = gGKEditListener;
        addMinorBtn(gGKBtnTextAndCallback2);
    }

    public String getHint() {
        return this.f24092a;
    }

    public GGKEditListener getListener() {
        return this.f24093b;
    }

    /* access modifiers changed from: protected */
    public GGKDrawerModel convertOthers(GGKDrawerModel gGKDrawerModel) {
        GGKDrawerModel.EditModel editModel = new GGKDrawerModel.EditModel();
        editModel.hint = getHint();
        GGKEditModelAndCallback gGKEditModelAndCallback = new GGKEditModelAndCallback();
        gGKEditModelAndCallback.model = editModel;
        gGKEditModelAndCallback.listener = getListener();
        gGKDrawerModel.edit = gGKEditModelAndCallback;
        gGKDrawerModel.isTwoBtnHorizontal = true;
        return gGKDrawerModel;
    }
}
