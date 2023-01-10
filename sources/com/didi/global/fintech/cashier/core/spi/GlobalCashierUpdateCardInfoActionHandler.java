package com.didi.global.fintech.cashier.core.spi;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.didi.global.fintech.cashier.core.action.IGlobalCashierUpdateCardInfoActionHandler;
import com.didi.global.fintech.cashier.model.net.request.CashierAction;
import com.didi.global.fintech.cashier.model.net.request.CashierActionData;
import com.didi.payment.creditcard.open.DidiCreditCardFactory;
import com.didi.payment.creditcard.open.DidiGlobalAddCardData;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@ServiceProvider(alias = "cashier_update_card_info", value = {IGlobalCashierUpdateCardInfoActionHandler.class})
@Metadata(mo148867d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/core/spi/GlobalCashierUpdateCardInfoActionHandler;", "Lcom/didi/global/fintech/cashier/core/action/IGlobalCashierUpdateCardInfoActionHandler;", "()V", "handle", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "action", "Lcom/didi/global/fintech/cashier/model/net/request/CashierAction;", "onDestroy", "", "cashier_core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: GlobalCashierUpdateCardInfoActionHandler.kt */
public final class GlobalCashierUpdateCardInfoActionHandler implements IGlobalCashierUpdateCardInfoActionHandler {
    public void onDestroy() {
    }

    public boolean handle(LifecycleOwner lifecycleOwner, CashierAction cashierAction) {
        CashierActionData cashierActionData;
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        boolean z = lifecycleOwner instanceof FragmentActivity;
        if (!z && !(lifecycleOwner instanceof Fragment)) {
            return false;
        }
        GlobalCashierUpdateCardInfoActionHandler globalCashierUpdateCardInfoActionHandler = this;
        if (((cashierAction != null && cashierAction.updateCardInfo()) && cashierAction.getActionData() != null ? this : null) == null) {
            return false;
        }
        if (cashierAction == null) {
            cashierActionData = null;
        } else {
            cashierActionData = cashierAction.getActionData();
        }
        if (cashierActionData != null) {
            DidiGlobalAddCardData.AddCardParam addCardParam = new DidiGlobalAddCardData.AddCardParam();
            addCardParam.bindType = 4;
            addCardParam.isSignAfterOrder = true;
            String productId = cashierActionData.getProductId();
            String str = "";
            if (productId == null) {
                productId = str;
            }
            addCardParam.productLine = productId;
            addCardParam.orderId = null;
            String cardNo = cashierActionData.getCardNo();
            if (cardNo != null) {
                str = cardNo;
            }
            addCardParam.cardNo = str;
            if (z) {
                DidiCreditCardFactory.createGlobalCreditCardApi().startAddCreditCardActivity((Activity) lifecycleOwner, 2, addCardParam);
            } else if (lifecycleOwner instanceof Fragment) {
                DidiCreditCardFactory.createGlobalCreditCardApi().startAddCreditCardActivity((Fragment) lifecycleOwner, 2, addCardParam);
            }
        }
        return true;
    }
}
