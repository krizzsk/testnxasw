package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzabw implements zzzi {
    private final zzef zza = new zzef(6);
    private zzzl zzb;
    private int zzc;
    private int zzd;
    private int zze;
    private long zzf = -1;
    private zzadt zzg;
    private zzzj zzh;
    private zzabz zzi;
    private zzafq zzj;

    private final int zze(zzzj zzzj) throws IOException {
        this.zza.zzC(2);
        ((zzyy) zzzj).zzm(this.zza.zzH(), 0, 2, false);
        return this.zza.zzo();
    }

    private final void zzf() {
        zzg(new zzbp[0]);
        zzzl zzzl = this.zzb;
        if (zzzl != null) {
            zzzl.zzC();
            this.zzb.zzN(new zzaak(-9223372036854775807L, 0));
            this.zzc = 6;
            return;
        }
        throw null;
    }

    public final int zza(zzzj zzzj, zzaai zzaai) throws IOException {
        String zzv;
        zzaby zza2;
        long j;
        zzzj zzzj2 = zzzj;
        zzaai zzaai2 = zzaai;
        int i = this.zzc;
        if (i == 0) {
            this.zza.zzC(2);
            ((zzyy) zzzj2).zzn(this.zza.zzH(), 0, 2, false);
            int zzo = this.zza.zzo();
            this.zzd = zzo;
            if (zzo == 65498) {
                if (this.zzf != -1) {
                    this.zzc = 4;
                } else {
                    zzf();
                }
            } else if ((zzo < 65488 || zzo > 65497) && zzo != 65281) {
                this.zzc = 1;
            }
            return 0;
        } else if (i != 1) {
            zzadt zzadt = null;
            if (i == 2) {
                if (this.zzd == 65505) {
                    zzef zzef = new zzef(this.zze);
                    ((zzyy) zzzj2).zzn(zzef.zzH(), 0, this.zze, false);
                    if (this.zzg == null && "http://ns.adobe.com/xap/1.0/".equals(zzef.zzv(0)) && (zzv = zzef.zzv(0)) != null) {
                        long zzd2 = zzzj.zzd();
                        if (!(zzd2 == -1 || (zza2 = zzacc.zza(zzv)) == null || zza2.zzb.size() < 2)) {
                            long j2 = -1;
                            long j3 = -1;
                            long j4 = -1;
                            long j5 = -1;
                            boolean z = false;
                            for (int size = zza2.zzb.size() - 1; size >= 0; size--) {
                                zzabx zzabx = (zzabx) zza2.zzb.get(size);
                                z |= "video/mp4".equals(zzabx.zza);
                                if (size == 0) {
                                    zzd2 -= zzabx.zzd;
                                    j = 0;
                                } else {
                                    j = zzd2 - zzabx.zzc;
                                }
                                long j6 = zzd2;
                                zzd2 = j;
                                long j7 = j6;
                                if (z && zzd2 != j7) {
                                    j5 = j7 - zzd2;
                                    j4 = zzd2;
                                    z = false;
                                }
                                if (size == 0) {
                                    j3 = j7;
                                }
                                if (size == 0) {
                                    j2 = zzd2;
                                }
                            }
                            zzadt = (j4 == -1 || j5 == -1 || j2 == -1 || j3 == -1) ? null : new zzadt(j2, j3, zza2.zza, j4, j5);
                        }
                        this.zzg = zzadt;
                        if (zzadt != null) {
                            this.zzf = zzadt.zzd;
                        }
                    }
                } else {
                    ((zzyy) zzzj2).zzo(this.zze, false);
                }
                this.zzc = 0;
                return 0;
            } else if (i == 4) {
                long zzf2 = zzzj.zzf();
                long j8 = this.zzf;
                if (zzf2 == j8) {
                    if (!zzzj2.zzm(this.zza.zzH(), 0, 1, true)) {
                        zzf();
                    } else {
                        zzzj.zzj();
                        if (this.zzj == null) {
                            this.zzj = new zzafq(0);
                        }
                        zzabz zzabz = new zzabz(zzzj2, this.zzf);
                        this.zzi = zzabz;
                        if (this.zzj.zzd(zzabz)) {
                            zzafq zzafq = this.zzj;
                            long j9 = this.zzf;
                            zzzl zzzl = this.zzb;
                            if (zzzl != null) {
                                zzafq.zzb(new zzacb(j9, zzzl));
                                zzbp[] zzbpArr = new zzbp[1];
                                zzadt zzadt2 = this.zzg;
                                if (zzadt2 != null) {
                                    zzbpArr[0] = zzadt2;
                                    zzg(zzbpArr);
                                    this.zzc = 5;
                                } else {
                                    throw null;
                                }
                            } else {
                                throw null;
                            }
                        } else {
                            zzf();
                        }
                    }
                    return 0;
                }
                zzaai2.zza = j8;
                return 1;
            } else if (i == 5) {
                if (this.zzi == null || zzzj2 != this.zzh) {
                    this.zzh = zzzj2;
                    this.zzi = new zzabz(zzzj2, this.zzf);
                }
                zzafq zzafq2 = this.zzj;
                if (zzafq2 != null) {
                    int zza3 = zzafq2.zza(this.zzi, zzaai2);
                    if (zza3 == 1) {
                        zzaai2.zza += this.zzf;
                    }
                    return zza3;
                }
                throw null;
            } else if (i == 6) {
                return -1;
            } else {
                throw new IllegalStateException();
            }
        } else {
            this.zza.zzC(2);
            ((zzyy) zzzj2).zzn(this.zza.zzH(), 0, 2, false);
            this.zze = this.zza.zzo() - 2;
            this.zzc = 2;
            return 0;
        }
    }

    public final void zzb(zzzl zzzl) {
        this.zzb = zzzl;
    }

    public final boolean zzd(zzzj zzzj) throws IOException {
        if (zze(zzzj) != 65496) {
            return false;
        }
        int zze2 = zze(zzzj);
        this.zzd = zze2;
        if (zze2 == 65504) {
            this.zza.zzC(2);
            zzyy zzyy = (zzyy) zzzj;
            zzyy.zzm(this.zza.zzH(), 0, 2, false);
            zzyy.zzl(this.zza.zzo() - 2, false);
            zze2 = zze(zzzj);
            this.zzd = zze2;
        }
        if (zze2 == 65505) {
            zzyy zzyy2 = (zzyy) zzzj;
            zzyy2.zzl(2, false);
            this.zza.zzC(6);
            zzyy2.zzm(this.zza.zzH(), 0, 6, false);
            if (this.zza.zzs() == 1165519206 && this.zza.zzo() == 0) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final void zzc(long j, long j2) {
        if (j == 0) {
            this.zzc = 0;
            this.zzj = null;
        } else if (this.zzc == 5) {
            zzafq zzafq = this.zzj;
            if (zzafq != null) {
                zzafq.zzc(j, j2);
                return;
            }
            throw null;
        }
    }

    private final void zzg(zzbp... zzbpArr) {
        zzzl zzzl = this.zzb;
        if (zzzl != null) {
            zzaap zzv = zzzl.zzv(1024, 4);
            zzad zzad = new zzad();
            zzad.zzz("image/jpeg");
            zzad.zzM(new zzbq(-9223372036854775807L, zzbpArr));
            zzv.zzk(zzad.zzY());
            return;
        }
        throw null;
    }
}
