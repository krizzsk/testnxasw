package com.didi.dimina.container.p065ui.wheelview.timer;

import com.didi.dimina.container.p065ui.wheelview.view.WheelView;
import java.util.TimerTask;

/* renamed from: com.didi.dimina.container.ui.wheelview.timer.SmoothScrollTimerTask */
public final class SmoothScrollTimerTask extends TimerTask {

    /* renamed from: a */
    private int f19748a = Integer.MAX_VALUE;

    /* renamed from: b */
    private int f19749b = 0;

    /* renamed from: c */
    private final int f19750c;

    /* renamed from: d */
    private final WheelView f19751d;

    public SmoothScrollTimerTask(WheelView wheelView, int i) {
        this.f19751d = wheelView;
        this.f19750c = i;
    }

    public final void run() {
        if (this.f19748a == Integer.MAX_VALUE) {
            this.f19748a = this.f19750c;
        }
        int i = this.f19748a;
        int i2 = (int) (((float) i) * 0.1f);
        this.f19749b = i2;
        if (i2 == 0) {
            if (i < 0) {
                this.f19749b = -1;
            } else {
                this.f19749b = 1;
            }
        }
        if (Math.abs(this.f19748a) <= 1) {
            this.f19751d.cancelFuture();
            this.f19751d.getHandler().sendEmptyMessage(3000);
            return;
        }
        WheelView wheelView = this.f19751d;
        wheelView.setTotalScrollY(wheelView.getTotalScrollY() + ((float) this.f19749b));
        if (!this.f19751d.isLoop()) {
            float itemHeight = this.f19751d.getItemHeight();
            float f = ((float) (-this.f19751d.getInitPosition())) * itemHeight;
            float itemsCount = ((float) ((this.f19751d.getItemsCount() - 1) - this.f19751d.getInitPosition())) * itemHeight;
            if (this.f19751d.getTotalScrollY() <= f || this.f19751d.getTotalScrollY() >= itemsCount) {
                WheelView wheelView2 = this.f19751d;
                wheelView2.setTotalScrollY(wheelView2.getTotalScrollY() - ((float) this.f19749b));
                this.f19751d.cancelFuture();
                this.f19751d.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.f19751d.getHandler().sendEmptyMessage(1000);
        this.f19748a -= this.f19749b;
    }
}
