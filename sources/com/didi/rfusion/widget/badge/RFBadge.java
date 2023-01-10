package com.didi.rfusion.widget.badge;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.didi.rfusion.utils.RFResUtils;
import com.didi.rfusion.widget.RFTextView;
import com.taxis99.R;

public class RFBadge extends RFTextView implements C12351a {

    /* renamed from: a */
    private static final int f36080a = 99;

    /* renamed from: b */
    private static final int f36081b = 8;

    /* renamed from: c */
    private static final String f36082c = "+";

    /* renamed from: d */
    private int f36083d;

    /* renamed from: e */
    private int f36084e;

    /* renamed from: f */
    private String f36085f;

    /* renamed from: g */
    private int f36086g;

    /* renamed from: h */
    private int f36087h;

    /* renamed from: i */
    private int f36088i;

    /* renamed from: j */
    private int f36089j;

    /* renamed from: k */
    private int f36090k;

    /* renamed from: l */
    private Drawable f36091l;

    /* renamed from: m */
    private boolean f36092m;

    /* renamed from: n */
    private int f36093n;

    public RFBadge(Context context) {
        this(context, (AttributeSet) null);
    }

    public RFBadge(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RFBadge(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f36083d = 99;
        this.f36085f = "";
        this.f36093n = 17170445;
        m27170a(context);
    }

    /* renamed from: a */
    private void m27170a(Context context) {
        this.f36087h = getResources().getDimensionPixelOffset(R.dimen.rf_dimen_12);
        this.f36088i = getResources().getDimensionPixelOffset(R.dimen.rf_dimen_3);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.f_11_app_24_pad_14);
        this.f36086g = dimensionPixelSize;
        this.f36089j = dimensionPixelSize;
        int color = getResources().getColor(R.color.rf_color_white_100_FFFFFF);
        this.f36090k = color;
        setTextColor(color);
        setGravity(17);
        m27169a();
    }

    /* renamed from: a */
    private void m27169a() {
        setText(this.f36085f);
        if (TextUtils.isEmpty(this.f36085f)) {
            this.f36089j = 0;
            setPadding(0, 0, 0, 0);
            this.f36091l = getResources().getDrawable(R.drawable.rf_shape_bg_badge_circle_default);
        } else if (this.f36085f.length() == 1) {
            this.f36089j = this.f36086g;
            setPadding(0, 0, 0, 0);
            this.f36091l = getResources().getDrawable(R.drawable.rf_shape_bg_badge_circle_with_text);
        } else {
            this.f36089j = this.f36086g;
            int i = this.f36087h;
            int i2 = this.f36088i;
            setPadding(i, i2, i, i2);
            this.f36091l = getResources().getDrawable(R.drawable.rf_shape_bg_badge_round_rect_with_text);
        }
        setTextSize((float) this.f36089j);
        m27171b();
    }

    /* renamed from: b */
    private void m27171b() {
        Drawable drawable = this.f36091l;
        if (drawable != null && (drawable instanceof GradientDrawable)) {
            ((GradientDrawable) drawable).setStroke(RFResUtils.getDimensionPixelSize(R.dimen.rf_dimen_3), RFResUtils.getColor(this.f36093n));
            setBackground(this.f36091l);
        }
    }

    public void setMaxBadgeNumber(int i) {
        this.f36083d = i;
    }

    public int getMaxBadgeNumber() {
        return this.f36083d;
    }

    public void setBadgeNumber(int i) {
        this.f36084e = i;
        if (i <= this.f36083d) {
            this.f36085f = String.valueOf(i);
        } else {
            this.f36085f = this.f36083d + "+";
        }
        m27169a();
    }

    public int getBadgeNumber() {
        return this.f36084e;
    }

    public void setBadgeText(String str) {
        if (str.length() > 8) {
            this.f36085f = str.substring(0, 8);
        } else {
            this.f36085f = str;
        }
        m27169a();
    }

    public String getBadgeText() {
        return this.f36085f;
    }

    public void clearContent() {
        this.f36085f = "";
        m27169a();
    }

    public void show() {
        setVisibility(0);
    }

    public void hide() {
        setVisibility(8);
    }

    public void showStock(int i) {
        if (!this.f36092m) {
            this.f36092m = true;
            this.f36093n = i;
            m27171b();
        }
    }

    public void showStock() {
        showStock(R.color.rf_color_white_100_FFFFFF);
    }

    public void hideStock() {
        if (this.f36092m) {
            this.f36092m = false;
            this.f36093n = 17170445;
            m27171b();
        }
    }

    public void setTextColor(int i) {
        super.setTextColor(this.f36090k);
    }

    public void setTextSize(float f) {
        super.setTextSize(0, (float) this.f36089j);
    }

    public void setTextSize(int i, float f) {
        super.setTextSize(0, (float) this.f36089j);
    }

    public void setBackground(Drawable drawable) {
        super.setBackground(this.f36091l);
    }
}
