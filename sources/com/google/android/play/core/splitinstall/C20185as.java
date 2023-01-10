package com.google.android.play.core.splitinstall;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.tasks.C20237i;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.play.core.splitinstall.as */
final class C20185as extends C20187au<List<SplitInstallSessionState>> {
    C20185as(C20188av avVar, C20237i<List<SplitInstallSessionState>> iVar) {
        super(avVar, iVar);
    }

    /* renamed from: a */
    public final void mo164310a(List<Bundle> list) throws RemoteException {
        super.mo164310a(list);
        ArrayList arrayList = new ArrayList(list.size());
        for (Bundle a : list) {
            arrayList.add(SplitInstallSessionState.m42457a(a));
        }
        this.f56235a.mo164557b(arrayList);
    }
}
