package com.didi.global.globalgenerickit.drawer;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.didi.theme.DidiThemeManager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.global.globalgenerickit.utils.GGKOnAntiShakeClickListener;
import com.didi.global.globalgenerickit.utils.UiUtils;
import com.taxis99.R;

public final class GGKDrawer extends GGKAbsDrawer {

    /* renamed from: A */
    private TextView f24059A;

    /* renamed from: B */
    private TextView f24060B;

    /* renamed from: C */
    private TextView f24061C;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public GGKDrawerModel f24062a;

    /* renamed from: b */
    private View f24063b;

    /* renamed from: c */
    private View f24064c;

    /* renamed from: d */
    private View f24065d;

    /* renamed from: e */
    private View f24066e;

    /* renamed from: f */
    private View f24067f;

    /* renamed from: g */
    private View f24068g;

    /* renamed from: h */
    private View f24069h;

    /* renamed from: i */
    private View f24070i;

    /* renamed from: j */
    private LinearLayout f24071j;

    /* renamed from: k */
    private ImageView f24072k;

    /* renamed from: l */
    private TextView f24073l;

    /* renamed from: m */
    private TextView f24074m;

    /* renamed from: n */
    private FrameLayout f24075n;

    /* renamed from: o */
    private FrameLayout f24076o;

    /* renamed from: p */
    private ImageView f24077p;

    /* renamed from: q */
    private TextView f24078q;

    /* renamed from: r */
    private TextView f24079r;

    /* renamed from: s */
    private TextView f24080s;

    /* renamed from: t */
    private TextView f24081t;

    /* renamed from: u */
    private TextView f24082u;

    /* renamed from: v */
    private CheckBox f24083v;

    /* renamed from: w */
    private TextView f24084w;

    /* renamed from: x */
    private EditText f24085x;

    /* renamed from: y */
    private TextView f24086y;

    /* renamed from: z */
    private TextView f24087z;

    /* access modifiers changed from: protected */
    public int getCustomView() {
        return R.layout.ggk_drawer_common_layout;
    }

    public GGKDrawer(Context context, GGKDrawerModel gGKDrawerModel) {
        super(context);
        this.f24062a = gGKDrawerModel;
        setLoadingEnable(gGKDrawerModel.isLoadingEnable);
    }

    /* access modifiers changed from: protected */
    public boolean onShowPrepare() {
        m19457h();
        m19456g();
        m19447a();
        m19455f();
        m19454e();
        m19453d();
        m19452c();
        m19451b();
        if (this.f24062a.clickOutsideCanCancel) {
            setCanceledOnTouchOutside(true);
        }
        if (this.f24062a.backPressedEnabled) {
            setBackPressedEnabled(true);
        }
        return true;
    }

    /* renamed from: a */
    private void m19447a() {
        if (this.f24062a.extendedUpView != null) {
            this.f24075n.setVisibility(0);
            this.f24075n.addView(this.f24062a.extendedUpView);
        } else {
            this.f24075n.setVisibility(8);
        }
        if (this.f24062a.extendedBottomView != null) {
            this.f24076o.setVisibility(0);
            this.f24076o.addView(this.f24062a.extendedBottomView);
        } else {
            this.f24076o.setVisibility(8);
        }
        if (this.f24062a.extendedView != null) {
            this.f24075n.setVisibility(8);
            this.f24076o.setVisibility(8);
            this.f24063b.setVisibility(8);
            this.f24071j.addView(this.f24062a.extendedView);
        }
    }

    /* renamed from: b */
    private void m19451b() {
        if (this.f24062a.majorBtn != null && (this.f24062a.minorBtns == null || this.f24062a.minorBtns.size() == 0)) {
            m19449a(0, 8);
            m19450a(this.f24059A, this.f24062a.majorBtn.getText(), this.f24062a.majorBtn.getListener());
        } else if (this.f24062a.majorBtn != null && this.f24062a.minorBtns.size() == 1 && this.f24062a.isTwoBtnHorizontal) {
            m19449a(8, 0);
            m19450a(this.f24087z, this.f24062a.majorBtn.getText(), this.f24062a.majorBtn.getListener());
            m19450a(this.f24086y, this.f24062a.minorBtns.get(0).getText(), this.f24062a.minorBtns.get(0).getListener());
        } else if (this.f24062a.majorBtn != null && this.f24062a.minorBtns.size() == 1) {
            m19449a(0, 8);
            m19450a(this.f24059A, this.f24062a.majorBtn.getText(), this.f24062a.majorBtn.getListener());
            m19450a(this.f24060B, this.f24062a.minorBtns.get(0).getText(), this.f24062a.minorBtns.get(0).getListener());
        } else if (this.f24062a.majorBtn == null || this.f24062a.minorBtns.size() != 2) {
            m19449a(8, 8);
        } else {
            m19449a(0, 8);
            m19450a(this.f24059A, this.f24062a.majorBtn.getText(), this.f24062a.majorBtn.getListener());
            m19450a(this.f24060B, this.f24062a.minorBtns.get(0).getText(), this.f24062a.minorBtns.get(0).getListener());
            m19450a(this.f24061C, this.f24062a.minorBtns.get(1).getText(), this.f24062a.minorBtns.get(1).getListener());
        }
        if ((!TextUtils.isEmpty(this.f24062a.imgUrl) || this.f24062a.imgResId != 0) && !this.f24062a.isImgUp) {
            m19448a(15);
        } else if (this.f24062a.link != null && this.f24062a.link.linkModel != null && this.f24062a.link.listener != null) {
            m19448a(20);
        } else if (this.f24062a.checkbox != null && this.f24062a.checkbox.cbModel != null && this.f24062a.checkbox.listener != null) {
            m19448a(0);
        } else if (this.f24062a.edit != null && this.f24062a.edit.model != null && this.f24062a.edit.listener != null) {
            m19448a(20);
        } else if (this.f24062a.extendedUpView == null && this.f24062a.extendedBottomView == null) {
            m19448a(30);
        } else {
            m19448a(0);
        }
        if (this.f24062a.extendedView != null) {
            m19449a(8, 8);
        }
    }

