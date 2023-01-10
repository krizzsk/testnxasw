package com.didi.nova.assembly.p128ui.shimmer;

import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.didi.passenger.C11267R;
import com.didi.sdk.apm.SystemUtils;

/* renamed from: com.didi.nova.assembly.ui.shimmer.ShimmerViewHelper */
public class ShimmerViewHelper {

    /* renamed from: a */
    private static final int f31764a = -1;

    /* renamed from: b */
    private View f31765b;

    /* renamed from: c */
    private Paint f31766c;

    /* renamed from: d */
    private float f31767d;

    /* renamed from: e */
    private LinearGradient f31768e;

    /* renamed from: f */
    private Matrix f31769f;

    /* renamed from: g */
    private int f31770g;

    /* renamed from: h */
    private int f31771h;

    /* renamed from: i */
    private boolean f31772i;

    /* renamed from: j */
    private boolean f31773j;

    /* renamed from: k */
    private AnimationSetupCallback f31774k;

    /* renamed from: com.didi.nova.assembly.ui.shimmer.ShimmerViewHelper$AnimationSetupCallback */
    public interface AnimationSetupCallback {
        void onSetupAnimation(View view);
    }

    public ShimmerViewHelper(View view, Paint paint, AttributeSet attributeSet) {
        this.f31765b = view;
        this.f31766c = paint;
        m24270a(attributeSet);
    }

    public float getGradientX() {
        return this.f31767d;
    }

    public void setGradientX(float f) {
        this.f31767d = f;
        this.f31765b.invalidate();
    }

    public boolean isShimmering() {
        return this.f31772i;
    }

    public void setShimmering(boolean z) {
        this.f31772i = z;
    }

    public boolean isSetUp() {
        return this.f31773j;
    }

    public void setAnimationSetupCallback(AnimationSetupCallback animationSetupCallback) {
        this.f31774k = animationSetupCallback;
    }

    public int getPrimaryColor() {
        return this.f31770g;
    }

    public void setPrimaryColor(int i) {
        this.f31770g = i;
        if (this.f31773j) {
            m24269a();
        }
    }

    public int getReflectionColor() {
        return this.f31771h;
    }

    public void setReflectionColor(int i) {
        this.f31771h = i;
        if (this.f31773j) {
            m24269a();
        }
    }

    /* renamed from: a */
    private void m24270a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes;
        this.f31771h = -1;
        if (!(attributeSet == null || (obtainStyledAttributes = this.f31765b.getContext().obtainStyledAttributes(attributeSet, C11267R.styleable.ShimmerView, 0, 0)) == null)) {
            try {
                this.f31771h = obtainStyledAttributes.getColor(0, -1);
            } catch (Exception e) {
                SystemUtils.log(6, "ShimmerTextView", "Error while creating the view:", e, "com.didi.nova.assembly.ui.shimmer.ShimmerViewHelper", 118);
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
            obtainStyledAttributes.recycle();
        }
        this.f31769f = new Matrix();
    }

    /* renamed from: a */
    private void m24269a() {
        int i = this.f31770g;
        LinearGradient linearGradient = new LinearGradient((float) (-this.f31765b.getWidth()), 0.0f, 0.0f, 0.0f, new int[]{i, this.f31771h, i}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP);
        this.f31768e = linearGradient;
        this.f31766c.setShader(linearGradient);
    }

    public void onSizeChanged() {
        m24269a();
        if (!this.f31773j) {
            this.f31773j = true;
            AnimationSetupCallback animationSetupCallback = this.f31774k;
            if (animationSetupCallback != null) {
                animationSetupCallback.onSetupAnimation(this.f31765b);
            }
        }
    }

    public void onDraw() {
        if (this.f31772i) {
            if (this.f31766c.getShader() == null) {
                this.f31766c.setShader(this.f31768e);
            }
            this.f31769f.setTranslate(this.f31767d * 2.0f, 0.0f);
            this.f31768e.setLocalMatrix(this.f31769f);
            return;
        }
        this.f31766c.setShader((Shader) null);
    }
}
