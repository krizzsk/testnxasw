package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzfc extends zzkc implements zzlk {
    /* access modifiers changed from: private */
    public static final zzfc zza;
    private int zze;
    private String zzf = "";
    private boolean zzg;
    private boolean zzh;
    private int zzi;

    static {
        zzfc zzfc = new zzfc();
        zza = zzfc;
        zzkc.zzbM(zzfc.class, zzfc);
    }

    private zzfc() {
    }

    static /* synthetic */ void zzd(zzfc zzfc, String str) {
        str.getClass();
        zzfc.zze |= 1;
        zzfc.zzf = str;
    }

    public final int zza() {
        return this.zzi;
    }

    public final String zzc() {
        return this.zzf;
    }

    public final boolean zze() {
        return this.zzg;
    }

    public final boolean zzf() {
        return this.zzh;
    }

    public final boolean zzg() {
        return (this.zze & 2) != 0;
    }

    public final boolean zzh() {
        return (this.zze & 4) != 0;
    }

    public final boolean zzi() {
        return (this.zze & 8) != 0;
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzbL(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004င\u0003", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
        } else if (i2 == 3) {
            return new zzfc();
        } else {
            if (i2 == 4) {
                return new zzfb((zzey) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }
}
