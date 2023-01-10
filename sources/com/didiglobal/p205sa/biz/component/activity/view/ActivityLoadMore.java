package com.didiglobal.p205sa.biz.component.activity.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.didiglobal.p205sa.biz.weight.tkrefreshlayout.IBottomView;
import com.taxis99.R;

/* renamed from: com.didiglobal.sa.biz.component.activity.view.ActivityLoadMore */
public class ActivityLoadMore extends FrameLayout implements IBottomView {

    /* renamed from: a */
    private static final String f53282a = "ActivityLoadMore";

    /* renamed from: b */
    private LottieAnimationView f53283b;

    /* renamed from: c */
    private boolean f53284c;

    /* renamed from: d */
    private View f53285d;

    public View getView() {
        return this;
    }

    public void onPullReleasing(float f, float f2, float f3) {
    }

    public void reset() {
    }

    public void startAnim(float f, float f2) {
    }

    public ActivityLoadMore(Context context) {
        super(context);
        m39870a();
    }

    /* renamed from: a */
    private void m39870a() {
        this.f53285d = LayoutInflater.from(getContext()).inflate(R.layout.activity_bottom_load, this, true);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(R.id.animation_view);
        this.f53283b = lottieAnimationView;
        lottieAnimationView.setRepeatCount(-1);
        this.f53284c = false;
    }

    public void onPullingUp(float f, float f2, float f3) {
        if (!this.f53284c && f < -1.0f) {
            this.f53284c = true;
            this.f53283b.playAnimation();
        }
    }

    public void onFinish() {
        this.f53284c = false;
        this.f53283b.setProgress(0.0f);
        this.f53283b.cancelAnimation();
    }
}
