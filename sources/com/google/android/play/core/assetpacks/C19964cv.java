package com.google.android.play.core.assetpacks;

import com.google.android.play.core.tasks.C20237i;
import java.util.List;

/* renamed from: com.google.android.play.core.assetpacks.cv */
final /* synthetic */ class C19964cv implements Runnable {

    /* renamed from: a */
    private final C19968cz f55898a;

    /* renamed from: b */
    private final List f55899b;

    /* renamed from: c */
    private final C19914az f55900c;

    /* renamed from: d */
    private final C20237i f55901d;

    C19964cv(C19968cz czVar, List list, C19914az azVar, C20237i iVar) {
        this.f55898a = czVar;
        this.f55899b = list;
        this.f55900c = azVar;
        this.f55901d = iVar;
    }

    public final void run() {
        this.f55898a.mo164184a(this.f55899b, this.f55900c, this.f55901d);
    }
}
