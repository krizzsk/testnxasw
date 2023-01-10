package com.google.android.play.core.assetpacks;

public abstract class AssetLocation {
    /* renamed from: a */
    static AssetLocation m41795a(String str, long j, long j2) {
        return new C19921bf(str, j, j2);
    }

    public abstract long offset();

    public abstract String path();

    public abstract long size();
}
