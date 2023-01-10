package com.google.android.play.core.appupdate;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.install.InstallException;
import com.google.android.play.core.internal.C20030ag;
import com.google.android.play.core.tasks.C20237i;

/* renamed from: com.google.android.play.core.appupdate.n */
final class C19876n extends C19875m<Void> {
    C19876n(C19878p pVar, C20237i<Void> iVar) {
        super(pVar, new C20030ag("OnCompleteUpdateCallback"), iVar);
    }

    /* renamed from: b */
    public final void mo163995b(Bundle bundle) throws RemoteException {
        super.mo163995b(bundle);
        if (bundle.getInt("error.code", -2) != 0) {
            this.f55573b.mo164556b((Exception) new InstallException(bundle.getInt("error.code", -2)));
        } else {
            this.f55573b.mo164557b(null);
        }
    }
}
