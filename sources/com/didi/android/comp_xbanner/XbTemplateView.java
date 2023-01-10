package com.didi.android.comp_xbanner;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.didiglobal.enginecore.template.temp.IXEView;
import com.didiglobal.enginecore.template.temp.mdel.XEBaseModel;

public class XbTemplateView implements IXEView<XEBaseModel> {

    /* renamed from: a */
    private TextView f9959a;

    public void initView(Context context) {
        this.f9959a = new TextView(context);
    }

    public void bindData(XEBaseModel xEBaseModel) {
        this.f9959a.setText(xEBaseModel.normal.data.title.text);
    }

    public View getView() {
        return this.f9959a;
    }
}
