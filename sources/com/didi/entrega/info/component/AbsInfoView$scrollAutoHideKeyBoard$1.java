package com.didi.entrega.info.component;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.entrega.customer.foundation.util.KeyboardUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, mo148868d2 = {"com/didi/entrega/info/component/AbsInfoView$scrollAutoHideKeyBoard$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "entrega-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: AbsInfoView.kt */
public final class AbsInfoView$scrollAutoHideKeyBoard$1 extends RecyclerView.OnScrollListener {
    final /* synthetic */ AbsInfoView this$0;

    AbsInfoView$scrollAutoHideKeyBoard$1(AbsInfoView absInfoView) {
        this.this$0 = absInfoView;
    }

    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i, i2);
        if (Math.abs(i2) > 10) {
            KeyboardUtils.hideSoftInput(this.this$0.getContext(), (View) null);
        }
    }
}
