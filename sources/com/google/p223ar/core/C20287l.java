package com.google.p223ar.core;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.google.p223ar.core.exceptions.UnavailableUserDeclinedInstallationException;

/* renamed from: com.google.ar.core.l */
/* compiled from: InstallActivity */
final class C20287l implements View.OnClickListener {

    /* renamed from: a */
    private final /* synthetic */ InstallActivity f56480a;

    C20287l(InstallActivity installActivity) {
        this.f56480a = installActivity;
    }

    public final void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        this.f56480a.finishWithFailure(new UnavailableUserDeclinedInstallationException());
    }
}
