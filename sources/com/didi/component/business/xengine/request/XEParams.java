package com.didi.component.business.xengine.request;

public class XEParams {

    /* renamed from: a */
    private static volatile XEParams f13250a;

    /* renamed from: b */
    private int f13251b = 0;

    /* renamed from: c */
    private int f13252c = 0;

    private XEParams() {
    }

    public static XEParams getInstance() {
        if (f13250a == null) {
            synchronized (XEParams.class) {
                if (f13250a == null) {
                    f13250a = new XEParams();
                }
            }
        }
        return f13250a;
    }

    public int getLastOrderSubStatus() {
        return this.f13252c;
    }

    public void setLastOrderSubStatus(int i) {
        this.f13252c = i;
    }

    public int getLastOrderStatus() {
        return this.f13251b;
    }

    public void setLastOrderStatus(int i) {
        this.f13251b = i;
    }
}
