package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzekz extends zzbwz {
    private final zzehf zza;

    /* synthetic */ zzekz(zzela zzela, zzehf zzehf, zzeky zzeky) {
        this.zza = zzehf;
    }

    public final void zze(String str) throws RemoteException {
        ((zzeix) this.zza.zzc).zzi(0, str);
    }

    public final void zzf(zze zze) throws RemoteException {
        ((zzeix) this.zza.zzc).zzh(zze);
    }

    public final void zzg() throws RemoteException {
        ((zzeix) this.zza.zzc).zzo();
    }
}
