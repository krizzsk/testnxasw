package com.didi.soda.business.component.home.scroll;

import androidx.recyclerview.widget.RecyclerView;

public class BusinessScrollerFactory {

    /* renamed from: a */
    private BusinessSmoothScroller f42240a;

    /* renamed from: b */
    private BusinessFastScroller f42241b;

    public IScroller getBusinessScroller(RecyclerView recyclerView, int i) {
        if (Math.abs(i) <= 30) {
            if (this.f42240a == null) {
                this.f42240a = new BusinessSmoothScroller(recyclerView);
            }
            return this.f42240a;
        }
        if (this.f42241b == null) {
            this.f42241b = new BusinessFastScroller(recyclerView);
        }
        return this.f42241b;
    }
}
