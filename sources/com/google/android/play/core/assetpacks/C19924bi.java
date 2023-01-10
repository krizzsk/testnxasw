package com.google.android.play.core.assetpacks;

import java.util.Map;

/* renamed from: com.google.android.play.core.assetpacks.bi */
final class C19924bi extends AssetPackStates {

    /* renamed from: a */
    private final long f55753a;

    /* renamed from: b */
    private final Map<String, AssetPackState> f55754b;

    C19924bi(long j, Map<String, AssetPackState> map) {
        this.f55753a = j;
        this.f55754b = map;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AssetPackStates) {
            AssetPackStates assetPackStates = (AssetPackStates) obj;
            return this.f55753a == assetPackStates.totalBytes() && this.f55754b.equals(assetPackStates.packStates());
        }
    }

    public final int hashCode() {
        long j = this.f55753a;
        return this.f55754b.hashCode() ^ ((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003);
    }

    public final Map<String, AssetPackState> packStates() {
        return this.f55754b;
    }

    public final String toString() {
        long j = this.f55753a;
        String valueOf = String.valueOf(this.f55754b);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 61);
        sb.append("AssetPackStates{totalBytes=");
        sb.append(j);
        sb.append(", packStates=");
        sb.append(valueOf);
        sb.append("}");
        return sb.toString();
    }

    public final long totalBytes() {
        return this.f55753a;
    }
}
