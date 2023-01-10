package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import com.google.android.play.core.tasks.C20237i;

/* renamed from: com.google.android.play.core.assetpacks.ao */
final class C19903ao extends C19899ak<Void> {

    /* renamed from: c */
    final int f55680c;

    /* renamed from: d */
    final String f55681d;

    /* renamed from: e */
    final int f55682e;

    /* renamed from: f */
    final /* synthetic */ C19906ar f55683f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C19903ao(C19906ar arVar, C20237i<Void> iVar, int i, String str, int i2) {
        super(arVar, iVar);
        this.f55683f = arVar;
        this.f55680c = i;
        this.f55681d = str;
        this.f55682e = i2;
    }

    /* renamed from: a */
    public final void mo164064a(Bundle bundle) {
        this.f55683f.f55692e.mo164278a();
        int i = bundle.getInt("error_code");
        C19906ar.f55688a.mo164269b("onError(%d), retrying notifyModuleCompleted...", Integer.valueOf(i));
        int i2 = this.f55682e;
        if (i2 > 0) {
            this.f55683f.m41843a(this.f55680c, this.f55681d, i2 - 1);
        }
    }
}
