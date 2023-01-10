package com.google.android.gms.internal.instantapps;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import android.os.RemoteException;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.gms.instantapps.PackageManagerCompat;

public final class zzao implements PackageManagerCompat {
    private static zzao zzbw;
    private final Context zzbl;
    private final boolean zzbx = true;

    public static synchronized zzao zza(Context context, boolean z) {
        zzao zzao;
        synchronized (zzao.class) {
            Context zza = zzo.zza(context);
            if (!(zzbw != null && zzbw.zzbl == zza && zzbw.zzbx)) {
                zzbw = new zzao(zza, true);
            }
            zzao = zzbw;
        }
        return zzao;
    }

    private zzao(Context context, boolean z) {
        this.zzbl = context;
    }

    public final String[] getPackagesForUid(int i) {
        String[] packagesForUid;
        if (this.zzbx && (packagesForUid = this.zzbl.getPackageManager().getPackagesForUid(i)) != null) {
            return packagesForUid;
        }
        zzah zzb = zzah.zzb(this.zzbl);
        if (zzb != null) {
            try {
                String zzb2 = zzb.zzb(i);
                if (zzb2 == null) {
                    return null;
                }
                return new String[]{zzb2};
            } catch (RemoteException e) {
                SystemUtils.log(6, "InstantAppsPMW", "Error getting app package for UID", e, "com.google.android.gms.internal.instantapps.zzao", 20);
            }
        }
        return null;
    }

    public final PackageInfo getPackageInfo(String str, int i) throws PackageManager.NameNotFoundException {
        if (this.zzbx) {
            try {
                return SystemUtils.getPackageInfo(this.zzbl.getPackageManager(), str, i);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        zzah zzb = zzah.zzb(this.zzbl);
        if (zzb != null) {
            try {
                PackageInfo packageInfo = zzb.getPackageInfo(str, i);
                if (packageInfo != null) {
                    return packageInfo;
                }
            } catch (RemoteException e) {
                SystemUtils.log(6, "InstantAppsPMW", "Error getting package info", e, "com.google.android.gms.internal.instantapps.zzao", 33);
            }
        }
        throw new PackageManager.NameNotFoundException();
    }

    public final ApplicationInfo getApplicationInfo(String str, int i) throws PackageManager.NameNotFoundException {
        if (this.zzbx) {
            try {
                return SystemUtils.getApplicationInfo(this.zzbl.getPackageManager(), str, i);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        zzah zzb = zzah.zzb(this.zzbl);
        if (zzb != null) {
            try {
                ApplicationInfo applicationInfo = zzb.getApplicationInfo(str, i);
                if (applicationInfo != null) {
                    return applicationInfo;
                }
            } catch (RemoteException e) {
                SystemUtils.log(6, "InstantAppsPMW", "Error getting application info", e, "com.google.android.gms.internal.instantapps.zzao", 45);
            }
        }
        throw new PackageManager.NameNotFoundException();
    }

    public final CharSequence getApplicationLabel(ApplicationInfo applicationInfo) {
        if (this.zzbx && this.zzbl.getPackageManager().getPackagesForUid(applicationInfo.uid) != null) {
            return this.zzbl.getPackageManager().getApplicationLabel(applicationInfo);
        }
        zzah zzb = zzah.zzb(this.zzbl);
        if (zzb == null) {
            return null;
        }
        try {
            return zzb.zzb(applicationInfo.packageName);
        } catch (RemoteException e) {
            SystemUtils.log(6, "InstantAppsPMW", "Error getting application label", e, "com.google.android.gms.internal.instantapps.zzao", 54);
            return null;
        }
    }

    public final String getInstallerPackageName(String str) {
        IllegalArgumentException e;
        if (this.zzbx) {
            try {
                return this.zzbl.getPackageManager().getInstallerPackageName(str);
            } catch (IllegalArgumentException e2) {
                e = e2;
            }
        } else {
            e = null;
            zzah zzb = zzah.zzb(this.zzbl);
            if (zzb != null) {
                try {
                    if (zzb.zza(str) != 0) {
                        return "com.android.vending";
                    }
                } catch (RemoteException e3) {
                    SystemUtils.log(6, "InstantAppsPMW", "Error getting UID for app package", e3, "com.google.android.gms.internal.instantapps.zzao", 67);
                }
            }
            if (e == null) {
                e = new IllegalArgumentException();
            }
            throw e;
        }
    }

    public final boolean isInstantApp() {
        return isInstantApp(this.zzbl.getPackageName());
    }

    public final boolean isInstantApp(String str) {
        zzah zzb = zzah.zzb(this.zzbl);
        if (zzb == null) {
            return false;
        }
        try {
            return zzb.isInstantApp(str);
        } catch (RemoteException e) {
            SystemUtils.log(6, "InstantAppsPMW", "Error checking if app is instant app", e, "com.google.android.gms.internal.instantapps.zzao", 74);
            return false;
        }
    }

    public final int getInstantAppCookieMaxSize() {
        zzah zzb = zzah.zzb(this.zzbl);
        if (zzb == null) {
            return 0;
        }
        try {
            return zzb.getInstantAppCookieMaxSize();
        } catch (RemoteException e) {
            SystemUtils.log(6, "InstantAppsPMW", "Error fetching max cookie size", e, "com.google.android.gms.internal.instantapps.zzao", 80);
            return 0;
        }
    }

    public final boolean setInstantAppCookie(byte[] bArr) {
        zzah zzb = zzah.zzb(this.zzbl);
        if (zzb == null) {
            return false;
        }
        try {
            return zzb.zza(Process.myUid(), bArr);
        } catch (RemoteException e) {
            SystemUtils.log(6, "InstantAppsPMW", "Error setting cookie", e, "com.google.android.gms.internal.instantapps.zzao", 86);
            return false;
        }
    }

    public final byte[] getInstantAppCookie() {
        zzah zzb = zzah.zzb(this.zzbl);
        if (zzb == null) {
            return null;
        }
        try {
            return zzb.zzc(Process.myUid());
        } catch (RemoteException e) {
            SystemUtils.log(6, "InstantAppsPMW", "Error setting cookie", e, "com.google.android.gms.internal.instantapps.zzao", 92);
            return null;
        }
    }
}
