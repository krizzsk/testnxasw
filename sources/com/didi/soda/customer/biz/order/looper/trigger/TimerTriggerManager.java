package com.didi.soda.customer.biz.order.looper.trigger;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.didi.soda.customer.biz.order.looper.trigger.ITriggerManager;
import com.didi.soda.customer.foundation.log.util.LogUtil;

public class TimerTriggerManager implements ITriggerManager {

    /* renamed from: a */
    private static final String f43034a = "TimerTriggerManager";

    /* renamed from: b */
    private Handler f43035b = new TimeHandler(Looper.getMainLooper(), new Runnable() {
        public void run() {
            TimerTriggerManager.this.doRequestOnce();
        }
    });
    /* access modifiers changed from: private */

    /* renamed from: c */
    public volatile boolean f43036c = false;

    /* renamed from: d */
    private volatile boolean f43037d = false;

    /* renamed from: e */
    private boolean f43038e;

    /* renamed from: f */
    private long f43039f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f43040g;
    protected ITriggerManager.TriggerListener mTriggerListener;

    public boolean isOverTime() {
        return false;
    }

    public TimerTriggerManager(int i) {
        this.f43040g = i;
        this.f43038e = true;
    }

    public void active() {
        LogUtil.m32588i(f43034a, "TimerTriggerManager --> active");
        this.f43038e = true;
    }

    public void doRequestOnce() {
        if (!this.f43037d) {
            m32160a();
            updateLastWorkTime();
        }
    }

    public void inactive() {
        LogUtil.m32588i(f43034a, "TimerTriggerManager --> inactive");
        this.f43038e = false;
    }

    public boolean isActive() {
        return this.f43038e;
    }

    public boolean isWorking() {
        return this.f43037d;
    }

    public void notifyWorkFinish() {
        this.f43037d = false;
    }

    public void reset() {
        this.f43035b.sendEmptyMessage(4);
    }

    public void serLooperTime(int i) {
        if (i < 3000) {
            i = 3000;
        }
        this.f43040g = i;
    }

    public void setTriggerListener(ITriggerManager.TriggerListener triggerListener) {
        this.mTriggerListener = triggerListener;
    }

    public void start() {
        if (!this.f43036c) {
            this.f43036c = true;
            LogUtil.m32588i(f43034a, "TimerTriggerManager --> start");
            this.f43035b.removeMessages(2);
            this.f43035b.sendEmptyMessage(2);
        }
    }

    public void stop() {
        if (this.f43036c) {
            this.f43035b.removeCallbacksAndMessages((Object) null);
            this.f43036c = false;
            notifyWorkFinish();
            LogUtil.m32588i(f43034a, "TimerTriggerManager --> stop");
        }
    }

    public void updateLastWorkTime() {
        this.f43039f = System.currentTimeMillis();
    }

    /* renamed from: a */
    private void m32160a() {
        this.f43037d = true;
        ITriggerManager.TriggerListener triggerListener = this.mTriggerListener;
        if (triggerListener != null) {
            triggerListener.doLoopWork((String) null);
            LogUtil.m32588i(f43034a, "TimerTriggerManager --> doWork");
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
                LogUtil.m32588i(TimerTriggerManager.f43034a, "timer DO_LOOP.");
                this.mRunnable.run();
                sendEmptyMessageDelayed(2, (long) TimerTriggerManager.this.f43040g);
            } else if (i == 3) {
                LogUtil.m32588i(TimerTriggerManager.f43034a, "looper ends");
                boolean unused = TimerTriggerManager.this.f43036c = false;
                removeCallbacksAndMessages((Object) null);
            } else if (i == 4) {
                LogUtil.m32588i(TimerTriggerManager.f43034a, "clear timer");
                removeMessages(2);
                sendEmptyMessageDelayed(2, (long) TimerTriggerManager.this.f43040g);
            }
        }
    }
}
