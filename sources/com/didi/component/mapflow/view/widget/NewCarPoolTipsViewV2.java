package com.didi.component.mapflow.view.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.taxis99.R;

public class NewCarPoolTipsViewV2 extends LinearLayout {
    public NewCarPoolTipsViewV2(Context context) {
        super(context);
        m13730a();
    }

    public NewCarPoolTipsViewV2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m13730a();
    }

    public NewCarPoolTipsViewV2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m13730a();
    }

    /* renamed from: a */
    private void m13730a() {
        setOrientation(1);
        setGravity(1);
        TextView textView = new TextView(getContext());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, m13729a(20.0f)));
        textView.setGravity(17);
        textView.setText(R.string.map_flow_circle_text);
        textView.setTextSize(2, 10.0f);
        textView.setTextColor(Color.parseColor("#ffffff"));
        int a = m13729a(8.0f);
        int a2 = m13729a(4.0f);
        textView.setPadding(a, a2, a, a2);
        textView.setBackground(getResources().getDrawable(R.drawable.global_mapflow_tips_bg_shape_v2));
        addView(textView);
    }

    /* renamed from: a */
    private int m13729a(float f) {
        return (int) TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }
}
