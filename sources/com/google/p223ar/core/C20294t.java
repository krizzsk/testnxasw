package com.google.p223ar.core;

import android.os.Bundle;
import android.os.RemoteException;
import com.didi.sdk.apm.SystemUtils;
import com.google.p209a.p211b.p212a.p213a.p214a.C18670e;
import com.google.p223ar.core.ArCoreApk;

/* renamed from: com.google.ar.core.t */
/* compiled from: InstallServiceImpl */
final class C20294t extends C18670e {

    /* renamed from: a */
    private final /* synthetic */ C20295u f56501a;

    C20294t(C20295u uVar) {
        this.f56501a = uVar;
    }

    /* renamed from: a */
    public final void mo138990a() throws RemoteException {
    }

    /* renamed from: a */
    public final void mo138991a(Bundle bundle) throws RemoteException {
    }

    /* renamed from: b */
    public final void mo138992b(Bundle bundle) throws RemoteException {
        int i = bundle.getInt("error.code", -100);
        if (i == -5) {
            SystemUtils.log(6, "ARCore-InstallService", "The device is not supported.", (Throwable) null, "com.google.ar.core.t", 10);
            this.f56501a.f56502a.mo164600a(ArCoreApk.Availability.UNSUPPORTED_DEVICE_NOT_CAPABLE);
        } else if (i == -3) {
            SystemUtils.log(6, "ARCore-InstallService", "The Google Play application must be updated.", (Throwable) null, "com.google.ar.core.t", 7);
            this.f56501a.f56502a.mo164600a(ArCoreApk.Availability.UNKNOWN_ERROR);
        } else if (i != 0) {
            StringBuilder sb = new StringBuilder(33);
            sb.append("requestInfo returned: ");
            sb.append(i);
            SystemUtils.log(6, "ARCore-InstallService", sb.toString(), (Throwable) null, "com.google.ar.core.t", 13);
            this.f56501a.f56502a.mo164600a(ArCoreApk.Availability.UNKNOWN_ERROR);
        } else {
            this.f56501a.f56502a.mo164600a(ArCoreApk.Availability.SUPPORTED_NOT_INSTALLED);
        }
    }
}
