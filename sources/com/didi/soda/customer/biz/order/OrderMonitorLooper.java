package com.didi.soda.customer.biz.order;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import java.util.ArrayList;
import java.util.List;

class OrderMonitorLooper {

    /* renamed from: a */
    private static final String f43013a = "OrderMonitorLooper";

    /* renamed from: b */
    private boolean f43014b = false;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f43015c = 30000;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public List<MonitorLooperListener> f43016d = new ArrayList();

    /* renamed from: e */
    private OrderHandler f43017e = new OrderHandler(Looper.getMainLooper(), new Runnable() {
        public void run() {
            for (MonitorLooperListener looperWork : OrderMonitorLooper.this.f43016d) {
                looperWork.looperWork();
            }
        }
    });

    public interface MonitorLooperListener {
        void looperWork();
    }

    OrderMonitorLooper() {
    }

    /* renamed from: a */
    public boolean mo108396a() {
        return this.f43014b;
    }

    /* renamed from: a */
    public void mo108395a(MonitorLooperListener monitorLooperListener) {
        if (monitorLooperListener != null && !this.f43016d.contains(monitorLooperListener)) {
            this.f43016d.add(monitorLooperListener);
        }
    }

    /* renamed from: b */
    public void mo108397b() {
        this.f43014b = true;
        this.f43017e.sendEmptyMessage(4);
    }

    /* renamed from: a */
    public void mo108394a(int i) {
        this.f43015c = i;
    }

    /* renamed from: c */
    public void mo108399c() {
        if (!this.f43014b) {
            this.f43014b = true;
            this.f43017e.sendEmptyMessage(2);
        }
    }

    /* renamed from: d */
    public void mo108400d() {
        if (this.f43014b) {
            this.f43014b = false;
            this.f43017e.sendEmptyMessage(3);
        }
    }

    /* renamed from: b */
    public void mo108398b(MonitorLooperListener monitorLooperListener) {
        this.f43016d.remove(monitorLooperListener);
    }

    class OrderHandler extends Handler {
        public static final int DO_LOOP = 2;
        public static final int RESET_TIMER = 4;
        public static final int SHUT_DOWN = 3;
        private Runnable mRunnable;

        OrderHandler(Looper looper, Runnable runnable) {
            super(looper);
            this.mRunnable = runnable;
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 2) {
                LogUtil.m32584d(OrderMonitorLooper.f43013a, "loop mType: DO_LOOP");
                this.mRunnable.run();
                removeMessages(2);
                sendEmptyMessageDelayed(2, (long) OrderMonitorLooper.this.f43015c);
            } else if (i == 3) {
                LogUtil.m32584d(OrderMonitorLooper.f43013a, "loop mType: SHUT_DOWN");
                removeCallbacksAndMessages((Object) null);
            } else if (i == 4) {
                LogUtil.m32584d(OrderMonitorLooper.f43013a, "loop mType: RESET_TIMER");
                removeMessages(4);
                removeMessages(2);
                sendEmptyMessageDelayed(2, 0);
            }
        }
    }
}
