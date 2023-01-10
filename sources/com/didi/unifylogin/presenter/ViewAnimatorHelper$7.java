package com.didi.unifylogin.presenter;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class ViewAnimatorHelper$7 extends AnimatorListenerAdapter {
    final /* synthetic */ C15457a this$0;

    ViewAnimatorHelper$7(C15457a aVar) {
        this.this$0 = aVar;
    }

    public void onAnimationStart(Animator animator) {
        this.this$0.f47506b.setVisibility(0);
        this.this$0.f47510f.setText(this.this$0.f47520p.getText());
    }

    public void onAnimationEnd(Animator animator) {
        this.this$0.f47505a.setVisibility(8);
    }
}
