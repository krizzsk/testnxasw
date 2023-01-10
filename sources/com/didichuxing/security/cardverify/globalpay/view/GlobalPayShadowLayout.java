package com.didichuxing.security.cardverify.globalpay.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.didi.passenger.C11267R;

public class GlobalPayShadowLayout extends FrameLayout {

    /* renamed from: a */
    private int f51494a;

    /* renamed from: b */
    private float f51495b;

    /* renamed from: c */
    private float f51496c;

    /* renamed from: d */
    private float f51497d;

    /* renamed from: e */
    private float f51498e;

    public GlobalPayShadowLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public GlobalPayShadowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GlobalPayShadowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m38574a(context, attributeSet);
        m38572a();
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0 && getBackground() == null) {
            m38573a(i, i2);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int i5 = i3 - i;
        int i6 = i4 - i2;
        if (i5 > 0 && i6 > 0) {
            m38573a(i5, i6);
        }
    }

    /* renamed from: a */
    private void m38572a() {
        int shadowWidth = getShadowWidth();
        int shadowHeight = getShadowHeight();
        setPadding(shadowWidth, shadowHeight, shadowWidth, shadowHeight);
    }

    /* renamed from: a */
    private void m38573a(int i, int i2) {
        if (getShadowWidth() == 0 && getShadowHeight() == 0) {
            setBackground((Drawable) null);
            return;
        }
        setBackground(new BitmapDrawable(getResources(), m38571a(i, i2, this.f51496c, this.f51495b, this.f51497d, this.f51498e, this.f51494a, 0)));
    }

    /* renamed from: a */
    private void m38574a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.GlobalPayShadowLayout);
        this.f51496c = obtainStyledAttributes.getDimension(1, this.f51496c);
        this.f51495b = obtainStyledAttributes.getDimension(2, this.f51495b);
        this.f51497d = obtainStyledAttributes.getDimension(3, this.f51497d);
        this.f51498e = obtainStyledAttributes.getDimension(4, this.f51498e);
        this.f51494a = obtainStyledAttributes.getColor(0, this.f51494a);
    }

    private int getShadowWidth() {
        return (int) (this.f51495b + Math.abs(this.f51497d));
    }

    private int getShadowHeight() {
        return (int) (this.f51495b + Math.abs(this.f51498e));
    }

    /* renamed from: a */
    private Bitmap m38571a(int i, int i2, float f, float f2, float f3, float f4, int i3, int i4) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        RectF rectF = new RectF(f2, f2, ((float) i) - f2, ((float) i2) - f2);
        if (f4 > 0.0f) {
            rectF.top += f4;
            rectF.bottom -= f4;
        } else if (f4 < 0.0f) {
            rectF.top += Math.abs(f4);
            rectF.bottom -= Math.abs(f4);
        }
        if (f3 > 0.0f) {
            rectF.left += f3;
            rectF.right -= f3;
        } else if (f3 < 0.0f) {
            rectF.left += Math.abs(f3);
            rectF.right -= Math.abs(f3);
        }
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(i4);
        paint.setStyle(Paint.Style.FILL);
        if (!isInEditMode()) {
            paint.setShadowLayer(f2, f3, f4, i3);
        }
        canvas.drawRoundRect(rectF, f, f, paint);
        return createBitmap;
    }

    public void setShadow(int i, int i2, int i3, int i4, int i5) {
        this.f51494a = i;
        this.f51495b = (float) i2;
        this.f51496c = (float) i3;
        this.f51497d = (float) i4;
        this.f51498e = (float) i5;
        m38572a();
    }
}
