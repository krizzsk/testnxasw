package com.google.android.gms.internal.ads;

import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzuz extends zzvn implements Comparable {
    private final int zze;
    private final boolean zzf;
    private final String zzg = zzvr.zzf(this.zzd.zzd);
    private final zzvf zzh;
    private final boolean zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final boolean zzm;
    private final int zzn;
    private final int zzo;
    private final boolean zzp;
    private final int zzq;
    private final int zzr;
    private final int zzs;
    private final int zzt;
    private final boolean zzu;
    private final boolean zzv;

    public zzuz(int i, zzcp zzcp, int i2, zzvf zzvf, int i3, boolean z, zzfsy zzfsy) {
        super(i, zzcp, i2);
        int i4;
        int i5;
        int i6;
        boolean z2;
        this.zzh = zzvf;
        int i7 = 0;
        this.zzi = zzvr.zzm(i3, false);
        int i8 = 0;
        while (true) {
            i4 = Integer.MAX_VALUE;
            if (i8 >= zzvf.zzq.size()) {
                i8 = Integer.MAX_VALUE;
                i5 = 0;
                break;
            }
            i5 = zzvr.zza(this.zzd, (String) zzvf.zzq.get(i8), false);
            if (i5 > 0) {
                break;
            }
            i8++;
        }
        this.zzk = i8;
        this.zzj = i5;
        int i9 = this.zzd.zzf;
        int i10 = zzvf.zzr;
        this.zzl = Integer.bitCount(0);
        zzaf zzaf = this.zzd;
        int i11 = zzaf.zzf;
        this.zzm = true;
        this.zzp = 1 == (zzaf.zze & 1);
        this.zzq = zzaf.zzz;
        this.zzr = zzaf.zzA;
        this.zzs = zzaf.zzi;
        if (zzaf.zzi != -1) {
            int i12 = zzvf.zzt;
        }
        if (zzaf.zzz != -1) {
            int i13 = zzvf.zzs;
        }
        this.zzf = zzfsy.zza(zzaf);
        String[] zzaf2 = zzen.zzaf();
        int i14 = 0;
        while (true) {
            if (i14 >= zzaf2.length) {
                i14 = Integer.MAX_VALUE;
                i6 = 0;
                break;
            }
            i6 = zzvr.zza(this.zzd, zzaf2[i14], false);
            if (i6 > 0) {
                break;
            }
            i14++;
        }
        this.zzn = i14;
        this.zzo = i6;
        int i15 = 0;
        while (true) {
            if (i15 < zzvf.zzu.size()) {
                String str = this.zzd.zzm;
                if (str != null && str.equals(zzvf.zzu.get(i15))) {
                    i4 = i15;
                    break;
                }
                i15++;
            } else {
                break;
            }
        }
        this.zzt = i4;
        this.zzu = (i3 & 128) == 128;
        this.zzv = (i3 & 64) == 64;
        zzvf zzvf2 = this.zzh;
        if (zzvr.zzm(i3, zzvf2.zzQ) && ((z2 = this.zzf) || zzvf2.zzK)) {
            if (zzvr.zzm(i3, false) && z2 && this.zzd.zzi != -1) {
                boolean z3 = zzvf2.zzA;
                boolean z4 = zzvf2.zzz;
                if (zzvf2.zzS || !z) {
                    i7 = 2;
                }
            }
            i7 = 1;
        }
        this.zze = i7;
    }

    public final int zzb() {
        return this.zze;
    }

    public final /* synthetic */ boolean zzc(zzvn zzvn) {
        zzuz zzuz = (zzuz) zzvn;
        zzvf zzvf = this.zzh;
        boolean z = zzvf.zzN;
        zzaf zzaf = this.zzd;
        int i = zzaf.zzz;
        if (i == -1) {
            return false;
        }
        zzaf zzaf2 = zzuz.zzd;
        if (i != zzaf2.zzz) {
            return false;
        }
        boolean z2 = zzvf.zzL;
        String str = zzaf.zzm;
        if (str == null || !TextUtils.equals(str, zzaf2.zzm)) {
            return false;
        }
        zzvf zzvf2 = this.zzh;
        boolean z3 = zzvf2.zzM;
        int i2 = this.zzd.zzA;
        if (i2 == -1 || i2 != zzuz.zzd.zzA) {
            return false;
        }
        boolean z4 = zzvf2.zzO;
        return this.zzu == zzuz.zzu && this.zzv == zzuz.zzv;
    }

    /* renamed from: zza */
    public final int compareTo(zzuz zzuz) {
        zzfwv zzfwv;
        if (!this.zzf || !this.zzi) {
            zzfwv = zzvr.zzc.zza();
        } else {
            zzfwv = zzvr.zzc;
        }
        zzfvc zzd = zzfvc.zzj().zzd(this.zzi, zzuz.zzi).zzc(Integer.valueOf(this.zzk), Integer.valueOf(zzuz.zzk), zzfwv.zzc().zza()).zzb(this.zzj, zzuz.zzj).zzb(this.zzl, zzuz.zzl).zzd(this.zzp, zzuz.zzp);
        boolean z = zzuz.zzm;
        zzfvc zzc = zzd.zzd(true, true).zzc(Integer.valueOf(this.zzn), Integer.valueOf(zzuz.zzn), zzfwv.zzc().zza()).zzb(this.zzo, zzuz.zzo).zzd(this.zzf, zzuz.zzf).zzc(Integer.valueOf(this.zzt), Integer.valueOf(zzuz.zzt), zzfwv.zzc().zza());
        Integer valueOf = Integer.valueOf(this.zzs);
        Integer valueOf2 = Integer.valueOf(zzuz.zzs);
        boolean z2 = this.zzh.zzz;
        zzfvc zzc2 = zzc.zzc(valueOf, valueOf2, zzvr.zzd).zzd(this.zzu, zzuz.zzu).zzd(this.zzv, zzuz.zzv).zzc(Integer.valueOf(this.zzq), Integer.valueOf(zzuz.zzq), zzfwv).zzc(Integer.valueOf(this.zzr), Integer.valueOf(zzuz.zzr), zzfwv);
        Integer valueOf3 = Integer.valueOf(this.zzs);
        Integer valueOf4 = Integer.valueOf(zzuz.zzs);
        if (!zzen.zzT(this.zzg, zzuz.zzg)) {
            zzfwv = zzvr.zzd;
        }
        return zzc2.zzc(valueOf3, valueOf4, zzfwv).zza();
    }
}
