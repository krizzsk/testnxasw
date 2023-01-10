package com.didi.entrega.order.manager;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.rpc.entity.order.OrderInfoEntity;
import com.didi.entrega.customer.foundation.rpc.entity.order.OrderListEntity;
import com.didi.entrega.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.entrega.customer.foundation.rpc.net.SFRpcException;
import com.didi.entrega.customer.foundation.util.CollectionsUtil;
import com.didi.entrega.order.omega.OrderOmegaHelper;

class BatchOrderRepo$1 extends CustomerRpcCallback<OrderListEntity> {
    final /* synthetic */ C8800a this$0;
    final /* synthetic */ OnceOrderListener val$listener;
    final /* synthetic */ int val$scene;
    final /* synthetic */ ScopeContext val$tag;

    BatchOrderRepo$1(C8800a aVar, ScopeContext scopeContext, OnceOrderListener onceOrderListener, int i) {
        this.this$0 = aVar;
        this.val$tag = scopeContext;
        this.val$listener = onceOrderListener;
        this.val$scene = i;
    }

    public void onRpcFailure(SFRpcException sFRpcException) {
        if (this.val$tag != null) {
            super.onRpcFailure(sFRpcException);
            this.this$0.m18723a(sFRpcException, this.val$tag, this.val$listener);
        }
        LogUtil.m18185i("EntregaBatchOrderRepo", "requestBatchOrders request orderIds: onRpcFailure");
        OrderOmegaHelper.INSTANCE.orderRequestError(Integer.valueOf(sFRpcException.getCode()), sFRpcException.getMessage());
    }

    public void onRpcSuccess(OrderListEntity orderListEntity, long j) {
        OrderInfoEntity orderInfoEntity;
        if (orderListEntity == null || CollectionsUtil.isEmpty(orderListEntity.mOrderDetailEntityList)) {
            orderInfoEntity = null;
        } else {
            orderInfoEntity = orderListEntity.mOrderDetailEntityList.get(0);
            this.this$0.mo67419a(this.val$scene);
            this.this$0.m18727a(orderListEntity.mOrderDetailEntityList);
        }
        this.this$0.m18722a(orderListEntity, orderInfoEntity, this.val$tag, this.val$listener);
    }
}
