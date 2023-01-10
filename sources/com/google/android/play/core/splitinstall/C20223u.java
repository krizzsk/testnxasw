package com.google.android.play.core.splitinstall;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.play.core.splitinstall.u */
final class C20223u implements Runnable {

    /* renamed from: a */
    final /* synthetic */ SplitInstallRequest f56334a;

    /* renamed from: b */
    final /* synthetic */ C20225w f56335b;

    C20223u(C20225w wVar, SplitInstallRequest splitInstallRequest) {
        this.f56335b = wVar;
        this.f56334a = splitInstallRequest;
    }

    public final void run() {
        C20211t a = this.f56335b.f56338b;
        List<String> moduleNames = this.f56334a.getModuleNames();
        List a2 = C20225w.m42588b(this.f56334a.getLanguages());
        Bundle bundle = new Bundle();
        bundle.putInt("session_id", 0);
        bundle.putInt("status", 5);
        bundle.putInt("error_code", 0);
        if (!moduleNames.isEmpty()) {
            bundle.putStringArrayList("module_names", new ArrayList(moduleNames));
        }
        if (!a2.isEmpty()) {
            bundle.putStringArrayList("languages", new ArrayList(a2));
        }
        bundle.putLong("total_bytes_to_download", 0);
        bundle.putLong("bytes_downloaded", 0);
        a.mo164405a(SplitInstallSessionState.m42457a(bundle));
    }
}
