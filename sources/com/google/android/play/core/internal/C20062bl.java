package com.google.android.play.core.internal;

import java.io.File;
import java.util.Set;

/* renamed from: com.google.android.play.core.internal.bl */
final class C20062bl implements C20045av {
    C20062bl() {
    }

    /* renamed from: b */
    static void m42204b(ClassLoader classLoader, Set<File> set) {
        C20057bg.m42193a(classLoader, set, new C20060bj());
    }

    /* renamed from: b */
    static boolean m42205b(ClassLoader classLoader, File file, File file2, boolean z) {
        return C20052bb.m42182a(classLoader, file, file2, z, C20057bg.m42192a(), "path", new C20061bk());
    }

    /* renamed from: a */
    public final void mo164286a(ClassLoader classLoader, Set<File> set) {
        m42204b(classLoader, set);
    }

    /* renamed from: a */
    public final boolean mo164287a(ClassLoader classLoader, File file, File file2, boolean z) {
        return m42205b(classLoader, file, file2, z);
    }
}
