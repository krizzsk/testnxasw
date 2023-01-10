package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* renamed from: com.google.android.play.core.internal.aa */
public final class C20024aa extends C20099j implements C20026ac {
    C20024aa(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.inappreview.protocol.IInAppReviewService");
    }

    /* renamed from: a */
    public final void mo164261a(String str, Bundle bundle, C20028ae aeVar) throws RemoteException {
        Parcel a = mo164352a();
        a.writeString(str);
        C20101l.m42322a(a, (Parcelable) bundle);
        C20101l.m42321a(a, (IInterface) aeVar);
        mo164353a(2, a);
    }
}
