package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.didi.sdk.apm.SystemUtils;
import java.io.File;

/* renamed from: com.google.android.play.core.splitinstall.y */
public final class C20227y {

    /* renamed from: a */
    private final Context f56346a;

    C20227y(Context context) {
        this.f56346a = context;
    }

    /* renamed from: a */
    static File m42590a(Context context) {
        String string;
        try {
            Bundle bundle = SystemUtils.getApplicationInfo(context.getPackageManager(), context.getPackageName(), 128).metaData;
            if (bundle == null || (string = bundle.getString("local_testing_dir")) == null) {
                return null;
            }
            return new File(context.getExternalFilesDir((String) null), string);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final C20211t mo164532a() {
        return C20211t.m42554a(this.f56346a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final Context mo164533b() {
        return this.f56346a;
    }
}
