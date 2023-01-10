package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzfa extends zzkc implements zzlk {
    /* access modifiers changed from: private */
    public static final zzfa zza;
    private int zze;
    private String zzf = "";
    private zzkj zzg = zzbG();
    private boolean zzh;

    static {
        zzfa zzfa = new zzfa();
        zza = zzfa;
        zzkc.zzbM(zzfa.class, zzfa);
    }

    private zzfa() {
    }

    public final String zzb() {
        return this.zzf;
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzbL(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b\u0003ဇ\u0001", new Object[]{"zze", "zzf", "zzg", zzfg.class, "zzh"});
        } else if (i2 == 3) {
            return new zzfa();
        } else {
            if (i2 == 4) {
                return new zzez((zzey) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }
}
