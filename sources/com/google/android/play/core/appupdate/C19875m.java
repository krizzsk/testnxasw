package com.google.android.play.core.appupdate;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.C20030ag;
import com.google.android.play.core.internal.C20105p;
import com.google.android.play.core.tasks.C20237i;

/* renamed from: com.google.android.play.core.appupdate.m */
class C19875m<T> extends C20105p {

    /* renamed from: a */
    final C20030ag f55572a;

    /* renamed from: b */
    final C20237i<T> f55573b;

    /* renamed from: c */
    final /* synthetic */ C19878p f55574c;

    C19875m(C19878p pVar, C20030ag agVar, C20237i<T> iVar) {
        this.f55574c = pVar;
        this.f55572a = agVar;
        this.f55573b = iVar;
    }

    /* renamed from: a */
    public void mo163994a(Bundle bundle) throws RemoteException {
        this.f55574c.f55579a.mo164278a();
        this.f55572a.mo164270c("onRequestInfo", new Object[0]);
    }

    /* renamed from: b */
    public void mo163995b(Bundle bundle) throws RemoteException {
        this.f55574c.f55579a.mo164278a();
        this.f55572a.mo164270c("onCompleteUpdate", new Object[0]);
    }
}
