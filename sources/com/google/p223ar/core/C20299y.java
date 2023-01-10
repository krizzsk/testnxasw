package com.google.p223ar.core;

import android.os.Bundle;
import android.os.RemoteException;
import com.didi.sdk.apm.SystemUtils;
import com.google.p209a.p211b.p212a.p213a.p214a.C18670e;
import com.google.p223ar.core.exceptions.FatalException;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.google.ar.core.y */
/* compiled from: InstallServiceImpl */
final class C20299y extends C18670e {

    /* renamed from: a */
    private final /* synthetic */ AtomicBoolean f56512a;

    /* renamed from: b */
    private final /* synthetic */ C20296v f56513b;

    C20299y(C20296v vVar, AtomicBoolean atomicBoolean) {
        this.f56513b = vVar;
        this.f56512a = atomicBoolean;
    }

    /* renamed from: a */
    public final void mo138990a() throws RemoteException {
    }

    /* renamed from: b */
    public final void mo138992b(Bundle bundle) throws RemoteException {
    }

    /* renamed from: a */
    public final void mo138991a(Bundle bundle) throws RemoteException {
        if (!this.f56512a.getAndSet(true)) {
            int i = bundle.getInt("error.code", -100);
            int i2 = bundle.getInt("install.status", 0);
            if (i2 == 4) {
                this.f56513b.f56506b.mo164861a(C20290o.COMPLETED);
            } else if (i != 0) {
                StringBuilder sb = new StringBuilder(51);
                sb.append("requestInstall = ");
                sb.append(i);
                sb.append(", launching fullscreen.");
                SystemUtils.log(5, "ARCore-InstallService", sb.toString(), (Throwable) null, "com.google.ar.core.y", 12);
                C20291p.m42686b(this.f56513b.f56505a, this.f56513b.f56506b);
            } else if (bundle.containsKey("resolution.intent")) {
                C20291p.m42677a(this.f56513b.f56505a, bundle, this.f56513b.f56506b);
            } else if (i2 != 10) {
                switch (i2) {
                    case 1:
                    case 2:
                    case 3:
                        this.f56513b.f56506b.mo164861a(C20290o.ACCEPTED);
                        return;
                    case 4:
                        this.f56513b.f56506b.mo164861a(C20290o.COMPLETED);
                        return;
                    case 5:
                        this.f56513b.f56506b.mo164862a((Exception) new FatalException("Unexpected FAILED install status without error."));
                        return;
                    case 6:
                        this.f56513b.f56506b.mo164861a(C20290o.CANCELLED);
                        return;
                    default:
                        C20293s sVar = this.f56513b.f56506b;
                        StringBuilder sb2 = new StringBuilder(38);
                        sb2.append("Unexpected install status: ");
                        sb2.append(i2);
                        sVar.mo164862a((Exception) new FatalException(sb2.toString()));
                        return;
                }
            } else {
                this.f56513b.f56506b.mo164862a((Exception) new FatalException("Unexpected REQUIRES_UI_INTENT install status without an intent."));
            }
        }
    }
}
