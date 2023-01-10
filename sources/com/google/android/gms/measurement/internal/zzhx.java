package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.api.AppMeasurementSdk;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
final class zzhx implements Runnable {
    final /* synthetic */ Bundle zza;
    final /* synthetic */ zzin zzb;

    zzhx(zzin zzin, Bundle bundle) {
        this.zzb = zzin;
        this.zza = bundle;
    }

    public final void run() {
        zzin zzin = this.zzb;
        Bundle bundle = this.zza;
        zzin.zzg();
        zzin.zza();
        Preconditions.checkNotNull(bundle);
        String checkNotEmpty = Preconditions.checkNotEmpty(bundle.getString("name"));
        if (!zzin.zzs.zzJ()) {
            zzin.zzs.zzaz().zzj().zza("Conditional property not cleared since app measurement is disabled");
            return;
        }
        zzll zzll = new zzll(checkNotEmpty, 0, (Object) null, "");
        try {
            zzab zzab = r4;
            zzab zzab2 = new zzab(bundle.getString("app_id"), "", zzll, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), bundle.getBoolean("active"), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME), (zzav) null, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT), (zzav) null, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE), zzin.zzs.zzv().zzz(bundle.getString("app_id"), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS), "", bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), true, true));
            zzin.zzs.zzt().zzE(zzab);
        } catch (IllegalArgumentException unused) {
        }
    }
}
