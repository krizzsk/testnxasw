package com.google.android.play.core.assetpacks;

import android.content.ComponentName;
import android.content.Context;
import com.google.android.play.core.common.PlayCoreDialogWrapperActivity;
import com.google.android.play.core.internal.C20068br;
import com.google.android.play.core.internal.C20092co;

/* renamed from: com.google.android.play.core.assetpacks.q */
public final class C20007q implements C20092co<AssetPackManager> {

    /* renamed from: a */
    private final C20092co<C19999j> f56035a;

    /* renamed from: b */
    private final C20092co<Context> f56036b;

    public C20007q(C20092co<C19999j> coVar, C20092co<Context> coVar2) {
        this.f56035a = coVar;
        this.f56036b = coVar2;
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo163987a() {
        C19999j a = this.f56035a.mo163987a();
        Context b = ((C20009s) this.f56036b).mo163987a();
        C19999j jVar = a;
        C20068br.m42227a(b.getPackageManager(), new ComponentName(b.getPackageName(), "com.google.android.play.core.assetpacks.AssetPackExtractionService"), 4);
        PlayCoreDialogWrapperActivity.m42108a(b);
        C20068br.m42234b(jVar);
        return jVar;
    }
}
