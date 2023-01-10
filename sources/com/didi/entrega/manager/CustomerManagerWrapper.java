package com.didi.entrega.manager;

import com.didi.entrega.manager.base.ICustomerManager;

public class CustomerManagerWrapper {

    /* renamed from: a */
    ICustomerManager f22678a;

    /* renamed from: b */
    ManagerState f22679b = ManagerState.INITIALIZE;

    enum ManagerState {
        INITIALIZE,
        CREATE,
        START,
        STOP,
        DESTROY
    }

    public CustomerManagerWrapper(ICustomerManager iCustomerManager) {
        this.f22678a = iCustomerManager;
    }

    public void create() {
        if (this.f22678a != null && this.f22679b == ManagerState.INITIALIZE) {
            this.f22678a.onCreate();
            this.f22679b = ManagerState.CREATE;
        }
    }

    public void destroy() {
        if (this.f22678a != null && this.f22679b != ManagerState.DESTROY) {
            this.f22678a.onDestroy();
            this.f22679b = ManagerState.DESTROY;
        }
    }

    public ICustomerManager getInnerManager() {
        return this.f22678a;
    }

    public void start() {
        if (this.f22678a == null) {
            return;
        }
        if (this.f22679b == ManagerState.CREATE || this.f22679b == ManagerState.STOP) {
            this.f22678a.onStart();
            this.f22679b = ManagerState.START;
        }
    }

    public void stop() {
        if (this.f22678a != null && this.f22679b == ManagerState.START) {
            this.f22678a.onStop();
            this.f22679b = ManagerState.STOP;
        }
    }
}
