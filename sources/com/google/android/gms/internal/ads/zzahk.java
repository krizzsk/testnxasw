package com.google.android.gms.internal.ads;

import android.util.SparseArray;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzahk {
    private final zzaap zza;
    private final SparseArray zzb = new SparseArray();
    private final SparseArray zzc = new SparseArray();
    private final zzaah zzd;
    private final byte[] zze;
    private int zzf;
    private long zzg;
    private long zzh;
    private final zzahj zzi = new zzahj((zzahi) null);
    private final zzahj zzj = new zzahj((zzahi) null);
    private boolean zzk;
    private long zzl;
    private long zzm;
    private boolean zzn;

    public zzahk(zzaap zzaap, boolean z, boolean z2) {
        this.zza = zzaap;
        byte[] bArr = new byte[128];
        this.zze = bArr;
        this.zzd = new zzaah(bArr, 0, 0);
        this.zzk = false;
    }

    public final void zza(zzaad zzaad) {
        this.zzc.append(zzaad.zza, zzaad);
    }

    public final void zzb(zzaae zzaae) {
        this.zzb.append(zzaae.zzd, zzaae);
    }

    public final void zzc() {
        this.zzk = false;
    }

    public final void zzd(long j, int i, long j2) {
        this.zzf = i;
        this.zzh = j2;
        this.zzg = j;
    }

    public final boolean zze(long j, int i, boolean z, boolean z2) {
        boolean z3 = false;
        if (this.zzf == 9) {
            if (z && this.zzk) {
                long j2 = this.zzg;
                int i2 = i + ((int) (j - j2));
                long j3 = this.zzm;
                if (j3 != -9223372036854775807L) {
                    boolean z4 = this.zzn;
                    long j4 = this.zzl;
                    this.zza.zzs(j3, z4 ? 1 : 0, (int) (j2 - j4), i2, (zzaao) null);
                }
            }
            this.zzl = this.zzg;
            this.zzm = this.zzh;
            this.zzn = false;
            this.zzk = true;
        }
        boolean z5 = this.zzn;
        int i3 = this.zzf;
        if (i3 == 5 || (z2 && i3 == 1)) {
            z3 = true;
        }
        boolean z6 = z5 | z3;
        this.zzn = z6;
        return z6;
    }
}
