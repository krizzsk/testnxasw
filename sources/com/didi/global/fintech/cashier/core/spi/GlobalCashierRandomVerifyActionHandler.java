package com.didi.global.fintech.cashier.core.spi;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.didi.global.fintech.cashier.core.action.IGlobalCashierRandomVerifyActionHandler;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierRandomVerifyActionCallBack;
import com.didi.global.fintech.cashier.model.net.request.CashierAction;
import com.didi.global.fintech.cashier.model.net.request.CashierActionData;
import com.didi.global.fintech.cashier.user.facade.CashierFacade;
import com.didi.global.fintech.cashier.user.model.CashierParam;
import com.didi.payment.creditcard.open.DidiCreditCardFactory;
import com.didi.payment.creditcard.open.DidiGlobalVerifyCardData;
import com.didi.sdk.util.SystemUtil;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.didichuxing.security.cardverify.DiCardVerify;
import com.didichuxing.security.cardverify.DiCardVerifyCallback;
import com.didichuxing.security.cardverify.DiCardVerifyParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@ServiceProvider(alias = "cashier_random_verify", value = {IGlobalCashierRandomVerifyActionHandler.class})
@Metadata(mo148867d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J*\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J$\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016¨\u0006\u0016"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/core/spi/GlobalCashierRandomVerifyActionHandler;", "Lcom/didi/global/fintech/cashier/core/action/IGlobalCashierRandomVerifyActionHandler;", "()V", "go2NormalRandomVerify", "", "data", "Lcom/didi/global/fintech/cashier/model/net/request/CashierActionData;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "go2SodaRandomVerify", "context", "Landroid/content/Context;", "actionData", "productId", "", "handle", "", "action", "Lcom/didi/global/fintech/cashier/model/net/request/CashierAction;", "cashierParam", "Lcom/didi/global/fintech/cashier/user/model/CashierParam;", "onDestroy", "cashier_core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: GlobalCashierRandomVerifyActionHandler.kt */
public final class GlobalCashierRandomVerifyActionHandler implements IGlobalCashierRandomVerifyActionHandler {
    public void onDestroy() {
    }

    public boolean handle(LifecycleOwner lifecycleOwner, CashierAction cashierAction, CashierParam cashierParam) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        boolean z = false;
        if (!(cashierAction != null && !cashierAction.randomVerify())) {
            Context context = null;
            if ((cashierAction == null ? null : cashierAction.getActionData()) != null) {
                FragmentActivity fragmentActivity = lifecycleOwner instanceof FragmentActivity ? (FragmentActivity) lifecycleOwner : null;
                if (fragmentActivity == null) {
                    Fragment fragment = lifecycleOwner instanceof Fragment ? (Fragment) lifecycleOwner : null;
                    if (fragment != null) {
                        context = fragment.getContext();
                    }
                    if (context == null) {
                        return false;
                    }
                } else {
                    context = fragmentActivity;
                }
                CashierActionData actionData = cashierAction.getActionData();
                if (actionData == null) {
                    return false;
                }
                if (cashierParam != null && cashierParam.getUseSodaRandomVerify()) {
                    z = true;
                }
                if (z) {
                    m19162a(lifecycleOwner, context, actionData, cashierParam.getProductId());
                } else {
                    m19163a(actionData, lifecycleOwner);
                }
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private final void m19163a(CashierActionData cashierActionData, LifecycleOwner lifecycleOwner) {
        DidiGlobalVerifyCardData.VerifyCardParam verifyCardParam = new DidiGlobalVerifyCardData.VerifyCardParam();
        String cardIndex = cashierActionData.getCardIndex();
        String str = "";
        if (cardIndex == null) {
            cardIndex = str;
        }
        verifyCardParam.cardIndex = cardIndex;
        String cardNo = cashierActionData.getCardNo();
        if (cardNo != null) {
            str = cardNo;
        }
        verifyCardParam.cardNo = str;
        if (lifecycleOwner instanceof FragmentActivity) {
            DidiCreditCardFactory.createGlobalCreditCardApi().startVerifyBalanceActivity((FragmentActivity) lifecycleOwner, 6, verifyCardParam);
        } else if (lifecycleOwner instanceof Fragment) {
            DidiCreditCardFactory.createGlobalCreditCardApi().startVerifyBalanceActivity((Fragment) lifecycleOwner, 6, verifyCardParam);
        }
    }

    /* renamed from: a */
    private final void m19162a(LifecycleOwner lifecycleOwner, Context context, CashierActionData cashierActionData, String str) {
        DiCardVerifyParam.Builder builder = new DiCardVerifyParam.Builder(context);
        String cardIndex = cashierActionData.getCardIndex();
        String str2 = "";
        if (cardIndex == null) {
            cardIndex = str2;
        }
        DiCardVerifyParam.Builder cardIndex2 = builder.cardIndex(cardIndex);
        String cardNo = cashierActionData.getCardNo();
        if (cardNo == null) {
            cardNo = str2;
        }
        DiCardVerifyParam.Builder longitude = cardIndex2.cardNo(cardNo).productId(str).terminalId(CashierFacade.Companion.getInstance().getInitConfig().getTerminalID()).country(CashierFacade.Companion.getInstance().getInitConfig().getCountry()).language(CashierFacade.Companion.getInstance().getInitConfig().getLanguage()).uid(CashierFacade.Companion.getInstance().getInitConfig().getUid()).token(CashierFacade.Companion.getInstance().getInitConfig().getToken()).latitude(String.valueOf(CashierFacade.Companion.getInstance().getInitConfig().getLat())).longitude(String.valueOf(CashierFacade.Companion.getInstance().getInitConfig().getLng()));
        String iPAddress = SystemUtil.getIPAddress(CashierFacade.Companion.getInstance().getApplication());
        if (iPAddress != null) {
            str2 = iPAddress;
        }
        DiCardVerify.globalPayRandomPayVerify(context, longitude.mo127256ip(str2).build(), new DiCardVerifyCallback() {
            public final void onCallback(int i, String str) {
                GlobalCashierRandomVerifyActionHandler.m19161a(LifecycleOwner.this, i, str);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m19161a(LifecycleOwner lifecycleOwner, int i, String str) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "$lifecycleOwner");
        IGlobalCashierRandomVerifyActionCallBack iGlobalCashierRandomVerifyActionCallBack = lifecycleOwner instanceof IGlobalCashierRandomVerifyActionCallBack ? (IGlobalCashierRandomVerifyActionCallBack) lifecycleOwner : null;
        if (iGlobalCashierRandomVerifyActionCallBack != null) {
            iGlobalCashierRandomVerifyActionCallBack.onRandomVerifyResult(i, str);
        }
    }
}
