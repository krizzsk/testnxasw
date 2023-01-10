package com.didi.soda.customer.biz.order.looper.mix.statemachine.state;

import com.didi.soda.customer.biz.order.looper.mix.statemachine.MixStrategyStateMachine;
import com.didi.soda.customer.biz.order.looper.trigger.PushTriggerManager;
import com.didi.soda.customer.foundation.push.LongConnectionProvider;

public class PushLoopState extends CBaseState {

    /* renamed from: b */
    private static final String f43026b = "PushLoopState";

    /* renamed from: a */
    PushTriggerManager f43027a;

    public void onCreate(MixStrategyStateMachine mixStrategyStateMachine) {
        super.onCreate(mixStrategyStateMachine);
        PushTriggerManager pushTriggerManager = (PushTriggerManager) mixStrategyStateMachine.getTrrigerManager(PushTriggerManager.class);
        this.f43027a = pushTriggerManager;
        pushTriggerManager.start();
    }

    public void onDestroy(MixStrategyStateMachine mixStrategyStateMachine) {
        super.onDestroy(mixStrategyStateMachine);
        this.f43027a.stop();
    }

    public void onStart(MixStrategyStateMachine mixStrategyStateMachine) {
        super.onStart(mixStrategyStateMachine);
        this.f43027a.active();
    }

    public void onStop(MixStrategyStateMachine mixStrategyStateMachine) {
        super.onStop(mixStrategyStateMachine);
        this.f43027a.inactive();
    }

    public void start() {
        this.f43027a.start();
    }

    public void stop() {
        this.f43027a.stop();
    }

    public void update(MixStrategyStateMachine mixStrategyStateMachine, Void voidR) {
        if (!LongConnectionProvider.getInstance().isConnected()) {
            mixStrategyStateMachine.switchTo(TimeLoopState.class);
        } else if (this.f43027a.isOverTime()) {
            this.f43027a.doRequestOnce();
            this.f43027a.updateLastWorkTime();
        }
    }
}
