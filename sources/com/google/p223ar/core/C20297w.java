package com.google.p223ar.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/* renamed from: com.google.ar.core.w */
/* compiled from: InstallServiceImpl */
final class C20297w extends BroadcastReceiver {

    /* renamed from: a */
    private final /* synthetic */ C20293s f56508a;

    /* renamed from: b */
    private final /* synthetic */ C20291p f56509b;

    C20297w(C20291p pVar, C20293s sVar) {
        this.f56509b = pVar;
        this.f56508a = sVar;
    }

    public final void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Bundle extras = intent.getExtras();
        if ("com.google.android.play.core.install.ACTION_INSTALL_STATUS".equals(action) && extras != null && extras.containsKey("install.status")) {
            this.f56509b.m42688c();
            int i = extras.getInt("install.status");
            if (i == 1 || i == 2 || i == 3) {
                this.f56508a.mo164861a(C20290o.ACCEPTED);
            } else if (i == 4) {
                this.f56508a.mo164861a(C20290o.COMPLETED);
            } else if (i == 6) {
                this.f56508a.mo164861a(C20290o.CANCELLED);
            }
        }
    }
}
