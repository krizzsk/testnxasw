package com.didi.soda.customer.widget.goods;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.passenger.C11267R;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;

public class CustomerPriceView extends LinearLayout {

    /* renamed from: a */
    private static final String f44434a = "CustomerPriceView";

    /* renamed from: b */
    private static final int f44435b = -16777216;

    /* renamed from: c */
    private static final float f44436c = 6.0f;

    /* renamed from: d */
    private int f44437d = -16777216;

    /* renamed from: e */
    private int f44438e = -16777216;

    /* renamed from: f */
    private int f44439f = -16777216;

    /* renamed from: g */
    private int f44440g = -16777216;

    /* renamed from: h */
    private float f44441h;

    /* renamed from: i */
    private float f44442i;

    /* renamed from: j */
    private CharSequence f44443j = "";

    /* renamed from: k */
    private CharSequence f44444k = "";

    /* renamed from: l */
    private TextView f44445l;

    /* renamed from: m */
    private TextView f44446m;

    /* renamed from: n */
    private float f44447n = 0.0f;

    /* renamed from: o */
    private boolean f44448o = true;

    /* renamed from: p */
    private boolean f44449p = false;

    /* renamed from: q */
    private boolean f44450q = true;

    /* renamed from: r */
    private boolean f44451r = false;

    /* renamed from: s */
    private IToolsService.FontType f44452s = IToolsService.FontType.MEDIUM;

    /* renamed from: t */
    private IToolsService.FontType f44453t = IToolsService.FontType.NORMAL;

    public CustomerPriceView(Context context) {
        super(context);
        m33002a(context, (AttributeSet) null);
    }

