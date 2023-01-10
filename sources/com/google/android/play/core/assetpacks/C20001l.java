package com.google.android.play.core.assetpacks;

import java.util.concurrent.ThreadFactory;

/* renamed from: com.google.android.play.core.assetpacks.l */
final /* synthetic */ class C20001l implements ThreadFactory {

    /* renamed from: a */
    static final ThreadFactory f56029a = new C20001l();

    private C20001l() {
    }

    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, "AssetPackBackgroundExecutor");
    }
}
