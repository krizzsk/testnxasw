package com.google.android.gms.internal.auth;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.gms.auth.zze;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
final class zzi extends GmsClient<zzp> {
    zzi(Context context, Looper looper, ClientSettings clientSettings, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 224, clientSettings, connectionCallbacks, onConnectionFailedListener);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.account.data.IGoogleAuthService");
        if (queryLocalInterface instanceof zzp) {
            return (zzp) queryLocalInterface;
        }
        return new zzp(iBinder);
    }

    public final void disconnect(String str) {
        String valueOf = String.valueOf(str);
        SystemUtils.log(5, "GoogleAuthSvcClientImpl", valueOf.length() != 0 ? "GoogleAuthServiceClientImpl disconnected with reason: ".concat(valueOf) : new String("GoogleAuthServiceClientImpl disconnected with reason: "), (Throwable) null, "com.google.android.gms.internal.auth.zzi", 1);
        super.disconnect(str);
    }

    public final Feature[] getApiFeatures() {
        return new Feature[]{zze.zzf, zze.zzg, zze.zza};
    }

    public final int getMinApkVersion() {
        return 17895000;
    }

    /* access modifiers changed from: protected */
    public final String getServiceDescriptor() {
        return "com.google.android.gms.auth.account.data.IGoogleAuthService";
    }

    /* access modifiers changed from: protected */
    public final String getStartServiceAction() {
        return "com.google.android.gms.auth.account.authapi.START";
    }

    /* access modifiers changed from: protected */
    public final boolean getUseDynamicLookup() {
        return true;
    }

    public final boolean usesClientTelemetry() {
        return true;
    }
}
