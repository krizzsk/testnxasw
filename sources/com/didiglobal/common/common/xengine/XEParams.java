package com.didiglobal.common.common.xengine;

public class XEParams {

    /* renamed from: a */
    private static volatile XEParams f52308a;

    /* renamed from: b */
    private int f52309b = 0;

    /* renamed from: c */
    private int f52310c = 0;

    private XEParams() {
    }

    public static XEParams getInstance() {
        if (f52308a == null) {
            synchronized (XEParams.class) {
                if (f52308a == null) {
                    f52308a = new XEParams();
                }
            }
        }
        return f52308a;
    }

    public int getLastOrderSubStatus() {
        return this.f52310c;
    }

    public void setLastOrderSubStatus(int i) {
        this.f52310c = i;
    }

    public int getLastOrderStatus() {
        return this.f52309b;
    }

    public void setLastOrderStatus(int i) {
        this.f52309b = i;
    }
}
