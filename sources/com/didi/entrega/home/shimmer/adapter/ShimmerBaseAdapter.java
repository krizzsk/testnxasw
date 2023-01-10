package com.didi.entrega.home.shimmer.adapter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.entrega.customer.foundation.util.CollectionsUtil;
import com.didi.entrega.home.shimmer.ShimmerViewHolder;
import java.util.ArrayList;
import java.util.List;

public abstract class ShimmerBaseAdapter extends RecyclerView.Adapter<ShimmerViewHolder> {

    /* renamed from: a */
    private static final int f22585a = 9;

    /* renamed from: b */
    private final List<List<View>> f22586b = new ArrayList();

    public int getItemCount() {
        return 9;
    }

    public void onBindViewHolder(ShimmerViewHolder shimmerViewHolder, int i) {
        mo66873a(shimmerViewHolder.getShimmerView());
    }

    public List<List<View>> getAnimationViewSet() {
        return this.f22586b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo66873a(List<View> list) {
        if (!CollectionsUtil.isEmpty(list)) {
            this.f22586b.add(list);
        }
    }
}
