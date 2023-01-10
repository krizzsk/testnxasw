package com.didi.entrega.customer.flutter;

import com.didi.flutter.nacho2.p116v2.NachoAction;

public final class FlutterEngineStore {

    /* renamed from: a */
    private static FlutterEngineStore f21744a;

    /* renamed from: b */
    private NachoAction f21745b;

    private FlutterEngineStore() {
    }

    public static FlutterEngineStore getInstance() {
        if (f21744a == null) {
            synchronized (FlutterEngineStore.class) {
                if (f21744a == null) {
                    f21744a = new FlutterEngineStore();
                }
            }
        }
        return f21744a;
    }

    public void setBizMainEngineAction(NachoAction nachoAction) {
        this.f21745b = nachoAction;
    }

    public NachoAction getBizMainEngineAction() {
        return this.f21745b;
    }
}
