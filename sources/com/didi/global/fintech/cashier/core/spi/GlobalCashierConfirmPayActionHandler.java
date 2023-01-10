package com.didi.global.fintech.cashier.core.spi;

import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.didi.global.fintech.cashier.core.GlobalCashierConfirmPayActivity;
import com.didi.global.fintech.cashier.core.action.IGlobalCashierConfirmPayActionHandler;
import com.didi.global.fintech.cashier.core.base.BaseCashierActivity;
import com.didi.global.fintech.cashier.model.net.request.CashierAction;
import com.didi.global.fintech.cashier.model.net.request.CashierActionData;
import com.didi.global.fintech.cashier.user.model.CashierParam;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@ServiceProvider(alias = "confirm_pay", value = {IGlobalCashierConfirmPayActionHandler.class})
@Metadata(mo148867d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/core/spi/GlobalCashierConfirmPayActionHandler;", "Lcom/didi/global/fintech/cashier/core/action/IGlobalCashierConfirmPayActionHandler;", "()V", "handle", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "action", "Lcom/didi/global/fintech/cashier/model/net/request/CashierAction;", "param", "Lcom/didi/global/fintech/cashier/user/model/CashierParam;", "uniqueId", "", "onDestroy", "", "cashier_core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: GlobalCashierConfirmPayActionHandler.kt */
public final class GlobalCashierConfirmPayActionHandler implements IGlobalCashierConfirmPayActionHandler {
    public void onDestroy() {
    }

    public boolean handle(LifecycleOwner lifecycleOwner, CashierAction cashierAction, CashierParam cashierParam, String str) {
        Context context;
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        boolean z = lifecycleOwner instanceof FragmentActivity;
        CashierActionData cashierActionData = null;
        FragmentActivity fragmentActivity = z ? (FragmentActivity) lifecycleOwner : null;
        if (fragmentActivity == null) {
            Fragment fragment = lifecycleOwner instanceof Fragment ? (Fragment) lifecycleOwner : null;
            context = fragment == null ? null : fragment.getContext();
            if (context == null) {
                return false;
            }
        } else {
            context = fragmentActivity;
        }
        GlobalCashierConfirmPayActionHandler globalCashierConfirmPayActionHandler = this;
        if (((cashierAction != null && cashierAction.confirmPay()) && cashierAction.getActionData() != null ? this : null) == null) {
            return false;
        }
        Intent intent = new Intent(context, GlobalCashierConfirmPayActivity.class);
        if (cashierAction != null) {
            cashierActionData = cashierAction.getActionData();
        }
        intent.putExtra("actionData", cashierActionData);
        intent.putExtra("args_param", cashierParam);
        intent.putExtra(BaseCashierActivity.ARGS_UNIQUE_ID, str);
        if (z) {
            ((FragmentActivity) lifecycleOwner).startActivityForResult(intent, 200);
        } else if (lifecycleOwner instanceof Fragment) {
            ((Fragment) lifecycleOwner).startActivityForResult(intent, 200);
        }
        return true;
    }
}
