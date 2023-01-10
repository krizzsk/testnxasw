package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzabl implements zzyt {
    private final zzzv zza;
    private final int zzb;
    private final zzzq zzc = new zzzq();

    /* synthetic */ zzabl(zzzv zzzv, int i, zzabk zzabk) {
        this.zza = zzzv;
        this.zzb = i;
    }

    private final long zzc(zzzj zzzj) throws IOException {
        zzzj zzzj2 = zzzj;
        while (zzzj.zze() < zzzj.zzd() - 6) {
            zzzv zzzv = this.zza;
            int i = this.zzb;
            zzzq zzzq = this.zzc;
            long zze = zzzj.zze();
            byte[] bArr = new byte[2];
            zzyy zzyy = (zzyy) zzzj2;
            zzyy.zzm(bArr, 0, 2, false);
            if ((((bArr[0] & 255) << 8) | (bArr[1] & 255)) != i) {
                zzzj.zzj();
                zzyy.zzl((int) (zze - zzzj.zzf()), false);
            } else {
                zzef zzef = new zzef(16);
                System.arraycopy(bArr, 0, zzef.zzH(), 0, 2);
                zzef.zzE(zzzm.zza(zzzj2, zzef.zzH(), 2, 14));
                zzzj.zzj();
                zzyy.zzl((int) (zze - zzzj.zzf()), false);
                if (zzzr.zzc(zzef, zzzv, i, zzzq)) {
                    break;
                }
            }
            zzyy.zzl(1, false);
        }
        if (zzzj.zze() < zzzj.zzd() - 6) {
            return this.zzc.zza;
        }
        ((zzyy) zzzj2).zzl((int) (zzzj.zzd() - zzzj.zze()), false);
        return this.zza.zzj;
    }

    public final zzys zza(zzzj zzzj, long j) throws IOException {
        long zzf = zzzj.zzf();
        long zzc2 = zzc(zzzj);
        long zze = zzzj.zze();
        ((zzyy) zzzj).zzl(Math.max(6, this.zza.zzc), false);
        long zzc3 = zzc(zzzj);
        long zze2 = zzzj.zze();
        if (zzc2 > j || zzc3 <= j) {
            return zzc3 <= j ? zzys.zzf(zzc3, zze2) : zzys.zzd(zzc2, zzf);
        }
        return zzys.zze(zze);
    }

    public final /* synthetic */ void zzb() {
    }
}
