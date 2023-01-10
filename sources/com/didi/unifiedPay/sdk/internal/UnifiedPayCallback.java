package com.didi.unifiedPay.sdk.internal;

import com.didi.sdk.util.SingletonHolder;

public class UnifiedPayCallback {

    /* renamed from: a */
    private PayCallback f47206a;

    /* renamed from: b */
    private BindCardCallback f47207b;

    public interface BindCardCallback {
        void onFail(int i, String str);

        void onSuccess();
    }

    public interface PayCallback {
        void onFail(int i, String str);

        void onSuccess();
    }

    private UnifiedPayCallback() {
    }

    public static UnifiedPayCallback getInstance() {
        return (UnifiedPayCallback) SingletonHolder.getInstance(UnifiedPayCallback.class);
    }

    public void registerWXPayCallback(String str, PayCallback payCallback) {
        this.f47206a = payCallback;
    }

    public void registerQQPayCallback(String str, PayCallback payCallback) {
        this.f47206a = payCallback;
    }

    public void registerBindVisaCardCallback(BindCardCallback bindCardCallback) {
        this.f47207b = bindCardCallback;
    }

    public void unRegisterPayCallback() {
        this.f47206a = null;
    }

    public void unRegisterBindCardCallback() {
        this.f47207b = null;
    }

    public void unRegisterAllPayCallback() {
        unRegisterPayCallback();
        unRegisterBindCardCallback();
    }

    public PayCallback getPayCallback() {
        return this.f47206a;
    }

    public BindCardCallback getBindCardCallback() {
        return this.f47207b;
    }
}
