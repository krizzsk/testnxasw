package com.google.android.play.core.install;

/* renamed from: com.google.android.play.core.install.a */
final class C20021a extends InstallState {

    /* renamed from: a */
    private final int f56054a;

    /* renamed from: b */
    private final long f56055b;

    /* renamed from: c */
    private final long f56056c;

    /* renamed from: d */
    private final int f56057d;

    /* renamed from: e */
    private final String f56058e;

    C20021a(int i, long j, long j2, int i2, String str) {
        this.f56054a = i;
        this.f56055b = j;
        this.f56056c = j2;
        this.f56057d = i2;
        if (str != null) {
            this.f56058e = str;
            return;
        }
        throw new NullPointerException("Null packageName");
    }

    public final long bytesDownloaded() {
        return this.f56055b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof InstallState) {
            InstallState installState = (InstallState) obj;
            return this.f56054a == installState.installStatus() && this.f56055b == installState.bytesDownloaded() && this.f56056c == installState.totalBytesToDownload() && this.f56057d == installState.installErrorCode() && this.f56058e.equals(installState.packageName());
        }
    }

    public final int hashCode() {
        int i = this.f56054a;
        long j = this.f56055b;
        long j2 = this.f56056c;
        return ((((((((i ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ this.f56057d) * 1000003) ^ this.f56058e.hashCode();
    }

    public final int installErrorCode() {
        return this.f56057d;
    }

    public final int installStatus() {
        return this.f56054a;
    }

    public final String packageName() {
        return this.f56058e;
    }

    public final String toString() {
        int i = this.f56054a;
        long j = this.f56055b;
        long j2 = this.f56056c;
        int i2 = this.f56057d;
        String str = this.f56058e;
        StringBuilder sb = new StringBuilder(str.length() + 164);
        sb.append("InstallState{installStatus=");
        sb.append(i);
        sb.append(", bytesDownloaded=");
        sb.append(j);
        sb.append(", totalBytesToDownload=");
        sb.append(j2);
        sb.append(", installErrorCode=");
        sb.append(i2);
        sb.append(", packageName=");
        sb.append(str);
        sb.append("}");
        return sb.toString();
    }

    public final long totalBytesToDownload() {
        return this.f56056c;
    }
}
