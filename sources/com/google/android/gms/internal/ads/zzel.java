package com.google.android.gms.internal.ads;

import com.threatmetrix.TrustDefender.qqqqqy;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzel {
    private long zza;
    private long zzb;
    private long zzc;
    private final ThreadLocal zzd = new ThreadLocal();

    public zzel(long j) {
        zzf(0);
    }

    public final synchronized long zza(long j) {
        if (this.zzb == -9223372036854775807L) {
            long j2 = this.zza;
            if (j2 == 9223372036854775806L) {
                Long l = (Long) this.zzd.get();
                if (l != null) {
                    j2 = l.longValue();
                } else {
                    throw null;
                }
            }
            this.zzb = j2 - j;
            notifyAll();
        }
        this.zzc = j;
        return j + this.zzb;
    }

    public final synchronized long zzb(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long j2 = this.zzc;
        if (j2 != -9223372036854775807L) {
            long j3 = (j2 * 90000) / 1000000;
            long j4 = (4294967296L + j3) / qqqqqy.b00650065e006500650065;
            long j5 = ((-1 + j4) * qqqqqy.b00650065e006500650065) + j;
            j += j4 * qqqqqy.b00650065e006500650065;
            if (Math.abs(j5 - j3) < Math.abs(j - j3)) {
                j = j5;
            }
        }
        return zza((j * 1000000) / 90000);
    }

    public final synchronized long zzc() {
        long j = this.zza;
        if (j == Long.MAX_VALUE || j == 9223372036854775806L) {
            return -9223372036854775807L;
        }
        return j;
    }

    public final synchronized long zzd() {
        long j;
        j = this.zzc;
        return j != -9223372036854775807L ? j + this.zzb : zzc();
    }

    public final synchronized long zze() {
        return this.zzb;
    }

    public final synchronized void zzf(long j) {
        this.zza = j;
        this.zzb = j == Long.MAX_VALUE ? 0 : -9223372036854775807L;
        this.zzc = -9223372036854775807L;
    }
}
