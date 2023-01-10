package com.didi.global.fintech.cashier.user.utils;

import android.app.Activity;
import com.didi.global.fintech.cashier.user.model.CashierParam;
import com.didi.global.fintech.cashier.user.p119ut.CashierOmegaSDK;
import com.didi.global.fintech.cashier.user.p119ut.CashierUT;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0006\u0010\t\u001a\u00020\u0004¨\u0006\n"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/user/utils/CashierStartUpTask;", "", "()V", "startExternal", "", "param", "Lcom/didi/global/fintech/cashier/user/model/CashierParam;", "activity", "Landroid/app/Activity;", "startInternal", "cashier_user_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: CashierStartUpTask.kt */
public final class CashierStartUpTask {
    public static final CashierStartUpTask INSTANCE = new CashierStartUpTask();

    private CashierStartUpTask() {
    }

    public final void startExternal(CashierParam cashierParam, Activity activity) {
        Intrinsics.checkNotNullParameter(cashierParam, "param");
        CashierOmegaSDK.INSTANCE.initGlobalAttrsFromExternal(cashierParam, activity);
        CashierUT.trackEvent$default(CashierUT.INSTANCE, CashierUT.EVENT_ID_SDK_ALL_EN, (Map) null, 2, (Object) null);
    }

    public final void startInternal() {
        CashierUT.trackEvent$default(CashierUT.INSTANCE, CashierUT.EVENT_ID_SDK_2_EN, (Map) null, 2, (Object) null);
    }
}
