package rui.internal.loopview;

/* renamed from: rui.internal.loopview.a */
/* compiled from: InertiaTimerTask */
final class C3569a implements Runnable {

    /* renamed from: a */
    float f8643a = 2.14748365E9f;

    /* renamed from: b */
    final float f8644b;

    /* renamed from: c */
    final LoopView f8645c;

    C3569a(LoopView loopView, float f) {
        this.f8645c = loopView;
        this.f8644b = f;
    }

    public final void run() {
        if (this.f8643a == 2.14748365E9f) {
            if (Math.abs(this.f8644b) <= 2000.0f) {
                this.f8643a = this.f8644b;
            } else if (this.f8644b > 0.0f) {
                this.f8643a = 2000.0f;
            } else {
                this.f8643a = -2000.0f;
            }
        }
        if (Math.abs(this.f8643a) < 0.0f || Math.abs(this.f8643a) > 20.0f) {
            this.f8645c.f8626h -= (int) ((this.f8643a * 10.0f) / 1000.0f);
            if (!this.f8645c.f8619a) {
                float f = (float) this.f8645c.f8629k;
                if (this.f8645c.f8626h <= ((int) (((float) (-this.f8645c.f8627i)) * f))) {
                    this.f8643a = 40.0f;
                    LoopView loopView = this.f8645c;
                    loopView.f8626h = (int) (((float) (-loopView.f8627i)) * f);
                } else if (this.f8645c.f8626h >= ((int) (((float) ((this.f8645c.f8634p.size() - 1) - this.f8645c.f8627i)) * f))) {
                    LoopView loopView2 = this.f8645c;
                    loopView2.f8626h = (int) (((float) ((loopView2.f8634p.size() - 1) - this.f8645c.f8627i)) * f);
                    this.f8643a = -40.0f;
                }
            }
            float f2 = this.f8643a;
            if (f2 < 0.0f) {
                this.f8643a = f2 + 20.0f;
            } else {
                this.f8643a = f2 - 20.0f;
            }
            this.f8645c.f8632n.sendEmptyMessage(1000);
            return;
        }
        this.f8645c.cancelFuture();
        this.f8645c.f8632n.sendEmptyMessage(2000);
    }
}
