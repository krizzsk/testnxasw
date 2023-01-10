package com.google.android.gms.instantapps;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.internal.instantapps.zzaf;

final class zzd extends Api.AbstractClientBuilder<zzaf, Api.ApiOptions.NoOptions> {
    zzd() {
    }

    public final /* synthetic */ Api.Client buildClient(Context context, Looper looper, ClientSettings clientSettings, Object obj, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return new zzaf(context, looper, connectionCallbacks, onConnectionFailedListener);
    }
}