    /* renamed from: a */
    private void m19448a(int i) {
        if (this.f24069h.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f24069h.getLayoutParams();
            layoutParams.topMargin = UiUtils.dip2px(this.mContext, (float) i);
            this.f24069h.setLayoutParams(layoutParams);
        } else if (this.f24070i.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f24070i.getLayoutParams();
            layoutParams2.topMargin = UiUtils.dip2px(this.mContext, (float) i);
            this.f24070i.setLayoutParams(layoutParams2);
        }
    }

    /* renamed from: a */
    private void m19450a(TextView textView, String str, GGKOnAntiShakeClickListener gGKOnAntiShakeClickListener) {
        textView.setVisibility(0);
        textView.setText(str);
        textView.setOnClickListener(gGKOnAntiShakeClickListener);
    }

    /* renamed from: a */
    private void m19449a(int i, int i2) {
        this.f24070i.setVisibility(i);
        this.f24069h.setVisibility(i2);
    }

    /* renamed from: c */
    private void m19452c() {
        if (this.f24062a.edit == null || this.f24062a.edit.model == null || this.f24062a.edit.listener == null) {
            this.f24068g.setVisibility(8);
            return;
        }
        this.f24068g.setVisibility(0);
        this.f24062a.edit.model.bind(this.f24085x);
        this.f24085x.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                if (editable == null) {
                    GGKDrawer.this.f24062a.edit.listener.onInput((String) null);
                } else {
                    GGKDrawer.this.f24062a.edit.listener.onInput(editable.toString());
                }
            }
        });
    }

    /* renamed from: d */
    private void m19453d() {
        if (this.f24062a.checkbox == null || this.f24062a.checkbox.cbModel == null || this.f24062a.checkbox.listener == null) {
            this.f24067f.setVisibility(8);
            return;
        }
        this.f24067f.setVisibility(0);
        this.f24062a.checkbox.cbModel.bind(this.f24084w);
        this.f24083v.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AutoTrackHelper.trackViewOnClick(compoundButton, z);
                GGKDrawer.this.f24062a.checkbox.listener.onCheckedChanged(z);
            }
        });
    }

    /* renamed from: e */
    private void m19454e() {
        if (this.f24062a.link == null || this.f24062a.link.linkModel == null || this.f24062a.link.listener == null) {
            this.f24066e.setVisibility(8);
            return;
        }
        this.f24066e.setVisibility(0);
        this.f24062a.link.linkModel.bind(this.f24082u);
        this.f24082u.setOnClickListener(this.f24062a.link.listener);
    }

    /* renamed from: f */
    private void m19455f() {
        if (this.f24062a.selectedText == null || this.f24062a.changeBtn == null) {
            this.f24065d.setVisibility(8);
            return;
        }
        this.f24065d.setVisibility(0);
        this.f24062a.selectedText.bind(this.f24081t);
        this.f24080s.setText(this.f24062a.changeBtn.getText());
        this.f24080s.setOnClickListener(this.f24062a.changeBtn.getListener());
    }

    /* renamed from: g */
    private void m19456g() {
        Drawable drawable;
        Drawable drawable2;
        if (this.f24062a.isImgUp) {
            this.f24064c.setVisibility(8);
            this.f24063b.setVisibility(0);
            if (this.f24062a.imgPlaceHolder != 0) {
                drawable2 = this.mContext.getResources().getDrawable(this.f24062a.imgPlaceHolder);
            } else {
                drawable2 = DidiThemeManager.getIns().getResPicker(this.mContext).getDrawable(R.attr.ggk_default_big_bg);
            }
            if (!TextUtils.isEmpty(this.f24062a.imgUrl) || this.f24062a.imgResId != 0) {
                this.f24072k.setVisibility(0);
                ((RequestBuilder) Glide.with(this.mContext).load(!TextUtils.isEmpty(this.f24062a.imgUrl) ? this.f24062a.imgUrl : this.f24062a.imgResId != 0 ? Integer.valueOf(this.f24062a.imgResId) : DidiThemeManager.getIns().getResPicker(this.mContext).getDrawable(R.attr.ggk_default_big_bg)).placeholder(drawable2)).into(this.f24072k);
            }
            this.f24062a.title.bind(this.f24073l);
            if (this.f24062a.subTitle != null) {
                this.f24074m.setVisibility(0);
                this.f24062a.subTitle.bind(this.f24074m);
                return;
            }
            this.f24074m.setVisibility(8);
            return;
        }
        this.f24063b.setVisibility(8);
        this.f24064c.setVisibility(0);
        if (this.f24062a.imgPlaceHolder != 0) {
            drawable = this.mContext.getResources().getDrawable(this.f24062a.imgPlaceHolder);
        } else {
            drawable = DidiThemeManager.getIns().getResPicker(this.mContext).getDrawable(R.attr.ggk_default_small_bg);
        }
        if (!TextUtils.isEmpty(this.f24062a.imgUrl) || this.f24062a.imgResId != 0) {
            this.f24077p.setVisibility(0);
            ((RequestBuilder) Glide.with(this.mContext).load(!TextUtils.isEmpty(this.f24062a.imgUrl) ? this.f24062a.imgUrl : this.f24062a.imgResId != 0 ? Integer.valueOf(this.f24062a.imgResId) : DidiThemeManager.getIns().getResPicker(this.mContext).getDrawable(R.attr.ggk_default_small_bg)).placeholder(drawable)).into(this.f24077p);
        }
        this.f24062a.title.bind(this.f24078q);
        if (this.f24062a.subTitle != null) {
            this.f24079r.setVisibility(0);
            this.f24062a.subTitle.bind(this.f24079r);
            return;
        }
        this.f24079r.setVisibility(8);
    }

    /* renamed from: h */
    private void m19457h() {
        this.f24071j = (LinearLayout) findViewById(R.id.ll_drawer_common_container);
        this.f24063b = findViewById(R.id.ggk_drawer_title_include);
        this.f24064c = findViewById(R.id.ggk_drawer_img_right_include);
        this.f24065d = findViewById(R.id.ggk_drawer_selected_include);
        this.f24066e = findViewById(R.id.ggk_drawer_link_include);
        this.f24067f = findViewById(R.id.ggk_drawer_checkbox_include);
        this.f24068g = findViewById(R.id.ggk_drawer_edit_include);
        this.f24069h = findViewById(R.id.ggk_drawer_btn_horizontal_include);
        this.f24070i = findViewById(R.id.ggk_drawer_btn_vertical_include);
        this.f24072k = (ImageView) findViewById(R.id.ggk_drawer_up_img);
        this.f24073l = (TextView) findViewById(R.id.ggk_drawer_title);
        this.f24074m = (TextView) findViewById(R.id.ggk_drawer_sub_title);
        this.f24075n = (FrameLayout) findViewById(R.id.ggk_drawer_extended_up_view);
        this.f24076o = (FrameLayout) findViewById(R.id.ggk_drawer_extended_bottom_view);
        this.f24077p = (ImageView) findViewById(R.id.ggk_drawer_right_img);
        this.f24078q = (TextView) findViewById(R.id.ggk_drawer_left_title);
        this.f24079r = (TextView) findViewById(R.id.ggk_drawer_left_sub_title);
        this.f24080s = (TextView) findViewById(R.id.ggk_drawer_selected_btn);
        this.f24081t = (TextView) findViewById(R.id.ggk_drawer_selected_tv);
        this.f24082u = (TextView) findViewById(R.id.ggk_drawer_link_tv);
        this.f24083v = (CheckBox) findViewById(R.id.ggk_drawer_cb);
        this.f24084w = (TextView) findViewById(R.id.ggk_drawer_cb_desc);
        this.f24085x = (EditText) findViewById(R.id.ggk_drawer_edit);
        this.f24086y = (TextView) findViewById(R.id.ggk_drawer_btn_cancel);
        this.f24087z = (TextView) findViewById(R.id.ggk_drawer_btn_ok);
        this.f24059A = (TextView) findViewById(R.id.ggk_drawer_btn_v1);
        this.f24060B = (TextView) findViewById(R.id.ggk_drawer_btn_v2);
        this.f24061C = (TextView) findViewById(R.id.ggk_drawer_btn_v3);
    }
}
