package com.didi.entrega.order.manager;

import android.text.TextUtils;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.entrega.customer.app.constant.Const;
import com.didi.entrega.customer.foundation.log.RecordTracker;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.entrega.customer.foundation.rpc.CustomerRpcService;
import com.didi.entrega.customer.foundation.rpc.entity.order.OrderData;
import com.didi.entrega.customer.foundation.rpc.entity.order.OrderInfoEntity;
import com.didi.entrega.customer.foundation.rpc.entity.order.OrderListEntity;
import com.didi.entrega.customer.foundation.rpc.net.SFRpcException;
import com.didi.entrega.customer.foundation.util.CollectionsUtil;
import com.didi.entrega.customer.repo.CustomerResource;
import com.didi.entrega.order.pool.OrderLimitQueue;
import com.didi.entrega.order.pool.OrderMixService;
import com.didichuxing.foundation.rpc.Rpc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.didi.entrega.order.manager.a */
/* compiled from: BatchOrderRepo */
class C8800a extends Repo<CustomerResource<List<OrderInfoEntity>>> {

    /* renamed from: b */
    private static final String f22745b = "EntregaBatchOrderRepo";

    /* renamed from: a */
    public CustomerRpcService f22746a = CustomerRpcManagerProxy.get();

    /* renamed from: c */
    private final OrderLimitQueue f22747c = new OrderLimitQueue();

