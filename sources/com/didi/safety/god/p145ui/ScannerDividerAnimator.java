package com.didi.safety.god.p145ui;

import android.animation.ObjectAnimator;
import android.widget.ImageView;

/* renamed from: com.didi.safety.god.ui.ScannerDividerAnimator */
public class ScannerDividerAnimator {

    /* renamed from: a */
    private ImageView f37564a;

    /* renamed from: b */
    private ImageView f37565b;

    public ScannerDividerAnimator(ImageView imageView, ImageView imageView2) {
        this.f37564a = imageView;
        this.f37565b = imageView2;
    }

    public void startAnim() {
        this.f37564a.setVisibility(0);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.f37564a, "translationY", new float[]{0.0f, (float) ((this.f37565b.getHeight() * 2) / 3)}).setDuration(3000);
        duration.setRepeatCount(-1);
        duration.start();
    }

    public void stopAnim() {
        this.f37564a.clearAnimation();
        this.f37564a.setVisibility(8);
    }
}
