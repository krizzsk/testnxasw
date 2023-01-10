package com.didi.entrega.customer.downgrade;

import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.storage.CustomerStorage;
import com.didi.entrega.customer.foundation.util.CustomerApolloUtil;
import com.didi.foundation.sdk.depsdowngrade.DowngradeToggle;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.observer.OnCacheLoadedListener;
import com.didichuxing.apollo.sdk.observer.OnToggleStateChangeListener;

public class DowngradeStorage extends CustomerStorage<DowngradeConfig> implements DowngradeToggle {

    /* renamed from: a */
    private static final int f21737a = 1;

    /* renamed from: b */
    private static final String f21738b = "DowngradeStorage";

    /* renamed from: c */
    private DowngradeConfig f21739c;

    public boolean isDowngradeNavigation() {
        return false;
    }

    DowngradeStorage() {
        DowngradeConfig downgradeConfig = (DowngradeConfig) getData();
        this.f21739c = downgradeConfig;
        if (downgradeConfig == null) {
            this.f21739c = new DowngradeConfig();
        }
        LogUtil.m18185i(f21738b, "Read cached toggle mToggle = " + this.f21739c.mToggle + " mDowngradeMap = " + this.f21739c.mDowngradeMap + " mDowngradeIM = " + this.f21739c.mDowngradeIM + " mDowngradeFacebookLogin = " + this.f21739c.mDowngradeFacebookLogin + " mDowngradeShare = " + this.f21739c.mDowngradeShare + " mDowngradeGoogleLogin = " + this.f21739c.mDowngradeGoogleLogin);
        Apollo.addCacheLoadedListener(new OnCacheLoadedListener() {
            public final void onCacheAlreadyLoaded() {
                DowngradeStorage.this.m18139c();
            }
        });
        Apollo.addToggleStateChangeListener(new OnToggleStateChangeListener() {
            public final void onStateChanged() {
                DowngradeStorage.this.m18138b();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m18139c() {
        LogUtil.m18185i(f21738b, "onCacheAlreadyLoaded");
        m18136a();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m18138b() {
        LogUtil.m18185i(f21738b, "onStateChanged");
        m18136a();
    }

    /* renamed from: a */
    private void m18136a() {
        DowngradeConfig downGradeConfig = CustomerApolloUtil.getDownGradeConfig();
        LogUtil.m18185i(f21738b, "updateCachedApolloToggle mToggle = " + downGradeConfig.mToggle + " mDowngradeMap = " + downGradeConfig.mDowngradeMap + " mDowngradeIM = " + downGradeConfig.mDowngradeIM + " mDowngradeFacebookLogin = " + downGradeConfig.mDowngradeFacebookLogin + " mDowngradeShare = " + downGradeConfig.mDowngradeShare + " mDowngradeGoogleLogin = " + downGradeConfig.mDowngradeGoogleLogin);
        setData(downGradeConfig);
        m18137a(downGradeConfig);
    }

    /* renamed from: a */
    private void m18137a(DowngradeConfig downgradeConfig) {
        LogUtil.m18185i(f21738b, "updateMemoryCachedToggle data: " + downgradeConfig);
        if (downgradeConfig.mToggle == 1) {
            this.f21739c.mToggle = 1;
        }
        if (downgradeConfig.mDowngradeIM == 1) {
            this.f21739c.mDowngradeIM = 1;
        }
        if (downgradeConfig.mDowngradeMap == 1) {
            this.f21739c.mDowngradeMap = 1;
        }
        if (downgradeConfig.mDowngradeShare == 1) {
            this.f21739c.mDowngradeShare = 1;
        }
        if (downgradeConfig.mDowngradeFacebookLogin == 1) {
            this.f21739c.mDowngradeFacebookLogin = 1;
        }
        if (downgradeConfig.mDowngradeGoogleLogin == 1) {
            this.f21739c.mDowngradeGoogleLogin = 1;
        }
    }

    public boolean toggle() {
        return this.f21739c.mToggle == 1;
    }

    public boolean isDowngradeMap() {
        return this.f21739c.mDowngradeMap == 1;
    }

    public boolean isDowngradeIM() {
        return this.f21739c.mDowngradeIM == 1;
    }

    public boolean isDowngradeShare() {
        return this.f21739c.mDowngradeShare == 1;
    }

    public boolean isDowngradeFaceBookLogin() {
        return this.f21739c.mDowngradeFacebookLogin == 1;
    }

    public boolean isDowngradeGoogleLogin() {
        return this.f21739c.mDowngradeGoogleLogin == 1;
    }
}
