package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbay {
    public final List zza;
    public final int zzb;

    private zzbay(List list, int i) {
        this.zza = list;
        this.zzb = i;
    }

    public static zzbay zza(zzbak zzbak) throws zzasz {
        List list;
        try {
            zzbak.zzw(21);
            int zzg = zzbak.zzg() & 3;
            int zzg2 = zzbak.zzg();
            int zzc = zzbak.zzc();
            int i = 0;
            for (int i2 = 0; i2 < zzg2; i2++) {
                zzbak.zzw(1);
                int zzj = zzbak.zzj();
                for (int i3 = 0; i3 < zzj; i3++) {
                    int zzj2 = zzbak.zzj();
                    i += zzj2 + 4;
                    zzbak.zzw(zzj2);
                }
            }
            zzbak.zzv(zzc);
            byte[] bArr = new byte[i];
            int i4 = 0;
            for (int i5 = 0; i5 < zzg2; i5++) {
                zzbak.zzw(1);
                int zzj3 = zzbak.zzj();
                for (int i6 = 0; i6 < zzj3; i6++) {
                    int zzj4 = zzbak.zzj();
                    System.arraycopy(zzbai.zza, 0, bArr, i4, 4);
                    int i7 = i4 + 4;
                    System.arraycopy(zzbak.zza, zzbak.zzc(), bArr, i7, zzj4);
                    i4 = i7 + zzj4;
                    zzbak.zzw(zzj4);
                }
            }
            if (i == 0) {
                list = null;
            } else {
                list = Collections.singletonList(bArr);
            }
            return new zzbay(list, zzg + 1);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new zzasz("Error parsing HEVC config", e);
        }
    }
}
