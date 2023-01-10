package com.google.android.gms.internal.instantapps;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.instantapps.LaunchData;
import com.google.android.gms.instantapps.zze;
import com.google.android.gms.instantapps.zzk;

final class zzx extends zzad<zze> {
    private final /* synthetic */ String zzbd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzx(zzy zzy, GoogleApiClient googleApiClient, String str) {
        super(googleApiClient);
        this.zzbd = str;
    }

    /* access modifiers changed from: protected */
    public final void zza(Context context, zzu zzu) throws RemoteException {
        zzu.zza(new zzaa(this), this.zzbd, new zzk());
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Result createFailedResult(Status status) {
        return new zzag(status, (LaunchData) null);
    }
}
