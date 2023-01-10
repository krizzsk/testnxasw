package com.didi.soda.order.manager;

import android.text.TextUtils;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.soda.customer.biz.order.OrderLayoutLimitQueue;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.soda.customer.foundation.rpc.CustomerRpcService;
import com.didi.soda.customer.foundation.rpc.entity.OrderData;
import com.didi.soda.customer.foundation.rpc.entity.OrderLayoutEntity;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.repo.CustomerResource;
import com.didichuxing.foundation.rpc.Rpc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\b\u0000\u0018\u0000 22\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00020\u0001:\u00012B\u0005¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0015\u001a\u00020\u00162\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0002J\u0006\u0010\u0018\u001a\u00020\u0016J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001a\u001a\u00020\u0007J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u0007J\b\u0010\u001d\u001a\u00020\u0016H\u0002J\b\u0010\u001e\u001a\u00020\u0016H\u0014J\"\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0002J&\u0010&\u001a\u00020\u00162\b\u0010'\u001a\u0004\u0018\u00010\u00042\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0002J\u0010\u0010(\u001a\u00020\u00162\b\u0010$\u001a\u0004\u0018\u00010\fJ8\u0010)\u001a\u00020\u00002\b\u0010*\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010+\u001a\u00020,2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010-\u001a\u00020,H\u0002J.\u0010)\u001a\u00020\u00002\b\u0010*\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010+\u001a\u00020,2\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010-\u001a\u00020,H\u0002J\u0010\u0010.\u001a\u00020\u00162\b\u0010*\u001a\u0004\u0018\u00010\u0007J\"\u0010.\u001a\u00020\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u00072\u0006\u0010+\u001a\u00020,2\b\u0010$\u001a\u0004\u0018\u00010%J,\u0010/\u001a\u00020\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u00072\u0006\u0010+\u001a\u00020,2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%J\u000e\u00100\u001a\u00020\u00162\u0006\u0010-\u001a\u00020,J\u0010\u00101\u001a\u00020\u00162\b\u0010$\u001a\u0004\u0018\u00010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u00063"}, mo148868d2 = {"Lcom/didi/soda/order/manager/BatchOrderLayoutRepo;", "Lcom/didi/app/nova/skeleton/repo/Repo;", "Lcom/didi/soda/customer/repo/CustomerResource;", "", "Lcom/didi/soda/customer/foundation/rpc/entity/OrderLayoutEntity;", "()V", "allOrderIdsInQueue", "", "getAllOrderIdsInQueue", "()Ljava/lang/String;", "mBatchOrderLayoutListeners", "", "Lcom/didi/soda/order/manager/BatchOrderLayoutListener;", "mOrderQueue", "Lcom/didi/soda/customer/biz/order/OrderLayoutLimitQueue;", "mRpcService", "Lcom/didi/soda/customer/foundation/rpc/CustomerRpcService;", "getMRpcService", "()Lcom/didi/soda/customer/foundation/rpc/CustomerRpcService;", "setMRpcService", "(Lcom/didi/soda/customer/foundation/rpc/CustomerRpcService;)V", "addOrderEntity2Queue", "", "entityList", "clearAllInMonitor", "getOrderLayoutByPreId", "preOrderId", "getOrderLayoutsById", "orderId", "onChange", "onDestroy", "onTagOrderRpcFailure", "ex", "Lcom/didi/soda/customer/foundation/rpc/net/SFRpcException;", "tag", "Lcom/didi/app/nova/skeleton/ScopeContext;", "listener", "Lcom/didi/soda/order/manager/OnceOrderLayoutsListener;", "onTagOrderRpcSuccess", "entity", "registerBatchOrderLayoutsListener", "requestBatchOrders", "orderIds", "needEvaluateSchema", "", "scene", "requestOrderLayouts", "requestOrderLayoutsWithTag", "trackScene", "unregisterBatchOrderLayoutsListener", "Companion", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: BatchOrderLayoutRepo.kt */
public final class BatchOrderLayoutRepo extends Repo<CustomerResource<List<? extends OrderLayoutEntity>>> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: d */
    private static final String f46063d = "BatchOrderLayoutsRepo";

    /* renamed from: a */
    private CustomerRpcService f46064a;

    /* renamed from: b */
    private final OrderLayoutLimitQueue f46065b = new OrderLayoutLimitQueue();

    /* renamed from: c */
    private final List<BatchOrderLayoutListener> f46066c = new ArrayList();

    public BatchOrderLayoutRepo() {
        CustomerRpcService customerRpcService = CustomerRpcManagerProxy.get();
        Intrinsics.checkNotNullExpressionValue(customerRpcService, "get()");
        this.f46064a = customerRpcService;
    }

    public final CustomerRpcService getMRpcService() {
        return this.f46064a;
    }

    public final void setMRpcService(CustomerRpcService customerRpcService) {
        Intrinsics.checkNotNullParameter(customerRpcService, "<set-?>");
        this.f46064a = customerRpcService;
    }

    public final String getAllOrderIdsInQueue() {
        return this.f46065b.getOrderIds();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.f46066c.clear();
        this.f46065b.clear();
    }

    public final void registerBatchOrderLayoutsListener(BatchOrderLayoutListener batchOrderLayoutListener) {
        if (batchOrderLayoutListener != null && !this.f46066c.contains(batchOrderLayoutListener)) {
            this.f46066c.add(batchOrderLayoutListener);
        }
    }

    public final void unregisterBatchOrderLayoutsListener(BatchOrderLayoutListener batchOrderLayoutListener) {
        if (batchOrderLayoutListener != null) {
            this.f46066c.remove(batchOrderLayoutListener);
        }
    }

    public final void requestOrderLayouts(String str) {
        if (!TextUtils.isEmpty(str)) {
            m34216a(str, 0, (OnceOrderLayoutsListener) null, 4);
        }
    }

    public final void requestOrderLayoutsWithTag(String str, int i, ScopeContext scopeContext, OnceOrderLayoutsListener onceOrderLayoutsListener) {
        if (!TextUtils.isEmpty(str)) {
            m34215a(str, i, scopeContext, onceOrderLayoutsListener, 5);
        }
    }

    public final void requestOrderLayouts(String str, int i, OnceOrderLayoutsListener onceOrderLayoutsListener) {
        if (!TextUtils.isEmpty(str)) {
            m34216a(str, i, onceOrderLayoutsListener, 5);
        }
    }

    public final void clearAllInMonitor() {
        this.f46065b.clear();
    }

    public final OrderLayoutEntity getOrderLayoutsById(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f46065b.getOrderById(str);
    }

    public final OrderLayoutEntity getOrderLayoutByPreId(String str) {
        OrderData orderData;
        Intrinsics.checkNotNullParameter(str, "preOrderId");
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator iterator = this.f46065b.getIterator();
        Intrinsics.checkNotNullExpressionValue(iterator, "mOrderQueue.iterator");
        while (iterator.hasNext()) {
            OrderLayoutEntity orderLayoutEntity = (OrderLayoutEntity) ((Map.Entry) iterator.next()).getValue();
            if (orderLayoutEntity == null) {
                orderData = null;
            } else {
                orderData = orderLayoutEntity.getOrderData();
            }
            if (orderData != null && str.equals(orderLayoutEntity.getOrderData().getPreOrderId())) {
                return orderLayoutEntity;
            }
        }
        return null;
    }

    public final void trackScene(int i) {
        LogUtil.m32588i(f46063d, Intrinsics.stringPlus("trackScene:", Integer.valueOf(i)));
    }

    /* renamed from: a */
    static /* synthetic */ BatchOrderLayoutRepo m34213a(BatchOrderLayoutRepo batchOrderLayoutRepo, String str, int i, ScopeContext scopeContext, OnceOrderLayoutsListener onceOrderLayoutsListener, int i2, int i3, Object obj) {
        return batchOrderLayoutRepo.m34215a(str, (i3 & 2) != 0 ? 0 : i, scopeContext, onceOrderLayoutsListener, i2);
    }

    /* renamed from: a */
    private final BatchOrderLayoutRepo m34215a(String str, int i, ScopeContext scopeContext, OnceOrderLayoutsListener onceOrderLayoutsListener, int i2) {
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        LogUtil.m32588i(f46063d, Intrinsics.stringPlus("request orderIds:", str));
        Rpc orderLayoutBatch = this.f46064a.getOrderLayoutBatch(str, i, new BatchOrderLayoutRepo$requestBatchOrders$rpc$1(scopeContext, this, onceOrderLayoutsListener, i2));
        if (scopeContext != null) {
            autoRelease(scopeContext, orderLayoutBatch);
        }
        return this;
    }

    /* renamed from: a */
    static /* synthetic */ BatchOrderLayoutRepo m34214a(BatchOrderLayoutRepo batchOrderLayoutRepo, String str, int i, OnceOrderLayoutsListener onceOrderLayoutsListener, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        return batchOrderLayoutRepo.m34216a(str, i, onceOrderLayoutsListener, i2);
    }

    /* renamed from: a */
    private final BatchOrderLayoutRepo m34216a(String str, int i, OnceOrderLayoutsListener onceOrderLayoutsListener, int i2) {
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        LogUtil.m32588i(f46063d, Intrinsics.stringPlus("request orderIds:", str));
        this.f46064a.getOrderLayoutBatch(str, i, new BatchOrderLayoutRepo$requestBatchOrders$2(onceOrderLayoutsListener, this, i2));
        return this;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m34219a(SFRpcException sFRpcException, ScopeContext scopeContext, OnceOrderLayoutsListener onceOrderLayoutsListener) {
        if (!scopeContext.getLiveHandler().isDestroyed()) {
            m34220a((List<OrderLayoutEntity>) null);
            if (onceOrderLayoutsListener != null) {
                onceOrderLayoutsListener.onOnceOrderListener((OrderLayoutEntity) null, sFRpcException.getCode());
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m34218a(OrderLayoutEntity orderLayoutEntity, ScopeContext scopeContext, OnceOrderLayoutsListener onceOrderLayoutsListener) {
        if (scopeContext != null && !scopeContext.getLiveHandler().isDestroyed()) {
            if (orderLayoutEntity == null) {
                m34220a((List<OrderLayoutEntity>) null);
            }
            if (onceOrderLayoutsListener != null) {
                onceOrderLayoutsListener.onOnceOrderListener(orderLayoutEntity, 0);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m34220a(List<OrderLayoutEntity> list) {
        LogUtil.m32588i(f46063d, Intrinsics.stringPlus("addOrderEntitys:", list));
        if (!CollectionsUtil.isEmpty(list)) {
            Intrinsics.checkNotNull(list);
            for (OrderLayoutEntity add : list) {
                this.f46065b.add(add);
            }
        }
        m34217a();
    }

    /* renamed from: a */
    private final void m34217a() {
        List list = this.f46065b.getList();
        for (BatchOrderLayoutListener onBatchOrderLayout : this.f46066c) {
            onBatchOrderLayout.onBatchOrderLayout(list);
        }
        synchronized (this.f46065b) {
            this.f46065b.resort();
            List list2 = this.f46065b.getList();
            setValue(CustomerResource.change(list2));
            LogUtil.m32588i(f46063d, Intrinsics.stringPlus("onChange =", list2));
            Unit unit = Unit.INSTANCE;
        }
    }

    @Metadata(mo148867d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo148868d2 = {"Lcom/didi/soda/order/manager/BatchOrderLayoutRepo$Companion;", "", "()V", "TAG", "", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: BatchOrderLayoutRepo.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
