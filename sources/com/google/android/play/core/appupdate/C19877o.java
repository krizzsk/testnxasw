package com.google.android.play.core.appupdate;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.install.InstallException;
import com.google.android.play.core.internal.C20030ag;
import com.google.android.play.core.tasks.C20237i;

/* renamed from: com.google.android.play.core.appupdate.o */
final class C19877o extends C19875m<AppUpdateInfo> {

    /* renamed from: d */
    final /* synthetic */ C19878p f55575d;

    /* renamed from: e */
    private final String f55576e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C19877o(C19878p pVar, C20237i<AppUpdateInfo> iVar, String str) {
        super(pVar, new C20030ag("OnRequestInstallCallback"), iVar);
        this.f55575d = pVar;
        this.f55576e = str;
    }

    /* renamed from: a */
    public final void mo163994a(Bundle bundle) throws RemoteException {
        super.mo163994a(bundle);
        if (bundle.getInt("error.code", -2) != 0) {
            this.f55573b.mo164556b((Exception) new InstallException(bundle.getInt("error.code", -2)));
        } else {
            this.f55573b.mo164557b(C19878p.m41770a(this.f55575d, bundle, this.f55576e));
        }
    }
}
