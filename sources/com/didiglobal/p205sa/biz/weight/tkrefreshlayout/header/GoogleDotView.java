package com.didiglobal.p205sa.biz.weight.tkrefreshlayout.header;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.core.view.InputDeviceCompat;
import com.didiglobal.p205sa.biz.weight.tkrefreshlayout.IHeaderView;
import com.didiglobal.p205sa.biz.weight.tkrefreshlayout.OnAnimEndListener;
import com.didiglobal.p205sa.biz.weight.tkrefreshlayout.utils.DensityUtil;

/* renamed from: com.didiglobal.sa.biz.weight.tkrefreshlayout.header.GoogleDotView */
public class GoogleDotView extends View implements IHeaderView {

    /* renamed from: a */
    float f53851a;

    /* renamed from: b */
    float f53852b;

    /* renamed from: c */
    boolean f53853c;

    /* renamed from: d */
    ValueAnimator f53854d;

    /* renamed from: e */
    ValueAnimator f53855e;

    /* renamed from: f */
    private Paint f53856f;

    /* renamed from: g */
    private float f53857g;

    /* renamed from: h */
    private int f53858h;

    /* renamed from: i */
    private int f53859i;

    public View getView() {
        return this;
    }

    public void setCir_x(int i) {
        this.f53859i = i;
    }

    public GoogleDotView(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public GoogleDotView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GoogleDotView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f53858h = 5;
        this.f53853c = false;
        m40162a();
    }

