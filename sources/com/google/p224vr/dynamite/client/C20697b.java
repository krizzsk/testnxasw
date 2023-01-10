package com.google.p224vr.dynamite.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.p209a.p210a.C18663b;

/* renamed from: com.google.vr.dynamite.client.b */
/* compiled from: INativeLibraryLoader */
public final class C20697b extends C18663b implements INativeLibraryLoader {
    C20697b(IBinder iBinder) {
        super(iBinder, "com.google.vr.dynamite.client.INativeLibraryLoader");
    }

    public final long initializeAndLoadNativeLibrary(String str) throws RemoteException {
        Parcel a = mo138984a();
        a.writeString(str);
        Parcel a2 = mo138985a(1, a);
        long readLong = a2.readLong();
        a2.recycle();
        return readLong;
    }

    public final int checkVersion(String str) throws RemoteException {
        Parcel a = mo138984a();
        a.writeString(str);
        Parcel a2 = mo138985a(2, a);
        int readInt = a2.readInt();
        a2.recycle();
        return readInt;
    }
}
