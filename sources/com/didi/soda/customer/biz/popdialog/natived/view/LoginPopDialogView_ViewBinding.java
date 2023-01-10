package com.didi.soda.customer.biz.popdialog.natived.view;

import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.taxis99.R;

public class LoginPopDialogView_ViewBinding implements Unbinder {

    /* renamed from: a */
    private LoginPopDialogView f43105a;

    public LoginPopDialogView_ViewBinding(LoginPopDialogView loginPopDialogView, View view) {
        this.f43105a = loginPopDialogView;
        loginPopDialogView.mRootView = Utils.findRequiredView(view, R.id.customer_ll_pop_root, "field 'mRootView'");
        loginPopDialogView.mPopImage = (ImageView) Utils.findRequiredViewAsType(view, R.id.customer_iv_pop_image, "field 'mPopImage'", ImageView.class);
        loginPopDialogView.mPopClose = (ImageView) Utils.findRequiredViewAsType(view, R.id.customer_iv_pop_close, "field 'mPopClose'", ImageView.class);
    }

    public void unbind() {
        LoginPopDialogView loginPopDialogView = this.f43105a;
        if (loginPopDialogView != null) {
            this.f43105a = null;
            loginPopDialogView.mRootView = null;
            loginPopDialogView.mPopImage = null;
            loginPopDialogView.mPopClose = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