    /* renamed from: d */
    private final List<BatchOrderListener> f22748d = new ArrayList();

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.f22748d.clear();
        this.f22747c.clear();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo67421a(BatchOrderListener batchOrderListener) {
        if (!this.f22748d.contains(batchOrderListener)) {
            this.f22748d.add(batchOrderListener);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo67425b(BatchOrderListener batchOrderListener) {
        this.f22748d.remove(batchOrderListener);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo67422a(String str, int i, OnceOrderListener onceOrderListener) {
        if (!TextUtils.isEmpty(str)) {
            mo67419a(i);
            m18719a(str, (ScopeContext) null, onceOrderListener, i);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo67420a(ScopeContext scopeContext, String str, int i, OnceOrderListener onceOrderListener) {
        if (!TextUtils.isEmpty(str)) {
            mo67419a(i);
            m18719a(str, scopeContext, onceOrderListener, i);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo67418a() {
        this.f22747c.clear();
        OrderMixService.getInstance().reset();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public OrderInfoEntity mo67417a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f22747c.getOrderById(str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public OrderInfoEntity mo67423b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator iterator = this.f22747c.getIterator();
        while (iterator.hasNext()) {
            OrderInfoEntity orderInfoEntity = (OrderInfoEntity) ((Map.Entry) iterator.next()).getValue();
            if (orderInfoEntity != null && orderInfoEntity.getOrderData() != null && str.equals(orderInfoEntity.getOrderData().getPreOrderId())) {
                return orderInfoEntity;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo67424b() {
        return this.f22747c.getOrderIds();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo67419a(int i) {
        LogUtil.m18185i(f22745b, "trackScene:" + i);
    }

    /* renamed from: a */
    private C8800a m18719a(String str, ScopeContext scopeContext, OnceOrderListener onceOrderListener, int i) {
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        LogUtil.m18185i(f22745b, "request orderIds:" + str);
        Rpc orderDetailBatch = this.f22746a.getOrderDetailBatch(str, new BatchOrderRepo$1(this, scopeContext, onceOrderListener, i));
        if (scopeContext != null) {
            autoRelease(scopeContext, orderDetailBatch);
        }
        return this;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m18723a(SFRpcException sFRpcException, ScopeContext scopeContext, OnceOrderListener onceOrderListener) {
        if (!scopeContext.getLiveHandler().isDestroyed()) {
            m18731d();
            m18727a((List<OrderInfoEntity>) null);
            if (onceOrderListener != null) {
                onceOrderListener.onOnceOrderListener((OrderInfoEntity) null, sFRpcException.getCode());
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m18722a(OrderListEntity orderListEntity, OrderInfoEntity orderInfoEntity, ScopeContext scopeContext, OnceOrderListener onceOrderListener) {
        if (scopeContext != null && !scopeContext.getLiveHandler().isDestroyed()) {
            m18721a(orderListEntity);
            if (orderInfoEntity == null) {
                m18727a((List<OrderInfoEntity>) null);
            }
            if (onceOrderListener != null) {
                onceOrderListener.onOnceOrderListener(orderInfoEntity, 0);
            }
        }
    }

    /* renamed from: a */
    private void m18720a(OrderInfoEntity orderInfoEntity) {
        if (orderInfoEntity != null) {
            LogUtil.m18185i(f22745b, "addOrderEntity:" + orderInfoEntity);
            this.f22747c.add(orderInfoEntity);
            m18730c();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m18727a(List<OrderInfoEntity> list) {
        LogUtil.m18185i(f22745b, "addOrderEntitys:" + list);
        if (!CollectionsUtil.isEmpty(list)) {
            for (OrderInfoEntity add : list) {
                this.f22747c.add(add);
            }
        }
        m18730c();
    }

    /* renamed from: c */
    private void m18730c() {
        List list = this.f22747c.getList();
        for (BatchOrderListener onBatchOrderListener : this.f22748d) {
            onBatchOrderListener.onBatchOrderListener(list);
        }
        synchronized (this.f22747c) {
            this.f22747c.onChange();
            List list2 = this.f22747c.getList();
            if (m18728a((List<OrderInfoEntity>) list, (List<OrderInfoEntity>) list2)) {
                setValue(CustomerResource.change(list2));
            }
            LogUtil.m18185i(f22745b, "onChange =" + list2);
        }
    }

    /* renamed from: a */
    private boolean m18728a(List<OrderInfoEntity> list, List<OrderInfoEntity> list2) {
        if (list.size() != list2.size()) {
            return true;
        }
        Iterator<OrderInfoEntity> it = list2.iterator();
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                return false;
            }
            OrderData orderData = it.next().getOrderData();
            if (orderData != null && !TextUtils.isEmpty(orderData.getOrderId())) {
                String orderId = orderData.getOrderId();
                int status = orderData.getStatus();
                for (OrderInfoEntity orderData2 : list) {
                    OrderData orderData3 = orderData2.getOrderData();
                    if (orderData3 != null && !TextUtils.isEmpty(orderData3.getOrderId())) {
                        String orderId2 = orderData3.getOrderId();
                        int status2 = orderData3.getStatus();
                        if (orderId != null && orderId.equals(orderId2)) {
                            if (status2 < 1800 && status >= 1800) {
                                return true;
                            }
                            z = true;
                        }
                    }
                }
                if (!z) {
                    return true;
                }
            }
        }
    }

    /* renamed from: d */
    private void m18731d() {
        RecordTracker.Builder.create().setLogModule("m-odr|").setLogCategory("c-data|").setTag(f22745b).setMessage("requestOrderInfoById-->onRpcFailure").build().info();
    }

    /* renamed from: a */
    private void m18721a(OrderListEntity orderListEntity) {
        RecordTracker.Builder.create().setLogModule("m-odr|").setLogCategory("c-data|").setTag(f22745b).setMessage("requestOrderInfoById-->onRpcSuccess").setOtherParam("data", orderListEntity.toString()).build().info();
    }

    /* renamed from: b */
    private void m18729b(OrderInfoEntity orderInfoEntity) {
        int i;
        String str;
        if (orderInfoEntity == null || orderInfoEntity.getOrderData() == null) {
            str = null;
            i = Const.OrderStatus.DEFAULT;
        } else {
            str = orderInfoEntity.getOrderData().getOrderId();
            i = orderInfoEntity.getOrderData().getStatus();
        }
        RecordTracker.Builder tag = RecordTracker.Builder.create().setLogModule("m-odr|").setLogCategory("c-data|").setTag(f22745b);
        tag.setMessage("updatePushOrderData" + str + "order status" + i).build().info();
    }
}
