package com.didi.app.nova.skeleton.dialog;

import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.dialog.TransformAnimation;

public class SimpleTransformAnimation extends TransformAnimation {

    /* renamed from: b */
    private boolean f10271b = false;

    public void completeAnimationImmediately() {
    }

    public SimpleTransformAnimation() {
    }

    public SimpleTransformAnimation(boolean z) {
        super(z);
    }

    public void onAbortPush() {
        this.f10271b = true;
    }

    public void performChange(ViewGroup viewGroup, View view, View view2, boolean z, TransformAnimation.TransformAnimationListener transformAnimationListener) {
        if (!this.f10271b) {
            if (view != null && (!z || removeFromViewOnEnter())) {
                viewGroup.removeView(view);
            }
            if (view2 != null && view2.getParent() == null) {
                viewGroup.addView(view2);
            }
            transformAnimationListener.onAnimationCompleted();
        }
    }

    public SimpleTransformAnimation copy() {
        return new SimpleTransformAnimation(removeFromViewOnEnter());
    }
}
