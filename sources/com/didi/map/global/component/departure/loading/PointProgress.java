package com.didi.map.global.component.departure.loading;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import java.lang.ref.WeakReference;

public class PointProgress extends View {

    /* renamed from: a */
    private int f27422a;

    /* renamed from: b */
    private int f27423b;

    /* renamed from: c */
    private Paint f27424c;

    /* renamed from: d */
    private int f27425d;

    /* renamed from: e */
    private int f27426e;

    /* renamed from: f */
    private int f27427f;

    /* renamed from: g */
    private int f27428g;

    /* renamed from: h */
    private float f27429h;

    public PointProgress(Context context) {
        this(context, (AttributeSet) null);
    }

    public PointProgress(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f27422a = 238;
        this.f27423b = 204;
        this.f27424c = null;
        this.f27425d = 0;
        this.f27426e = 0;
        this.f27427f = 0;
        this.f27428g = 0;
        this.f27429h = 0.0f;
        Paint paint = new Paint();
        this.f27424c = paint;
        paint.setAntiAlias(true);
        startAnimation(new PointProgressAnimation());
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float width = ((float) getWidth()) / 24.0f;
        this.f27425d = (int) (2.0f * width);
        this.f27426e = (int) (3.0f * width);
        this.f27427f = (int) (width * 9.0f);
        this.f27428g = getHeight() / 2;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m21749a(canvas);
    }

    /* renamed from: a */
    private void m21749a(Canvas canvas) {
        int i = this.f27422a;
        int i2 = this.f27423b;
        int i3 = i - i2;
        int i4 = this.f27426e - this.f27425d;
        float f = this.f27429h;
        if (f <= 0.33333334f) {
            float f2 = f / 0.33333334f;
            float f3 = ((float) i3) * f2;
            int i5 = (int) (((float) i) - f3);
            this.f27424c.setColor(Color.argb(255, i5, i5, i5));
            float f4 = f2 * ((float) i4);
            canvas.drawCircle((float) this.f27426e, (float) this.f27428g, ((float) this.f27425d) + f4, this.f27424c);
            Paint paint = this.f27424c;
            int i6 = this.f27422a;
            paint.setColor(Color.argb(255, i6, i6, i6));
            canvas.drawCircle((float) (this.f27426e + this.f27427f), (float) this.f27428g, (float) this.f27425d, this.f27424c);
            int i7 = (int) (((float) this.f27423b) + f3);
            this.f27424c.setColor(Color.argb(255, i7, i7, i7));
            int i8 = this.f27426e;
            canvas.drawCircle((float) ((this.f27427f * 2) + i8), (float) this.f27428g, ((float) i8) - f4, this.f27424c);
        } else if (f <= 0.33333334f || f > 0.6666667f) {
            float f5 = (this.f27429h - 0.6666667f) / 0.33333334f;
            Paint paint2 = this.f27424c;
            int i9 = this.f27422a;
            paint2.setColor(Color.argb(255, i9, i9, i9));
            canvas.drawCircle((float) this.f27426e, (float) this.f27428g, (float) this.f27425d, this.f27424c);
            float f6 = ((float) i3) * f5;
            int i10 = (int) (((float) this.f27423b) + f6);
            this.f27424c.setColor(Color.argb(255, i10, i10, i10));
            int i11 = this.f27426e;
            float f7 = f5 * ((float) i4);
            canvas.drawCircle((float) (this.f27427f + i11), (float) this.f27428g, ((float) i11) - f7, this.f27424c);
            int i12 = (int) (((float) this.f27422a) - f6);
            this.f27424c.setColor(Color.argb(255, i12, i12, i12));
            canvas.drawCircle((float) (this.f27426e + (this.f27427f * 2)), (float) this.f27428g, ((float) this.f27425d) + f7, this.f27424c);
        } else {
            float f8 = (f - 0.33333334f) / 0.33333334f;
            float f9 = (float) i2;
            float f10 = ((float) i3) * f8;
            int i13 = (int) (f9 + f10);
            this.f27424c.setColor(Color.argb(255, i13, i13, i13));
            int i14 = this.f27426e;
            float f11 = f8 * ((float) i4);
            canvas.drawCircle((float) i14, (float) this.f27428g, ((float) i14) - f11, this.f27424c);
            int i15 = (int) (((float) this.f27422a) - f10);
            this.f27424c.setColor(Color.argb(255, i15, i15, i15));
            canvas.drawCircle((float) (this.f27426e + this.f27427f), (float) this.f27428g, ((float) this.f27425d) + f11, this.f27424c);
            Paint paint3 = this.f27424c;
            int i16 = this.f27422a;
            paint3.setColor(Color.argb(255, i16, i16, i16));
            canvas.drawCircle((float) (this.f27426e + (this.f27427f * 2)), (float) this.f27428g, (float) this.f27425d, this.f27424c);
        }
    }

    /* access modifiers changed from: private */
    public void setProgress(float f) {
        this.f27429h = f;
        invalidate();
    }

    static class PointProgressAnimation extends Animation {
        private static int sDuration = 600;
        private WeakReference<PointProgress> mPointProgress;

        private PointProgressAnimation(PointProgress pointProgress) {
            this.mPointProgress = null;
            this.mPointProgress = new WeakReference<>(pointProgress);
        }

        public void initialize(int i, int i2, int i3, int i4) {
            super.initialize(i, i2, i3, i4);
            setDuration((long) sDuration);
            setRepeatCount(-1);
            setRepeatMode(1);
            setInterpolator(new LinearInterpolator());
        }

        /* access modifiers changed from: protected */
        public void applyTransformation(float f, Transformation transformation) {
            PointProgress pointProgress = (PointProgress) this.mPointProgress.get();
            if (pointProgress != null) {
                pointProgress.setProgress(f);
            }
        }
    }
}
