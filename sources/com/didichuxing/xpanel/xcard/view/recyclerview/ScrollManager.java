package com.didichuxing.xpanel.xcard.view.recyclerview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didichuxing.xpanel.util.Utils;
import com.didichuxing.xpanel.xcard.ICardListener;
import com.didichuxing.xpanel.xcard.XPanelCardDataHelper;
import java.util.ArrayList;
import java.util.HashMap;

public class ScrollManager {

    /* renamed from: b */
    private static final String f52277b = "ScrollManager";

    /* renamed from: a */
    ArrayList<SubCardData> f52278a;

    /* renamed from: c */
    private XPanelHorizontalRecyclerView f52279c;

    /* renamed from: d */
    private LinearLayoutManager f52280d;

    /* renamed from: e */
    private int f52281e;

    /* renamed from: f */
    private int f52282f = 0;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f52283g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f52284h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f52285i = 0;

    /* renamed from: j */
    private Context f52286j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public XPanelCardDataHelper f52287k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public ICardListener f52288l;

    public ScrollManager(XPanelHorizontalRecyclerView xPanelHorizontalRecyclerView, Context context, LinearLayoutManager linearLayoutManager) {
        this.f52279c = xPanelHorizontalRecyclerView;
        this.f52286j = context;
        this.f52280d = linearLayoutManager;
        this.f52278a = xPanelHorizontalRecyclerView.myRecylerAdapter.f52268a;
        this.f52281e = Utils.dip2px(context, 30.0f);
    }

    public void initScrollListener() {
        this.f52279c.addOnScrollListener(new GalleryScrollerListener());
    }

    public void setCardDataHelper(XPanelCardDataHelper xPanelCardDataHelper) {
        this.f52287k = xPanelCardDataHelper;
    }

    public void setXCardListener(ICardListener iCardListener) {
        this.f52288l = iCardListener;
    }

    class GalleryScrollerListener extends RecyclerView.OnScrollListener {
        GalleryScrollerListener() {
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i != 0) {
                return;
            }
            if (ScrollManager.this.f52287k != null) {
                ScrollManager.this.f52287k.scrollCardOmega();
            } else if (ScrollManager.this.f52288l != null) {
                ScrollManager.this.f52288l.handleEvent("xpanel_card_scroll", (HashMap<String, Object>) null);
            }
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            ScrollManager.this.checkScrollX();
        }
    }

    public void checkScrollX() {
        int findFirstVisibleItemPosition = this.f52280d.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = this.f52280d.findLastVisibleItemPosition();
        try {
            int measuredWidth = this.f52279c.getMeasuredWidth();
            for (int i = 0; i < this.f52278a.size(); i++) {
                SubCardData subCardData = this.f52278a.get(i);
                if (i < findFirstVisibleItemPosition || i > findLastVisibleItemPosition) {
                    subCardData.moveOut();
                } else {
                    View childAt = this.f52280d.getChildAt(i - findFirstVisibleItemPosition);
                    int left = measuredWidth - childAt.getLeft();
                    if (childAt.getRight() < this.f52281e) {
                        if (left <= this.f52281e) {
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
        if (this.f52278a != null) {
            for (int i = 0; i < this.f52278a.size(); i++) {
                this.f52278a.get(i).moveOut();
            }
        }
    }

    /* renamed from: a */
    private void m39319a(final RecyclerView recyclerView, int i) {
        this.f52285i += i;
        if (this.f52283g == 0) {
            this.f52283g = recyclerView.getMeasuredWidth();
        }
        ((ViewGroup) recyclerView.getParent()).getMeasuredWidth();
        recyclerView.post(new Runnable() {
            public void run() {
                if (ScrollManager.this.f52284h == 0 && recyclerView.getLayoutManager().getChildCount() > 0) {
                    int unused = ScrollManager.this.f52284h = recyclerView.getLayoutManager().getChildAt(0).getMeasuredWidth();
                }
                if (ScrollManager.this.f52284h != 0) {
                    ScrollManager scrollManager = ScrollManager.this;
                    int a = scrollManager.m39315a(scrollManager.f52285i, ScrollManager.this.f52284h);
                    float c = ((float) ((ScrollManager.this.f52284h * a) - ScrollManager.this.f52285i)) / ((float) ScrollManager.this.f52284h);
                    float f = c < 0.0f ? 0.0f : c;
                    int i = a + 1;
                    float c2 = ((float) ((ScrollManager.this.f52284h * i) - ScrollManager.this.f52285i)) / ((float) ScrollManager.this.f52284h);
                    float f2 = c2 > 1.0f ? 1.0f : c2;
                    float e = ((float) ((ScrollManager.this.f52283g + ScrollManager.this.f52285i) - (i * ScrollManager.this.f52284h))) / ((float) ScrollManager.this.f52284h);
                    AnimManager.getInstance().setAlpha(1.0f);
                    AnimManager.getInstance().setAnim(recyclerView, a, f, f2, e);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m39315a(int i, int i2) {
        return ((i + this.f52283g) / i2) - 1;
    }

    public int getPosition() {
        return this.f52282f;
    }
}
