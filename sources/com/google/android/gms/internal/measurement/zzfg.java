package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzfg extends zzkc implements zzlk {
    /* access modifiers changed from: private */
    public static final zzfg zza;
    private int zze;
    private String zzf = "";
    private String zzg = "";

    static {
        zzfg zzfg = new zzfg();
        zza = zzfg;
        zzkc.zzbM(zzfg.class, zzfg);
    }

    private zzfg() {
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzbL(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zze", "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzfg();
        } else {
            if (i2 == 4) {
                return new zzff((zzey) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }
}
