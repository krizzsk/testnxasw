package com.didi.soda.home.topgun.binder;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, mo148868d2 = {"Lcom/didi/soda/home/topgun/binder/SpaceItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "()V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.soda.home.topgun.binder.b */
/* compiled from: HomeSceneBinder.kt */
final class C14762b extends RecyclerView.ItemDecoration {
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(rect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        Resources resources = recyclerView.getContext().getResources();
        int childLayoutPosition = recyclerView.getChildLayoutPosition(view);
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        Intrinsics.checkNotNull(adapter);
        int itemCount = adapter.getItemCount();
        if (childLayoutPosition >= itemCount - 2) {
            if (itemCount % 2 == 0) {
                rect.right = (int) resources.getDimension(R.dimen.customer_22px);
            } else if (childLayoutPosition == itemCount - 1) {
                rect.right = (int) resources.getDimension(R.dimen.customer_22px);
            }
        }
        if (childLayoutPosition == 0 || childLayoutPosition == 1) {
            rect.left = (int) resources.getDimension(R.dimen.customer_22px);
        }
    }
}
