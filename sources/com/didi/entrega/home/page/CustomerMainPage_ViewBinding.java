package com.didi.entrega.home.page;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.taxis99.R;

public class CustomerMainPage_ViewBinding implements Unbinder {

    /* renamed from: a */
    private CustomerMainPage f22566a;

    public CustomerMainPage_ViewBinding(CustomerMainPage customerMainPage, View view) {
        this.f22566a = customerMainPage;
        customerMainPage.mFeedContainer = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.entrega_fl_feed_container, "field 'mFeedContainer'", FrameLayout.class);
        customerMainPage.mMainPageContainer = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.entrega_rl_main_page_container, "field 'mMainPageContainer'", ViewGroup.class);
        customerMainPage.mHomeNoServiceContainer = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.entrega_fl_home_nonsuport_container, "field 'mHomeNoServiceContainer'", FrameLayout.class);
        customerMainPage.mNoAddressContianer = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.entrega_fl_no_address_container, "field 'mNoAddressContianer'", FrameLayout.class);
    }

    public void unbind() {
        CustomerMainPage customerMainPage = this.f22566a;
        if (customerMainPage != null) {
            this.f22566a = null;
            customerMainPage.mFeedContainer = null;
            customerMainPage.mMainPageContainer = null;
            customerMainPage.mHomeNoServiceContainer = null;
            customerMainPage.mNoAddressContianer = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
