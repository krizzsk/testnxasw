package com.google.android.gms.internal.ads;

import com.google.common.primitives.SignedBytes;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzagv implements zzahc {
    private final zzee zza;
    private final zzef zzb;
    private final String zzc;
    private String zzd;
    private zzaap zze;
    private int zzf;
    private int zzg;
    private boolean zzh;
    private long zzi;
    private zzaf zzj;
    private int zzk;
    private long zzl;

    public zzagv() {
        this((String) null);
    }

    public final void zza(zzef zzef) {
        int zzk2;
        byte b;
        zzdd.zzb(this.zze);
        while (zzef.zza() > 0) {
            int i = this.zzf;
            if (i == 0) {
                while (true) {
                    if (zzef.zza() <= 0) {
                        break;
                    } else if (!this.zzh) {
                        this.zzh = zzef.zzk() == 172;
                    } else {
                        zzk2 = zzef.zzk();
                        this.zzh = zzk2 == 172;
                        b = SignedBytes.MAX_POWER_OF_TWO;
                        if (zzk2 == 64) {
                            break;
                        } else if (zzk2 == 65) {
                            zzk2 = 65;
                            break;
                        }
                    }
                }
                this.zzf = 1;
                zzef zzef2 = this.zzb;
                zzef2.zzH()[0] = -84;
                byte[] zzH = zzef2.zzH();
                if (zzk2 == 65) {
                    b = 65;
                }
                zzH[1] = b;
                this.zzg = 2;
            } else if (i != 1) {
                int min = Math.min(zzef.zza(), this.zzk - this.zzg);
                this.zze.zzq(zzef, min);
                int i2 = this.zzg + min;
                this.zzg = i2;
                int i3 = this.zzk;
                if (i2 == i3) {
                    long j = this.zzl;
                    if (j != -9223372036854775807L) {
                        this.zze.zzs(j, 1, i3, 0, (zzaao) null);
                        this.zzl += this.zzi;
                    }
                    this.zzf = 0;
                }
            } else {
                byte[] zzH2 = this.zzb.zzH();
                int min2 = Math.min(zzef.zza(), 16 - this.zzg);
                zzef.zzB(zzH2, this.zzg, min2);
                int i4 = this.zzg + min2;
                this.zzg = i4;
                if (i4 == 16) {
                    this.zza.zzh(0);
                    zzyl zza2 = zzym.zza(this.zza);
                    zzaf zzaf = this.zzj;
                    if (zzaf == null || zzaf.zzz != 2 || zza2.zza != zzaf.zzA || !"audio/ac4".equals(zzaf.zzm)) {
                        zzad zzad = new zzad();
                        zzad.zzH(this.zzd);
                        zzad.zzS("audio/ac4");
                        zzad.zzw(2);
                        zzad.zzT(zza2.zza);
                        zzad.zzK(this.zzc);
                        zzaf zzY = zzad.zzY();
                        this.zzj = zzY;
                        this.zze.zzk(zzY);
                    }
                    this.zzk = zza2.zzb;
                    this.zzi = (((long) zza2.zzc) * 1000000) / ((long) this.zzj.zzA);
                    this.zzb.zzF(0);
                    this.zze.zzq(this.zzb, 16);
                    this.zzf = 2;
                }
            }
        }
    }

    public final void zzb(zzzl zzzl, zzaio zzaio) {
        zzaio.zzc();
        this.zzd = zzaio.zzb();
        this.zze = zzzl.zzv(zzaio.zza(), 1);
    }

    public final void zzc() {
    }

    public final void zzd(long j, int i) {
        if (j != -9223372036854775807L) {
            this.zzl = j;
        }
    }

    public final void zze() {
        this.zzf = 0;
        this.zzg = 0;
        this.zzh = false;
        this.zzl = -9223372036854775807L;
    }

    public zzagv(String str) {
        zzee zzee = new zzee(new byte[16], 16);
        this.zza = zzee;
        this.zzb = new zzef(zzee.zza);
        this.zzf = 0;
        this.zzg = 0;
        this.zzh = false;
        this.zzl = -9223372036854775807L;
        this.zzc = str;
    }
}
