package com.didi.component.common.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.didi.passenger.C11267R;

public class CircleProgressBar extends View {

    /* renamed from: a */
    private float f13802a = 4.0f;

    /* renamed from: b */
    private float f13803b = 0.0f;

    /* renamed from: c */
    private int f13804c = 0;

    /* renamed from: d */
    private int f13805d = 100;

    /* renamed from: e */
    private int f13806e = -90;

    /* renamed from: f */
    private int f13807f = -12303292;

    /* renamed from: g */
    private int f13808g = -7829368;

    /* renamed from: h */
    private RectF f13809h;

    /* renamed from: i */
    private Paint f13810i;

    /* renamed from: j */
    private Paint f13811j;

    /* renamed from: k */
    private boolean f13812k = false;

    /* renamed from: l */
    private int f13813l = 30;

    /* renamed from: m */
    private int[] f13814m;

    /* renamed from: n */
    private float[] f13815n;

    /* renamed from: o */
    private Matrix f13816o;

    /* renamed from: p */
    private Bitmap f13817p;

    /* renamed from: q */
    private float f13818q;

    public float getStrokeWidth() {
        return this.f13802a;
    }

    public void setStrokeWidth(float f) {
        this.f13802a = f;
        this.f13810i.setStrokeWidth(f);
        this.f13811j.setStrokeWidth(f);
        invalidate();
        requestLayout();
    }

    public float getProgress() {
        return this.f13803b;
    }

    public void setProgress(float f) {
        this.f13803b = f;
        invalidate();
    }

    public void setPercent(float f) {
        this.f13803b = f * ((float) getMax());
        invalidate();
    }

    public int getMin() {
        return this.f13804c;
    }

    public void setMin(int i) {
        this.f13804c = i;
        invalidate();
    }

    public int getMax() {
        return this.f13805d;
    }

    public void setMax(int i) {
        this.f13805d = i;
        invalidate();
    }

    public int getColor() {
        return this.f13807f;
    }

    public void setColor(int i) {
        this.f13807f = i;
        this.f13811j.setColor(i);
        invalidate();
        requestLayout();
    }

    public int getBackColor() {
        return this.f13808g;
    }

    public void setBackColor(int i) {
        this.f13808g = i;
        this.f13810i.setColor(i);
        invalidate();
        requestLayout();
    }

    public CircleProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11455a(context, attributeSet);
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    private void m11455a(Context context, AttributeSet attributeSet) {
        this.f13809h = new RectF();
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C11267R.styleable.CircleProgressBar, 0, 0);
        try {
            this.f13802a = obtainStyledAttributes.getDimension(3, this.f13802a);
            this.f13803b = obtainStyledAttributes.getFloat(2, this.f13803b);
            int i = obtainStyledAttributes.getInt(5, this.f13807f);
            this.f13807f = i;
            this.f13808g = obtainStyledAttributes.getInt(4, i);
            this.f13804c = obtainStyledAttributes.getInt(1, this.f13804c);
            this.f13805d = obtainStyledAttributes.getInt(0, this.f13805d);
            obtainStyledAttributes.recycle();
            Paint paint = new Paint(1);
            this.f13810i = paint;
            paint.setColor(this.f13808g);
            this.f13810i.setStyle(Paint.Style.STROKE);
            this.f13810i.setStrokeWidth(this.f13802a);
            Paint paint2 = new Paint(1);
            this.f13811j = paint2;
            paint2.setColor(this.f13807f);
            this.f13811j.setStyle(Paint.Style.STROKE);
            this.f13811j.setStrokeWidth(this.f13802a);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = (this.f13803b * 360.0f) / ((float) this.f13805d);
        canvas.drawArc(this.f13809h, (float) this.f13806e, f, false, this.f13811j);
        if (this.f13812k && f > ((float) this.f13813l)) {
            if (this.f13817p == null) {
                m11454a();
            }
            Matrix matrix = this.f13816o;
            if (matrix == null) {
                Matrix matrix2 = new Matrix();
                this.f13816o = matrix2;
                matrix2.postRotate(((180.0f + f) + ((float) this.f13806e)) - ((float) this.f13813l), this.f13809h.centerX(), this.f13809h.centerY());
                this.f13818q = f;
            } else {
                matrix.postRotate(f - this.f13818q, this.f13809h.centerX(), this.f13809h.centerY());
                this.f13818q = f;
            }
            canvas.drawBitmap(this.f13817p, this.f13816o, (Paint) null);
        }
    }

    /* renamed from: a */
    private void m11454a() {
        this.f13817p = Bitmap.createBitmap((int) ((Math.sin(Math.toRadians((double) this.f13813l)) * ((double) this.f13809h.width())) / 2.0d), ((int) this.f13809h.height()) / 2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.f13817p);
        canvas.drawColor(0);
        SweepGradient sweepGradient = new SweepGradient(this.f13809h.centerX(), this.f13809h.centerY(), this.f13814m, this.f13815n);
        Matrix matrix = new Matrix();
        matrix.postRotate(-180.0f, this.f13809h.centerX(), this.f13809h.centerY());
        sweepGradient.setLocalMatrix(matrix);
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.f13802a);
        paint.setShader(sweepGradient);
        canvas.drawArc(this.f13809h, -180.0f, (float) this.f13813l, false, paint);
    }

    public void setGradientStatus(boolean z) {
        this.f13812k = z;
        if (!z) {
            Bitmap bitmap = this.f13817p;
            if (bitmap != null) {
                bitmap.recycle();
            }
            this.f13817p = null;
            this.f13816o = null;
        }
    }

    public void setGradientColor(int i, int i2, int i3) {
        this.f13813l = i3;
        this.f13814m = new int[]{i, i2};
        this.f13815n = new float[]{0.0f, ((float) i3) / 360.0f};
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int min = Math.min(getDefaultSize(getSuggestedMinimumWidth(), i), getDefaultSize(getSuggestedMinimumHeight(), i2));
        setMeasuredDimension(min, min);
        RectF rectF = this.f13809h;
        float f = this.f13802a;
        float f2 = (float) min;
        rectF.set((f / 2.0f) + 0.0f, (f / 2.0f) + 0.0f, f2 - (f / 2.0f), f2 - (f / 2.0f));
    }

    public int lightenColor(int i, float f) {
        float green = ((float) Color.green(i)) * f;
        float blue = ((float) Color.blue(i)) * f;
        return Color.argb(Color.alpha(i), Math.min(255, (int) (((float) Color.red(i)) * f)), Math.min(255, (int) green), Math.min(255, (int) blue));
    }

    public int adjustAlpha(int i, float f) {
        return Color.argb(Math.round(((float) Color.alpha(i)) * f), Color.red(i), Color.green(i), Color.blue(i));
    }

    public void setProgressWithAnimation(float f, int i) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "progress", new float[]{f});
        ofFloat.setDuration((long) i);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.start();
    }
}
