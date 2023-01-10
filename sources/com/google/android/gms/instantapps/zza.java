package com.google.android.gms.instantapps;

import com.google.android.gms.common.Feature;

public final class zza {
    public static final Feature zze = new Feature("device_enabled_api", 1);
    public static final Feature zzf = new Feature("instant_app_removed_api", 1);
    public static final Feature zzg = new Feature("instant_app_installed_api", 1);
    public static final Feature zzh;
    private static final Feature[] zzi;

    static {
        Feature feature = new Feature("instant_app_uninstalled_api", 1);
        zzh = feature;
        zzi = new Feature[]{zze, zzf, zzg, feature};
    }
}
