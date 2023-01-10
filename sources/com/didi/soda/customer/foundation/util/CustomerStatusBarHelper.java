package com.didi.soda.customer.foundation.util;

import android.app.Activity;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.soda.customer.app.GlobalContext;

public final class CustomerStatusBarHelper {

    /* renamed from: a */
    private static CustomerStatusBarHelper f43824a = new CustomerStatusBarHelper();

    /* renamed from: b */
    private Boolean f43825b;

    private CustomerStatusBarHelper() {
    }

    public static CustomerStatusBarHelper getHelper() {
        return f43824a;
    }

    public void resetState() {
        this.f43825b = null;
    }

    public void setStatusBarBgLightning(Activity activity, boolean z) {
        Boolean bool = this.f43825b;
        if (bool == null || bool.booleanValue() != z) {
            this.f43825b = Boolean.valueOf(z);
            if (!GlobalContext.isEmbed()) {
                StatusBarLightingCompat.setStatusBarBgLightning(activity, !z, 0);
            }
        }
    }

    public void setStatusBarBgLightningForThirdParty(Activity activity, boolean z, int i) {
        if (!GlobalContext.isEmbed()) {
            StatusBarLightingCompat.setStatusBarBgLightning(activity, !z, i);
        }
    }

    public Boolean getCurrentStatus() {
        return this.f43825b;
    }
}
