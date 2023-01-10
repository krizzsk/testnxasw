package com.google.android.play.core.splitinstall;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.C20073bw;
import com.google.android.play.core.tasks.C20237i;
import java.util.List;

/* renamed from: com.google.android.play.core.splitinstall.au */
class C20187au<T> extends C20073bw {

    /* renamed from: a */
    final C20237i<T> f56235a;

    /* renamed from: b */
    final /* synthetic */ C20188av f56236b;

    C20187au(C20188av avVar, C20237i<T> iVar) {
        this.f56236b = avVar;
        this.f56235a = iVar;
    }

    /* renamed from: a */
    public final void mo164306a() throws RemoteException {
        this.f56236b.f56239a.mo164278a();
        C20188av.f56237b.mo164270c("onCompleteInstallForAppUpdate", new Object[0]);
    }

    /* renamed from: a */
    public final void mo164307a(int i) throws RemoteException {
        this.f56236b.f56239a.mo164278a();
        C20188av.f56237b.mo164270c("onCompleteInstall(%d)", Integer.valueOf(i));
    }

    /* renamed from: a */
    public void mo164308a(int i, Bundle bundle) throws RemoteException {
        this.f56236b.f56239a.mo164278a();
        C20188av.f56237b.mo164270c("onCancelInstall(%d)", Integer.valueOf(i));
    }

    /* renamed from: a */
    public void mo164309a(Bundle bundle) throws RemoteException {
        this.f56236b.f56239a.mo164278a();
        C20188av.f56237b.mo164270c("onDeferredInstall", new Object[0]);
    }

    /* renamed from: a */
    public void mo164310a(List<Bundle> list) throws RemoteException {
        this.f56236b.f56239a.mo164278a();
        C20188av.f56237b.mo164270c("onGetSessionStates", new Object[0]);
    }

    /* renamed from: b */
    public final void mo164311b() throws RemoteException {
        this.f56236b.f56239a.mo164278a();
        C20188av.f56237b.mo164270c("onGetSplitsForAppUpdate", new Object[0]);
    }

    /* renamed from: b */
    public void mo164312b(int i, Bundle bundle) throws RemoteException {
        this.f56236b.f56239a.mo164278a();
        C20188av.f56237b.mo164270c("onGetSession(%d)", Integer.valueOf(i));
    }

    /* renamed from: b */
    public void mo164313b(Bundle bundle) throws RemoteException {
        this.f56236b.f56239a.mo164278a();
        C20188av.f56237b.mo164270c("onDeferredLanguageInstall", new Object[0]);
    }

    /* renamed from: c */
    public void mo164314c(int i, Bundle bundle) throws RemoteException {
        this.f56236b.f56239a.mo164278a();
        C20188av.f56237b.mo164270c("onStartInstall(%d)", Integer.valueOf(i));
    }

    /* renamed from: c */
    public void mo164315c(Bundle bundle) throws RemoteException {
        this.f56236b.f56239a.mo164278a();
        C20188av.f56237b.mo164270c("onDeferredLanguageUninstall", new Object[0]);
    }

    /* renamed from: d */
    public void mo164316d(Bundle bundle) throws RemoteException {
        this.f56236b.f56239a.mo164278a();
        C20188av.f56237b.mo164270c("onDeferredUninstall", new Object[0]);
    }

    /* renamed from: e */
    public final void mo164317e(Bundle bundle) throws RemoteException {
        this.f56236b.f56239a.mo164278a();
        int i = bundle.getInt("error_code");
        C20188av.f56237b.mo164269b("onError(%d)", Integer.valueOf(i));
        this.f56235a.mo164556b((Exception) new SplitInstallException(i));
    }
}
