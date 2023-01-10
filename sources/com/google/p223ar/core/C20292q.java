package com.google.p223ar.core;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* renamed from: com.google.ar.core.q */
/* compiled from: InstallServiceImpl */
final class C20292q implements ServiceConnection {

    /* renamed from: a */
    private final /* synthetic */ C20291p f56498a;

    C20292q(C20291p pVar) {
        this.f56498a = pVar;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f56498a.m42678a(iBinder);
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.f56498a.m42689d();
    }
}
