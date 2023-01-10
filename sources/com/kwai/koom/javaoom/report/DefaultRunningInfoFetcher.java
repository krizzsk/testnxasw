package com.kwai.koom.javaoom.report;

import android.app.Activity;
import android.app.Application;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import com.kwai.koom.javaoom.common.KGlobalConfig;
import com.kwai.koom.javaoom.common.KUtils;
import com.kwai.koom.javaoom.common.RunningInfoFetcher;
import java.lang.ref.WeakReference;
import java.util.Map;

public class DefaultRunningInfoFetcher implements RunningInfoFetcher {

    /* renamed from: a */
    String f58488a;

    /* renamed from: b */
    private WeakReference<Activity> f58489b;

    public Map<String, String> ext() {
        return null;
    }

    public String appVersion() {
        if (!TextUtils.isEmpty(this.f58488a)) {
            return this.f58488a;
        }
        try {
            this.f58488a = SystemUtils.getPackageInfo(KGlobalConfig.getApplication().getPackageManager(), KGlobalConfig.getApplication().getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return this.f58488a;
    }

    public String currentPage() {
        WeakReference<Activity> weakReference = this.f58489b;
        return (weakReference == null || weakReference.get() == null) ? "" : ((Activity) this.f58489b.get()).getLocalClassName();
    }

    public Integer usageSeconds() {
        return Integer.valueOf(KUtils.usageSeconds());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m44305a(Activity activity) {
        WeakReference<Activity> weakReference = this.f58489b;
        if (weakReference == null) {
            this.f58489b = new WeakReference<>(activity);
        } else {
            this.f58489b = weakReference.get() == activity ? this.f58489b : new WeakReference<>(activity);
        }
    }

    public DefaultRunningInfoFetcher(Application application) {
        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            public void onActivityCreated(Activity activity, Bundle bundle) {
                DefaultRunningInfoFetcher.this.m44305a(activity);
            }

            public void onActivityStarted(Activity activity) {
                DefaultRunningInfoFetcher.this.m44305a(activity);
            }

            public void onActivityResumed(Activity activity) {
                DefaultRunningInfoFetcher.this.m44305a(activity);
            }

            public void onActivityPaused(Activity activity) {
                DefaultRunningInfoFetcher.this.m44305a(activity);
            }

            public void onActivityStopped(Activity activity) {
                DefaultRunningInfoFetcher.this.m44305a(activity);
            }

            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                DefaultRunningInfoFetcher.this.m44305a(activity);
            }

            public void onActivityDestroyed(Activity activity) {
                DefaultRunningInfoFetcher.this.m44305a(activity);
            }
        });
    }
}
