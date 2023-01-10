package com.google.android.play.core.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.google.android.play.core.internal.j */
public class C20099j implements IInterface {

    /* renamed from: a */
    private final IBinder f56123a;

    /* renamed from: b */
    private final String f56124b;

    protected C20099j(IBinder iBinder, String str) {
        this.f56123a = iBinder;
        this.f56124b = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Parcel mo164352a() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f56124b);
        return obtain;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo164353a(int i, Parcel parcel) throws RemoteException {
        try {
            this.f56123a.transact(i, parcel, (Parcel) null, 1);
        } finally {
            parcel.recycle();
        }
    }

    public final IBinder asBinder() {
        return this.f56123a;
    }
}
