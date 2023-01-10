package com.didi.soda.uiwidget.cardview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.didi.passenger.C11267R;
import com.taxis99.R;

public class SodaCardView extends FrameLayout {

    /* renamed from: a */
    private static final int[] f46374a = {16842801};

    /* renamed from: b */
    private static final C15004e f46375b;

    /* renamed from: c */
    private final C15003d f46376c = new C15003d() {
        private Drawable mCardBackground;

        public void setCardBackground(Drawable drawable) {
            this.mCardBackground = drawable;
            SodaCardView.this.setBackgroundDrawable(drawable);
        }

        public boolean getUseCompatPadding() {
            return SodaCardView.this.getUseCompatPadding();
        }

        public boolean getPreventCornerOverlap() {
            return SodaCardView.this.getPreventCornerOverlap();
        }

        public void setShadowPadding(int i, int i2, int i3, int i4) {
            SodaCardView.this.f46378e.set(i, i2, i3, i4);
            SodaCardView sodaCardView = SodaCardView.this;
            SodaCardView.super.setPadding(i + sodaCardView.f46377d.left, i2 + SodaCardView.this.f46377d.top, i3 + SodaCardView.this.f46377d.right, i4 + SodaCardView.this.f46377d.bottom);
        }

        public void setMinWidthHeightInternal(int i, int i2) {
            if (i > SodaCardView.this.f46381h) {
                SodaCardView.super.setMinimumWidth(i);
            }
            if (i2 > SodaCardView.this.f46382i) {
                SodaCardView.super.setMinimumHeight(i2);
            }
        }

        public Drawable getCardBackground() {
            return this.mCardBackground;
        }

        public View getCardView() {
            return SodaCardView.this;
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final Rect f46377d = new Rect();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final Rect f46378e = new Rect();

    /* renamed from: f */
    private boolean f46379f;

    /* renamed from: g */
    private boolean f46380g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f46381h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f46382i;

    /* renamed from: j */
    private int f46383j;

    /* renamed from: k */
    private int f46384k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public Rect f46385l;

    /* renamed from: m */
    private int f46386m;

    static {
        if (Build.VERSION.SDK_INT >= 17) {
            f46375b = new C15000a();
        } else {
            f46375b = new C15002c();
        }
        f46375b.mo115593a();
    }

    public SodaCardView(Context context) {
        super(context);
        m34508a(context, (AttributeSet) null, 0);
    }

    public SodaCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m34508a(context, attributeSet, 0);
    }

    public SodaCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m34508a(context, attributeSet, i);
    }

    public boolean getUseCompatPadding() {
        return this.f46379f;
    }

    public void setUseCompatPadding(boolean z) {
        if (this.f46379f != z) {
            this.f46379f = z;
            f46375b.mo115607f(this.f46376c);
        }
    }

    public void setContentPadding(int i, int i2, int i3, int i4) {
        this.f46377d.set(i, i2, i3, i4);
        f46375b.mo115613l(this.f46376c);
    }

    public void setMinimumWidth(int i) {
        this.f46381h = i;
        super.setMinimumWidth(i);
    }

    public void setMinimumHeight(int i) {
        this.f46382i = i;
        super.setMinimumHeight(i);
    }

    public void setCardBackgroundColor(int i) {
        f46375b.mo115596a(this.f46376c, i);
    }

    public int getCardBackgroundColor() {
        return f46375b.mo115609h(this.f46376c);
    }

    public void setShadowStartColor(int i) {
        f46375b.mo115600b(this.f46376c, i);
    }

    public int getShadowStartColor() {
        return f46375b.mo115611j(this.f46376c);
    }

    public void setShadowEndColor(int i) {
        f46375b.mo115603c(this.f46376c, i);
    }

    public int getShadowEndColor() {
        return f46375b.mo115612k(this.f46376c);
    }

    public void setYShadowOffset(float f) {
        f46375b.mo115595a(this.f46376c, f);
    }

    public float getYShadowOffset() {
        return f46375b.mo115610i(this.f46376c);
    }

    public int getContentPaddingLeft() {
        return this.f46377d.left;
    }

    public int getContentPaddingRight() {
        return this.f46377d.right;
    }

    public int getContentPaddingTop() {
        return this.f46377d.top;
    }

    public int getContentPaddingBottom() {
        return this.f46377d.bottom;
    }

    public void setRadius(float f) {
        f46375b.mo115605d(this.f46376c, f);
    }

    public float getRadius() {
        return f46375b.mo115606e(this.f46376c);
    }

    public void setCardElevation(float f) {
        f46375b.mo115599b(this.f46376c, f);
    }

