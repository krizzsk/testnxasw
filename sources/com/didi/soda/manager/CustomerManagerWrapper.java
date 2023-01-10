package com.didi.soda.manager;

import com.didi.soda.manager.base.ICustomerManager;

public class CustomerManagerWrapper {

    /* renamed from: a */
    ICustomerManager f45911a;

    /* renamed from: b */
    ManagerState f45912b = ManagerState.INITIALIZE;

    enum ManagerState {
        INITIALIZE,
        CREATE,
        START,
        STOP,
        DESTROY
    }

    public CustomerManagerWrapper(ICustomerManager iCustomerManager) {
        this.f45911a = iCustomerManager;
    }

    public void create() {
        if (this.f45911a != null && this.f45912b == ManagerState.INITIALIZE) {
            this.f45911a.onCreate();
            this.f45912b = ManagerState.CREATE;
        }
    }

    public void destroy() {
        if (this.f45911a != null && this.f45912b != ManagerState.DESTROY) {
            this.f45911a.onDestroy();
            this.f45912b = ManagerState.DESTROY;
        }
    }

    public ICustomerManager getInnerManager() {
        return this.f45911a;
    }

    public void start() {
        if (this.f45911a == null) {
            return;
        }
        if (this.f45912b == ManagerState.CREATE || this.f45912b == ManagerState.STOP) {
            this.f45911a.onStart();
            this.f45912b = ManagerState.START;
        }
    }

    public void stop() {
        if (this.f45911a != null && this.f45912b == ManagerState.START) {
            this.f45911a.onStop();
            this.f45912b = ManagerState.STOP;
        }
    }
}
