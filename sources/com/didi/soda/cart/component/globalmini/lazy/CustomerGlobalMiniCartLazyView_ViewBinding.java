package com.didi.soda.cart.component.globalmini.lazy;

import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.didi.rfusion.widget.button.RFMainButton;
import com.didi.soda.customer.widget.text.RichTextView;
import com.taxis99.R;

public class CustomerGlobalMiniCartLazyView_ViewBinding implements Unbinder {

    /* renamed from: a */
    private CustomerGlobalMiniCartLazyView f42564a;

    public CustomerGlobalMiniCartLazyView_ViewBinding(CustomerGlobalMiniCartLazyView customerGlobalMiniCartLazyView, View view) {
        this.f42564a = customerGlobalMiniCartLazyView;
        customerGlobalMiniCartLazyView.mButton = (RFMainButton) Utils.findRequiredViewAsType(view, R.id.customer_custom_mini_cart_content, "field 'mButton'", RFMainButton.class);
        customerGlobalMiniCartLazyView.mOfferPassParent = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.customer_cl_offer_pass_parent, "field 'mOfferPassParent'", ConstraintLayout.class);
        customerGlobalMiniCartLazyView.mOfferPassText = (RichTextView) Utils.findRequiredViewAsType(view, R.id.customer_custom_offer_pass, "field 'mOfferPassText'", RichTextView.class);
        customerGlobalMiniCartLazyView.mContainer = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.customer_custom_mini_cart_container, "field 'mContainer'", FrameLayout.class);
    }

    public void unbind() {
        CustomerGlobalMiniCartLazyView customerGlobalMiniCartLazyView = this.f42564a;
        if (customerGlobalMiniCartLazyView != null) {
            this.f42564a = null;
            customerGlobalMiniCartLazyView.mButton = null;
            customerGlobalMiniCartLazyView.mOfferPassParent = null;
            customerGlobalMiniCartLazyView.mOfferPassText = null;
            customerGlobalMiniCartLazyView.mContainer = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
