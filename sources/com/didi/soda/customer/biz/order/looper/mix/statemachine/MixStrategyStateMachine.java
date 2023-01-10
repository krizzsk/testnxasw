package com.didi.soda.customer.biz.order.looper.mix.statemachine;

import com.didi.soda.customer.biz.order.looper.mix.statemachine.IMixMachineTrigger;
import com.didi.soda.customer.biz.order.looper.mix.statemachine.state.CBaseState;
import com.didi.soda.customer.biz.order.looper.mix.statemachine.state.PushLoopState;
import com.didi.soda.customer.biz.order.looper.mix.statemachine.state.TimeLoopState;
import com.didi.soda.customer.biz.order.looper.trigger.ITriggerManager;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.push.LongConnectionProvider;
import java.util.HashMap;
import java.util.Map;

public class MixStrategyStateMachine extends MixBaseStateMachine {
    public static final int INTERVAL = 5000;

    /* renamed from: b */
    private static final String f43022b = "MixStrategyStateMachine";

    /* renamed from: a */
    IMixMachineTrigger.OnTriggerListener f43023a = new IMixMachineTrigger.OnTriggerListener() {
        public void doTrigger() {
            MixStrategyStateMachine.this.update((Void) null);
        }
    };

    /* renamed from: c */
    private Map<Class, ITriggerManager> f43024c = new HashMap();

    /* renamed from: d */
    private IMixMachineTrigger f43025d;

    public MixStrategyStateMachine(IMixMachineTrigger iMixMachineTrigger, ITriggerManager... iTriggerManagerArr) {
        for (ITriggerManager iTriggerManager : iTriggerManagerArr) {
            this.f43024c.put(iTriggerManager.getClass(), iTriggerManager);
        }
        this.f43025d = iMixMachineTrigger;
        if (iMixMachineTrigger == null) {
            this.f43025d = new MixMachineTrigger();
        }
    }

    public ITriggerManager getTrrigerManager(Class cls) {
        return this.f43024c.get(cls);
    }

    public void onActive() {
        LogUtil.m32584d("Looper", "MixedLooperStrategyStateMachine -> onActive");
        this.mCurrentState.onStart(this);
    }

    public void onCreate() {
        LogUtil.m32584d("Looper", "MixedLooperStrategyStateMachine -> onCreate");
        super.onCreate();
        reset();
        this.f43025d.setInterval(5000);
        this.f43025d.setTriggerListener(this.f43023a);
        this.f43025d.onCreate();
    }

    public void onDestroy() {
        super.onDestroy();
        LogUtil.m32584d("Looper", "MixedLooperStrategyStateMachine -> onDestroy");
        this.mCurrentState.onDestroy(this);
        this.f43024c = null;
        this.f43025d.onDestroy();
        this.f43025d = null;
    }

    public void onInactive() {
        LogUtil.m32584d("Looper", "MixedLooperStrategyStateMachine -> onInactive");
        this.mCurrentState.onStop(this);
    }

    public void reset() {
        LogUtil.m32584d("Looper", "MixedLooperStrategyStateMachine -> reset");
        if (LongConnectionProvider.getInstance().isConnected()) {
            switchTo(PushLoopState.class);
        } else {
            switchTo(TimeLoopState.class);
        }
    }

    public void start() {
        LogUtil.m32584d("Looper", "MixedLooperStrategyStateMachine -> start");
        this.f43025d.start();
        ((CBaseState) this.mCurrentState).start();
    }

    public void stop() {
        LogUtil.m32584d("Looper", "MixedLooperStrategyStateMachine -> stop");
        this.f43025d.stop();
        ((CBaseState) this.mCurrentState).stop();
    }

    public void update(Void voidR) {
        super.update(voidR);
        LogUtil.m32584d("Looper", "MixedLooperStrategyStateMachine -> update");
        if (this.mCurrentState == null) {
            LogUtil.m32584d("Looper", "MixedLooperStrategyStateMachine -> update mCurrentState is null");
        } else {
            this.mCurrentState.update(this, null);
        }
    }
}
