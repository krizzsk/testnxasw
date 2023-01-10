package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* renamed from: com.google.android.play.core.internal.m */
public final class C20102m extends C20099j implements C20104o {
    C20102m(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.appupdate.protocol.IAppUpdateService");
    }

    /* renamed from: a */
    public final void mo164357a(String str, Bundle bundle, C20106q qVar) throws RemoteException {
        Parcel a = mo164352a();
        a.writeString(str);
        C20101l.m42322a(a, (Parcelable) bundle);
        C20101l.m42321a(a, (IInterface) qVar);
        mo164353a(2, a);
    }

    /* renamed from: b */
    public final void mo164358b(String str, Bundle bundle, C20106q qVar) throws RemoteException {
        Parcel a = mo164352a();
        a.writeString(str);
        C20101l.m42322a(a, (Parcelable) bundle);
        C20101l.m42321a(a, (IInterface) qVar);
        mo164353a(3, a);
    }
}
