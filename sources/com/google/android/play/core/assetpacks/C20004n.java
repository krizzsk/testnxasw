package com.google.android.play.core.assetpacks;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.didi.sdk.apm.SystemUtils;

/* renamed from: com.google.android.play.core.assetpacks.n */
final class C20004n {

    /* renamed from: a */
    private final Context f56033a;

    public C20004n(Context context) {
        this.f56033a = context;
    }

    /* renamed from: a */
    static String m42082a(Context context) {
        try {
            Bundle bundle = SystemUtils.getApplicationInfo(context.getPackageManager(), context.getPackageName(), 128).metaData;
            if (bundle == null) {
                return null;
            }
            return bundle.getString("local_testing_dir");
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final Context mo164245a() {
        return this.f56033a;
    }
}
