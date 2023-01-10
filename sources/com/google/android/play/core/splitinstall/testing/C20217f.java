package com.google.android.play.core.splitinstall.testing;

import com.google.android.play.core.splitinstall.SplitInstallSessionState;

/* renamed from: com.google.android.play.core.splitinstall.testing.f */
final /* synthetic */ class C20217f implements Runnable {

    /* renamed from: a */
    private final FakeSplitInstallManager f56313a;

    /* renamed from: b */
    private final SplitInstallSessionState f56314b;

    C20217f(FakeSplitInstallManager fakeSplitInstallManager, SplitInstallSessionState splitInstallSessionState) {
        this.f56313a = fakeSplitInstallManager;
        this.f56314b = splitInstallSessionState;
    }

    public final void run() {
        this.f56313a.mo164522a(this.f56314b);
    }
}
