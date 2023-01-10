package com.didi.entrega.customer.downgrade;

import com.didi.foundation.sdk.depsdowngrade.DependencyDowngradeToggle;
import com.didi.foundation.sdk.depsdowngrade.DowngradeToggle;

public final class CustomerDowngradeHelper {

    /* renamed from: a */
    private static DowngradeToggle f21735a = DependencyDowngradeToggle.getInstance();

    private CustomerDowngradeHelper() {
    }

    public static boolean isDowngradeMap() {
        return f21735a.isDowngradeMap();
    }

    public static boolean isDowngradeNavigation() {
        return f21735a.isDowngradeNavigation();
    }

    public static boolean isDowngradeIM() {
        return f21735a.isDowngradeIM();
    }

    public static boolean isDowngradeShare() {
        return f21735a.isDowngradeShare();
    }

    public static boolean isDowngradeFaceBookLogin() {
        return f21735a.isDowngradeFaceBookLogin();
    }

    public static boolean isDowngradeGoogleLogin() {
        return f21735a.isDowngradeGoogleLogin();
    }
}
