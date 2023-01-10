package com.didi.soda.business.page;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.ViewCompat;

class OverlayView extends View {

    /* renamed from: a */
    private Bitmap f42341a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Matrix f42342b = new Matrix();

    /* renamed from: c */
    private Matrix f42343c;

    /* renamed from: d */
    private Matrix f42344d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public View f42345e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public View f42346f;

    public interface AnimateEndListener {
        void onAnimationEnd();
    }

    public OverlayView(Context context, Bitmap bitmap) {
        super(context);
        this.f42341a = bitmap;
    }

    /* renamed from: a */
    public void mo107268a(View view, int i, int i2) {
        if (view != null) {
            this.f42345e = view;
            Matrix matrix = new Matrix();
            this.f42343c = matrix;
            matrix.setTranslate((float) i, (float) i2);
            this.f42342b.set(this.f42343c);
            mo107267a();
        }
    }

    /* renamed from: b */
    public void mo107270b(View view, int i, int i2) {
        if (view != null && this.f42345e != null) {
            this.f42346f = view;
            Matrix matrix = new Matrix();
            this.f42344d = matrix;
            matrix.setTranslate((float) i, (float) i2);
            this.f42344d.preScale((((float) this.f42346f.getWidth()) * 1.0f) / ((float) this.f42345e.getWidth()), (((float) this.f42346f.getHeight()) * 1.0f) / ((float) this.f42345e.getHeight()));
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bitmap = this.f42341a;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, this.f42342b, (Paint) null);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m31834c();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo107267a() {
        ViewCompat.postInvalidateOnAnimation(this);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Animator mo107269b() {
        if (this.f42345e == null || this.f42346f == null) {
            return null;
        }
        post(new Runnable() {
            public final void run() {
                OverlayView.this.m31837e();
            }
        });
        ValueAnimator ofObject = ValueAnimator.ofObject(new MatrixEvaluator(), new Object[]{this.f42343c, this.f42344d});
        ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                OverlayView.this.f42342b.set((Matrix) valueAnimator.getAnimatedValue());
                OverlayView.this.mo107267a();
            }
        });
        ofObject.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                OverlayView.this.f42345e.setVisibility(0);
                OverlayView.this.f42346f.setVisibility(0);
                OverlayView.this.m31835d();
            }

            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                OverlayView.this.f42345e.setVisibility(0);
                OverlayView.this.f42346f.setVisibility(0);
                OverlayView.this.m31835d();
            }
        });
        return ofObject;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void m31837e() {
        this.f42345e.setVisibility(4);
        this.f42346f.setVisibility(4);
    }

    /* renamed from: c */
    private void m31834c() {
        Bitmap bitmap = this.f42341a;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f42341a.recycle();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m31835d() {
        ViewParent parent = getParent();
        if (parent != null) {
            ((ViewGroup) parent).removeView(this);
        }
        m31834c();
    }

    private static class MatrixEvaluator implements TypeEvaluator<Matrix> {
        private Matrix mTemp;

        private MatrixEvaluator() {
            this.mTemp = new Matrix();
        }

        public Matrix evaluate(float f, Matrix matrix, Matrix matrix2) {
            float value = getValue(matrix, 2);
            float value2 = getValue(matrix, 5);
            float value3 = getValue(matrix2, 2);
            float value4 = getValue(matrix2, 5);
            float value5 = getValue(matrix, 0);
            float value6 = getValue(matrix, 4);
            float value7 = getValue(matrix2, 0);
            float value8 = getValue(matrix2, 4);
            this.mTemp.reset();
            this.mTemp.setTranslate(value + ((value3 - value) * f), value2 + ((value4 - value2) * f));
            this.mTemp.preScale(value5 + ((value7 - value5) * f), value6 + ((value8 - value6) * f));
            return new Matrix(this.mTemp);
        }

        private float getValue(Matrix matrix, int i) {
            float[] fArr = new float[9];
            matrix.getValues(fArr);
            return fArr[i];
        }
    }
}
