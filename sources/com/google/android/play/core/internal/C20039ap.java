package com.google.android.play.core.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* renamed from: com.google.android.play.core.internal.ap */
final class C20039ap implements ServiceConnection {

    /* renamed from: a */
    final /* synthetic */ C20040aq f56071a;

    /* synthetic */ C20039ap(C20040aq aqVar) {
        this.f56071a = aqVar;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f56071a.f56074c.mo164270c("ServiceConnectionImpl.onServiceConnected(%s)", componentName);
        this.f56071a.m42146b((C20031ah) new C20037an(this, iBinder));
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.f56071a.f56074c.mo164270c("ServiceConnectionImpl.onServiceDisconnected(%s)", componentName);
        this.f56071a.m42146b((C20031ah) new C20038ao(this));
    }
}
