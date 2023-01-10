package rui.internal.loopview;

/* renamed from: rui.internal.loopview.e */
/* compiled from: SmoothScrollTimerTask */
final class C3573e implements Runnable {

    /* renamed from: a */
    int f8652a = Integer.MAX_VALUE;

    /* renamed from: b */
    int f8653b = 0;

    /* renamed from: c */
    int f8654c;

    /* renamed from: d */
    final LoopView f8655d;

    C3573e(LoopView loopView, int i) {
        this.f8655d = loopView;
        this.f8654c = i;
    }

    public final void run() {
        if (this.f8652a == Integer.MAX_VALUE) {
            this.f8652a = this.f8654c;
        }
        int i = this.f8652a;
        int i2 = (int) (((float) i) * 0.1f);
        this.f8653b = i2;
        if (i2 == 0) {
            if (i < 0) {
                this.f8653b = -1;
            } else {
                this.f8653b = 1;
            }
        }
        if (Math.abs(this.f8652a) <= 0) {
            this.f8655d.cancelFuture();
            this.f8655d.f8632n.sendEmptyMessage(3000);
            return;
        }
        this.f8655d.f8626h += this.f8653b;
        this.f8655d.f8632n.sendEmptyMessage(1000);
        this.f8652a -= this.f8653b;
    }
}
