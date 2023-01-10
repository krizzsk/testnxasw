package com.didi.payment.base.push;

import android.content.Context;
import com.didi.payment.base.utils.ServiceLoaderUtil;

public class PayPushManager {

    /* renamed from: a */
    private IPayPush f32381a;

    private PayPushManager() {
        this.f32381a = (IPayPush) ServiceLoaderUtil.getInstance().load(IPayPush.class);
    }

    public static PayPushManager getInstance() {
        return SingleHolder.sInstance;
    }

    private static class SingleHolder {
        /* access modifiers changed from: private */
        public static final PayPushManager sInstance = new PayPushManager();

        private SingleHolder() {
        }
    }

    public void registerListener(Context context, String str, PushListener pushListener) {
        IPayPush iPayPush = this.f32381a;
        if (iPayPush != null) {
            iPayPush.register(context, str, pushListener);
        }
    }

    public void unregisterListener(PushListener pushListener) {
        IPayPush iPayPush = this.f32381a;
        if (iPayPush != null) {
            iPayPush.unregister(pushListener);
        }
    }
}
