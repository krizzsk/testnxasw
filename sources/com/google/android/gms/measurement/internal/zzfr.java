package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzcl;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzfr {
    private final zza zza;

    /* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
    public interface zza {
        void doStartService(Context context, Intent intent);
    }

    public zzfr(zza zza2) {
        Preconditions.checkNotNull(zza2);
        this.zza = zza2;
    }

    public final void zza(Context context, Intent intent) {
        zzgi zzp = zzgi.zzp(context, (zzcl) null, (Long) null);
        zzey zzaz = zzp.zzaz();
        if (intent == null) {
            zzaz.zzk().zza("Receiver called with null intent");
            return;
        }
        zzp.zzax();
        String action = intent.getAction();
        zzaz.zzj().zzb("Local receiver got", action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
            className.setAction("com.google.android.gms.measurement.UPLOAD");
            zzaz.zzj().zza("Starting wakeful intent.");
            this.zza.doStartService(context, className);
        } else if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
            zzaz.zzk().zza("Install Referrer Broadcasts are deprecated");
        }
    }
}
