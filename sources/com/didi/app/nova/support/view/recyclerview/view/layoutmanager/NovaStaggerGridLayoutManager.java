package com.didi.app.nova.support.view.recyclerview.view.layoutmanager;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.didi.app.nova.support.view.recyclerview.adapter.NovaRecyclerAdapter;

public class NovaStaggerGridLayoutManager extends StaggeredGridLayoutManager implements INovaLayoutManager {

    /* renamed from: a */
    private RecyclerView.SmoothScroller f10477a;

    /* renamed from: b */
    private C4346a f10478b = new C4346a();

    public NovaStaggerGridLayoutManager(int i, int i2) {
        super(i, i2);
    }

    public void init(NovaRecyclerAdapter novaRecyclerAdapter) {
        this.f10478b.mo46297a((INovaLayoutManager) this, novaRecyclerAdapter);
    }

    public void release() {
        this.f10478b.mo46293a();
    }

    public void setSmoothScroller(RecyclerView.SmoothScroller smoothScroller) {
        this.f10477a = smoothScroller;
    }

    public int findFirstVisibleItemPosition() {
        int spanCount = getSpanCount();
        if (spanCount <= 0) {
            return 0;
        }
        int[] iArr = new int[spanCount];
        findFirstVisibleItemPositions(iArr);
        int i = iArr[0];
        for (int i2 = 0; i2 < spanCount; i2++) {
            if (iArr[i2] < i) {
                i = iArr[i2];
            }
        }
        return i;
    }

    public int findFirstCompletelyVisibleItemPosition() {
        int spanCount = getSpanCount();
        if (spanCount <= 0) {
            return 0;
        }
        int[] iArr = new int[spanCount];
        findFirstCompletelyVisibleItemPositions(iArr);
        int i = iArr[0];
        for (int i2 = 0; i2 < spanCount; i2++) {
            if (iArr[i2] < i) {
                i = iArr[i2];
            }
        }
        return i;
    }

    public int findLastVisibleItemPosition() {
        int spanCount = getSpanCount();
        if (spanCount <= 0) {
            return 0;
        }
        int[] iArr = new int[spanCount];
        findLastVisibleItemPositions(iArr);
        int i = iArr[0];
        for (int i2 = 0; i2 < spanCount; i2++) {
            if (iArr[i2] > i) {
                i = iArr[i2];
            }
        }
        return i;
    }

    public void elevateHeaders(boolean z) {
        this.f10478b.mo46298a(z);
    }

    public void elevateHeaders(int i) {
        this.f10478b.mo46294a(i);
    }

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        super.onLayoutChildren(recycler, state);
        this.f10478b.mo46295a(recycler, state);
    }

    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int scrollVerticallyBy = super.scrollVerticallyBy(i, recycler, state);
        if (Math.abs(scrollVerticallyBy) > 0) {
            this.f10478b.mo46299b();
        }
        return scrollVerticallyBy;
    }

    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int scrollHorizontallyBy = super.scrollHorizontallyBy(i, recycler, state);
        if (Math.abs(scrollHorizontallyBy) > 0) {
            this.f10478b.mo46299b();
        }
        return scrollHorizontallyBy;
    }

    public void removeAndRecycleAllViews(RecyclerView.Recycler recycler) {
        super.removeAndRecycleAllViews(recycler);
        this.f10478b.mo46300c();
    }

    public void onAttachedToWindow(RecyclerView recyclerView) {
        this.f10478b.mo46296a(recyclerView);
        super.onAttachedToWindow(recyclerView);
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        RecyclerView.SmoothScroller smoothScroller = this.f10477a;
        if (smoothScroller == null) {
            super.smoothScrollToPosition(recyclerView, state, i);
            return;
        }
        smoothScroller.setTargetPosition(i);
        startSmoothScroll(this.f10477a);
    }
}
