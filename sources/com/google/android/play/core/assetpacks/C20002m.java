package com.google.android.play.core.assetpacks;

import java.util.concurrent.ThreadFactory;

/* renamed from: com.google.android.play.core.assetpacks.m */
final /* synthetic */ class C20002m implements ThreadFactory {

    /* renamed from: a */
    static final ThreadFactory f56030a = new C20002m();

    private C20002m() {
    }

    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, "UpdateListenerExecutor");
    }
}
