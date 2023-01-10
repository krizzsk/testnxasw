package com.didi.map.global.flow.scene.order.serving;

public interface ITrafficEventFeedbackViewCallback {
    void countDownDismiss();

    void onDismiss();

    void onVerifyCode(int i);
}
