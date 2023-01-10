package com.didi.global.globalgenerickit.view;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.global.globalgenerickit.model.ComponentConfigBannerModel;
import com.didi.global.globalgenerickit.utils.OmegaUtils;
import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.taxis99.R;

public class ComponentConfigBannerView extends RelativeLayout {

    /* renamed from: a */
    private ImageView f24255a;

    /* renamed from: b */
    private ImageView f24256b;

    /* renamed from: c */
    private TextView f24257c;

    /* renamed from: d */
    private RelativeLayout f24258d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ComponentConfigBannerModel f24259e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public View.OnClickListener f24260f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public LEGORichInfo.RichInfoClickListener f24261g;

    /* renamed from: h */
    private TextView f24262h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public LEGORichInfo.RichInfoClickListener f24263i = new LEGORichInfo.RichInfoClickListener() {
        public void onClick(String str) {
            if (ComponentConfigBannerView.this.f24261g != null) {
                ComponentConfigBannerView.this.f24261g.onClick(str);
            }
        }
    };

    public ComponentConfigBannerView(Context context) {
        super(context);
        m19538a(context);
    }

    public ComponentConfigBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m19538a(context);
    }

    public ComponentConfigBannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m19538a(context);
    }

    /* renamed from: a */
    private void m19538a(Context context) {
        inflate(context, R.layout.ggk_component_config_banner_view, this);
        this.f24257c = (TextView) findViewById(R.id.content);
        this.f24262h = (TextView) findViewById(R.id.sub_content);
        this.f24256b = (ImageView) findViewById(R.id.close);
        this.f24255a = (ImageView) findViewById(R.id.icon);
        this.f24258d = (RelativeLayout) findViewById(R.id.container);
        this.f24256b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                OmegaUtils.trackComponentConfigBannerCK(ComponentConfigBannerView.this.f24259e, "banner_close");
                if (ComponentConfigBannerView.this.f24260f != null) {
                    ComponentConfigBannerView.this.f24260f.onClick(view);
                }
            }
        });
    }

    public void setData(final ComponentConfigBannerModel componentConfigBannerModel) {
        if (componentConfigBannerModel != null) {
            this.f24259e = componentConfigBannerModel;
            if (componentConfigBannerModel.businessData != null) {
                if (!TextUtils.isEmpty(componentConfigBannerModel.businessData.iconUrl)) {
                    Glide.with(getContext()).load(componentConfigBannerModel.businessData.iconUrl).into(this.f24255a);
                }
                if (!TextUtils.isEmpty(componentConfigBannerModel.businessData.closeUrl)) {
                    Glide.with(getContext()).load(componentConfigBannerModel.businessData.closeUrl).into(this.f24256b);
                }
                if (!TextUtils.isEmpty(componentConfigBannerModel.businessData.title)) {
                    this.f24257c.setText(componentConfigBannerModel.businessData.title);
                }
                if (!TextUtils.isEmpty(componentConfigBannerModel.businessData.titleColor)) {
                    try {
                        this.f24257c.setTextColor(Color.parseColor(componentConfigBannerModel.businessData.titleColor));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (!TextUtils.isEmpty(componentConfigBannerModel.businessData.bgColor)) {
                    try {
                        this.f24258d.setBackgroundColor(Color.parseColor(componentConfigBannerModel.businessData.bgColor));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                if (componentConfigBannerModel.businessData.titleSize > 0) {
                    this.f24257c.setTextSize((float) componentConfigBannerModel.businessData.titleSize);
                }
                LEGORichInfo lEGORichInfo = componentConfigBannerModel.businessData.titleRich;
                LEGORichInfo lEGORichInfo2 = componentConfigBannerModel.businessData.subTitleRich;
                if (lEGORichInfo != null && !TextUtils.isEmpty(lEGORichInfo.getContent())) {
                    lEGORichInfo.bindTextView(this.f24257c);
                    lEGORichInfo.setOnClickListener(this.f24263i);
                }
                if (lEGORichInfo2 == null || TextUtils.isEmpty(lEGORichInfo2.getContent())) {
                    this.f24262h.setVisibility(8);
                } else {
                    this.f24262h.setVisibility(0);
                    this.f24257c.setMaxLines(1);
                    lEGORichInfo2.bindTextView(this.f24262h);
                    lEGORichInfo2.setOnClickListener(this.f24263i);
                }
                this.f24258d.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        if (ComponentConfigBannerView.this.f24263i != null) {
                            ComponentConfigBannerView.this.f24263i.onClick(componentConfigBannerModel.businessData.link);
                        }
                    }
                });
            }
        }
    }

    public void setCloseClickListener(View.OnClickListener onClickListener) {
        this.f24260f = onClickListener;
    }

    public void setOnLinkClickListener(LEGORichInfo.RichInfoClickListener richInfoClickListener) {
        this.f24261g = richInfoClickListener;
    }
}
