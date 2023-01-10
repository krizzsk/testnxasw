package com.didi.rfusion.utils;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.didi.rfusion.config.RFLogger;
import com.didi.rfusion.config.RFTheme;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import xcrash.TombstoneParser;

public class RFActivityManager {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Activity f36061a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f36062b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f36063c;

    /* renamed from: d */
    private Application.ActivityLifecycleCallbacks f36064d;

    /* renamed from: a */
    static /* synthetic */ int m27144a(RFActivityManager rFActivityManager) {
        int i = rFActivityManager.f36062b;
        rFActivityManager.f36062b = i + 1;
        return i;
    }

    /* renamed from: c */
    static /* synthetic */ int m27148c(RFActivityManager rFActivityManager) {
        int i = rFActivityManager.f36062b;
        rFActivityManager.f36062b = i - 1;
        return i;
    }

    private RFActivityManager() {
        this.f36064d = new Application.ActivityLifecycleCallbacks() {
            public void onActivityPaused(Activity activity) {
            }

            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            public void onActivityCreated(Activity activity, Bundle bundle) {
                Activity unused = RFActivityManager.this.f36061a = activity;
                RFTheme.getThemeManager().setDefaultTheme(activity);
            }

            public void onActivityStarted(Activity activity) {
                Activity unused = RFActivityManager.this.f36061a = activity;
                RFActivityManager.m27144a(RFActivityManager.this);
                if (RFActivityManager.this.f36062b == 1) {
                    boolean unused2 = RFActivityManager.this.f36063c = true;
                    RFLogger.getLogger().debug(TombstoneParser.keyForeground);
                }
            }

            public void onActivityResumed(Activity activity) {
                Activity unused = RFActivityManager.this.f36061a = activity;
            }

            public void onActivityStopped(Activity activity) {
                RFActivityManager.m27148c(RFActivityManager.this);
                if (RFActivityManager.this.f36062b == 0) {
                    boolean unused = RFActivityManager.this.f36063c = false;
                    RFLogger.getLogger().debug(Constants.BACKGROUND);
                }
            }

            public void onActivityDestroyed(Activity activity) {
                if (RFActivityManager.this.f36061a == activity) {
                    Activity unused = RFActivityManager.this.f36061a = null;
                }
            }
        };
    }

    private static final class InnerHolder {
        /* access modifiers changed from: private */
        public static final RFActivityManager INSTANCE = new RFActivityManager();

        private InnerHolder() {
        }
    }

    public static RFActivityManager getInstance() {
        return InnerHolder.INSTANCE;
    }

    public void init(Application application) {
        application.unregisterActivityLifecycleCallbacks(this.f36064d);
        application.registerActivityLifecycleCallbacks(this.f36064d);
    }

    public boolean isApplicationForeground() {
        return this.f36063c;
    }

    public Activity getTopActivity() {
        return this.f36061a;
    }
}
