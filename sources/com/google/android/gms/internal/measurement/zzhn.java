package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.Build;
import com.didi.sdk.apm.SystemUtils;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzhn {
    static volatile zzid zza = zzid.zzc();
    private static final Object zzb = new Object();

    public static boolean zza(Context context, Uri uri) {
        String authority = uri.getAuthority();
        boolean z = false;
        if (!"com.google.android.gms.phenotype".equals(authority)) {
            SystemUtils.log(6, "PhenotypeClientHelper", String.valueOf(authority).concat(" is an unsupported authority. Only com.google.android.gms.phenotype authority is supported."), (Throwable) null, "com.google.android.gms.internal.measurement.zzhn", 3);
            return false;
        } else if (zza.zzb()) {
            return ((Boolean) zza.zza()).booleanValue();
        } else {
            synchronized (zzb) {
                if (zza.zzb()) {
                    boolean booleanValue = ((Boolean) zza.zza()).booleanValue();
                    return booleanValue;
                }
                if (!"com.google.android.gms".equals(context.getPackageName())) {
                    ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.phenotype", Build.VERSION.SDK_INT < 29 ? 0 : 268435456);
                    if (resolveContentProvider != null) {
                        if (!"com.google.android.gms".equals(resolveContentProvider.packageName)) {
                        }
                    }
                    zza = zzid.zzd(Boolean.valueOf(z));
                    return ((Boolean) zza.zza()).booleanValue();
                }
                try {
                    if ((SystemUtils.getApplicationInfo(context.getPackageManager(), "com.google.android.gms", 0).flags & 129) != 0) {
                        z = true;
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                }
                zza = zzid.zzd(Boolean.valueOf(z));
                return ((Boolean) zza.zza()).booleanValue();
            }
        }
    }
}
