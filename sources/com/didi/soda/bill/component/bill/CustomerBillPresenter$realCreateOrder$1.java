package com.didi.soda.bill.component.bill;

import android.os.Bundle;
import com.didi.soda.bill.component.Contract;
import com.didi.soda.bill.model.ComponentModel;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.SceneParamsEntity;
import com.didi.soda.manager.base.ICustomerPayManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\"\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016¨\u0006\u0010"}, mo148868d2 = {"com/didi/soda/bill/component/bill/CustomerBillPresenter$realCreateOrder$1", "Lcom/didi/soda/manager/base/ICustomerPayManager$BillPayCallback;", "gotoEditPage", "", "msg", "", "quitBill", "error", "", "recoverBill", "orderId", "sceneType", "sceneParam", "Lcom/didi/soda/customer/foundation/rpc/entity/SceneParamsEntity;", "refreshBill", "updateBusinessAndCart", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: CustomerBillPresenter.kt */
public final class CustomerBillPresenter$realCreateOrder$1 implements ICustomerPayManager.BillPayCallback {
    final /* synthetic */ CustomerBillPresenter this$0;

    CustomerBillPresenter$realCreateOrder$1(CustomerBillPresenter customerBillPresenter) {
        this.this$0 = customerBillPresenter;
    }

    public void recoverBill(String str, int i, SceneParamsEntity sceneParamsEntity) {
        Intrinsics.checkNotNullParameter(str, "orderId");
        this.this$0.m31205a(str, i, sceneParamsEntity);
        LogUtil.m32588i("CustomerBillPresenter", Intrinsics.stringPlus("realCreateOrder -> recoverBill orderId: ", str));
    }

    public void refreshBill() {
        LogUtil.m32588i("CustomerBillPresenter", "realCreateOrder -> refreshBill");
        CustomerBillPresenter.m31198a(this.this$0, false, 201, 1, (Object) null);
    }

    public void quitBill(int i) {
        this.this$0.m31192a(i);
    }

    public void updateBusinessAndCart() {
        this.this$0.f41567z = true;
    }

    public void gotoEditPage(String str) {
        Intrinsics.checkNotNullParameter(str, "msg");
        ComponentModel access$findModelByType = this.this$0.m31212b(2);
        if (access$findModelByType != null) {
            Bundle bundle = new Bundle();
            bundle.putString(Const.PageParams.NAME_NOT_LEGAL, str);
            Unit unit = Unit.INSTANCE;
            ((Contract.AbsBillView) this.this$0.getLogicView()).autoClickItem(access$findModelByType, 5, bundle);
        }
    }
}
