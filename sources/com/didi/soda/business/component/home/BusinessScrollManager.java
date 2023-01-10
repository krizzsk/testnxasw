package com.didi.soda.business.component.home;

import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView;
import com.didi.app.nova.support.view.recyclerview.view.layoutmanager.NovaLinearLayoutManager;
import com.didi.soda.business.component.home.scroll.BusinessScrollerFactory;
import com.didi.soda.business.component.home.scroll.ScrollerFinishCallback;
import com.didi.soda.business.listener.BusinessViewBehaviorImpl;
import com.didi.soda.business.model.BusinessCategoryRvModel;
import didinet.Logger;
import java.util.Map;

public class BusinessScrollManager {

    /* renamed from: a */
    private static final String f42229a = "BusinessScrollManager";

    /* renamed from: b */
    private NovaRecyclerView f42230b;

    /* renamed from: c */
    private BusinessViewBehaviorImpl f42231c;

    /* renamed from: d */
    private NovaLinearLayoutManager f42232d;

    /* renamed from: e */
    private Map<String, BusinessCategoryRvModel> f42233e;

    /* renamed from: f */
    private int f42234f = 0;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f42235g = false;

    /* renamed from: h */
    private BusinessScrollerFactory f42236h = new BusinessScrollerFactory();

    public BusinessScrollManager(NovaRecyclerView novaRecyclerView) {
        this.f42230b = novaRecyclerView;
        this.f42232d = (NovaLinearLayoutManager) novaRecyclerView.getLayoutManager();
        this.f42230b.addOnScrollListener(new RecyclerView.OnScrollListener() {
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0) {
                    boolean unused = BusinessScrollManager.this.f42235g = false;
                }
            }

            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                if (!BusinessScrollManager.this.f42235g) {
                    BusinessScrollManager.this.m31748b();
                }
            }
        });
    }

    public void onTabSelected(int i) {
        if (i != this.f42234f) {
            m31744a(m31743a().getCategoryRvIndex(i), m31743a().getCategoryRvIndex(this.f42234f), (ScrollerFinishCallback) null);
            this.f42234f = i;
        }
    }

    public void scrollToAnchorView(int i, int i2, ScrollerFinishCallback scrollerFinishCallback) {
        m31745a("scrollToAnchorView cateIndex: " + i + ", position " + i2);
        m31744a(i2, 0, scrollerFinishCallback);
        this.f42234f = i;
    }

    public void setBusinessViewBehaviorImpl(BusinessViewBehaviorImpl businessViewBehaviorImpl) {
        this.f42231c = businessViewBehaviorImpl;
    }

    public void updateCategoryMap(Map<String, BusinessCategoryRvModel> map) {
        this.f42233e = map;
    }

    /* renamed from: a */
    private BusinessViewBehaviorImpl m31743a() {
        return this.f42231c;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m31748b() {
        int a = m31742a(this.f42232d.findFirstVisibleItemPosition());
        m31745a("current tab index: " + a + " is Scrolling:" + this.f42235g);
        if (this.f42234f != a && !this.f42235g) {
            m31743a().selectTab(a);
            this.f42234f = a;
        }
    }

    /* renamed from: a */
    private void m31744a(int i, int i2, ScrollerFinishCallback scrollerFinishCallback) {
        this.f42235g = true;
        m31745a("target pos: " + i);
        this.f42236h.getBusinessScroller(this.f42230b, Math.abs(i - i2)).scrollToPosition(i, scrollerFinishCallback);
    }

    /* renamed from: a */
    private int m31742a(int i) {
        Map<String, BusinessCategoryRvModel> map = this.f42233e;
        int i2 = 0;
        if (map != null && map.size() > 0) {
            int i3 = 0;
            for (BusinessCategoryRvModel next : this.f42233e.values()) {
                int size = next.getAllDisplayGoods().size() + next.getAllDyDisplayGoods().size();
                if (i2 != 0) {
                    size++;
                }
                if (next.mExpandRvModel != null) {
                    size++;
                }
                int i4 = (i3 + size) - 1;
                if (i - 1 <= i4) {
                    break;
                }
                i3 = i4 + 1;
                i2++;
            }
        }
        return i2;
    }

    /* renamed from: a */
    private void m31745a(String str) {
        Logger.m45047d(f42229a, str);
    }
}
