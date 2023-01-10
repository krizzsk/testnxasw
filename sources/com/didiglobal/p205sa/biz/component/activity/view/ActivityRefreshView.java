package com.didiglobal.p205sa.biz.component.activity.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.didiglobal.p205sa.biz.weight.tkrefreshlayout.IHeaderView;
import com.didiglobal.p205sa.biz.weight.tkrefreshlayout.OnAnimEndListener;
import com.taxis99.R;

/* renamed from: com.didiglobal.sa.biz.component.activity.view.ActivityRefreshView */
public class ActivityRefreshView extends FrameLayout implements IHeaderView {

    /* renamed from: a */
    private static final String f53303a = "ActivityRefreshView";

    /* renamed from: b */
    private LottieAnimationView f53304b;

    /* renamed from: c */
    private boolean f53305c;

    public View getView() {
        return this;
    }

    public void onPullReleasing(float f, float f2, float f3) {
    }

    public void reset() {
    }

    public void startAnim(float f, float f2) {
    }

    public ActivityRefreshView(Context context) {
        super(context);
        m39883a();
    }

    /* renamed from: a */
    private void m39883a() {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_head_refresh, this, true);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(R.id.animation_view);
        this.f53304b = lottieAnimationView;
        lottieAnimationView.setRepeatCount(-1);
        this.f53305c = false;
    }

    public void onPullingDown(float f, float f2, float f3) {
        if (!this.f53305c && f > 1.0f) {
            this.f53305c = true;
            this.f53304b.playAnimation();
        }
    }

    public void onFinish(OnAnimEndListener onAnimEndListener) {
        this.f53305c = false;
        this.f53304b.setProgress(0.0f);
        this.f53304b.cancelAnimation();
        onAnimEndListener.onAnimEnd();
    }
}
