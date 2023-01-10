package com.didi.entrega.order.manager;

import android.text.TextUtils;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.entrega.customer.foundation.rpc.entity.order.OrderInfoEntity;
import com.didi.entrega.customer.repo.CustomerResource;
import com.didi.entrega.customer.repo.RepoFactory;
import com.didi.entrega.manager.base.ICustomerOrderManager;
import java.util.List;

public class CustomerOrderManager implements ICustomerOrderManager {
    public void onCreate() {
    }

    public void onDestroy() {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public String getManagerName() {
        return CustomerOrderManager.class.getName();
    }

    public void requestOrderInfoById(ScopeContext scopeContext, String str, int i, OnceOrderListener onceOrderListener) {
        if (!TextUtils.isEmpty(str)) {
            ((C8800a) RepoFactory.getRepo(C8800a.class)).mo67420a(scopeContext, str, i, onceOrderListener);
        }
    }

    public void requestOrderInfoById(String str, int i, OnceOrderListener onceOrderListener) {
        if (!TextUtils.isEmpty(str)) {
            ((C8800a) RepoFactory.getRepo(C8800a.class)).mo67422a(str, i, onceOrderListener);
        }
    }

    public void requestOrderInfoById(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            ((C8800a) RepoFactory.getRepo(C8800a.class)).mo67422a(str, i, (OnceOrderListener) null);
        }
    }

    public void updateAllOrdersInMonitor() {
        ((C8800a) RepoFactory.getRepo(C8800a.class)).mo67422a(((C8800a) RepoFactory.getRepo(C8800a.class)).mo67424b(), 4, (OnceOrderListener) null);
    }

    public void clearAllOrdersInMonitor() {
        ((C8800a) RepoFactory.getRepo(C8800a.class)).mo67418a();
    }

    public OrderInfoEntity getOrderInfoById(String str) {
        return ((C8800a) RepoFactory.getRepo(C8800a.class)).mo67417a(str);
    }

    public void subscribe(ScopeContext scopeContext, Action1<CustomerResource<List<OrderInfoEntity>>> action1) {
        if (scopeContext != null) {
            ((C8800a) RepoFactory.getRepo(C8800a.class)).subscribe(scopeContext, action1);
        }
    }

    public void registerBatchOrderListener(BatchOrderListener batchOrderListener) {
        if (batchOrderListener != null) {
            ((C8800a) RepoFactory.getRepo(C8800a.class)).mo67421a(batchOrderListener);
        }
    }

    public void unregisterBatchOrderListener(BatchOrderListener batchOrderListener) {
        if (batchOrderListener != null) {
            ((C8800a) RepoFactory.getRepo(C8800a.class)).mo67425b(batchOrderListener);
        }
    }
}
