package com.didi.soda.customer.timemachine;

import java.util.List;

public final class TimeMachineEngine {

    /* renamed from: a */
    private CustomerTimeMachineConfig f44002a;

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
        this.f44002a = customerTimeMachineConfig;
    }

    public List<String> getTraceDomainList() {
        if (checkEngineAvailable()) {
            return this.f44002a.traceDomainList();
        }
        return null;
    }

    public String getPageName() {
        if (checkEngineAvailable()) {
            return this.f44002a.getCurrentPage();
        }
        return null;
    }

    public boolean checkEngineAvailable() {
        return this.f44002a != null;
    }
}
