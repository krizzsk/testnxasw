package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzci;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@20.1.2 */
final class zzo implements zzhj {
    public final zzci zza;
    final /* synthetic */ AppMeasurementDynamiteService zzb;

    zzo(AppMeasurementDynamiteService appMeasurementDynamiteService, zzci zzci) {
        this.zzb = appMeasurementDynamiteService;
        this.zza = zzci;
    }

    public final void onEvent(String str, String str2, Bundle bundle, long j) {
        try {
            this.zza.zze(str, str2, bundle, j);
        } catch (RemoteException e) {
            zzgi zzgi = this.zzb.zza;
            if (zzgi != null) {
                zzgi.zzaz().zzk().zzb("Event listener threw exception", e);
            }
        }
    }
}
