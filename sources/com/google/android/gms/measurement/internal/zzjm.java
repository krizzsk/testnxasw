package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzcf;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
final class zzjm implements Runnable {
    final /* synthetic */ zzav zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzcf zzc;
    final /* synthetic */ zzkb zzd;

    zzjm(zzkb zzkb, zzav zzav, String str, zzcf zzcf) {
        this.zzd = zzkb;
        this.zza = zzav;
        this.zzb = str;
        this.zzc = zzcf;
    }

    public final void run() {
        zzgi zzgi;
        byte[] bArr = null;
        try {
            zzkb zzkb = this.zzd;
            zzeo zzh = zzkb.zzb;
            if (zzh == null) {
                zzkb.zzs.zzaz().zzd().zza("Discarding data. Failed to send event to service to bundle");
                zzgi = this.zzd.zzs;
            } else {
                bArr = zzh.zzu(this.zza, this.zzb);
                this.zzd.zzQ();
                zzgi = this.zzd.zzs;
            }
        } catch (RemoteException e) {
            this.zzd.zzs.zzaz().zzd().zzb("Failed to send event to the service to bundle", e);
            zzgi = this.zzd.zzs;
        } catch (Throwable th) {
            this.zzd.zzs.zzv().zzS(this.zzc, bArr);
            throw th;
        }
        zzgi.zzv().zzS(this.zzc, bArr);
    }
}
