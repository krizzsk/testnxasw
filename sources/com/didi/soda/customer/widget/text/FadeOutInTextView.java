package com.didi.soda.customer.widget.text;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.didi.soda.customer.animation.CustomerInterpolator;

public class FadeOutInTextView extends RichTextView {

    /* renamed from: a */
    private AnimatorSet f44795a;

    public FadeOutInTextView(Context context) {
        super(context);
        m33224a();
    }

    public FadeOutInTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m33224a();
    }

    public FadeOutInTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m33224a();
    }

    public void showTextOnAnim(CharSequence charSequence) {
        CharSequence text = getText();
        if (TextUtils.isEmpty(text) || text.equals(charSequence)) {
            super.setText(charSequence);
        } else {
            m33225a(text, charSequence);
        }
    }

    /* renamed from: a */
    private void m33225a(final CharSequence charSequence, final CharSequence charSequence2) {
        if (!this.f44795a.isRunning()) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, View.ALPHA, new float[]{1.0f, 0.0f});
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, View.ALPHA, new float[]{0.0f, 1.0f});
            ofFloat.setDuration(100);
            ofFloat2.setDuration(100);
            ofFloat.setInterpolator(getInterpolator());
            ofFloat2.setInterpolator(getInterpolator());
            ofFloat.addListener(new Animator.AnimatorListener() {
                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationEnd(Animator animator) {
                    this.setText(charSequence2);
                }

                public void onAnimationStart(Animator animator) {
                    this.setText(charSequence);
                }
            });
            this.f44795a.play(ofFloat2).after(ofFloat);
            this.f44795a.start();
        }
    }

    private TimeInterpolator getInterpolator() {
        return CustomerInterpolator.newInstance();
    }

    /* renamed from: a */
    private void m33224a() {
        this.f44795a = new AnimatorSet();
    }
}
