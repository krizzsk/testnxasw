package com.didi.global.fintech.cashier.user.facade;

import android.app.Activity;
import android.content.Intent;
import com.didi.global.fintech.cashier.user.model.CashierParam;
import com.didi.global.fintech.cashier.user.p119ut.CashierUT;
import com.didi.global.fintech.cashier.user.spi.IGlobalCashierProcessor;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, mo148868d2 = {"<anonymous>", "", "result", ""}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: CashierFacade.kt */
final class CashierFacade$launchCustomCashier$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ Intent $intent;
    final /* synthetic */ CashierLaunchListener $listener;
    final /* synthetic */ CashierParam $param;
    final /* synthetic */ CashierFacade this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CashierFacade$launchCustomCashier$1(CashierLaunchListener cashierLaunchListener, CashierFacade cashierFacade, Activity activity, Intent intent, CashierParam cashierParam) {
        super(1);
        this.$listener = cashierLaunchListener;
        this.this$0 = cashierFacade;
        this.$activity = activity;
        this.$intent = intent;
        this.$param = cashierParam;
    }

    public /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        CashierLaunchListener cashierLaunchListener = this.$listener;
        if (cashierLaunchListener != null) {
            cashierLaunchListener.onCashierLaunch(z);
        }
        if (z) {
            IGlobalCashierProcessor access$getCashierProcessor$p = this.this$0.f23932b;
            if (access$getCashierProcessor$p != null) {
                access$getCashierProcessor$p.launch(this.$activity, this.$intent, (Integer) null, this.$param);
                return;
            }
            return;
        }
        CashierUT.trackEvent$default(CashierUT.INSTANCE, CashierUT.EVENT_ID_SDK_1_EN, (Map) null, 2, (Object) null);
    }
}
