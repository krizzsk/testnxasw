package com.didi.soda.customer.biz.order.looper.mix.statemachine.state;

import com.didi.soda.customer.biz.order.looper.mix.statemachine.MixStrategyStateMachine;
import com.didi.soda.customer.biz.order.looper.trigger.TimerTriggerManager;
import com.didi.soda.customer.foundation.push.LongConnectionProvider;

public class TimeLoopState extends CBaseState {

    /* renamed from: b */
    private static final String f43028b = "TimeLoopState";

    /* renamed from: a */
    TimerTriggerManager f43029a;

    public void onCreate(MixStrategyStateMachine mixStrategyStateMachine) {
        super.onCreate(mixStrategyStateMachine);
        TimerTriggerManager timerTriggerManager = (TimerTriggerManager) mixStrategyStateMachine.getTrrigerManager(TimerTriggerManager.class);
        this.f43029a = timerTriggerManager;
        timerTriggerManager.start();
    }

    public void onDestroy(MixStrategyStateMachine mixStrategyStateMachine) {
        super.onDestroy(mixStrategyStateMachine);
        this.f43029a.stop();
    }

    public void onStart(MixStrategyStateMachine mixStrategyStateMachine) {
        super.onStart(mixStrategyStateMachine);
        this.f43029a.active();
    }

    public void onStop(MixStrategyStateMachine mixStrategyStateMachine) {
        super.onStop(mixStrategyStateMachine);
        this.f43029a.inactive();
    }

    public void start() {
        this.f43029a.start();
    }

    public void stop() {
        this.f43029a.stop();
    }

    public void update(MixStrategyStateMachine mixStrategyStateMachine, Void voidR) {
        if (LongConnectionProvider.getInstance().isConnected()) {
            mixStrategyStateMachine.switchTo(PushLoopState.class);
        }
    }
}
