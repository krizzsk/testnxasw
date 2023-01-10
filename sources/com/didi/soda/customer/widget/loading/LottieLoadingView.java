package com.didi.soda.customer.widget.loading;

import android.content.Context;
import android.util.AttributeSet;
import com.airbnb.lottie.LottieAnimationView;

public class LottieLoadingView extends LottieAnimationView {

    /* renamed from: a */
    Runnable f44646a = new Runnable() {
        public void run() {
            LottieLoadingView.this.removeCallbacks(this);
            LottieLoadingView.this.playAnimation();
        }
    };

    public LottieLoadingView(Context context) {
        super(context);
    }

    public LottieLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LottieLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void show() {
        start();
        setVisibility(0);
    }

    public void hide() {
        stop();
        setVisibility(8);
    }

    public boolean isRunning() {
        return getVisibility() == 0 && isAnimating();
    }

    public void start() {
        removeCallbacks(this.f44646a);
        if (isShown()) {
            playAnimation();
        } else {
            post(this.f44646a);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        removeCallbacks(this.f44646a);
        super.onDetachedFromWindow();
    }

    public void pauseAnimation() {
        super.pauseAnimation();
        removeCallbacks(this.f44646a);
    }

    public void cancelAnimation() {
        super.cancelAnimation();
        removeCallbacks(this.f44646a);
    }

    public void stop() {
        cancelAnimation();
    }
}
