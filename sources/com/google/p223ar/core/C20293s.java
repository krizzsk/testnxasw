package com.google.p223ar.core;

import com.google.p223ar.core.exceptions.UnavailableException;
import com.google.p223ar.core.exceptions.UnavailableUserDeclinedInstallationException;

/* renamed from: com.google.ar.core.s */
/* compiled from: InstallService */
class C20293s {

    /* renamed from: a */
    boolean f56499a = false;

    /* renamed from: b */
    final /* synthetic */ InstallActivity f56500b;

    /* renamed from: a */
    public void mo164861a(C20290o oVar) {
        synchronized (this.f56500b) {
            if (!this.f56499a) {
                C20290o unused = this.f56500b.lastEvent = oVar;
                int ordinal = oVar.ordinal();
                if (ordinal != 0) {
                    if (ordinal == 1) {
                        this.f56500b.finishWithFailure(new UnavailableUserDeclinedInstallationException());
                    } else if (ordinal == 2) {
                        if (!this.f56500b.waitingForCompletion) {
                            this.f56500b.closeInstaller();
                        }
                        this.f56500b.finishWithFailure((Exception) null);
                    }
                    this.f56499a = true;
                }
            }
        }
    }

    /* renamed from: a */
    public void mo164862a(Exception exc) {
        synchronized (this.f56500b) {
            if (!this.f56499a) {
                this.f56499a = true;
                C20290o unused = this.f56500b.lastEvent = C20290o.CANCELLED;
                boolean z = exc instanceof UnavailableException;
                this.f56500b.finishWithFailure(exc);
            }
        }
    }

    C20293s(InstallActivity installActivity) {
        this.f56500b = installActivity;
    }
}
