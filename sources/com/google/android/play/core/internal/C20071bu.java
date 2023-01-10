package com.google.android.play.core.internal;

import android.os.IBinder;
import android.os.IInterface;

/* renamed from: com.google.android.play.core.internal.bu */
public abstract class C20071bu extends C20100k implements C20072bv {
    /* renamed from: a */
    public static C20072bv m42243a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.splitinstall.protocol.ISplitInstallService");
        return queryLocalInterface instanceof C20072bv ? (C20072bv) queryLocalInterface : new C20070bt(iBinder);
    }
}
