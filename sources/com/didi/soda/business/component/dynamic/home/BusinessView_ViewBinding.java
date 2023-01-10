package com.didi.soda.business.component.dynamic.home;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView;
import com.didi.soda.business.widget.BusinessDyHomeHeaderView;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalView;
import com.didi.soda.home.shimmer.ShimmerRecyclerView;
import com.taxis99.R;

public class BusinessView_ViewBinding implements Unbinder {

    /* renamed from: a */
    private BusinessView f42182a;

    public BusinessView_ViewBinding(BusinessView businessView, View view) {
        this.f42182a = businessView;
        businessView.mCoordinatorLayout = (CoordinatorLayout) Utils.findRequiredViewAsType(view, R.id.customer_cl_business_menu_area, "field 'mCoordinatorLayout'", CoordinatorLayout.class);
        businessView.mBusinessHeaderView = (BusinessDyHomeHeaderView) Utils.findRequiredViewAsType(view, R.id.customer_view_business_home_header, "field 'mBusinessHeaderView'", BusinessDyHomeHeaderView.class);
        businessView.mRecyclerView = (NovaRecyclerView) Utils.findRequiredViewAsType(view, R.id.customer_custom_menu_rv, "field 'mRecyclerView'", NovaRecyclerView.class);
        businessView.mAbnormalView = (TopGunAbnormalView) Utils.findRequiredViewAsType(view, R.id.customer_custom_abnormal_view, "field 'mAbnormalView'", TopGunAbnormalView.class);
        businessView.mShimmerView = (ShimmerRecyclerView) Utils.findRequiredViewAsType(view, R.id.customer_custom_shimmer, "field 'mShimmerView'", ShimmerRecyclerView.class);
        businessView.mShimmerTitleBar = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.customer_cl_business_home_shimmer_title_container, "field 'mShimmerTitleBar'", ConstraintLayout.class);
    }

    public void unbind() {
        BusinessView businessView = this.f42182a;
        if (businessView != null) {
            this.f42182a = null;
            businessView.mCoordinatorLayout = null;
            businessView.mBusinessHeaderView = null;
            businessView.mRecyclerView = null;
            businessView.mAbnormalView = null;
            businessView.mShimmerView = null;
            businessView.mShimmerTitleBar = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
