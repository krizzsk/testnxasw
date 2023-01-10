package com.didi.rfusion.widget.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.passenger.C11267R;
import com.didi.rfusion.utils.RFResUtils;
import com.didi.rfusion.widget.RFIconView;
import com.didi.rfusion.widget.RFTextView;
import com.didi.rfusion.widget.loading.RFLottieLoadingView;
import com.taxis99.R;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class RFStyleButton extends RFButton {

    /* renamed from: a */
    private static final String f36140a = "RFStyleButton";

    /* renamed from: b */
    private static final int f36141b = 0;

    /* renamed from: c */
    private static final int f36142c = 1;

    /* renamed from: d */
    private static final int f36143d = 2;

    /* renamed from: e */
    private RFShadowLayout f36144e;

    /* renamed from: f */
    private FrameLayout f36145f;

    /* renamed from: g */
    private ConstraintLayout f36146g;

    /* renamed from: h */
    private RFIconView f36147h;

    /* renamed from: i */
    private ImageView f36148i;

    /* renamed from: j */
    private RFIconView f36149j;

    /* renamed from: k */
    private ImageView f36150k;

    /* renamed from: l */
    private RFTextView f36151l;

    /* renamed from: m */
    private RFLottieLoadingView f36152m;

    /* renamed from: n */
    private View.OnClickListener f36153n;

    /* renamed from: o */
    private View.OnClickListener f36154o;

    /* renamed from: p */
    private final View.OnClickListener f36155p = new View.OnClickListener() {
        public final void onClick(View view) {
            RFStyleButton.this.m27197a(view);
        }
    };

    /* renamed from: q */
    private boolean f36156q = false;

    /* renamed from: r */
    private int f36157r = -1;

    /* access modifiers changed from: protected */
    public int getLayoutRes() {
        return R.layout.rf_btn_style;
    }

    /* access modifiers changed from: protected */
    public abstract int getLoadingRes();

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m27197a(View view) {
        if (!isEnabled()) {
            View.OnClickListener onClickListener = this.f36153n;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        } else if (this.f36154o != null && !isLoading()) {
            this.f36154o.onClick(view);
        }
    }

    public RFStyleButton(Context context) {
        super(context);
    }

    public RFStyleButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RFStyleButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void initView() {
        this.f36144e = (RFShadowLayout) findViewById(R.id.rf_sl_shadow);
        this.f36145f = (FrameLayout) findViewById(R.id.rf_fl_frame);
        this.f36146g = (ConstraintLayout) findViewById(R.id.rf_cl_content);
        this.f36147h = (RFIconView) findViewById(R.id.rf_iv_left_icon);
        this.f36149j = (RFIconView) findViewById(R.id.rf_iv_right_icon);
        this.f36148i = (ImageView) findViewById(R.id.rf_iv_left_drawable);
        this.f36150k = (ImageView) findViewById(R.id.rf_iv_right_drawable);
        this.f36151l = (RFTextView) findViewById(R.id.rf_tv_text);
        this.f36152m = (RFLottieLoadingView) findViewById(R.id.rf_llv_loading);
        setLoadingRes(getLoadingRes());
    }

    /* access modifiers changed from: protected */
    public void setLoadingRes(int i) {
        if (this.f36152m.isRunning()) {
            this.f36152m.stop();
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getResources().openRawResource(i)));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                } else {
                    this.f36152m.setAnimationFromJson(sb.toString(), (String) null);
                    return;
                }
            }
        } catch (Resources.NotFoundException | IOException unused) {
        }
    }

    /* access modifiers changed from: protected */
    public void initLogic(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C11267R.styleable.RFStyleButton);
        boolean z = obtainStyledAttributes.getBoolean(2, false);
        String string = obtainStyledAttributes.getString(1);
        String string2 = obtainStyledAttributes.getString(3);
        int i = obtainStyledAttributes.getInt(0, 0);
        obtainStyledAttributes.recycle();
        setSpec(i);
        setIcon(1, string2);
        setIcon(0, string);
        setLoading(z);
    }

    /* renamed from: a */
    private int m27195a(int i) {
        float f;
        if (i == 0) {
            f = RFResUtils.getDimens(getContext(), R.dimen.rf_btn_style_height_large);
        } else if (i == 1) {
            f = RFResUtils.getDimens(getContext(), R.dimen.rf_btn_style_height_small);
        } else if (i != 2) {
            return 0;
        } else {
            f = RFResUtils.getDimens(getContext(), R.dimen.rf_btn_style_height_max);
        }
        return (int) f;
    }

    /* access modifiers changed from: protected */
    public void updateText(CharSequence charSequence) {
        this.f36151l.setText(charSequence);
        m27196a();
    }

    /* access modifiers changed from: protected */
    public void updateSpec(int i) {
        int i2;
        int i3;
        int i4;
        if (i == 0) {
            i2 = (int) RFResUtils.getDimens(getContext(), R.dimen.f_07_app_36_pad_24);
            i3 = (int) RFResUtils.getDimens(getContext(), R.dimen.rf_btn_loading_size_large);
            i4 = (int) RFResUtils.getDimens(getContext(), R.dimen.rf_btn_style_icon_size_large);
            this.f36151l.setTypeface(1);
        } else if (i == 1) {
            i2 = (int) RFResUtils.getDimens(getContext(), R.dimen.f_10_app_28_pad_16);
            i3 = (int) RFResUtils.getDimens(getContext(), R.dimen.rf_btn_loading_size_small);
            i4 = (int) RFResUtils.getDimens(getContext(), R.dimen.rf_btn_style_icon_size_small);
        } else if (i != 2) {
            i4 = 0;
            i3 = 0;
            i2 = 0;
        } else {
            i2 = (int) RFResUtils.getDimens(getContext(), R.dimen.f_07_app_36_pad_24);
            i3 = (int) RFResUtils.getDimens(getContext(), R.dimen.rf_btn_loading_size_large);
            i4 = (int) RFResUtils.getDimens(getContext(), R.dimen.rf_btn_style_icon_size_large);
            this.f36151l.setTypeface(2);
        }
        this.f36145f.getLayoutParams().height = m27195a(i);
        this.f36151l.setTextSize(0, (float) i2);
        ViewGroup.LayoutParams layoutParams = this.f36152m.getLayoutParams();
        layoutParams.width = i3;
        layoutParams.height = i3;
        this.f36152m.setLayoutParams(layoutParams);
        float f = (float) i4;
        this.f36147h.setTextSize(0, f);
        this.f36149j.setTextSize(0, f);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f36147h.getLayoutParams();
        marginLayoutParams.width = i4;
        marginLayoutParams.height = i4;
        this.f36148i.setLayoutParams(marginLayoutParams);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f36149j.getLayoutParams();
        marginLayoutParams2.width = i4;
        marginLayoutParams2.height = i4;
        this.f36150k.setLayoutParams(marginLayoutParams2);
        m27196a();
    }

    /* renamed from: a */
    private void m27196a() {
        int i;
        boolean isEmpty = TextUtils.isEmpty(this.f36151l.getText());
        int i2 = 0;
        if (isEmpty) {
            i = 0;
        } else {
            i = (int) RFResUtils.getDimens(getContext(), R.dimen.rf_btn_style_icon_margin_size);
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f36147h.getLayoutParams();
        if (!isEmpty) {
            i2 = i;
        }
        marginLayoutParams.rightMargin = i2;
        ((ViewGroup.MarginLayoutParams) this.f36149j.getLayoutParams()).leftMargin = i;
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f36147h.getLayoutParams();
        marginLayoutParams2.rightMargin = i;
        this.f36148i.setLayoutParams(marginLayoutParams2);
        ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) this.f36149j.getLayoutParams();
        marginLayoutParams3.leftMargin = i;
        this.f36150k.setLayoutParams(marginLayoutParams3);
    }

    /* access modifiers changed from: protected */
    public void setTextColor(int i) {
        this.f36151l.setTextColor(i);
    }

    /* access modifiers changed from: protected */
    public void setTextColor(ColorStateList colorStateList) {
        this.f36151l.setTextColor(colorStateList);
    }

    public void setContentBackground(Drawable drawable) {
        this.f36145f.setBackground(drawable);
    }

    public Drawable getContentBackground() {
        return this.f36145f.getBackground();
    }

    /* access modifiers changed from: protected */
    public void setShadow(int i, int i2, int i3, int i4, int i5) {
        this.f36144e.setShadow(i, i2, i3, i4, i5);
    }

    public void setEnabled(boolean z) {
        this.f36145f.setEnabled(z);
        this.f36151l.setEnabled(z);
    }

    public boolean isEnabled() {
        return this.f36145f.isEnabled();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f36154o = onClickListener;
        m27198b();
    }

    public void setOnDisableClickListener(View.OnClickListener onClickListener) {
        this.f36153n = onClickListener;
        m27198b();
    }

    /* renamed from: b */
    private void m27198b() {
        if (this.f36154o == null && this.f36153n == null) {
            super.setOnClickListener((View.OnClickListener) null);
        } else {
            super.setOnClickListener(this.f36155p);
        }
    }

    public void setSpec(int i) {
        if (this.f36157r != i) {
            this.f36157r = i;
            updateSpec(i);
        }
    }

    public void setLoading(boolean z) {
        if (this.f36156q != z) {
            this.f36156q = z;
            if (z) {
                this.f36152m.show();
                this.f36146g.setVisibility(4);
                return;
            }
            this.f36152m.hide();
            this.f36146g.setVisibility(0);
        }
    }

    public void setLeftIcon(String str) {
        setIcon(0, str);
    }

    public void setLeftIcon(Drawable drawable) {
        setIcon(0, drawable);
    }

    public void setRightIcon(String str) {
        setIcon(1, str);
    }

    public void setRightIcon(Drawable drawable) {
        setIcon(1, drawable);
    }

    public void setIcon(int i, String str) {
        this.f36148i.setVisibility(8);
        this.f36150k.setVisibility(8);
        if (i == 0) {
            if (TextUtils.isEmpty(str)) {
                this.f36147h.setVisibility(8);
                return;
            }
            this.f36149j.setVisibility(8);
            this.f36147h.setVisibility(0);
            this.f36147h.setText(str);
        } else if (TextUtils.isEmpty(str)) {
            this.f36149j.setVisibility(8);
        } else {
            this.f36147h.setVisibility(8);
            this.f36149j.setVisibility(0);
            this.f36149j.setText(str);
        }
    }

    public void setIcon(int i, Drawable drawable) {
        this.f36147h.setVisibility(8);
        this.f36149j.setVisibility(8);
        if (i == 0) {
            if (drawable == null) {
                this.f36148i.setVisibility(8);
                return;
            }
            this.f36150k.setVisibility(8);
            this.f36148i.setVisibility(0);
            this.f36148i.setImageDrawable(drawable);
        } else if (drawable == null) {
            this.f36150k.setVisibility(8);
        } else {
            this.f36148i.setVisibility(8);
            this.f36150k.setVisibility(0);
            this.f36150k.setImageDrawable(drawable);
        }
    }

    public int getSpec() {
        return this.f36157r;
    }

    public boolean isLoading() {
        return this.f36156q;
    }
}
