package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.measurement.internal.zzfr;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class AppMeasurementReceiver extends WakefulBroadcastReceiver implements zzfr.zza {
    private zzfr zza;

    public BroadcastReceiver.PendingResult doGoAsync() {
        return goAsync();
    }

    public void doStartService(Context context, Intent intent) {
        startWakefulService(context, intent);
    }

    public void onReceive(Context context, Intent intent) {
        if (this.zza == null) {
            this.zza = new zzfr(this);
        }
        this.zza.zza(context, intent);
    }
}
