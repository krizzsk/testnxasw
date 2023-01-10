package com.didi.entrega.customer.foundation.util;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CustomeRvExposeUtil {

    /* renamed from: a */
    private OnItemExposeListener f21930a;

    /* renamed from: b */
    private RecyclerView f21931b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f21932c = false;

    public interface OnItemExposeListener {
        void onItemViewVisible(int i);
    }

    public void setRecyclerItemExposeListener(RecyclerView recyclerView, OnItemExposeListener onItemExposeListener) {
        this.f21930a = onItemExposeListener;
        this.f21931b = recyclerView;
        if (recyclerView != null && recyclerView.getVisibility() == 0) {
            this.f21931b.addOnScrollListener(new RecyclerView.OnScrollListener() {
                public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                    if (i == 0) {
                        CustomeRvExposeUtil.this.handleCurrentVisibleItems();
                    }
                }

                public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                    super.onScrolled(recyclerView, i, i2);
                    if (!CustomeRvExposeUtil.this.f21932c) {
                        CustomeRvExposeUtil.this.handleCurrentVisibleItems();
                        boolean unused = CustomeRvExposeUtil.this.f21932c = true;
                    }
                }
            });
        }
    }

    public void handleCurrentVisibleItems() {
        RecyclerView recyclerView = this.f21931b;
        if (recyclerView != null && recyclerView.getVisibility() == 0) {
            try {
                int[] iArr = new int[2];
                RecyclerView.LayoutManager layoutManager = this.f21931b.getLayoutManager();
                if (layoutManager instanceof LinearLayoutManager) {
                    iArr = m18240a((LinearLayoutManager) layoutManager);
                }
                if (iArr == null) {
                    return;
                }
                if (iArr.length >= 2) {
                    for (int i = iArr[0]; i <= iArr[1]; i++) {
                        m18237a(layoutManager.findViewByPosition(i), i);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private void m18237a(View view, int i) {
        OnItemExposeListener onItemExposeListener;
        if (view != null && view.getVisibility() == 0 && (onItemExposeListener = this.f21930a) != null) {
            onItemExposeListener.onItemViewVisible(i);
        }
    }

    /* renamed from: a */
    private int[] m18240a(LinearLayoutManager linearLayoutManager) {
        return new int[]{linearLayoutManager.findFirstVisibleItemPosition(), linearLayoutManager.findLastVisibleItemPosition()};
    }
}
