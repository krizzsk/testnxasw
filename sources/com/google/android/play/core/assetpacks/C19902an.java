package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import com.google.android.play.core.tasks.C20237i;

/* renamed from: com.google.android.play.core.assetpacks.an */
final class C19902an extends C19899ak<Void> {

    /* renamed from: c */
    final /* synthetic */ C19906ar f55679c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C19902an(C19906ar arVar, C20237i<Void> iVar) {
        super(arVar, iVar);
        this.f55679c = arVar;
    }

    /* renamed from: a */
    public final void mo164065a(Bundle bundle, Bundle bundle2) {
        super.mo164065a(bundle, bundle2);
        if (!this.f55679c.f55694g.compareAndSet(true, false)) {
            C19906ar.f55688a.mo164271d("Expected keepingAlive to be true, but was false.", new Object[0]);
        }
        if (bundle.getBoolean("keep_alive")) {
            this.f55679c.mo164077a();
        }
    }
}
