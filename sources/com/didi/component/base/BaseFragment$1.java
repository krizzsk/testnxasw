package com.didi.component.base;

import android.animation.Animator;
import android.view.View;
import android.view.ViewTreeObserver;

class BaseFragment$1 implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ C5091a this$0;

    BaseFragment$1(C5091a aVar) {
        this.this$0 = aVar;
    }

    public void onGlobalLayout() {
        View a = this.this$0.f12832f;
        if (a != null) {
            a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            Animator m = this.this$0.mo50560m();
            if (m != null) {
                m.start();
            }
            this.this$0.mo50559l();
        }
    }
}
