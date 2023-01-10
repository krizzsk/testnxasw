package com.didi.app.nova.support.view.recyclerview.view.layoutmanager;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.support.view.recyclerview.adapter.NovaRecyclerAdapter;

public class NovaLinearLayoutManager extends LinearLayoutManager implements INovaLayoutManager {

    /* renamed from: a */
    private RecyclerView.SmoothScroller f10475a;

    /* renamed from: b */
    private C4346a f10476b;

    public NovaLinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    public NovaLinearLayoutManager(Context context, int i, boolean z) {
        super(context, i, z);
        this.f10476b = new C4346a();
    }

    public void init(NovaRecyclerAdapter novaRecyclerAdapter) {
        this.f10476b.mo46297a((INovaLayoutManager) this, novaRecyclerAdapter);
    }

    public void release() {
        this.f10476b.mo46293a();
    }

    public void elevateHeaders(boolean z) {
        this.f10476b.mo46298a(z);
    }

    public void elevateHeaders(int i) {
        this.f10476b.mo46294a(i);
    }

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        super.onLayoutChildren(recycler, state);
        this.f10476b.mo46295a(recycler, state);
    }

    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int scrollVerticallyBy = super.scrollVerticallyBy(i, recycler, state);
        if (Math.abs(scrollVerticallyBy) > 0) {
            this.f10476b.mo46299b();
        }
        return scrollVerticallyBy;
    }

    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int scrollHorizontallyBy = super.scrollHorizontallyBy(i, recycler, state);
        if (Math.abs(scrollHorizontallyBy) > 0) {
            this.f10476b.mo46299b();
        }
        return scrollHorizontallyBy;
    }

    public void removeAndRecycleAllViews(RecyclerView.Recycler recycler) {
        super.removeAndRecycleAllViews(recycler);
        this.f10476b.mo46300c();
    }

    public void onAttachedToWindow(RecyclerView recyclerView) {
        this.f10476b.mo46296a(recyclerView);
        super.onAttachedToWindow(recyclerView);
    }

    public void setSmoothScroller(RecyclerView.SmoothScroller smoothScroller) {
        this.f10475a = smoothScroller;
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        RecyclerView.SmoothScroller smoothScroller = this.f10475a;
        if (smoothScroller == null) {
            super.smoothScrollToPosition(recyclerView, state, i);
            return;
        }
        smoothScroller.setTargetPosition(i);
        startSmoothScroll(this.f10475a);
    }
}
