package com.google.android.play.core.assetpacks;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.google.android.play.core.internal.C20030ag;
import com.google.android.play.core.internal.C20087cj;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.android.play.core.assetpacks.bb */
final class C19917bb {

    /* renamed from: a */
    private static final C20030ag f55728a = new C20030ag("AssetPackStorage");

    /* renamed from: b */
    private static final long f55729b = TimeUnit.DAYS.toMillis(14);

    /* renamed from: c */
    private static final long f55730c = TimeUnit.DAYS.toMillis(28);

    /* renamed from: d */
    private final Context f55731d;

    /* renamed from: e */
    private final C19981dl f55732e;

    C19917bb(Context context, C19981dl dlVar) {
        this.f55731d = context;
        this.f55732e = dlVar;
    }

    /* renamed from: a */
    private final File m41880a(String str, int i) {
        return new File(m41885g(str), String.valueOf(i));
    }

    /* renamed from: a */
    private static List<String> m41881a(PackageInfo packageInfo, String str) {
        ArrayList arrayList = new ArrayList();
        if (packageInfo.splitNames == null) {
            return arrayList;
        }
        int i = (-Arrays.binarySearch(packageInfo.splitNames, str)) - 1;
        while (i < packageInfo.splitNames.length && packageInfo.splitNames[i].startsWith(str)) {
            arrayList.add(packageInfo.applicationInfo.splitSourceDirs[i]);
            i++;
        }
        return arrayList;
    }

    /* renamed from: a */
    private static void m41882a(File file) {
        if (file.listFiles() != null && file.listFiles().length > 1) {
            long b = m41883b(file);
            for (File file2 : file.listFiles()) {
                if (!file2.getName().equals(String.valueOf(b)) && !file2.getName().equals("stale.tmp")) {
                    m41884c(file2);
                }
            }
        }
    }

    /* renamed from: b */
    private static long m41883b(File file) {
        if (!file.exists()) {
            return -1;
        }
        ArrayList arrayList = new ArrayList();
        try {
            for (File file2 : file.listFiles()) {
                if (!file2.getName().equals("stale.tmp")) {
                    arrayList.add(Long.valueOf(file2.getName()));
                }
            }
        } catch (NumberFormatException e) {
            f55728a.mo164268a((Throwable) e, "Corrupt asset pack directories.", new Object[0]);
        }
        if (arrayList.isEmpty()) {
            return -1;
        }
        Collections.sort(arrayList);
        return ((Long) arrayList.get(arrayList.size() - 1)).longValue();
    }

