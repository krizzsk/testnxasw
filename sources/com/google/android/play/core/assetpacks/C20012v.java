package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.C20068br;
import com.google.android.play.core.internal.C20092co;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: com.google.android.play.core.assetpacks.v */
public final class C20012v implements C20092co<Executor> {
    /* renamed from: b */
    public static Executor m42094b() {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(C20002m.f56030a);
        C20068br.m42234b(newSingleThreadExecutor);
        return newSingleThreadExecutor;
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo163987a() {
        return m42094b();
    }
}
