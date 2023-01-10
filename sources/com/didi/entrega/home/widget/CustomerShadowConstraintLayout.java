package com.didi.entrega.home.widget;

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
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.passenger.C11267R;

public class CustomerShadowConstraintLayout extends ConstraintLayout {

    /* renamed from: a */
    private int f22600a;

    /* renamed from: b */
    private float f22601b;

    /* renamed from: c */
    private float f22602c;

    /* renamed from: d */
    private float f22603d;

    /* renamed from: e */
    private float f22604e;

    /* renamed from: f */
    private float f22605f;

    /* renamed from: g */
    private float f22606g;

    /* renamed from: h */
    private int f22607h;

    /* renamed from: i */
    private boolean f22608i;

    /* renamed from: j */
    private Paint f22609j;

    public boolean isOpaque() {
        return false;
    }

    public float getmInsetPaddingOffset() {
        return (float) this.f22607h;
    }

    public CustomerShadowConstraintLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public CustomerShadowConstraintLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CustomerShadowConstraintLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f22600a = Color.argb(90, 0, 0, 0);
        this.f22601b = 30.0f;
        this.f22602c = 0.0f;
        this.f22603d = 0.0f;
        this.f22604e = 1.0f;
        this.f22605f = 0.0f;
        this.f22606g = 0.0f;
        this.f22607h = 0;
        this.f22608i = true;
        this.f22609j = new Paint(1);
        m18590a(context, attributeSet);
        m18592b();
        setClipChildren(false);
        setClipToPadding(false);
    }

    public void draw(Canvas canvas) {
        m18591a();
        canvas.drawRoundRect(getRectF(), this.f22603d, this.f22602c, this.f22609j);
        super.draw(canvas);
    }

    private void setViewFamilyClipChildren(ViewGroup viewGroup) {
        if (viewGroup != null) {
            viewGroup.setClipChildren(false);
            viewGroup.setClipToPadding(false);
            for (ViewParent parent = viewGroup.getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
                ViewGroup viewGroup2 = (ViewGroup) parent;
                viewGroup2.setClipChildren(false);
                viewGroup2.setClipToPadding(false);
            }
        }
    }

    /* renamed from: a */
    private boolean m18591a() {
        Drawable background = getBackground();
        if (background == null || (background instanceof InsetDrawable)) {
            return false;
        }
        setBackground(new InsetDrawable(background, this.f22607h + getPaddingLeft(), this.f22607h + getPaddingTop(), this.f22607h + getPaddingRight(), this.f22607h + getPaddingBottom()));
        return true;
    }

    private RectF getRectF() {
        return new RectF(((float) getPaddingLeft()) + this.f22605f, ((float) getPaddingTop()) + this.f22606g, ((float) (getWidth() - getPaddingRight())) + this.f22605f, ((float) (getHeight() - getPaddingBottom())) + this.f22606g);
    }

    /* renamed from: a */
    private void m18590a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.EntregaShadowLayout);
        if (obtainStyledAttributes != null) {
            this.f22600a = obtainStyledAttributes.getColor(3, this.f22600a);
            this.f22602c = obtainStyledAttributes.getDimension(8, this.f22602c);
            this.f22603d = obtainStyledAttributes.getDimension(7, this.f22603d);
            this.f22601b = obtainStyledAttributes.getDimension(2, this.f22601b);
            this.f22605f = obtainStyledAttributes.getDimension(4, this.f22605f);
            this.f22606g = obtainStyledAttributes.getDimension(5, this.f22606g);
            this.f22608i = obtainStyledAttributes.getBoolean(0, true);
            this.f22604e = obtainStyledAttributes.getFraction(1, 1, 1, 1.0f);
            this.f22607h = (int) obtainStyledAttributes.getDimension(6, 0.0f);
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: b */
    private void m18592b() {
        setLayerType(1, (Paint) null);
        this.f22609j.setAntiAlias(this.f22608i);
        this.f22609j.setColor(this.f22600a);
        this.f22609j.setAlpha((int) (this.f22604e * 255.0f));
        this.f22609j.setMaskFilter(new BlurMaskFilter(this.f22601b, BlurMaskFilter.Blur.NORMAL));
    }
}
