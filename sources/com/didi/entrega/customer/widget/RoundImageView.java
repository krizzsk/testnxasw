package com.didi.entrega.customer.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.passenger.C11267R;

public class RoundImageView extends AppCompatImageView {

    /* renamed from: g */
    private static final int f22173g = DisplayUtils.dip2px(GlobalContext.getContext(), 8.0f);

    /* renamed from: a */
    float f22174a;

    /* renamed from: b */
    float f22175b;

    /* renamed from: c */
    int f22176c;

    /* renamed from: d */
    int f22177d;

    /* renamed from: e */
    int f22178e;

    /* renamed from: f */
    int f22179f;

    public RoundImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public RoundImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18327a(context, attributeSet, i);
    }

    public void setCorner(int i, int i2, int i3, int i4) {
        this.f22176c = i;
        this.f22177d = i2;
        this.f22178e = i3;
        this.f22179f = i4;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f22174a = (float) getWidth();
        this.f22175b = (float) getHeight();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int max = Math.max(0, this.f22176c);
        int max2 = Math.max(0, this.f22178e);
        int max3 = Math.max(0, this.f22177d);
        int max4 = Math.max(0, this.f22179f);
        Path path = new Path();
        float f = this.f22174a;
        if (f > ((float) (max + max3)) && f > ((float) (max2 + max4))) {
            float f2 = this.f22175b;
            if (f2 > ((float) (max3 + max4)) && f2 > ((float) (max + max2))) {
                float f3 = (float) max;
                path.moveTo(0.0f, f3);
                if (max > 0) {
                    path.quadTo(0.0f, 0.0f, f3, 0.0f);
                }
                float f4 = (float) max3;
                path.lineTo(this.f22174a - f4, 0.0f);
                if (max3 > 0) {
                    float f5 = this.f22174a;
                    path.quadTo(f5, 0.0f, f5, f4);
                }
                float f6 = (float) max4;
                path.lineTo(this.f22174a, this.f22175b - f6);
                if (max4 > 0) {
                    float f7 = this.f22174a;
                    float f8 = this.f22175b;
                    path.quadTo(f7, f8, f7 - f6, f8);
                }
                float f9 = (float) max2;
                path.lineTo(f9, this.f22175b);
                if (max2 > 0) {
                    float f10 = this.f22175b;
                    path.quadTo(0.0f, f10, 0.0f, f10 - f9);
                }
                path.lineTo(0.0f, (float) this.f22176c);
            }
        }
        canvas.clipPath(path);
        super.onDraw(canvas);
    }

    /* renamed from: a */
    private void m18327a(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.EntregaRoundImageView, i, 0);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, f22173g);
        this.f22176c = obtainStyledAttributes.getDimensionPixelSize(2, dimensionPixelSize);
        this.f22178e = obtainStyledAttributes.getDimensionPixelSize(1, dimensionPixelSize);
        this.f22177d = obtainStyledAttributes.getDimensionPixelSize(4, dimensionPixelSize);
        this.f22179f = obtainStyledAttributes.getDimensionPixelSize(3, dimensionPixelSize);
        obtainStyledAttributes.recycle();
    }
}
