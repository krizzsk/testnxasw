package com.didi.soda.home.widget;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, mo148868d2 = {"com/didi/soda/home/widget/LandingFloatLayout$attachRecycleView$2", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "onItemRangeChanged", "", "positionStart", "", "itemCount", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: LandingFloatView.kt */
public final class LandingFloatLayout$attachRecycleView$2 extends RecyclerView.AdapterDataObserver {
    final /* synthetic */ LandingFloatLayout this$0;

    LandingFloatLayout$attachRecycleView$2(LandingFloatLayout landingFloatLayout) {
        this.this$0 = landingFloatLayout;
    }

    public void onItemRangeChanged(int i, int i2) {
        super.onItemRangeChanged(i, i2);
        this.this$0.getStickItemImp().onItemRangeChanged(i, i2);
    }
}
