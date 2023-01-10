package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzfy extends zzkc implements zzlk {
    /* access modifiers changed from: private */
    public static final zzfy zza;
    private int zze;
    private String zzf = "";
    private String zzg = "";
    private zzfm zzh;

    static {
        zzfy zzfy = new zzfy();
        zza = zzfy;
        zzkc.zzbM(zzfy.class, zzfy);
    }

    private zzfy() {
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzbL(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဉ\u0002", new Object[]{"zze", "zzf", "zzg", "zzh"});
        } else if (i2 == 3) {
            return new zzfy();
        } else {
            if (i2 == 4) {
                return new zzfx((zzfj) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }
}
