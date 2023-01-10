package com.didi.global.fintech.cashier.core.spi;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.api.Extend;
import com.didi.drouter.router.Request;
import com.didi.global.fintech.cashier.core.action.IGlobalCashierAddCardActionHandler;
import com.didi.global.fintech.cashier.core.consts.RouterConstKt;
import com.didi.global.fintech.cashier.model.net.request.CashierAction;
import com.didi.global.fintech.cashier.model.net.request.CashierActionData;
import com.didi.global.fintech.cashier.user.facade.CashierFacade;
import com.didi.global.fintech.cashier.user.model.CashierParam;
import com.didi.payment.creditcard.open.DidiCreditCardFactory;
import com.didi.payment.creditcard.open.DidiGlobalAddCardData;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@ServiceProvider(alias = "add_card", value = {IGlobalCashierAddCardActionHandler.class})
@Metadata(mo148867d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/core/spi/GlobalCashierAddCardActionHandler;", "Lcom/didi/global/fintech/cashier/core/action/IGlobalCashierAddCardActionHandler;", "()V", "handle", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "action", "Lcom/didi/global/fintech/cashier/model/net/request/CashierAction;", "cashierParam", "Lcom/didi/global/fintech/cashier/user/model/CashierParam;", "onDestroy", "", "cashier_core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: GlobalCashierAddCardActionHandler.kt */
public final class GlobalCashierAddCardActionHandler implements IGlobalCashierAddCardActionHandler {
    public void onDestroy() {
    }

    public boolean handle(FragmentActivity fragmentActivity, CashierAction cashierAction, CashierParam cashierParam) {
        String str;
        String str2;
        Object obj;
        Map<String, Object> omegaAttrs;
        CashierActionData actionData;
        String appId;
        CashierActionData actionData2;
        CashierActionData actionData3;
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
        if (CashierFacade.Companion.getInstance().getTheme().latour()) {
            ((Request) DRouter.build(RouterConstKt.WALLET_BIND_CARD_URI).putExtra(Extend.START_ACTIVITY_REQUEST_CODE, 1)).start(fragmentActivity);
        } else {
            DidiGlobalAddCardData.AddCardParam addCardParam = new DidiGlobalAddCardData.AddCardParam();
            addCardParam.bindType = 4;
            addCardParam.isSignAfterOrder = true;
            String str3 = "";
            if (cashierAction == null || (actionData3 = cashierAction.getActionData()) == null || (str = actionData3.getProductId()) == null) {
                str = str3;
            }
            addCardParam.productLine = str;
            if (cashierAction == null || (actionData2 = cashierAction.getActionData()) == null || (str2 = actionData2.getProductId()) == null) {
                str2 = str3;
            }
            addCardParam.productId = str2;
            if (!(cashierAction == null || (actionData = cashierAction.getActionData()) == null || (appId = actionData.getAppId()) == null)) {
                str3 = appId;
            }
            addCardParam.appId = str3;
            if (cashierParam == null || (omegaAttrs = cashierParam.getOmegaAttrs()) == null) {
                obj = null;
            } else {
                obj = omegaAttrs.get("resource_id");
            }
            String str4 = (String) obj;
            CharSequence charSequence = str4;
            if (charSequence == null || StringsKt.isBlank(charSequence)) {
                str4 = "8";
            }
            addCardParam.resourceId = str4;
            addCardParam.orderId = null;
            DidiCreditCardFactory.createGlobalCreditCardApi().startAddCreditCardActivity((Activity) fragmentActivity, 1, addCardParam);
        }
        return true;
    }
}
