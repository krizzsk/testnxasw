package com.didi.travel.psnger.core.order;

import com.didi.travel.psnger.core.listener.IDiDiCoreCallback;
import com.didi.travel.psnger.core.listener.IDiDiMatchInfoCallback;

public abstract class AbsOrderService implements OrderService {

    /* renamed from: a */
    private OrderPollingManager f46836a;

    /* renamed from: b */
    private OrderPushManager f46837b;

    /* access modifiers changed from: protected */
    public abstract long pollingIntervalMills();

    public void setMatchInfoCallback(IDiDiMatchInfoCallback iDiDiMatchInfoCallback) {
    }

    public AbsOrderService() {
        init();
    }

    /* access modifiers changed from: protected */
    public void init() {
        if (this.f46836a == null) {
            this.f46836a = createPollingManager();
        }
        if (this.f46837b == null) {
            this.f46837b = new OrderPushManager();
        }
    }

    /* access modifiers changed from: protected */
    public OrderPollingManager createPollingManager() {
        return new OrderPollingManager(this);
    }

    public void addOrderServiceCallback(IDiDiCoreCallback iDiDiCoreCallback) {
        OrderPollingManager orderPollingManager = this.f46836a;
        if (orderPollingManager != null) {
            orderPollingManager.addCoreCallback(iDiDiCoreCallback);
        }
    }

    public void addOrderPushCallback(IDiDiCoreCallback iDiDiCoreCallback) {
        OrderPushManager orderPushManager = this.f46837b;
        if (orderPushManager != null) {
            orderPushManager.addCoreCallback(iDiDiCoreCallback);
        }
    }

    public void removeOrderServiceCallback(IDiDiCoreCallback iDiDiCoreCallback) {
        OrderPollingManager orderPollingManager = this.f46836a;
        if (orderPollingManager != null) {
            orderPollingManager.removeCoreCallback(iDiDiCoreCallback);
        }
    }

    public void removeOrderPushCallback(IDiDiCoreCallback iDiDiCoreCallback) {
        OrderPushManager orderPushManager = this.f46837b;
        if (orderPushManager != null) {
            orderPushManager.removeCoreCallback(iDiDiCoreCallback);
        }
    }

    public void startOrderService(boolean z) {
        OrderPollingManager orderPollingManager = this.f46836a;
        if (orderPollingManager != null) {
            orderPollingManager.start(z, pollingIntervalMills());
        }
    }

    public void stopOrderService() {
        OrderPollingManager orderPollingManager = this.f46836a;
        if (orderPollingManager != null) {
            orderPollingManager.stopOrderStatusPoll();
        }
    }

    public void registerPush() {
        OrderPollingManager orderPollingManager = this.f46836a;
        if (orderPollingManager != null) {
            orderPollingManager.registerOrderStatusPush();
        }
        OrderPushManager orderPushManager = this.f46837b;
        if (orderPushManager != null) {
            orderPushManager.registerPushListener();
        }
    }

    public void unregisterPush() {
        OrderPushManager orderPushManager = this.f46837b;
        if (orderPushManager != null) {
            orderPushManager.unregisterPushListener();
        }
        OrderPollingManager orderPollingManager = this.f46836a;
        if (orderPollingManager != null) {
            orderPollingManager.unregisterOrderStatusPush();
        }
    }

    public OrderPollingManager getOrderPollingManager() {
        return this.f46836a;
    }
}
