package com.google.android.play.core.assetpacks;

import java.io.File;
import java.io.FilenameFilter;

/* renamed from: com.google.android.play.core.assetpacks.cx */
final /* synthetic */ class C19966cx implements FilenameFilter {

    /* renamed from: a */
    private final String f55905a;

    C19966cx(String str) {
        this.f55905a = str;
    }

    public final boolean accept(File file, String str) {
        return str.startsWith(String.valueOf(this.f55905a).concat("-")) && str.endsWith(".apk");
    }
}
