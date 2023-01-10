package com.google.android.gms.internal.p221authapiphone;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.IStatusCallback;

/* renamed from: com.google.android.gms.internal.auth-api-phone.zzh */
/* compiled from: com.google.android.gms:play-services-auth-api-phone@@17.5.1 */
public final class zzh extends zza implements IInterface {
    zzh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.phone.internal.ISmsRetrieverApiService");
    }

    public final void zzc(zze zze) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, zze);
        zzb(4, zza);
    }

    public final void zzd(String str, zzg zzg) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzc.zzb(zza, zzg);
        zzb(5, zza);
    }

    public final void zze(IStatusCallback iStatusCallback) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, iStatusCallback);
        zzb(3, zza);
    }

    public final void zzf(IStatusCallback iStatusCallback) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, iStatusCallback);
        zzb(6, zza);
    }

    public final void zzg(zzj zzj) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, zzj);
        zzb(1, zza);
    }

    public final void zzh(String str, zzj zzj) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzc.zzb(zza, zzj);
        zzb(2, zza);
    }
}
