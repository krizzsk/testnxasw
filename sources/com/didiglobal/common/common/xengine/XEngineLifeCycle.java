package com.didiglobal.common.common.xengine;

public class XEngineLifeCycle {

    /* renamed from: a */
    private static volatile XEngineLifeCycle f52313a;

    /* renamed from: b */
    private boolean f52314b;

    private XEngineLifeCycle() {
    }

    public static XEngineLifeCycle getInstance() {
        if (f52313a == null) {
            synchronized (XEngineLifeCycle.class) {
                if (f52313a == null) {
                    f52313a = new XEngineLifeCycle();
                }
            }
        }
        return f52313a;
    }

    public boolean isServiceEngineActive() {
        return this.f52314b;
    }

    public void setServiceEngineActive(boolean z) {
        this.f52314b = z;
    }
}