    public CustomerPriceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m33002a(context, attributeSet);
    }

    public CustomerPriceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m33002a(context, attributeSet);
    }

    public void setFontType(IToolsService.FontType fontType, IToolsService.FontType fontType2) {
        this.f44452s = fontType;
        this.f44453t = fontType2;
        m33000a();
    }

    public float getCurPriceSize() {
        return this.f44441h;
    }

    public float getOriPriceSize() {
        return this.f44442i;
    }

    public void setEnabled(boolean z) {
        this.f44448o = z;
        m33007d();
        super.setEnabled(z);
    }

    public void setMaxWidth(int i) {
        this.f44447n = (float) i;
        m33007d();
    }

    public void setCurPriceColor(int i) {
        this.f44437d = i;
    }

    public void setOriginPriceColor(int i) {
        this.f44438e = i;
    }

    public void setDisableCurPriceColor(int i) {
        this.f44439f = i;
    }

    public void setDisableOriginPriceColor(int i) {
        this.f44440g = i;
    }

    public void setPriceStr(CharSequence charSequence, CharSequence charSequence2) {
        if (TextUtils.isEmpty(charSequence2)) {
            charSequence2 = "";
        }
        this.f44443j = charSequence;
        this.f44444k = charSequence2;
        m33007d();
    }

    public void setPriceTextSize(float f, float f2) {
        this.f44441h = f;
        this.f44442i = f2;
        m33007d();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 0;
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            i3 += getChildAt(i4).getMeasuredWidth();
        }
        int paddingLeft = i3 + getPaddingLeft() + getPaddingRight();
        if (getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
            paddingLeft = paddingLeft + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
        }
        if (!this.f44450q) {
            paddingLeft += DisplayUtils.dip2px(getContext(), f44436c);
        }
        m33003a("rough total: " + paddingLeft + " max width: " + this.f44447n);
        if (this.f44451r) {
            return;
        }
        if (this.f44450q) {
            if (((float) paddingLeft) >= this.f44447n) {
                this.f44451r = true;
                m33001a(i, i2);
            }
        } else if (((float) paddingLeft) < this.f44447n) {
            this.f44451r = true;
            m33005b(i, i2);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f44451r = false;
    }

    /* renamed from: a */
    private void m33002a(Context context, AttributeSet attributeSet) {
        float screenWidth = (float) CustomerSystemUtil.getScreenWidth(context);
        this.f44447n = screenWidth;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.CustomerPriceView);
            this.f44437d = obtainStyledAttributes.getColor(0, -16777216);
            this.f44438e = obtainStyledAttributes.getColor(6, -16777216);
            this.f44439f = obtainStyledAttributes.getColor(2, -16777216);
            this.f44440g = obtainStyledAttributes.getColor(3, -16777216);
            this.f44441h = obtainStyledAttributes.getDimension(1, 0.0f);
            this.f44442i = obtainStyledAttributes.getDimension(7, 0.0f);
            this.f44447n = obtainStyledAttributes.getDimension(5, screenWidth);
            this.f44449p = obtainStyledAttributes.getBoolean(4, false);
            obtainStyledAttributes.recycle();
        }
        this.f44445l = new TextView(context);
        this.f44446m = new TextView(context);
        this.f44445l.setMaxLines(1);
        this.f44446m.setMaxLines(1);
        m33004b();
        m33000a();
    }

    /* renamed from: a */
    private void m33000a() {
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f44445l, this.f44452s);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f44446m, this.f44453t);
    }

    /* renamed from: a */
    private void m33001a(int i, int i2) {
        if (this.f44450q) {
            removeAllViews();
            m33006c();
            measure(i, i2);
        }
    }

    /* renamed from: b */
    private void m33005b(int i, int i2) {
        if (!this.f44450q) {
            removeAllViews();
            m33004b();
            measure(i, i2);
        }
    }

    /* renamed from: b */
    private void m33004b() {
        setOrientation(0);
        if (this.f44449p) {
            this.f44445l.setPadding(0, 0, 0, 0);
            this.f44446m.setPadding(0, 0, DisplayUtils.dip2px(getContext(), f44436c), 0);
            addView(this.f44446m, new LinearLayoutCompat.LayoutParams(-2, -2));
            addView(this.f44445l, new LinearLayoutCompat.LayoutParams(-2, -2));
        } else {
            this.f44445l.setPadding(0, 0, DisplayUtils.dip2px(getContext(), f44436c), 0);
            this.f44446m.setPadding(0, 0, 0, 0);
            addView(this.f44445l, new LinearLayoutCompat.LayoutParams(-2, -2));
            addView(this.f44446m, new LinearLayoutCompat.LayoutParams(-2, -2));
        }
        this.f44450q = true;
    }

    /* renamed from: c */
    private void m33006c() {
        setOrientation(1);
        this.f44445l.setPadding(0, 0, 0, 0);
        this.f44446m.setPadding(0, DisplayUtils.dip2px(getContext(), f44436c), 0, 0);
        addView(this.f44445l, new LinearLayoutCompat.LayoutParams(-2, -2));
        addView(this.f44446m, new LinearLayoutCompat.LayoutParams(-2, -2));
        this.f44450q = false;
    }

    /* renamed from: d */
    private void m33007d() {
        CharSequence charSequence = this.f44443j;
        CharSequence charSequence2 = this.f44444k;
        SpannableString spannableString = new SpannableString(charSequence);
        if (this.f44441h > 0.0f) {
            spannableString.setSpan(new AbsoluteSizeSpan((int) this.f44441h), 0, charSequence.length(), 33);
        }
        SpannableString spannableString2 = new SpannableString(charSequence2);
        if (this.f44442i > 0.0f) {
            spannableString2.setSpan(new AbsoluteSizeSpan((int) this.f44442i), 0, charSequence2.length(), 33);
        }
        spannableString2.setSpan(new StrikethroughSpan(), 0, charSequence2.length(), 33);
        if (this.f44448o) {
            spannableString.setSpan(new ForegroundColorSpan(this.f44437d), 0, charSequence.length(), 33);
            spannableString2.setSpan(new ForegroundColorSpan(this.f44438e), 0, charSequence2.length(), 33);
        } else {
            spannableString.setSpan(new ForegroundColorSpan(this.f44439f), 0, charSequence.length(), 33);
            spannableString2.setSpan(new ForegroundColorSpan(this.f44440g), 0, charSequence2.length(), 33);
        }
        this.f44445l.setText(spannableString);
        this.f44446m.setText(spannableString2);
        if (TextUtils.isEmpty(charSequence2)) {
            this.f44446m.setVisibility(this.f44450q ? 4 : 8);
        } else {
            this.f44446m.setVisibility(0);
        }
    }

    /* renamed from: a */
    private void m33003a(String str) {
        LogUtil.m32584d(f44434a, str);
    }
}
