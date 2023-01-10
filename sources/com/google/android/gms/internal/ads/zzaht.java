package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzaht implements zzaip {
    private final zzahc zza;
    private final zzee zzb = new zzee(new byte[10], 10);
    private int zzc = 0;
    private int zzd;
    private zzel zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private int zzi;
    private int zzj;
    private boolean zzk;

    public zzaht(zzahc zzahc) {
        this.zza = zzahc;
    }

    private final void zzd(int i) {
        this.zzc = i;
        this.zzd = 0;
    }

    private final boolean zze(zzef zzef, byte[] bArr, int i) {
        int min = Math.min(zzef.zza(), i - this.zzd);
        if (min <= 0) {
            return true;
        }
        if (bArr == null) {
            zzef.zzG(min);
        } else {
            zzef.zzB(bArr, this.zzd, min);
        }
        int i2 = this.zzd + min;
        this.zzd = i2;
        if (i2 == i) {
            return true;
        }
        return false;
    }

    public final void zza(zzef zzef, int i) throws zzbu {
        long j;
        zzef zzef2 = zzef;
        zzdd.zzb(this.zze);
        int i2 = -1;
        int i3 = 2;
        if ((i & 1) != 0) {
            int i4 = this.zzc;
            if (!(i4 == 0 || i4 == 1)) {
                if (i4 != 2) {
                    int i5 = this.zzj;
                    if (i5 != -1) {
                        zzdw.zze("PesReader", "Unexpected start indicator: expected " + i5 + " more bytes");
                    }
                    this.zza.zzc();
                } else {
                    zzdw.zze("PesReader", "Unexpected start indicator reading extended header");
                }
            }
            zzd(1);
        }
        int i6 = i;
        while (zzef.zza() > 0) {
            int i7 = this.zzc;
            if (i7 != 0) {
                int i8 = 0;
                if (i7 != 1) {
                    if (i7 != i3) {
                        int zza2 = zzef.zza();
                        int i9 = this.zzj;
                        if (i9 != i2) {
                            i8 = zza2 - i9;
                        }
                        if (i8 > 0) {
                            zza2 -= i8;
                            zzef2.zzE(zzef.zzc() + zza2);
                        }
                        this.zza.zza(zzef2);
                        int i10 = this.zzj;
                        if (i10 != i2) {
                            int i11 = i10 - zza2;
                            this.zzj = i11;
                            if (i11 == 0) {
                                this.zza.zzc();
                                zzd(1);
                            }
                        }
                    } else {
                        if (zze(zzef2, this.zzb.zza, Math.min(10, this.zzi)) && zze(zzef2, (byte[]) null, this.zzi)) {
                            this.zzb.zzh(0);
                            if (this.zzf) {
                                this.zzb.zzj(4);
                                int zzc2 = this.zzb.zzc(3);
                                this.zzb.zzj(1);
                                int zzc3 = this.zzb.zzc(15);
                                this.zzb.zzj(1);
                                long zzc4 = ((long) (zzc3 << 15)) | (((long) zzc2) << 30) | ((long) this.zzb.zzc(15));
                                this.zzb.zzj(1);
                                if (!this.zzh && this.zzg) {
                                    this.zzb.zzj(4);
                                    int zzc5 = this.zzb.zzc(3);
                                    this.zzb.zzj(1);
                                    int zzc6 = this.zzb.zzc(15);
                                    this.zzb.zzj(1);
                                    int zzc7 = this.zzb.zzc(15);
                                    this.zzb.zzj(1);
                                    this.zze.zzb((((long) zzc5) << 30) | ((long) (zzc6 << 15)) | ((long) zzc7));
                                    this.zzh = true;
                                }
                                j = this.zze.zzb(zzc4);
                            } else {
                                j = -9223372036854775807L;
                            }
                            i6 |= true != this.zzk ? 0 : 4;
                            this.zza.zzd(j, i6);
                            zzd(3);
                            i2 = -1;
                        }
                    }
                } else if (zze(zzef2, this.zzb.zza, 9)) {
                    int i12 = 0;
                    this.zzb.zzh(0);
                    int zzc8 = this.zzb.zzc(24);
                    if (zzc8 != 1) {
                        zzdw.zze("PesReader", "Unexpected start code prefix: " + zzc8);
                        i2 = -1;
                        this.zzj = -1;
                    } else {
                        this.zzb.zzj(8);
                        int zzc9 = this.zzb.zzc(16);
                        this.zzb.zzj(5);
                        this.zzk = this.zzb.zzl();
                        this.zzb.zzj(2);
                        this.zzf = this.zzb.zzl();
                        this.zzg = this.zzb.zzl();
                        this.zzb.zzj(6);
                        int zzc10 = this.zzb.zzc(8);
                        this.zzi = zzc10;
                        if (zzc9 == 0) {
                            this.zzj = -1;
                        } else {
                            int i13 = (zzc9 - 3) - zzc10;
                            this.zzj = i13;
                            if (i13 < 0) {
                                zzdw.zze("PesReader", "Found negative packet payload size: " + i13);
                                i2 = -1;
                                this.zzj = -1;
                                i12 = 2;
                            }
                        }
                        i2 = -1;
                        i12 = 2;
                    }
                    zzd(i12);
                } else {
                    i2 = -1;
                }
            } else {
                zzef2.zzG(zzef.zza());
            }
            i3 = 2;
        }
    }

    public final void zzb(zzel zzel, zzzl zzzl, zzaio zzaio) {
        this.zze = zzel;
        this.zza.zzb(zzzl, zzaio);
    }

    public final void zzc() {
        this.zzc = 0;
        this.zzd = 0;
        this.zzh = false;
        this.zza.zze();
    }
}
