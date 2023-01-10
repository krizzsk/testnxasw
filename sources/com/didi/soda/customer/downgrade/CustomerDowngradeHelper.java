package com.didi.soda.customer.downgrade;

import com.didi.foundation.sdk.depsdowngrade.DependencyDowngradeToggle;
import com.didi.foundation.sdk.depsdowngrade.DowngradeToggle;

public final class CustomerDowngradeHelper {

    /* renamed from: a */
    private static DowngradeToggle f43468a = DependencyDowngradeToggle.getInstance();

    private CustomerDowngradeHelper() {
    }

    public static boolean isDowngradeMap() {
        return f43468a.isDowngradeMap();
    }

    public static boolean isDowngradeNavigation() {
        return f43468a.isDowngradeNavigation();
    }

    public static boolean isDowngradeIM() {
        return f43468a.isDowngradeIM();
    }

    public static boolean isDowngradeShare() {
        return f43468a.isDowngradeShare();
    }

    public static boolean isDowngradeFaceBookLogin() {
        return f43468a.isDowngradeFaceBookLogin();
    }

    public static boolean isDowngradeGoogleLogin() {
        return f43468a.isDowngradeGoogleLogin();
    }
}
