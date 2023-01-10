package com.google.android.play.core.internal;

import com.didi.dynamic.manager.DownloadManager;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.play.core.splitinstall.C20201k;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: com.google.android.play.core.internal.bb */
final class C20052bb implements C20045av {
    C20052bb() {
    }

    /* renamed from: a */
    static C20051ba m42180a() {
        return new C20047ax();
    }

    /* renamed from: a */
    static Object m42181a(ClassLoader classLoader) {
        return C20068br.m42219a((Object) classLoader, "pathList", Object.class).mo164293a();
    }

    /* renamed from: a */
    static boolean m42182a(ClassLoader classLoader, File file, File file2, boolean z, C20051ba baVar, String str, C20049az azVar) {
        ArrayList arrayList = new ArrayList();
        Object a = m42181a(classLoader);
        C20067bq b = C20068br.m42233b(a, "dexElements", Object.class);
        List<Object> asList = Arrays.asList((Object[]) b.mo164293a());
        ArrayList arrayList2 = new ArrayList();
        for (Object a2 : asList) {
            arrayList2.add(C20068br.m42219a(a2, str, File.class).mo164293a());
        }
        if (arrayList2.contains(file2)) {
            return true;
        }
        if (z || azVar.mo164289a(a, file2, file)) {
            b.mo164295a((Collection) Arrays.asList(baVar.mo164288a(a, new ArrayList(Collections.singleton(file2)), file, arrayList)));
            if (arrayList.isEmpty()) {
                return true;
            }
            C20066bp bpVar = new C20066bp("DexPathList.makeDexElement failed");
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                IOException iOException = (IOException) arrayList.get(i);
                SystemUtils.log(6, "SplitCompat", "DexPathList.makeDexElement failed", iOException, "com.google.android.play.core.internal.bb", -1);
                C20087cj.m42281a(bpVar, iOException);
            }
            C20068br.m42233b(a, "dexElementsSuppressedExceptions", IOException.class).mo164295a((Collection) arrayList);
            throw bpVar;
        }
        String valueOf = String.valueOf(file2.getPath());
        SystemUtils.log(5, "SplitCompat", valueOf.length() != 0 ? "Should be optimized ".concat(valueOf) : new String("Should be optimized "), (Throwable) null, "com.google.android.play.core.internal.bb", -1);
        return false;
    }

    /* renamed from: b */
    static C20049az m42183b() {
        return new C20048ay();
    }

    /* renamed from: b */
    static void m42184b(ClassLoader classLoader, Set<File> set) {
        if (!set.isEmpty()) {
            HashSet hashSet = new HashSet();
            for (File next : set) {
                String valueOf = String.valueOf(next.getParentFile().getAbsolutePath());
                SystemUtils.log(3, "Splitcompat", valueOf.length() != 0 ? "Adding native library parent directory: ".concat(valueOf) : new String("Adding native library parent directory: "), (Throwable) null, "com.google.android.play.core.internal.bb", -1);
                hashSet.add(next.getParentFile());
            }
            C20067bq b = C20068br.m42233b(m42181a(classLoader), "nativeLibraryDirectories", File.class);
            hashSet.removeAll(Arrays.asList((File[]) b.mo164293a()));
            synchronized (C20201k.class) {
                int size = hashSet.size();
                StringBuilder sb = new StringBuilder(30);
                sb.append("Adding directories ");
                sb.append(size);
                SystemUtils.log(3, "Splitcompat", sb.toString(), (Throwable) null, "com.google.android.play.core.internal.bb", -1);
                b.mo164297b(hashSet);
            }
        }
    }

    /* renamed from: a */
    public final void mo164286a(ClassLoader classLoader, Set<File> set) {
        m42184b(classLoader, set);
    }

    /* renamed from: a */
    public final boolean mo164287a(ClassLoader classLoader, File file, File file2, boolean z) {
        return m42182a(classLoader, file, file2, z, m42180a(), DownloadManager.MODULE_DIR_ZIP, m42183b());
    }
}
