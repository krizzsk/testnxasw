package com.google.android.gms.internal.instantapps;

import java.io.IOException;

final class zzfo extends zzfm<zzfp, zzfp> {
    zzfo() {
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(zzev zzev) {
        return false;
    }

    private static void zza(Object obj, zzfp zzfp) {
        ((zzcx) obj).zzapc = zzfp;
    }

    /* access modifiers changed from: package-private */
    public final void zzc(Object obj) {
        ((zzcx) obj).zzapc.zzs();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ int zzm(Object obj) {
        return ((zzfp) obj).zzbz();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ int zzs(Object obj) {
        return ((zzfp) obj).zzec();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzg(Object obj, Object obj2) {
        zzfp zzfp = (zzfp) obj;
        zzfp zzfp2 = (zzfp) obj2;
        if (zzfp2.equals(zzfp.zzea())) {
            return zzfp;
        }
        return zzfp.zza(zzfp, zzfp2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(Object obj, zzgi zzgi) throws IOException {
        ((zzfp) obj).zza(zzgi);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, zzgi zzgi) throws IOException {
        ((zzfp) obj).zzb(zzgi);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzf(Object obj, Object obj2) {
        zza(obj, (zzfp) obj2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzr(Object obj) {
        zzfp zzfp = ((zzcx) obj).zzapc;
        if (zzfp != zzfp.zzea()) {
            return zzfp;
        }
        zzfp zzeb = zzfp.zzeb();
        zza(obj, zzeb);
        return zzeb;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzq(Object obj) {
        return ((zzcx) obj).zzapc;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zze(Object obj, Object obj2) {
        zza(obj, (zzfp) obj2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzi(Object obj) {
        zzfp zzfp = (zzfp) obj;
        zzfp.zzs();
        return zzfp;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzdz() {
        return zzfp.zzeb();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, int i, Object obj2) {
        ((zzfp) obj).zzb((i << 3) | 3, (zzfp) obj2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, int i, zzbp zzbp) {
        ((zzfp) obj).zzb((i << 3) | 2, zzbp);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(Object obj, int i, long j) {
        ((zzfp) obj).zzb((i << 3) | 1, Long.valueOf(j));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(Object obj, int i, int i2) {
        ((zzfp) obj).zzb((i << 3) | 5, Integer.valueOf(i2));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, int i, long j) {
        ((zzfp) obj).zzb(i << 3, Long.valueOf(j));
    }
}
