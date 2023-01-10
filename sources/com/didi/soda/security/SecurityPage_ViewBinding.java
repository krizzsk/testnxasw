package com.didi.soda.security;

import android.view.View;
import android.widget.FrameLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.taxis99.R;

public class SecurityPage_ViewBinding implements Unbinder {

    /* renamed from: a */
    private SecurityPage f46369a;

    public SecurityPage_ViewBinding(SecurityPage securityPage, View view) {
        this.f46369a = securityPage;
        securityPage.mContainer = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.customer_fl_security_container, "field 'mContainer'", FrameLayout.class);
    }

    public void unbind() {
        SecurityPage securityPage = this.f46369a;
        if (securityPage != null) {
            this.f46369a = null;
            securityPage.mContainer = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
