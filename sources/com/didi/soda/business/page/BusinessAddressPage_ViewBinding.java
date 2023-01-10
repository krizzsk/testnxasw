package com.didi.soda.business.page;

import android.view.View;
import android.widget.FrameLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.taxis99.R;

public class BusinessAddressPage_ViewBinding implements Unbinder {

    /* renamed from: a */
    private BusinessAddressPage f42321a;

    public BusinessAddressPage_ViewBinding(BusinessAddressPage businessAddressPage, View view) {
        this.f42321a = businessAddressPage;
        businessAddressPage.mBusinessDetailContainer = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.customer_fl_business_detail_container, "field 'mBusinessDetailContainer'", FrameLayout.class);
    }

    public void unbind() {
        BusinessAddressPage businessAddressPage = this.f42321a;
        if (businessAddressPage != null) {
            this.f42321a = null;
            businessAddressPage.mBusinessDetailContainer = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
