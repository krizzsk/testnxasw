package com.didi.unifylogin.presenter;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.text.TextUtils;
import com.didi.unifylogin.utils.KeyboardHelper;

class ViewAnimatorHelper$4 extends AnimatorListenerAdapter {
    final /* synthetic */ C15457a this$0;

    ViewAnimatorHelper$4(C15457a aVar) {
        this.this$0 = aVar;
    }

    public void onAnimationStart(Animator animator) {
        this.this$0.f47505a.setVisibility(0);
        this.this$0.f47505a.setLeftVisible(true);
        if (TextUtils.isEmpty(this.this$0.f47520p.getText())) {
            this.this$0.f47522r.setVisibility(8);
        } else {
            this.this$0.f47522r.setVisibility(0);
        }
        this.this$0.f47508d.setVisibility(0);
        this.this$0.f47508d.setBackgroundColor(0);
        this.this$0.f47516l.setAlpha(0.0f);
        this.this$0.f47519o.setAlpha(0.0f);
        this.this$0.f47522r.setAlpha(0.0f);
        this.this$0.f47517m.setAlpha(0.0f);
        this.this$0.f47518n.setAlpha(0.0f);
        this.this$0.f47521q.setAlpha(0.0f);
    }

    public void onAnimationEnd(Animator animator) {
        this.this$0.f47520p.requestFocus();
        this.this$0.f47506b.setVisibility(8);
        KeyboardHelper.showInputMethod(this.this$0.f47520p.getContext(), this.this$0.f47520p);
    }
}
