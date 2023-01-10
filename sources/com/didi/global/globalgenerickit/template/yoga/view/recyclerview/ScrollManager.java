package com.didi.global.globalgenerickit.template.yoga.view.recyclerview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.global.globalgenerickit.helper.KitHelper;
import com.didi.global.globalgenerickit.template.yoga.EventListener;
import java.util.ArrayList;

public class ScrollManager {

    /* renamed from: b */
    private static final String f24231b = "ScrollManager";

    /* renamed from: a */
    ArrayList<SubCardData> f24232a;

    /* renamed from: c */
    private XPanelHorizontalRecyclerView f24233c;

    /* renamed from: d */
    private LinearLayoutManager f24234d;

    /* renamed from: e */
    private int f24235e;

    /* renamed from: f */
    private int f24236f = 0;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f24237g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f24238h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f24239i = 0;

    /* renamed from: j */
    private Context f24240j;

    /* renamed from: k */
    private EventListener f24241k;

    public ScrollManager(XPanelHorizontalRecyclerView xPanelHorizontalRecyclerView, Context context, LinearLayoutManager linearLayoutManager) {
        this.f24233c = xPanelHorizontalRecyclerView;
        this.f24240j = context;
        this.f24234d = linearLayoutManager;
        this.f24232a = xPanelHorizontalRecyclerView.myRecylerAdapter.f24223a;
        this.f24235e = KitHelper.dip2px(context, 30.0f);
    }

    public void initScrollListener() {
        this.f24233c.addOnScrollListener(new GalleryScrollerListener());
    }

    public void setXCardListener(EventListener eventListener) {
        this.f24241k = eventListener;
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
        int findFirstVisibleItemPosition = this.f24234d.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = this.f24234d.findLastVisibleItemPosition();
        try {
            int measuredWidth = this.f24233c.getMeasuredWidth();
            for (int i = 0; i < this.f24232a.size(); i++) {
                SubCardData subCardData = this.f24232a.get(i);
                if (i < findFirstVisibleItemPosition || i > findLastVisibleItemPosition) {
                    subCardData.moveOut();
                } else {
                    View childAt = this.f24234d.getChildAt(i - findFirstVisibleItemPosition);
                    int left = measuredWidth - childAt.getLeft();
                    if (childAt.getRight() < this.f24235e) {
                        if (left <= this.f24235e) {
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
        if (this.f24232a != null) {
            for (int i = 0; i < this.f24232a.size(); i++) {
                this.f24232a.get(i).moveOut();
            }
        }
    }

    /* renamed from: a */
    private void m19523a(final RecyclerView recyclerView, int i) {
        this.f24239i += i;
        if (this.f24237g == 0) {
            this.f24237g = recyclerView.getMeasuredWidth();
        }
        ((ViewGroup) recyclerView.getParent()).getMeasuredWidth();
        recyclerView.post(new Runnable() {
            public void run() {
                if (ScrollManager.this.f24238h == 0 && recyclerView.getLayoutManager().getChildCount() > 0) {
                    int unused = ScrollManager.this.f24238h = recyclerView.getLayoutManager().getChildAt(0).getMeasuredWidth();
                }
                if (ScrollManager.this.f24238h != 0) {
                    ScrollManager scrollManager = ScrollManager.this;
                    int a = scrollManager.m19519a(scrollManager.f24239i, ScrollManager.this.f24238h);
                    float a2 = ((float) ((ScrollManager.this.f24238h * a) - ScrollManager.this.f24239i)) / ((float) ScrollManager.this.f24238h);
                    float f = a2 < 0.0f ? 0.0f : a2;
                    int i = a + 1;
                    float a3 = ((float) ((ScrollManager.this.f24238h * i) - ScrollManager.this.f24239i)) / ((float) ScrollManager.this.f24238h);
                    float f2 = a3 > 1.0f ? 1.0f : a3;
                    float c = ((float) ((ScrollManager.this.f24237g + ScrollManager.this.f24239i) - (i * ScrollManager.this.f24238h))) / ((float) ScrollManager.this.f24238h);
                    AnimManager.getInstance().setAlpha(1.0f);
                    AnimManager.getInstance().setAnim(recyclerView, a, f, f2, c);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m19519a(int i, int i2) {
        return ((i + this.f24237g) / i2) - 1;
    }

    public int getPosition() {
        return this.f24236f;
    }
}
