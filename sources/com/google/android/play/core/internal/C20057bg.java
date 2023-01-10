package com.google.android.play.core.internal;

import com.didi.dynamic.manager.DownloadManager;
import com.google.android.play.core.splitinstall.C20201k;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: com.google.android.play.core.internal.bg */
final class C20057bg implements C20045av {
    C20057bg() {
    }

    /* renamed from: a */
    static C20051ba m42192a() {
        return new C20054bd();
    }

    /* renamed from: a */
    public static void m42193a(ClassLoader classLoader, Set<File> set, C20056bf bfVar) {
        if (!set.isEmpty()) {
            HashSet hashSet = new HashSet();
            for (File parentFile : set) {
                hashSet.add(parentFile.getParentFile());
            }
            Object a = C20052bb.m42181a(classLoader);
            C20067bq<List> a2 = C20068br.m42219a(a, "nativeLibraryDirectories", List.class);
            synchronized (C20201k.class) {
                ArrayList arrayList = new ArrayList(a2.mo164293a());
                hashSet.removeAll(arrayList);
                arrayList.addAll(hashSet);
                a2.mo164294a(arrayList);
            }
            ArrayList arrayList2 = new ArrayList();
            Object[] a3 = bfVar.mo164292a(a, new ArrayList(hashSet), arrayList2);
            if (!arrayList2.isEmpty()) {
                C20066bp bpVar = new C20066bp("Error in makePathElements");
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    C20087cj.m42281a(bpVar, (IOException) arrayList2.get(i));
                }
                throw bpVar;
            }
            synchronized (C20201k.class) {
                C20068br.m42233b(a, "nativeLibraryPathElements", Object.class).mo164297b(Arrays.asList(a3));
            }
        }
    }

    /* renamed from: b */
    static C20056bf m42194b() {
        return new C20055be();
    }

    /* renamed from: b */
    public static boolean m42195b(ClassLoader classLoader, File file, File file2, boolean z) {
        return C20052bb.m42182a(classLoader, file, file2, z, m42192a(), DownloadManager.MODULE_DIR_ZIP, C20052bb.m42183b());
    }

    /* renamed from: a */
    public final void mo164286a(ClassLoader classLoader, Set<File> set) {
        m42193a(classLoader, set, m42194b());
    }

    /* renamed from: a */
    public final boolean mo164287a(ClassLoader classLoader, File file, File file2, boolean z) {
        return m42195b(classLoader, file, file2, z);
    }
}
