package com.didi.soda.customer.widget.goodsV2;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.passenger.C11267R;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.taxis99.R;

public class CustomerPriceView extends LinearLayout {

    /* renamed from: a */
    private static final String f44470a = "CustomerPriceView";

    /* renamed from: b */
    private static final int f44471b = -16777216;

    /* renamed from: c */
    private static final float f44472c = 6.0f;

    /* renamed from: d */
    private int f44473d = -16777216;

    /* renamed from: e */
    private int f44474e = -16777216;

    /* renamed from: f */
    private float f44475f;

    /* renamed from: g */
    private float f44476g;

    /* renamed from: h */
    private CharSequence f44477h = "";

    /* renamed from: i */
    private CharSequence f44478i = "";

    /* renamed from: j */
    private TextView f44479j;

    /* renamed from: k */
    private TextView f44480k;

    /* renamed from: l */
    private IToolsService.FontType f44481l = IToolsService.FontType.BOLD;

    /* renamed from: m */
    private IToolsService.FontType f44482m = IToolsService.FontType.NORMAL;

    public CustomerPriceView(Context context) {
        super(context);
        m33013a(context, (AttributeSet) null);
    }

    public CustomerPriceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m33013a(context, attributeSet);
    }

    public CustomerPriceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m33013a(context, attributeSet);
    }

    public void setFontType(IToolsService.FontType fontType, IToolsService.FontType fontType2) {
        this.f44481l = fontType;
        this.f44482m = fontType2;
        m33012a();
    }

    public void setPriceStr(CharSequence charSequence, CharSequence charSequence2) {
        if (TextUtils.isEmpty(charSequence2)) {
            charSequence2 = "";
        }
        this.f44477h = charSequence;
        this.f44478i = charSequence2;
        m33015c();
    }

    public void setPriceLight(boolean z) {
        if (z) {
            this.f44479j.setTextColor(ResourceHelper.getColor(R.color.rf_color_v2_brand1_1_a100));
        } else {
            this.f44479j.setTextColor(-16777216);
        }
    }

    /* renamed from: a */
    private void m33013a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.CustomerPriceView);
            this.f44473d = obtainStyledAttributes.getColor(0, -16777216);
            this.f44474e = obtainStyledAttributes.getColor(6, -16777216);
            this.f44475f = (float) obtainStyledAttributes.getDimensionPixelSize(1, 0);
            this.f44476g = (float) obtainStyledAttributes.getDimensionPixelSize(7, 0);
            obtainStyledAttributes.recycle();
        }
        this.f44479j = new TextView(context);
        this.f44480k = new TextView(context);
        this.f44479j.setTextColor(this.f44473d);
        this.f44480k.setTextColor(this.f44474e);
        this.f44480k.getPaint().setFlags(16);
        this.f44480k.getPaint().setAntiAlias(true);
        this.f44479j.setTextSize(0, this.f44475f);
        this.f44480k.setTextSize(0, this.f44476g);
        this.f44479j.setMaxLines(1);
        this.f44480k.setMaxLines(1);
        m33014b();
        m33012a();
    }

    /* renamed from: a */
    private void m33012a() {
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f44479j, this.f44481l);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f44480k, this.f44482m);
    }

    /* renamed from: b */
    private void m33014b() {
        setOrientation(0);
        setGravity(16);
        this.f44479j.setPadding(0, 0, DisplayUtils.dip2px(getContext(), f44472c), 0);
        this.f44480k.setPadding(0, 0, 0, 0);
        addView(this.f44479j, new LinearLayoutCompat.LayoutParams(-2, -2));
        addView(this.f44480k, new LinearLayoutCompat.LayoutParams(-2, -2));
    }

    /* renamed from: c */
    private void m33015c() {
        this.f44479j.setText(this.f44477h);
        this.f44480k.setText(this.f44478i);
        if (TextUtils.isEmpty(this.f44477h)) {
            this.f44479j.setVisibility(8);
        } else {
            this.f44479j.setVisibility(0);
        }
        if (TextUtils.isEmpty(this.f44478i)) {
            this.f44480k.setVisibility(8);
        } else {
            this.f44480k.setVisibility(0);
        }
    }
}
