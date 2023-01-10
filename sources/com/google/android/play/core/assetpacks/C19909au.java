package com.google.android.play.core.assetpacks;

import android.os.Bundle;

/* renamed from: com.google.android.play.core.assetpacks.au */
final /* synthetic */ class C19909au implements Runnable {

    /* renamed from: a */
    private final C19911aw f55699a;

    /* renamed from: b */
    private final Bundle f55700b;

    /* renamed from: c */
    private final AssetPackState f55701c;

    C19909au(C19911aw awVar, Bundle bundle, AssetPackState assetPackState) {
        this.f55699a = awVar;
        this.f55700b = bundle;
        this.f55701c = assetPackState;
    }

    public final void run() {
        this.f55699a.mo164088a(this.f55700b, this.f55701c);
    }
}
