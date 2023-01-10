package com.didi.soda.order.page;

import android.view.View;
import android.widget.FrameLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.taxis99.R;

public class EditTipsPage_ViewBinding implements Unbinder {

    /* renamed from: a */
    private EditTipsPage f46080a;

    public EditTipsPage_ViewBinding(EditTipsPage editTipsPage, View view) {
        this.f46080a = editTipsPage;
        editTipsPage.mCartContainer = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.customer_fl_cart_container, "field 'mCartContainer'", FrameLayout.class);
    }

    public void unbind() {
        EditTipsPage editTipsPage = this.f46080a;
        if (editTipsPage != null) {
            this.f46080a = null;
            editTipsPage.mCartContainer = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
