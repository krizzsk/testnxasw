package com.didi.payment.wallet.global.wallet.view.view.home.p143v2.handler;

import android.app.Activity;
import android.content.Context;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.payment.creditcard.open.DidiCreditCardFactory;
import com.didi.payment.creditcard.open.DidiGlobalAddCardData;
import com.didi.payment.creditcard.open.IGlobalCreditCardApi;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.wallet.dimina.DiminaLaunchModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo148867d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, mo148868d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/handler/WalletBindCardHandler;", "Lcom/didi/drouter/router/IRouterHandler;", "()V", "handle", "", "request", "Lcom/didi/drouter/router/Request;", "result", "Lcom/didi/drouter/router/Result;", "wallet_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.handler.WalletBindCardHandler */
/* compiled from: WalletBindCardHandler.kt */
public final class WalletBindCardHandler implements IRouterHandler {
    public void handle(Request request, Result result) {
        int i;
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(result, "result");
        DidiGlobalAddCardData.AddCardParam addCardParam = new DidiGlobalAddCardData.AddCardParam();
        String string = request.getString("resource_id");
        String string2 = request.getString(ParamConst.PARAM_BIND_TYPE);
        String string3 = request.getString("discountContent");
        boolean z = request.getBoolean("isSignAfterOrder");
        String string4 = request.getString(DiminaLaunchModel.PRODUCT_LINE);
        addCardParam.discountContent = string3;
        addCardParam.isSignAfterOrder = z;
        addCardParam.productLine = string4;
        if (string2 == null || (intOrNull = StringsKt.toIntOrNull(string2)) == null) {
            i = 1;
        } else {
            i = intOrNull.intValue();
        }
        addCardParam.bindType = i;
        if (string == null) {
            string = "1";
        }
        addCardParam.resourceId = string;
        addCardParam.isShowLoading = true;
        addCardParam.extOmegaAttrs = request.getString("ext");
        IGlobalCreditCardApi createGlobalCreditCardApi = DidiCreditCardFactory.createGlobalCreditCardApi();
        Context context = request.getContext();
        createGlobalCreditCardApi.startAddCreditCardActivity(context instanceof Activity ? (Activity) context : null, 1, addCardParam);
    }
}
