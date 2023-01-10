package com.google.android.gms.measurement.internal;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.didi.sdk.apm.SystemUtils;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzfe extends zzkw {
    public zzfe(zzli zzli) {
        super(zzli);
    }

    public final boolean zza() {
        zzW();
        ConnectivityManager connectivityManager = (ConnectivityManager) this.zzs.zzav().getSystemService("connectivity");
        NetworkInfo networkInfo = null;
        if (connectivityManager != null) {
            try {
                networkInfo = SystemUtils.getActiveNetworkInfo(connectivityManager);
            } catch (SecurityException unused) {
            }
        }
        return networkInfo != null && networkInfo.isConnected();
    }

    /* access modifiers changed from: protected */
    public final boolean zzb() {
        return false;
    }
}
