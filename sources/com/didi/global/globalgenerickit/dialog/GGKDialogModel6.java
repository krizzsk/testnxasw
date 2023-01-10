package com.didi.global.globalgenerickit.dialog;

import com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback;
import com.didi.global.globalgenerickit.dialog.GGKRealUsedModel;
import java.util.ArrayList;
import java.util.List;

public class GGKDialogModel6 extends GGKBaseDialogModel {

    /* renamed from: a */
    private String f23997a;

    /* renamed from: b */
    private List<String> f23998b;

    public GGKDialogModel6(String str, List<String> list, GGKBtnTextAndCallback gGKBtnTextAndCallback) {
        super(gGKBtnTextAndCallback);
        this.f23997a = str;
        this.f23998b = list;
    }

    public String getSubTitle() {
        return this.f23997a;
    }

    public List<String> getSubContents() {
        return this.f23998b;
    }

    /* access modifiers changed from: protected */
    public void convertOthers(GGKRealUsedModel gGKRealUsedModel) {
        gGKRealUsedModel.f24013k = new GGKRealUsedModel.TextWidgetModel();
        gGKRealUsedModel.f24013k.text = getSubTitle();
        ArrayList arrayList = new ArrayList();
        for (String str : getSubContents()) {
            GGKRealUsedModel.TextWidgetModel textWidgetModel = new GGKRealUsedModel.TextWidgetModel();
            textWidgetModel.text = str;
            arrayList.add(textWidgetModel);
        }
        gGKRealUsedModel.f24014l = arrayList;
    }
}
