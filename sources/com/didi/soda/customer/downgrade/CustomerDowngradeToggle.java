package com.didi.soda.customer.downgrade;

import com.didi.foundation.sdk.depsdowngrade.DowngradeToggle;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;

@ServiceProvider({DowngradeToggle.class})
public class CustomerDowngradeToggle implements DowngradeToggle {

    /* renamed from: a */
    private DowngradeStorage f43469a = new DowngradeStorage();

    public boolean toggle() {
        return this.f43469a.toggle();
    }

    public boolean isDowngradeMap() {
        return this.f43469a.isDowngradeMap();
    }

    public boolean isDowngradeNavigation() {
        return this.f43469a.isDowngradeNavigation();
    }

    public boolean isDowngradeIM() {
        return this.f43469a.isDowngradeIM();
    }

    public boolean isDowngradeShare() {
        return this.f43469a.isDowngradeShare();
    }

    public boolean isDowngradeFaceBookLogin() {
        return this.f43469a.isDowngradeFaceBookLogin();
    }

    public boolean isDowngradeGoogleLogin() {
        return this.f43469a.isDowngradeGoogleLogin();
    }
}
