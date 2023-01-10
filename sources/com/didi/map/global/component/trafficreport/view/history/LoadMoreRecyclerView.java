package com.didi.map.global.component.trafficreport.view.history;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.ref.WeakReference;

public class LoadMoreRecyclerView extends RecyclerView {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public WeakReference<LoadMoreListener> f28754a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public LinearLayoutManager f28755b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f28756c = false;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f28757d = false;

    public interface LoadMoreListener {
        void loadMore();
    }

    public LoadMoreRecyclerView(Context context) {
        super(context);
        m22387a();
    }

    public LoadMoreRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m22387a();
    }

    public LoadMoreRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m22387a();
    }

    /* renamed from: a */
    private void m22387a() {
        addOnScrollListener(new RecyclerView.OnScrollListener() {
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0 && LoadMoreRecyclerView.this.f28755b != null) {
                    int findLastCompletelyVisibleItemPosition = LoadMoreRecyclerView.this.f28755b.findLastCompletelyVisibleItemPosition();
                    int itemCount = LoadMoreRecyclerView.this.f28755b.getItemCount();
                    if (!LoadMoreRecyclerView.this.f28757d && !LoadMoreRecyclerView.this.f28756c && findLastCompletelyVisibleItemPosition == itemCount - 1 && LoadMoreRecyclerView.this.f28754a != null && LoadMoreRecyclerView.this.f28754a.get() != null) {
                        ((LoadMoreListener) LoadMoreRecyclerView.this.f28754a.get()).loadMore();
                    }
                }
            }

            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
            }
        });
    }

    public void setLayoutManager(LinearLayoutManager linearLayoutManager) {
        super.setLayoutManager(linearLayoutManager);
        this.f28755b = linearLayoutManager;
    }

    public void setLoadMoreListener(LoadMoreListener loadMoreListener) {
        this.f28754a = new WeakReference<>(loadMoreListener);
    }

    public void setLoadState(int i) {
        boolean z = true;
        this.f28756c = i == 11;
        if (i != 12) {
            z = false;
        }
        this.f28757d = z;
        if (getAdapter() instanceof ReportHistoryAdapter) {
            ((ReportHistoryAdapter) getAdapter()).setState(i);
        }
    }
}
