package com.google.android.play.core.assetpacks;

public abstract class AssetPackLocation {

    /* renamed from: a */
    private static final AssetPackLocation f55634a = new C19922bg(1, (String) null, (String) null);

    /* renamed from: a */
    static AssetPackLocation m41799a() {
        return f55634a;
    }

    /* renamed from: a */
    static AssetPackLocation m41800a(String str, String str2) {
        return new C19922bg(0, str, str2);
    }

    public abstract String assetsPath();

    public abstract int packStorageMethod();

    public abstract String path();
}
