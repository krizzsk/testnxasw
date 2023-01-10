package com.didi.global.globaluikit.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.didi.sdk.apm.SystemUtils;

public class RoundCornerRelativeLayout extends RelativeLayout implements RCAttrs {

    /* renamed from: a */
    RCHelper f24556a;

    public RoundCornerRelativeLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public RoundCornerRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundCornerRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        RCHelper rCHelper = new RCHelper();
        this.f24556a = rCHelper;
        rCHelper.initAttrs(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f24556a.onSizeChanged(this, i, i2);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        SystemUtils.saveLayer(canvas, this.f24556a.mLayer, (Paint) null, 31);
        super.dispatchDraw(canvas);
        this.f24556a.onClipDraw(canvas);
        canvas.restore();
    }

    public void draw(Canvas canvas) {
        if (this.f24556a.mClipBackground) {
            canvas.save();
            canvas.clipPath(this.f24556a.mClipPath);
            super.draw(canvas);
            canvas.restore();
            return;
        }
        super.draw(canvas);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0 && !this.f24556a.mAreaRegion.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return false;
        }
        if (action == 0 || action == 1) {
            refreshDrawableState();
        } else if (action == 3) {
            setPressed(false);
            refreshDrawableState();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setClipBackground(boolean z) {
        this.f24556a.mClipBackground = z;
        invalidate();
    }

    public void setRoundAsCircle(boolean z) {
        this.f24556a.mRoundAsCircle = z;
        invalidate();
    }

    public void setRadius(int i) {
        for (int i2 = 0; i2 < this.f24556a.radii.length; i2++) {
            this.f24556a.radii[i2] = (float) i;
        }
        invalidate();
    }

    public void setTopLeftRadius(int i) {
        float f = (float) i;
        this.f24556a.radii[0] = f;
        this.f24556a.radii[1] = f;
        invalidate();
    }

    public void setTopRightRadius(int i) {
        float f = (float) i;
        this.f24556a.radii[2] = f;
        this.f24556a.radii[3] = f;
        invalidate();
    }

    public void setBottomLeftRadius(int i) {
        float f = (float) i;
        this.f24556a.radii[6] = f;
        this.f24556a.radii[7] = f;
        invalidate();
    }

    public void setBottomRightRadius(int i) {
        float f = (float) i;
        this.f24556a.radii[4] = f;
        this.f24556a.radii[5] = f;
        invalidate();
    }

    public void setStrokeWidth(int i) {
        this.f24556a.mStrokeWidth = i;
        invalidate();
    }

    public void setStrokeColor(int i) {
        this.f24556a.mStrokeColor = i;
        invalidate();
    }

    public void invalidate() {
        RCHelper rCHelper = this.f24556a;
        if (rCHelper != null) {
            rCHelper.refreshRegion(this);
        }
        super.invalidate();
    }

    public boolean isClipBackground() {
        return this.f24556a.mClipBackground;
    }

    public boolean isRoundAsCircle() {
        return this.f24556a.mRoundAsCircle;
    }

    public float getTopLeftRadius() {
        return this.f24556a.radii[0];
    }

    public float getTopRightRadius() {
        return this.f24556a.radii[2];
    }

    public float getBottomLeftRadius() {
        return this.f24556a.radii[4];
    }

    public float getBottomRightRadius() {
        return this.f24556a.radii[6];
    }

    public int getStrokeWidth() {
        return this.f24556a.mStrokeWidth;
    }

    public int getStrokeColor() {
        return this.f24556a.mStrokeColor;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        this.f24556a.drawableStateChanged(this);
    }
}
