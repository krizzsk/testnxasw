package com.google.p209a.p211b.p212a.p213a.p214a;

import android.os.IBinder;
import android.os.IInterface;
import com.google.p209a.p210a.C18662a;

/* renamed from: com.google.a.b.a.a.a.a */
/* compiled from: IInstallService */
public abstract class C18666a extends C18662a implements C18667b {
    /* renamed from: a */
    public static C18667b m40750a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.install.protocol.IInstallService");
        if (queryLocalInterface instanceof C18667b) {
            return (C18667b) queryLocalInterface;
        }
        return new C18669d(iBinder);
    }
}
