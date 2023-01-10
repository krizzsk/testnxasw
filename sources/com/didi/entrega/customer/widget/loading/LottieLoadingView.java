package com.didi.entrega.customer.widget.loading;

import android.content.Context;
import android.util.AttributeSet;
import com.airbnb.lottie.LottieAnimationView;

public class LottieLoadingView extends LottieAnimationView {

    /* renamed from: a */
    Runnable f22403a = new Runnable() {
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
        removeCallbacks(this.f22403a);
        if (isShown()) {
            playAnimation();
        } else {
            post(this.f22403a);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        removeCallbacks(this.f22403a);
        super.onDetachedFromWindow();
    }

    public void pauseAnimation() {
        super.pauseAnimation();
        removeCallbacks(this.f22403a);
    }

    public void cancelAnimation() {
        super.cancelAnimation();
        removeCallbacks(this.f22403a);
    }

    public void stop() {
        cancelAnimation();
    }
}