    public float getCardElevation() {
        return f46375b.mo115594a(this.f46376c);
    }

    public void setMaxCardElevation(float f) {
        f46375b.mo115602c(this.f46376c, f);
    }

    public float getMaxCardElevation() {
        return f46375b.mo115598b(this.f46376c);
    }

    public boolean getPreventCornerOverlap() {
        return this.f46380g;
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.f46380g) {
            this.f46380g = z;
            f46375b.mo115608g(this.f46376c);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (!(f46375b instanceof C15001b)) {
            int mode = View.MeasureSpec.getMode(i);
            if (mode == Integer.MIN_VALUE || mode == 1073741824) {
                i = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) f46375b.mo115604d(this.f46376c)), View.MeasureSpec.getSize(i)), mode);
            }
            int mode2 = View.MeasureSpec.getMode(i2);
            if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                i2 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) f46375b.mo115601c(this.f46376c)), View.MeasureSpec.getSize(i2)), mode2);
            }
            super.onMeasure(i, i2);
            return;
        }
        super.onMeasure(i, i2);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        m34511a(z);
    }

    /* renamed from: a */
    private void m34511a(boolean z) {
        View childAt;
        if (z && (childAt = getChildAt(0)) != null && (childAt instanceof ImageView) && Build.VERSION.SDK_INT >= 21) {
            childAt.setOutlineProvider(new ViewOutlineProvider() {
                public void getOutline(View view, Outline outline) {
                    if (SodaCardView.this.f46385l == null || Build.VERSION.SDK_INT < 21) {
                        Rect bounds = SodaCardView.this.getBackground().getBounds();
                        if (!(bounds.right == 0 && bounds.left == 0 && bounds.top == 0 && bounds.bottom == 0) && Build.VERSION.SDK_INT >= 21) {
                            Rect unused = SodaCardView.this.f46385l = bounds;
                            SodaCardView.this.f46385l.inset(SodaCardView.this.f46378e.left, SodaCardView.this.f46378e.top);
                            SodaCardView.this.f46385l.left += SodaCardView.this.f46377d.left;
                            SodaCardView.this.f46385l.right -= SodaCardView.this.f46377d.right;
                            SodaCardView.this.f46385l.top += SodaCardView.this.f46377d.top;
                            SodaCardView.this.f46385l.bottom -= SodaCardView.this.f46377d.bottom;
                            SodaCardView.this.f46385l.offsetTo(0, 0);
                            outline.setRoundRect(SodaCardView.this.f46385l, SodaCardView.this.getRadius());
                            return;
                        }
                        return;
                    }
                    outline.setRoundRect(SodaCardView.this.f46385l, SodaCardView.this.getRadius());
                }
            });
            childAt.setClipToOutline(true);
        }
    }

    /* renamed from: a */
    private void m34508a(Context context, AttributeSet attributeSet, int i) {
        int i2;
        Context context2 = context;
        AttributeSet attributeSet2 = attributeSet;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.SodaCardView, i, R.style.SodaCardView);
        if (obtainStyledAttributes.hasValue(2)) {
            i2 = obtainStyledAttributes.getColor(2, 0);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(f46374a);
            int color = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            if (fArr[2] > 0.5f) {
                i2 = getResources().getColor(R.color.soda_cardview_light_background);
            } else {
                i2 = getResources().getColor(R.color.soda_cardview_dark_background);
            }
        }
        this.f46383j = obtainStyledAttributes.getColor(14, 0);
        this.f46384k = obtainStyledAttributes.getColor(13, 0);
        float dimension = obtainStyledAttributes.getDimension(3, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(4, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(5, 0.0f);
        this.f46386m = obtainStyledAttributes.getDimensionPixelSize(15, 0);
        this.f46379f = obtainStyledAttributes.getBoolean(7, false);
        this.f46380g = obtainStyledAttributes.getBoolean(6, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(8, 0);
        this.f46377d.left = obtainStyledAttributes.getDimensionPixelSize(10, dimensionPixelSize);
        this.f46377d.top = obtainStyledAttributes.getDimensionPixelSize(12, dimensionPixelSize);
        this.f46377d.right = obtainStyledAttributes.getDimensionPixelSize(11, dimensionPixelSize);
        this.f46377d.bottom = obtainStyledAttributes.getDimensionPixelSize(9, dimensionPixelSize);
        float f = dimension2 > dimension3 ? dimension2 : dimension3;
        this.f46381h = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f46382i = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        obtainStyledAttributes.recycle();
        f46375b.mo115597a(this.f46376c, context, i2, dimension, dimension2, f, (float) this.f46386m, this.f46383j, this.f46384k);
    }
}
