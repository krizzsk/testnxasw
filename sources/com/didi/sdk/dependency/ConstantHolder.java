package com.didi.sdk.dependency;

public class ConstantHolder {

    /* renamed from: a */
    private ConstantListener f38574a;

    private static class SingletonHolder {
        /* access modifiers changed from: private */
        public static final ConstantHolder INSTANCE = new ConstantHolder();

        private SingletonHolder() {
        }
    }

    private ConstantHolder() {
    }

    public static final ConstantHolder getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public ConstantListener getConstantListener() {
        return this.f38574a;
    }

    public void setConstantListener(ConstantListener constantListener) {
        this.f38574a = constantListener;
    }
}
