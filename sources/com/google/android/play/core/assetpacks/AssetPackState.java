package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import com.google.android.play.core.internal.C20098i;

public abstract class AssetPackState {
    /* renamed from: a */
    static AssetPackState m41801a(Bundle bundle, String str, C19941bz bzVar, C19914az azVar) {
        Bundle bundle2 = bundle;
        String str2 = str;
        int a = azVar.mo164090a(bundle2.getInt(C20098i.m42301a("status", str2)), str2);
        int i = bundle2.getInt(C20098i.m42301a("error_code", str2));
        long j = bundle2.getLong(C20098i.m42301a("bytes_downloaded", str2));
        long j2 = bundle2.getLong(C20098i.m42301a("total_bytes_to_download", str2));
        double b = bzVar.mo164158b(str2);
        long j3 = bundle2.getLong(C20098i.m42301a("pack_version", str2));
        long j4 = bundle2.getLong(C20098i.m42301a("pack_base_version", str2));
        return m41802a(str, a, i, j, j2, b, (a != 4 || j4 == 0 || j4 == j3) ? 1 : 2);
    }

    /* renamed from: a */
    public static AssetPackState m41802a(String str, int i, int i2, long j, long j2, double d, int i3) {
        return new C19923bh(str, i, i2, j, j2, (int) Math.rint(100.0d * d), i3);
    }

    /* renamed from: a */
    public abstract int mo164049a();

    public abstract long bytesDownloaded();

    public abstract int errorCode();

    public abstract String name();

    public abstract int status();

    public abstract long totalBytesToDownload();

    public abstract int transferProgressPercentage();
}
