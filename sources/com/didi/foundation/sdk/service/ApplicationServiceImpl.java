package com.didi.foundation.sdk.service;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import com.didi.foundation.sdk.application.FoundationApplicationListener;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;

@ServiceProvider({ApplicationServiceProvider.class})
public class ApplicationServiceImpl implements ApplicationServiceProvider {

    /* renamed from: a */
    private PackageInfo f23156a;

    public String getChannelId() {
        return null;
    }

    public int getVersionCode() {
        PackageInfo a = m19060a();
        if (a != null) {
            return a.versionCode;
        }
        return 0;
    }

    /* renamed from: a */
    private synchronized PackageInfo m19060a() {
        if (this.f23156a == null) {
            try {
                this.f23156a = SystemUtils.getPackageInfo(FoundationApplicationListener.getApplication().getPackageManager(), FoundationApplicationListener.getApplication().getPackageName(), 24063);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.f23156a;
    }

    public String getVersionName() {
        PackageInfo a = m19060a();
        if (a != null) {
            return a.versionName;
        }
        return null;
    }

    public boolean isDebuggable() {
        ApplicationInfo applicationInfo = FoundationApplicationListener.getApplication().getApplicationInfo();
        return (applicationInfo == null || (applicationInfo.flags & 2) == 0) ? false : true;
    }
}
