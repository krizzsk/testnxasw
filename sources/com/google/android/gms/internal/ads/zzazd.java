package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import java.util.Arrays;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public abstract class zzazd extends zzazh {
    private final SparseArray zza = new SparseArray();
    private final SparseBooleanArray zzb = new SparseBooleanArray();
    private zzazb zzc;

    /* access modifiers changed from: protected */
    public abstract zzayx[] zzb(zzatc[] zzatcArr, zzayt[] zzaytArr, int[][][] iArr) throws zzasi;

    public final zzazi zzc(zzatc[] zzatcArr, zzayt zzayt) throws zzasi {
        zzazc zzazc;
        int[] iArr;
        zzatc[] zzatcArr2 = zzatcArr;
        zzayt zzayt2 = zzayt;
        int[] iArr2 = new int[3];
        zzays[][] zzaysArr = new zzays[3][];
        int[][][] iArr3 = new int[3][][];
        for (int i = 0; i < 3; i++) {
            int i2 = zzayt2.zzb;
            zzaysArr[i] = new zzays[i2];
            iArr3[i] = new int[i2][];
        }
        int i3 = 2;
        int[] iArr4 = new int[2];
        for (int i4 = 0; i4 < 2; i4++) {
            zzatcArr2[i4].zze();
            iArr4[i4] = 4;
        }
        int i5 = 0;
        while (i5 < zzayt2.zzb) {
            zzays zzb2 = zzayt2.zzb(i5);
            int i6 = 0;
            int i7 = 0;
            int i8 = 2;
            while (true) {
                if (i6 >= i3) {
                    i6 = i8;
                    break;
                }
                zzatc zzatc = zzatcArr2[i6];
                int i9 = 0;
                while (true) {
                    int i10 = zzb2.zza;
                    if (i9 > 0) {
                        break;
                    }
                    int zzG = zzatc.zzG(zzb2.zzb(i9)) & 3;
                    if (zzG > i7) {
                        if (zzG == 3) {
                            break;
                        }
                        i8 = i6;
                        i7 = zzG;
                    }
                    i9++;
                }
                i6++;
                i3 = 2;
            }
            if (i6 == 2) {
                int i11 = zzb2.zza;
                iArr = new int[1];
            } else {
                zzatc zzatc2 = zzatcArr2[i6];
                int i12 = zzb2.zza;
                int[] iArr5 = new int[1];
                int i13 = 0;
                while (true) {
                    int i14 = zzb2.zza;
                    if (i13 > 0) {
                        break;
                    }
                    iArr5[i13] = zzatc2.zzG(zzb2.zzb(i13));
                    i13++;
                }
                iArr = iArr5;
            }
            int i15 = iArr2[i6];
            zzaysArr[i6][i15] = zzb2;
            iArr3[i6][i15] = iArr;
            iArr2[i6] = i15 + 1;
            i5++;
            i3 = 2;
        }
        zzayt[] zzaytArr = new zzayt[2];
        int[] iArr6 = new int[2];
        int i16 = 0;
        for (int i17 = 2; i16 < i17; i17 = 2) {
            int i18 = iArr2[i16];
            zzaytArr[i16] = new zzayt((zzays[]) Arrays.copyOf(zzaysArr[i16], i18));
            iArr3[i16] = (int[][]) Arrays.copyOf(iArr3[i16], i18);
            iArr6[i16] = zzatcArr2[i16].zzc();
            i16++;
        }
        zzayt zzayt3 = new zzayt((zzays[]) Arrays.copyOf(zzaysArr[2], iArr2[2]));
        zzayx[] zzb3 = zzb(zzatcArr2, zzaytArr, iArr3);
        int i19 = 0;
        for (int i20 = 2; i19 < i20; i20 = 2) {
            if (this.zzb.get(i19)) {
                zzb3[i19] = null;
            } else {
                zzayt zzayt4 = zzaytArr[i19];
                Map map = (Map) this.zza.get(i19);
                if (map == null) {
                    zzazc = null;
                } else {
                    zzazc = (zzazc) map.get(zzayt4);
                }
                if (zzazc != null) {
                    throw null;
                }
            }
            i19++;
        }
        zzazb zzazb = new zzazb(iArr6, zzaytArr, iArr4, iArr3, zzayt3);
        zzatd[] zzatdArr = new zzatd[2];
        for (int i21 = 0; i21 < 2; i21++) {
            zzatdArr[i21] = zzb3[i21] != null ? zzatd.zza : null;
        }
        return new zzazi(zzayt2, new zzazf(zzb3, (byte[]) null), zzazb, zzatdArr);
    }

    public final void zzd(Object obj) {
        this.zzc = (zzazb) obj;
    }

    public final void zze(int i, boolean z) {
        if (this.zzb.get(i) != z) {
            this.zzb.put(i, z);
            zzg();
        }
    }
}
