package com.didi.addressold.view.tips;

import android.animation.Animator;
import android.view.View;
import com.didi.autotracker.AutoTrackHelper;

class TipsWithLine$3 implements Animator.AnimatorListener {
    final /* synthetic */ C4090c this$0;
    final /* synthetic */ TipsLineView val$tipsLineView;

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }

    TipsWithLine$3(C4090c cVar, TipsLineView tipsLineView) {
        this.this$0 = cVar;
        this.val$tipsLineView = tipsLineView;
    }

    public void onAnimationEnd(Animator animator) {
        if (!this.this$0.f9867l) {
            this.this$0.f9856a.setmRemoveListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    TipsWithLine$3.this.val$tipsLineView.startEndAnim(200);
                }
            });
            this.this$0.m8600f();
            boolean unused = this.this$0.f9869n = false;
        }
    }
}
