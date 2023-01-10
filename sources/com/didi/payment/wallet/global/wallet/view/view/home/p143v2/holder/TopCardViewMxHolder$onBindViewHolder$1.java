package com.didi.payment.wallet.global.wallet.view.view.home.p143v2.holder;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0016J \u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, mo148868d2 = {"com/didi/payment/wallet/global/wallet/view/view/home/v2/holder/TopCardViewMxHolder$onBindViewHolder$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "lastX", "", "getLastX", "()I", "setLastX", "(I)V", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "onScrolled", "dx", "dy", "wallet_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.TopCardViewMxHolder$onBindViewHolder$1 */
/* compiled from: TopCardViewMxHolder.kt */
public final class TopCardViewMxHolder$onBindViewHolder$1 extends RecyclerView.OnScrollListener {
    private int lastX;
    final /* synthetic */ TopCardViewMxHolder this$0;

    TopCardViewMxHolder$onBindViewHolder$1(TopCardViewMxHolder topCardViewMxHolder) {
        this.this$0 = topCardViewMxHolder;
    }

    public final int getLastX() {
        return this.lastX;
    }

    public final void setLastX(int i) {
        this.lastX = i;
    }

    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i, i2);
        int i3 = this.lastX + i;
        this.lastX = i3;
        if (i3 > 0 && this.this$0.getLayerPix() > 0.0f) {
            this.this$0.m26816a().updateAlpha(((float) 1) - (((float) this.lastX) / this.this$0.getLayerPix()));
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrollStateChanged(recyclerView, i);
        if (i == 0 && recyclerView.getChildCount() > 0) {
            boolean z = false;
            View childAt = recyclerView.getChildAt(0);
            if (childAt != null) {
                int right = childAt.getRight();
                TopCardViewMxHolder topCardViewMxHolder = this.this$0;
                TopCardViewMxItemHolder access$getTopCardViewHolder = topCardViewMxHolder.m26816a();
                if (right > topCardViewMxHolder.getMiddle()) {
                    z = true;
                }
                access$getTopCardViewHolder.updateLayer(z);
            }
        }
    }
}
