package com.google.android.play.core.appupdate;

import android.app.PendingIntent;

public abstract class AppUpdateInfo {
    /* renamed from: a */
    public static AppUpdateInfo m41745a(String str, int i, int i2, int i3, Integer num, int i4, long j, long j2, long j3, long j4, PendingIntent pendingIntent, PendingIntent pendingIntent2, PendingIntent pendingIntent3, PendingIntent pendingIntent4) {
        return new C19882t(str, i, i2, i3, num, i4, j, j2, j3, j4, pendingIntent, pendingIntent2, pendingIntent3, pendingIntent4);
    }

    /* renamed from: b */
    private final boolean m41746b(AppUpdateOptions appUpdateOptions) {
        return appUpdateOptions.allowAssetPackDeletion() && mo163955a() <= mo163958b();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract long mo163955a();

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final PendingIntent mo163956a(AppUpdateOptions appUpdateOptions) {
        if (appUpdateOptions.appUpdateType() != 0) {
            if (appUpdateOptions.appUpdateType() == 1) {
                if (mo163960c() != null) {
                    return mo163960c();
                }
                if (m41746b(appUpdateOptions)) {
                    return mo163963e();
                }
            }
            return null;
        } else if (mo163962d() != null) {
            return mo163962d();
        } else {
            if (m41746b(appUpdateOptions)) {
                return mo163964f();
            }
            return null;
        }
    }

    public abstract int availableVersionCode();

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public abstract long mo163958b();

    public abstract long bytesDownloaded();

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public abstract PendingIntent mo163960c();

    public abstract Integer clientVersionStalenessDays();

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public abstract PendingIntent mo163962d();

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public abstract PendingIntent mo163963e();

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public abstract PendingIntent mo163964f();

    public abstract int installStatus();

    public boolean isUpdateTypeAllowed(int i) {
        return mo163956a(AppUpdateOptions.defaultOptions(i)) != null;
    }

    public boolean isUpdateTypeAllowed(AppUpdateOptions appUpdateOptions) {
        return mo163956a(appUpdateOptions) != null;
    }

    public abstract String packageName();

    public abstract long totalBytesToDownload();

    public abstract int updateAvailability();

    public abstract int updatePriority();
}
