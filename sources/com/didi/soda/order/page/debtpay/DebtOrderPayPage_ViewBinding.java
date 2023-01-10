package com.didi.soda.order.page.debtpay;

import android.view.View;
import android.widget.FrameLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.taxis99.R;

public class DebtOrderPayPage_ViewBinding implements Unbinder {

    /* renamed from: a */
    private DebtOrderPayPage f46084a;

    public DebtOrderPayPage_ViewBinding(DebtOrderPayPage debtOrderPayPage, View view) {
        this.f46084a = debtOrderPayPage;
        debtOrderPayPage.mPayInfoContainer = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.customer_fl_pay_info_container, "field 'mPayInfoContainer'", FrameLayout.class);
    }

    public void unbind() {
        DebtOrderPayPage debtOrderPayPage = this.f46084a;
        if (debtOrderPayPage != null) {
            this.f46084a = null;
            debtOrderPayPage.mPayInfoContainer = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
