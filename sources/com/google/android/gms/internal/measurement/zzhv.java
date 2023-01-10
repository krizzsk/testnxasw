package com.google.android.gms.internal.measurement;

import android.net.Uri;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzhv {
    final String zza;
    final Uri zzb;
    final String zzc;
    final String zzd;
    final boolean zze;
    final boolean zzf;
    final boolean zzg;
    final boolean zzh;
    @Nullable
    final zzic zzi;

    public zzhv(Uri uri) {
        this((String) null, uri, "", "", false, false, false, false, (zzic) null);
    }

    private zzhv(String str, Uri uri, String str2, String str3, boolean z, boolean z2, boolean z3, boolean z4, @Nullable zzic zzic) {
        this.zza = null;
        this.zzb = uri;
        this.zzc = "";
        this.zzd = "";
        this.zze = z;
        this.zzf = false;
        this.zzg = z3;
        this.zzh = false;
        this.zzi = null;
    }

    public final zzhv zza() {
        return new zzhv((String) null, this.zzb, this.zzc, this.zzd, this.zze, false, true, false, (zzic) null);
    }

    public final zzhv zzb() {
        if (this.zzc.isEmpty()) {
            return new zzhv((String) null, this.zzb, this.zzc, this.zzd, true, false, this.zzg, false, (zzic) null);
        }
        throw new IllegalStateException("Cannot set GServices prefix and skip GServices");
    }

    public final zzhy zzc(String str, double d) {
        return new zzht(this, "measurement.test.double_flag", Double.valueOf(-3.0d), true);
    }

    public final zzhy zzd(String str, long j) {
        return new zzhr(this, str, Long.valueOf(j), true);
    }

    public final zzhy zze(String str, String str2) {
        return new zzhu(this, str, str2, true);
    }

    public final zzhy zzf(String str, boolean z) {
        return new zzhs(this, str, Boolean.valueOf(z), true);
    }
}
