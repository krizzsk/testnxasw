package com.didi.component.comp_new_xpanel.template;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.xpanelnew.OmegaXPTrack;
import com.didi.component.common.util.UIUtils;
import com.didi.component.comp_new_xpanel.template.XpTemplateBizModel;
import com.didi.drouter.api.DRouter;
import com.didiglobal.enginecore.template.temp.IXEView;
import com.taxis99.R;

public class XpTemplateBizView implements IXEView<XpTemplateBizModel> {

    /* renamed from: a */
    private View f14153a;

    /* renamed from: b */
    private View f14154b;

    /* renamed from: c */
    private TextView f14155c;

    /* renamed from: d */
    private TextView f14156d;

    /* renamed from: e */
    private View f14157e;

    /* renamed from: f */
    private TextView f14158f;

    /* renamed from: g */
    private TextView f14159g;

    /* renamed from: h */
    private View f14160h;

    /* renamed from: i */
    private TextView f14161i;

    /* renamed from: j */
    private TextView f14162j;

    /* renamed from: k */
    private ImageView f14163k;

    /* renamed from: l */
    private Context f14164l;

    public void initView(Context context) {
        this.f14164l = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.g_xp_template_biz, (ViewGroup) null);
        this.f14153a = inflate;
        this.f14154b = inflate.findViewById(R.id.xp_template_biz_layout_left_img);
        this.f14155c = (TextView) this.f14153a.findViewById(R.id.xp_template_biz_title);
        this.f14156d = (TextView) this.f14153a.findViewById(R.id.xp_template_biz_subtitle);
        this.f14157e = this.f14153a.findViewById(R.id.xp_template_biz_btn_horizontal);
        this.f14158f = (TextView) this.f14153a.findViewById(R.id.xp_template_biz_btn_left);
        this.f14159g = (TextView) this.f14153a.findViewById(R.id.xp_template_biz_btn_right);
        this.f14160h = this.f14153a.findViewById(R.id.xp_template_biz_btn_vertical);
        this.f14161i = (TextView) this.f14153a.findViewById(R.id.xp_template_biz_btn_up);
        this.f14162j = (TextView) this.f14153a.findViewById(R.id.xp_template_biz_btn_bottom);
        this.f14163k = (ImageView) this.f14153a.findViewById(R.id.xp_template_biz_image);
    }

    public void bindData(final XpTemplateBizModel xpTemplateBizModel) {
        if (xpTemplateBizModel == null || xpTemplateBizModel.normal == null || xpTemplateBizModel.normal.data == null) {
            this.f14153a.setVisibility(8);
            return;
        }
        this.f14153a.setVisibility(0);
        final XpTemplateBizModel.BizTemplateData bizTemplateData = xpTemplateBizModel.normal.data;
        if (bizTemplateData.title != null) {
            this.f14155c.setVisibility(0);
            bizTemplateData.title.bindTextView(this.f14155c);
        } else {
            this.f14155c.setVisibility(8);
        }
        if (bizTemplateData.subtitle != null) {
            this.f14156d.setVisibility(0);
            bizTemplateData.subtitle.bindTextView(this.f14156d);
        } else {
            this.f14156d.setVisibility(8);
        }
        if (bizTemplateData.buttons != null) {
            if (bizTemplateData.buttons.style == 0 && bizTemplateData.buttons.buttonList != null && bizTemplateData.buttons.buttonList.size() > 0) {
                this.f14157e.setVisibility(0);
                this.f14160h.setVisibility(8);
                if (bizTemplateData.buttons.buttonList.size() == 1) {
                    this.f14158f.setVisibility(0);
                    if (this.f14158f.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                        ((LinearLayout.LayoutParams) this.f14158f.getLayoutParams()).weight = 0.0f;
                    }
                    this.f14159g.setVisibility(8);
                    if (bizTemplateData.buttons.buttonList.get(0) == null || bizTemplateData.buttons.buttonList.get(0).title == null) {
                        this.f14158f.setVisibility(8);
                    } else {
                        bizTemplateData.buttons.buttonList.get(0).bindTextView(xpTemplateBizModel, this.f14158f, 15);
                    }
                } else if (bizTemplateData.buttons.buttonList.size() == 2) {
                    this.f14158f.setVisibility(0);
                    this.f14159g.setVisibility(0);
                    if (bizTemplateData.buttons.buttonList.get(0) == null || bizTemplateData.buttons.buttonList.get(0).title == null) {
                        this.f14158f.setVisibility(8);
                    } else {
                        bizTemplateData.buttons.buttonList.get(0).bindTextView(xpTemplateBizModel, this.f14158f, 15);
                    }
                    if (bizTemplateData.buttons.buttonList.get(1) == null || bizTemplateData.buttons.buttonList.get(1).title == null) {
                        this.f14159g.setVisibility(8);
                    } else {
                        bizTemplateData.buttons.buttonList.get(1).bindTextView(xpTemplateBizModel, this.f14159g, 15);
                    }
                }
            } else if (bizTemplateData.buttons.style == 1 && bizTemplateData.buttons.buttonList != null && bizTemplateData.buttons.buttonList.size() > 0) {
                this.f14157e.setVisibility(8);
                this.f14160h.setVisibility(0);
                if (bizTemplateData.buttons.buttonList.size() == 1) {
                    this.f14161i.setVisibility(0);
                    this.f14162j.setVisibility(8);
                    if (bizTemplateData.buttons.buttonList.get(0) == null || bizTemplateData.buttons.buttonList.get(0).title == null) {
                        this.f14161i.setVisibility(8);
                    } else {
                        bizTemplateData.buttons.buttonList.get(0).bindTextView(xpTemplateBizModel, this.f14161i, 15);
                    }
                } else if (bizTemplateData.buttons.buttonList.size() == 2) {
                    this.f14161i.setVisibility(0);
                    this.f14162j.setVisibility(0);
                    if (bizTemplateData.buttons.buttonList.get(0) == null || bizTemplateData.buttons.buttonList.get(0).title == null) {
                        this.f14161i.setVisibility(8);
                    } else {
                        bizTemplateData.buttons.buttonList.get(0).bindTextView(xpTemplateBizModel, this.f14161i, 15);
                    }
                    if (bizTemplateData.buttons.buttonList.get(1) == null || bizTemplateData.buttons.buttonList.get(1).title == null) {
                        this.f14162j.setVisibility(8);
                    } else {
                        bizTemplateData.buttons.buttonList.get(1).bindTextView(xpTemplateBizModel, this.f14162j, 15);
                    }
                }
            }
        }
        if (!(this.f14157e.getVisibility() == 0 || this.f14160h.getVisibility() == 0)) {
            if (this.f14156d.getVisibility() != 0) {
                this.f14155c.setLines(2);
                if (this.f14155c.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                    ((LinearLayout.LayoutParams) this.f14155c.getLayoutParams()).bottomMargin = UIUtils.dip2pxInt(this.f14164l, 24.0f);
                }
            } else if (this.f14155c.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) this.f14156d.getLayoutParams()).bottomMargin = UIUtils.dip2pxInt(this.f14164l, 24.0f);
            }
        }
        if (bizTemplateData.rightIcon == null || TextUtils.isEmpty(bizTemplateData.rightIcon.url)) {
            this.f14163k.setVisibility(8);
        } else {
            this.f14163k.setVisibility(0);
            RequestBuilder<Drawable> load = Glide.with(this.f14164l).load(bizTemplateData.rightIcon.url);
            int i = bizTemplateData.rightIcon.position;
            if (i == 0) {
                this.f14163k.setScaleType(ImageView.ScaleType.FIT_START);
                load.into(this.f14163k);
            } else if (i == 1) {
                ((RequestBuilder) load.fitCenter()).into(this.f14163k);
            } else if (i == 2) {
                this.f14163k.setScaleType(ImageView.ScaleType.FIT_END);
                load.into(this.f14163k);
            }
        }
        if (bizTemplateData.bgColor != null) {
            bizTemplateData.bgColor.bindView(this.f14153a, 0);
        }
        if (bizTemplateData.cardClick != null && !TextUtils.isEmpty(bizTemplateData.cardClick.url)) {
            this.f14153a.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    XpTemplateBizModel xpTemplateBizModel = xpTemplateBizModel;
                    if (xpTemplateBizModel != null) {
                        OmegaXPTrack.omegaTrackWhenClickCard(xpTemplateBizModel);
                    }
                    DRouter.build(bizTemplateData.cardClick.url).start();
                }
            });
        }
    }

    public View getView() {
        return this.f14153a;
    }
}
