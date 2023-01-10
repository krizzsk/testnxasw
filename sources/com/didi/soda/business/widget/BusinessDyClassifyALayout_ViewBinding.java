package com.didi.soda.business.widget;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.didi.rfusion.widget.RFIconView;
import com.taxis99.R;

public class BusinessDyClassifyALayout_ViewBinding implements Unbinder {

    /* renamed from: a */
    private BusinessDyClassifyALayout f42371a;

    public BusinessDyClassifyALayout_ViewBinding(BusinessDyClassifyALayout businessDyClassifyALayout) {
        this(businessDyClassifyALayout, businessDyClassifyALayout);
    }

    public BusinessDyClassifyALayout_ViewBinding(BusinessDyClassifyALayout businessDyClassifyALayout, View view) {
        this.f42371a = businessDyClassifyALayout;
        businessDyClassifyALayout.mClassifyIcon = (RFIconView) Utils.findRequiredViewAsType(view, R.id.customer_iv_classify_menu, "field 'mClassifyIcon'", RFIconView.class);
        businessDyClassifyALayout.mClassifySearchIcon = (RFIconView) Utils.findRequiredViewAsType(view, R.id.customer_iv_business_classify_search, "field 'mClassifySearchIcon'", RFIconView.class);
        businessDyClassifyALayout.mClassifyTv = (TextView) Utils.findRequiredViewAsType(view, R.id.customer_tv_classify_menu, "field 'mClassifyTv'", TextView.class);
    }

    public void unbind() {
        BusinessDyClassifyALayout businessDyClassifyALayout = this.f42371a;
        if (businessDyClassifyALayout != null) {
            this.f42371a = null;
            businessDyClassifyALayout.mClassifyIcon = null;
            businessDyClassifyALayout.mClassifySearchIcon = null;
            businessDyClassifyALayout.mClassifyTv = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
