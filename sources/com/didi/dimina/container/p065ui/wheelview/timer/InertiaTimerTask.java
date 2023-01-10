package com.didi.dimina.container.p065ui.wheelview.timer;

import com.didi.dimina.container.p065ui.wheelview.view.WheelView;
import java.util.TimerTask;

/* renamed from: com.didi.dimina.container.ui.wheelview.timer.InertiaTimerTask */
public final class InertiaTimerTask extends TimerTask {

    /* renamed from: a */
    private float f19744a = 2.14748365E9f;

    /* renamed from: b */
    private final float f19745b;

    /* renamed from: c */
    private final WheelView f19746c;

    public InertiaTimerTask(WheelView wheelView, float f) {
        this.f19746c = wheelView;
        this.f19745b = f;
    }

    public final void run() {
        if (this.f19744a == 2.14748365E9f) {
            float f = 2000.0f;
            if (Math.abs(this.f19745b) > 2000.0f) {
                if (this.f19745b <= 0.0f) {
                    f = -2000.0f;
                }
                this.f19744a = f;
            } else {
                this.f19744a = this.f19745b;
            }
        }
        if (Math.abs(this.f19744a) < 0.0f || Math.abs(this.f19744a) > 20.0f) {
            WheelView wheelView = this.f19746c;
            float f2 = (float) ((int) (this.f19744a / 100.0f));
            wheelView.setTotalScrollY(wheelView.getTotalScrollY() - f2);
            if (!this.f19746c.isLoop()) {
                float itemHeight = this.f19746c.getItemHeight();
                float f3 = ((float) (-this.f19746c.getInitPosition())) * itemHeight;
                float itemsCount = ((float) ((this.f19746c.getItemsCount() - 1) - this.f19746c.getInitPosition())) * itemHeight;
                double d = ((double) itemHeight) * 0.25d;
                if (((double) this.f19746c.getTotalScrollY()) - d < ((double) f3)) {
                    f3 = this.f19746c.getTotalScrollY() + f2;
                } else if (((double) this.f19746c.getTotalScrollY()) + d > ((double) itemsCount)) {
                    itemsCount = this.f19746c.getTotalScrollY() + f2;
                }
                if (this.f19746c.getTotalScrollY() <= f3) {
                    this.f19744a = 40.0f;
                    this.f19746c.setTotalScrollY((float) ((int) f3));
                } else if (this.f19746c.getTotalScrollY() >= itemsCount) {
                    this.f19746c.setTotalScrollY((float) ((int) itemsCount));
                    this.f19744a = -40.0f;
                }
            }
            float f4 = this.f19744a;
            if (f4 < 0.0f) {
                this.f19744a = f4 + 20.0f;
            } else {
                this.f19744a = f4 - 20.0f;
            }
            this.f19746c.getHandler().sendEmptyMessage(1000);
            return;
        }
        this.f19746c.cancelFuture();
        this.f19746c.getHandler().sendEmptyMessage(2000);
    }
}
