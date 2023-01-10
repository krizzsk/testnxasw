package com.didi.soda.home.component.city;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView;
import com.didi.soda.customer.widget.titlebar.TitleBarView;
import com.taxis99.R;

public class HomeCityListView_ViewBinding implements Unbinder {

    /* renamed from: a */
    private HomeCityListView f45058a;

    public HomeCityListView_ViewBinding(HomeCityListView homeCityListView, View view) {
        this.f45058a = homeCityListView;
        homeCityListView.mTitleBarView = (TitleBarView) Utils.findRequiredViewAsType(view, R.id.customer_tbv_title_view, "field 'mTitleBarView'", TitleBarView.class);
        homeCityListView.mRecyclerView = (NovaRecyclerView) Utils.findRequiredViewAsType(view, R.id.customer_rv_city_list, "field 'mRecyclerView'", NovaRecyclerView.class);
    }

    public void unbind() {
        HomeCityListView homeCityListView = this.f45058a;
        if (homeCityListView != null) {
            this.f45058a = null;
            homeCityListView.mTitleBarView = null;
            homeCityListView.mRecyclerView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
