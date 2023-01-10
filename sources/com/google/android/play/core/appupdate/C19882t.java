package com.google.android.play.core.appupdate;

import android.app.PendingIntent;

/* renamed from: com.google.android.play.core.appupdate.t */
final class C19882t extends AppUpdateInfo {

    /* renamed from: a */
    private final String f55587a;

    /* renamed from: b */
    private final int f55588b;

    /* renamed from: c */
    private final int f55589c;

    /* renamed from: d */
    private final int f55590d;

    /* renamed from: e */
    private final Integer f55591e;

    /* renamed from: f */
    private final int f55592f;

    /* renamed from: g */
    private final long f55593g;

    /* renamed from: h */
    private final long f55594h;

    /* renamed from: i */
    private final long f55595i;

    /* renamed from: j */
    private final long f55596j;

    /* renamed from: k */
    private final PendingIntent f55597k;

    /* renamed from: l */
    private final PendingIntent f55598l;

    /* renamed from: m */
    private final PendingIntent f55599m;

    /* renamed from: n */
    private final PendingIntent f55600n;

    C19882t(String str, int i, int i2, int i3, Integer num, int i4, long j, long j2, long j3, long j4, PendingIntent pendingIntent, PendingIntent pendingIntent2, PendingIntent pendingIntent3, PendingIntent pendingIntent4) {
        String str2 = str;
        if (str2 != null) {
            this.f55587a = str2;
            this.f55588b = i;
            this.f55589c = i2;
            this.f55590d = i3;
            this.f55591e = num;
            this.f55592f = i4;
            this.f55593g = j;
            this.f55594h = j2;
            this.f55595i = j3;
            this.f55596j = j4;
            this.f55597k = pendingIntent;
            this.f55598l = pendingIntent2;
            this.f55599m = pendingIntent3;
            this.f55600n = pendingIntent4;
            return;
        }
        throw new NullPointerException("Null packageName");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final long mo163955a() {
        return this.f55595i;
    }

    public final int availableVersionCode() {
        return this.f55588b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final long mo163958b() {
        return this.f55596j;
    }

    public final long bytesDownloaded() {
        return this.f55593g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final PendingIntent mo163960c() {
        return this.f55597k;
    }

    public final Integer clientVersionStalenessDays() {
        return this.f55591e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final PendingIntent mo163962d() {
        return this.f55598l;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final PendingIntent mo163963e() {
        return this.f55599m;
    }

    public final boolean equals(Object obj) {
        Integer num;
        PendingIntent pendingIntent;
        PendingIntent pendingIntent2;
        PendingIntent pendingIntent3;
        if (obj == this) {
            return true;
        }
        if (obj instanceof AppUpdateInfo) {
            AppUpdateInfo appUpdateInfo = (AppUpdateInfo) obj;
            if (this.f55587a.equals(appUpdateInfo.packageName()) && this.f55588b == appUpdateInfo.availableVersionCode() && this.f55589c == appUpdateInfo.updateAvailability() && this.f55590d == appUpdateInfo.installStatus() && ((num = this.f55591e) != null ? num.equals(appUpdateInfo.clientVersionStalenessDays()) : appUpdateInfo.clientVersionStalenessDays() == null) && this.f55592f == appUpdateInfo.updatePriority() && this.f55593g == appUpdateInfo.bytesDownloaded() && this.f55594h == appUpdateInfo.totalBytesToDownload() && this.f55595i == appUpdateInfo.mo163955a() && this.f55596j == appUpdateInfo.mo163958b() && ((pendingIntent = this.f55597k) != null ? pendingIntent.equals(appUpdateInfo.mo163960c()) : appUpdateInfo.mo163960c() == null) && ((pendingIntent2 = this.f55598l) != null ? pendingIntent2.equals(appUpdateInfo.mo163962d()) : appUpdateInfo.mo163962d() == null) && ((pendingIntent3 = this.f55599m) != null ? pendingIntent3.equals(appUpdateInfo.mo163963e()) : appUpdateInfo.mo163963e() == null)) {
                PendingIntent pendingIntent4 = this.f55600n;
                PendingIntent f = appUpdateInfo.mo163964f();
                if (pendingIntent4 != null ? pendingIntent4.equals(f) : f == null) {
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final PendingIntent mo163964f() {
        return this.f55600n;
    }

    public final int hashCode() {
        int hashCode = (((((((this.f55587a.hashCode() ^ 1000003) * 1000003) ^ this.f55588b) * 1000003) ^ this.f55589c) * 1000003) ^ this.f55590d) * 1000003;
        Integer num = this.f55591e;
        int i = 0;
        int hashCode2 = num == null ? 0 : num.hashCode();
        int i2 = this.f55592f;
        long j = this.f55593g;
        long j2 = this.f55594h;
        long j3 = this.f55595i;
        long j4 = this.f55596j;
        int i3 = (((((((((((hashCode ^ hashCode2) * 1000003) ^ i2) * 1000003) ^ ((int) ((j >>> 32) ^ j))) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003) ^ ((int) ((j4 >>> 32) ^ j4))) * 1000003;
        PendingIntent pendingIntent = this.f55597k;
        int hashCode3 = (i3 ^ (pendingIntent == null ? 0 : pendingIntent.hashCode())) * 1000003;
        PendingIntent pendingIntent2 = this.f55598l;
        int hashCode4 = (hashCode3 ^ (pendingIntent2 == null ? 0 : pendingIntent2.hashCode())) * 1000003;
        PendingIntent pendingIntent3 = this.f55599m;
        int hashCode5 = (hashCode4 ^ (pendingIntent3 == null ? 0 : pendingIntent3.hashCode())) * 1000003;
        PendingIntent pendingIntent4 = this.f55600n;
        if (pendingIntent4 != null) {
            i = pendingIntent4.hashCode();
        }
        return hashCode5 ^ i;
    }

    public final int installStatus() {
        return this.f55590d;
    }

    public final String packageName() {
        return this.f55587a;
    }

    public final String toString() {
        String str = this.f55587a;
        int i = this.f55588b;
        int i2 = this.f55589c;
        int i3 = this.f55590d;
        String valueOf = String.valueOf(this.f55591e);
        int i4 = this.f55592f;
        long j = this.f55593g;
        long j2 = this.f55594h;
        long j3 = this.f55595i;
        long j4 = this.f55596j;
        String valueOf2 = String.valueOf(this.f55597k);
        long j5 = j4;
        String valueOf3 = String.valueOf(this.f55598l);
        String valueOf4 = String.valueOf(this.f55599m);
        long j6 = j3;
        String valueOf5 = String.valueOf(this.f55600n);
        int length = str.length();
        int length2 = String.valueOf(valueOf).length();
        int length3 = String.valueOf(valueOf2).length();
        int length4 = String.valueOf(valueOf3).length();
        StringBuilder sb = new StringBuilder(length + 463 + length2 + length3 + length4 + String.valueOf(valueOf4).length() + String.valueOf(valueOf5).length());
        sb.append("AppUpdateInfo{packageName=");
        sb.append(str);
        sb.append(", availableVersionCode=");
        sb.append(i);
        sb.append(", updateAvailability=");
        sb.append(i2);
        sb.append(", installStatus=");
        sb.append(i3);
        sb.append(", clientVersionStalenessDays=");
        sb.append(valueOf);
        sb.append(", updatePriority=");
        sb.append(i4);
        sb.append(", bytesDownloaded=");
        sb.append(j);
        sb.append(", totalBytesToDownload=");
        sb.append(j2);
        sb.append(", additionalSpaceRequired=");
        sb.append(j6);
        sb.append(", assetPackStorageSize=");
        sb.append(j5);
        sb.append(", immediateUpdateIntent=");
        sb.append(valueOf2);
        sb.append(", flexibleUpdateIntent=");
        sb.append(valueOf3);
        sb.append(", immediateDestructiveUpdateIntent=");
        sb.append(valueOf4);
        sb.append(", flexibleDestructiveUpdateIntent=");
        sb.append(valueOf5);
        sb.append("}");
        return sb.toString();
    }

    public final long totalBytesToDownload() {
        return this.f55594h;
    }

    public final int updateAvailability() {
        return this.f55589c;
    }

    public final int updatePriority() {
        return this.f55592f;
    }
}
