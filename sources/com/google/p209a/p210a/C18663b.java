package com.google.p209a.p210a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.google.a.a.b */
/* compiled from: BaseProxy */
public class C18663b implements IInterface {

    /* renamed from: a */
    private final IBinder f55132a;

    /* renamed from: b */
    private final String f55133b;

    protected C18663b(IBinder iBinder, String str) {
        this.f55132a = iBinder;
        this.f55133b = str;
    }

    public IBinder asBinder() {
        return this.f55132a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Parcel mo138984a() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f55133b);
        return obtain;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Parcel mo138985a(int i, Parcel parcel) throws RemoteException {
        parcel = Parcel.obtain();
        try {
            this.f55132a.transact(i, parcel, parcel, 0);
            parcel.readException();
            return parcel;
        } catch (RuntimeException e) {
            throw e;
        } finally {
            parcel.recycle();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo138987b(int i, Parcel parcel) throws RemoteException {
        try {
            this.f55132a.transact(i, parcel, (Parcel) null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
