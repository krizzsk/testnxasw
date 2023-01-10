package com.didi.unifiedPay.sdk.internal;

import global.didi.pay.threeds.model.Adyen3DSModel;

public interface ThreeDSActionCallBack {
    void onThreeDSActionHandle(Adyen3DSModel adyen3DSModel);
}
