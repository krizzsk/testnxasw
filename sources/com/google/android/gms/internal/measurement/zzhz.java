package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import androidx.collection.ArrayMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzhz implements zzhj {
    private static final Map zza = new ArrayMap();
    private final SharedPreferences zzb;
    private final SharedPreferences.OnSharedPreferenceChangeListener zzc;

    static zzhz zza(Context context, String str) {
        zzhz zzhz;
        if (!zzha.zza()) {
            synchronized (zzhz.class) {
                zzhz = (zzhz) zza.get((Object) null);
                if (zzhz == null) {
                    StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        throw null;
                    } catch (Throwable th) {
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                        throw th;
                    }
                }
            }
            return zzhz;
        }
        throw null;
    }

    static synchronized void zzc() {
        synchronized (zzhz.class) {
            Iterator it = zza.values().iterator();
            if (!it.hasNext()) {
                zza.clear();
            } else {
                zzhz zzhz = (zzhz) it.next();
                SharedPreferences sharedPreferences = zzhz.zzb;
                SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = zzhz.zzc;
                throw null;
            }
        }
    }

    public final Object zzb(String str) {
        throw null;
    }
}
