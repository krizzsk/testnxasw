package com.didi.entrega.customer.biz.order.looper.trigger;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.didi.entrega.customer.biz.order.looper.trigger.ITriggerManager;
import com.didi.entrega.customer.foundation.log.util.LogUtil;

public class TimerTriggerManager implements ITriggerManager {

    /* renamed from: a */
    private static final String f21675a = "TimerTriggerManager";

    /* renamed from: b */
    private Handler f21676b = new TimeHandler(Looper.getMainLooper(), new Runnable() {
        public void run() {
            TimerTriggerManager.this.doRequestOnce();
        }
    });
    /* access modifiers changed from: private */

    /* renamed from: c */
    public volatile boolean f21677c = false;

    /* renamed from: d */
    private volatile boolean f21678d = false;

    /* renamed from: e */
    private boolean f21679e;

    /* renamed from: f */
    private long f21680f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f21681g;
    protected ITriggerManager.TriggerListener mTriggerListener;

    public boolean isOverTime() {
        return false;
    }

    public TimerTriggerManager(int i) {
        this.f21681g = i;
        this.f21679e = true;
    }

    public void active() {
        LogUtil.m18185i(f21675a, "TimerTriggerManager --> active");
        this.f21679e = true;
    }

    public void doRequestOnce() {
        if (!this.f21678d) {
            m18115a();
            updateLastWorkTime();
        }
    }

    public void inactive() {
        LogUtil.m18185i(f21675a, "TimerTriggerManager --> inactive");
        this.f21679e = false;
    }

    public boolean isActive() {
        return this.f21679e;
    }

    public boolean isWorking() {
        return this.f21678d;
    }

    public void notifyWorkFinish() {
        this.f21678d = false;
    }

    public void reset() {
        this.f21676b.sendEmptyMessage(4);
    }

    public void serLooperTime(int i) {
        if (i < 3000) {
            i = 3000;
        }
        this.f21681g = i;
    }

    public void setTriggerListener(ITriggerManager.TriggerListener triggerListener) {
        this.mTriggerListener = triggerListener;
    }

    public void start() {
        if (!this.f21677c) {
            this.f21677c = true;
            LogUtil.m18185i(f21675a, "TimerTriggerManager --> start");
            this.f21676b.removeMessages(2);
            this.f21676b.sendEmptyMessage(2);
        }
    }

    public void stop() {
        if (this.f21677c) {
            this.f21676b.removeCallbacksAndMessages((Object) null);
            this.f21677c = false;
            notifyWorkFinish();
            LogUtil.m18185i(f21675a, "TimerTriggerManager --> stop");
        }
    }

    public void updateLastWorkTime() {
        this.f21680f = System.currentTimeMillis();
    }

    /* renamed from: a */
    private void m18115a() {
        this.f21678d = true;
        ITriggerManager.TriggerListener triggerListener = this.mTriggerListener;
        if (triggerListener != null) {
            triggerListener.doLoopWork((String) null);
            LogUtil.m18185i(f21675a, "TimerTriggerManager --> doWork");
        }
    }

    private class TimeHandler extends Handler {
        static final int DO_LOOP = 2;
        static final int RESET_TIMER = 4;
        static final int SHUT_DOWN = 3;
        private Runnable mRunnable;

        public TimeHandler(Looper looper, Runnable runnable) {
            super(looper);
            this.mRunnable = runnable;
        }

        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 2) {
                LogUtil.m18185i(TimerTriggerManager.f21675a, "timer DO_LOOP.");
                this.mRunnable.run();
                sendEmptyMessageDelayed(2, (long) TimerTriggerManager.this.f21681g);
            } else if (i == 3) {
                LogUtil.m18185i(TimerTriggerManager.f21675a, "looper ends");
                boolean unused = TimerTriggerManager.this.f21677c = false;
                removeCallbacksAndMessages((Object) null);
            } else if (i == 4) {
                LogUtil.m18185i(TimerTriggerManager.f21675a, "clear timer");
                removeMessages(2);
                sendEmptyMessageDelayed(2, (long) TimerTriggerManager.this.f21681g);
            }
        }
    }
}
