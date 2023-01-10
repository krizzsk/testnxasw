package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzaej {
    private final zzef zza = new zzef(8);
    private int zzb;

    private final long zzb(zzzj zzzj) throws IOException {
        zzyy zzyy = (zzyy) zzzj;
        int i = 0;
        zzyy.zzm(this.zza.zzH(), 0, 1, false);
        byte b = this.zza.zzH()[0] & 255;
        if (b == 0) {
            return Long.MIN_VALUE;
        }
        int i2 = 128;
        int i3 = 0;
        while ((b & i2) == 0) {
            i2 >>= 1;
            i3++;
        }
        int i4 = b & (~i2);
        zzyy.zzm(this.zza.zzH(), 1, i3, false);
        while (i < i3) {
            i++;
            i4 = (this.zza.zzH()[i] & 255) + (i4 << 8);
        }
        this.zzb += i3 + 1;
        return (long) i4;
    }

    public final boolean zza(zzzj zzzj) throws IOException {
        long zzb2;
        int i;
        long zzd = zzzj.zzd();
        long j = 1024;
        int i2 = (zzd > -1 ? 1 : (zzd == -1 ? 0 : -1));
        if (i2 != 0 && zzd <= 1024) {
            j = zzd;
        }
        int i3 = (int) j;
        zzyy zzyy = (zzyy) zzzj;
        zzyy.zzm(this.zza.zzH(), 0, 4, false);
        this.zzb = 4;
        for (long zzs = this.zza.zzs(); zzs != 440786851; zzs = ((zzs << 8) & -256) | ((long) (this.zza.zzH()[0] & 255))) {
            int i4 = this.zzb + 1;
            this.zzb = i4;
            if (i4 == i3) {
                return false;
            }
            zzyy.zzm(this.zza.zzH(), 0, 1, false);
        }
        long zzb3 = zzb(zzzj);
        long j2 = (long) this.zzb;
        if (zzb3 != Long.MIN_VALUE && (i2 == 0 || j2 + zzb3 < zzd)) {
            while (true) {
                int i5 = (((long) this.zzb) > (j2 + zzb3) ? 1 : (((long) this.zzb) == (j2 + zzb3) ? 0 : -1));
                if (i5 < 0) {
                    if (zzb(zzzj) == Long.MIN_VALUE || zzb2 < 0) {
                        return false;
                    }
                    if (i != 0) {
                        int zzb4 = (int) (zzb2 = zzb(zzzj));
                        zzyy.zzl(zzb4, false);
                        this.zzb += zzb4;
                    }
                } else if (i5 == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
