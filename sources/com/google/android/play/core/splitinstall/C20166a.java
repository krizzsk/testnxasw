package com.google.android.play.core.splitinstall;

import android.app.PendingIntent;
import android.content.Intent;
import java.util.List;

/* renamed from: com.google.android.play.core.splitinstall.a */
final class C20166a extends SplitInstallSessionState {

    /* renamed from: a */
    private final int f56197a;

    /* renamed from: b */
    private final int f56198b;

    /* renamed from: c */
    private final int f56199c;

    /* renamed from: d */
    private final long f56200d;

    /* renamed from: e */
    private final long f56201e;

    /* renamed from: f */
    private final List<String> f56202f;

    /* renamed from: g */
    private final List<String> f56203g;

    /* renamed from: h */
    private final PendingIntent f56204h;

    /* renamed from: i */
    private final List<Intent> f56205i;

    C20166a(int i, int i2, int i3, long j, long j2, List<String> list, List<String> list2, PendingIntent pendingIntent, List<Intent> list3) {
        this.f56197a = i;
        this.f56198b = i2;
        this.f56199c = i3;
        this.f56200d = j;
        this.f56201e = j2;
        this.f56202f = list;
        this.f56203g = list2;
        this.f56204h = pendingIntent;
        this.f56205i = list3;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final List<String> mo164479a() {
        return this.f56202f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final List<String> mo164480b() {
        return this.f56203g;
    }

    public final long bytesDownloaded() {
        return this.f56200d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final List<Intent> mo164482c() {
        return this.f56205i;
    }

    public final boolean equals(Object obj) {
        List<String> list;
        List<String> list2;
        PendingIntent pendingIntent;
        if (obj == this) {
            return true;
        }
        if (obj instanceof SplitInstallSessionState) {
            SplitInstallSessionState splitInstallSessionState = (SplitInstallSessionState) obj;
            if (this.f56197a == splitInstallSessionState.sessionId() && this.f56198b == splitInstallSessionState.status() && this.f56199c == splitInstallSessionState.errorCode() && this.f56200d == splitInstallSessionState.bytesDownloaded() && this.f56201e == splitInstallSessionState.totalBytesToDownload() && ((list = this.f56202f) != null ? list.equals(splitInstallSessionState.mo164479a()) : splitInstallSessionState.mo164479a() == null) && ((list2 = this.f56203g) != null ? list2.equals(splitInstallSessionState.mo164480b()) : splitInstallSessionState.mo164480b() == null) && ((pendingIntent = this.f56204h) != null ? pendingIntent.equals(splitInstallSessionState.resolutionIntent()) : splitInstallSessionState.resolutionIntent() == null)) {
                List<Intent> list3 = this.f56205i;
                List<Intent> c = splitInstallSessionState.mo164482c();
                if (list3 != null ? list3.equals(c) : c == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int errorCode() {
        return this.f56199c;
    }

    public final int hashCode() {
        int i = this.f56197a;
        int i2 = this.f56198b;
        int i3 = this.f56199c;
        long j = this.f56200d;
        long j2 = this.f56201e;
        int i4 = (((((((((i ^ 1000003) * 1000003) ^ i2) * 1000003) ^ i3) * 1000003) ^ ((int) ((j >>> 32) ^ j))) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003;
        List<String> list = this.f56202f;
        int i5 = 0;
        int hashCode = (i4 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        List<String> list2 = this.f56203g;
        int hashCode2 = (hashCode ^ (list2 == null ? 0 : list2.hashCode())) * 1000003;
        PendingIntent pendingIntent = this.f56204h;
        int hashCode3 = (hashCode2 ^ (pendingIntent == null ? 0 : pendingIntent.hashCode())) * 1000003;
        List<Intent> list3 = this.f56205i;
        if (list3 != null) {
            i5 = list3.hashCode();
        }
        return hashCode3 ^ i5;
    }

    @Deprecated
    public final PendingIntent resolutionIntent() {
        return this.f56204h;
    }

    public final int sessionId() {
        return this.f56197a;
    }

    public final int status() {
        return this.f56198b;
    }

    public final String toString() {
        int i = this.f56197a;
        int i2 = this.f56198b;
        int i3 = this.f56199c;
        long j = this.f56200d;
        long j2 = this.f56201e;
        String valueOf = String.valueOf(this.f56202f);
        String valueOf2 = String.valueOf(this.f56203g);
        String valueOf3 = String.valueOf(this.f56204h);
        String valueOf4 = String.valueOf(this.f56205i);
        int length = String.valueOf(valueOf).length();
        int length2 = String.valueOf(valueOf2).length();
        StringBuilder sb = new StringBuilder(length + 251 + length2 + String.valueOf(valueOf3).length() + String.valueOf(valueOf4).length());
        sb.append("SplitInstallSessionState{sessionId=");
        sb.append(i);
        sb.append(", status=");
        sb.append(i2);
        sb.append(", errorCode=");
        sb.append(i3);
        sb.append(", bytesDownloaded=");
        sb.append(j);
        sb.append(", totalBytesToDownload=");
        sb.append(j2);
        sb.append(", moduleNamesNullable=");
        sb.append(valueOf);
        sb.append(", languagesNullable=");
        sb.append(valueOf2);
        sb.append(", resolutionIntent=");
        sb.append(valueOf3);
        sb.append(", splitFileIntents=");
        sb.append(valueOf4);
        sb.append("}");
        return sb.toString();
    }

    public final long totalBytesToDownload() {
        return this.f56201e;
    }
}
