package com.didi.entrega.order.pool;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import java.util.ArrayList;
import java.util.List;

class OrderMonitorLooper {

    /* renamed from: a */
    private static final String f22778a = "EntregaOrderMonitorLooper";

    /* renamed from: b */
    private boolean f22779b = false;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f22780c = 30000;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public List<MonitorLooperListener> f22781d = new ArrayList();

    /* renamed from: e */
    private OrderHandler f22782e = new OrderHandler(Looper.getMainLooper(), new Runnable() {
        public void run() {
            for (MonitorLooperListener looperWork : OrderMonitorLooper.this.f22781d) {
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
    public boolean mo67480a() {
        return this.f22779b;
    }

    /* renamed from: b */
    public void mo67481b() {
        this.f22779b = true;
        this.f22782e.sendEmptyMessage(4);
    }

    /* renamed from: a */
    public void mo67478a(int i) {
        this.f22780c = i;
    }

    /* renamed from: c */
    public void mo67483c() {
        if (!this.f22779b) {
            this.f22779b = true;
            this.f22782e.sendEmptyMessage(2);
        }
    }

    /* renamed from: d */
    public void mo67484d() {
        if (this.f22779b) {
            this.f22779b = false;
            this.f22782e.sendEmptyMessage(3);
        }
    }

    /* renamed from: a */
    public void mo67479a(MonitorLooperListener monitorLooperListener) {
        if (monitorLooperListener != null && !this.f22781d.contains(monitorLooperListener)) {
            this.f22781d.add(monitorLooperListener);
        }
    }

    /* renamed from: b */
    public void mo67482b(MonitorLooperListener monitorLooperListener) {
        this.f22781d.remove(monitorLooperListener);
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
                LogUtil.m18181d(OrderMonitorLooper.f22778a, "loop mType: DO_LOOP");
                this.mRunnable.run();
                removeMessages(2);
                sendEmptyMessageDelayed(2, (long) OrderMonitorLooper.this.f22780c);
            } else if (i == 3) {
                LogUtil.m18181d(OrderMonitorLooper.f22778a, "loop mType: SHUT_DOWN");
                removeCallbacksAndMessages((Object) null);
            } else if (i == 4) {
                LogUtil.m18181d(OrderMonitorLooper.f22778a, "loop mType: RESET_TIMER");
                removeMessages(4);
                removeMessages(2);
                sendEmptyMessageDelayed(2, 0);
            }
        }
    }
}
