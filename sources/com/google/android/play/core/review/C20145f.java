package com.google.android.play.core.review;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.C20027ad;
import com.google.android.play.core.internal.C20030ag;
import com.google.android.play.core.tasks.C20237i;

/* renamed from: com.google.android.play.core.review.f */
class C20145f<T> extends C20027ad {

    /* renamed from: a */
    final C20030ag f56151a;

    /* renamed from: b */
    final C20237i<T> f56152b;

    /* renamed from: c */
    final /* synthetic */ C20147h f56153c;

    C20145f(C20147h hVar, C20030ag agVar, C20237i<T> iVar) {
        this.f56153c = hVar;
        this.f56151a = agVar;
        this.f56152b = iVar;
    }

    /* renamed from: a */
    public void mo164263a(Bundle bundle) throws RemoteException {
        this.f56153c.f56155a.mo164278a();
        this.f56151a.mo164270c("onGetLaunchReviewFlowInfo", new Object[0]);
    }
}
