package com.didi.global.globaluikit.drawer;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.airbnb.lottie.LottieAnimationView;
import com.android.didi.theme.DidiThemeManager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.integration.webp.decoder.WebpDrawable;
import com.bumptech.glide.integration.webp.decoder.WebpDrawableTransformation;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.global.globaluikit.LEGOUIKit;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener2;
import com.didi.global.globaluikit.config.LEGOUIConfig;
import com.didi.global.globaluikit.utils.UiUtils;
import com.didi.global.globaluikit.widget.RoundCornerRelativeLayout;
import com.taxis99.R;

public final class LEGODrawer extends LEGOAbsDrawer {

    /* renamed from: A */
    private TextView f24462A;

    /* renamed from: B */
    private View f24463B;

    /* renamed from: C */
    private boolean f24464C;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public LEGODrawerModel f24465a;

    /* renamed from: b */
    private View f24466b;

    /* renamed from: c */
    private View f24467c;

    /* renamed from: d */
    private View f24468d;

    /* renamed from: e */
    private View f24469e;

    /* renamed from: f */
    private View f24470f;

    /* renamed from: g */
    private View f24471g;

    /* renamed from: h */
    private ImageView f24472h;

    /* renamed from: i */
    private RoundCornerRelativeLayout f24473i;

    /* renamed from: j */
    private ImageView f24474j;

    /* renamed from: k */
    private TextView f24475k;

    /* renamed from: l */
    private TextView f24476l;

    /* renamed from: m */
    private FrameLayout f24477m;

    /* renamed from: n */
    private FrameLayout f24478n;

    /* renamed from: o */
    private FrameLayout f24479o;

    /* renamed from: p */
    private TextView f24480p;

    /* renamed from: q */
    private TextView f24481q;

    /* renamed from: r */
    private TextView f24482r;

    /* renamed from: s */
    private CheckBox f24483s;

    /* renamed from: t */
    private TextView f24484t;

    /* renamed from: u */
    private TextView f24485u;

    /* renamed from: v */
    private TextView f24486v;

    /* renamed from: w */
    private LottieAnimationView f24487w;

    /* renamed from: x */
    private TextView f24488x;

    /* renamed from: y */
    private LottieAnimationView f24489y;

    /* renamed from: z */
    private TextView f24490z;

    /* access modifiers changed from: protected */
    public int getCustomView() {
        return R.layout.lego_drawer_common_layout;
    }

    public LEGODrawer(Context context, LEGODrawerModel lEGODrawerModel) {
        super(context);
        this.f24465a = lEGODrawerModel;
        setLoadingEnable(lEGODrawerModel.isLoadingEnable);
    }