    /* renamed from: a */
    private void m40162a() {
        this.f53857g = (float) DensityUtil.dp2px(getContext(), 4.0f);
        Paint paint = new Paint();
        this.f53856f = paint;
        paint.setAntiAlias(true);
        this.f53856f.setColor(Color.rgb(114, 114, 114));
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 1.2f, 1.0f, 0.8f});
        this.f53854d = ofFloat;
        ofFloat.setDuration(800);
        this.f53854d.setInterpolator(new DecelerateInterpolator());
        this.f53854d.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                GoogleDotView.this.f53851a = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                GoogleDotView.this.invalidate();
            }
        });
        this.f53854d.setRepeatCount(-1);
        this.f53854d.setRepeatMode(2);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{1.0f, 0.8f, 1.0f, 1.2f});
        this.f53855e = ofFloat2;
        ofFloat2.setDuration(800);
        this.f53855e.setInterpolator(new DecelerateInterpolator());
        this.f53855e.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                GoogleDotView.this.f53852b = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            }
        });
        this.f53855e.setRepeatCount(-1);
        this.f53855e.setRepeatMode(2);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int measuredWidth = (getMeasuredWidth() / this.f53858h) - 10;
        for (int i = 0; i < this.f53858h; i++) {
            if (this.f53853c) {
                if (i == 0) {
                    this.f53856f.setAlpha(105);
                    this.f53856f.setColor(InputDeviceCompat.SOURCE_ANY);
                    canvas.drawCircle((float) (((getMeasuredWidth() / 2) - (this.f53859i * 2)) - (((measuredWidth * 2) / 3) * 2)), (float) (getMeasuredHeight() / 2), this.f53857g * this.f53852b, this.f53856f);
                } else if (i == 1) {
                    this.f53856f.setAlpha(145);
                    this.f53856f.setColor(-16711936);
                    canvas.drawCircle((float) (((getMeasuredWidth() / 2) - (this.f53859i * 1)) - ((measuredWidth / 3) * 2)), (float) (getMeasuredHeight() / 2), this.f53857g * this.f53852b, this.f53856f);
                } else if (i == 2) {
                    this.f53856f.setAlpha(255);
                    this.f53856f.setColor(-16776961);
                    canvas.drawCircle((float) (getMeasuredWidth() / 2), (float) (getMeasuredHeight() / 2), this.f53857g * this.f53851a, this.f53856f);
                } else if (i == 3) {
                    this.f53856f.setAlpha(145);
                    this.f53856f.setColor(-16711936);
                    canvas.drawCircle((float) ((getMeasuredWidth() / 2) + (this.f53859i * 1) + ((measuredWidth / 3) * 2)), (float) (getMeasuredHeight() / 2), this.f53857g * this.f53852b, this.f53856f);
                } else if (i == 4) {
                    this.f53856f.setAlpha(105);
                    this.f53856f.setColor(InputDeviceCompat.SOURCE_ANY);
                    canvas.drawCircle((float) ((getMeasuredWidth() / 2) + (this.f53859i * 2) + (((measuredWidth * 2) / 3) * 2)), (float) (getMeasuredHeight() / 2), this.f53857g * this.f53852b, this.f53856f);
                }
            } else if (i == 0) {
                this.f53856f.setAlpha(105);
                this.f53856f.setColor(InputDeviceCompat.SOURCE_ANY);
                canvas.drawCircle((float) (((getMeasuredWidth() / 2) - (this.f53859i * 2)) - (((measuredWidth * 2) / 3) * 2)), (float) (getMeasuredHeight() / 2), this.f53857g, this.f53856f);
            } else if (i == 1) {
                this.f53856f.setAlpha(145);
                this.f53856f.setColor(-16711936);
                canvas.drawCircle((float) (((getMeasuredWidth() / 2) - (this.f53859i * 1)) - ((measuredWidth / 3) * 2)), (float) (getMeasuredHeight() / 2), this.f53857g, this.f53856f);
            } else if (i == 2) {
                this.f53856f.setAlpha(255);
                this.f53856f.setColor(-16776961);
                canvas.drawCircle((float) (getMeasuredWidth() / 2), (float) (getMeasuredHeight() / 2), this.f53857g, this.f53856f);
            } else if (i == 3) {
                this.f53856f.setAlpha(145);
                this.f53856f.setColor(-16711936);
                canvas.drawCircle((float) ((getMeasuredWidth() / 2) + (this.f53859i * 1) + ((measuredWidth / 3) * 2)), (float) (getMeasuredHeight() / 2), this.f53857g, this.f53856f);
            } else if (i == 4) {
                this.f53856f.setAlpha(105);
                this.f53856f.setColor(InputDeviceCompat.SOURCE_ANY);
                canvas.drawCircle((float) ((getMeasuredWidth() / 2) + (this.f53859i * 2) + (((measuredWidth * 2) / 3) * 2)), (float) (getMeasuredHeight() / 2), this.f53857g, this.f53856f);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.f53854d;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.f53855e;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
    }

    public void onPullingDown(float f, float f2, float f3) {
        float f4 = (f / 2.0f) + 1.0f;
        setScaleX(f4);
        setScaleY(f4);
        this.f53853c = false;
        if (this.f53854d.isRunning()) {
            this.f53854d.cancel();
            invalidate();
        }
        if (this.f53855e.isRunning()) {
            this.f53855e.cancel();
        }
    }

    public void onPullReleasing(float f, float f2, float f3) {
        float f4 = (f / 2.0f) + 1.0f;
        setScaleX(f4);
        setScaleY(f4);
        if (f < 1.0f) {
            this.f53853c = false;
            if (this.f53854d.isRunning()) {
                this.f53854d.cancel();
                invalidate();
            }
            if (this.f53855e.isRunning()) {
                this.f53855e.cancel();
            }
        }
    }

    public void startAnim(float f, float f2) {
        this.f53853c = true;
        this.f53854d.start();
        this.f53855e.start();
    }

    public void onFinish(OnAnimEndListener onAnimEndListener) {
        onAnimEndListener.onAnimEnd();
    }

    public void reset() {
        this.f53853c = false;
        if (this.f53854d.isRunning()) {
            this.f53854d.cancel();
        }
        if (this.f53855e.isRunning()) {
            this.f53855e.cancel();
        }
        invalidate();
    }
}
