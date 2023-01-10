package com.didi.global.fintech.cashier.p118ui.viewholder.adapter;

import android.view.View;
import com.didi.global.fintech.cashier.p118ui.viewholder.item.InstallmentVo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, mo148868d2 = {"<anonymous>", "", "it", "Landroid/view/View;"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.viewholder.adapter.InstallmentAdapter$onBindViewHolder$1 */
/* compiled from: InstallmentAdapter.kt */
final class InstallmentAdapter$onBindViewHolder$1 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ InstallmentVo.PlansVo $data;
    final /* synthetic */ InstallmentAdapter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InstallmentAdapter$onBindViewHolder$1(InstallmentAdapter installmentAdapter, InstallmentVo.PlansVo plansVo) {
        super(1);
        this.this$0 = installmentAdapter;
        this.$data = plansVo;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((View) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(View view) {
        Function1 access$getOnItemClick$p = this.this$0.f23742a;
        if (access$getOnItemClick$p != null) {
            access$getOnItemClick$p.invoke(this.$data);
        }
    }
}
