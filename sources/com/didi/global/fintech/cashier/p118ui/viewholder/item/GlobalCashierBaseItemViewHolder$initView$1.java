package com.didi.global.fintech.cashier.p118ui.viewholder.item;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, mo148868d2 = {"<anonymous>", "", "it", "Landroid/view/View;"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.viewholder.item.GlobalCashierBaseItemViewHolder$initView$1 */
/* compiled from: GlobalCashierBaseItemViewHolder.kt */
final class GlobalCashierBaseItemViewHolder$initView$1 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ GlobalCashierBaseItemViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GlobalCashierBaseItemViewHolder$initView$1(GlobalCashierBaseItemViewHolder globalCashierBaseItemViewHolder) {
        super(1);
        this.this$0 = globalCashierBaseItemViewHolder;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((View) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(View view) {
        Boolean valueOf = Boolean.valueOf(this.this$0.f23771d);
        ChannelItemViewHolderData channelItemViewHolderData = null;
        if (!valueOf.booleanValue()) {
            valueOf = null;
        }
        if (valueOf != null) {
            GlobalCashierBaseItemViewHolder globalCashierBaseItemViewHolder = this.this$0;
            valueOf.booleanValue();
            Function1<ChannelItemViewHolderData, Unit> onClick = globalCashierBaseItemViewHolder.getOnClick();
            if (onClick != null) {
                ChannelItemViewHolderData access$getData$p = globalCashierBaseItemViewHolder.f23769b;
                if (access$getData$p == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("data");
                } else {
                    channelItemViewHolderData = access$getData$p;
                }
                onClick.invoke(channelItemViewHolderData);
            }
        }
    }
}
