package com.didi.soda.customer.flutter;

import com.didi.flutter.nacho2.p116v2.NachoAction;

public class CustomerFlutterEngineManager {

    /* renamed from: a */
    private static CustomerFlutterEngineManager f43477a;

    /* renamed from: b */
    private NachoAction f43478b;

    private CustomerFlutterEngineManager() {
    }

    public static CustomerFlutterEngineManager getInstance() {
        if (f43477a == null) {
            synchronized (CustomerFlutterEngineManager.class) {
                if (f43477a == null) {
                    f43477a = new CustomerFlutterEngineManager();
                }
            }
        }
        return f43477a;
    }

    public void setBizFoodEngineAction(NachoAction nachoAction) {
        this.f43478b = nachoAction;
    }

    public NachoAction getBizFoodEngineAction() {
        return this.f43478b;
    }
}
