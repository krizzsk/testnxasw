package com.google.android.gms.internal.instantapps;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.instantapps.zza;
import javax.annotation.Nullable;

public final class zzaf extends GmsClient<zzu> {
    public final int getMinApkVersion() {
        return 12200000;
    }

    /* access modifiers changed from: protected */
    public final String getServiceDescriptor() {
        return "com.google.android.gms.instantapps.internal.IInstantAppsService";
    }

    /* access modifiers changed from: protected */
    public final String getStartServiceAction() {
        return "com.google.android.gms.instantapps.START";
    }

    public zzaf(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 121, ClientSettings.createDefault(context), connectionCallbacks, onConnectionFailedListener);
    }

    public final Feature[] getApiFeatures() {
        return new Feature[]{zza.zze, zza.zzf, zza.zzg, zza.zzh};
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.instantapps.internal.IInstantAppsService");
        if (queryLocalInterface instanceof zzu) {
            return (zzu) queryLocalInterface;
        }
        return new zzt(iBinder);
    }
}
