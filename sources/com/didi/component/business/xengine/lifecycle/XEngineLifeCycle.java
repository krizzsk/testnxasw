package com.didi.component.business.xengine.lifecycle;

public class XEngineLifeCycle {

    /* renamed from: a */
    private static volatile XEngineLifeCycle f13248a;

    /* renamed from: b */
    private boolean f13249b;

    private XEngineLifeCycle() {
    }

    public static XEngineLifeCycle getInstance() {
        if (f13248a == null) {
            synchronized (XEngineLifeCycle.class) {
                if (f13248a == null) {
                    f13248a = new XEngineLifeCycle();
                }
            }
        }
        return f13248a;
    }

    public boolean isServiceEngineActive() {
        return this.f13249b;
    }

    public void setServiceEngineActive(boolean z) {
        this.f13249b = z;
    }
}
