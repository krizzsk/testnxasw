package com.didi.soda.bill.component.bill;

import com.didi.soda.business.model.BusinessActionParam;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerBusinessManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", ""}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: CustomerBillPresenterV2.kt */
final class CustomerBillPresenterV2$BillRpcCallback$onRpcSuccess$3$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Ref.BooleanRef $isAutoGotoEditAddress;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CustomerBillPresenterV2$BillRpcCallback$onRpcSuccess$3$1(Ref.BooleanRef booleanRef) {
        super(0);
        this.$isAutoGotoEditAddress = booleanRef;
    }

    public final void invoke() {
        this.$isAutoGotoEditAddress.element = true;
        ((ICustomerBusinessManager) CustomerManagerLoader.loadManager(ICustomerBusinessManager.class)).refreshBusinessPage(new BusinessActionParam(true, false, true, 2, (DefaultConstructorMarker) null));
    }
}
