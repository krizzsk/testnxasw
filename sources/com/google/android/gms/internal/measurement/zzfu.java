package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzfu extends zzkc implements zzlk {
    /* access modifiers changed from: private */
    public static final zzfu zza;
    private int zze;
    private String zzf = "";
    private long zzg;

    static {
        zzfu zzfu = new zzfu();
        zza = zzfu;
        zzkc.zzbM(zzfu.class, zzfu);
    }

    private zzfu() {
    }

    public static zzft zza() {
        return (zzft) zza.zzbA();
    }

    static /* synthetic */ void zzc(zzfu zzfu, String str) {
        str.getClass();
        zzfu.zze |= 1;
        zzfu.zzf = str;
    }

    static /* synthetic */ void zzd(zzfu zzfu, long j) {
        zzfu.zze |= 2;
        zzfu.zzg = j;
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzbL(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001", new Object[]{"zze", "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzfu();
        } else {
            if (i2 == 4) {
                return new zzft((zzfj) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }
}
