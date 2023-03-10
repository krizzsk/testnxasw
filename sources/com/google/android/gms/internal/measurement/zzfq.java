package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzfq extends zzkc implements zzlk {
    /* access modifiers changed from: private */
    public static final zzfq zza;
    private int zze;
    private int zzf;
    private long zzg;

    static {
        zzfq zzfq = new zzfq();
        zza = zzfq;
        zzkc.zzbM(zzfq.class, zzfq);
    }

    private zzfq() {
    }

    public static zzfp zzc() {
        return (zzfp) zza.zzbA();
    }

    static /* synthetic */ void zze(zzfq zzfq, int i) {
        zzfq.zze |= 1;
        zzfq.zzf = i;
    }

    static /* synthetic */ void zzf(zzfq zzfq, long j) {
        zzfq.zze |= 2;
        zzfq.zzg = j;
    }

    public final int zza() {
        return this.zzf;
    }

    public final long zzb() {
        return this.zzg;
    }

    public final boolean zzg() {
        return (this.zze & 2) != 0;
    }

    public final boolean zzh() {
        return (this.zze & 1) != 0;
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzbL(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဂ\u0001", new Object[]{"zze", "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzfq();
        } else {
            if (i2 == 4) {
                return new zzfp((zzfj) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }
}
