package com.didi.global.fintech.cashier.core;

import android.content.Intent;
import android.view.View;
import com.didi.global.fintech.cashier.p118ui.omega.CashierOmegaUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, mo148868d2 = {"<anonymous>", "", "it", "Landroid/view/View;"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: GlobalCashierPlansInfoActivity.kt */
final class GlobalCashierPlansInfoActivity$initView$2 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ GlobalCashierPlansInfoActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GlobalCashierPlansInfoActivity$initView$2(GlobalCashierPlansInfoActivity globalCashierPlansInfoActivity) {
        super(1);
        this.this$0 = globalCashierPlansInfoActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((View) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(View view) {
        GlobalCashierPlansInfoActivity globalCashierPlansInfoActivity = this.this$0;
        globalCashierPlansInfoActivity.m19134a(4, globalCashierPlansInfoActivity.f23281g);
        GlobalCashierPlansInfoActivity globalCashierPlansInfoActivity2 = this.this$0;
        Intent intent = new Intent();
        GlobalCashierPlansInfoActivity globalCashierPlansInfoActivity3 = this.this$0;
        intent.putExtra(GlobalCashierPlansInfoActivity.PARAM_INSTALLMENT_NUMBER, globalCashierPlansInfoActivity3.f23281g);
        intent.putExtra("card_index", globalCashierPlansInfoActivity3.f23282h);
        Unit unit = Unit.INSTANCE;
        globalCashierPlansInfoActivity2.setResult(-1, intent);
        this.this$0.finish();
        CashierOmegaUtils.Companion.setPubPage((String) null);
    }
}
