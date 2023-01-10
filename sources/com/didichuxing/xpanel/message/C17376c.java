package com.didichuxing.xpanel.message;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;

/* renamed from: com.didichuxing.xpanel.message.c */
/* compiled from: MessageAnimatorProxyImpl */
class C17376c extends C17375b {
    C17376c(View view) {
        super(view);
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        View view = this.f52138a == null ? null : (View) this.f52138a.get();
        if (view != null) {
            if ((view instanceof ViewGroup) && XPanelMessageLayout.f52116a) {
                view = ((ViewGroup) view).getChildAt(0);
            }
            if (view != null) {
                ViewCompat.setTranslationY(view, ((float) view.getMeasuredHeight()) * ((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }
}
