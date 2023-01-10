package p244in.srain.cube.views.ptr.header;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import p244in.srain.cube.views.ptr.PtrFrameLayout;
import p244in.srain.cube.views.ptr.PtrUIHandler;
import p244in.srain.cube.views.ptr.PtrUIHandlerHook;
import p244in.srain.cube.views.ptr.indicator.PtrIndicator;

/* renamed from: in.srain.cube.views.ptr.header.MaterialHeader */
public class MaterialHeader extends View implements PtrUIHandler {
    /* access modifiers changed from: private */
    public MaterialProgressDrawable mDrawable;
    private PtrFrameLayout mPtrFrameLayout;
    /* access modifiers changed from: private */
    public float mScale = 1.0f;
    /* access modifiers changed from: private */
    public Animation mScaleAnimation = new Animation() {
        public void applyTransformation(float f, Transformation transformation) {
            float unused = MaterialHeader.this.mScale = 1.0f - f;
            MaterialHeader.this.mDrawable.setAlpha((int) (MaterialHeader.this.mScale * 255.0f));
            MaterialHeader.this.invalidate();
        }
    };

    public void onUIRefreshPrepare(PtrFrameLayout ptrFrameLayout) {
    }

    public MaterialHeader(Context context) {
        super(context);
        initView();
    }

    public MaterialHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public MaterialHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    public void setPtrFrameLayout(PtrFrameLayout ptrFrameLayout) {
        final C220212 r0 = new PtrUIHandlerHook() {
            public void run() {
                MaterialHeader materialHeader = MaterialHeader.this;
                materialHeader.startAnimation(materialHeader.mScaleAnimation);
            }
        };
        this.mScaleAnimation.setDuration(200);
        this.mScaleAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                r0.resume();
            }
        });
        this.mPtrFrameLayout = ptrFrameLayout;
        ptrFrameLayout.setRefreshCompleteHook(r0);
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [in.srain.cube.views.ptr.header.MaterialHeader, android.graphics.drawable.Drawable$Callback, android.view.View] */
    private void initView() {
        MaterialProgressDrawable materialProgressDrawable = new MaterialProgressDrawable(getContext(), this);
        this.mDrawable = materialProgressDrawable;
        materialProgressDrawable.setBackgroundColor(-1);
        this.mDrawable.setCallback(this);
    }

    public void invalidateDrawable(Drawable drawable) {
        if (drawable == this.mDrawable) {
            invalidate();
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    public void setColorSchemeColors(int[] iArr) {
        this.mDrawable.setColorSchemeColors(iArr);
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(this.mDrawable.getIntrinsicHeight() + getPaddingTop() + getPaddingBottom(), 1073741824));
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int intrinsicHeight = this.mDrawable.getIntrinsicHeight();
        this.mDrawable.setBounds(0, 0, intrinsicHeight, intrinsicHeight);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int save = canvas.save();
        Rect bounds = this.mDrawable.getBounds();
        canvas.translate((float) (getPaddingLeft() + ((getMeasuredWidth() - this.mDrawable.getIntrinsicWidth()) / 2)), (float) getPaddingTop());
        float f = this.mScale;
        canvas.scale(f, f, bounds.exactCenterX(), bounds.exactCenterY());
        this.mDrawable.draw(canvas);
        canvas.restoreToCount(save);
    }

    public void onUIReset(PtrFrameLayout ptrFrameLayout) {
        this.mScale = 1.0f;
        this.mDrawable.stop();
    }

    public void onUIRefreshBegin(PtrFrameLayout ptrFrameLayout) {
        this.mDrawable.setAlpha(255);
        this.mDrawable.start();
    }

    public void onUIRefreshComplete(PtrFrameLayout ptrFrameLayout) {
        this.mDrawable.stop();
    }

    public void onUIPositionChange(PtrFrameLayout ptrFrameLayout, boolean z, byte b, PtrIndicator ptrIndicator) {
        float min = Math.min(1.0f, ptrIndicator.getCurrentPercent());
        if (b == 2) {
            this.mDrawable.setAlpha((int) (255.0f * min));
            this.mDrawable.showArrow(true);
            this.mDrawable.setStartEndTrim(0.0f, Math.min(0.8f, min * 0.8f));
            this.mDrawable.setArrowScale(Math.min(1.0f, min));
            this.mDrawable.setProgressRotation((((0.4f * min) - 16.0f) + (min * 2.0f)) * 0.5f);
            invalidate();
        }
    }
}
