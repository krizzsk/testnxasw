package com.google.android.gms.internal.instantapps;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.instantapps.InstantApps;

abstract class zzad<R extends Result> extends BaseImplementation.ApiMethodImpl<R, zzaf> {
    zzad(GoogleApiClient googleApiClient) {
        super((Api<?>) InstantApps.API, googleApiClient);
    }

    /* access modifiers changed from: protected */
    public abstract void zza(Context context, zzu zzu) throws RemoteException;

    /* access modifiers changed from: protected */
    public /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        zzaf zzaf = (zzaf) anyClient;
        zza(zzaf.getContext(), (zzu) zzaf.getService());
    }
}
