package com.didi.soda.business.component.home.scroll;

import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.soda.customer.foundation.log.util.LogUtil;

public class BusinessFastScroller implements IScroller {

    /* renamed from: a */
    private static final String f42237a = "BusinessFastScroller";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public RecyclerView f42238b;

    /* renamed from: c */
    private LinearLayoutManager f42239c;

    public BusinessFastScroller(RecyclerView recyclerView) {
        this.f42238b = recyclerView;
        this.f42239c = (LinearLayoutManager) recyclerView.getLayoutManager();
    }

    public void scrollToPosition(int i, final ScrollerFinishCallback scrollerFinishCallback) {
        LogUtil.m32588i(f42237a, "fast scroll start");
        this.f42239c.scrollToPositionWithOffset(i, SCROLL_OFFSET);
        this.f42238b.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                LogUtil.m32588i(BusinessFastScroller.f42237a, "fast scroll end");
                ScrollerFinishCallback scrollerFinishCallback = scrollerFinishCallback;
                if (scrollerFinishCallback != null) {
                    scrollerFinishCallback.onScrollFinished();
                }
                BusinessFastScroller.this.f42238b.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }
}
