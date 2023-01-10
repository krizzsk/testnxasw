package com.didi.soda.customer.downgrade;

import com.didi.foundation.sdk.depsdowngrade.DowngradeToggle;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.storage.CustomerStorage;
import com.didi.soda.customer.foundation.util.CustomerApolloUtil;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.observer.OnCacheLoadedListener;
import com.didichuxing.apollo.sdk.observer.OnToggleStateChangeListener;

public class DowngradeStorage extends CustomerStorage<DowngradeConfig> implements DowngradeToggle {

    /* renamed from: a */
    private static final int f43470a = 1;

    /* renamed from: b */
    private static final String f43471b = "DowngradeStorage";

    /* renamed from: c */
    private DowngradeConfig f43472c;

    public boolean isDowngradeNavigation() {
        return false;
    }

    DowngradeStorage() {
        DowngradeConfig downgradeConfig = (DowngradeConfig) getData();
        this.f43472c = downgradeConfig;
        if (downgradeConfig == null) {
            this.f43472c = new DowngradeConfig();
        }
        LogUtil.m32588i(f43471b, "Read cached toggle mToggle = " + this.f43472c.mToggle + " mDowngradeMap = " + this.f43472c.mDowngradeMap + " mDowngradeIM = " + this.f43472c.mDowngradeIM + " mDowngradeFacebookLogin = " + this.f43472c.mDowngradeFacebookLogin + " mDowngradeShare = " + this.f43472c.mDowngradeShare + " mDowngradeGoogleLogin = " + this.f43472c.mDowngradeGoogleLogin);
        Apollo.addCacheLoadedListener(new OnCacheLoadedListener() {
            public final void onCacheAlreadyLoaded() {
                DowngradeStorage.this.m32532c();
            }
        });
        Apollo.addToggleStateChangeListener(new OnToggleStateChangeListener() {
            public final void onStateChanged() {
                DowngradeStorage.this.m32531b();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m32532c() {
        LogUtil.m32588i(f43471b, "onCacheAlreadyLoaded");
        m32529a();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m32531b() {
        LogUtil.m32588i(f43471b, "onStateChanged");
        m32529a();
    }

    /* renamed from: a */
    private void m32529a() {
        DowngradeConfig downGradeConfig = CustomerApolloUtil.getDownGradeConfig();
        LogUtil.m32588i(f43471b, "updateCachedApolloToggle mToggle = " + downGradeConfig.mToggle + " mDowngradeMap = " + downGradeConfig.mDowngradeMap + " mDowngradeIM = " + downGradeConfig.mDowngradeIM + " mDowngradeFacebookLogin = " + downGradeConfig.mDowngradeFacebookLogin + " mDowngradeShare = " + downGradeConfig.mDowngradeShare + " mDowngradeGoogleLogin = " + downGradeConfig.mDowngradeGoogleLogin);
        setData(downGradeConfig);
        m32530a(downGradeConfig);
    }

    /* renamed from: a */
    private void m32530a(DowngradeConfig downgradeConfig) {
        LogUtil.m32588i(f43471b, "updateMemoryCachedToggle data: " + downgradeConfig);
        if (downgradeConfig.mToggle == 1) {
            this.f43472c.mToggle = 1;
        }
        if (downgradeConfig.mDowngradeIM == 1) {
            this.f43472c.mDowngradeIM = 1;
        }
        if (downgradeConfig.mDowngradeMap == 1) {
            this.f43472c.mDowngradeMap = 1;
        }
        if (downgradeConfig.mDowngradeShare == 1) {
            this.f43472c.mDowngradeShare = 1;
        }
        if (downgradeConfig.mDowngradeFacebookLogin == 1) {
            this.f43472c.mDowngradeFacebookLogin = 1;
        }
        if (downgradeConfig.mDowngradeGoogleLogin == 1) {
            this.f43472c.mDowngradeGoogleLogin = 1;
        }
    }

    public boolean toggle() {
        return this.f43472c.mToggle == 1;
    }

    public boolean isDowngradeMap() {
        return this.f43472c.mDowngradeMap == 1;
    }

    public boolean isDowngradeIM() {
        return this.f43472c.mDowngradeIM == 1;
    }

    public boolean isDowngradeShare() {
        return this.f43472c.mDowngradeShare == 1;
    }

    public boolean isDowngradeFaceBookLogin() {
        return this.f43472c.mDowngradeFacebookLogin == 1;
    }

    public boolean isDowngradeGoogleLogin() {
        return this.f43472c.mDowngradeGoogleLogin == 1;
    }
}