    /* renamed from: c */
    private static boolean m41884c(File file) {
        boolean z;
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            z = true;
            for (File c : listFiles) {
                z &= m41884c(c);
            }
        } else {
            z = true;
        }
        return file.delete() && true == z;
    }

    /* renamed from: g */
    private final File m41885g(String str) {
        return new File(m41890i(), str);
    }

    /* renamed from: g */
    private final File m41886g(String str, int i, long j) {
        return new File(mo164105c(str, i, j), "merge.tmp");
    }

    /* renamed from: g */
    private final List<File> m41887g() {
        ArrayList arrayList = new ArrayList();
        try {
            if (m41890i().exists()) {
                if (m41890i().listFiles() != null) {
                    for (File file : m41890i().listFiles()) {
                        if (!file.getCanonicalPath().equals(m41888h().getCanonicalPath())) {
                            arrayList.add(file);
                        }
                    }
                    return arrayList;
                }
            }
            return arrayList;
        } catch (IOException e) {
            f55728a.mo164269b("Could not process directory while scanning installed packs. %s", e);
        }
    }

    /* renamed from: h */
    private final File m41888h() {
        return new File(m41890i(), "_tmp");
    }

    /* renamed from: h */
    private final File m41889h(String str, int i, long j) {
        return new File(new File(new File(m41888h(), str), String.valueOf(i)), String.valueOf(j));
    }

    /* renamed from: i */
    private final File m41890i() {
        return new File(this.f55731d.getFilesDir(), "assetpacks");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0073  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.play.core.assetpacks.AssetLocation mo164093a(java.lang.String r9, java.lang.String r10) {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            android.content.Context r2 = r8.f55731d     // Catch:{ NameNotFoundException -> 0x0013 }
            android.content.pm.PackageManager r2 = r2.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0013 }
            android.content.Context r3 = r8.f55731d     // Catch:{ NameNotFoundException -> 0x0013 }
            java.lang.String r3 = r3.getPackageName()     // Catch:{ NameNotFoundException -> 0x0013 }
            android.content.pm.PackageInfo r2 = com.didi.sdk.apm.SystemUtils.getPackageInfo(r2, r3, r0)     // Catch:{ NameNotFoundException -> 0x0013 }
            goto L_0x001d
        L_0x0013:
            com.google.android.play.core.internal.ag r2 = f55728a
            java.lang.Object[] r3 = new java.lang.Object[r0]
            java.lang.String r4 = "Could not find PackageInfo."
            r2.mo164269b(r4, r3)
            r2 = r1
        L_0x001d:
            r3 = 1
            if (r2 != 0) goto L_0x0022
            r4 = r1
            goto L_0x0087
        L_0x0022:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            int r5 = android.os.Build.VERSION.SDK_INT
            r6 = 21
            if (r5 >= r6) goto L_0x0035
            android.content.pm.ApplicationInfo r2 = r2.applicationInfo
            java.lang.String r2 = r2.sourceDir
            r4.add(r2)
            goto L_0x0087
        L_0x0035:
            java.lang.String[] r5 = r2.splitNames
            if (r5 == 0) goto L_0x005b
            android.content.pm.ApplicationInfo r5 = r2.applicationInfo
            java.lang.String[] r5 = r5.splitSourceDirs
            if (r5 != 0) goto L_0x0040
            goto L_0x005b
        L_0x0040:
            java.lang.String[] r5 = r2.splitNames
            int r5 = java.util.Arrays.binarySearch(r5, r9)
            if (r5 >= 0) goto L_0x0054
            com.google.android.play.core.internal.ag r5 = f55728a
            java.lang.Object[] r6 = new java.lang.Object[r3]
            r6[r0] = r9
            java.lang.String r7 = "Asset Pack '%s' is not installed."
            r5.mo164267a(r7, r6)
            goto L_0x0066
        L_0x0054:
            android.content.pm.ApplicationInfo r6 = r2.applicationInfo
            java.lang.String[] r6 = r6.splitSourceDirs
            r5 = r6[r5]
            goto L_0x0067
        L_0x005b:
            com.google.android.play.core.internal.ag r5 = f55728a
            java.lang.Object[] r6 = new java.lang.Object[r3]
            r6[r0] = r9
            java.lang.String r7 = "No splits present for package %s."
            r5.mo164267a(r7, r6)
        L_0x0066:
            r5 = r1
        L_0x0067:
            if (r5 != 0) goto L_0x0073
            android.content.pm.ApplicationInfo r5 = r2.applicationInfo
            java.lang.String r5 = r5.sourceDir
            r4.add(r5)
            java.lang.String r5 = "config."
            goto L_0x0080
        L_0x0073:
            r4.add(r5)
            java.lang.String r5 = java.lang.String.valueOf(r9)
            java.lang.String r6 = ".config."
            java.lang.String r5 = r5.concat(r6)
        L_0x0080:
            java.util.List r2 = m41881a((android.content.pm.PackageInfo) r2, (java.lang.String) r5)
            r4.addAll(r2)
        L_0x0087:
            if (r4 != 0) goto L_0x008a
            goto L_0x00cd
        L_0x008a:
            java.io.File r2 = new java.io.File
            java.lang.String r5 = "assets"
            r2.<init>(r5, r10)
            java.lang.String r2 = r2.getPath()
            java.util.Iterator r5 = r4.iterator()
        L_0x0099:
            boolean r6 = r5.hasNext()
            r7 = 2
            if (r6 == 0) goto L_0x00bd
            java.lang.Object r6 = r5.next()
            java.lang.String r6 = (java.lang.String) r6
            com.google.android.play.core.assetpacks.AssetLocation r6 = com.google.android.play.core.assetpacks.C19971db.m42010a((java.lang.String) r6, (java.lang.String) r2)     // Catch:{ IOException -> 0x00ae }
            if (r6 == 0) goto L_0x0099
            r1 = r6
            goto L_0x00cd
        L_0x00ae:
            r9 = move-exception
            com.google.android.play.core.internal.ag r2 = f55728a
            java.lang.Object[] r4 = new java.lang.Object[r7]
            r4[r0] = r6
            r4[r3] = r10
            java.lang.String r10 = "Failed to parse APK file '%s' looking for asset '%s'."
            r2.mo164268a((java.lang.Throwable) r9, (java.lang.String) r10, (java.lang.Object[]) r4)
            goto L_0x00cd
        L_0x00bd:
            com.google.android.play.core.internal.ag r2 = f55728a
            r5 = 3
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r5[r0] = r10
            r5[r3] = r9
            r5[r7] = r4
            java.lang.String r9 = "The asset %s is not present in Asset Pack %s. Searched in APKs: %s"
            r2.mo164267a(r9, r5)
        L_0x00cd:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.assetpacks.C19917bb.mo164093a(java.lang.String, java.lang.String):com.google.android.play.core.assetpacks.AssetLocation");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final AssetLocation mo164094a(String str, String str2, AssetPackLocation assetPackLocation) {
        File file = new File(assetPackLocation.assetsPath(), str2);
        if (file.exists()) {
            return AssetLocation.m41795a(file.getPath(), 0, file.length());
        }
        f55728a.mo164267a("The asset %s is not present in Asset Pack %s. Searched in folder: %s", str2, str, assetPackLocation.assetsPath());
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final File mo164095a(String str, int i, long j) {
        return new File(m41880a(str, i), String.valueOf(j));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final File mo164096a(String str, int i, long j, String str2) {
        return new File(new File(new File(m41889h(str, i, j), "_slices"), "_unverified"), str2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final Map<String, AssetPackLocation> mo164097a() {
        HashMap hashMap = new HashMap();
        try {
            for (File next : m41887g()) {
                AssetPackLocation b = mo164101b(next.getName());
                if (b != null) {
                    hashMap.put(next.getName(), b);
                }
            }
        } catch (IOException e) {
            f55728a.mo164269b("Could not process directory while scanning installed packs: %s", e);
        }
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo164098a(String str, int i, long j, int i2) throws IOException {
        File g = m41886g(str, i, j);
        Properties properties = new Properties();
        properties.put("numberOfMerges", String.valueOf(i2));
        g.getParentFile().mkdirs();
        g.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(g);
        properties.store(fileOutputStream, (String) null);
        fileOutputStream.close();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo164099a(List<String> list) {
        int a = this.f55732e.mo164199a();
        for (File next : m41887g()) {
            if (!list.contains(next.getName()) && m41883b(next) != ((long) a)) {
                m41884c(next);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final boolean mo164100a(String str) {
        try {
            return mo164107c(str) != null;
        } catch (IOException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final AssetPackLocation mo164101b(String str) throws IOException {
        String c = mo164107c(str);
        if (c == null) {
            return null;
        }
        File file = new File(c, "assets");
        if (file.isDirectory()) {
            return AssetPackLocation.m41800a(c, file.getCanonicalPath());
        }
        f55728a.mo164269b("Failed to find assets directory: %s", file);
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final File mo164102b(String str, int i, long j) {
        return new File(mo164095a(str, i, j), "_metadata");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final File mo164103b(String str, int i, long j, String str2) {
        return new File(new File(new File(m41889h(str, i, j), "_slices"), "_verified"), str2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final Map<String, Long> mo164104b() {
        HashMap hashMap = new HashMap();
        for (String next : mo164097a().keySet()) {
            hashMap.put(next, Long.valueOf(mo164117f(next)));
        }
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final File mo164105c(String str, int i, long j) {
        return new File(m41889h(str, i, j), "_packs");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final File mo164106c(String str, int i, long j, String str2) {
        return new File(mo164118f(str, i, j, str2), "checkpoint.dat");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final String mo164107c(String str) throws IOException {
        int length;
        File file = new File(m41890i(), str);
        if (!file.exists()) {
            f55728a.mo164267a("Pack not found with pack name: %s", str);
            return null;
        }
        File file2 = new File(file, String.valueOf(this.f55732e.mo164199a()));
        if (!file2.exists()) {
            f55728a.mo164267a("Pack not found with pack name: %s app version: %s", str, Integer.valueOf(this.f55732e.mo164199a()));
            return null;
        }
        File[] listFiles = file2.listFiles();
        if (listFiles == null || (length = listFiles.length) == 0) {
            f55728a.mo164267a("No pack version found for pack name: %s app version: %s", str, Integer.valueOf(this.f55732e.mo164199a()));
            return null;
        } else if (length <= 1) {
            return listFiles[0].getCanonicalPath();
        } else {
            f55728a.mo164269b("Multiple pack versions found for pack name: %s app version: %s", str, Integer.valueOf(this.f55732e.mo164199a()));
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final void mo164108c() {
        for (File next : m41887g()) {
            if (next.listFiles() != null) {
                m41882a(next);
                long b = m41883b(next);
                if (((long) this.f55732e.mo164199a()) != b) {
                    try {
                        new File(new File(next, String.valueOf(b)), "stale.tmp").createNewFile();
                    } catch (IOException unused) {
                        f55728a.mo164269b("Could not write staleness marker.", new Object[0]);
                    }
                }
                for (File a : next.listFiles()) {
                    m41882a(a);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final int mo164109d(String str, int i, long j) throws IOException {
        File g = m41886g(str, i, j);
        if (!g.exists()) {
            return 0;
        }
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(g);
        try {
            properties.load(fileInputStream);
            fileInputStream.close();
            if (properties.getProperty("numberOfMerges") != null) {
                try {
                    return Integer.parseInt(properties.getProperty("numberOfMerges"));
                } catch (NumberFormatException e) {
                    throw new C19937bv("Merge checkpoint file corrupt.", (Exception) e);
                }
            } else {
                throw new C19937bv("Merge checkpoint file corrupt.");
            }
        } catch (Throwable th) {
            C20087cj.m42281a(th, th);
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final File mo164110d(String str, int i, long j, String str2) {
        return new File(mo164118f(str, i, j, str2), "checkpoint_ext.dat");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final void mo164111d() {
        for (File next : m41887g()) {
            if (next.listFiles() != null) {
                for (File file : next.listFiles()) {
                    File file2 = new File(file, "stale.tmp");
                    if (file2.exists() && System.currentTimeMillis() - file2.lastModified() > f55730c) {
                        m41884c(file);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final boolean mo164112d(String str) {
        if (!m41885g(str).exists()) {
            return true;
        }
        return m41884c(m41885g(str));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final int mo164113e(String str) {
        return (int) m41883b(m41885g(str));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final File mo164114e(String str, int i, long j) {
        return new File(new File(m41889h(str, i, j), "_slices"), "_metadata");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final File mo164115e(String str, int i, long j, String str2) {
        return new File(mo164118f(str, i, j, str2), "slice.zip");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final void mo164116e() {
        if (m41888h().exists()) {
            for (File file : m41888h().listFiles()) {
                if (System.currentTimeMillis() - file.lastModified() > f55729b) {
                    m41884c(file);
                } else {
                    m41882a(file);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final long mo164117f(String str) {
        return m41883b(m41880a(str, mo164113e(str)));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final File mo164118f(String str, int i, long j, String str2) {
        return new File(mo164114e(str, i, j), str2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final void mo164119f() {
        m41884c(m41890i());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final void mo164120f(String str, int i, long j) {
        if (m41889h(str, i, j).exists()) {
            m41884c(m41889h(str, i, j));
        }
    }
}
