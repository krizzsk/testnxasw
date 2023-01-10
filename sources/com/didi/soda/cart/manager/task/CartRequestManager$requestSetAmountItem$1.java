package com.didi.soda.cart.manager.task;

import com.didi.soda.cart.model.SetItemAmountParams;
import com.didi.soda.customer.foundation.rpc.CustomerRpcService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, mo148868d2 = {"<anonymous>", "", "requestParam", "Lcom/didi/soda/cart/model/SetItemAmountParams;", "mergeModel", "Lcom/didi/soda/cart/manager/task/CartMergeModel;"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: CartRequestManager.kt */
final class CartRequestManager$requestSetAmountItem$1 extends Lambda implements Function2<SetItemAmountParams, CartMergeModel, Unit> {
    final /* synthetic */ CustomerRpcService $rpcService;
    final /* synthetic */ CartRequestManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CartRequestManager$requestSetAmountItem$1(CartRequestManager cartRequestManager, CustomerRpcService customerRpcService) {
        super(2);
        this.this$0 = cartRequestManager;
        this.$rpcService = customerRpcService;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((SetItemAmountParams) obj, (CartMergeModel) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(SetItemAmountParams setItemAmountParams, CartMergeModel cartMergeModel) {
        Intrinsics.checkNotNullParameter(setItemAmountParams, "requestParam");
        Intrinsics.checkNotNullParameter(cartMergeModel, "mergeModel");
        CartRequestManagerKt.m32001a(Intrinsics.stringPlus("requestSetItem : end merge = ", setItemAmountParams));
        this.this$0.f42582e.requestSetAmount(CartRequest.Companion.createCardSetAmount(new CartRequestManager$requestSetAmountItem$1$runRequest$1(cartMergeModel, this.this$0, this.$rpcService, setItemAmountParams)));
    }
}
