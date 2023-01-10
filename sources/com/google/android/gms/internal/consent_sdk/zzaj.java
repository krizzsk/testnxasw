package com.google.android.gms.internal.consent_sdk;

import android.app.Application;

/* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
public final class zzaj extends zzd {
    /* access modifiers changed from: private */
    public final zzaj zza = this;
    /* access modifiers changed from: private */
    public final zzcl<Application> zzb;
    /* access modifiers changed from: private */
    public final zzcl<zzam> zzc;
    /* access modifiers changed from: private */
    public final zzcl<zzac> zzd;
    private final zzcl<zzas> zze;
    private final zzcl<zzba> zzf;
    private final zzcl<zzb> zzg;
    private final zzcl<zzn> zzh;
    /* access modifiers changed from: private */
    public final zzcl<zzh> zzi;
    /* access modifiers changed from: private */
    public final zzcl<zzak> zzj;
    private final zzcl<zzz> zzk;
    private final zzcl<zzv> zzl;
    private final zzcl<zzk> zzm;

    /* synthetic */ zzaj(Application application, zzaf zzaf) {
        zzch zza2 = zzci.zza(application);
        this.zzb = zza2;
        this.zzc = zzcg.zza(new zzan(zza2));
        this.zzd = zzcg.zza(zzad.zza);
        zzaf zzaf2 = new zzaf(this);
        this.zze = zzaf2;
        this.zzf = zzcg.zza(new zzbb(zzaf2));
        zzc zzc2 = new zzc(this.zzb);
        this.zzg = zzc2;
        this.zzh = new zzp(this.zzb, zzc2, this.zzc);
        this.zzi = zzcg.zza(new zzi(zzaq.zza));
        zzal zzal = new zzal(this.zzb, this.zzc, zzaq.zza);
        this.zzj = zzal;
        this.zzk = new zzab(this.zzi, zzal, this.zzc);
        zzw zzw = new zzw(this.zzb, this.zzd, zzao.zza, zzaq.zza, this.zzc, this.zzf, this.zzh, this.zzk, this.zzi);
        this.zzl = zzw;
        this.zzm = zzcg.zza(new zzl(this.zzc, zzw, this.zzf));
    }

    public final zzk zzb() {
        return this.zzm.zzb();
    }

    public final zzba zzc() {
        return this.zzf.zzb();
    }
}
