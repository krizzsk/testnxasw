package com.didi.map.global.component.departure.wheel.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SimpleWheelItem extends FrameLayout {

    /* renamed from: a */
    private TextView f27696a;

    public SimpleWheelItem(Context context) {
        super(context);
        m21889a();
    }

    public SimpleWheelItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m21889a();
    }

    public SimpleWheelItem(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m21889a();
    }

    /* renamed from: a */
    private void m21889a() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, WheelUtils.dip2px(getContext(), 45.0f));
        linearLayout.setOrientation(0);
        linearLayout.setPadding(20, 20, 20, 20);
        linearLayout.setGravity(17);
        addView(linearLayout, layoutParams);
        TextView textView = new TextView(getContext());
        this.f27696a = textView;
        textView.setTag(101);
        this.f27696a.setEllipsize(TextUtils.TruncateAt.END);
        this.f27696a.setSingleLine();
        this.f27696a.setIncludeFontPadding(false);
        this.f27696a.setGravity(17);
        this.f27696a.setTextColor(-16777216);
        linearLayout.addView(this.f27696a, new FrameLayout.LayoutParams(-1, -1));
    }

    public void setText(CharSequence charSequence) {
        this.f27696a.setText(charSequence);
    }
}
