package com.didi.global.xbanner.view.recycler;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class XBannerOnScrollListener extends RecyclerView.OnScrollListener {

    /* renamed from: a */
    private XBannerScrollChangedListener f24872a;

    /* renamed from: b */
    private int f24873b = 0;

    /* renamed from: c */
    private int f24874c = 0;

    public void setScrollChangedListener(XBannerScrollChangedListener xBannerScrollChangedListener) {
        this.f24872a = xBannerScrollChangedListener;
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        super.onScrollStateChanged(recyclerView, i);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (i == 0 && (layoutManager instanceof LinearLayoutManager)) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
            int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            int i2 = -1;
            Rect rect = new Rect();
            View findViewByPosition = layoutManager.findViewByPosition(findFirstVisibleItemPosition);
            if (findViewByPosition != null) {
                findViewByPosition.getLocalVisibleRect(rect);
                i2 = rect.right - rect.left == findViewByPosition.getMeasuredWidth() ? findFirstVisibleItemPosition : findLastVisibleItemPosition;
            }
            if (findFirstVisibleItemPosition != this.f24873b || i2 != this.f24874c) {
                this.f24873b = findFirstVisibleItemPosition;
                this.f24874c = i2;
                XBannerScrollChangedListener xBannerScrollChangedListener = this.f24872a;
                if (xBannerScrollChangedListener != null) {
                    xBannerScrollChangedListener.onScrollChanged(findFirstVisibleItemPosition, findLastVisibleItemPosition, i2);
                }
            }
        }
    }

    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        super.onScrolled(recyclerView, i, i2);
    }
}
