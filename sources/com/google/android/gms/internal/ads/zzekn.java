package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zze;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzekn implements zzfzc {
    final /* synthetic */ long zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzfdk zzc;
    final /* synthetic */ zzfdn zzd;
    final /* synthetic */ zzfki zze;
    final /* synthetic */ zzfdw zzf;
    final /* synthetic */ zzeko zzg;

    zzekn(zzeko zzeko, long j, String str, zzfdk zzfdk, zzfdn zzfdn, zzfki zzfki, zzfdw zzfdw) {
        this.zzg = zzeko;
        this.zza = j;
        this.zzb = str;
        this.zzc = zzfdk;
        this.zzd = zzfdn;
        this.zze = zzfki;
        this.zzf = zzfdw;
    }

    public final void zza(Throwable th) {
        Integer num;
        zze zze2;
        zze zzb2;
        long elapsedRealtime = this.zzg.zza.elapsedRealtime() - this.zza;
        int i = 6;
        if (th instanceof TimeoutException) {
            num = null;
            i = 2;
        } else if (th instanceof zzekd) {
            num = null;
            i = 3;
        } else if (th instanceof CancellationException) {
            num = null;
            i = 4;
        } else if (th instanceof zzfek) {
            num = null;
            i = 5;
        } else {
            if (th instanceof zzebh) {
                if (zzffe.zza(th).zza == 3) {
                    i = 1;
                }
                if (((Boolean) zzay.zzc().zzb(zzbjc.zzbu)).booleanValue() && (th instanceof zzehg) && (zzb2 = ((zzehg) th).zzb()) != null) {
                    num = Integer.valueOf(zzb2.zza);
                }
            }
            num = null;
        }
        zzeko.zzg(this.zzg, this.zzb, i, elapsedRealtime, this.zzc.zzah, num);
        zzeko zzeko = this.zzg;
        if (zzeko.zze) {
            zzeko.zzb.zza(this.zzd, this.zzc, i, th instanceof zzehg ? (zzehg) th : null, elapsedRealtime);
        }
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzhi)).booleanValue()) {
            zzfkm zzc2 = this.zzg.zzc;
            zzfki zzfki = this.zze;
            zzfdw zzfdw = this.zzf;
            zzfdk zzfdk = this.zzc;
            zzc2.zzd(zzfki.zzc(zzfdw, zzfdk, zzfdk.zzo));
        }
        zze zza2 = zzffe.zza(th);
        int i2 = zza2.zza;
        if ((i2 == 3 || i2 == 0) && (zze2 = zza2.zzd) != null && !zze2.zzc.equals(MobileAds.ERROR_DOMAIN)) {
            zza2 = zzffe.zza(new zzehg(13, zza2.zzd));
        }
        this.zzg.zzf.zze(this.zzc, elapsedRealtime, zza2);
    }

    public final void zzb(Object obj) {
        long elapsedRealtime = this.zzg.zza.elapsedRealtime() - this.zza;
        zzeko.zzg(this.zzg, this.zzb, 0, elapsedRealtime, this.zzc.zzah, (Integer) null);
        zzeko zzeko = this.zzg;
        if (zzeko.zze) {
            zzeko.zzb.zza(this.zzd, this.zzc, 0, (zzehg) null, elapsedRealtime);
        }
        this.zzg.zzf.zzf(this.zzc, elapsedRealtime, (zze) null);
    }
}
