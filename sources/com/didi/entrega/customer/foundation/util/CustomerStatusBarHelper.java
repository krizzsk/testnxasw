package com.didi.entrega.customer.foundation.util;

import android.app.Activity;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.entrega.customer.app.GlobalContext;

public final class CustomerStatusBarHelper {

    /* renamed from: a */
    private static CustomerStatusBarHelper f21978a = new CustomerStatusBarHelper();

    /* renamed from: b */
    private Boolean f21979b;

    private CustomerStatusBarHelper() {
    }

    public static CustomerStatusBarHelper getHelper() {
        return f21978a;
    }

    public void resetState() {
        this.f21979b = null;
    }

    public void setStatusBarBgLightning(Activity activity, boolean z) {
        Boolean bool = this.f21979b;
        if (bool == null || bool.booleanValue() != z) {
            this.f21979b = Boolean.valueOf(z);
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
        return this.f21979b;
    }
}
