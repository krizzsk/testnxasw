package com.didi.unifiedPay.sdk.spei;

import android.text.TextUtils;
import com.didi.unifiedPay.sdk.internal.PayMethod;
import com.didi.unifiedPay.sdk.model.PrepayInfo;
import global.didi.pay.presenter.GlobalOffLinePaymentHelper;

public class SpeiMethod extends PayMethod {
    /* access modifiers changed from: protected */
    public <T> boolean checkPaySupport(T t) {
        return true;
    }

    /* access modifiers changed from: protected */
    public <T> boolean checkDataValid(T t) {
        PrepayInfo prepayInfo = (PrepayInfo) t;
        if (prepayInfo == null || TextUtils.isEmpty(prepayInfo.offline_pay_params) || TextUtils.isEmpty(GlobalOffLinePaymentHelper.getOfflinePayH5Url(prepayInfo.offline_pay_params))) {
            return false;
        }
        if (prepayInfo.pay_channel != 0) {
            return true;
        }
        prepayInfo.pay_channel = getPayChannel();
        return true;
    }

    public boolean onPay(PrepayInfo prepayInfo) {
        if (!checkDataValid(prepayInfo)) {
            initPayResultCheckAlarm(prepayInfo);
            return true;
        }
        this.mCallback.onPrePaySuccess(prepayInfo);
        return true;
    }
}
