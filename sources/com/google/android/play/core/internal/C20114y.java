package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* renamed from: com.google.android.play.core.internal.y */
public final class C20114y extends C20099j implements C20115z {
    C20114y(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.assetpacks.protocol.IAssetPackExtractionServiceCallback");
    }

    /* renamed from: a */
    public final void mo164369a(Bundle bundle) throws RemoteException {
        Parcel a = mo164352a();
        C20101l.m42322a(a, (Parcelable) bundle);
        mo164353a(3, a);
    }

    /* renamed from: a */
    public final void mo164370a(Bundle bundle, Bundle bundle2) throws RemoteException {
        Parcel a = mo164352a();
        C20101l.m42322a(a, (Parcelable) bundle);
        C20101l.m42322a(a, (Parcelable) bundle2);
        mo164353a(2, a);
    }

    /* renamed from: b */
    public final void mo164371b(Bundle bundle) throws RemoteException {
        Parcel a = mo164352a();
        C20101l.m42322a(a, (Parcelable) bundle);
        mo164353a(4, a);
    }
}
