package com.didi.soda.order.manager;

import android.text.TextUtils;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.soda.customer.biz.order.OrderLimitQueue;
import com.didi.soda.customer.biz.order.OrderMixService;
import com.didi.soda.customer.foundation.log.RecordTracker;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.soda.customer.foundation.rpc.CustomerRpcService;
import com.didi.soda.customer.foundation.rpc.entity.OrderInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.OrderListEntity;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.repo.CustomerResource;
import com.didi.soda.customer.repo.RepoFactory;
import com.didichuxing.foundation.rpc.Rpc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.didi.soda.order.manager.a */
/* compiled from: BatchOrderRepo */
class C14915a extends Repo<CustomerResource<List<OrderInfoEntity>>> {

    /* renamed from: b */
    private static final String f46067b = "BatchOrderRepo";

    /* renamed from: a */
    public CustomerRpcService f46068a = CustomerRpcManagerProxy.get();

    /* renamed from: c */
    private OrderLimitQueue f46069c = new OrderLimitQueue();

    /* renamed from: d */
    private ArrayList<String> f46070d = new ArrayList<>();

    /* renamed from: e */
    private List<BatchOrderListener> f46071e = new ArrayList();

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.f46070d.clear();
        this.f46071e.clear();
        this.f46069c.clear();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo115005a(BatchOrderListener batchOrderListener) {
        if (!this.f46071e.contains(batchOrderListener)) {
            this.f46071e.add(batchOrderListener);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo115012b(BatchOrderListener batchOrderListener) {
        this.f46071e.remove(batchOrderListener);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo115007a(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            mo115006a(str);
            m34222a(str, (ScopeContext) null, (OnceOrderListener) null, i);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo115008a(String str, ScopeContext scopeContext, OnceOrderListener onceOrderListener) {
        if (!TextUtils.isEmpty(str)) {
            m34222a(str, scopeContext, onceOrderListener, 5);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo115006a(String str) {
        String[] split;
        if (str != null && !TextUtils.isEmpty(str) && (split = str.replace(" ", "").split(",")) != null && split.length != 0) {
            for (String str2 : split) {
                if (!this.f46070d.contains(str2)) {
                    this.f46070d.add(str2);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo115004a(OrderInfoEntity orderInfoEntity, int i) {
        if (i == 3) {
            m34232b(orderInfoEntity);
        }
        mo115003a(i);
        m34233b(orderInfoEntity, i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo115009a(List<OrderInfoEntity> list, int i) {
        mo115003a(i);
        m34234b(list, i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo115002a() {
        this.f46070d.clear();
        this.f46069c.clear();
        OrderMixService.getInstance().reset();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public OrderInfoEntity mo115010b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f46069c.getOrderById(str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public OrderInfoEntity mo115013c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator iterator = this.f46069c.getIterator();
        while (iterator.hasNext()) {
            OrderInfoEntity orderInfoEntity = (OrderInfoEntity) ((Map.Entry) iterator.next()).getValue();
            if (orderInfoEntity != null && str.equals(orderInfoEntity.preOrderId)) {
                return orderInfoEntity;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo115011b() {
        return this.f46069c.getOrderIds(this.f46070d);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo115003a(int i) {
        LogUtil.m32588i(f46067b, "trackScene:" + i);
    }

    /* renamed from: a */
    private C14915a m34222a(String str, ScopeContext scopeContext, OnceOrderListener onceOrderListener, int i) {
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        LogUtil.m32588i(f46067b, "request orderIds:" + str);
        Rpc orderDetailBatch = this.f46068a.getOrderDetailBatch(str, new BatchOrderRepo$1(this, scopeContext, onceOrderListener, i));
        if (scopeContext != null) {
            autoRelease(scopeContext, orderDetailBatch);
        }
        return this;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m34226a(SFRpcException sFRpcException, ScopeContext scopeContext, OnceOrderListener onceOrderListener, int i) {
        if (!scopeContext.getLiveHandler().isDestroyed()) {
            m34235c();
            m34234b((List<OrderInfoEntity>) null, i);
            if (onceOrderListener != null) {
                onceOrderListener.onOnceOrderListener((OrderInfoEntity) null, sFRpcException.getCode());
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m34225a(OrderListEntity orderListEntity, OrderInfoEntity orderInfoEntity, ScopeContext scopeContext, OnceOrderListener onceOrderListener, int i) {
        if (scopeContext != null && !scopeContext.getLiveHandler().isDestroyed()) {
            m34224a(orderListEntity);
            if (orderInfoEntity == null) {
                m34234b((List<OrderInfoEntity>) null, i);
            }
            if (onceOrderListener != null) {
                onceOrderListener.onOnceOrderListener(orderInfoEntity, 0);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m34223a(OrderInfoEntity orderInfoEntity) {
        if (orderInfoEntity != null && orderInfoEntity.orderId != null) {
            this.f46070d.remove(orderInfoEntity.orderId);
        }
    }

    /* renamed from: b */
    private void m34233b(OrderInfoEntity orderInfoEntity, int i) {
        if (orderInfoEntity != null) {
            LogUtil.m32588i(f46067b, "addOrderEntity:" + orderInfoEntity);
            this.f46069c.add(orderInfoEntity);
            m34231b(i);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m34234b(List<OrderInfoEntity> list, int i) {
        LogUtil.m32588i(f46067b, "addOrderEntitys:" + list);
        if (!CollectionsUtil.isEmpty(list)) {
            for (OrderInfoEntity add : list) {
                this.f46069c.add(add);
            }
        }
        m34231b(i);
    }

    /* renamed from: b */
    private void m34231b(int i) {
        List list = this.f46069c.getList();
        for (BatchOrderListener onBatchOrderListener : this.f46071e) {
            onBatchOrderListener.onBatchOrderListener(list);
        }
        if (!(i == 1 || i == 5)) {
            ((BatchOrderLayoutRepo) RepoFactory.getRepo(BatchOrderLayoutRepo.class)).requestOrderLayouts(mo115011b());
        }
        synchronized (this.f46069c) {
            this.f46069c.resort();
            List list2 = this.f46069c.getList();
            setValue(CustomerResource.change(list2));
            LogUtil.m32588i(f46067b, "onChange =" + list2);
        }
    }

    /* renamed from: c */
    private void m34235c() {
        RecordTracker.Builder.create().setLogModule("m-odr|").setLogCategory("c-data|").setTag(f46067b).setMessage("requestOrderInfoById-->onRpcFailure").build().info();
    }

    /* renamed from: a */
    private void m34224a(OrderListEntity orderListEntity) {
        RecordTracker.Builder.create().setLogModule("m-odr|").setLogCategory("c-data|").setTag(f46067b).setMessage("requestOrderInfoById-->onRpcSuccess").setOtherParam("data", orderListEntity.toString()).build().info();
    }

    /* renamed from: b */
    private void m34232b(OrderInfoEntity orderInfoEntity) {
        RecordTracker.Builder tag = RecordTracker.Builder.create().setLogModule("m-odr|").setLogCategory("c-data|").setTag(f46067b);
        tag.setMessage("updatePushOrderData" + orderInfoEntity.orderId + "order status" + orderInfoEntity.status).build().info();
    }
}
