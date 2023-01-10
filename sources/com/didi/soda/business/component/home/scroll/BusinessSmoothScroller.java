package com.didi.soda.business.component.home.scroll;

import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.support.view.recyclerview.view.layoutmanager.NovaLinearLayoutManager;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.widget.scroll.CustomerSmoothScroller;
import com.didi.soda.customer.widget.scroll.SmoothScrollListener;

public class BusinessSmoothScroller implements IScroller {

    /* renamed from: a */
    private static final String f42242a = "BusinessSmoothScroller";

    /* renamed from: b */
    private RecyclerView f42243b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public CustomerSmoothScroller f42244c;

    public BusinessSmoothScroller(RecyclerView recyclerView) {
        this.f42243b = recyclerView;
        CustomerSmoothScroller customerSmoothScroller = new CustomerSmoothScroller(this.f42243b.getContext());
        this.f42244c = customerSmoothScroller;
        customerSmoothScroller.setOrientation(1);
        ((NovaLinearLayoutManager) recyclerView.getLayoutManager()).setSmoothScroller(this.f42244c);
        this.f42244c.setOffset(SCROLL_OFFSET);
    }

    public void scrollToPosition(int i, final ScrollerFinishCallback scrollerFinishCallback) {
        LogUtil.m32588i(f42242a, "smooth scroll start");
        this.f42244c.setSmoothScrollListener(new SmoothScrollListener() {
            public /* synthetic */ void onStart() {
                SmoothScrollListener.CC.$default$onStart(this);
            }

            public void onStop() {
                LogUtil.m32588i(BusinessSmoothScroller.f42242a, "smooth scroll end");
                ScrollerFinishCallback scrollerFinishCallback = scrollerFinishCallback;
                if (scrollerFinishCallback != null) {
                    scrollerFinishCallback.onScrollFinished();
                }
                BusinessSmoothScroller.this.f42244c.setSmoothScrollListener((SmoothScrollListener) null);
            }
        });
        this.f42243b.smoothScrollToPosition(i);
    }
}
