package com.didi.global.fintech.cashier.core.spi;

import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.didi.global.fintech.cashier.core.GlobalCashierWebActivity;
import com.didi.global.fintech.cashier.core.action.IGlobalCashierOpenUrlActionHandler;
import com.didi.global.fintech.cashier.core.utils.GlobalCashierWebParamUtils;
import com.didi.global.fintech.cashier.model.net.request.CashierAction;
import com.didi.global.fintech.cashier.model.net.request.CashierActionData;
import com.didi.payment.base.view.webview.PayBaseWebActivity;
import com.didi.sdk.pay.base.PayCommonParamsUtil;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@ServiceProvider(alias = "open_url", value = {IGlobalCashierOpenUrlActionHandler.class})
@Metadata(mo148867d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/core/spi/GlobalCashierOpenUrlActionHandler;", "Lcom/didi/global/fintech/cashier/core/action/IGlobalCashierOpenUrlActionHandler;", "()V", "handle", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "action", "Lcom/didi/global/fintech/cashier/model/net/request/CashierAction;", "onDestroy", "", "cashier_core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: GlobalCashierOpenUrlActionHandler.kt */
public final class GlobalCashierOpenUrlActionHandler implements IGlobalCashierOpenUrlActionHandler {
    public void onDestroy() {
    }

    public boolean handle(LifecycleOwner lifecycleOwner, CashierAction cashierAction) {
        Context context;
        CashierActionData actionData;
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        boolean z = lifecycleOwner instanceof FragmentActivity;
        String str = null;
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
        GlobalCashierOpenUrlActionHandler globalCashierOpenUrlActionHandler = this;
        if (((cashierAction != null && cashierAction.openUrl()) && cashierAction.getActionData() != null ? this : null) == null) {
            return false;
        }
        GlobalCashierWebParamUtils globalCashierWebParamUtils = GlobalCashierWebParamUtils.INSTANCE;
        if (!(cashierAction == null || (actionData = cashierAction.getActionData()) == null)) {
            str = actionData.getUrl();
        }
        String appendUrlQueryParams = globalCashierWebParamUtils.appendUrlQueryParams(str, PayCommonParamsUtil.getInstance().getCommonParam(context));
        Intent intent = new Intent(context, GlobalCashierWebActivity.class);
        intent.putExtra(PayBaseWebActivity.EXTRA_URL, appendUrlQueryParams);
        if (z) {
            ((FragmentActivity) lifecycleOwner).startActivityForResult(intent, 201);
        } else if (lifecycleOwner instanceof Fragment) {
            ((Fragment) lifecycleOwner).startActivityForResult(intent, 201);
        }
        return true;
    }
}
