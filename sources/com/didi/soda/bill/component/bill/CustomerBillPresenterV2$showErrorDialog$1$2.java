package com.didi.soda.bill.component.bill;

import com.didi.entrega.customer.app.constant.Const;
import com.didi.soda.bill.BillOmegaHelper;
import com.didi.soda.bill.component.Contract;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016¨\u0006\u0006"}, mo148868d2 = {"com/didi/soda/bill/component/bill/CustomerBillPresenterV2$showErrorDialog$1$2", "Lcom/didi/soda/bill/component/Contract$IPayCardErrorListener;", "onCashPay", "", "onDismiss", "onOtherPay", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: CustomerBillPresenterV2.kt */
public final class CustomerBillPresenterV2$showErrorDialog$1$2 implements Contract.IPayCardErrorListener {
    final /* synthetic */ String $orderId;
    final /* synthetic */ CustomerBillPresenterV2 this$0;

    CustomerBillPresenterV2$showErrorDialog$1$2(CustomerBillPresenterV2 customerBillPresenterV2, String str) {
        this.this$0 = customerBillPresenterV2;
        this.$orderId = str;
    }

    public void onEditAddress() {
        Contract.IPayCardErrorListener.DefaultImpls.onEditAddress(this);
    }

    public void onCashPay() {
        CustomerBillPresenterV2 customerBillPresenterV2 = this.this$0;
        customerBillPresenterV2.onCreateOrder(((Contract.AbsBillView) customerBillPresenterV2.getLogicView()).getPayButtonCallback());
        BillOmegaHelper.Companion companion = BillOmegaHelper.Companion;
        String str = this.$orderId;
        String access$getShopId$p = this.this$0.f41574b;
        String str2 = null;
        if (access$getShopId$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopId");
            access$getShopId$p = null;
        }
        String access$getCartId$p = this.this$0.f41573a;
        if (access$getCartId$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException(Const.BundleKey.CART_ID);
        } else {
            str2 = access$getCartId$p;
        }
        companion.traceGuideCashDialogCK(str, access$getShopId$p, str2, 1);
    }

    public void onOtherPay() {
        this.this$0.m31267j();
        BillOmegaHelper.Companion companion = BillOmegaHelper.Companion;
        String str = this.$orderId;
        String access$getShopId$p = this.this$0.f41574b;
        String str2 = null;
        if (access$getShopId$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopId");
            access$getShopId$p = null;
        }
        String access$getCartId$p = this.this$0.f41573a;
        if (access$getCartId$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException(Const.BundleKey.CART_ID);
        } else {
            str2 = access$getCartId$p;
        }
        companion.traceGuideCashDialogCK(str, access$getShopId$p, str2, 2);
    }

    public void onDismiss() {
        BillOmegaHelper.Companion companion = BillOmegaHelper.Companion;
        String str = this.$orderId;
        String access$getShopId$p = this.this$0.f41574b;
        String str2 = null;
        if (access$getShopId$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopId");
            access$getShopId$p = null;
        }
        String access$getCartId$p = this.this$0.f41573a;
        if (access$getCartId$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException(Const.BundleKey.CART_ID);
        } else {
            str2 = access$getCartId$p;
        }
        companion.traceGuideCashDialogCK(str, access$getShopId$p, str2, 3);
    }
}
