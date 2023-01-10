package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzfw extends zzkc implements zzlk {
    /* access modifiers changed from: private */
    public static final zzfw zza;
    private int zze;
    private String zzf = "";
    private String zzg = "";
    private long zzh;
    private float zzi;
    private double zzj;
    /* access modifiers changed from: private */
    public zzkj zzk = zzbG();

    static {
        zzfw zzfw = new zzfw();
        zza = zzfw;
        zzkc.zzbM(zzfw.class, zzfw);
    }

    private zzfw() {
    }

    public static zzfv zze() {
        return (zzfv) zza.zzbA();
    }

    static /* synthetic */ void zzj(zzfw zzfw, String str) {
        str.getClass();
        zzfw.zze |= 1;
        zzfw.zzf = str;
    }

    static /* synthetic */ void zzk(zzfw zzfw, String str) {
        str.getClass();
        zzfw.zze |= 2;
        zzfw.zzg = str;
    }

    static /* synthetic */ void zzm(zzfw zzfw) {
        zzfw.zze &= -3;
        zzfw.zzg = zza.zzg;
    }

    static /* synthetic */ void zzn(zzfw zzfw, long j) {
        zzfw.zze |= 4;
        zzfw.zzh = j;
    }

    static /* synthetic */ void zzo(zzfw zzfw) {
        zzfw.zze &= -5;
        zzfw.zzh = 0;
    }

    static /* synthetic */ void zzp(zzfw zzfw, double d) {
        zzfw.zze |= 16;
        zzfw.zzj = d;
    }

    static /* synthetic */ void zzq(zzfw zzfw) {
        zzfw.zze &= -17;
        zzfw.zzj = 0.0d;
    }

    static /* synthetic */ void zzr(zzfw zzfw, zzfw zzfw2) {
        zzfw2.getClass();
        zzfw.zzz();
        zzfw.zzk.add(zzfw2);
    }

    static /* synthetic */ void zzs(zzfw zzfw, Iterable iterable) {
        zzfw.zzz();
        zzil.zzbw(iterable, zzfw.zzk);
    }

    private final void zzz() {
        zzkj zzkj = this.zzk;
        if (!zzkj.zzc()) {
            this.zzk = zzkc.zzbH(zzkj);
        }
    }

    public final double zza() {
        return this.zzj;
    }

    public final float zzb() {
        return this.zzi;
    }

    public final int zzc() {
        return this.zzk.size();
    }

    public final long zzd() {
        return this.zzh;
    }

    public final String zzg() {
        return this.zzf;
    }

    public final String zzh() {
        return this.zzg;
    }

    public final List zzi() {
        return this.zzk;
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzbL(zza, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ခ\u0003\u0005က\u0004\u0006\u001b", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", zzfw.class});
        } else if (i2 == 3) {
            return new zzfw();
        } else {
            if (i2 == 4) {
                return new zzfv((zzfj) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }

    public final boolean zzu() {
        return (this.zze & 16) != 0;
    }

    public final boolean zzv() {
        return (this.zze & 8) != 0;
    }

    public final boolean zzw() {
        return (this.zze & 4) != 0;
    }

    public final boolean zzx() {
        return (this.zze & 1) != 0;
    }

    public final boolean zzy() {
        return (this.zze & 2) != 0;
    }
}
