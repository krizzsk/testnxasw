package com.didi.component.mapflow.view.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.taxis99.R;

public class CarPoolTipsView extends LinearLayout {
    public CarPoolTipsView(Context context) {
        super(context);
        m13708a();
    }

    public CarPoolTipsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m13708a();
    }

    public CarPoolTipsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m13708a();
    }

    /* renamed from: a */
    private void m13708a() {
        setOrientation(1);
        setGravity(1);
        CarPoolTriangleView carPoolTriangleView = new CarPoolTriangleView(getContext());
        carPoolTriangleView.setLayoutParams(new LinearLayout.LayoutParams(m13707a(9.0f), m13707a(4.5f)));
        addView(carPoolTriangleView);
        TextView textView = new TextView(getContext());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, m13707a(28.0f)));
        textView.setGravity(17);
        textView.setText(R.string.map_flow_circle_text);
        textView.setTextSize(2, 12.0f);
        textView.setTextColor(Color.parseColor("#ffffff"));
        textView.setBackground(getResources().getDrawable(R.drawable.global_mapflow_tips_bg_shape));
        textView.setPadding(m13707a(9.75f), 0, m13707a(9.75f), 0);
        addView(textView);
        setPadding(0, m13707a(10.0f), 0, 0);
    }

    /* renamed from: a */
    private int m13707a(float f) {
        return (int) TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }
}
