package com.didi.global.fintech.cashier.p118ui.dialog;

import android.view.View;
import com.didi.global.fintech.cashier.p118ui.dialog.GlobalCashierAlertDialog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, mo148868d2 = {"<anonymous>", "", "it", "Landroid/view/View;"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.dialog.GlobalCashierAlertDialog$posBtn$1$1 */
/* compiled from: GlobalCashierAlertDialog.kt */
final class GlobalCashierAlertDialog$posBtn$1$1 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ Map.Entry<String, GlobalCashierAlertDialog.OnBtnClickListener> $entry;
    final /* synthetic */ GlobalCashierAlertDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GlobalCashierAlertDialog$posBtn$1$1(Map.Entry<String, ? extends GlobalCashierAlertDialog.OnBtnClickListener> entry, GlobalCashierAlertDialog globalCashierAlertDialog) {
        super(1);
        this.$entry = entry;
        this.this$0 = globalCashierAlertDialog;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((View) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(View view) {
        this.$entry.getValue().onBtnClick(this.this$0);
    }
}
