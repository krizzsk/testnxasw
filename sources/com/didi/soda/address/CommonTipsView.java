package com.didi.soda.address;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CommonTipsView extends View {

    /* renamed from: a */
    private final int f41353a = 11;

    /* renamed from: b */
    private final int f41354b = 5;

    /* renamed from: c */
    private final int f41355c = 10;

    /* renamed from: d */
    private final int f41356d = 15;

    /* renamed from: e */
    private Context f41357e;

    /* renamed from: f */
    private TextView f41358f;

    /* renamed from: g */
    private ImageView f41359g;

    /* renamed from: h */
    private int f41360h;

    /* renamed from: i */
    private int f41361i;

    /* renamed from: a */
    private int m31027a(int i) {
        return 0;
    }

    /* renamed from: a */
    private void m31028a() {
    }

    public CommonTipsView(Context context) {
        super(context);
        this.f41357e = context;
    }

    public CommonTipsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f41357e = context;
    }

    public void setBackgroundColor(int i) {
        this.f41360h = i;
    }

    public void setCloseImage(int i) {
        this.f41359g.setImageResource(i);
    }

    public void setContent(String str) {
        this.f41358f.setText(str);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), i), getDefaultSize(getSuggestedMinimumHeight(), i2));
    }

    /* renamed from: b */
    private void m31029b() {
        new RelativeLayout(this.f41357e);
        new LinearLayout.LayoutParams(-2, -2);
    }

    public static final class ArrowOriation {
        public static final int BOTTOM_CENTER = 4096;
        public static final int BOTTOM_LEFT = 8192;
        public static final int BOTTOM_RIGHT = 12288;
        public static final int LEFT = 16;
        public static final int RIGHT = 256;
        public static final int UP_CENTER = 1;
        public static final int UP_LEFT = 2;
        public static final int UP_RIGHT = 3;

        private ArrowOriation() {
        }
    }
}
