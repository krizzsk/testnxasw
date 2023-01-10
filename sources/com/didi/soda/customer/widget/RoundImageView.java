package com.didi.soda.customer.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.passenger.C11267R;
import com.didi.soda.customer.app.GlobalContext;

public class RoundImageView extends AppCompatImageView {

    /* renamed from: g */
    private static final int f44168g = DisplayUtils.dip2px(GlobalContext.getContext(), 8.0f);

    /* renamed from: a */
    float f44169a;

    /* renamed from: b */
    float f44170b;

    /* renamed from: c */
    int f44171c;

    /* renamed from: d */
    int f44172d;

    /* renamed from: e */
    int f44173e;

    /* renamed from: f */
    int f44174f;

    public RoundImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public RoundImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m32877a(context, attributeSet, i);
    }

    public void setCorner(int i, int i2, int i3, int i4) {
        this.f44171c = i;
        this.f44172d = i2;
        this.f44173e = i3;
        this.f44174f = i4;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f44169a = (float) getWidth();
        this.f44170b = (float) getHeight();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int max = Math.max(0, this.f44171c);
        int max2 = Math.max(0, this.f44173e);
        int max3 = Math.max(0, this.f44172d);
        int max4 = Math.max(0, this.f44174f);
        Path path = new Path();
        float f = this.f44169a;
        if (f > ((float) (max + max3)) && f > ((float) (max2 + max4))) {
            float f2 = this.f44170b;
            if (f2 > ((float) (max3 + max4)) && f2 > ((float) (max + max2))) {
                float f3 = (float) max;
                path.moveTo(0.0f, f3);
                if (max > 0) {
                    path.quadTo(0.0f, 0.0f, f3, 0.0f);
                }
                float f4 = (float) max3;
                path.lineTo(this.f44169a - f4, 0.0f);
                if (max3 > 0) {
                    float f5 = this.f44169a;
                    path.quadTo(f5, 0.0f, f5, f4);
                }
                float f6 = (float) max4;
                path.lineTo(this.f44169a, this.f44170b - f6);
                if (max4 > 0) {
                    float f7 = this.f44169a;
                    float f8 = this.f44170b;
                    path.quadTo(f7, f8, f7 - f6, f8);
                }
                float f9 = (float) max2;
                path.lineTo(f9, this.f44170b);
                if (max2 > 0) {
                    float f10 = this.f44170b;
                    path.quadTo(0.0f, f10, 0.0f, f10 - f9);
                }
                path.lineTo(0.0f, (float) this.f44171c);
            }
        }
        canvas.clipPath(path);
        super.onDraw(canvas);
    }

    /* renamed from: a */
    private void m32877a(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.RoundImageView, i, 0);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, f44168g);
        this.f44171c = obtainStyledAttributes.getDimensionPixelSize(2, dimensionPixelSize);
        this.f44173e = obtainStyledAttributes.getDimensionPixelSize(1, dimensionPixelSize);
        this.f44172d = obtainStyledAttributes.getDimensionPixelSize(5, dimensionPixelSize);
        this.f44174f = obtainStyledAttributes.getDimensionPixelSize(4, dimensionPixelSize);
        obtainStyledAttributes.recycle();
    }
}
