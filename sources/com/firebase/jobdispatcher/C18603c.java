package com.firebase.jobdispatcher;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.firebase.jobdispatcher.c */
/* compiled from: GooglePlayJobCallback */
final class C18603c implements JobCallback {

    /* renamed from: a */
    private static final String f54719a = "com.google.android.gms.gcm.INetworkTaskCallback";

    /* renamed from: b */
    private static final int f54720b = 2;

    /* renamed from: c */
    private final IBinder f54721c;

    public C18603c(IBinder iBinder) {
        this.f54721c = iBinder;
    }

    public void jobFinished(int i) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(f54719a);
            obtain.writeInt(i);
            this.f54721c.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            obtain.recycle();
            obtain2.recycle();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        } catch (Throwable th) {
            obtain.recycle();
            obtain2.recycle();
            throw th;
        }
    }
}
