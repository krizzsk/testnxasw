package com.didi.entrega.order.contact;

import com.didi.entrega.customer.foundation.rpc.entity.order.OrderInfoEntity;
import com.didi.entrega.customer.foundation.rpc.entity.order.OrderListEntity;
import com.didi.entrega.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.entrega.customer.foundation.rpc.net.SFRpcException;
import com.didi.entrega.customer.foundation.util.DialogUtil;
import com.didi.entrega.order.contact.IMContactModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(mo148867d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, mo148868d2 = {"com/didi/entrega/order/contact/OrderContactUtil$Companion$requestOrderInfoById$rpc$1", "Lcom/didi/entrega/customer/foundation/rpc/net/CustomerRpcCallback;", "Lcom/didi/entrega/customer/foundation/rpc/entity/order/OrderListEntity;", "onRpcFailure", "", "ex", "Lcom/didi/entrega/customer/foundation/rpc/net/SFRpcException;", "onRpcSuccess", "orderListEntity", "code", "", "entrega-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: OrderContactUtil.kt */
public final class OrderContactUtil$Companion$requestOrderInfoById$rpc$1 extends CustomerRpcCallback<OrderListEntity> {
    final /* synthetic */ Function1<IMContactModel, Unit> $action;

    OrderContactUtil$Companion$requestOrderInfoById$rpc$1(Function1<? super IMContactModel, Unit> function1) {
        this.$action = function1;
    }

    public void onRpcSuccess(OrderListEntity orderListEntity, long j) {
        List<OrderInfoEntity> list;
        DialogUtil.hideLoadingDialog();
        Function1<IMContactModel, Unit> function1 = this.$action;
        IMContactModel.Companion companion = IMContactModel.Companion;
        OrderInfoEntity orderInfoEntity = null;
        if (!(orderListEntity == null || (list = orderListEntity.mOrderDetailEntityList) == null)) {
            orderInfoEntity = list.get(0);
        }
        function1.invoke(companion.assemble(orderInfoEntity));
    }

    public void onRpcFailure(SFRpcException sFRpcException) {
        super.onRpcFailure(sFRpcException);
        DialogUtil.hideLoadingDialog();
        this.$action.invoke(null);
    }
}
