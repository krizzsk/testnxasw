package com.didi.soda.bill.view.item;

import android.widget.TextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, mo148868d2 = {"<anonymous>", "", "text", ""}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: BillTotalItemView.kt */
final class BillTotalItemView$setData$1$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ BillTotalItemView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BillTotalItemView$setData$1$1(BillTotalItemView billTotalItemView) {
        super(1);
        this.this$0 = billTotalItemView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(String str) {
        TextView access$getTotalPrice$p = this.this$0.f41960b;
        if (access$getTotalPrice$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("totalPrice");
            access$getTotalPrice$p = null;
        }
        access$getTotalPrice$p.setText(str);
    }
}
