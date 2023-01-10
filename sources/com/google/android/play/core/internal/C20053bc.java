package com.google.android.play.core.internal;

import com.didi.dynamic.manager.DownloadManager;
import java.io.File;
import java.util.Set;

/* renamed from: com.google.android.play.core.internal.bc */
final class C20053bc implements C20045av {
    C20053bc() {
    }

    /* renamed from: a */
    public final void mo164286a(ClassLoader classLoader, Set<File> set) {
        C20052bb.m42184b(classLoader, set);
    }

    /* renamed from: a */
    public final boolean mo164287a(ClassLoader classLoader, File file, File file2, boolean z) {
        return C20052bb.m42182a(classLoader, file, file2, z, C20052bb.m42180a(), DownloadManager.MODULE_DIR_ZIP, C20052bb.m42183b());
    }
}
