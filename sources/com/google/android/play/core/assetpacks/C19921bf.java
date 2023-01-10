package com.google.android.play.core.assetpacks;

/* renamed from: com.google.android.play.core.assetpacks.bf */
final class C19921bf extends AssetLocation {

    /* renamed from: a */
    private final String f55740a;

    /* renamed from: b */
    private final long f55741b;

    /* renamed from: c */
    private final long f55742c;

    C19921bf(String str, long j, long j2) {
        if (str != null) {
            this.f55740a = str;
            this.f55741b = j;
            this.f55742c = j2;
            return;
        }
        throw new NullPointerException("Null path");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AssetLocation) {
            AssetLocation assetLocation = (AssetLocation) obj;
            return this.f55740a.equals(assetLocation.path()) && this.f55741b == assetLocation.offset() && this.f55742c == assetLocation.size();
        }
    }

    public final int hashCode() {
        int hashCode = this.f55740a.hashCode();
        long j = this.f55741b;
        long j2 = this.f55742c;
        return ((((hashCode ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2));
    }

    public final long offset() {
        return this.f55741b;
    }

    public final String path() {
        return this.f55740a;
    }

    public final long size() {
        return this.f55742c;
    }

    public final String toString() {
        String str = this.f55740a;
        long j = this.f55741b;
        long j2 = this.f55742c;
        StringBuilder sb = new StringBuilder(str.length() + 76);
        sb.append("AssetLocation{path=");
        sb.append(str);
        sb.append(", offset=");
        sb.append(j);
        sb.append(", size=");
        sb.append(j2);
        sb.append("}");
        return sb.toString();
    }
}
