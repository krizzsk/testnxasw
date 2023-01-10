package com.didi.component.comp_new_xpanel.template;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.didi.component.business.xengine.model.XpTemplateMsgModel;
import com.didi.sdk.app.DIDIBaseApplication;
import com.taxis99.R;

public class XpMsgTitleLayout extends LinearLayout {

    /* renamed from: a */
    private View f14144a;

    /* renamed from: b */
    private TextView f14145b;

    /* renamed from: c */
    private ImageView f14146c;

    /* renamed from: d */
    private ImageView f14147d;

    /* renamed from: e */
    private TimeTracker f14148e = new TimeTracker();

    public XpMsgTitleLayout(Context context) {
        super(context);
        m11738a(context);
    }

    /* renamed from: a */
    private void m11738a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.g_xp_msg_title_layout, this);
        this.f14144a = inflate;
        this.f14145b = (TextView) inflate.findViewById(R.id.xp_msg_title);
        this.f14146c = (ImageView) this.f14144a.findViewById(R.id.xp_msg_left_to_title_img);
        this.f14147d = (ImageView) this.f14144a.findViewById(R.id.xp_msg_right_to_title_img);
    }

    public boolean isTitleEmpty() {
        return TextUtils.isEmpty(this.f14145b.getText().toString());
    }

    public void update(XpTemplateMsgModel.MsgTemplateData msgTemplateData) {
        if (msgTemplateData.title != null) {
            this.f14145b.setVisibility(0);
            msgTemplateData.title.bindTextView(this.f14145b);
            this.f14148e.trackNullTitle(msgTemplateData.title.getContent());
        } else {
            this.f14145b.setVisibility(8);
        }
        if (!TextUtils.isEmpty(msgTemplateData.titleLeftIcon)) {
            this.f14146c.setVisibility(0);
            Glide.with((Context) DIDIBaseApplication.getAppContext()).load(msgTemplateData.titleLeftIcon).into(this.f14146c);
        } else {
            this.f14146c.setVisibility(8);
        }
        if (!TextUtils.isEmpty(msgTemplateData.titleRightIcon)) {
            this.f14147d.setVisibility(0);
            Glide.with((Context) DIDIBaseApplication.getAppContext()).load(msgTemplateData.titleRightIcon).into(this.f14147d);
            return;
        }
        this.f14147d.setVisibility(8);
    }
}
