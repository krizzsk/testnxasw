package com.didiglobal.eevee.mew.widget;

import android.content.Context;
import android.view.View;
import com.didiglobal.enginecore.template.temp.IXEView;

public class VpTemplateView implements IXEView<VpTemplateModel> {

    /* renamed from: a */
    private VpTemplateFrameLayout f52653a;

    public void initView(Context context) {
        this.f52653a = new VpTemplateFrameLayout(context);
    }

    public void bindData(VpTemplateModel vpTemplateModel) {
        this.f52653a.bindData(vpTemplateModel);
    }

    public View getView() {
        return this.f52653a;
    }
}
