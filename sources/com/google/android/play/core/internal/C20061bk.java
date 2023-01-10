package com.google.android.play.core.internal;

import com.didi.sdk.apm.SystemUtils;
import java.io.File;

/* renamed from: com.google.android.play.core.internal.bk */
final class C20061bk implements C20049az {
    C20061bk() {
    }

    /* renamed from: a */
    public final boolean mo164289a(Object obj, File file, File file2) {
        try {
            return !((Boolean) C20068br.m42220a((Class) Class.forName("dalvik.system.DexFile"), Boolean.class, String.class, file.getPath())).booleanValue();
        } catch (ClassNotFoundException unused) {
            SystemUtils.log(6, "SplitCompat", "Unexpected missing dalvik.system.DexFile.", (Throwable) null, "com.google.android.play.core.internal.bk", -1);
            return false;
        }
    }
}
