package com.google.android.play.core.appupdate;

import android.content.Context;
import java.io.File;

/* renamed from: com.google.android.play.core.appupdate.r */
final class C19880r {

    /* renamed from: a */
    private final Context f55585a;

    C19880r(Context context) {
        this.f55585a = context;
    }

    /* renamed from: a */
    private static long m41779a(File file) {
        if (!file.isDirectory()) {
            return file.length();
        }
        File[] listFiles = file.listFiles();
        long j = 0;
        if (listFiles != null) {
            for (File a : listFiles) {
                j += m41779a(a);
            }
        }
        return j;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final long mo163998a() {
        return m41779a(new File(this.f55585a.getFilesDir(), "assetpacks"));
    }
}
