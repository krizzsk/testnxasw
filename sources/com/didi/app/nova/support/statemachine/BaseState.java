package com.didi.app.nova.support.statemachine;

import com.didi.app.nova.support.helper.ActiveStateHelper;
import com.didi.app.nova.support.statemachine.BaseStateMachine;

public abstract class BaseState<T, S extends BaseStateMachine> {

    /* renamed from: a */
    private ActiveStateHelper f10377a;

    public void onStart(S s) {
    }

    public void onStop(S s) {
    }

    public abstract void update(S s, T t);

    public void onCreate(S s) {
        ActiveStateHelper activeStateHelper = new ActiveStateHelper();
        this.f10377a = activeStateHelper;
        activeStateHelper.active();
        s.dispatchStateCallback(getClass(), StateMachineConst.STATE_CREATE);
    }

    public void onDestroy(S s) {
        this.f10377a.inactive();
        s.dispatchStateCallback(getClass(), StateMachineConst.STATE_DESTROY);
    }
}
