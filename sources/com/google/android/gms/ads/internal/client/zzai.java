package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbvk;
import com.google.firebase.analytics.FirebaseAnalytics;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
final class zzai extends zzav {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzq zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ zzbvk zzd;
    final /* synthetic */ zzau zze;

    zzai(zzau zzau, Context context, zzq zzq, String str, zzbvk zzbvk) {
        this.zze = zzau;
        this.zza = context;
        this.zzb = zzq;
        this.zzc = str;
        this.zzd = zzbvk;
    }

    public final /* synthetic */ Object zza() {
        zzau.zzs(this.zza, FirebaseAnalytics.Event.APP_OPEN);
        return new zzeq();
    }

    public final /* synthetic */ Object zzb(zzcc zzcc) throws RemoteException {
        return zzcc.zzc(ObjectWrapper.wrap(this.zza), this.zzb, this.zzc, this.zzd, 223104000);
    }

    public final /* synthetic */ Object zzc() throws RemoteException {
        return this.zze.zza.zza(this.zza, this.zzb, this.zzc, this.zzd, 4);
    }
}
