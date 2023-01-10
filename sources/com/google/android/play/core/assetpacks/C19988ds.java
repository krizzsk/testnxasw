package com.google.android.play.core.assetpacks;

import java.io.File;
import java.io.FilenameFilter;

/* renamed from: com.google.android.play.core.assetpacks.ds */
final /* synthetic */ class C19988ds implements FilenameFilter {

    /* renamed from: a */
    static final FilenameFilter f55989a = new C19988ds();

    private C19988ds() {
    }

    public final boolean accept(File file, String str) {
        return C19989dt.f55990a.matcher(str).matches();
    }
}
