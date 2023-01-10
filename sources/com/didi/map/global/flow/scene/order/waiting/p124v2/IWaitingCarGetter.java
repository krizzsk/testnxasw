package com.didi.map.global.flow.scene.order.waiting.p124v2;

import com.didichuxing.carsliding.model.Driver;

/* renamed from: com.didi.map.global.flow.scene.order.waiting.v2.IWaitingCarGetter */
public interface IWaitingCarGetter {
    void requestCarPosition(Driver driver, IRequestDriverCallback iRequestDriverCallback);
}
