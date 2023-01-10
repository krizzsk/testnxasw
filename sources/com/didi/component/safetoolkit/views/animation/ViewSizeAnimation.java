package com.didi.component.safetoolkit.views.animation;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class ViewSizeAnimation extends Animation {

    /* renamed from: a */
    private int f17335a;

    /* renamed from: b */
    private int f17336b;

    /* renamed from: c */
    private int f17337c;

    /* renamed from: d */
    private int f17338d;

    /* renamed from: e */
    private View f17339e;

    /* renamed from: f */
    private AnimationUpdater f17340f;

    /* renamed from: g */
    private float f17341g;

    public interface AnimationUpdater {
        void onUpdate(int i, int i2, int i3, int i4, float f);
    }

    public boolean willChangeBounds() {
        return true;
    }

    public ViewSizeAnimation(View view) {
        this.f17339e = view;
        this.f17336b = -1;
        this.f17338d = -1;
    }

    public ViewSizeAnimation(View view, int i, int i2) {
        this.f17339e = view;
        this.f17336b = i;
        this.f17338d = i2;
    }

    public ViewSizeAnimation(View view, int i) {
        this.f17339e = view;
        this.f17336b = -1;
        this.f17338d = i;
    }

    public void setTargetWidth(int i) {
        this.f17338d = i;
    }

    public void setTargetHeight(int i) {
        this.f17336b = i;
    }

    /* access modifiers changed from: protected */
    public void applyTransformation(float f, Transformation transformation) {
        if (this.f17341g != f) {
            this.f17341g = f;
            if (this.f17336b != -1) {
                ViewGroup.LayoutParams layoutParams = this.f17339e.getLayoutParams();
                int i = this.f17335a;
                layoutParams.height = i + ((int) (((float) (this.f17336b - i)) * f));
            }
            if (this.f17338d != -1) {
                ViewGroup.LayoutParams layoutParams2 = this.f17339e.getLayoutParams();
                int i2 = this.f17337c;
                layoutParams2.width = i2 + ((int) (((float) (this.f17338d - i2)) * f));
            }
            this.f17339e.requestLayout();
            AnimationUpdater animationUpdater = this.f17340f;
            if (animationUpdater != null) {
                animationUpdater.onUpdate(this.f17335a, this.f17337c, this.f17336b, this.f17338d, f);
            }
        }
    }

    public void initialize(int i, int i2, int i3, int i4) {
        this.f17335a = i2;
        this.f17337c = i;
        super.initialize(i, i2, i3, i4);
    }

    public void setAnimationUpdater(AnimationUpdater animationUpdater) {
        this.f17340f = animationUpdater;
    }
}
