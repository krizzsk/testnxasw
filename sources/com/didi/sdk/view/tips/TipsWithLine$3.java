package com.didi.sdk.view.tips;

import android.animation.Animator;
import android.view.View;
import com.didi.autotracker.AutoTrackHelper;

class TipsWithLine$3 implements Animator.AnimatorListener {
    final /* synthetic */ C14097c this$0;
    final /* synthetic */ TipsLineView val$tipsLineView;

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }

    TipsWithLine$3(C14097c cVar, TipsLineView tipsLineView) {
        this.this$0 = cVar;
        this.val$tipsLineView = tipsLineView;
    }

    public void onAnimationEnd(Animator animator) {
        if (!this.this$0.f41000l) {
            this.this$0.f40989a.setmRemoveListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    TipsWithLine$3.this.val$tipsLineView.startEndAnim(200);
                }
            });
            this.this$0.m30740f();
            boolean unused = this.this$0.f41002n = false;
        }
    }
}
