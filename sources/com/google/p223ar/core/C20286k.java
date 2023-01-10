package com.google.p223ar.core;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;

/* renamed from: com.google.ar.core.k */
/* compiled from: InstallActivity */
final class C20286k implements View.OnClickListener {

    /* renamed from: a */
    private final /* synthetic */ InstallActivity f56479a;

    C20286k(InstallActivity installActivity) {
        this.f56479a = installActivity;
    }

    public final void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        this.f56479a.animateToSpinner();
        this.f56479a.startInstaller();
    }
}
