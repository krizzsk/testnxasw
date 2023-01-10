package com.google.android.play.core.review;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.C20030ag;
import com.google.android.play.core.tasks.C20237i;

/* renamed from: com.google.android.play.core.review.g */
final class C20146g extends C20145f<ReviewInfo> {
    C20146g(C20147h hVar, C20237i iVar) {
        super(hVar, new C20030ag("OnRequestInstallCallback"), iVar);
    }

    /* renamed from: a */
    public final void mo164263a(Bundle bundle) throws RemoteException {
        super.mo164263a(bundle);
        this.f56152b.mo164557b(ReviewInfo.m42394a((PendingIntent) bundle.get("confirmation_intent")));
    }
}
