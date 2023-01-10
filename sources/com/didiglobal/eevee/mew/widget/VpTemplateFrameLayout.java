package com.didiglobal.eevee.mew.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.drouter.api.DRouter;
import com.didiglobal.common.common.util.EeveeRichTextUtil;
import com.didiglobal.eevee.mew.widget.VpTemplateModel;
import com.didiglobal.mew.framework.MUIUtils;
import com.taxis99.R;

public class VpTemplateFrameLayout extends FrameLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f52646a;

    /* renamed from: b */
    private ImageView f52647b;

    /* renamed from: c */
    private TextView f52648c;

    /* renamed from: d */
    private View f52649d;

    /* renamed from: e */
    private TextView f52650e;

    /* renamed from: f */
    private ImageView f52651f;

    /* renamed from: g */
    private LinearLayout f52652g;

    public VpTemplateFrameLayout(Context context) {
        super(context);
        this.f52646a = context;
        m39531a();
    }

    public VpTemplateFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f52646a = context;
        m39531a();
    }

    public VpTemplateFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f52646a = context;
        m39531a();
    }

    /* renamed from: a */
    private void m39531a() {
        setLayoutParams(new FrameLayout.LayoutParams(-1, MUIUtils.getStatusBarHeight(getContext()) + MUIUtils.dip2pxInt(getContext(), 390.0f)));
        setPadding(0, MUIUtils.getStatusBarHeight(getContext()), 0, 0);
        LayoutInflater.from(getContext()).inflate(R.layout.vp_template_item_layout, this);
        this.f52647b = (ImageView) findViewById(R.id.vp_template_bg);
        this.f52648c = (TextView) findViewById(R.id.vp_template_title);
        this.f52649d = findViewById(R.id.vp_template_btn_layout);
        this.f52650e = (TextView) findViewById(R.id.vp_template_btn);
        this.f52651f = (ImageView) findViewById(R.id.vp_template_btn_arrow);
        this.f52652g = (LinearLayout) findViewById(R.id.vp_layout_title);
    }

    public void bindData(VpTemplateModel vpTemplateModel) {
        if (vpTemplateModel != null && vpTemplateModel.normal != null && vpTemplateModel.normal.data != null) {
            final VpTemplateModel.VpNormalData vpNormalData = vpTemplateModel.normal.data;
            if (!TextUtils.isEmpty(vpNormalData.background)) {
                Glide.with((View) this).load(vpNormalData.background).into(this.f52647b);
            }
            if (vpNormalData.title != null) {
                EeveeRichTextUtil.setText(this.f52648c, vpNormalData.title);
            }
            if (vpNormalData.buttonTitle != null) {
                this.f52649d.setVisibility(0);
                if (vpNormalData.buttonTitle.title != null) {
                    this.f52650e.setVisibility(0);
                    EeveeRichTextUtil.setText(this.f52650e, vpNormalData.buttonTitle.title);
                } else {
                    this.f52650e.setVisibility(8);
                }
                if (!TextUtils.isEmpty(vpNormalData.buttonTitle.url)) {
                    this.f52651f.setVisibility(0);
                    this.f52649d.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            AutoTrackHelper.trackViewOnClick(view);
                            if (VpTemplateFrameLayout.this.f52646a != null) {
                                DRouter.build(vpNormalData.buttonTitle.url).start(VpTemplateFrameLayout.this.f52646a);
                            }
                        }
                    });
                    if (!TextUtils.isEmpty(vpNormalData.buttonArrow)) {
                        Glide.with((View) this).load(vpNormalData.buttonArrow).into(this.f52651f);
                        return;
                    }
                    return;
                }
                this.f52651f.setVisibility(8);
                return;
            }
            this.f52649d.setVisibility(8);
        }
    }
}
