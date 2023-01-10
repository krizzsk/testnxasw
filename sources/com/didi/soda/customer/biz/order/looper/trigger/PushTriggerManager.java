package com.didi.soda.customer.biz.order.looper.trigger;

import com.didi.soda.customer.biz.order.looper.trigger.ITriggerManager;
import com.didi.soda.customer.foundation.log.util.LogUtil;

public class PushTriggerManager implements ITriggerManager {

    /* renamed from: a */
    private long f43030a = System.currentTimeMillis();

    /* renamed from: b */
    private long f43031b = 15000;

    /* renamed from: c */
    private ITriggerManager.TriggerListener f43032c;

    /* renamed from: d */
    private boolean f43033d;

    public boolean isWorking() {
        return false;
    }

    public void notifyWorkFinish() {
    }

    public void reset() {
    }

    public void serLooperTime(int i) {
    }

    public PushTriggerManager() {
        LogUtil.m32584d("ITriggerManager", "PushTriggerManager --> PushTriggerManager");
    }

    public void active() {
        LogUtil.m32584d("Push refactor", "LooperPushManager -> onStart");
        this.f43033d = true;
    }

    public void doRequestOnce() {
        ITriggerManager.TriggerListener triggerListener = this.f43032c;
        if (triggerListener != null) {
            triggerListener.doLoopWork((String) null);
        }
    }

    public void inactive() {
        LogUtil.m32584d("ITriggerManager", "PushTriggerManager --> inactive");
        this.f43033d = false;
    }

    public boolean isActive() {
        LogUtil.m32584d("ITriggerManager", "PushTriggerManager --> isForeground");
        return this.f43033d;
    }

    public boolean isOverTime() {
        return System.currentTimeMillis() - this.f43030a > this.f43031b;
    }

    public void setTriggerListener(ITriggerManager.TriggerListener triggerListener) {
        this.f43032c = triggerListener;
    }

    public void start() {
        LogUtil.m32584d("ITriggerManager", "PushTriggerManager --> start");
    }

    public void stop() {
        LogUtil.m32584d("ITriggerManager", "PushTriggerManager --> stop");
    }

    public void updateLastWorkTime() {
        this.f43030a = System.currentTimeMillis();
    }
}
