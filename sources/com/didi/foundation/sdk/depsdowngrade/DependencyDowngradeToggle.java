package com.didi.foundation.sdk.depsdowngrade;

import com.didichuxing.foundation.spi.ServiceLoader;

public final class DependencyDowngradeToggle implements DowngradeToggle {

    /* renamed from: b */
    private static final DependencyDowngradeToggle f23028b = new DependencyDowngradeToggle();

    /* renamed from: a */
    DowngradeToggle f23029a;

    public static DependencyDowngradeToggle getInstance() {
        return f23028b;
    }

    private DependencyDowngradeToggle() {
        DowngradeToggle downgradeToggle = (DowngradeToggle) ServiceLoader.load(DowngradeToggle.class).get();
        this.f23029a = downgradeToggle;
        if (downgradeToggle == null) {
            this.f23029a = new C8939a();
        }
    }

    public boolean toggle() {
        return this.f23029a.toggle();
    }

    public boolean isDowngradeMap() {
        return toggle() && this.f23029a.isDowngradeMap();
    }

    public boolean isDowngradeNavigation() {
        return toggle() && this.f23029a.isDowngradeNavigation();
    }

    public boolean isDowngradeIM() {
        return toggle() && this.f23029a.isDowngradeIM();
    }

    public boolean isDowngradeShare() {
        return toggle() && this.f23029a.isDowngradeShare();
    }

    public boolean isDowngradeFaceBookLogin() {
        return toggle() && this.f23029a.isDowngradeFaceBookLogin();
    }

    public boolean isDowngradeGoogleLogin() {
        return toggle() && this.f23029a.isDowngradeGoogleLogin();
    }
}
