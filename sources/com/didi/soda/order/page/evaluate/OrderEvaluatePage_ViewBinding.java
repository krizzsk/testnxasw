package com.didi.soda.order.page.evaluate;

import android.view.View;
import android.widget.FrameLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.taxis99.R;

public class OrderEvaluatePage_ViewBinding implements Unbinder {

    /* renamed from: a */
    private OrderEvaluatePage f46086a;

    public OrderEvaluatePage_ViewBinding(OrderEvaluatePage orderEvaluatePage, View view) {
        this.f46086a = orderEvaluatePage;
        orderEvaluatePage.mEvaluateContainer = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.customer_fl_order_evaluate_container, "field 'mEvaluateContainer'", FrameLayout.class);
    }

    public void unbind() {
        OrderEvaluatePage orderEvaluatePage = this.f46086a;
        if (orderEvaluatePage != null) {
            this.f46086a = null;
            orderEvaluatePage.mEvaluateContainer = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
