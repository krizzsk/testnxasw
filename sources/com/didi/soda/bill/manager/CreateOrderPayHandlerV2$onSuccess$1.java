package com.didi.soda.bill.manager;

import com.didi.soda.bill.BillEventToJS;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import com.didi.soda.customer.foundation.rpc.entity.OrderInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.OrderLayoutEntity;
import com.didi.soda.order.manager.OnceOrderLayoutsListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, mo148868d2 = {"com/didi/soda/bill/manager/CreateOrderPayHandlerV2$onSuccess$1", "Lcom/didi/soda/order/manager/OnceOrderLayoutsListener;", "onOnceOrderListener", "", "entity", "Lcom/didi/soda/customer/foundation/rpc/entity/OrderLayoutEntity;", "code", "", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: CreateOrderPayHandlerV2.kt */
public final class CreateOrderPayHandlerV2$onSuccess$1 implements OnceOrderLayoutsListener {
    final /* synthetic */ OrderInfoEntity $order;
    final /* synthetic */ CreateOrderPayHandlerV2 this$0;

    CreateOrderPayHandlerV2$onSuccess$1(OrderInfoEntity orderInfoEntity, CreateOrderPayHandlerV2 createOrderPayHandlerV2) {
        this.$order = orderInfoEntity;
        this.this$0 = createOrderPayHandlerV2;
    }

    public void onOnceOrderListener(OrderLayoutEntity orderLayoutEntity, int i) {
        LogUtil.m32588i(CreateOrderPayHandler.TAG, Intrinsics.stringPlus("paySuccess -> orderId: ", this.$order.orderId));
        CreateOrderPayHandlerV2 createOrderPayHandlerV2 = this.this$0;
        String str = this.$order.shopId;
        Intrinsics.checkNotNullExpressionValue(str, "order.shopId");
        String str2 = this.$order.orderId;
        Intrinsics.checkNotNullExpressionValue(str2, "order.orderId");
        createOrderPayHandlerV2.m31419a(str, str2);
        BillEventToJS.triggerEvent$default(BillEventToJS.INSTANCE, 6, (Integer) null, (String) null, (IEntity) null, 14, (Object) null);
        CreateOrderPayHandlerV2 createOrderPayHandlerV22 = this.this$0;
        String str3 = this.$order.orderId;
        Intrinsics.checkNotNullExpressionValue(str3, "order.orderId");
        CreateOrderPayHandlerV2.m31414a(createOrderPayHandlerV22, str3, false, 2, (Object) null);
        this.this$0.getMScopeContext().getNavigator().finish();
    }
}
