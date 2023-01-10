package com.google.android.play.core.assetpacks;

import com.google.android.play.core.tasks.C20237i;
import java.util.List;

/* renamed from: com.google.android.play.core.assetpacks.cu */
final /* synthetic */ class C19963cu implements Runnable {

    /* renamed from: a */
    private final C19968cz f55894a;

    /* renamed from: b */
    private final List f55895b;

    /* renamed from: c */
    private final C20237i f55896c;

    /* renamed from: d */
    private final List f55897d;

    C19963cu(C19968cz czVar, List list, C20237i iVar, List list2) {
        this.f55894a = czVar;
        this.f55895b = list;
        this.f55896c = iVar;
        this.f55897d = list2;
    }

    public final void run() {
        this.f55894a.mo164185a(this.f55895b, this.f55896c, this.f55897d);
    }
}
