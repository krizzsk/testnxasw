package com.didi.global.globaluikit.drawer.templatemodel;

import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.callback.LEGOCheckboxListener;
import com.didi.global.globaluikit.drawer.LEGOCheckboxModelAndCallback;
import com.didi.global.globaluikit.drawer.LEGODrawerModel;

public class LEGODrawerModel5 extends LEGOBaseDrawerModel {

    /* renamed from: a */
    private String f24499a;

    /* renamed from: b */
    private LEGOCheckboxListener f24500b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f24501c;

    public LEGODrawerModel5(String str, String str2, boolean z, LEGOCheckboxListener lEGOCheckboxListener, LEGOBtnTextAndCallback lEGOBtnTextAndCallback) {
        super(str, lEGOBtnTextAndCallback);
        this.f24499a = str2;
        this.f24501c = z;
        this.f24500b = lEGOCheckboxListener;
    }

    /* renamed from: a */
    private String m19655a() {
        return this.f24499a;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public LEGOCheckboxListener m19657b() {
        return this.f24500b;
    }

    public boolean getChecked() {
        return this.f24501c;
    }

    /* access modifiers changed from: protected */
    public LEGODrawerModel convertOthers(LEGODrawerModel lEGODrawerModel) {
        LEGODrawerModel.WidgetModel widgetModel = new LEGODrawerModel.WidgetModel();
        widgetModel.text = m19655a();
        LEGOCheckboxModelAndCallback lEGOCheckboxModelAndCallback = new LEGOCheckboxModelAndCallback();
        lEGOCheckboxModelAndCallback.cbModel = widgetModel;
        lEGOCheckboxModelAndCallback.checked = getChecked();
        lEGOCheckboxModelAndCallback.listener = new LEGOCheckboxListener() {
            public void onCheckedChanged(boolean z) {
                boolean unused = LEGODrawerModel5.this.f24501c = z;
                LEGODrawerModel5.this.m19657b().onCheckedChanged(z);
            }
        };
        lEGODrawerModel.checkbox = lEGOCheckboxModelAndCallback;
        return lEGODrawerModel;
    }
}
