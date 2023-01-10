package com.didi.universal.pay.sdk.method.internal;

import com.didi.sdk.util.SingletonHolder;

public class UnifiedPayCallback {

    /* renamed from: a */
    private PayCallback f47770a;

    /* renamed from: b */
    private BindCardCallback f47771b;

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
        this.f47770a = payCallback;
    }

    public void registerQQPayCallback(String str, PayCallback payCallback) {
        this.f47770a = payCallback;
    }

    public void registerBindVisaCardCallback(BindCardCallback bindCardCallback) {
        this.f47771b = bindCardCallback;
    }

    public void unRegisterPayCallback() {
        this.f47770a = null;
    }

    public void unRegisterBindCardCallback() {
        this.f47771b = null;
    }

    public void unRegisterAllPayCallback() {
        unRegisterPayCallback();
        unRegisterBindCardCallback();
    }

    public PayCallback getPayCallback() {
        return this.f47770a;
    }

    public BindCardCallback getBindCardCallback() {
        return this.f47771b;
    }
}
