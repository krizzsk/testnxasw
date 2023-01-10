package com.google.android.play.core.assetpacks;

/* renamed from: com.google.android.play.core.assetpacks.bh */
final class C19923bh extends AssetPackState {

    /* renamed from: a */
    private final String f55746a;

    /* renamed from: b */
    private final int f55747b;

    /* renamed from: c */
    private final int f55748c;

    /* renamed from: d */
    private final long f55749d;

    /* renamed from: e */
    private final long f55750e;

    /* renamed from: f */
    private final int f55751f;

    /* renamed from: g */
    private final int f55752g;

    C19923bh(String str, int i, int i2, long j, long j2, int i3, int i4) {
        if (str != null) {
            this.f55746a = str;
            this.f55747b = i;
            this.f55748c = i2;
            this.f55749d = j;
            this.f55750e = j2;
            this.f55751f = i3;
            this.f55752g = i4;
            return;
        }
        throw new NullPointerException("Null name");
    }

    /* renamed from: a */
    public final int mo164049a() {
        return this.f55752g;
    }

    public final long bytesDownloaded() {
        return this.f55749d;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AssetPackState) {
            AssetPackState assetPackState = (AssetPackState) obj;
            return this.f55746a.equals(assetPackState.name()) && this.f55747b == assetPackState.status() && this.f55748c == assetPackState.errorCode() && this.f55749d == assetPackState.bytesDownloaded() && this.f55750e == assetPackState.totalBytesToDownload() && this.f55751f == assetPackState.transferProgressPercentage() && this.f55752g == assetPackState.mo164049a();
        }
    }

    public final int errorCode() {
        return this.f55748c;
    }

    public final int hashCode() {
        int hashCode = this.f55746a.hashCode();
        int i = this.f55747b;
        int i2 = this.f55748c;
        long j = this.f55749d;
        long j2 = this.f55750e;
        return ((((((((((((hashCode ^ 1000003) * 1000003) ^ i) * 1000003) ^ i2) * 1000003) ^ ((int) ((j >>> 32) ^ j))) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ this.f55751f) * 1000003) ^ this.f55752g;
    }

    public final String name() {
        return this.f55746a;
    }

    public final int status() {
        return this.f55747b;
    }

    public final String toString() {
        String str = this.f55746a;
        int i = this.f55747b;
        int i2 = this.f55748c;
        long j = this.f55749d;
        long j2 = this.f55750e;
        int i3 = this.f55751f;
        int i4 = this.f55752g;
        StringBuilder sb = new StringBuilder(str.length() + 217);
        sb.append("AssetPackState{name=");
        sb.append(str);
        sb.append(", status=");
        sb.append(i);
        sb.append(", errorCode=");
        sb.append(i2);
        sb.append(", bytesDownloaded=");
        sb.append(j);
        sb.append(", totalBytesToDownload=");
        sb.append(j2);
        sb.append(", transferProgressPercentage=");
        sb.append(i3);
        sb.append(", updateAvailability=");
        sb.append(i4);
        sb.append("}");
        return sb.toString();
    }

    public final long totalBytesToDownload() {
        return this.f55750e;
    }

    public final int transferProgressPercentage() {
        return this.f55751f;
    }
}
