package com.didiglobal.dittoview.view.recyclerview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didiglobal.dittoview.DittoEventListener;
import com.didiglobal.dittoview.util.DittoUtil;
import java.util.ArrayList;

public class ScrollManager {

    /* renamed from: b */
    private static final String f52570b = "ScrollManager";

    /* renamed from: a */
    ArrayList<SubCardData> f52571a;

    /* renamed from: c */
    private DittoRecyclerView f52572c;

    /* renamed from: d */
    private LinearLayoutManager f52573d;

    /* renamed from: e */
    private int f52574e;

    /* renamed from: f */
    private int f52575f = 0;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f52576g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f52577h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f52578i = 0;

    /* renamed from: j */
    private Context f52579j;

    /* renamed from: k */
    private DittoEventListener f52580k;

    public ScrollManager(DittoRecyclerView dittoRecyclerView, Context context, LinearLayoutManager linearLayoutManager) {
        this.f52572c = dittoRecyclerView;
        this.f52579j = context;
        this.f52573d = linearLayoutManager;
        this.f52571a = dittoRecyclerView.dittoRecyclerAdapter.f52561a;
        this.f52574e = DittoUtil.dip2px(context, 30.0f);
    }

    public void initScrollListener() {
        this.f52572c.addOnScrollListener(new GalleryScrollerListener());
    }

    public void setXCardListener(DittoEventListener dittoEventListener) {
        this.f52580k = dittoEventListener;
    }

    class GalleryScrollerListener extends RecyclerView.OnScrollListener {
        GalleryScrollerListener() {
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            ScrollManager.this.checkScrollX();
        }
    }

    public void checkScrollX() {
        int findFirstVisibleItemPosition = this.f52573d.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = this.f52573d.findLastVisibleItemPosition();
        try {
            int measuredWidth = this.f52572c.getMeasuredWidth();
            for (int i = 0; i < this.f52571a.size(); i++) {
                SubCardData subCardData = this.f52571a.get(i);
                if (i < findFirstVisibleItemPosition || i > findLastVisibleItemPosition) {
                    subCardData.moveOut();
                } else {
                    View childAt = this.f52573d.getChildAt(i - findFirstVisibleItemPosition);
                    int left = measuredWidth - childAt.getLeft();
                    if (childAt.getRight() < this.f52574e) {
                        if (left <= this.f52574e) {
                            subCardData.moveOut();
                        }
                    }
                    subCardData.moveIn();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void pauseStatus() {
        if (this.f52571a != null) {
            for (int i = 0; i < this.f52571a.size(); i++) {
                this.f52571a.get(i).moveOut();
            }
        }
    }

    /* renamed from: a */
    private void m39460a(final RecyclerView recyclerView, int i) {
        this.f52578i += i;
        if (this.f52576g == 0) {
            this.f52576g = recyclerView.getMeasuredWidth();
        }
        ((ViewGroup) recyclerView.getParent()).getMeasuredWidth();
        recyclerView.post(new Runnable() {
            public void run() {
                if (ScrollManager.this.f52577h == 0 && recyclerView.getLayoutManager().getChildCount() > 0) {
                    int unused = ScrollManager.this.f52577h = recyclerView.getLayoutManager().getChildAt(0).getMeasuredWidth();
                }
                if (ScrollManager.this.f52577h != 0) {
                    ScrollManager scrollManager = ScrollManager.this;
                    int a = scrollManager.m39456a(scrollManager.f52578i, ScrollManager.this.f52577h);
                    float a2 = ((float) ((ScrollManager.this.f52577h * a) - ScrollManager.this.f52578i)) / ((float) ScrollManager.this.f52577h);
                    float f = a2 < 0.0f ? 0.0f : a2;
                    int i = a + 1;
                    float a3 = ((float) ((ScrollManager.this.f52577h * i) - ScrollManager.this.f52578i)) / ((float) ScrollManager.this.f52577h);
                    float f2 = a3 > 1.0f ? 1.0f : a3;
                    float c = ((float) ((ScrollManager.this.f52576g + ScrollManager.this.f52578i) - (i * ScrollManager.this.f52577h))) / ((float) ScrollManager.this.f52577h);
                    AnimManager.getInstance().setAlpha(1.0f);
                    AnimManager.getInstance().setAnim(recyclerView, a, f, f2, c);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m39456a(int i, int i2) {
        return ((i + this.f52576g) / i2) - 1;
    }

    public int getPosition() {
        return this.f52575f;
    }
}