    /* access modifiers changed from: protected */
    public boolean onShowPrepare() {
        m19645g();
        m19644f();
        m19631a();
        m19643e();
        m19642d();
        m19641c();
        m19639b();
        setDismissListener(this.f24465a.dismissListener);
        if (this.f24465a.clickOutsideCanCancel) {
            setCanceledOnTouchOutside(true);
        }
        if (this.f24465a.backPressedEnabled) {
            setBackPressedEnabled(true);
        }
        if (this.f24465a.isShowCloseImg && this.f24465a.mCloseImgListener == null) {
            this.f24472h.setVisibility(0);
            this.f24472h.setOnClickListener(new LEGOOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    LEGODrawer.this.dismiss();
                }
            });
        } else if (this.f24465a.isShowCloseImg) {
            this.f24472h.setVisibility(0);
            this.f24472h.setOnClickListener(new LEGOOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    LEGODrawer.this.f24465a.mCloseImgListener.onAntiShakeClick(view);
                    LEGODrawer.this.dismiss();
                }
            });
        } else {
            this.f24472h.setVisibility(8);
            this.f24472h.setOnClickListener((View.OnClickListener) null);
        }
        return true;
    }

    /* renamed from: a */
    private void m19631a() {
        if (this.f24465a.allExtendView != null) {
            this.f24479o.setVisibility(0);
            this.f24479o.addView(this.f24465a.allExtendView);
            this.f24466b.setVisibility(8);
            return;
        }
        this.f24479o.setVisibility(8);
        if (this.f24465a.extendedUpView != null) {
            this.f24477m.setVisibility(0);
            this.f24477m.addView(this.f24465a.extendedUpView);
        } else {
            this.f24477m.setVisibility(8);
        }
        if (this.f24465a.extendedBottomView != null) {
            this.f24478n.setVisibility(0);
            this.f24478n.addView(this.f24465a.extendedBottomView);
        } else {
            this.f24478n.setVisibility(8);
        }
        if (this.f24465a.extendedView != null) {
            this.f24479o.setVisibility(0);
            this.f24479o.addView(this.f24465a.extendedView);
            this.f24466b.setVisibility(0);
            this.f24475k.setVisibility(8);
            this.f24476l.setVisibility(8);
            return;
        }
        this.f24479o.setVisibility(8);
    }

    /* renamed from: b */
    private void m19639b() {
        if (this.f24465a.majorBtn != null && (this.f24465a.minorBtns == null || this.f24465a.minorBtns.size() == 0)) {
            m19633a(0, 8);
            m19634a(this.f24488x, this.f24465a.majorBtn);
        } else if (this.f24465a.majorBtn != null && this.f24465a.minorBtns.size() == 1 && this.f24465a.isTwoBtnHorizontal) {
            m19633a(8, 0);
            m19634a(this.f24486v, this.f24465a.majorBtn);
            m19634a(this.f24485u, this.f24465a.minorBtns.get(0));
        } else if (this.f24465a.majorBtn != null && this.f24465a.minorBtns.size() == 1) {
            m19633a(0, 8);
            m19634a(this.f24488x, this.f24465a.majorBtn);
            m19634a(this.f24490z, this.f24465a.minorBtns.get(0));
        } else if (this.f24465a.majorBtn == null || this.f24465a.minorBtns.size() != 2) {
            m19633a(8, 8);
        } else {
            m19633a(0, 8);
            m19634a(this.f24488x, this.f24465a.majorBtn);
            m19634a(this.f24490z, this.f24465a.minorBtns.get(0));
            m19634a(this.f24462A, this.f24465a.minorBtns.get(1));
        }
        if ((this.f24465a.checkbox == null || this.f24465a.checkbox.cbModel == null || this.f24465a.checkbox.listener == null) && (this.f24465a.mRichCheckbox == null || this.f24465a.mCheckListener == null)) {
            m19632a(40);
        } else {
            m19632a(22);
        }
        if (this.f24465a.allExtendView != null) {
            m19633a(8, 8);
        }
    }

    /* renamed from: a */
    private void m19632a(int i) {
        if (this.f24470f.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f24470f.getLayoutParams();
            layoutParams.topMargin = UiUtils.dip2px(this.mContext, (float) i);
            this.f24470f.setLayoutParams(layoutParams);
        } else if (this.f24471g.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f24471g.getLayoutParams();
            layoutParams2.topMargin = UiUtils.dip2px(this.mContext, (float) i);
            this.f24471g.setLayoutParams(layoutParams2);
        }
    }

    /* renamed from: a */
    private void m19634a(TextView textView, final LEGOBtnModelAndCallback lEGOBtnModelAndCallback) {
        textView.setVisibility(0);
        lEGOBtnModelAndCallback.btnModel.bind(textView);
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                LEGODrawer.this.m19635a(lEGOBtnModelAndCallback, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m19635a(LEGOBtnModelAndCallback lEGOBtnModelAndCallback, View view) {
        if (lEGOBtnModelAndCallback.listener instanceof LEGOOnAntiShakeClickListener2) {
            ((LEGOOnAntiShakeClickListener2) lEGOBtnModelAndCallback.listener).onClick(this);
        } else {
            lEGOBtnModelAndCallback.listener.onClick(view);
        }
    }

    /* renamed from: a */
    private void m19633a(int i, int i2) {
        this.f24471g.setVisibility(i);
        this.f24470f.setVisibility(i2);
    }

    /* renamed from: c */
    private void m19641c() {
        if (this.f24465a.mRichCheckbox == null || this.f24465a.mCheckListener == null) {
            this.f24469e.setVisibility(8);
            if (this.f24465a.checkbox == null || this.f24465a.checkbox.cbModel == null || this.f24465a.checkbox.listener == null) {
                this.f24469e.setVisibility(8);
                return;
            }
            this.f24469e.setVisibility(0);
            this.f24465a.checkbox.cbModel.bind(this.f24484t);
            this.f24483s.setChecked(this.f24465a.checkbox.checked);
            this.f24483s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    AutoTrackHelper.trackViewOnClick(compoundButton, z);
                    LEGODrawer.this.f24465a.checkbox.listener.onCheckedChanged(z);
                }
            });
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f24469e.getLayoutParams();
            layoutParams.topMargin = UiUtils.dip2px(this.mContext, 22.0f);
            this.f24469e.setLayoutParams(layoutParams);
            return;
        }
        this.f24469e.setVisibility(0);
        this.f24465a.mRichCheckbox.bindTextView(this.f24484t);
        this.f24483s.setChecked(this.f24465a.mIsChecked);
        this.f24483s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AutoTrackHelper.trackViewOnClick(compoundButton, z);
                LEGODrawer.this.f24465a.mIsChecked = z;
                LEGODrawer.this.f24465a.mCheckListener.onCheckedChanged(z);
            }
        });
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f24469e.getLayoutParams();
        layoutParams2.topMargin = UiUtils.dip2px(this.mContext, 22.0f);
        this.f24469e.setLayoutParams(layoutParams2);
    }

    /* renamed from: d */
    private void m19642d() {
        if (this.f24465a.mRichLink == null || this.f24465a.mLinkListener == null) {
            this.f24468d.setVisibility(8);
            if (this.f24465a.link == null || this.f24465a.link.linkModel == null || this.f24465a.link.listener == null) {
                this.f24468d.setVisibility(8);
                return;
            }
            this.f24468d.setVisibility(0);
            this.f24465a.link.linkModel.bind(this.f24482r);
            this.f24482r.setOnClickListener(this.f24465a.link.listener);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f24468d.getLayoutParams();
            layoutParams.topMargin = UiUtils.dip2px(this.mContext, 40.0f);
            this.f24468d.setLayoutParams(layoutParams);
            return;
        }
        this.f24468d.setVisibility(0);
        this.f24465a.mRichLink.bindTextView(this.f24482r);
        this.f24482r.setOnClickListener(this.f24465a.mLinkListener);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f24468d.getLayoutParams();
        layoutParams2.topMargin = UiUtils.dip2px(this.mContext, 40.0f);
        this.f24468d.setLayoutParams(layoutParams2);
    }

    /* renamed from: e */
    private void m19643e() {
        if (this.f24465a.mRichLeft == null || this.f24465a.mRightBtn == null || this.f24465a.mRightBtn.btnModel == null || this.f24465a.mRightBtn.listener == null) {
            this.f24467c.setVisibility(8);
            if (this.f24465a.leftText == null || this.f24465a.rightBtn == null) {
                this.f24467c.setVisibility(8);
                return;
            }
            this.f24467c.setVisibility(0);
            this.f24465a.leftText.bind(this.f24481q);
            this.f24465a.rightBtn.btnModel.bind(this.f24480p);
            this.f24480p.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    LEGODrawer lEGODrawer = LEGODrawer.this;
                    lEGODrawer.m19635a(lEGODrawer.f24465a.rightBtn, view);
                }
            });
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f24467c.getLayoutParams();
            layoutParams.topMargin = UiUtils.dip2px(this.mContext, 30.0f);
            this.f24467c.setLayoutParams(layoutParams);
            return;
        }
        this.f24467c.setVisibility(0);
        this.f24465a.mRichLeft.bindTextView(this.f24481q);
        this.f24465a.mRightBtn.btnModel.bind(this.f24480p);
        this.f24480p.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                LEGODrawer lEGODrawer = LEGODrawer.this;
                lEGODrawer.m19635a(lEGODrawer.f24465a.mRightBtn, view);
            }
        });
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f24467c.getLayoutParams();
        layoutParams2.topMargin = UiUtils.dip2px(this.mContext, 30.0f);
        this.f24467c.setLayoutParams(layoutParams2);
    }

    /* renamed from: f */
    private void m19644f() {
        Drawable drawable;
        this.f24466b.setVisibility(0);
        this.f24475k.setVisibility(0);
        if (this.f24465a.mRichTitle != null) {
            this.f24465a.mRichTitle.bindTextView(this.f24475k);
        } else if (this.f24465a.title != null) {
            this.f24465a.title.bind(this.f24475k);
        } else {
            this.f24475k.setVisibility(8);
        }
        if (this.f24465a.mRichSubTitle != null) {
            this.f24476l.setVisibility(0);
            this.f24465a.mRichSubTitle.bindTextView(this.f24476l);
        } else if (this.f24465a.subTitle != null) {
            this.f24476l.setVisibility(0);
            this.f24465a.subTitle.bind(this.f24476l);
        } else {
            this.f24476l.setVisibility(8);
        }
        if (this.f24465a.imgPlaceHolder != 0) {
            drawable = this.mContext.getResources().getDrawable(this.f24465a.imgPlaceHolder);
        } else {
            drawable = DidiThemeManager.getIns().getResPicker(this.mContext).getDrawable(R.attr.ggk_default_big_bg);
        }
        if (!TextUtils.isEmpty(this.f24465a.imgUrl) || this.f24465a.imgResId != 0) {
            this.f24474j.setVisibility(0);
            if (this.mContext instanceof FragmentActivity) {
                if (((FragmentActivity) this.mContext).isDestroyed()) {
                    return;
                }
            } else if ((this.mContext instanceof Activity) && ((Activity) this.mContext).isDestroyed()) {
                return;
            }
            if (!TextUtils.isEmpty(this.f24465a.imgUrl)) {
                String str = this.f24465a.imgUrl;
                if (str.endsWith("webp")) {
                    ((RequestBuilder) ((RequestBuilder) Glide.with(this.mContext).load(str).placeholder(drawable)).optionalTransform(WebpDrawable.class, new WebpDrawableTransformation(new FitCenter()))).into(this.f24474j);
                    return;
                }
                ((RequestBuilder) Glide.with(this.mContext).load(str).placeholder(drawable)).into(this.f24474j);
                return;
            }
            int i = this.f24465a.imgResId;
            if (i != 0) {
                ((RequestBuilder) Glide.with(this.mContext).load(Integer.valueOf(i)).placeholder(drawable)).into(this.f24474j);
            } else {
                ((RequestBuilder) Glide.with(this.mContext).load(DidiThemeManager.getIns().getResPicker(this.mContext).getDrawable(R.attr.ggk_default_big_bg)).placeholder(drawable)).into(this.f24474j);
            }
        }
    }

    /* renamed from: g */
    private void m19645g() {
        this.f24466b = findViewById(R.id.lego_drawer_title_include);
        this.f24467c = findViewById(R.id.lego_drawer_selected_include);
        this.f24468d = findViewById(R.id.lego_drawer_link_include);
        this.f24469e = findViewById(R.id.lego_drawer_checkbox_include);
        this.f24470f = findViewById(R.id.lego_drawer_btn_horizontal_include);
        this.f24471g = findViewById(R.id.lego_drawer_btn_vertical_include);
        this.f24472h = (ImageView) findViewById(R.id.lego_drawer_close_img);
        this.f24463B = findViewById(R.id.g_bottom_pop_interval_view);
        this.f24474j = (ImageView) findViewById(R.id.lego_drawer_up_img);
        this.f24475k = (TextView) findViewById(R.id.lego_drawer_title);
        this.f24476l = (TextView) findViewById(R.id.lego_drawer_sub_title);
        this.f24477m = (FrameLayout) findViewById(R.id.lego_drawer_extended_up_view);
        this.f24478n = (FrameLayout) findViewById(R.id.lego_drawer_extended_bottom_view);
        this.f24479o = (FrameLayout) findViewById(R.id.lego_drawer_extended_view);
        this.f24473i = (RoundCornerRelativeLayout) findViewById(R.id.border_layout);
        this.f24480p = (TextView) findViewById(R.id.lego_drawer_right_btn);
        this.f24481q = (TextView) findViewById(R.id.ggk_drawer_left_tv);
        this.f24482r = (TextView) findViewById(R.id.lego_drawer_link_tv);
        this.f24483s = (CheckBox) findViewById(R.id.lego_drawer_cb);
        this.f24484t = (TextView) findViewById(R.id.lego_drawer_cb_desc);
        this.f24485u = (TextView) findViewById(R.id.ggk_drawer_btn_cancel);
        this.f24486v = (TextView) findViewById(R.id.ggk_drawer_btn_ok);
        this.f24487w = (LottieAnimationView) findViewById(R.id.ggk_drawer_btn_ok_lottie);
        this.f24488x = (TextView) findViewById(R.id.ggk_drawer_btn_v1);
        this.f24489y = (LottieAnimationView) findViewById(R.id.ggk_drawer_btn_v1_lottie);
        this.f24490z = (TextView) findViewById(R.id.ggk_drawer_btn_v2);
        this.f24462A = (TextView) findViewById(R.id.ggk_drawer_btn_v3);
        m19646h();
        LEGODrawerModel lEGODrawerModel = this.f24465a;
        if (lEGODrawerModel != null && lEGODrawerModel.drawerStyle > 0 && this.f24465a.drawerStyle == 5) {
            this.f24490z.setBackground(DidiThemeManager.getIns().getResPicker(this.mContext).getDrawable(R.attr.global_overall_main_button_selector));
            this.f24490z.setTextColor(DidiThemeManager.getIns().getResPicker(this.mContext).getColorStateList(R.attr.global_main_button_text_color_selector));
        }
    }

    /* renamed from: h */
    private void m19646h() {
        LEGOUIConfig lEGOUIConfig = LEGOUIKit.mConfig;
        if (lEGOUIConfig != null) {
            if (lEGOUIConfig.getDrawerTitleTextSize() > 0) {
                this.f24475k.setTextSize((float) lEGOUIConfig.getDrawerTitleTextSize());
            }
            if (lEGOUIConfig.getDrawerContentTextSize() > 0) {
                this.f24476l.setTextSize((float) lEGOUIConfig.getDrawerContentTextSize());
            }
            Rect drawerOutMargin = lEGOUIConfig.getDrawerOutMargin();
            if (drawerOutMargin != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f24473i.getLayoutParams();
                if (drawerOutMargin.top > 0) {
                    marginLayoutParams.topMargin = UiUtils.dip2px(this.mContext, (float) drawerOutMargin.top);
                }
                if (drawerOutMargin.left > 0) {
                    marginLayoutParams.leftMargin = UiUtils.dip2px(this.mContext, (float) drawerOutMargin.left);
                }
                if (drawerOutMargin.right > 0) {
                    marginLayoutParams.rightMargin = UiUtils.dip2px(this.mContext, (float) drawerOutMargin.right);
                }
                if (drawerOutMargin.bottom > 0) {
                    marginLayoutParams.bottomMargin = UiUtils.dip2px(this.mContext, (float) drawerOutMargin.bottom);
                }
                this.f24473i.setLayoutParams(marginLayoutParams);
            }
            if (lEGOUIConfig.getDrawerCornerRadius() > 0) {
                this.f24473i.setRadius(UiUtils.dip2px(this.mContext, (float) lEGOUIConfig.getDrawerCornerRadius()));
            }
            if (lEGOUIConfig.getDrawerHoriBtnInterval() > 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f24463B.getLayoutParams();
                layoutParams.width = UiUtils.dip2px(this.mContext, (float) lEGOUIConfig.getDrawerHoriBtnInterval());
                this.f24463B.setLayoutParams(layoutParams);
            }
            if (lEGOUIConfig.getDrawerVertiBtnInterval() > 0) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f24490z.getLayoutParams();
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f24462A.getLayoutParams();
                layoutParams2.topMargin = UiUtils.dip2px(this.mContext, (float) lEGOUIConfig.getDrawerVertiBtnInterval());
                layoutParams3.topMargin = UiUtils.dip2px(this.mContext, (float) lEGOUIConfig.getDrawerVertiBtnInterval());
                this.f24490z.setLayoutParams(layoutParams2);
                this.f24462A.setLayoutParams(layoutParams3);
            }
            Rect horiBtnLayoutOutMargin = lEGOUIConfig.getHoriBtnLayoutOutMargin();
            if (horiBtnLayoutOutMargin != null) {
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.f24470f.getLayoutParams();
                if (horiBtnLayoutOutMargin.top > 0) {
                    layoutParams4.topMargin = UiUtils.dip2px(this.mContext, (float) horiBtnLayoutOutMargin.top);
                }
                if (horiBtnLayoutOutMargin.left > 0) {
                    layoutParams4.leftMargin = UiUtils.dip2px(this.mContext, (float) horiBtnLayoutOutMargin.left);
                }
                if (horiBtnLayoutOutMargin.right > 0) {
                    layoutParams4.rightMargin = UiUtils.dip2px(this.mContext, (float) horiBtnLayoutOutMargin.right);
                }
                if (horiBtnLayoutOutMargin.bottom > 0) {
                    layoutParams4.bottomMargin = UiUtils.dip2px(this.mContext, (float) horiBtnLayoutOutMargin.bottom);
                }
                this.f24470f.setLayoutParams(layoutParams4);
            }
            Rect vertiBtnLayoutOutMargin = lEGOUIConfig.getVertiBtnLayoutOutMargin();
            if (vertiBtnLayoutOutMargin != null) {
                LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.f24471g.getLayoutParams();
                if (vertiBtnLayoutOutMargin.top > 0) {
                    layoutParams5.topMargin = UiUtils.dip2px(this.mContext, (float) vertiBtnLayoutOutMargin.top);
                }
                if (vertiBtnLayoutOutMargin.left > 0) {
                    layoutParams5.leftMargin = UiUtils.dip2px(this.mContext, (float) vertiBtnLayoutOutMargin.left);
                }
                if (vertiBtnLayoutOutMargin.right > 0) {
                    layoutParams5.rightMargin = UiUtils.dip2px(this.mContext, (float) vertiBtnLayoutOutMargin.right);
                }
                if (vertiBtnLayoutOutMargin.bottom > 0) {
                    layoutParams5.bottomMargin = UiUtils.dip2px(this.mContext, (float) vertiBtnLayoutOutMargin.bottom);
                }
                this.f24471g.setLayoutParams(layoutParams5);
            }
        }
    }

    public void showLoading() {
        if (this.f24470f.getVisibility() == 0) {
            m19637a(true);
        } else if (this.f24471g.getVisibility() == 0) {
            m19637a(false);
        }
    }

    /* renamed from: a */
    private void m19637a(boolean z) {
        if (z) {
            this.f24487w.setVisibility(0);
            this.f24487w.setRepeatCount(-1);
            this.f24487w.playAnimation();
            this.f24486v.setVisibility(8);
        } else {
            this.f24489y.setVisibility(0);
            this.f24489y.setRepeatCount(-1);
            this.f24489y.playAnimation();
            this.f24488x.setVisibility(8);
        }
        m19638a(z, false);
    }

    /* renamed from: b */
    private void m19640b(boolean z) {
        if (z) {
            this.f24486v.setVisibility(0);
            this.f24487w.setVisibility(8);
            this.f24487w.cancelAnimation();
        } else {
            this.f24488x.setVisibility(0);
            this.f24489y.setVisibility(4);
            this.f24489y.cancelAnimation();
        }
        m19638a(z, true);
    }

    public void hideLoading() {
        if (this.f24489y.getVisibility() == 0) {
            m19640b(false);
        } else if (this.f24487w.getVisibility() == 0) {
            m19640b(true);
        }
    }

    /* renamed from: a */
    private void m19638a(boolean z, boolean z2) {
        if (z) {
            this.f24485u.setEnabled(z2);
            return;
        }
        this.f24490z.setEnabled(z2);
        this.f24462A.setEnabled(z2);
    }
}
