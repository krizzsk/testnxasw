package com.google.android.gms.internal.instantapps;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.instantapps.zzk;

public final class zzt extends zzb implements zzu {
    zzt(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.instantapps.internal.IInstantAppsService");
    }

    public final void zza(zzs zzs, String str, zzk zzk) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (IInterface) zzs);
        zza.writeString(str);
        zzd.zza(zza, (Parcelable) zzk);
        zza(19, zza);
    }

    public final void zza(zzs zzs) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (IInterface) zzs);
        zza(29, zza);
    }

    public final void zzb(zzs zzs) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (IInterface) zzs);
        zza(40, zza);
    }
}
