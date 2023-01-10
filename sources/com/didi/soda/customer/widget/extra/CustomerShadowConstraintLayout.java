package com.didi.soda.customer.widget.extra;

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
    private int f44411a;

    /* renamed from: b */
    private float f44412b;

    /* renamed from: c */
    private float f44413c;

    /* renamed from: d */
    private float f44414d;

    /* renamed from: e */
    private float f44415e;

    /* renamed from: f */
    private float f44416f;

    /* renamed from: g */
    private float f44417g;

    /* renamed from: h */
    private int f44418h;

    /* renamed from: i */
    private boolean f44419i;

    /* renamed from: j */
    private Paint f44420j;

    public boolean isOpaque() {
        return false;
    }

    public float getmInsetPaddingOffset() {
        return (float) this.f44418h;
    }

    public CustomerShadowConstraintLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public CustomerShadowConstraintLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CustomerShadowConstraintLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f44411a = Color.argb(90, 0, 0, 0);
        this.f44412b = 30.0f;
        this.f44413c = 0.0f;
        this.f44414d = 0.0f;
        this.f44415e = 1.0f;
        this.f44416f = 0.0f;
        this.f44417g = 0.0f;
        this.f44418h = 0;
        this.f44419i = true;
        this.f44420j = new Paint(1);
        m32995a(context, attributeSet);
        m32997b();
        setClipChildren(false);
        setClipToPadding(false);
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

    public void draw(Canvas canvas) {
        m32996a();
        canvas.drawRoundRect(getRectF(), this.f44414d, this.f44413c, this.f44420j);
        super.draw(canvas);
    }

    /* renamed from: a */
    private boolean m32996a() {
        Drawable background = getBackground();
        if (background == null || (background instanceof InsetDrawable)) {
            return false;
        }
        setBackground(new InsetDrawable(background, this.f44418h + getPaddingLeft(), this.f44418h + getPaddingTop(), this.f44418h + getPaddingRight(), this.f44418h + getPaddingBottom()));
        return true;
    }

    private RectF getRectF() {
        return new RectF(((float) getPaddingLeft()) + this.f44416f, ((float) getPaddingTop()) + this.f44417g, ((float) (getWidth() - getPaddingRight())) + this.f44416f, ((float) (getHeight() - getPaddingBottom())) + this.f44417g);
    }

    /* renamed from: a */
    private void m32995a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.CustomerShadowLayout);
        if (obtainStyledAttributes != null) {
            this.f44411a = obtainStyledAttributes.getColor(3, this.f44411a);
            this.f44413c = obtainStyledAttributes.getDimension(8, this.f44413c);
            this.f44414d = obtainStyledAttributes.getDimension(7, this.f44414d);
            this.f44412b = obtainStyledAttributes.getDimension(2, this.f44412b);
            this.f44416f = obtainStyledAttributes.getDimension(4, this.f44416f);
            this.f44417g = obtainStyledAttributes.getDimension(5, this.f44417g);
            this.f44419i = obtainStyledAttributes.getBoolean(0, true);
            this.f44415e = obtainStyledAttributes.getFraction(1, 1, 1, 1.0f);
            this.f44418h = (int) obtainStyledAttributes.getDimension(6, 0.0f);
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: b */
    private void m32997b() {
        setLayerType(1, (Paint) null);
        this.f44420j.setAntiAlias(this.f44419i);
        this.f44420j.setColor(this.f44411a);
        this.f44420j.setAlpha((int) (this.f44415e * 255.0f));
        this.f44420j.setMaskFilter(new BlurMaskFilter(this.f44412b, BlurMaskFilter.Blur.NORMAL));
    }
}
