package com.didi.entrega.customer.downgrade;

import com.didi.foundation.sdk.depsdowngrade.DowngradeToggle;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;

@ServiceProvider({DowngradeToggle.class})
public class CustomerDowngradeToggle implements DowngradeToggle {

    /* renamed from: a */
    private DowngradeStorage f21736a = new DowngradeStorage();

    public boolean toggle() {
        return this.f21736a.toggle();
    }

    public boolean isDowngradeMap() {
        return this.f21736a.isDowngradeMap();
    }

    public boolean isDowngradeNavigation() {
        return this.f21736a.isDowngradeNavigation();
    }

    public boolean isDowngradeIM() {
        return this.f21736a.isDowngradeIM();
    }

    public boolean isDowngradeShare() {
        return this.f21736a.isDowngradeShare();
    }

    public boolean isDowngradeFaceBookLogin() {
        return this.f21736a.isDowngradeFaceBookLogin();
    }

    public boolean isDowngradeGoogleLogin() {
        return this.f21736a.isDowngradeGoogleLogin();
    }
}
