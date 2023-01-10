package com.didi.component.comp_new_xpanel.template;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.component.comp_new_xpanel.template.XpTemplateOperationModel;
import com.didiglobal.enginecore.template.temp.IXEView;
import com.taxis99.R;

public class XpTemplateOperationView implements IXEView<XpTemplateOperationModel> {

    /* renamed from: a */
    private Context f14182a;

    /* renamed from: b */
    private View f14183b;

    /* renamed from: c */
    private TextView f14184c;

    /* renamed from: d */
    private TextView f14185d;

    /* renamed from: e */
    private ImageView f14186e;

    public void initView(Context context) {
        this.f14182a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.g_xp_template_operate, (ViewGroup) null);
        this.f14183b = inflate;
        this.f14184c = (TextView) inflate.findViewById(R.id.xp_template_operate_title);
        this.f14185d = (TextView) this.f14183b.findViewById(R.id.xp_template_operate_btn);
        this.f14186e = (ImageView) this.f14183b.findViewById(R.id.xp_template_operate_bg);
    }

    public void bindData(XpTemplateOperationModel xpTemplateOperationModel) {
        if (xpTemplateOperationModel == null || xpTemplateOperationModel.normal == null || xpTemplateOperationModel.normal.data == null) {
            this.f14183b.setVisibility(8);
            return;
        }
        this.f14183b.setVisibility(0);
        XpTemplateOperationModel.OperationTemplateData operationTemplateData = xpTemplateOperationModel.normal.data;
        if (operationTemplateData.title != null) {
            this.f14184c.setVisibility(0);
            operationTemplateData.title.bindTextView(this.f14184c);
        } else {
            this.f14184c.setVisibility(8);
        }
        if (operationTemplateData.button == null || operationTemplateData.button.title == null || TextUtils.isEmpty(operationTemplateData.button.title.getContent())) {
            this.f14185d.setVisibility(8);
        } else {
            this.f14185d.setVisibility(0);
            operationTemplateData.button.bindTextView(xpTemplateOperationModel, this.f14185d, 15);
        }
        if (!TextUtils.isEmpty(operationTemplateData.bgImage)) {
            this.f14186e.setVisibility(0);
            ((RequestBuilder) Glide.with(this.f14182a).load(operationTemplateData.bgImage).centerCrop()).into(this.f14186e);
        } else {
            this.f14186e.setVisibility(8);
        }
        if (operationTemplateData.cardClick != null) {
            operationTemplateData.cardClick.bindView(xpTemplateOperationModel, this.f14183b);
        }
    }

    public View getView() {
        return this.f14183b;
    }
}
