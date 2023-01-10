package com.didi.hawaii.mapsdkv2.core;

import java.util.Timer;
import java.util.TimerTask;

final class RenderHeartbeat {

    /* renamed from: a */
    private static final int f26233a = 60;

    /* renamed from: b */
    private final Timer f26234b = new Timer("RenderHeartbeat");

    /* renamed from: c */
    private TimerTask f26235c;

    /* renamed from: d */
    private boolean f26236d = false;

    /* renamed from: e */
    private RenderListener f26237e;

    interface RenderListener {
        void invokeRequestRender();
    }

    RenderHeartbeat(RenderListener renderListener) {
        this.f26237e = renderListener;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo76360a(int i) {
        m20725d(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized void mo76362b(int i) {
        m20725d(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo76359a() {
        m20724c();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public synchronized void mo76363c(int i) {
        m20724c();
        m20725d(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized void mo76361b() {
        m20724c();
        this.f26234b.cancel();
    }

    /* renamed from: d */
    private void m20725d(int i) {
        if (i <= 0 || i > 6) {
            throw new IllegalArgumentException("Wrong fps ratios. Must between of FPS_60 and FPS_10");
        } else if (!this.f26236d) {
            RateTimerTask rateTimerTask = new RateTimerTask(this.f26237e);
            this.f26235c = rateTimerTask;
            try {
                this.f26234b.schedule(rateTimerTask, 0, 1000 / ((long) (60 / i)));
            } catch (Exception unused) {
            }
            this.f26236d = true;
        }
    }

    /* renamed from: c */
    private void m20724c() {
        if (this.f26236d) {
            TimerTask timerTask = this.f26235c;
            if (timerTask != null) {
                timerTask.cancel();
            }
            this.f26236d = false;
        }
    }

    static class RateTimerTask extends TimerTask {
        private boolean isCancel = false;
        final RenderListener listener;

        RateTimerTask(RenderListener renderListener) {
            this.listener = renderListener;
        }

        public void run() {
            if (!this.isCancel) {
                this.listener.invokeRequestRender();
            }
        }

        public boolean cancel() {
            this.isCancel = true;
            return super.cancel();
        }
    }
}
