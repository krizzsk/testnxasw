package com.didi.soda.bill.component.bill;

import com.didi.soda.bill.BillOmegaHelper;
import com.didi.soda.bill.component.Contract;
import com.didi.soda.bill.model.ComponentModel;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", ""}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: CustomerBillPresenter.kt */
final class CustomerBillPresenter$checkAndShowBubble$1$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ AddressEntity $it;
    final /* synthetic */ ComponentModel $this_apply;
    final /* synthetic */ CustomerBillPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CustomerBillPresenter$checkAndShowBubble$1$1$1(CustomerBillPresenter customerBillPresenter, AddressEntity addressEntity, ComponentModel componentModel) {
        super(0);
        this.this$0 = customerBillPresenter;
        this.$it = addressEntity;
        this.$this_apply = componentModel;
    }

    public final void invoke() {
        ((Contract.AbsBillView) this.this$0.getLogicView()).setTipsContent(this.$it);
        BillOmegaHelper.Companion companion = BillOmegaHelper.Companion;
        String cartId = this.$this_apply.getCartId();
        String shopId = this.$this_apply.getShopId();
        String access$getFromPage$p = this.this$0.f41544c;
        if (access$getFromPage$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fromPage");
            access$getFromPage$p = null;
        }
        companion.traceCartRecommendBubbleSW(cartId, shopId, access$getFromPage$p, 2);
    }
}
