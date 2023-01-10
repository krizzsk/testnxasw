package com.didi.globalsafetoolkit.util.statuslightning;

import android.os.Build;

/* renamed from: com.didi.globalsafetoolkit.util.statuslightning.a */
/* compiled from: SystemDetective */
class C9574a {

    /* renamed from: a */
    private static final String f25191a = "ro.miui.ui.version.code";

    /* renamed from: b */
    private static final String f25192b = "ro.miui.ui.version.name";

    /* renamed from: c */
    private static final String f25193c = "ro.miui.internal.storage";

    /* renamed from: d */
    private static final String f25194d = "ro.build.hw_emui_api_level";

    C9574a() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0042 A[SYNTHETIC, Splitter:B:21:0x0042] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0049 A[SYNTHETIC, Splitter:B:27:0x0049] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m20159a() {
        /*
            r0 = 0
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0046, all -> 0x003f }
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x0046, all -> 0x003f }
            java.io.File r4 = android.os.Environment.getRootDirectory()     // Catch:{ Exception -> 0x0046, all -> 0x003f }
            java.lang.String r5 = "build.prop"
            r3.<init>(r4, r5)     // Catch:{ Exception -> 0x0046, all -> 0x003f }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0046, all -> 0x003f }
            java.util.Properties r1 = new java.util.Properties     // Catch:{ Exception -> 0x003d, all -> 0x003a }
            r1.<init>()     // Catch:{ Exception -> 0x003d, all -> 0x003a }
            r1.load(r2)     // Catch:{ Exception -> 0x003d, all -> 0x003a }
            java.lang.String r3 = "ro.miui.ui.version.code"
            java.lang.String r3 = r1.getProperty(r3)     // Catch:{ Exception -> 0x003d, all -> 0x003a }
            if (r3 != 0) goto L_0x0035
            java.lang.String r3 = "ro.miui.ui.version.name"
            java.lang.String r3 = r1.getProperty(r3)     // Catch:{ Exception -> 0x003d, all -> 0x003a }
            if (r3 != 0) goto L_0x0035
            java.lang.String r3 = "ro.miui.internal.storage"
            java.lang.String r1 = r1.getProperty(r3)     // Catch:{ Exception -> 0x003d, all -> 0x003a }
            if (r1 == 0) goto L_0x0036
        L_0x0035:
            r0 = 1
        L_0x0036:
            r2.close()     // Catch:{ IOException -> 0x0039 }
        L_0x0039:
            return r0
        L_0x003a:
            r0 = move-exception
            r1 = r2
            goto L_0x0040
        L_0x003d:
            r1 = r2
            goto L_0x0047
        L_0x003f:
            r0 = move-exception
        L_0x0040:
            if (r1 == 0) goto L_0x0045
            r1.close()     // Catch:{ IOException -> 0x0045 }
        L_0x0045:
            throw r0
        L_0x0046:
        L_0x0047:
            if (r1 == 0) goto L_0x004c
            r1.close()     // Catch:{ IOException -> 0x004c }
        L_0x004c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.globalsafetoolkit.util.statuslightning.C9574a.m20159a():boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0038 A[SYNTHETIC, Splitter:B:18:0x0038] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0044 A[SYNTHETIC, Splitter:B:25:0x0044] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m20160b() {
        /*
            java.io.File r0 = new java.io.File
            java.io.File r1 = android.os.Environment.getRootDirectory()
            java.lang.String r2 = "build.prop"
            r0.<init>(r1, r2)
            boolean r1 = r0.exists()
            r2 = 0
            if (r1 == 0) goto L_0x004c
            java.util.Properties r1 = new java.util.Properties
            r1.<init>()
            r3 = 0
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0041, all -> 0x0035 }
            r4.<init>(r0)     // Catch:{ Exception -> 0x0041, all -> 0x0035 }
            r1.load(r4)     // Catch:{ Exception -> 0x0033, all -> 0x0030 }
            java.lang.String r0 = "ro.build.hw_emui_api_level"
            boolean r0 = r1.containsKey(r0)     // Catch:{ Exception -> 0x0033, all -> 0x0030 }
            r4.close()     // Catch:{ IOException -> 0x002b }
            goto L_0x002f
        L_0x002b:
            r1 = move-exception
            r1.printStackTrace()
        L_0x002f:
            return r0
        L_0x0030:
            r0 = move-exception
            r3 = r4
            goto L_0x0036
        L_0x0033:
            r3 = r4
            goto L_0x0042
        L_0x0035:
            r0 = move-exception
        L_0x0036:
            if (r3 == 0) goto L_0x0040
            r3.close()     // Catch:{ IOException -> 0x003c }
            goto L_0x0040
        L_0x003c:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0040:
            throw r0
        L_0x0041:
        L_0x0042:
            if (r3 == 0) goto L_0x004c
            r3.close()     // Catch:{ IOException -> 0x0048 }
            goto L_0x004c
        L_0x0048:
            r0 = move-exception
            r0.printStackTrace()
        L_0x004c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.globalsafetoolkit.util.statuslightning.C9574a.m20160b():boolean");
    }

    /* renamed from: c */
    public static boolean m20161c() {
        return Build.DISPLAY.startsWith("Flyme");
    }

    /* renamed from: d */
    public static boolean m20162d() {
        return Build.VERSION.SDK_INT >= 23;
    }
}
