package com.google.android.play.core.splitinstall.testing;

import java.util.List;

/* renamed from: com.google.android.play.core.splitinstall.testing.h */
final /* synthetic */ class C20219h implements Runnable {

    /* renamed from: a */
    private final FakeSplitInstallManager f56320a;

    /* renamed from: b */
    private final List f56321b;

    /* renamed from: c */
    private final List f56322c;

    /* renamed from: d */
    private final List f56323d;

    /* renamed from: e */
    private final long f56324e;

    C20219h(FakeSplitInstallManager fakeSplitInstallManager, List list, List list2, List list3, long j) {
        this.f56320a = fakeSplitInstallManager;
        this.f56321b = list;
        this.f56322c = list2;
        this.f56323d = list3;
        this.f56324e = j;
    }

    public final void run() {
        this.f56320a.mo164524a(this.f56321b, this.f56322c, this.f56323d, this.f56324e);
    }
}
