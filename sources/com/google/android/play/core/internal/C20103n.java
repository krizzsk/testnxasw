package com.google.android.play.core.internal;

import android.os.IBinder;
import android.os.IInterface;

/* renamed from: com.google.android.play.core.internal.n */
public abstract class C20103n extends C20100k implements C20104o {
    /* renamed from: a */
    public static C20104o m42325a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.appupdate.protocol.IAppUpdateService");
        return queryLocalInterface instanceof C20104o ? (C20104o) queryLocalInterface : new C20102m(iBinder);
    }
}
