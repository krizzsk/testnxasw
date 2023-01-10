package com.didi.rfusion.widget.floating;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.conductor.changehandler.AnimatorChangeHandler;
import com.taxis99.R;
import java.util.ArrayList;

public class RFFloatingChangeHandler extends AnimatorChangeHandler {

    /* renamed from: a */
    private static final String f36307a = "RFFloatingChangeHandler";

    /* renamed from: b */
    private static final int f36308b = 255;

    /* renamed from: c */
    private View f36309c;

    /* renamed from: d */
    private View f36310d;

    /* access modifiers changed from: protected */
    public void resetFromView(View view) {
    }

    public RFFloatingChangeHandler() {
    }

    public RFFloatingChangeHandler(boolean z) {
        super(z);
    }

    /* access modifiers changed from: protected */
    public Animator getAnimator(ViewGroup viewGroup, View view, View view2, boolean z, boolean z2) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        if (z && view2 != null) {
            m27346a(view2);
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{(float) m27348c(), 0.0f});
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    RFFloatingChangeHandler.this.m27347b(valueAnimator);
                }
            });
            arrayList.add(ofFloat);
        }
        animatorSet.playTogether(arrayList);
        return animatorSet;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m27347b(ValueAnimator valueAnimator) {
        m27344a(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    public Animator getExitAnimator(View view) {
        m27346a(view);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.f36310d.getTranslationY(), (float) m27348c()});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                RFFloatingChangeHandler.this.m27345a(valueAnimator);
            }
        });
        return ofFloat;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m27345a(ValueAnimator valueAnimator) {
        m27344a(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* renamed from: a */
    private void m27346a(View view) {
        this.f36309c = view.findViewById(R.id.rf_fl_floating);
        this.f36310d = view.findViewById(R.id.rf_rrl_frame);
    }

    /* renamed from: a */
    private void m27344a(float f) {
        float min = Math.min(Math.max(f, 0.0f), (float) m27348c());
        float c = 1.0f - (min / ((float) m27348c()));
        this.f36310d.setTranslationY(min);
        this.f36309c.getBackground().setAlpha((int) (c * 255.0f));
    }

    /* renamed from: c */
    private int m27348c() {
        return this.f36309c.getHeight() - this.f36310d.getTop();
    }
}
