package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgt {
    public final String zza;
    public final zzaf zzb;
    public final zzaf zzc;
    public final int zzd;
    public final int zze;

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0022  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0016  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzgt(java.lang.String r3, com.google.android.gms.internal.ads.zzaf r4, com.google.android.gms.internal.ads.zzaf r5, int r6, int r7) {
        /*
            r2 = this;
            r2.<init>()
            r0 = 0
            r1 = 1
            if (r6 == 0) goto L_0x000a
            if (r7 != 0) goto L_0x000b
            r7 = 0
        L_0x000a:
            r0 = 1
        L_0x000b:
            com.google.android.gms.internal.ads.zzdd.zzd(r0)
            com.google.android.gms.internal.ads.zzdd.zzc(r3)
            r2.zza = r3
            r3 = 0
            if (r4 == 0) goto L_0x0022
            r2.zzb = r4
            if (r5 == 0) goto L_0x0021
            r2.zzc = r5
            r2.zzd = r6
            r2.zze = r7
            return
        L_0x0021:
            throw r3
        L_0x0022:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgt.<init>(java.lang.String, com.google.android.gms.internal.ads.zzaf, com.google.android.gms.internal.ads.zzaf, int, int):void");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzgt zzgt = (zzgt) obj;
            return this.zzd == zzgt.zzd && this.zze == zzgt.zze && this.zza.equals(zzgt.zza) && this.zzb.equals(zzgt.zzb) && this.zzc.equals(zzgt.zzc);
        }
    }

    public final int hashCode() {
        return ((((((((this.zzd + 527) * 31) + this.zze) * 31) + this.zza.hashCode()) * 31) + this.zzb.hashCode()) * 31) + this.zzc.hashCode();
    }
}
