package com.didi.global.globalgenerickit.drawer.templatemodel;

import com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback;
import com.didi.global.globalgenerickit.callback.GGKEditListener;
import com.didi.global.globalgenerickit.drawer.GGKDrawerModel;
import com.didi.global.globalgenerickit.drawer.GGKEditModelAndCallback;

public class GGKDrawerModel11 extends GGKBaseDrawerModel {

    /* renamed from: a */
    private String f24090a;

    /* renamed from: b */
    private GGKEditListener f24091b;

    public GGKDrawerModel11(String str, String str2, GGKEditListener gGKEditListener, GGKBtnTextAndCallback gGKBtnTextAndCallback) {
        super(str, gGKBtnTextAndCallback);
        this.f24090a = str2;
        this.f24091b = gGKEditListener;
    }

    public String getHint() {
        return this.f24090a;
    }

    public GGKEditListener getListener() {
        return this.f24091b;
    }

    /* access modifiers changed from: protected */
    public GGKDrawerModel convertOthers(GGKDrawerModel gGKDrawerModel) {
        GGKDrawerModel.EditModel editModel = new GGKDrawerModel.EditModel();
        editModel.hint = getHint();
        GGKEditModelAndCallback gGKEditModelAndCallback = new GGKEditModelAndCallback();
        gGKEditModelAndCallback.model = editModel;
        gGKEditModelAndCallback.listener = getListener();
        gGKDrawerModel.edit = gGKEditModelAndCallback;
        return gGKDrawerModel;
    }
}
