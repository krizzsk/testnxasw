package com.didi.component.bubbleLayout.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.taxis99.R;

public class BubbleTopBarView extends RelativeLayout {

    /* renamed from: a */
    private ImageView f13000a;

    /* renamed from: b */
    private TextView f13001b;

    /* renamed from: c */
    private View f13002c;

    public BubbleTopBarView(Context context) {
        this(context, (AttributeSet) null);
    }

    public BubbleTopBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BubbleTopBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m10980a();
    }

    /* renamed from: a */
    private void m10980a() {
        LayoutInflater.from(getContext()).inflate(R.layout.bubble_top_bar_view, this, true);
        this.f13000a = (ImageView) findViewById(R.id.bubble_top_bar_arrow);
        this.f13001b = (TextView) findViewById(R.id.bubble_top_bar_title);
        this.f13002c = findViewById(R.id.bubble_top_bar_layout);
    }

    public void setAnimationProgress(float f) {
        if (f >= 1.0f) {
            f = 1.0f;
        }
        if (f < 0.0f) {
            f = 0.0f;
        }
        setAlphaProgress(f);
        setRotationProgress(f);
    }

    private void setAlphaProgress(float f) {
        this.f13002c.setBackgroundColor(Color.argb(((int) (f * 135.0f)) + 120, 255, 255, 255));
    }

    private void setRotationProgress(float f) {
        this.f13000a.setRotation(f * -90.0f);
        this.f13000a.invalidate();
    }

    public void setText(String str) {
        this.f13001b.setText(str);
    }
}
