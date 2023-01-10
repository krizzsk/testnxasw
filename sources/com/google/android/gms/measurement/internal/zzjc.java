package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzcf;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
final class zzjc implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzp zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ zzcf zze;
    final /* synthetic */ zzkb zzf;

    zzjc(zzkb zzkb, String str, String str2, zzp zzp, boolean z, zzcf zzcf) {
        this.zzf = zzkb;
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzp;
        this.zzd = z;
        this.zze = zzcf;
    }

    public final void run() {
        Throwable th;
        Bundle bundle;
        RemoteException e;
        Bundle bundle2 = new Bundle();
        try {
            zzkb zzkb = this.zzf;
            zzeo zzh = zzkb.zzb;
            if (zzh == null) {
                zzkb.zzs.zzaz().zzd().zzc("Failed to get user properties; not connected to service", this.zza, this.zzb);
                this.zzf.zzs.zzv().zzR(this.zze, bundle2);
                return;
            }
            Preconditions.checkNotNull(this.zzc);
            List<zzll> zzh2 = zzh.zzh(this.zza, this.zzb, this.zzd, this.zzc);
            bundle = new Bundle();
            if (zzh2 != null) {
                for (zzll zzll : zzh2) {
                    String str = zzll.zze;
                    if (str != null) {
                        bundle.putString(zzll.zzb, str);
                    } else {
                        Long l = zzll.zzd;
                        if (l != null) {
                            bundle.putLong(zzll.zzb, l.longValue());
                        } else {
                            Double d = zzll.zzg;
                            if (d != null) {
                                bundle.putDouble(zzll.zzb, d.doubleValue());
                            }
                        }
                    }
                }
            }
            try {
                this.zzf.zzQ();
                this.zzf.zzs.zzv().zzR(this.zze, bundle);
            } catch (RemoteException e2) {
                e = e2;
                try {
                    this.zzf.zzs.zzaz().zzd().zzc("Failed to get user properties; remote exception", this.zza, e);
                    this.zzf.zzs.zzv().zzR(this.zze, bundle);
                } catch (Throwable th2) {
                    th = th2;
                    bundle2 = bundle;
                    this.zzf.zzs.zzv().zzR(this.zze, bundle2);
                    throw th;
                }
            }
        } catch (RemoteException e3) {
            bundle = bundle2;
            e = e3;
            this.zzf.zzs.zzaz().zzd().zzc("Failed to get user properties; remote exception", this.zza, e);
            this.zzf.zzs.zzv().zzR(this.zze, bundle);
        } catch (Throwable th3) {
            th = th3;
            this.zzf.zzs.zzv().zzR(this.zze, bundle2);
            throw th;
        }
    }
}
