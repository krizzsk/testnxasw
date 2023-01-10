package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Handler;
import android.os.StrictMode;
import androidx.collection.ArrayMap;
import com.didi.sdk.apm.SystemUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzhe implements zzhj {
    public static final String[] zza = {"key", "value"};
    private static final Map zzb = new ArrayMap();
    private final ContentResolver zzc;
    private final Uri zzd;
    private final ContentObserver zze = new zzhd(this, (Handler) null);
    private final Object zzf = new Object();
    private volatile Map zzg;
    private final List zzh = new ArrayList();

    private zzhe(ContentResolver contentResolver, Uri uri) {
        if (contentResolver == null) {
            throw null;
        } else if (uri != null) {
            this.zzc = contentResolver;
            this.zzd = uri;
            contentResolver.registerContentObserver(uri, false, this.zze);
        } else {
            throw null;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:2|3|(5:5|6|7|8|9)|11|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0018 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.measurement.zzhe zza(android.content.ContentResolver r3, android.net.Uri r4) {
        /*
            java.lang.Class<com.google.android.gms.internal.measurement.zzhe> r0 = com.google.android.gms.internal.measurement.zzhe.class
            monitor-enter(r0)
            java.util.Map r1 = zzb     // Catch:{ all -> 0x001a }
            java.lang.Object r1 = r1.get(r4)     // Catch:{ all -> 0x001a }
            com.google.android.gms.internal.measurement.zzhe r1 = (com.google.android.gms.internal.measurement.zzhe) r1     // Catch:{ all -> 0x001a }
            if (r1 != 0) goto L_0x0018
            com.google.android.gms.internal.measurement.zzhe r2 = new com.google.android.gms.internal.measurement.zzhe     // Catch:{ SecurityException -> 0x0018 }
            r2.<init>(r3, r4)     // Catch:{ SecurityException -> 0x0018 }
            java.util.Map r3 = zzb     // Catch:{ SecurityException -> 0x0017 }
            r3.put(r4, r2)     // Catch:{ SecurityException -> 0x0017 }
        L_0x0017:
            r1 = r2
        L_0x0018:
            monitor-exit(r0)     // Catch:{ all -> 0x001a }
            return r1
        L_0x001a:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001a }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzhe.zza(android.content.ContentResolver, android.net.Uri):com.google.android.gms.internal.measurement.zzhe");
    }

    static synchronized void zze() {
        synchronized (zzhe.class) {
            for (zzhe zzhe : zzb.values()) {
                zzhe.zzc.unregisterContentObserver(zzhe.zze);
            }
            zzb.clear();
        }
    }

    public final /* synthetic */ Object zzb(String str) {
        return (String) zzc().get(str);
    }

    /* JADX INFO: finally extract failed */
    public final Map zzc() {
        Map map;
        Map map2 = this.zzg;
        if (map2 == null) {
            synchronized (this.zzf) {
                map2 = this.zzg;
                if (map2 == null) {
                    StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        map = (Map) zzhh.zza(new zzhc(this));
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                    } catch (SQLiteException | IllegalStateException | SecurityException unused) {
                        try {
                            SystemUtils.log(6, "ConfigurationContentLoader", "PhenotypeFlag unable to load ContentProvider, using default values", (Throwable) null, "com.google.android.gms.internal.measurement.zzhe", 4);
                            StrictMode.setThreadPolicy(allowThreadDiskReads);
                            map = null;
                        } catch (Throwable th) {
                            StrictMode.setThreadPolicy(allowThreadDiskReads);
                            throw th;
                        }
                    }
                    this.zzg = map;
                    map2 = map;
                }
            }
        }
        if (map2 != null) {
            return map2;
        }
        return Collections.emptyMap();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Map zzd() {
        Map map;
        Cursor query = this.zzc.query(this.zzd, zza, (String) null, (String[]) null, (String) null);
        if (query == null) {
            return Collections.emptyMap();
        }
        try {
            int count = query.getCount();
            if (count == 0) {
                return Collections.emptyMap();
            }
            if (count <= 256) {
                map = new ArrayMap(count);
            } else {
                map = new HashMap(count, 1.0f);
            }
            while (query.moveToNext()) {
                map.put(query.getString(0), query.getString(1));
            }
            query.close();
            return map;
        } finally {
            query.close();
        }
    }

    public final void zzf() {
        synchronized (this.zzf) {
            this.zzg = null;
            zzhy.zzd();
        }
        synchronized (this) {
            for (zzhf zza2 : this.zzh) {
                zza2.zza();
            }
        }
    }
}
