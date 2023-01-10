package com.didi.map.global.component.departure.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didiglobal.font.DIDIFontUtils;
import com.taxis99.R;

public class CarPoolTipsView extends LinearLayout {
    public CarPoolTipsView(Context context) {
        super(context);
        m21811a();
    }

    public CarPoolTipsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m21811a();
    }

    public CarPoolTipsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m21811a();
    }

    /* renamed from: a */
    private void m21811a() {
        setOrientation(1);
        setGravity(1);
        TextView textView = new TextView(getContext());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, m21810a(28.0f)));
        textView.setGravity(17);
        textView.setText(R.string.GRider_Pickuppage0811_Get_in_QHVX);
        textView.setTextSize(2, 12.0f);
        textView.setTextColor(Color.parseColor("#ffffff"));
        DIDIFontUtils.Companion.setTypeface(getContext(), textView);
        textView.setBackground(getResources().getDrawable(R.drawable.departure_carpool_circle_tip_view_bg_shape));
        textView.setPadding(m21810a(9.75f), 0, m21810a(9.75f), 0);
        addView(textView);
    }

    /* renamed from: a */
    private int m21810a(float f) {
        return (int) TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }
}
