package com.didi.soda.home.shimmer.adapter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.home.shimmer.ShimmerViewHolder;
import java.util.ArrayList;
import java.util.List;

public abstract class ShimmerBaseAdapter extends RecyclerView.Adapter<ShimmerViewHolder> {

    /* renamed from: a */
    private static final int f45222a = 9;

    /* renamed from: b */
    private List<List<View>> f45223b = new ArrayList();

    public int getItemCount() {
        return 9;
    }

    public void onBindViewHolder(ShimmerViewHolder shimmerViewHolder, int i) {
        mo113496a(shimmerViewHolder.getShimmerView());
    }

    public List<List<View>> getAnimationViewSet() {
        return this.f45223b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo113496a(List<View> list) {
        if (!CollectionsUtil.isEmpty(list)) {
            this.f45223b.add(list);
        }
    }
}
