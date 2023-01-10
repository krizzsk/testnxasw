package com.google.android.gms.internal.instantapps;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import com.didi.sdk.apm.SystemUtils;

public final class zzah {
    private static zzah zzbk;
    private final Context zzbl;

    private static synchronized void reset() {
        synchronized (zzah.class) {
            zzbk = null;
        }
    }

    public static synchronized zzah zzb(Context context) {
        zzah zzah;
        synchronized (zzah.class) {
            Context zza = zzo.zza(context);
            if (zzbk == null || zzbk.zzbl != zza) {
                zzah zzah2 = null;
                if (Build.VERSION.SDK_INT >= 21) {
                    if (zzav.zzg(zza)) {
                        ProviderInfo resolveContentProvider = zza.getPackageManager().resolveContentProvider(zzak.zzbq.getAuthority(), 0);
                        if (resolveContentProvider != null) {
                            if (!resolveContentProvider.packageName.equals("com.google.android.gms")) {
                                String str = resolveContentProvider.packageName;
                                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 85);
                                sb.append("Package ");
                                sb.append(str);
                                sb.append(" is invalid for instant apps content provider; instant apps will be disabled.");
                                SystemUtils.log(6, "IAMetadataClient", sb.toString(), (Throwable) null, "com.google.android.gms.internal.instantapps.zzah", 16);
                            } else {
                                zzah2 = new zzah(zza);
                            }
                        }
                    }
                }
                zzbk = zzah2;
            }
            zzah = zzbk;
        }
        return zzah;
    }

    private zzah(Context context) {
        this.zzbl = context;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final android.os.Bundle zza(java.lang.String r6, android.os.Bundle r7) throws android.os.RemoteException {
        /*
            r5 = this;
            long r0 = android.os.Binder.clearCallingIdentity()
            android.content.Context r2 = r5.zzbl     // Catch:{ IllegalArgumentException -> 0x002a, SecurityException -> 0x001f }
            android.content.ContentResolver r2 = r2.getContentResolver()     // Catch:{ IllegalArgumentException -> 0x002a, SecurityException -> 0x001f }
            android.net.Uri r3 = com.google.android.gms.internal.instantapps.zzak.zzbq     // Catch:{ IllegalArgumentException -> 0x002a, SecurityException -> 0x001f }
            r4 = 0
            android.os.Bundle r6 = r2.call(r3, r6, r4, r7)     // Catch:{ IllegalArgumentException -> 0x002a, SecurityException -> 0x001f }
            android.os.Binder.restoreCallingIdentity(r0)
            if (r6 == 0) goto L_0x0017
            return r6
        L_0x0017:
            android.os.RemoteException r6 = new android.os.RemoteException
            r6.<init>()
            throw r6
        L_0x001d:
            r6 = move-exception
            goto L_0x0035
        L_0x001f:
            reset()     // Catch:{ all -> 0x001d }
            android.os.RemoteException r6 = new android.os.RemoteException     // Catch:{ all -> 0x001d }
            java.lang.String r7 = "SecurityException: Content provider unavailable. Likely framework issue."
            r6.<init>(r7)     // Catch:{ all -> 0x001d }
            throw r6     // Catch:{ all -> 0x001d }
        L_0x002a:
            reset()     // Catch:{ all -> 0x001d }
            android.os.RemoteException r6 = new android.os.RemoteException     // Catch:{ all -> 0x001d }
            java.lang.String r7 = "IAE: Content provider unavailable. Likely GmsCore down."
            r6.<init>(r7)     // Catch:{ all -> 0x001d }
            throw r6     // Catch:{ all -> 0x001d }
        L_0x0035:
            android.os.Binder.restoreCallingIdentity(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.instantapps.zzah.zza(java.lang.String, android.os.Bundle):android.os.Bundle");
    }

    public final String zzb(int i) throws RemoteException {
        Bundle bundle = new Bundle();
        bundle.putInt("uid", i);
        return zza("getAppPackageForUid", bundle).getString("result");
    }

    public final int zza(String str) throws RemoteException {
        Bundle bundle = new Bundle();
        bundle.putString("packageName", str);
        return zza("getUidForPackage", bundle).getInt("result");
    }

    public final ApplicationInfo getApplicationInfo(String str, int i) throws RemoteException {
        Bundle bundle = new Bundle();
        bundle.putString("packageName", str);
        bundle.putInt("flags", i);
        return (ApplicationInfo) zza("getWHApplicationInfo", bundle).getParcelable("result");
    }

    public final PackageInfo getPackageInfo(String str, int i) throws RemoteException {
        Bundle bundle = new Bundle();
        bundle.putString("packageName", str);
        bundle.putInt("flags", i);
        return (PackageInfo) zza("getWHPackageInfo", bundle).getParcelable("result");
    }

    public final String zzb(String str) throws RemoteException {
        Bundle bundle = new Bundle();
        bundle.putString("packageName", str);
        return zza("getApplicationLabel", bundle).getString("result");
    }

    public final ComponentName zzc(String str) throws RemoteException {
        Bundle bundle = new Bundle();
        bundle.putString("shadowActivity", str);
        return (ComponentName) zza("getCallingActivity", bundle).getParcelable("result");
    }

    public final boolean isInstantApp(String str) throws RemoteException {
        Bundle bundle = new Bundle();
        bundle.putString("packageName", str);
        return zza("isInstantApp", bundle).getBoolean("result");
    }

    public final int getInstantAppCookieMaxSize() throws RemoteException {
        return zza("getInstantAppCookieMaxSize", new Bundle()).getInt("result");
    }

    public final boolean zza(int i, byte[] bArr) throws RemoteException {
        Bundle bundle = new Bundle();
        bundle.putInt("uid", i);
        bundle.putByteArray("cookie", bArr);
        return zza("setInstantAppCookie", bundle).getBoolean("result");
    }

    public final byte[] zzc(int i) throws RemoteException {
        Bundle bundle = new Bundle();
        bundle.putInt("uid", i);
        return zza("getInstantAppCookie", bundle).getByteArray("result");
    }
}
