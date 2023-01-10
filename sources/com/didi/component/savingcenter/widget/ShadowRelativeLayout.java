package com.didi.component.savingcenter.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.didi.passenger.C11267R;

public class ShadowRelativeLayout extends RelativeLayout {

    /* renamed from: a */
    private int f17370a;

    /* renamed from: b */
    private float f17371b;

    /* renamed from: c */
    private float f17372c;

    /* renamed from: d */
    private float f17373d;

    /* renamed from: e */
    private float f17374e;

    /* renamed from: f */
    private Paint f17375f;

    public boolean isOpaque() {
        return false;
    }

    public ShadowRelativeLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public ShadowRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShadowRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f17370a = Color.argb(90, 0, 0, 0);
        this.f17371b = 30.0f;
        this.f17372c = 0.0f;
        this.f17373d = 0.0f;
        this.f17374e = 0.0f;
        this.f17375f = new Paint(1);
        m14590a(context, attributeSet);
        m14592b();
    }

    public void draw(Canvas canvas) {
        m14591a();
        RectF rectF = getRectF();
        float f = this.f17372c;
        canvas.drawRoundRect(rectF, f, f, this.f17375f);
        super.draw(canvas);
    }

    /* renamed from: a */
    private boolean m14591a() {
        Drawable background = getBackground();
        if (background == null || (background instanceof InsetDrawable)) {
            return false;
        }
        setBackground(new InsetDrawable(background, getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom()));
        return true;
    }

    private RectF getRectF() {
        return new RectF(((float) getPaddingLeft()) + this.f17373d, ((float) getPaddingTop()) + this.f17374e, ((float) (getWidth() - getPaddingRight())) + this.f17373d, ((float) (getHeight() - getPaddingBottom())) + this.f17374e);
    }

    /* renamed from: a */
    private void m14590a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.ShadowRelativeLayout);
        if (obtainStyledAttributes != null) {
            this.f17370a = obtainStyledAttributes.getColor(1, this.f17370a);
            this.f17372c = obtainStyledAttributes.getDimension(4, this.f17372c);
            this.f17371b = obtainStyledAttributes.getDimension(0, this.f17371b);
            this.f17373d = obtainStyledAttributes.getDimension(2, this.f17373d);
            this.f17374e = obtainStyledAttributes.getDimension(3, this.f17374e);
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: b */
    private void m14592b() {
        setLayerType(1, (Paint) null);
        this.f17375f.setAntiAlias(true);
        this.f17375f.setColor(this.f17370a);
        this.f17375f.setMaskFilter(new BlurMaskFilter(this.f17371b, BlurMaskFilter.Blur.NORMAL));
    }
}
