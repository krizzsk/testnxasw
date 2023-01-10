package com.didi.entrega.customer.timemachine;

import java.util.List;

public final class TimeMachineEngine {

    /* renamed from: a */
    private CustomerTimeMachineConfig f22091a;

    private static final class Holder {
        /* access modifiers changed from: private */
        public static final TimeMachineEngine INSTANCE = new TimeMachineEngine();

        private Holder() {
        }
    }

    private TimeMachineEngine() {
    }

    public static TimeMachineEngine getInstance() {
        return Holder.INSTANCE;
    }

    public void init(CustomerTimeMachineConfig customerTimeMachineConfig) {
        this.f22091a = customerTimeMachineConfig;
    }

    public List<String> getTraceDomainList() {
        if (checkEngineAvailable()) {
            return this.f22091a.traceDomainList();
        }
        return null;
    }

    public String getPageName() {
        if (checkEngineAvailable()) {
            return this.f22091a.getCurrentPage();
        }
        return null;
    }

    public boolean checkEngineAvailable() {
        return this.f22091a != null;
    }
}
