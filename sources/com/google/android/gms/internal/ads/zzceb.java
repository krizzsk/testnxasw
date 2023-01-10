package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzceb extends zzcev {
    private final Clock zzb;
    private final zzceb zzc = this;
    private final zzgxv zzd;
    private final zzgxv zze;
    private final zzgxv zzf;
    private final zzgxv zzg;
    private final zzgxv zzh;
    private final zzgxv zzi;
    private final zzgxv zzj;
    private final zzgxv zzk;

    /* synthetic */ zzceb(Context context, Clock clock, zzg zzg2, zzceu zzceu, zzcea zzcea) {
        this.zzb = clock;
        this.zzd = zzgxj.zza(context);
        this.zze = zzgxj.zza(zzg2);
        zzgxi zza = zzgxj.zza(zzceu);
        this.zzf = zza;
        this.zzg = zzgxh.zzc(new zzcdt(this.zzd, this.zze, zza));
        zzgxi zza2 = zzgxj.zza(clock);
        this.zzh = zza2;
        zzgxv zzc2 = zzgxh.zzc(new zzcdv(zza2, this.zze, this.zzf));
        this.zzi = zzc2;
        zzcdx zzcdx = new zzcdx(this.zzh, zzc2);
        this.zzj = zzcdx;
        this.zzk = zzgxh.zzc(new zzcfa(this.zzd, zzcdx));
    }

    /* access modifiers changed from: package-private */
    public final zzcds zza() {
        return (zzcds) this.zzg.zzb();
    }

    /* access modifiers changed from: package-private */
    public final zzcdw zzb() {
        return new zzcdw(this.zzb, (zzcdu) this.zzi.zzb());
    }

    /* access modifiers changed from: package-private */
    public final zzcez zzc() {
        return (zzcez) this.zzk.zzb();
    }
}
