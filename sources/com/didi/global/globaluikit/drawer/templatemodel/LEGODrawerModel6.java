package com.didi.global.globaluikit.drawer.templatemodel;

import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.callback.LEGOCheckboxListener;
import com.didi.global.globaluikit.drawer.LEGOCheckboxModelAndCallback;
import com.didi.global.globaluikit.drawer.LEGODrawerModel;

public class LEGODrawerModel6 extends LEGOBaseDrawerModel {

    /* renamed from: a */
    private String f24502a;

    /* renamed from: b */
    private LEGOCheckboxListener f24503b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f24504c;

    public LEGODrawerModel6(String str, String str2, boolean z, LEGOCheckboxListener lEGOCheckboxListener, LEGOBtnTextAndCallback lEGOBtnTextAndCallback, LEGOBtnTextAndCallback lEGOBtnTextAndCallback2) {
        super(str, lEGOBtnTextAndCallback);
        this.f24502a = str2;
        this.f24504c = z;
        this.f24503b = lEGOCheckboxListener;
        addMinorBtn(lEGOBtnTextAndCallback2);
    }

    /* renamed from: a */
    private String m19659a() {
        return this.f24502a;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public LEGOCheckboxListener m19661b() {
        return this.f24503b;
    }

    public boolean getChecked() {
        return this.f24504c;
    }

    /* access modifiers changed from: protected */
    public LEGODrawerModel convertOthers(LEGODrawerModel lEGODrawerModel) {
        LEGODrawerModel.WidgetModel widgetModel = new LEGODrawerModel.WidgetModel();
        widgetModel.text = m19659a();
        LEGOCheckboxModelAndCallback lEGOCheckboxModelAndCallback = new LEGOCheckboxModelAndCallback();
        lEGOCheckboxModelAndCallback.cbModel = widgetModel;
        lEGOCheckboxModelAndCallback.checked = getChecked();
        lEGOCheckboxModelAndCallback.listener = new LEGOCheckboxListener() {
            public void onCheckedChanged(boolean z) {
                boolean unused = LEGODrawerModel6.this.f24504c = z;
                LEGODrawerModel6.this.m19661b().onCheckedChanged(z);
            }
        };
        lEGODrawerModel.checkbox = lEGOCheckboxModelAndCallback;
        lEGODrawerModel.isTwoBtnHorizontal = true;
        return lEGODrawerModel;
    }
}
