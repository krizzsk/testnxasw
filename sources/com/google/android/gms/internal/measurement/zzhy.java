package com.google.android.gms.internal.measurement;

import android.content.Context;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public abstract class zzhy {
    public static final /* synthetic */ int zzc = 0;
    private static final Object zzd = new Object();
    @Nullable
    private static volatile zzhw zze = null;
    private static volatile boolean zzf = false;
    private static final AtomicReference zzg = new AtomicReference();
    private static final zzia zzh = new zzia(zzhp.zza, (byte[]) null);
    private static final AtomicInteger zzi = new AtomicInteger();
    final zzhv zza;
    final String zzb;
    private final Object zzj;
    private volatile int zzk = -1;
    private volatile Object zzl;
    private final boolean zzm;

    /* synthetic */ zzhy(zzhv zzhv, String str, Object obj, boolean z, zzhx zzhx) {
        if (zzhv.zzb != null) {
            this.zza = zzhv;
            this.zzb = str;
            this.zzj = obj;
            this.zzm = true;
            return;
        }
        throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
    }

    static void zzd() {
        zzi.incrementAndGet();
    }

    public static void zze(Context context) {
        if (zze == null) {
            synchronized (zzd) {
                if (zze == null) {
                    synchronized (zzd) {
                        zzhw zzhw = zze;
                        Context applicationContext = context.getApplicationContext();
                        if (applicationContext != null) {
                            context = applicationContext;
                        }
                        if (zzhw == null || zzhw.zza() != context) {
                            zzhe.zze();
                            zzhz.zzc();
                            zzhm.zze();
                            zze = new zzhb(context, zzij.zza(new zzhq(context)));
                            zzi.incrementAndGet();
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public abstract Object zza(Object obj);

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00f6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object zzb() {
        /*
            r10 = this;
            boolean r0 = r10.zzm
            if (r0 != 0) goto L_0x0011
            java.lang.String r0 = r10.zzb
            if (r0 == 0) goto L_0x0009
            goto L_0x0011
        L_0x0009:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "flagName must not be null"
            r0.<init>(r1)
            throw r0
        L_0x0011:
            java.util.concurrent.atomic.AtomicInteger r0 = zzi
            int r0 = r0.get()
            int r1 = r10.zzk
            if (r1 >= r0) goto L_0x0123
            monitor-enter(r10)
            int r1 = r10.zzk     // Catch:{ all -> 0x0120 }
            if (r1 >= r0) goto L_0x011e
            com.google.android.gms.internal.measurement.zzhw r1 = zze     // Catch:{ all -> 0x0120 }
            java.lang.String r2 = "Must call PhenotypeFlag.init() first"
            if (r1 == 0) goto L_0x0118
            com.google.android.gms.internal.measurement.zzhv r2 = r10.zza     // Catch:{ all -> 0x0120 }
            boolean r3 = r2.zzf     // Catch:{ all -> 0x0120 }
            boolean r2 = r2.zzg     // Catch:{ all -> 0x0120 }
            r3 = 0
            if (r2 != 0) goto L_0x006e
            android.content.Context r2 = r1.zza()     // Catch:{ all -> 0x0120 }
            com.google.android.gms.internal.measurement.zzhm r2 = com.google.android.gms.internal.measurement.zzhm.zza(r2)     // Catch:{ all -> 0x0120 }
            java.lang.String r4 = "gms:phenotype:phenotype_flag:debug_bypass_phenotype"
            java.lang.String r2 = r2.zzb(r4)     // Catch:{ all -> 0x0120 }
            if (r2 == 0) goto L_0x006e
            java.util.regex.Pattern r4 = com.google.android.gms.internal.measurement.zzgz.zzc     // Catch:{ all -> 0x0120 }
            java.util.regex.Matcher r2 = r4.matcher(r2)     // Catch:{ all -> 0x0120 }
            boolean r2 = r2.matches()     // Catch:{ all -> 0x0120 }
            if (r2 == 0) goto L_0x006e
            java.lang.String r2 = "PhenotypeFlag"
            r4 = 3
            boolean r2 = android.util.Log.isLoggable(r2, r4)     // Catch:{ all -> 0x0120 }
            if (r2 == 0) goto L_0x00b6
            java.lang.String r5 = "PhenotypeFlag"
            java.lang.String r2 = "Bypass reading Phenotype values for flag: "
            java.lang.String r4 = r10.zzc()     // Catch:{ all -> 0x0120 }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x0120 }
            java.lang.String r6 = r2.concat(r4)     // Catch:{ all -> 0x0120 }
            r4 = 3
            r7 = 0
            java.lang.String r8 = "com.google.android.gms.internal.measurement.zzhy"
            r9 = 17
            com.didi.sdk.apm.SystemUtils.log(r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0120 }
            goto L_0x00b6
        L_0x006e:
            com.google.android.gms.internal.measurement.zzhv r2 = r10.zza     // Catch:{ all -> 0x0120 }
            android.net.Uri r2 = r2.zzb     // Catch:{ all -> 0x0120 }
            if (r2 == 0) goto L_0x0099
            android.content.Context r2 = r1.zza()     // Catch:{ all -> 0x0120 }
            com.google.android.gms.internal.measurement.zzhv r4 = r10.zza     // Catch:{ all -> 0x0120 }
            android.net.Uri r4 = r4.zzb     // Catch:{ all -> 0x0120 }
            boolean r2 = com.google.android.gms.internal.measurement.zzhn.zza(r2, r4)     // Catch:{ all -> 0x0120 }
            if (r2 == 0) goto L_0x0097
            com.google.android.gms.internal.measurement.zzhv r2 = r10.zza     // Catch:{ all -> 0x0120 }
            boolean r2 = r2.zzh     // Catch:{ all -> 0x0120 }
            android.content.Context r2 = r1.zza()     // Catch:{ all -> 0x0120 }
            android.content.ContentResolver r2 = r2.getContentResolver()     // Catch:{ all -> 0x0120 }
            com.google.android.gms.internal.measurement.zzhv r4 = r10.zza     // Catch:{ all -> 0x0120 }
            android.net.Uri r4 = r4.zzb     // Catch:{ all -> 0x0120 }
            com.google.android.gms.internal.measurement.zzhe r2 = com.google.android.gms.internal.measurement.zzhe.zza(r2, r4)     // Catch:{ all -> 0x0120 }
            goto L_0x00a5
        L_0x0097:
            r2 = r3
            goto L_0x00a5
        L_0x0099:
            android.content.Context r2 = r1.zza()     // Catch:{ all -> 0x0120 }
            com.google.android.gms.internal.measurement.zzhv r4 = r10.zza     // Catch:{ all -> 0x0120 }
            java.lang.String r4 = r4.zza     // Catch:{ all -> 0x0120 }
            com.google.android.gms.internal.measurement.zzhz r2 = com.google.android.gms.internal.measurement.zzhz.zza(r2, r3)     // Catch:{ all -> 0x0120 }
        L_0x00a5:
            if (r2 == 0) goto L_0x00b6
            java.lang.String r4 = r10.zzc()     // Catch:{ all -> 0x0120 }
            java.lang.Object r2 = r2.zzb(r4)     // Catch:{ all -> 0x0120 }
            if (r2 == 0) goto L_0x00b6
            java.lang.Object r2 = r10.zza(r2)     // Catch:{ all -> 0x0120 }
            goto L_0x00b7
        L_0x00b6:
            r2 = r3
        L_0x00b7:
            if (r2 == 0) goto L_0x00ba
            goto L_0x00e6
        L_0x00ba:
            com.google.android.gms.internal.measurement.zzhv r2 = r10.zza     // Catch:{ all -> 0x0120 }
            boolean r4 = r2.zze     // Catch:{ all -> 0x0120 }
            if (r4 != 0) goto L_0x00e1
            com.google.android.gms.internal.measurement.zzic r2 = r2.zzi     // Catch:{ all -> 0x0120 }
            android.content.Context r2 = r1.zza()     // Catch:{ all -> 0x0120 }
            com.google.android.gms.internal.measurement.zzhm r2 = com.google.android.gms.internal.measurement.zzhm.zza(r2)     // Catch:{ all -> 0x0120 }
            com.google.android.gms.internal.measurement.zzhv r4 = r10.zza     // Catch:{ all -> 0x0120 }
            boolean r5 = r4.zze     // Catch:{ all -> 0x0120 }
            if (r5 == 0) goto L_0x00d2
            r4 = r3
            goto L_0x00d6
        L_0x00d2:
            java.lang.String r4 = r4.zzc     // Catch:{ all -> 0x0120 }
            java.lang.String r4 = r10.zzb     // Catch:{ all -> 0x0120 }
        L_0x00d6:
            java.lang.String r2 = r2.zzb(r4)     // Catch:{ all -> 0x0120 }
            if (r2 == 0) goto L_0x00e1
            java.lang.Object r2 = r10.zza(r2)     // Catch:{ all -> 0x0120 }
            goto L_0x00e2
        L_0x00e1:
            r2 = r3
        L_0x00e2:
            if (r2 != 0) goto L_0x00e6
            java.lang.Object r2 = r10.zzj     // Catch:{ all -> 0x0120 }
        L_0x00e6:
            com.google.android.gms.internal.measurement.zzif r1 = r1.zzb()     // Catch:{ all -> 0x0120 }
            java.lang.Object r1 = r1.zza()     // Catch:{ all -> 0x0120 }
            com.google.android.gms.internal.measurement.zzid r1 = (com.google.android.gms.internal.measurement.zzid) r1     // Catch:{ all -> 0x0120 }
            boolean r4 = r1.zzb()     // Catch:{ all -> 0x0120 }
            if (r4 == 0) goto L_0x0113
            java.lang.Object r1 = r1.zza()     // Catch:{ all -> 0x0120 }
            com.google.android.gms.internal.measurement.zzhg r1 = (com.google.android.gms.internal.measurement.zzhg) r1     // Catch:{ all -> 0x0120 }
            com.google.android.gms.internal.measurement.zzhv r2 = r10.zza     // Catch:{ all -> 0x0120 }
            android.net.Uri r4 = r2.zzb     // Catch:{ all -> 0x0120 }
            java.lang.String r5 = r2.zza     // Catch:{ all -> 0x0120 }
            java.lang.String r2 = r2.zzd     // Catch:{ all -> 0x0120 }
            java.lang.String r5 = r10.zzb     // Catch:{ all -> 0x0120 }
            java.lang.String r1 = r1.zza(r4, r3, r2, r5)     // Catch:{ all -> 0x0120 }
            if (r1 != 0) goto L_0x010f
            java.lang.Object r2 = r10.zzj     // Catch:{ all -> 0x0120 }
            goto L_0x0113
        L_0x010f:
            java.lang.Object r2 = r10.zza(r1)     // Catch:{ all -> 0x0120 }
        L_0x0113:
            r10.zzl = r2     // Catch:{ all -> 0x0120 }
            r10.zzk = r0     // Catch:{ all -> 0x0120 }
            goto L_0x011e
        L_0x0118:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0120 }
            r0.<init>(r2)     // Catch:{ all -> 0x0120 }
            throw r0     // Catch:{ all -> 0x0120 }
        L_0x011e:
            monitor-exit(r10)     // Catch:{ all -> 0x0120 }
            goto L_0x0123
        L_0x0120:
            r0 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x0120 }
            throw r0
        L_0x0123:
            java.lang.Object r0 = r10.zzl
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzhy.zzb():java.lang.Object");
    }

    public final String zzc() {
        String str = this.zza.zzd;
        return this.zzb;
    }
}
