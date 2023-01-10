package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.C20110u;
import com.google.android.play.core.tasks.C20237i;
import java.util.List;

/* renamed from: com.google.android.play.core.assetpacks.ak */
class C19899ak<T> extends C20110u {

    /* renamed from: a */
    final C20237i<T> f55676a;

    /* renamed from: b */
    final /* synthetic */ C19906ar f55677b;

    C19899ak(C19906ar arVar, C20237i<T> iVar) {
        this.f55677b = arVar;
        this.f55676a = iVar;
    }

    C19899ak(C19906ar arVar, C20237i iVar, byte[] bArr) {
        this(arVar, iVar);
    }

    C19899ak(C19906ar arVar, C20237i iVar, char[] cArr) {
        this(arVar, iVar);
    }

    C19899ak(C19906ar arVar, C20237i iVar, int[] iArr) {
        this(arVar, iVar);
    }

    C19899ak(C19906ar arVar, C20237i iVar, short[] sArr) {
        this(arVar, iVar);
    }

    /* renamed from: a */
    public void mo164061a() {
        this.f55677b.f55692e.mo164278a();
        C19906ar.f55688a.mo164270c("onCancelDownloads()", new Object[0]);
    }

    /* renamed from: a */
    public final void mo164062a(int i) {
        this.f55677b.f55692e.mo164278a();
        C19906ar.f55688a.mo164270c("onCancelDownload(%d)", Integer.valueOf(i));
    }

    /* renamed from: a */
    public void mo164063a(int i, Bundle bundle) {
        this.f55677b.f55692e.mo164278a();
        C19906ar.f55688a.mo164270c("onStartDownload(%d)", Integer.valueOf(i));
    }

    /* renamed from: a */
    public void mo164064a(Bundle bundle) {
        this.f55677b.f55692e.mo164278a();
        int i = bundle.getInt("error_code");
        C19906ar.f55688a.mo164269b("onError(%d)", Integer.valueOf(i));
        this.f55676a.mo164556b((Exception) new AssetPackException(i));
    }

    /* renamed from: a */
    public void mo164065a(Bundle bundle, Bundle bundle2) {
        this.f55677b.f55693f.mo164278a();
        C19906ar.f55688a.mo164270c("onKeepAlive(%b)", Boolean.valueOf(bundle.getBoolean("keep_alive")));
    }

    /* renamed from: a */
    public void mo164066a(List<Bundle> list) {
        this.f55677b.f55692e.mo164278a();
        C19906ar.f55688a.mo164270c("onGetSessionStates", new Object[0]);
    }

    /* renamed from: b */
    public void mo164067b() {
        this.f55677b.f55692e.mo164278a();
        C19906ar.f55688a.mo164270c("onRemoveModule()", new Object[0]);
    }

    /* renamed from: b */
    public final void mo164068b(int i) {
        this.f55677b.f55692e.mo164278a();
        C19906ar.f55688a.mo164270c("onGetSession(%d)", Integer.valueOf(i));
    }

    /* renamed from: b */
    public void mo164069b(Bundle bundle) {
        this.f55677b.f55692e.mo164278a();
        C19906ar.f55688a.mo164270c("onNotifyChunkTransferred(%s, %s, %d, session=%d)", bundle.getString("module_name"), bundle.getString("slice_id"), Integer.valueOf(bundle.getInt("chunk_number")), Integer.valueOf(bundle.getInt("session_id")));
    }

    /* renamed from: b */
    public void mo164070b(Bundle bundle, Bundle bundle2) throws RemoteException {
        this.f55677b.f55692e.mo164278a();
        C19906ar.f55688a.mo164270c("onGetChunkFileDescriptor", new Object[0]);
    }

    /* renamed from: c */
    public void mo164071c(Bundle bundle) {
        this.f55677b.f55692e.mo164278a();
        C19906ar.f55688a.mo164270c("onNotifyModuleCompleted(%s, sessionId=%d)", bundle.getString("module_name"), Integer.valueOf(bundle.getInt("session_id")));
    }

    /* renamed from: c */
    public void mo164072c(Bundle bundle, Bundle bundle2) {
        this.f55677b.f55692e.mo164278a();
        C19906ar.f55688a.mo164270c("onRequestDownloadInfo()", new Object[0]);
    }

    /* renamed from: d */
    public void mo164073d(Bundle bundle) {
        this.f55677b.f55692e.mo164278a();
        C19906ar.f55688a.mo164270c("onNotifySessionFailed(%d)", Integer.valueOf(bundle.getInt("session_id")));
    }
}
