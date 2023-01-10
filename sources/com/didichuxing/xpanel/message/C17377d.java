package com.didichuxing.xpanel.message;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;

/* renamed from: com.didichuxing.xpanel.message.d */
/* compiled from: MessageScaleAnimator */
class C17377d extends C17375b {
    C17377d(View view) {
        super(view);
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        View view = this.f52138a == null ? null : (View) this.f52138a.get();
        if (view != null) {
            if ((view instanceof ViewGroup) && XPanelMessageLayout.f52116a) {
                view = ((ViewGroup) view).getChildAt(0);
            }
            if (view != null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ViewCompat.setScaleX(view, floatValue);
                ViewCompat.setScaleY(view, floatValue);
            }
        }
    }
}
