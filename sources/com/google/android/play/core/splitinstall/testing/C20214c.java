package com.google.android.play.core.splitinstall.testing;

import java.util.List;

/* renamed from: com.google.android.play.core.splitinstall.testing.c */
final /* synthetic */ class C20214c implements Runnable {

    /* renamed from: a */
    private final FakeSplitInstallManager f56308a;

    /* renamed from: b */
    private final List f56309b;

    /* renamed from: c */
    private final List f56310c;

    C20214c(FakeSplitInstallManager fakeSplitInstallManager, List list, List list2) {
        this.f56308a = fakeSplitInstallManager;
        this.f56309b = list;
        this.f56310c = list2;
    }

    public final void run() {
        this.f56308a.mo164523a(this.f56309b, this.f56310c);
    }
}
