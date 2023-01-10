package com.google.android.play.core.splitinstall.testing;

import java.util.List;

/* renamed from: com.google.android.play.core.splitinstall.testing.g */
final /* synthetic */ class C20218g implements Runnable {

    /* renamed from: a */
    private final FakeSplitInstallManager f56315a;

    /* renamed from: b */
    private final long f56316b;

    /* renamed from: c */
    private final List f56317c;

    /* renamed from: d */
    private final List f56318d;

    /* renamed from: e */
    private final List f56319e;

    C20218g(FakeSplitInstallManager fakeSplitInstallManager, long j, List list, List list2, List list3) {
        this.f56315a = fakeSplitInstallManager;
        this.f56316b = j;
        this.f56317c = list;
        this.f56318d = list2;
        this.f56319e = list3;
    }

    public final void run() {
        this.f56315a.mo164521a(this.f56316b, this.f56317c, this.f56318d, this.f56319e);
    }
}
