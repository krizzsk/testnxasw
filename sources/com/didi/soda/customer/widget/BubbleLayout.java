package com.didi.soda.customer.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

class BubbleLayout extends LinearLayout {
    public static final int BOTTOM_LEFT = 4096;
    public static final int BOTTOM_MIDDLE = 8192;
    public static final int BOTTOM_RIGHT = 12288;
    public static final int LEFT_BOTTOM = 48;
    public static final int LEFT_MIDDLE = 32;
    public static final int LEFT_TOP = 16;
    public static final int NONE = 0;
    public static final int RIGHT_BOTTOM = 768;
    public static final int RIGHT_MIDDLE = 512;
    public static final int RIGHT_TOP = 256;
    public static final int TOP_LEFT = 1;
    public static final int TOP_MIDDLE = 2;
    public static final int TOP_RIGHT = 3;

    /* renamed from: a */
    private static int f44026a = 0;

    /* renamed from: b */
    private static int f44027b = 0;

    /* renamed from: c */
    private static float f44028c = 0.2f;
    public static float sCornerRadius;
    public static int sDefaultPaddingH;
    public static int sDefaultPaddingV;
    public static float sStrokeWidth;

    /* renamed from: d */
    private final Path f44029d;

    /* renamed from: e */
    private final Path f44030e;

    /* renamed from: f */
    private Paint f44031f;

    /* renamed from: g */
    private RectF f44032g;

    /* renamed from: h */
    private float f44033h;

    /* renamed from: i */
    private float f44034i;

    /* renamed from: j */
    private int f44035j;

    @Retention(RetentionPolicy.SOURCE)
    public @interface BubbleOrientation {
    }

    BubbleLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    BubbleLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    BubbleLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f44029d = new Path();
        this.f44030e = new Path();
        this.f44031f = null;
        this.f44035j = 32;
        m32821a(context, attributeSet);
    }

    public static float dip2Px(Context context, float f) {
        return (f * context.getResources().getDisplayMetrics().density) + 0.5f;
    }

    public void setBubbleParams(int i, float f) {
        this.f44035j = i;
        if (f > 0.0f) {
            f44028c = f;
        }
    }

    public void setFillColor(int i) {
        this.f44031f.setColor(i);
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f44033h = (float) getMeasuredWidth();
        this.f44034i = (float) getMeasuredHeight();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Matrix a = m32819a(this.f44033h, this.f44034i);
        this.f44029d.rewind();
        Path path = this.f44029d;
        RectF rectF = this.f44032g;
        float f = sCornerRadius;
        path.addRoundRect(rectF, f, f, Path.Direction.CW);
        this.f44029d.addPath(this.f44030e, a);
        canvas.drawPath(this.f44029d, this.f44031f);
    }

    /* renamed from: a */
    private void m32821a(Context context, AttributeSet attributeSet) {
        sDefaultPaddingH = (int) dip2Px(context, 0.0f);
        sDefaultPaddingV = (int) dip2Px(context, 0.0f);
        sStrokeWidth = 2.0f;
        sCornerRadius = dip2Px(context, 6.0f);
        f44026a = (int) dip2Px(context, 6.0f);
        f44027b = (int) dip2Px(context, 5.0f);
        Paint paint = new Paint();
        this.f44031f = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f44031f.setStrokeCap(Paint.Cap.BUTT);
        this.f44031f.setAntiAlias(true);
        this.f44031f.setStrokeWidth(sStrokeWidth);
        this.f44031f.setStrokeJoin(Paint.Join.MITER);
        setLayerType(1, this.f44031f);
        m32820a();
        setBackgroundColor(0);
        setClipChildren(false);
    }

    /* renamed from: a */
    private void m32820a() {
        if (this.f44035j != 0) {
            this.f44030e.moveTo(0.0f, 0.0f);
            this.f44030e.lineTo((float) f44027b, (float) (-f44026a));
            this.f44030e.lineTo((float) f44027b, (float) f44026a);
            this.f44030e.close();
        }
    }

    /* renamed from: a */
    private Matrix m32819a(float f, float f2) {
        Matrix matrix = new Matrix();
        int i = this.f44035j;
        if (i == 1) {
            f *= f44028c;
            matrix.postRotate(90.0f);
            int i2 = sDefaultPaddingH;
            int i3 = f44027b;
            int i4 = sDefaultPaddingV;
            setPadding(i2, i3 + i4, 0, i4);
            this.f44032g = new RectF(0.0f, (float) f44027b, this.f44033h, this.f44034i);
        } else if (i == 2) {
            f *= 0.5f;
            matrix.postRotate(90.0f);
            int i5 = sDefaultPaddingH;
            int i6 = f44027b;
            int i7 = sDefaultPaddingV;
            setPadding(i5, i6 + i7, 0, i7);
            this.f44032g = new RectF(0.0f, (float) f44027b, this.f44033h, this.f44034i);
        } else if (i != 3) {
            if (i == 16) {
                f2 *= f44028c;
                int i8 = sDefaultPaddingH + f44027b;
                int i9 = sDefaultPaddingV;
                setPadding(i8, i9, 0, i9);
                this.f44032g = new RectF((float) f44027b, 0.0f, this.f44033h, this.f44034i);
            } else if (i == 32) {
                f2 *= 0.5f;
                int i10 = sDefaultPaddingH + f44027b;
                int i11 = sDefaultPaddingV;
                setPadding(i10, i11, 0, i11);
                this.f44032g = new RectF((float) f44027b, 0.0f, this.f44033h, this.f44034i);
            } else if (i != 48) {
                if (i == 256) {
                    f2 *= f44028c;
                    matrix.postRotate(180.0f);
                    int i12 = sDefaultPaddingH;
                    int i13 = sDefaultPaddingV;
                    setPadding(i12, i13, f44027b, i13);
                    this.f44032g = new RectF(0.0f, 0.0f, this.f44033h - ((float) f44027b), this.f44034i);
                } else if (i == 512) {
                    f2 *= 0.5f;
                    matrix.postRotate(180.0f);
                    int i14 = sDefaultPaddingH;
                    int i15 = sDefaultPaddingV;
                    setPadding(i14, i15, f44027b, i15);
                    this.f44032g = new RectF(0.0f, 0.0f, this.f44033h - ((float) f44027b), this.f44034i);
                } else if (i == 768) {
                    f2 *= 1.0f - f44028c;
                    matrix.postRotate(180.0f);
                    int i16 = sDefaultPaddingH;
                    int i17 = sDefaultPaddingV;
                    setPadding(i16, i17, f44027b, i17);
                    this.f44032g = new RectF(0.0f, 0.0f, this.f44033h - ((float) f44027b), this.f44034i);
                } else if (i == 4096) {
                    f *= f44028c;
                    matrix.postRotate(270.0f);
                    int i18 = sDefaultPaddingH;
                    int i19 = sDefaultPaddingV;
                    setPadding(i18, i19, 0, f44027b + i19);
                    this.f44032g = new RectF(0.0f, 0.0f, this.f44033h, this.f44034i - ((float) f44027b));
                } else if (i == 8192) {
                    f *= 0.5f;
                    matrix.postRotate(270.0f);
                    int i20 = sDefaultPaddingH;
                    int i21 = sDefaultPaddingV;
                    setPadding(i20, i21, 0, f44027b + i21);
                    this.f44032g = new RectF(0.0f, 0.0f, this.f44033h, this.f44034i - ((float) f44027b));
                } else if (i != 12288) {
                    this.f44032g = new RectF(0.0f, 0.0f, this.f44033h, this.f44034i);
                    f = 0.0f;
                } else {
                    f *= 1.0f - f44028c;
                    matrix.postRotate(270.0f);
                    int i22 = sDefaultPaddingH;
                    int i23 = sDefaultPaddingV;
                    setPadding(i22, i23, 0, f44027b + i23);
                    this.f44032g = new RectF(0.0f, 0.0f, this.f44033h, this.f44034i - ((float) f44027b));
                }
                matrix.postTranslate(f, f2);
                return matrix;
            } else {
                f2 *= 1.0f - f44028c;
                int i24 = sDefaultPaddingH + f44027b;
                int i25 = sDefaultPaddingV;
                setPadding(i24, i25, 0, i25);
                this.f44032g = new RectF((float) f44027b, 0.0f, this.f44033h, this.f44034i);
            }
            f = 0.0f;
            matrix.postTranslate(f, f2);
            return matrix;
        } else {
            f *= 1.0f - f44028c;
            matrix.postRotate(90.0f);
            int i26 = sDefaultPaddingH;
            int i27 = f44027b;
            int i28 = sDefaultPaddingV;
            setPadding(i26, i27 + i28, 0, i28);
            this.f44032g = new RectF(0.0f, (float) f44027b, this.f44033h, this.f44034i);
        }
        f2 = 0.0f;
        matrix.postTranslate(f, f2);
        return matrix;
    }
}
