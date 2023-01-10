package com.didi.soda.home.topgun.widget;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", ""}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: FeedHeaderLayout.kt */
final class FeedHeaderLayout$getItemHeight$1 extends Lambda implements Function0<Integer> {
    final /* synthetic */ FeedHeaderLayout this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedHeaderLayout$getItemHeight$1(FeedHeaderLayout feedHeaderLayout) {
        super(0);
        this.this$0 = feedHeaderLayout;
    }

    public final Integer invoke() {
        View access$getItemView$p = this.this$0.f45554c;
        return Integer.valueOf(access$getItemView$p == null ? 0 : access$getItemView$p.getHeight());
    }
}
