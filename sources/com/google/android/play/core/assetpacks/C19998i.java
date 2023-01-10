package com.google.android.play.core.assetpacks;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.google.android.play.core.tasks.C20237i;

/* renamed from: com.google.android.play.core.assetpacks.i */
final class C19998i extends ResultReceiver {

    /* renamed from: a */
    final /* synthetic */ C20237i f56008a;

    /* renamed from: b */
    final /* synthetic */ C19999j f56009b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C19998i(C19999j jVar, Handler handler, C20237i iVar) {
        super(handler);
        this.f56009b = jVar;
        this.f56008a = iVar;
    }

    public final void onReceiveResult(int i, Bundle bundle) {
        if (i == 1) {
            this.f56008a.mo164557b(-1);
            this.f56009b.f56017h.mo164147a((PendingIntent) null);
        } else if (i != 2) {
            this.f56008a.mo164556b((Exception) new AssetPackException(-100));
        } else {
            this.f56008a.mo164557b(0);
        }
    }
}
