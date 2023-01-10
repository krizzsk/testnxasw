package com.didi.payment.wallet.global.wallet.view.view.home.p143v2.holder;

import com.didi.payment.base.utils.GlideUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n"}, mo148868d2 = {"<anonymous>", "", "count", "", "drawableId"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.TopCardViewHolder$onBindViewHolder$1$16 */
/* compiled from: TopCardViewHolder.kt */
final class TopCardViewHolder$onBindViewHolder$1$16 extends Lambda implements Function2<Integer, Integer, Unit> {
    final /* synthetic */ TopCardViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TopCardViewHolder$onBindViewHolder$1$16(TopCardViewHolder topCardViewHolder) {
        super(2);
        this.this$0 = topCardViewHolder;
    }

    public /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).intValue(), ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i, int i2) {
        this.this$0.getIvAddBank().setVisibility(8);
        this.this$0.getIvAddGifBank().setVisibility(0);
        GlideUtils.loadGifWithCount(this.this$0.itemView.getContext(), i2, this.this$0.getIvAddGifBank(), i, new Runnable() {
            public final void run() {
                TopCardViewHolder$onBindViewHolder$1$16.m47101invoke$lambda0(TopCardViewHolder.this);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m47101invoke$lambda0(TopCardViewHolder topCardViewHolder) {
        Intrinsics.checkNotNullParameter(topCardViewHolder, "this$0");
        topCardViewHolder.getIvAddGifBank().setVisibility(8);
        topCardViewHolder.getIvAddBank().setVisibility(0);
    }
}
